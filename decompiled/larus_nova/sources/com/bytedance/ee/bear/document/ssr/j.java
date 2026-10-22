package com.bytedance.ee.bear.document.ssr;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.utils.CarUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f221872a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(BearUrl r100) {
        boolean r101 = TextUtils.equals(r100.f222560a, sbb.e.f541304o.getType());
        boolean r102 = z05.i.d(r100.f222564e);
        if (r101 == true) goto L5;
    L8:
        return false;
    L5:
        if (fx4.a.f(r100.f222564e) == true) goto L8;
        if (r102 == true) goto L8;
        return true;
    }

    @JvmStatic
    public static final boolean b(String r100, String r101, boolean r102) {
        if (TextUtils.equals(r101, sbb.e.f541304o.getType()) == true) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r100, "501") == false) goto L8;
    L23:
        tt5.a.h("SsrDataLoader", "docAppId is " + r100);
        return false;
    L8:
        if (TextUtils.equals(r100, "601") == true) goto L23;
        if (r102 == true) goto L12;
    L15:
        String[] r103 = CarUtils.f444655a;
        if (DocOpenConfig.f().enable_low_device == false) goto L18;
        return true;
    L18:
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == false) goto L25;
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
