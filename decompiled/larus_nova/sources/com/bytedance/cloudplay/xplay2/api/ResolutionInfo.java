package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/ResolutionInfo;", "", "bitRate", "", "frameRate", "id", "", "name", "resolution", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBitRate", "()I", "getFrameRate", "getId", "()Ljava/lang/String;", "getName", "getResolution", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResolutionInfo {
    private final int bitRate;
    private final int frameRate;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f202789id;
    private final String name;
    private final String resolution;

    public static /* synthetic */ ResolutionInfo copy$default(ResolutionInfo r100, int r101, int r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bitRate;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.frameRate;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.f202789id;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.name;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.resolution;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.bitRate;
    }

    public final int component2() {
        return this.frameRate;
    }

    public final String component3() {
        return this.f202789id;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.resolution;
    }

    public final ResolutionInfo copy(int r100, int r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "resolution");
        return new ResolutionInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResolutionInfo) == true) goto L8;
        return false;
    L8:
        ResolutionInfo r101 = (ResolutionInfo) r100;
        if (this.bitRate == r101.bitRate) goto L12;
        return false;
    L12:
        if (this.frameRate == r101.frameRate) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f202789id, r101.f202789id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resolution, r101.resolution) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.bitRate * 31) + this.frameRate) * 31) + this.f202789id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.resolution.hashCode();
    }

    public String toString() {
        return "ResolutionInfo(bitRate=" + this.bitRate + ", frameRate=" + this.frameRate + ", id=" + this.f202789id + ", name=" + this.name + ", resolution=" + this.resolution + ')';
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final String getId() {
        return this.f202789id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public ResolutionInfo(int r100, int r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r104, "resolution");
        this.bitRate = r100;
        this.frameRate = r101;
        this.f202789id = r102;
        this.name = r103;
        this.resolution = r104;
    }
}
