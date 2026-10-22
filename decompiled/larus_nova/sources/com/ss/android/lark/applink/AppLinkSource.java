package com.ss.android.lark.applink;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public interface AppLinkSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f408917a = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    static {
        f408917a = new String[]{"unknown", "app", "scan", "qrcode", BrowserDependency.UrlClickType.CARD, "p2p_message", "group_message", "mini_program", "webview", "chat", "appcenter", "doc", "thread_topic", "native_open_app", AppConstants.API_HOST_SI_PREFIX, "feed_plus_menu", "vc_tab_function_item", "vc_tab_float_button", "app_side_bar_page", "vc_tab", "app_shortcuts_record", "feed_plus_menu_onboarding"};
    }
}
