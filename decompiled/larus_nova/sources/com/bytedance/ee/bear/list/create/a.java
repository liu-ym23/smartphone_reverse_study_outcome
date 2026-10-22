package com.bytedance.ee.bear.list.create;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f227701a = false;

    static {
        f227701a = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.mindnote_offline_create_enable");
    }

    @JvmStatic
    public static final boolean a(int r100) {
        if (r100 != sbb.e.f541296g.f541317b) goto L5;
    L14:
        return true;
    L5:
        if (r100 == sbb.e.f541297h.f541317b) goto L14;
        if (r100 != sbb.e.f541300k.f541317b) goto L11;
        if (f227701a == true) goto L14;
    L11:
        if (r100 == sbb.e.f541304o.f541317b) goto L14;
        return false;
    }
}
