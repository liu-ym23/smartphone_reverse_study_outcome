package com.lark.kmp.storage.kv;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f282704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lark.kmp.storage.c f282705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends b> f282706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Mode f282707d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f282704a, r101.f282704a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282705b, r101.f282705b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f282706c, r101.f282706c) == true) goto L18;
        return false;
    L18:
        if (this.f282707d == r101.f282707d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f282704a.hashCode() * 31) + this.f282705b.hashCode()) * 31) + this.f282706c.hashCode()) * 31;
        Mode r101 = this.f282707d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "KVStorageConfig(kvRepoFactory=" + this.f282704a + ", spaceResolver=" + this.f282705b + ", provider=" + this.f282706c + ", mode=" + this.f282707d + ')';
    }

    public d(a r100, com.lark.kmp.storage.c r101, List<? extends b> r102, Mode r103) {
        Intrinsics.checkNotNullParameter(r100, "kvRepoFactory");
        Intrinsics.checkNotNullParameter(r101, "spaceResolver");
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f282704a = r100;
        this.f282705b = r101;
        this.f282706c = r102;
        this.f282707d = r103;
    }
}
