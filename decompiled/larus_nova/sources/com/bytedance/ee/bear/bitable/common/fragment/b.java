package com.bytedance.ee.bear.bitable.common.fragment;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f209834a = 0;

    static {
        int r100 = IActionPanelFragmentSetting.f209829r1;
    }

    public static /* synthetic */ Fragment a(IActionPanelFragmentSetting r100, Class r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        String r104 = r102;
        if ((r103 & 16) == 0) goto L8;
        boolean r105 = true;
    L10:
        return r100.NG(r101, r104, null, null, r105);
    L8:
        r105 = false;
        goto L10
    }

    public static /* synthetic */ void b(IActionPanelFragmentSetting r100, Class r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.A40(r101, r102, null);
    }

    public static /* synthetic */ void c(IActionPanelFragmentSetting r100, Float r101, Float r102, Float r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = Float.valueOf(0.8f);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = Float.valueOf(0.45f);
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = Float.valueOf(0.8f);
    L11:
        r100.dn(r101, r102, r103);
    }
}
