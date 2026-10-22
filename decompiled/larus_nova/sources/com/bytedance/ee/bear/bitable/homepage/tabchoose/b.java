package com.bytedance.ee.bear.bitable.homepage.tabchoose;

import com.google.gson.Gson;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f213093a = 0;

    static {
    }

    @JvmStatic
    public static final void a(BitableTabData r100) {
        Intrinsics.checkNotNullParameter(r100, "tabData");
        String r101 = new Gson().toJson(r100);     // Catch: Exception -> L5
    L7:
        if (r101 == null) goto L12;
        int r102 = com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.f210602a;
        com.bytedance.ee.bear.bitable.core.usercomponent.b.a().xd().putString("bitable_tab_datav1", r101);
        return;
    L12:
        return;
    L5:
        e = move-exception;
        tt5.a.d("BitableTabChooseStorage", "toJson fail: " + e);
        r101 = null;
        goto L7
    }
}
