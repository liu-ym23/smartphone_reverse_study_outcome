package com.larus.home.impl.main.side_bar.view.group.render;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f345730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eb9.e f345731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<List<eb9.d>> f345732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f345733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f345734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f345735f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f345730a, r101.f345730a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345731b, r101.f345731b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f345732c, r101.f345732c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f345733d, r101.f345733d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f345734e, r101.f345734e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f345735f, r101.f345735f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f345730a.hashCode() * 31) + this.f345731b.hashCode()) * 31) + this.f345732c.hashCode()) * 31;
        Function0<Unit> r101 = this.f345733d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f345734e.hashCode()) * 31) + this.f345735f.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "GroupHeaderConfig(id=" + this.f345730a + ", title=" + this.f345731b + ", actionItems=" + this.f345732c + ", inlineAction=" + this.f345733d + ", onActionMenuShow=" + this.f345734e + ", onShow=" + this.f345735f + ')';
    }

    public y(String r100, eb9.e r101, com.larus.home.impl.main.side_bar.view.group.module.d0 r102, Function0 r103, Function0 r104, com.larus.home.impl.main.side_bar.view.group.module.e0 r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "actionItems");
        Intrinsics.checkNotNullParameter(r104, "onActionMenuShow");
        Intrinsics.checkNotNullParameter(r105, SendEventContainerMethodParamModel.EventKinds.onShow);
        this.f345730a = r100;
        this.f345731b = r101;
        this.f345732c = r102;
        this.f345733d = r103;
        this.f345734e = r104;
        this.f345735f = r105;
    }
}
