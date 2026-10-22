package com.ss.ttvideoengine.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.database.KVDBManager;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class Downloader {
    private static final int MESSAGE_COMPLETE = 3;
    private static final int MESSAGE_FAIL = 1;
    private static final int MESSAGE_LOADTASKS = 4;
    private static final int MESSAGE_OPEN_DB_FAIL = 5;
    private static final int MESSAGE_PROGRESS = 0;
    private static final int MESSAGE_SUSPEND = 2;
    private static final long MIN_FREE_SIZE = 1073741824;
    public static final int OptionIsPerfGetCacheInfo = 1;
    private static final int PRIVATE_MESSAGE_LOADALLTASK = 10;
    private static final int PRIVATE_MESSAGE_SAVETASK = 11;
    private static final String TAG = "TTVideoEngine.Downloader";
    private static final String dataBaseName = "TTVideoEngine_download_database_v01";
    private static final Downloader ourInstance = null;
    private static final String tasksIndex = "TTVideoEngine_download_index_v01";
    private ArrayList<DownloadTask> allTasks;
    private KVDBManager dbObject;
    private ArrayList<Long> indexArray;
    private long limitFreeDiskSize;
    private IDownloaderListener listener;
    private boolean loadData;
    private Context mContext;
    private Handler mHandler;
    private long mPerfGetCacheInfo;
    private long maxDownloadOperationCount;
    private long maxTaskId;
    private boolean readAllTask;
    private ArrayList<DownloadTask> runingTasks;
    private TaskThread taskThread;
    private ArrayList<DownloadTask> temLoadedTasks;
    private ArrayList<DownloadTask> waitingTasks;

    public class SaveInfos {
        ArrayList<DownloadTask> alltasks;
        DownloadTask task;
        final /* synthetic */ Downloader this$0;

        private SaveInfos(Downloader r100) {
            this.this$0 = r100;
            this.task = null;
            this.alltasks = null;
        }

        public /* synthetic */ SaveInfos(Downloader r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class TaskThread {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        public TaskThread() {
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("vcloud.engine.download.tasks");     // Catch: Throwable -> L5
            this.mHandlerThread = r100;     // Catch: Throwable -> L5
            ThreadMethodProxy.start(r100);     // Catch: Throwable -> L5
            final Looper r101 = this.mHandlerThread.getLooper();     // Catch: Throwable -> L5
            this.mHandler = new AnonymousClass1(this, r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            TTVideoEngineLog.d(th);
            this.mHandlerThread = null;
            this.mHandler = null;
        }

        public void postMessage(ArrayList<Object> r100, int r101) {
            if (this.mHandler != null) goto L5;
            return;
        L5:
            if (this.mHandlerThread == null) goto L9;
            Message r102 = Message.obtain();
            r102.what = r101;
            r102.obj = r100;
            this.mHandler.sendMessage(r102);
            return;
        }
    }

    static {
        ourInstance = new Downloader();
    }

    private ArrayList<DownloadTask> _loadAllTasks() {
        String r100 = "base_json";
        ArrayList<DownloadTask> r101 = new ArrayList();
        String r102 = this.mContext.getSharedPreferences(tasksIndex, 0).getString("index", "");     // Catch: Throwable -> L105
        ArrayList<String> r103 = stringToStringArray(r102);     // Catch: Throwable -> L105
        String r104 = this.dbObject.get("index");     // Catch: Throwable -> L105
        ArrayList<String> r105 = stringToStringArray(r104);     // Catch: Throwable -> L105
        if (r103 != null) goto L8;
        if (r105 != null) goto L8;
        return r101;
    L8:
        if (r102 != null) goto L10;
    L11:
        TTVideoEngineLog.e(TAG, "[downloader] index maybe save fail.");     // Catch: Throwable -> L105
        if (r103 == null) goto L15;
        if (r105 != null) goto L15;
    L21:
        TTVideoEngineLog.d(TAG, "[downloader] index array:" + r103.toString());     // Catch: Throwable -> L105
        int r106 = 0;
    L23:
        if (r106 >= r103.size()) goto L107;
        DownloadTask r107 = null;
        String r108 = r103.get(r106);     // Catch: Throwable -> L95
        JSONObject r110 = new JSONObject(this.dbObject.get(r108));     // Catch: Throwable -> L95
        if (r110.optJSONObject(r100) == null) goto L33;
        String r109 = r110.optJSONObject(r100).optString(AiProactiveTaskViewModel.PARAM_TASK_TYPE);     // Catch: Throwable -> L95
        if (r109.equals("url_task") == false) goto L31;
        r107 = DownloadURLTask.taskItem();     // Catch: Throwable -> L95
        goto L33
    L31:
        if (r109.equals("vid_task") == false) goto L33;
        r107 = DownloadVidTask.taskItem();     // Catch: Throwable -> L95
    L33:
        if (r107 != null) goto L38;
        TTVideoEngineLog.e(TAG, "[downloader] load task fail. taskIdentifier = " + r108);     // Catch: Throwable -> L95
        if (r107 == null) goto L37;
        r101.add(r107);     // Catch: Throwable -> L105
        r107.setDownloader(this);     // Catch: Throwable -> L105
    L37:
        String r111 = r100;
        int r112 = r106;
    L99:
        r106 = r112 + 1;
        r100 = r111;
        goto L23
    L38:
        r107.assignWithJson(r110);     // Catch: Throwable -> L95
        ArrayList<String> r113 = r107.mediaKeys;     // Catch: Throwable -> L95
        long r114 = 0;
        if (r113 != null) goto L41;
    L56:
        r111 = r100;
        r112 = r106;
        long r115 = 0;
        long r116 = 0;
    L57:
        r107.bytesExpectedToReceive = r115;     // Catch: Throwable -> L93
        r107.bytesReceived = r116;     // Catch: Throwable -> L93
        if (r107.getState() != 5) goto L70;
        long r117 = r107.bytesReceived;     // Catch: Throwable -> L93
        if (r117 > 0) goto L66;
        if (r107.bytesExpectedToReceive > 0) goto L66;
        r107.setState(0);     // Catch: Throwable -> L93
    L66:
        if (r117 != r107.bytesExpectedToReceive) goto L68;
        r107.setState(5);     // Catch: Throwable -> L93
        goto L70
    L68:
        r107.setState(3);     // Catch: Throwable -> L93
    L70:
        if (r107.canceled == false) goto L75;
        if (r107.error == null) goto L75;
        r107.setState(5);     // Catch: Throwable -> L93
    L75:
        if (r107.getState() != 2) goto L78;
        r107.setState(3);     // Catch: Throwable -> L93
    L78:
        if (r107.getState() != 1) goto L87;
        if (r107.bytesReceived <= 0) goto L108;
        r107.setState(3);     // Catch: Throwable -> L93
        goto L87
    L108:
        r107.setState(0);     // Catch: Throwable -> L91
    L91:
        th = th;
    L110:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        if (r107 == null) goto L125;
        r101.add(r107);     // Catch: Throwable -> L105
        r107.setDownloader(this);     // Catch: Throwable -> L105
        throw th;     // Catch: Throwable -> L105
    L125:
        throw th;     // Catch: Throwable -> L105
    L87:
        if (r107.getState() != 4) goto L89;
        TTVideoEngineLog.e(TAG, "[downloader] task state invalid. is canceling");     // Catch: Throwable -> L91
        r107.setState(3);     // Catch: Throwable -> L91
    L89:
        r101.add(r107);     // Catch: Throwable -> L105
        r107.setDownloader(this);     // Catch: Throwable -> L105
        goto L99
    L41:
        if (r113.size() <= 0) goto L56;
        r115 = 0;
        r116 = 0;
        int r118 = 0;
    L44:
        if (r118 >= r107.mediaKeys.size()) goto L55;
        String r119 = r107.mediaKeys.get(r118);     // Catch: Throwable -> L95
        if (this.mPerfGetCacheInfo <= r114) goto L48;
        DataLoaderHelper.DataLoaderCacheInfo r120 = DataLoaderHelper.getDataLoader().getOfflineCacheInfo(r119, r107.getCustomDir());     // Catch: Throwable -> L95
    L49:
        if (r120 != null) goto L51;
        r111 = r100;
        r112 = r106;
    L54:
        r118 = r118 + 1;     // Catch: Throwable -> L93
        r100 = r111;
        r106 = r112;
        r114 = 0;
        goto L44
    L51:
        r111 = r100;
        r112 = r106;
        r115 = r115 + Math.max(r120.mMediaSize, 0);     // Catch: Throwable -> L93
        r116 = r116 + Math.max(r120.mCacheSizeFromZero, 0);     // Catch: Throwable -> L93
    L93:
        th = th;
        goto L110
    L48:
        r120 = DataLoaderHelper.getDataLoader().getCacheInfo(r119);     // Catch: Throwable -> L95
        goto L49
    L55:
        r111 = r100;
        r112 = r106;
    L95:
        th = th;
        r111 = r100;
        r112 = r106;
    L107:
        return r101;
    L15:
        if (r103 != null) goto L19;
        if (r105 == null) goto L19;
    L20:
        r103 = r105;
    L19:
        if (r105.size() <= r103.size()) goto L21;
    L10:
        if (r102.equals(r104) == true) goto L21;
    L105:
        th = move-exception;
        TTVideoEngineLog.d(th);
        goto L107
    }

    private void initHandle() {
        if (this.mHandler == null) goto L5;
        return;
    L5:
        final Looper r100 = TTHelper.getLooper();
        this.mHandler = new AnonymousClass1(this, r100, this);
    }

    public void invalidateAndCancelAllTasks() {
        ArrayList<DownloadTask> r100 = this.allTasks;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<DownloadTask> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        DownloadTask r102 = r101.next();
        if (r102 == null) goto L7;
        r102.invalidateAndCancel();
        goto L7
    }

    public void resumeAllTasks() {
        ArrayList<DownloadTask> r100 = this.allTasks;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<DownloadTask> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L15;
        DownloadTask r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.getState() == 3) goto L14;
        if (r102.getState() != 0) goto L7;
    L14:
        r102.resume();
        goto L7
    }

    public void suspendAllTasks() {
        ArrayList<DownloadTask> r100 = this.allTasks;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<DownloadTask> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        DownloadTask r102 = r101.next();
        if (r102 == null) goto L7;
        r102.suspend();
        goto L7
    }

    private Downloader() {
        this.listener = null;
        this.maxDownloadOperationCount = 0;
        this.limitFreeDiskSize = 1073741824;
        this.maxTaskId = 0;
        this.allTasks = null;
        this.waitingTasks = null;
        this.runingTasks = null;
        this.temLoadedTasks = null;
        this.indexArray = null;
        this.readAllTask = false;
        this.loadData = false;
        this.mHandler = null;
        this.mContext = null;
        this.dbObject = null;
        this.taskThread = new TaskThread();
        this.mPerfGetCacheInfo = 0;
        this.maxTaskId = -1;
        this.allTasks = new ArrayList();
        this.indexArray = new ArrayList();
        this.waitingTasks = new ArrayList();
        this.runingTasks = new ArrayList();
        this.maxDownloadOperationCount = 1;
        this.limitFreeDiskSize = 1073741824;
        this.readAllTask = false;
    }

    public static Downloader getInstance() {
        return ourInstance;
    }

    public long getLimitFreeDiskSize() {
        return this.limitFreeDiskSize;
    }

    public IDownloaderListener getListener() {
        return this.listener;
    }

    public long getMaxDownloadOperationCount() {
        return this.maxDownloadOperationCount;
    }

    public static /* synthetic */ KVDBManager access$1000(Downloader r100) {
        return r100.dbObject;
    }

    public static /* synthetic */ Handler access$1100(Downloader r100) {
        return r100.mHandler;
    }

    public static /* synthetic */ ArrayList access$1200(Downloader r100) {
        return r100._loadAllTasks();
    }

    public static /* synthetic */ IDownloaderListener access$200(Downloader r100) {
        return r100.listener;
    }

    public static /* synthetic */ Context access$300(Downloader r100) {
        return r100.mContext;
    }

    public static /* synthetic */ ArrayList access$500(Downloader r100) {
        return r100.temLoadedTasks;
    }

    public static /* synthetic */ ArrayList access$700(Downloader r100) {
        return r100.indexArray;
    }

    public static /* synthetic */ ArrayList access$800(Downloader r100) {
        return r100.allTasks;
    }

    private DownloadTask addTask(DownloadTask r100) {
        r100.setDownloader(this);
    L20:
        th = move-exception;
        DownloadTask r101 = r100;
        Throwable th10 = th;
    L25:
        TTVideoEngineLog.d(th10);     // Catch: Throwable -> L24
    L23:
        return r101;
    L5:
        if (this.readAllTask == true) goto L7;
        TTVideoEngineLog.e(TAG, "[downloader] should load all tasks first.");     // Catch: Throwable -> L20
        return null;
    L7:
        if (this.allTasks.contains(r100) == false) goto L13;
        r101 = this.allTasks.get(this.allTasks.indexOf(r100));     // Catch: Throwable -> L20
        r101.setDownloader(this);     // Catch: Throwable -> L11
        return r101;
    L11:
        th10 = th;
        goto L25
    L13:
        long r102 = this.maxTaskId + 1;     // Catch: Throwable -> L20
        this.maxTaskId = r102;     // Catch: Throwable -> L20
        r100.taskIdentifier = r102;     // Catch: Throwable -> L20
        if (this.indexArray.contains(Long.valueOf(r102)) == false) goto L16;
        TTVideoEngineLog.e(TAG, "[downloader] add task fail. taskIdentifier = " + this.maxTaskId);     // Catch: Throwable -> L20
        r100 = null;
    L17:
        saveTaskInfo(r100);     // Catch: Throwable -> L20
        return r100;
    L16:
        this.indexArray.add(Long.valueOf(this.maxTaskId));     // Catch: Throwable -> L20
        this.allTasks.add(r100);     // Catch: Throwable -> L20
        goto L17
    }

    private String indexToString(ArrayList<Long> r100) {
        if (r100 == null) goto L12;
        StringBuilder r101 = new StringBuilder(r100.size());
        int r102 = 0;
    L5:
        if (r102 >= r100.size()) goto L11;
        r101.append(ListProtector.get(r100, r102));
        if (r102 >= (r100.size() - 1)) goto L9;
        r101.append(",");
    L9:
        r102 = r102 + 1;
        goto L5
    L11:
        return r101.toString();
    L12:
        return null;
    }

    private void saveTaskInfo(DownloadTask r100) {
        SaveInfos r101 = new SaveInfos(this, null);
        r101.task = r100;
        r101.alltasks = new ArrayList(this.allTasks);
        ArrayList<Object> r102 = new ArrayList();
        r102.add(this);
        r102.add(r101);
        this.taskThread.postMessage(r102, 11);
    }

    private ArrayList<String> stringToStringArray(String r100) {
        ArrayList<String> r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L24;
        return null;
    L24:
        String[] r102 = r100.split(",");     // Catch: Throwable -> L19
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.length <= 0) goto L30;
        ArrayList<String> r103 = new ArrayList();     // Catch: Throwable -> L19
        int r104 = r102.length;     // Catch: Throwable -> L17
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L31;
        String r106 = r102[r105];     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r106) == true) goto L15;
        r103.add(r106);     // Catch: Throwable -> L17
    L15:
        r105 = r105 + 1;
        goto L11
    L31:
        return r103;
    L17:
        th = th;
        r101 = r103;
    L20:
        TTVideoEngineLog.d(th);
        return r101;
    L30:
        return null;
    L19:
        th = th;
        goto L20
    }

    private DownloadTask taskForKey(String r100) {
        DownloadTask r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Iterator r102 = new ArrayList(this.allTasks).iterator();
    L7:
        if (r102.hasNext() == false) goto L19;
        DownloadTask r103 = (DownloadTask) r102.next();
        ArrayList<String> r104 = r103.mediaKeys;
        if (r104 == null) goto L18;
        if (r104.size() <= 0) goto L18;
        Iterator<String> r105 = r103.mediaKeys.iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        if (r100.equals(r105.next()) == false) goto L14;
        r101 = r103;
    L18:
        if (r101 == null) goto L7;
    L19:
        return r101;
    }

    private void writeIndexesToDisk(ArrayList<DownloadTask> r100) {
        ArrayList<Long> r101 = new ArrayList();
        Iterator<DownloadTask> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        DownloadTask r103 = r102.next();
        if (r101.contains(Long.valueOf(r103.taskIdentifier)) == true) goto L4;
        r101.add(Long.valueOf(r103.taskIdentifier));
        goto L4
    L8:
        Collections.sort(r101);
        String r104 = indexToString(r101);
        this.dbObject.save("index", r104);
        SharedPreferences.Editor r105 = this.mContext.getSharedPreferences(tasksIndex, 0).edit();
        r105.putString("index", r104);
        r105.commit();
    }

    public void cancel(DownloadTask r100) {
        this.allTasks.remove(r100);
        this.indexArray.remove(Long.valueOf(r100.taskIdentifier));
        this.waitingTasks.remove(r100);
        r100.receiveError(new Error(Error.Download, Error.UserCancel, 0, "task info: " + r100.toString()));
    }

    public void downloadDidSuspened(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Handler r101 = this.mHandler;
        if (r101 == null) goto L9;
        r101.sendMessage(Message.obtain(r101, 2, r100));
        return;
    }

    public void loadAllTasks(Context r100) {
        if (r100 != null) goto L9;
        TTVideoEngineLog.e(TAG, "[downloader] context == null");
        IDownloaderListener r101 = this.listener;
        if (r101 == null) goto L23;
        r101.downloaderDidLoadAllTask(this, null, new Error(Error.Download, -9999, 0, "context is null"));
        return;
    L23:
        return;
    L9:
        if (DataLoaderHelper.getDataLoader().isRunning() == true) goto L15;
        TTVideoEngineLog.e(TAG, "[downloader] need start dataloader first.");
        IDownloaderListener r102 = this.listener;
        if (r102 == null) goto L24;
        r102.downloaderDidLoadAllTask(this, null, new Error(Error.Download, Error.MediaLoaderNeedStart, 0, "need start medialoader"));
        return;
    L24:
        return;
    L15:
        if (this.readAllTask == false) goto L20;
        if (this.listener == null) goto L25;
        ArrayList r103 = new ArrayList(this.allTasks);
        this.listener.downloaderDidLoadAllTask(this, r103, null);
        return;
    L25:
        return;
    L20:
        if (this.loadData == true) goto L27;
        this.loadData = true;
        this.mContext = r100;
        initHandle();
        ArrayList<Object> r104 = new ArrayList();
        r104.add(this);
        this.taskThread.postMessage(r104, 10);
        return;
    }

    public void progress(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Handler r101 = this.mHandler;
        if (r101 == null) goto L9;
        r101.sendMessage(Message.obtain(r101, 0, r100));
        return;
    }

    public void resume(DownloadTask r100) {
        if (FeatureManager.hasPermission() == true) goto L6;
        return;
    L6:
        if (this.runingTasks.contains(r100) == true) goto L9;
        this.runingTasks.add(r100);
    L9:
        if (this.waitingTasks.contains(r100) == false) goto L11;
        TTVideoEngineLog.i(TAG, "[downloader] resume task. is waiting,  task = " + r100.toString());
        this.waitingTasks.remove(r100);
    L11:
        long r101 = r100.bytesReceived;
        if (r101 < 1) goto L20;
        long r102 = r100.bytesExpectedToReceive;
        if (r102 < 1) goto L22;
        IDownloaderListener r103 = this.listener;
        if (r103 == null) goto L21;
        r103.downloaderDidResume(this, r100, r101, r102);
        return;
    L21:
        return;
    L22:
        return;
    }

    public void setLimitFreeDiskSize(long r100) {
        this.limitFreeDiskSize = r100;
    }

    public void setListener(IDownloaderListener r100) {
        this.listener = r100;
    }

    public void setMaxDownloadOperationCount(long r100) {
        this.maxDownloadOperationCount = r100;
    }

    public boolean shouldResume(DownloadTask r110) {
        if (this.runingTasks.size() >= this.maxDownloadOperationCount) goto L5;
    L16:
        long r100 = TTHelper.getFreeSize(this.mContext);
        TTVideoEngineLog.i(TAG, "[downloader] get free size, size = " + r100 + ", limite = " + getLimitFreeDiskSize());
        if (r100 > getLimitFreeDiskSize()) goto L20;
        r110.receiveError(new Error(Error.Download, Error.NotEnoughDiskSpace, 0, "available size is less than 1073741824 M"));
        return false;
    L20:
        return true;
    L5:
        if (this.runingTasks.contains(r110) == true) goto L7;
    L11:
        r110.setState(1);
        if (this.waitingTasks.contains(r110) == true) goto L14;
        this.waitingTasks.add(r110);
    L14:
        TTVideoEngineLog.d(TAG, "[downloader] task is waiting, task info " + r110.toString());
        return false;
    L7:
        if (r110.getState() == 3) goto L16;
        if (r110.getState() != 5) goto L11;
        goto L11
    }

    public boolean suspended(DownloadTask r100) {
        if (this.waitingTasks.contains(r100) == false) goto L7;
        this.waitingTasks.remove(r100);
        TTVideoEngineLog.d(TAG, "[downloader] task is waiting. key =" + r100.toString());
        r100.setState(3);
        return true;
    L7:
        return true;
    }

    public void tryNextWaitingTask(DownloadTask r100) {
        if (this.runingTasks.contains(r100) == false) goto L6;
        this.runingTasks.remove(r100);
    L6:
        if (this.runingTasks.size() < this.maxDownloadOperationCount) goto L10;
        TTVideoEngineLog.d(TAG, "[downloader] running task count is " + this.runingTasks.size() + " max count is " + this.maxDownloadOperationCount);
        return;
    L10:
        if (this.waitingTasks.size() >= 1) goto L13;
        TTVideoEngineLog.d(TAG, "[downloader] waiting task is empty");
        return;
    L13:
        DownloadTask r101 = (DownloadTask) ListProtector.get(this.waitingTasks, 0);
        this.waitingTasks.remove(r101);
        r101.resume();
        TTVideoEngineLog.d(TAG, "[downloader] auto resume waiting task: " + r101.toString());
    }

    public static /* synthetic */ DownloadTask access$100(Downloader r100, String r101) {
        return r100.taskForKey(r101);
    }

    public static /* synthetic */ KVDBManager access$1002(Downloader r100, KVDBManager r101) {
        r100.dbObject = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(Downloader r100, boolean r101) {
        r100.loadData = r101;
        return r101;
    }

    public static /* synthetic */ ArrayList access$502(Downloader r100, ArrayList r101) {
        r100.temLoadedTasks = r101;
        return r101;
    }

    public static /* synthetic */ long access$602(Downloader r100, long r101) {
        r100.maxTaskId = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(Downloader r100, boolean r101) {
        r100.readAllTask = r101;
        return r101;
    }

    private void writeTask(DownloadTask r100, ArrayList<DownloadTask> r110) {
        writeIndexesToDisk(r110);
        String r101 = r100.jsonObject().toString();
        String r102 = String.valueOf(r100.taskIdentifier);
        TTVideoEngineLog.i(TAG, "[downloader] write task. key " + r102 + " value: " + r101);
        if (r110.contains(r100) == false) goto L8;
        if (this.dbObject.save(r102, r101) == true) goto L11;
        TTVideoEngineLog.e(TAG, "[downloader] save task fail, videoid = " + r100.videoId + " taskIdentifier = " + r100.taskIdentifier);
        r100.receiveError(new Error(Error.Download, Error.SaveTaskItem, -1, r101));
        return;
    L11:
        return;
    L8:
        if (this.dbObject.remove(r102) == true) goto L13;
        TTVideoEngineLog.e(TAG, "[downloader] remove task fail, videoid = " + r100.videoId + " taskIdentifier = " + r100.taskIdentifier);
        r100.receiveError(new Error(Error.Download, Error.SaveTaskItem, -1, r101));
        return;
    }

    public void completeError(DownloadTask r100, Error r101) {
        if (r100.finished == true) goto L5;
    L8:
        if (r101 == null) goto L10;
        TTVideoEngineLog.d(TAG, "[downloader] error info " + r101.toString());
    L10:
        r100.finished = true;
        saveTaskInfo(r100);
        IDownloaderListener r102 = this.listener;
        if (r102 == null) goto L13;
        r102.downloaderDidComplete(this, r100, r101);
    L13:
        TTVideoEngineLog.d(TAG, "[downloader] task complete, task info = " + r100.toString());
        tryNextWaitingTask(r100);
        return;
    L5:
        if (r100.canceled == true) goto L8;
        TTVideoEngineLog.d(TAG, "[downloader] task did finished, info = " + r100.toString());
    }

    public void downloadFail(String r100, Error r101) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.mHandler == null) goto L11;
        ArrayList r102 = new ArrayList();
        r102.add(r100);
        r102.add(r101);
        Handler r103 = this.mHandler;
        r103.sendMessage(Message.obtain(r103, 1, r102));
        return;
    L11:
        return;
    }

    public void setOption(int r100, long r101) {
        if (r100 != 1) goto L7;
        this.mPerfGetCacheInfo = r101;
        return;
    }

    public DownloadVidTask vidTask(VideoModel r100, Resolution r101) {
        if (FeatureManager.hasPermission() == true) goto L6;
        return null;
    L6:
        DownloadVidTask r102 = DownloadVidTask.taskItem(r100, r101);
        if (r102 == null) goto L11;
        r102 = (DownloadVidTask) addTask(r102);
        if (r102 == null) goto L11;
        r102.mContext = this.mContext;
        r102.setVideoModel(r100);
    L11:
        return r102;
    }

    public static /* synthetic */ void access$1300(Downloader r100, DownloadTask r101, ArrayList r102) {
        r100.writeTask(r101, r102);
    }

    public DownloadURLTask urlTask(String[] r100, String r101, String r102) {
        if (FeatureManager.hasPermission() == true) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
    L21:
        TTVideoEngineLog.e(TAG, "[downloader] urls or key is invalid.");
        return null;
    L7:
        if (r100.length < 1) goto L21;
        if (TextUtils.isEmpty(r101) == true) goto L21;
        ArrayList<String> r103 = new ArrayList();
        int r104 = 0;
    L13:
        if (r104 >= r100.length) goto L15;
        r103.add(r100[r104]);
        r104 = r104 + 1;
        goto L13
    L15:
        DownloadURLTask r105 = DownloadURLTask.taskItem(r101, r103, r102);
        if (r105 == null) goto L20;
        r105 = (DownloadURLTask) addTask(r105);
        if (r105 == null) goto L20;
        r105.updateUrls(r103);
    L20:
        return r105;
    }

    public DownloadVidTask vidTask(String r100, Resolution r101, String r110) {
        return vidTask(r100, r101, null, false, false, r110);
    }

    public DownloadURLTask urlTask(String[] r100, String r101, String r102, DownloadTask.EncryptVersion r103) {
        if (FeatureManager.hasPermission() == true) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
    L17:
        TTVideoEngineLog.e(TAG, "[downloader] urls or key is invalid.");
        return null;
    L7:
        if (r100.length < 1) goto L17;
        if (TextUtils.isEmpty(r101) == true) goto L17;
        ArrayList<String> r104 = new ArrayList();
        Collections.addAll(r104, r100);
        DownloadURLTask r105 = DownloadURLTask.taskItem(r101, r104, r102, r103);
        if (r105 == null) goto L16;
        r105 = (DownloadURLTask) addTask(r105);
        if (r105 == null) goto L16;
        r105.updateUrls(r104);
    L16:
        return r105;
    }

    public DownloadVidTask vidTask(String r100, Resolution r101, boolean r102, boolean r110, boolean r111) {
        if (FeatureManager.hasPermission() == true) goto L6;
        return null;
    L6:
        if (r102 == false) goto L8;
        String r103 = "bytevc1";
    L10:
        return vidTask(r100, r101, r103, r110, r111);
    L8:
        r103 = "h264";
        goto L10
    }

    public DownloadVidTask vidTask(String r100, Resolution r101, String r110, boolean r111, boolean r112) {
        return vidTask(r100, r101, r110, r111, r112, null);
    }

    public DownloadVidTask vidTask(String r100, Resolution r101, String r102, boolean r103, boolean r104, String r105) {
        if (FeatureManager.hasPermission() == true) goto L6;
        return null;
    L6:
        DownloadVidTask r106 = DownloadVidTask.taskItem(r100, r101, r102, r103, r104, r105);
        if (r106 == null) goto L11;
        r106 = (DownloadVidTask) addTask(r106);
        if (r106 == null) goto L11;
        r106.mContext = this.mContext;
    L11:
        return r106;
    }
}
