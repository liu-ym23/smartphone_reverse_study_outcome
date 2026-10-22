package com.bytedance.geckox.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/model/GeckoMd5Check;", "", "md5", "", "(Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class GeckoMd5Check {

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private final String f245084md5;

    public static /* synthetic */ GeckoMd5Check copy$default(GeckoMd5Check r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.f245084md5;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.f245084md5;
    }

    public final GeckoMd5Check copy(String r100) {
        return new GeckoMd5Check(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GeckoMd5Check) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f245084md5, ((GeckoMd5Check) r100).f245084md5) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.f245084md5;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "GeckoMd5Check(md5=" + this.f245084md5 + ")";
    }

    public final String getMd5() {
        return this.f245084md5;
    }

    public GeckoMd5Check(String r100) {
        this.f245084md5 = r100;
    }
}
