package com.larus.im.internal.jni.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/im/internal/jni/model/OmniAVVideoPlaneData;", "", "data", "", "stride", "", "<init>", "([BI)V", "getData", "()[B", "getStride", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAVVideoPlaneData {
    private final byte[] data;
    private final int stride;

    public static /* synthetic */ OmniAVVideoPlaneData copy$default(OmniAVVideoPlaneData r100, byte[] r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.stride;
    L9:
        return r100.copy(r101, r102);
    }

    public final byte[] component1() {
        return this.data;
    }

    public final int component2() {
        return this.stride;
    }

    public final OmniAVVideoPlaneData copy(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new OmniAVVideoPlaneData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAVVideoPlaneData) == true) goto L8;
        return false;
    L8:
        OmniAVVideoPlaneData r101 = (OmniAVVideoPlaneData) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.stride == r101.stride) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.data) * 31) + this.stride;
    }

    public String toString() {
        return "OmniAVVideoPlaneData(data=" + Arrays.toString(this.data) + ", stride=" + this.stride + ')';
    }

    public final byte[] getData() {
        return this.data;
    }

    public final int getStride() {
        return this.stride;
    }

    public OmniAVVideoPlaneData(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
        this.stride = r101;
    }
}
