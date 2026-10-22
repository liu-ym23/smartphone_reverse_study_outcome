package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animator f394118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f394119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RealtimeCallLifeState f394120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f394121d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f394118a, r101.f394118a) == true) goto L12;
        return false;
    L12:
        if (this.f394119b == r101.f394119b) goto L15;
        return false;
    L15:
        if (this.f394120c == r101.f394120c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f394121d, r101.f394121d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f394118a.hashCode() * 31;
        if (this.f394119b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        RealtimeCallLifeState r103 = this.f394120c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Function0<Unit> r107 = this.f394121d;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AnimationRequest(animator=" + this.f394118a + ", interruptible=" + this.f394119b + ", targetState=" + this.f394120c + ", onCompleted=" + this.f394121d + ')';
    }

    public a(Animator r100, boolean r101, RealtimeCallLifeState r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        this.f394118a = r100;
        this.f394119b = r101;
        this.f394120c = r102;
        this.f394121d = r103;
    }
}
