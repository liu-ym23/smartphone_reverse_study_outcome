package com.larus.bmhome.chat.outerinput;

import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f308425a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        switch(r100.hashCode()) {
            case -1462439438: goto L28;
            case -1039689911: goto L24;
            case -759341044: goto L20;
            case -503960960: goto L16;
            case -296727360: goto L13;
            case 400628625: goto L10;
            case 1619864869: goto L6;
            default: goto L31;
        };
    L31:
        return "";
    L6:
        if (r100.equals("chat_list") == false) goto L31;
        return "chat_list_input";
    L10:
        if (r100.equals("aweme_feed_dialog") == false) goto L31;
    L22:
        return "chat_feed_tab";
    L13:
        if (r100.equals("aweeme_feed_fragment") == true) goto L22;
    L16:
        if (r100.equals("bot_list_profile") == false) goto L31;
        return "bot_list_profile_input";
    L20:
        if (r100.equals("aweme_feed_conversation") == true) goto L22;
    L24:
        if (r100.equals("notify") == false) goto L31;
        return "notify_input";
    L28:
        if (r100.equals("bot_list_discover") == false) goto L31;
        return "bot_list_discover_input";
    }

    public static boolean b(com.bytedance.router.c r100) {
        if (r100 == null) goto L10;
        Intent r101 = r100.f267528b;
        if (r101 == null) goto L10;
        Bundle r102 = r101.getExtras();
        if (r102 == null) goto L10;
        if (r102.containsKey("arg_outer_input_event_id") != true) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean c(com.bytedance.router.c r100) {
        if (r100 == null) goto L8;
        Intent r101 = r100.f267528b;
        if (r101 == null) goto L8;
        Bundle r102 = r101.getExtras();
        if (r102 == null) goto L8;
        String r103 = r102.getString("arg_outer_input_tab_key");
    L10:
        if (Intrinsics.areEqual(r103, "aweme_feed_dialog") == false) goto L12;
    L15:
        return true;
    L12:
        if (Intrinsics.areEqual(r103, "aweeme_feed_fragment") == true) goto L15;
        return false;
    L8:
        r103 = null;
        goto L10
    }
}
