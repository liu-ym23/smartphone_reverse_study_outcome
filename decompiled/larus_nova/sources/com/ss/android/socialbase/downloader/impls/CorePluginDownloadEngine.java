package com.ss.android.socialbase.downloader.impls;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class CorePluginDownloadEngine implements IDownloadTaskExecuteListener {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final String MONITOR_SCENE = "morpheus_plugin_download";
    private static final String TAG = "CorePluginDownloadEngine";
    private int mDegradeTimeout;
    private AbsDownloadEngine mDownloadEngine;
    private Queue<PluginInfo> mDownloadingPluginQueue;
    private Map<Integer, Future> mFutureTaskRecords;
    private List<String> mIgnorePauseNames;
    private AtomicInteger mIndex;
    private MonitorRunnable mMonitorRunnable;
    private boolean mPauseAllTask;
    private ThreadPoolExecutor mPluginExecutor;
    private int mPluginPoolSize;
    private volatile boolean mRegisterTaskListener;
    private ThreadPoolExecutor mSingleOPExecutor;
    private Set<Integer> mStartDownloadId;
    private Queue<PluginInfo> mWaitingPluginQueue;
    private List<DownloadTask> mWaitingTasks;

    public class MonitorRunnable implements Runnable {
        private volatile boolean mCanceled;
        private Future mFuture;
        private int mId;
        final /* synthetic */ CorePluginDownloadEngine this$0;

        public void cancel() {
            this.mCanceled = true;
            this.mFuture.cancel(true);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Logger.taskError(CorePluginDownloadEngine.TAG, this.mId, "cancel", "Error:" + th);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ss_android_socialbase_downloader_impls_CorePluginDownloadEngine$MonitorRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void runImpl() {
            if (this.mCanceled == false) goto L9;
            if (Logger.debugScene(CorePluginDownloadEngine.MONITOR_SCENE) == false) goto L24;
            Logger.taskDebug(CorePluginDownloadEngine.TAG, this.mId, CorePluginDownloadEngine.MONITOR_SCENE, "MonitorRunnable_runImpl", "Cancel", false);
            return;
        L24:
            return;
        L9:
            if (CorePluginDownloadEngine.access$600(this.this$0) == false) goto L16;
            if (CorePluginDownloadEngine.access$700(this.this$0).contains(Integer.valueOf(this.mId)) == true) goto L16;
            CorePluginDownloadEngine.access$200(this.this$0, "Start download timeout, Id:" + this.mId);
            return;
        L16:
            if (CorePluginDownloadEngine.access$800(this.this$0).isEmpty() == true) goto L18;
            return;
        L18:
            if (CorePluginDownloadEngine.access$900(this.this$0).isEmpty() == true) goto L20;
            return;
        L20:
            if (Logger.debugScene(CorePluginDownloadEngine.MONITOR_SCENE) == false) goto L22;
            Logger.taskDebug(CorePluginDownloadEngine.TAG, this.mId, CorePluginDownloadEngine.MONITOR_SCENE, "MonitorRunnable_runImpl", "Stop Monitor", false);
        L22:
            CorePluginDownloadEngine.access$1000(this.this$0);
        }

        public void com_ss_android_socialbase_downloader_impls_CorePluginDownloadEngine$MonitorRunnable__run$___twin___() {
            if (this.mCanceled == true) goto L5;
            CorePluginDownloadEngine.access$300(this.this$0, new AnonymousClass1(this));
            return;
        L5:
            if (Logger.debugScene(CorePluginDownloadEngine.MONITOR_SCENE) == false) goto L10;
            Logger.taskDebug(CorePluginDownloadEngine.TAG, this.mId, CorePluginDownloadEngine.MONITOR_SCENE, "MonitorRunnable_run", "Cancel", false);
            return;
        }

        public boolean isDone() {
            Future r100 = this.mFuture;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isDone() == false) goto L7;
            return true;
        }

        public static /* synthetic */ void access$500(MonitorRunnable r100) {
            r100.runImpl();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_android_socialbase_downloader_impls_CorePluginDownloadEngine$MonitorRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MonitorRunnable r100) {
            r100.com_ss_android_socialbase_downloader_impls_CorePluginDownloadEngine$MonitorRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void setFuture(Future r100) {
            this.mFuture = r100;
        }

        public MonitorRunnable(CorePluginDownloadEngine r100, int r101) {
            this.this$0 = r100;
            this.mCanceled = false;
            this.mId = r101;
        }
    }

    public class PluginInfo {
        DownloadTask mDownloadTask;
        int mId;
        int mIndex;
        int mType;
        final /* synthetic */ CorePluginDownloadEngine this$0;

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mId)});
        }

        public String toString() {
            return "PluginInfo{type=" + this.mType + ", index=" + this.mIndex + ", id=" + this.mId + '}';
        }

        private PluginInfo(CorePluginDownloadEngine r100) {
            this.this$0 = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L15:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L15;
            if (this.mId == ((PluginInfo) r100).mId) goto L16;
            return false;
        L16:
            return true;
        }

        public /* synthetic */ PluginInfo(CorePluginDownloadEngine r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener
    public void onFinish(DownloadTask r100, int r101) {
    }

    private void stopMonitor() {
        if (this.mRegisterTaskListener == true) goto L5;
        return;
    L5:
        this.mRegisterTaskListener = false;
        DownloadComponentManager.unRegisterDownloadTaskExecuteListener(this);
        this.mStartDownloadId.clear();
    }

    public void resumeAllDownloadTask() {
        runWithSingleOPExecutor(new AnonymousClass7(this));
    }

    public CorePluginDownloadEngine() {
        this.mPluginPoolSize = getPluginThreadPoolSize();
        final int r100 = this.mPluginPoolSize;
        final long r101 = 15;
        final TimeUnit r110 = TimeUnit.SECONDS;
        final LinkedBlockingQueue r102 = new LinkedBlockingQueue();
        final DefaultThreadFactory r103 = new DefaultThreadFactory("DownloadThreadPool-plugin", true);
        this.mPluginExecutor = new AnonymousClass1(this, r100, r100, r101, r110, r102, r103);
        final int r104 = 1;
        final int r105 = 1;
        final long r106 = 30;
        final LinkedBlockingQueue r107 = new LinkedBlockingQueue();
        final DefaultThreadFactory r108 = new DefaultThreadFactory("DownloadThreadPool-plugin-single", true);
        this.mSingleOPExecutor = new AnonymousClass2(this, r104, r105, r106, r110, r107, r108);
        this.mDownloadEngine = DownloadComponentManager.getDownloadEngine();
        this.mDownloadingPluginQueue = new PriorityQueue(11, new AnonymousClass3(this));
        this.mWaitingPluginQueue = new PriorityQueue(11, new AnonymousClass4(this));
        this.mIndex = new AtomicInteger();
        this.mFutureTaskRecords = new HashMap();
        this.mPauseAllTask = false;
        this.mIgnorePauseNames = new ArrayList();
        this.mWaitingTasks = new ArrayList();
        this.mRegisterTaskListener = false;
        this.mDegradeTimeout = getPluginDegradeTimeout();
        this.mStartDownloadId = new CopyOnWriteArraySet();
    }

    private int getPluginDegradeTimeout() {
        int r100 = DownloadUtils.getPluginDegradeTimeout();
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L5;
        Logger.globalDebug(TAG, "getPluginDegradeTimeout", "PluginDegradeTimeout:" + r100);
    L5:
        if (r100 <= 0) goto L7;
        return r100;
    L7:
        int r101 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PLUGIN_DEGRADE_BACKUP_TIMEOUT_S);
        if (r101 > 0) goto L11;
        r101 = 60;
    L11:
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L13;
        Logger.globalDebug(TAG, "getPluginDegradeTimeout", "Setting PluginDegradeTimeout:" + r101);
    L13:
        return r101;
    }

    private int getPluginThreadPoolSize() {
        int r100 = DownloadUtils.getPluginThreadPoolSize();
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L5;
        Logger.globalDebug(TAG, "getPluginThreadPoolSize", "PluginThreadPoolSize:" + r100);
    L5:
        if (r100 <= 0) goto L7;
        return r100;
    L7:
        int r101 = 2;
        int r102 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PLUGIN_THREAD_POOL_SIZE, 2);
        if (r102 <= 0) goto L12;
        r101 = r102;
    L12:
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L14;
        Logger.globalDebug(TAG, "getPluginThreadPoolSize", "Setting PluginThreadPoolSize:" + r101);
    L14:
        return r101;
    }

    public ExecutorService getPluginExecutor() {
        return this.mPluginExecutor;
    }

    public static /* synthetic */ Map access$000(CorePluginDownloadEngine r100) {
        return r100.mFutureTaskRecords;
    }

    public static /* synthetic */ void access$1000(CorePluginDownloadEngine r100) {
        r100.stopMonitor();
    }

    public static /* synthetic */ boolean access$1300(CorePluginDownloadEngine r100) {
        return r100.mPauseAllTask;
    }

    public static /* synthetic */ List access$1400(CorePluginDownloadEngine r100) {
        return r100.mIgnorePauseNames;
    }

    public static /* synthetic */ AbsDownloadEngine access$1600(CorePluginDownloadEngine r100) {
        return r100.mDownloadEngine;
    }

    public static /* synthetic */ int access$1700(CorePluginDownloadEngine r100) {
        return r100.mDegradeTimeout;
    }

    public static /* synthetic */ List access$1800(CorePluginDownloadEngine r100) {
        return r100.mWaitingTasks;
    }

    public static /* synthetic */ MonitorRunnable access$1900(CorePluginDownloadEngine r100) {
        return r100.mMonitorRunnable;
    }

    public static /* synthetic */ boolean access$600(CorePluginDownloadEngine r100) {
        return r100.mRegisterTaskListener;
    }

    public static /* synthetic */ Set access$700(CorePluginDownloadEngine r100) {
        return r100.mStartDownloadId;
    }

    public static /* synthetic */ Queue access$800(CorePluginDownloadEngine r100) {
        return r100.mWaitingPluginQueue;
    }

    public static /* synthetic */ Queue access$900(CorePluginDownloadEngine r100) {
        return r100.mDownloadingPluginQueue;
    }

    private void degradeBackupDownloadEngine(String r100) {
        if (PluginDownloadEngine.isBackupEngine() == false) goto L5;
        return;
    L5:
        IDownloadPluginDegradeListener r101 = PluginDownloadEngine.getDownloadPluginDegradeListener();
        if (r101 == null) goto L8;
        r101.onDegrade(r100);
    L8:
        Logger.globalError(TAG, "degradeBackupDownloadEngine", "Error:" + r100);
        DownloadMonitorHelper.monitorDownloadOtherError(new Throwable(r100));
        PluginDownloadEngine.setBackupEngine(true);
        Logger.globalError(TAG, "degradeBackupDownloadEngine", "Stop Monitor");
        stopMonitor();
    }

    private void doDownload(PluginInfo r100) {
        this.mDownloadingPluginQueue.add(r100);
        Future r101 = this.mDownloadEngine.doDownload(r100.mDownloadTask, true);
        this.mFutureTaskRecords.put(Integer.valueOf(r100.mId), r101);
    }

    private void doPause(PluginInfo r100) {
        this.mWaitingPluginQueue.add(r100);
        this.mDownloadEngine.doPause(r100.mId, false);
    }

    private boolean matchIgnorePauseName(String r100) {
        if (this.mIgnorePauseNames.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<String> r101 = this.mIgnorePauseNames.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (r100.contains(r101.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private void runWithSingleOPExecutor(Runnable r100) {
        this.mSingleOPExecutor.execute(r100);
    }

    private void tryDownloadNext(int r100) {
        PluginInfo r101 = new PluginInfo(this, null);
        r101.mId = r100;
        this.mDownloadingPluginQueue.remove(r101);
        if (this.mDownloadingPluginQueue.size() < this.mPluginPoolSize) goto L9;
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L34;
        Logger.taskDebug(TAG, r100, MONITOR_SCENE, "tryDownloadNext", "DownloadingPluginQueue full", false);
        return;
    L34:
        return;
    L9:
        if (this.mWaitingPluginQueue.isEmpty() == true) goto L11;
    L21:
        Iterator<PluginInfo> r102 = this.mWaitingPluginQueue.iterator();
    L23:
        if (r102.hasNext() == false) goto L35;
        PluginInfo r103 = r102.next();
        if (this.mFutureTaskRecords.containsKey(Integer.valueOf(r103.mId)) == true) goto L23;
        r102.remove();
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L29;
        Logger.taskDebug(TAG, r100, MONITOR_SCENE, "tryDownloadNext", "Remove " + r100 + " Try doDownload:" + r103, false);
    L29:
        doDownload(r103);
        return;
    L35:
        return;
    L11:
        if (this.mDownloadingPluginQueue.isEmpty() == false) goto L21;
        MonitorRunnable r104 = this.mMonitorRunnable;
        if (r104 == null) goto L21;
        if (r104.isDone() == false) goto L21;
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L19;
        Logger.taskDebug(TAG, r100, MONITOR_SCENE, "tryDownloadNext", "Stop Monitor", false);
    L19:
        stopMonitor();
    }

    public void download(final DownloadTask r100) {
        runWithSingleOPExecutor(new AnonymousClass5(this, r100));
    }

    public void pauseAllDownloadTask(final List<String> r100) {
        runWithSingleOPExecutor(new AnonymousClass6(this, r100));
    }

    public static /* synthetic */ void access$100(CorePluginDownloadEngine r100, int r101) {
        r100.tryDownloadNext(r101);
    }

    public static /* synthetic */ boolean access$1302(CorePluginDownloadEngine r100, boolean r101) {
        r100.mPauseAllTask = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1500(CorePluginDownloadEngine r100, String r101) {
        return r100.matchIgnorePauseName(r101);
    }

    public static /* synthetic */ void access$200(CorePluginDownloadEngine r100, String r101) {
        r100.degradeBackupDownloadEngine(r101);
    }

    public static /* synthetic */ void access$300(CorePluginDownloadEngine r100, Runnable r101) {
        r100.runWithSingleOPExecutor(r101);
    }

    private int compareImpl(PluginInfo r100, PluginInfo r101) {
        int r102 = Integer.compare(r100.mType, r101.mType);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        if (r100.mType != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L10;
        return Integer.compare(r101.mIndex, r100.mIndex);
    L10:
        return Integer.compare(r100.mIndex, r101.mIndex);
    }

    private PluginInfo findPlugin(Collection<PluginInfo> r100, int r101) {
        Iterator<PluginInfo> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        PluginInfo r103 = r102.next();
        if (r103.mId != r101) goto L4;
        return r103;
    L8:
        return null;
    }

    private void startMonitor(int r100, int r101) {
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L6;
        Logger.taskDebug(TAG, r100, "startMonitor", "Run");
    L6:
        if (this.mDegradeTimeout <= 0) goto L28;
        if (this.mStartDownloadId.contains(Integer.valueOf(r100)) == true) goto L28;
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L14;
        Logger.taskDebug(TAG, r100, "startMonitor", "Real DegradeTimeout:" + this.mDegradeTimeout);
    L14:
        if (this.mRegisterTaskListener == true) goto L17;
        this.mRegisterTaskListener = true;
        DownloadComponentManager.registerDownloadTaskExecuteListener(this);
    L17:
        if (r101 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L19;
        MonitorRunnable r102 = this.mMonitorRunnable;
        if (r102 == null) goto L25;
        r102.cancel();
    L25:
        MonitorRunnable r103 = new MonitorRunnable(this, r100);
        this.mMonitorRunnable = r103;
        this.mMonitorRunnable.setFuture(DownloadComponentManager.submitScheduleTask(r103, this.mDegradeTimeout, TimeUnit.SECONDS));
        return;
    L19:
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L31;
        Logger.taskDebug(TAG, r100, "startMonitor", "Return");
        return;
    L31:
        return;
    L28:
        if (Logger.debugScene(MONITOR_SCENE) == false) goto L32;
        Logger.taskDebug(TAG, r100, "startMonitor", "Return");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener
    public void onStart(DownloadTask r100, int r101) {
        this.mStartDownloadId.add(Integer.valueOf(r100.getDownloadId()));
    }

    public static /* synthetic */ int access$400(CorePluginDownloadEngine r100, PluginInfo r101, PluginInfo r102) {
        return r100.compareImpl(r101, r102);
    }

    private void downloadImpl(int r100, int r101, DownloadTask r102, DownloadInfo r110) {
        if (this.mPauseAllTask == true) goto L5;
    L10:
        startMonitor(r100, r101);
        PluginInfo r103 = findPlugin(this.mDownloadingPluginQueue, r100);
        if (r103 != null) goto L13;
        PluginInfo r104 = findPlugin(this.mWaitingPluginQueue, r100);
        AnonymousClass1 r105 = null;
        if (this.mDownloadingPluginQueue.size() >= this.mPluginPoolSize) goto L49;
        if (this.mWaitingPluginQueue.isEmpty() == true) goto L27;
    L33:
        if (r104 != null) goto L35;
        PluginInfo r111 = new PluginInfo(this, r105);
        r111.mId = r100;
        r111.mType = r101;
        r111.mIndex = this.mIndex.incrementAndGet();
        r111.mDownloadTask = r102;
        this.mWaitingPluginQueue.add(r111);
        return;
    L35:
        if (r101 != EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L44;
        if (r104.mType != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L39;
        r104.mType = r101;
    L40:
        this.mWaitingPluginQueue.remove(r104);
        this.mWaitingPluginQueue.add(r104);
        if (Logger.debugScene(r110) == false) goto L75;
        Logger.taskDebug(TAG, r110, "downloadImpl", "Update Waiting Queue");
        return;
    L75:
        return;
    L39:
        r104.mIndex = this.mIndex.incrementAndGet();
        goto L40
    L44:
        if (Logger.debugScene(r110) == false) goto L77;
        Logger.taskDebug(TAG, r110, "downloadImpl", "In Waiting Queue");
        return;
    L77:
        return;
    L27:
        if (this.mFutureTaskRecords.containsKey(Integer.valueOf(r102.getDownloadId())) == true) goto L33;
        PluginInfo r106 = new PluginInfo(this, r105);
        r106.mId = r100;
        r106.mType = r101;
        r106.mIndex = this.mIndex.incrementAndGet();
        r106.mDownloadTask = r102;
        if (Logger.debugScene(r110) == false) goto L31;
        Logger.taskDebug(TAG, r110, "downloadImpl", "New doDownload");
    L31:
        doDownload(r106);
        return;
    L49:
        if (r104 != null) goto L51;
        PluginInfo r107 = new PluginInfo(this, r105);
        r107.mId = r100;
        r107.mType = r101;
        r107.mIndex = this.mIndex.incrementAndGet();
        r107.mDownloadTask = r102;
        if (r101 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L64;
        this.mWaitingPluginQueue.add(r107);
        PluginInfo r108 = this.mDownloadingPluginQueue.poll();
        if (Logger.debugScene(r110) == false) goto L70;
        Logger.taskDebug(TAG, r110, "downloadImpl", "Pause:" + r108.mId + " Add WaitingQueue");
    L70:
        doPause(r108);
        return;
    L64:
        if (Logger.debugScene(r110) == false) goto L66;
        Logger.taskDebug(TAG, r110, "downloadImpl", "Add WaitingQueue");
    L66:
        this.mWaitingPluginQueue.add(r107);
        return;
    L51:
        if (r101 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L53;
        r104.mType = r101;
        r104.mIndex = this.mIndex.incrementAndGet();
        this.mWaitingPluginQueue.remove(r104);
        this.mWaitingPluginQueue.add(r104);
        PluginInfo r109 = this.mDownloadingPluginQueue.poll();
        if (Logger.debugScene(r110) == false) goto L59;
        Logger.taskDebug(TAG, r110, "downloadImpl", "Pause:" + r109.mId + " Move WaitingQueue");
    L59:
        doPause(r109);
        return;
    L53:
        if (Logger.debugScene(r110) == false) goto L79;
        Logger.taskDebug(TAG, r110, "downloadImpl", "In WaitingQueue wait");
        return;
    L79:
        return;
    L13:
        if (r101 == EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L15;
        return;
    L15:
        if (r103.mType != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L17;
        r103.mType = r101;
    L18:
        this.mDownloadingPluginQueue.remove(r103);
        this.mDownloadingPluginQueue.add(r103);
        if (Logger.debugScene(r110) == false) goto L74;
        Logger.taskDebug(TAG, r110, "downloadImpl", "In DownloadingQueue reorder");
        return;
    L74:
        return;
    L17:
        r103.mIndex = this.mIndex.incrementAndGet();
        goto L18
    L5:
        if (matchIgnorePauseName(r110.getName()) == true) goto L10;
        this.mWaitingTasks.add(r102);
        if (Logger.debugScene(r110) == false) goto L72;
        Logger.taskDebug(TAG, r110, "downloadImpl", "Add PauseWaitingTask");
        return;
    }

    public static /* synthetic */ void access$1100(CorePluginDownloadEngine r100, int r101, int r102, DownloadTask r103, DownloadInfo r104) {
        r100.downloadImpl(r101, r102, r103, r104);
    }
}
