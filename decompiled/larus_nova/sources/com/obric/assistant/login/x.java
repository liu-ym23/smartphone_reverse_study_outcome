package com.obric.assistant.login;

import android.app.Activity;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f390275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f390276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ua7.h, Unit> f390277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<ua7.h, String, Unit> f390278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f390279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f390280f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f390275a, r101.f390275a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390276b, r101.f390276b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390277c, r101.f390277c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f390278d, r101.f390278d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f390279e, r101.f390279e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f390280f, r101.f390280f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f390275a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Activity r104 = this.f390276b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((((((r103 + r101) * 31) + this.f390277c.hashCode()) * 31) + this.f390278d.hashCode()) * 31) + this.f390279e.hashCode()) * 31) + this.f390280f.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricLoginRequest(loginSource=" + this.f390275a + ", activity=" + this.f390276b + ", onSuccess=" + this.f390277c + ", onError=" + this.f390278d + ", authLoginStart=" + this.f390279e + ", authLoginFinish=" + this.f390280f + ')';
    }

    public final Activity getActivity() {
        return this.f390276b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(String r100, Activity r101, Function1<? super ua7.h, Unit> r102, Function2<? super ua7.h, ? super String, Unit> r103, Function0<Unit> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
        Intrinsics.checkNotNullParameter(r104, "authLoginStart");
        Intrinsics.checkNotNullParameter(r105, "authLoginFinish");
        this.f390275a = r100;
        this.f390276b = r101;
        this.f390277c = r102;
        this.f390278d = r103;
        this.f390279e = r104;
        this.f390280f = r105;
    }
}
