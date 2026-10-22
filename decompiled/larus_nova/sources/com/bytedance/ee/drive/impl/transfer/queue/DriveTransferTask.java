package com.bytedance.ee.drive.impl.transfer.queue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.drive.model.transfer.IDriveTransferTask;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.EncryptUtil;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0000H\u0096\u0002J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u000e\u00102\u001a\n\u0018\u000103j\u0004\u0018\u0001`4H\u0007J\b\u00105\u001a\u00020/H\u0007J\b\u00106\u001a\u00020/H\u0007J\b\u00107\u001a\u00020/H\u0007J\b\u00108\u001a\u00020\u0005H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0006R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0006R\u0010\u0010!\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\u000eR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0012¨\u00069"}, d2 = {"Lcom/bytedance/ee/drive/impl/transfer/queue/DriveTransferTask;", "Lcom/bytedance/ee/drive/model/transfer/IDriveTransferTask;", "Ljava/io/Serializable;", "", "logTag", "", "(Ljava/lang/String;)V", "createTimeMs", "", "getCreateTimeMs", "()J", "finishTimeMs", "getFinishTimeMs", "setFinishTimeMs", "(J)V", "value", "localPath", "getLocalPath", "()Ljava/lang/String;", "setLocalPath", "localPathEncrypted", "pendingTimeMs", "getPendingTimeMs", "setPendingTimeMs", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "remoteUrl", "getRemoteUrl", "setRemoteUrl", "remoteUrlEncrypted", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "statusLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/drive/model/transfer/IDriveTransferTask$EStatus;", "getStatusLiveData", "()Landroidx/lifecycle/MutableLiveData;", DBDefinition.TASK_ID, "getTaskId", "compareTo", "other", "onFinished", "", "isSuccess", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onPending", "onStopped", "onTransferring", "toString", "drive-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class DriveTransferTask implements IDriveTransferTask, Serializable, Comparable<DriveTransferTask> {
    private final long createTimeMs;
    private long finishTimeMs;
    private String localPath;
    private String localPathEncrypted;
    private final String logTag;
    private long pendingTimeMs;
    private int priority;
    private String remoteUrl;
    private String remoteUrlEncrypted;
    private long startTimeMs;
    private final MutableLiveData<IDriveTransferTask.EStatus> statusLiveData;
    private final String taskId;

    public final void onStopped() {
        Log.i(this.logTag, "onStopped, self: " + this);
        IDriveTransferTask.EStatus r100 = getStatusLiveData().getValue();
        IDriveTransferTask.EStatus r101 = IDriveTransferTask.EStatus.STOPPED;
        if (r100 == r101) goto L6;
        getStatusLiveData().setValue(r101);
        return;
    }

    public String toString() {
        return this.logTag + '(' + hashCode() + "){taskId: " + getTaskId() + ", status: " + getStatusLiveData().getValue() + ", priority: " + getPriority() + ", remoteUrl: " + this.remoteUrlEncrypted + ", localPath: " + this.localPathEncrypted + '}';
    }

    @Override // com.bytedance.ee.drive.model.transfer.IDriveTransferTask
    public /* bridge */ /* synthetic */ LiveData getStatusLiveData() {
        return getStatusLiveData();
    }

    public final void onPending() {
        setPendingTimeMs(System.currentTimeMillis());
        Log.i(this.logTag, "onPending, self: " + this);
        IDriveTransferTask.EStatus r100 = getStatusLiveData().getValue();
        IDriveTransferTask.EStatus r101 = IDriveTransferTask.EStatus.PENDING;
        if (r100 == r101) goto L6;
        getStatusLiveData().setValue(r101);
        return;
    }

    public final void onTransferring() {
        setStartTimeMs(System.currentTimeMillis());
        Log.i(this.logTag, "onTransferring, self: " + this);
        IDriveTransferTask.EStatus r100 = getStatusLiveData().getValue();
        IDriveTransferTask.EStatus r101 = IDriveTransferTask.EStatus.TRANSFERRING;
        if (r100 == r101) goto L6;
        getStatusLiveData().setValue(r101);
        return;
    }

    public long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public long getFinishTimeMs() {
        return this.finishTimeMs;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public long getPendingTimeMs() {
        return this.pendingTimeMs;
    }

    public int getPriority() {
        return this.priority;
    }

    public final String getRemoteUrl() {
        return this.remoteUrl;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    @Override // com.bytedance.ee.drive.model.transfer.IDriveTransferTask
    public String getTaskId() {
        return this.taskId;
    }

    @Override // com.bytedance.ee.drive.model.transfer.IDriveTransferTask
    public MutableLiveData<IDriveTransferTask.EStatus> getStatusLiveData() {
        return this.statusLiveData;
    }

    public DriveTransferTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        this.logTag = r100;
        this.taskId = UUID.randomUUID().toString();
        this.statusLiveData = new MutableLiveData(IDriveTransferTask.EStatus.INIT);
        this.createTimeMs = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DriveTransferTask r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return getPriority() - r100.getPriority();
    }

    public void setFinishTimeMs(long r100) {
        this.finishTimeMs = r100;
    }

    public final void setLocalPath(String r100) {
        this.localPath = r100;
        this.localPathEncrypted = EncryptUtil.maskAllToken(r100);
    }

    public void setPendingTimeMs(long r100) {
        this.pendingTimeMs = r100;
    }

    public void setPriority(int r100) {
        this.priority = r100;
    }

    public final void setRemoteUrl(String r100) {
        this.remoteUrl = r100;
        this.remoteUrlEncrypted = EncryptUtil.maskAllToken(r100);
    }

    public void setStartTimeMs(long r100) {
        this.startTimeMs = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DriveTransferTask r100) {
        return compareTo2(r100);
    }

    public final void onFinished(boolean r100, Exception r101) {
        setFinishTimeMs(System.currentTimeMillis());
        Log.i(this.logTag, "onFinished, isSuccess: " + r100 + ", error: " + r101 + ", self: " + this);
        if (r100 == true) goto L5;
        IDriveTransferTask.EStatus r102 = getStatusLiveData().getValue();
        IDriveTransferTask.EStatus r103 = IDriveTransferTask.EStatus.FAILED;
        if (r102 == r103) goto L13;
        getStatusLiveData().setValue(r103);
        return;
    L13:
        return;
    L5:
        if (getStatusLiveData().getValue() != IDriveTransferTask.EStatus.TRANSFERRING) goto L11;
        getStatusLiveData().setValue(IDriveTransferTask.EStatus.SUCCESS);
        return;
    }
}
