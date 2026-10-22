package com.larus.bmhome.chat.component.bottom.voice;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.bmhome.chat.component.bottom.core.c3;
import com.larus.bmhome.chat.component.bottom.core.d3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f300405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f300406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f300407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f300408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f300409e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f300405a, r101.f300405a) == true) goto L12;
        return false;
    L12:
        if (this.f300406b == r101.f300406b) goto L15;
        return false;
    L15:
        if (this.f300407c == r101.f300407c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f300408d, r101.f300408d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f300409e, r101.f300409e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f300405a.hashCode() * 31;
        int r101 = 1231;
        if (this.f300406b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f300407c == true) goto L11;
        r101 = 1237;
    L11:
        return ((((r103 + r101) * 31) + this.f300408d.hashCode()) * 31) + this.f300409e.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SwitchVoiceInputData(textContext=" + this.f300405a + ", disablePanel=" + this.f300406b + ", disableTimeout=" + this.f300407c + ", onTimeout=" + this.f300408d + ", onError=" + this.f300409e + ')';
    }

    public d(String r100, boolean r101, boolean r102, c3 r103, d3 r104) {
        Intrinsics.checkNotNullParameter(r100, "textContext");
        Intrinsics.checkNotNullParameter(r103, "onTimeout");
        Intrinsics.checkNotNullParameter(r104, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f300405a = r100;
        this.f300406b = r101;
        this.f300407c = r102;
        this.f300408d = r103;
        this.f300409e = r104;
    }
}
