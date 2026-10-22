package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d5 {
    private final e device;
    private final String fileName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f337616id;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private final String f337617md5;
    private final long size;
    private final int type;
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d5) == true) goto L8;
        return false;
    L8:
        d5 r101 = (d5) r100;
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
        return false;
    L12:
        if (this.f337616id == r101.f337616id) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L21;
        return false;
    L21:
        if (this.size == r101.size) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f337617md5, r101.f337617md5) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.device.hashCode() * 31;
        long r101 = this.f337616id;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.version.hashCode()) * 31) + this.type) * 31;
        long r103 = this.size;
        return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f337617md5.hashCode()) * 31) + this.fileName.hashCode();
    }

    public final String toString() {
        return "PackageIdentity(device=" + this.device + ", id=" + this.f337616id + ", version=" + this.version + ", type=" + this.type + ", size=" + this.size + ", md5=" + this.f337617md5 + ", fileName=" + this.fileName + ')';
    }

    public final e a() {
        return this.device;
    }

    public final String b() {
        return this.fileName;
    }

    public final long c() {
        return this.f337616id;
    }

    public final String d() {
        return this.f337617md5;
    }

    public final long e() {
        return this.size;
    }

    public final String f() {
        return this.version;
    }

    public final int getType() {
        return this.type;
    }

    public d5(e r100, long r101, String r102, int r103, long r104, String r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, "device");
        Intrinsics.checkNotNullParameter(r102, "version");
        Intrinsics.checkNotNullParameter(r105, "md5");
        Intrinsics.checkNotNullParameter(r110, "fileName");
        this.device = r100;
        this.f337616id = r101;
        this.version = r102;
        this.type = r103;
        this.size = r104;
        this.f337617md5 = r105;
        this.fileName = r110;
    }
}
