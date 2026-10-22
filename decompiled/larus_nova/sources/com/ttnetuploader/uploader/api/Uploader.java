package com.ttnetuploader.uploader.api;

import android.content.Context;
import com.ttnetuploader.uploader.discovery.DiscoveryManager;
import com.ttnetuploader.uploader.task.ITask;
import com.ttnetuploader.uploader.task.Task;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public class Uploader {
    private static volatile Uploader s_instance;
    private Context mContext;
    private final Set<String> mFilePathSet;
    private final Map<Long, ITask> mTaskMap;

    public void stopDiscoveryLanDev() {
        DiscoveryManager.getInstance(this.mContext).stopDiscovery();
    }

    public Uploader() {
        this.mTaskMap = new HashMap();
        this.mFilePathSet = new HashSet();
        this.mContext = null;
    }

    public static /* synthetic */ Context access$100(Uploader r100) {
        return r100.mContext;
    }

    private void addTaskMap(ITask r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (ULLog.debug() == false) goto L7;
        ULLog.globalDebug("Uploader", "addTaskMap", "uploadId: " + r100.getUploadId());
    L7:
        Map<Long, ITask> r101 = this.mTaskMap;
        monitor-enter(r101);
        this.mTaskMap.put(Long.valueOf(r100.getUploadId()), r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void deleteFromSet(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return;
    L7:
        if (ULLog.debug() == false) goto L9;
        ULLog.globalDebug("Uploader", "deleteFromSet", "filePath=".concat(r100));
    L9:
        Set<String> r101 = this.mFilePathSet;
        monitor-enter(r101);
        this.mFilePathSet.remove(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void deleteTaskMap(long r100) {
        if (ULLog.debug() == false) goto L5;
        ULLog.globalDebug("Uploader", "deleteTaskMap", "uploadId: " + r100);
    L5:
        Map<Long, ITask> r101 = this.mTaskMap;
        monitor-enter(r101);
        this.mTaskMap.remove(Long.valueOf(r100));     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static Uploader getInstance(Context r100) {
        if (s_instance == null) goto L5;
    L14:
        s_instance.setContext(r100);
        return s_instance;
    L5:
        monitor-enter(Uploader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (s_instance != null) goto L9;
        s_instance = new Uploader();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Uploader.class);     // Catch: Throwable -> L11
        goto L14
    }

    private boolean isFilePathExist(String r100) {
        if (r100 != null) goto L5;
    L23:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L23;
        if (ULLog.debug() == false) goto L10;
        ULLog.globalDebug("Uploader", "isFilePathExist", "filePath=".concat(r100));
    L10:
        Set<String> r101 = this.mFilePathSet;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L13:
        if (this.mFilePathSet.contains(r100) == false) goto L17;
        monitor-exit(r101);     // Catch: Throwable -> L20
        return true;
    L17:
        this.mFilePathSet.add(r100);     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return false;
    }

    public String getLanServerIp(String r100) {
        return DiscoveryManager.getInstance(this.mContext).getIpv4(r100);
    }

    public boolean isLanDevReachable(String r100) {
        return DiscoveryManager.getInstance(this.mContext).isReachable(r100, false, false);
    }

    public void setContext(Context r100) {
        if (this.mContext != null) goto L14;
        if (r100 == null) goto L17;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mContext != null) goto L9;
        this.mContext = r100.getApplicationContext();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L17:
        return;
    }

    public void setTaskConcurrencyMax(int r100) {
        CommonTools.setTaskConcurrencyMax(r100);
    }

    public void start(final Parameters r100) {
        if (ULLog.debug() == false) goto L5;
        ULLog.globalDebug("Uploader", "start", "uploadId:=" + CommonTools.getNonnullValue(r100, new a(), 0L) + ",filePath=" + ((String) CommonTools.getNonnullValue(r100, new b(), "")) + ",url=" + ((String) CommonTools.getNonnullValue(r100, new c(), "")) + ",userKey=" + ((String) CommonTools.getNonnullValue(r100, new d(), "")));
    L5:
        CommonTools.getThreadExecutorService().execute(new AnonymousClass1(this, r100));
    }

    public void suspend(long r100) {
        Map<Long, ITask> r101 = this.mTaskMap;
        monitor-enter(r101);
        ITask r102 = this.mTaskMap.get(Long.valueOf(r100));     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.suspend();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean access$000(Uploader r100, String r101) {
        return r100.isFilePathExist(r101);
    }

    public static /* synthetic */ void access$200(Uploader r100, ITask r101) {
        r100.addTaskMap(r101);
    }

    public static /* synthetic */ void access$300(Uploader r100, String r101) {
        r100.deleteFromSet(r101);
    }

    public static /* synthetic */ void access$400(Uploader r100, long r101) {
        r100.deleteTaskMap(r101);
    }

    public String getLanCurrDevIp(String r100, boolean r110) {
        if (CommonTools.isMainThread() == false) goto L5;
        return "";
    L5:
        String r101 = DiscoveryManager.getInstance(this.mContext).getIpv4(r100);
        if (r101 != null) goto L8;
    L12:
        return "";
    L8:
        if (r101.isEmpty() == true) goto L12;
        Parameters r102 = new Parameters(1, r101, "query", null, null);
        r102.setIsHttp(r110);
        return new Task(r102, this.mContext).getCurrDevIp();
    }

    public ResultInfo queryServerDiskSize(String r210, boolean r211) {
        if (CommonTools.isMainThread() == true) goto L5;
        Parameters r100 = new Parameters(1, r210, "query", null, null);
        r100.setIsHttp(r211);
        return new Task(r100, this.mContext).queryServerDisk();
    L5:
        return new ResultInfo(0, 0, 0, 40003, r210, "", "Not allowed on main thread", 0, 0, "");
    }

    public void addNewServerInfo(String r100, String r101, int r102) {
        DiscoveryManager.getInstance(this.mContext).addNewServerInfo(r100, r101, r102);
    }

    public boolean isKeepAliveReachable(String r100, boolean r101, boolean r102) {
        if (CommonTools.isMainThread() == false) goto L7;
        return false;
    L7:
        return DiscoveryManager.getInstance(this.mContext).isReachable(r100, r101, r102);
    }

    public void startDiscoveryLanDev(boolean r100, List<String> r101, IServerStatusChange r102, boolean r103) {
        DiscoveryManager.getInstance(this.mContext).startDiscovery(r100, r101, r102, r103);
    }

    public ResultInfo delete(String r310, long r311, String r312, String r410, boolean r411) {
        if (CommonTools.isMainThread() == true) goto L5;
        if (r310 == null) goto L25;
        if (r410 == null) goto L25;
        if (r410.isEmpty() == true) goto L25;
        suspend(r311);
        Parameters r100 = new Parameters(1, r310, r410, null, null);
        if (r312 != null) goto L14;
    L26:
        r100.setMd5(CommonTools.md5Hex(r100.getFilePath(), this.mContext));     // Catch: Exception -> L21
    L19:
        r100.setIsHttp(r411);
        return new Task(r100, this.mContext).delete();
    L21:
        e = move-exception;
        return new ResultInfo(r311, 0, 0, 40002, r310, r410, e.toString(), 0, 0, "");
    L14:
        if (r312.length() <= 0) goto L26;
        r100.setMd5(r312);
    L25:
        return new ResultInfo(r311, 0, 0, 40002, r310, r410, "parameters error", 0, 0, "");
    L5:
        return new ResultInfo(r311, 0, 0, 40002, r310, r410, "Not allowed on main thread", 0, 0, "");
    }
}
