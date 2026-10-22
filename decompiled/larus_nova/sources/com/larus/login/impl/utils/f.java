package com.larus.login.impl.utils;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.login.api.TouristManager;
import com.larus.platform.service.AccountService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f358319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f358320b = null;

    static {
        f358319a = LazyKt.lazy(new d());
        f358320b = LazyKt.lazy(new e());
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageStyle");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        r102.put("page_style", r100);
        r102.put("current_page", r101);
        c(CheckPointType.ENTER_PAGE, r102);
    }

    public static void c(String r100, JSONObject r101) {
        List r102 = (List) f358319a.getValue();
        String r103 = ((SimpleDateFormat) f358320b.getValue()).format(new Date());
        Intrinsics.checkNotNull(r103);
        if (TouristManager.f357001a.f() == false) goto L5;
        String r104 = "1";
    L6:
        r101.put("is_tourist_mode", r104);
        r101.put("current_time", r103);
        JSONObject r105 = new JSONObject();
        r105.put(r100, r101);
        r102.add(r105);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public static void a(String r100, boolean r101, boolean r102, boolean r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "verifyType");
        Intrinsics.checkNotNullParameter(r104, "type");
        JSONObject r106 = new JSONObject();
        r106.put("verify_dialog_type", r100);
        r106.put("use_pass", r101 ? 1 : 0);
        r106.put("verify_pass", r102 ? 1 : 0);
        r106.put("request_server_success", r103 ? 1 : 0);
        r106.put("type", r104);
        if (r105 == null) goto L5;
        r106.put("err_code", r105);
    L5:
        c("age_gate_verification_result", r106);
    }
}
