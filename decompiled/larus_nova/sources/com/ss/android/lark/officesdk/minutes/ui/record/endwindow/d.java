package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c f435870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f435871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435872c;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f435870a, r101.f435870a) == true) goto L12;
        return false;
    L12:
        if (this.f435871b == r101.f435871b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435872c, r101.f435872c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f435870a.hashCode() * 31;
        if (this.f435871b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f435872c.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmEndWindowVMState(entity=" + this.f435870a + ", isLoading=" + this.f435871b + ", url=" + this.f435872c + ')';
    }

    public /* synthetic */ d(int r100) {
        this(new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c(0), true, "");
    }

    public d(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        Intrinsics.checkNotNullParameter(r102, "url");
        this.f435870a = r100;
        this.f435871b = r101;
        this.f435872c = r102;
    }

    public static d a(d r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.f435870a;
    L6:
        if ((r102 & 2) == 0) goto L8;
        boolean r103 = r100.f435871b;
    L10:
        if ((r102 & 4) == 0) goto L12;
        String r104 = r100.f435872c;
    L13:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "entity");
        Intrinsics.checkNotNullParameter(r104, "url");
        return new d(r101, r103, r104);
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = false;
        goto L10
    }
}
