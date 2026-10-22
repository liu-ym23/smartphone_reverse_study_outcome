package com.ss.android.lark.contact.customized.common;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418964a = 0;

    static {
    }

    public static void b() {
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Intrinsics.checkNotNullParameter(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, "enterMethod");
        Intrinsics.checkNotNullParameter("contact", "functionType");
        Statistics.sendEvent("click_search_button", new JSONObject().put("current_page", "profile_add_friend").put("enter_method", DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON).put("function_type", "contact"));
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Statistics.sendEvent("click_add_friend", new JSONObject().put("current_page", r100).put("enter_method", r101));
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Statistics.sendEvent(CheckPointType.ENTER_PAGE, new JSONObject().put("current_page", r100).put("enter_method", r101));
    }
}
