package com.larus.platform.model.chat;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/larus/platform/model/chat/BDVideoUploaderConfig;", "", "socketNum", "", "sliceRetryCount", "fileRetryCount", "maxRetryTimeoutSeconds", "customNetConnectTimeoutSeconds", "customNetReadTimeoutSeconds", "customNetWriteTimeoutSeconds", "customNetTotalRequestTimeoutSeconds", "<init>", "(IIIIIIII)V", "getSocketNum", "()I", "getSliceRetryCount", "getFileRetryCount", "getMaxRetryTimeoutSeconds", "getCustomNetConnectTimeoutSeconds", "getCustomNetReadTimeoutSeconds", "getCustomNetWriteTimeoutSeconds", "getCustomNetTotalRequestTimeoutSeconds", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("custom_net_connect_timeout_s")
    private final int customNetConnectTimeoutSeconds;

    @SerializedName("custom_net_read_timeout_s")
    private final int customNetReadTimeoutSeconds;

    @SerializedName("custom_net_total_request_timeout_s")
    private final int customNetTotalRequestTimeoutSeconds;

    @SerializedName("custom_net_write_timeout_s")
    private final int customNetWriteTimeoutSeconds;

    @SerializedName("file_retry_count")
    private final int fileRetryCount;

    @SerializedName("max_retry_timeout_s")
    private final int maxRetryTimeoutSeconds;

    @SerializedName("slice_retry_count")
    private final int sliceRetryCount;

    @SerializedName("socket_num")
    private final int socketNum;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.socketNum == r101.socketNum) goto L12;
        return false;
    L12:
        if (this.sliceRetryCount == r101.sliceRetryCount) goto L15;
        return false;
    L15:
        if (this.fileRetryCount == r101.fileRetryCount) goto L18;
        return false;
    L18:
        if (this.maxRetryTimeoutSeconds == r101.maxRetryTimeoutSeconds) goto L21;
        return false;
    L21:
        if (this.customNetConnectTimeoutSeconds == r101.customNetConnectTimeoutSeconds) goto L24;
        return false;
    L24:
        if (this.customNetReadTimeoutSeconds == r101.customNetReadTimeoutSeconds) goto L27;
        return false;
    L27:
        if (this.customNetWriteTimeoutSeconds == r101.customNetWriteTimeoutSeconds) goto L30;
        return false;
    L30:
        if (this.customNetTotalRequestTimeoutSeconds == r101.customNetTotalRequestTimeoutSeconds) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.socketNum * 31) + this.sliceRetryCount) * 31) + this.fileRetryCount) * 31) + this.maxRetryTimeoutSeconds) * 31) + this.customNetConnectTimeoutSeconds) * 31) + this.customNetReadTimeoutSeconds) * 31) + this.customNetWriteTimeoutSeconds) * 31) + this.customNetTotalRequestTimeoutSeconds;
    }

    public final String toString() {
        return "BDVideoUploaderConfig(socketNum=" + this.socketNum + ", sliceRetryCount=" + this.sliceRetryCount + ", fileRetryCount=" + this.fileRetryCount + ", maxRetryTimeoutSeconds=" + this.maxRetryTimeoutSeconds + ", customNetConnectTimeoutSeconds=" + this.customNetConnectTimeoutSeconds + ", customNetReadTimeoutSeconds=" + this.customNetReadTimeoutSeconds + ", customNetWriteTimeoutSeconds=" + this.customNetWriteTimeoutSeconds + ", customNetTotalRequestTimeoutSeconds=" + this.customNetTotalRequestTimeoutSeconds + ')';
    }

    public final int a() {
        return this.customNetConnectTimeoutSeconds;
    }

    public final int b() {
        return this.customNetReadTimeoutSeconds;
    }

    public final int c() {
        return this.customNetTotalRequestTimeoutSeconds;
    }

    public final int d() {
        return this.customNetWriteTimeoutSeconds;
    }

    public final int e() {
        return this.fileRetryCount;
    }

    public final int f() {
        return this.maxRetryTimeoutSeconds;
    }

    public final int g() {
        return this.sliceRetryCount;
    }

    public final int h() {
        return this.socketNum;
    }

    public /* synthetic */ e(int r110) {
        this(4, 5, 10, 7200, 70, 60, 120, AnnouncementViewModel.HOUR_DURATION);
    }

    public e(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.socketNum = r100;
        this.sliceRetryCount = r101;
        this.fileRetryCount = r102;
        this.maxRetryTimeoutSeconds = r103;
        this.customNetConnectTimeoutSeconds = r104;
        this.customNetReadTimeoutSeconds = r105;
        this.customNetWriteTimeoutSeconds = r106;
        this.customNetTotalRequestTimeoutSeconds = r107;
    }
}
