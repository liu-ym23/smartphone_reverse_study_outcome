package com.bytedance.ee.bear.document.ssr;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.utils.CarUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(BearUrl r2) {
        boolean r0 = TextUtils.equals(r2.a, sbb.e.o.getType());
        boolean r1 = z05.i.d(r2.e);
        if (r0 == true) goto L5;
    L8:
        return false;
    L5:
        if (fx4.a.f(r2.e) == true) goto L8;
        if (r1 == true) goto L8;
        return true;
    }

    @JvmStatic
    public static final boolean b(String r2, String r3, boolean r4) {
        if (TextUtils.equals(r3, sbb.e.o.getType()) == true) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r2, "501") == false) goto L8;
    L23:
        tt5.a.h("SsrDataLoader", "docAppId is " + r2);
        return false;
    L8:
        if (TextUtils.equals(r2, "601") == true) goto L23;
        if (r4 == true) goto L12;
    L15:
        String[] r5 = CarUtils.a;
        if (DocOpenConfig.f().enable_low_device == false) goto L18;
        return true;
    L18:
        if (DevicePerfManager.b.a.e.h == false) goto L25;
        tt5.a.h("SsrDataLoader", "isLowDevice = true");
        return false;
    L25:
        return true;
    L12:
        if (idb.f.a().isCurrentEnable("ccm.mobile.wiki_pre_fetch_docx_ssr") == true) goto L15;
        tt5.a.h("SsrDataLoader", "type is wiki and fg is false");
        return false;
    }
}
