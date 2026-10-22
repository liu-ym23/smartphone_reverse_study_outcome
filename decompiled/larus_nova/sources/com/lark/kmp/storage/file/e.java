package com.lark.kmp.storage.file;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f282699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lark.kmp.storage.c f282700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends c> f282701c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f282699a, r101.f282699a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282700b, r101.f282700b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f282701c, r101.f282701c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f282699a.hashCode() * 31) + this.f282700b.hashCode()) * 31) + this.f282701c.hashCode();
    }

    public final String toString() {
        return "FileStorageConfig(fileFactory=" + this.f282699a + ", spaceResolver=" + this.f282700b + ", provider=" + this.f282701c + ')';
    }

    public e(b r100, com.lark.kmp.storage.c r101, List<? extends c> r102) {
        Intrinsics.checkNotNullParameter(r100, "fileFactory");
        Intrinsics.checkNotNullParameter(r101, "spaceResolver");
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f282699a = r100;
        this.f282700b = r101;
        this.f282701c = r102;
    }
}
