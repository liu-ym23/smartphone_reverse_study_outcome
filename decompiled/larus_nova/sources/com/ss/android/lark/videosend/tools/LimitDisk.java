package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/videosend/tools/LimitDisk;", "", "freeSize", "", "freeMultiple", "", "freeMaxFactor", "<init>", "(JII)V", "getFreeSize", "()J", "setFreeSize", "(J)V", "getFreeMultiple", "()I", "setFreeMultiple", "(I)V", "getFreeMaxFactor", "setFreeMaxFactor", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LimitDisk {

    @SerializedName("free_max_factor")
    private int freeMaxFactor;

    @SerializedName("free_multiple")
    private int freeMultiple;

    @SerializedName("free_size")
    private long freeSize;

    public LimitDisk() {
        this(0, 0, 0, 7, null);
    }

    public final int getFreeMaxFactor() {
        return this.freeMaxFactor;
    }

    public final int getFreeMultiple() {
        return this.freeMultiple;
    }

    public final long getFreeSize() {
        return this.freeSize;
    }

    public final void setFreeMaxFactor(int r100) {
        this.freeMaxFactor = r100;
    }

    public final void setFreeMultiple(int r100) {
        this.freeMultiple = r100;
    }

    public final void setFreeSize(long r100) {
        this.freeSize = r100;
    }

    public LimitDisk(long r100, int r101, int r102) {
        this.freeSize = r100;
        this.freeMultiple = r101;
        this.freeMaxFactor = r102;
    }

    public /* synthetic */ LimitDisk(long r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 157286400;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 3;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 2;
    L11:
        this(r100, r101, r102);
    }
}
