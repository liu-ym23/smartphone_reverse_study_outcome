package com.larus.voicecall.impl.scene;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.SceneModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SceneModel f378735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f378736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f378737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f378738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f378739e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f378735a, r101.f378735a) == true) goto L12;
        return false;
    L12:
        if (this.f378736b == r101.f378736b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f378737c, r101.f378737c) == true) goto L18;
        return false;
    L18:
        if (this.f378738d == r101.f378738d) goto L21;
        return false;
    L21:
        if (this.f378739e == r101.f378739e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f378735a.hashCode() * 31) + this.f378736b) * 31;
        Integer r101 = this.f378737c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f378738d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f378739e == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SceneDisplayItem(model=" + this.f378735a + ", status=" + this.f378736b + ", clickTraceId=" + this.f378737c + ", disableExit=" + this.f378738d + ", disableChange=" + this.f378739e + ')';
    }

    public static m a(m r100, int r101, Integer r102, int r110) {
        if ((r110 & 1) == 0) goto L5;
        SceneModel r103 = r100.f378735a;
    L6:
        SceneModel r104 = r103;
        if ((r110 & 2) == 0) goto L9;
        r101 = r100.f378736b;
    L9:
        int r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        r102 = r100.f378737c;
    L12:
        Integer r106 = r102;
        if ((r110 & 8) == 0) goto L15;
        boolean r107 = r100.f378738d;
    L17:
        if ((r110 & 16) == 0) goto L19;
        boolean r108 = r100.f378739e;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return new m(r104, r105, r106, r107, r108);
    L19:
        r108 = false;
        goto L20
    L15:
        r107 = false;
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    public m(SceneModel r100, int r101, Integer r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f378735a = r100;
        this.f378736b = r101;
        this.f378737c = r102;
        this.f378738d = r103;
        this.f378739e = r104;
    }
}
