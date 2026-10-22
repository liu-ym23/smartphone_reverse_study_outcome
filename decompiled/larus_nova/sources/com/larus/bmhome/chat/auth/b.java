package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.auth.model.PluginAuthType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b extends com.larus.bmhome.chat.auth.a implements hc8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297312a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f297313a = null;

        static {
            int[] r100 = new int[PluginAuthType.values().length];
            r100[PluginAuthType.Always.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PluginAuthType.Once.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PluginAuthType.Deny.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PluginAuthType.Ask.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f297313a = r100;
        }
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f297312a = r100;
    }

    public static String i(PluginAuthType r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 != 1) goto L8;
        return "always_allow";
    L8:
        if (r101 != 2) goto L10;
        return "allow_once";
    L10:
        if (r101 != 3) goto L12;
    L14:
        return "decline";
    L12:
        if (r101 == 4) goto L14;
        return "close";
    L4:
        r101 = a.f297313a[r100.ordinal()];
        goto L6
    }

    public static String j(PluginAuthType r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 != 1) goto L8;
        return "always_allow";
    L8:
        if (r101 == 2) goto L10;
        return "null";
    L10:
        return "allow_once";
    L4:
        r101 = a.f297313a[r100.ordinal()];
        goto L6
    }

    public final void h(String r110, String r111, PluginAuthType r112, PluginAuthType r113) {
        Intrinsics.checkNotNullParameter(r110, "pluginName");
        Intrinsics.checkNotNullParameter(r111, "pluginId");
        Intrinsics.checkNotNullParameter("bot_setting", "previousPage");
        c("plugin_management", "bot_setting", r110, r111, null, null, this.f297312a, j(r112), i(r113));
    }

    @Override // hc8.a
    public final void a(String r110, String r111, String r112, String r113, String r114, PluginAuthType r115) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "pluginName");
        Intrinsics.checkNotNullParameter(r113, "pluginId");
        Intrinsics.checkNotNullParameter(r114, "previousPage");
        e("chat", r114, r112, r113, r110, r111, this.f297312a, j(r115));
    }

    @Override // hc8.a
    public final void b(String r110, String r111, String r112, String r113, String r114, PluginAuthType r115, PluginAuthType r116) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "pluginName");
        Intrinsics.checkNotNullParameter(r113, "pluginId");
        Intrinsics.checkNotNullParameter(r114, "previousPage");
        Intrinsics.checkNotNullParameter(r116, "clickAuthType");
        c("chat", r114, r112, r113, r110, r111, this.f297312a, j(r115), i(r116));
    }

    public final void g(String r110, String r111, String r112, String r113, String r114, PluginAuthType r115, PluginAuthType r116) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "pluginName");
        Intrinsics.checkNotNullParameter(r113, "pluginId");
        Intrinsics.checkNotNullParameter(r114, "previousPage");
        c("chat_detail_page", r114, r112, r113, r110, r111, this.f297312a, j(r115), i(r116));
    }
}
