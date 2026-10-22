package com.larus.home.impl.route;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.larus.bmhome.chat.ChatLandingChannel;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class r0 implements q97.a {
    public r0() {
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        return false;
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r110) {
        if (r110 == null) goto L53;
        String r100 = r110.f267529c;
        boolean r101 = true;
        String r102 = null;
        if (r100 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L27;
        String r104 = r110.f267529c;
        if (r104 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == true) goto L27;
        String r106 = r110.f267529c;
        if (r106 != null) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == true) goto L27;
        r101 = false;
        goto L27
    L21:
        if (StringsKt.contains$default(r106, "//flow/chat_page_double_tab", false, 2, null) != true) goto L23;
        r107 = true;
        goto L24
    L14:
        if (StringsKt.contains$default(r104, "//flow/chat_page_immers", false, 2, null) != true) goto L16;
        r105 = true;
    L27:
        if (r101 == false) goto L53;
        Intent r108 = r110.f267528b;
        if (r108 == null) goto L33;
        Bundle r109 = r108.getExtras();
        if (r109 == null) goto L33;
        String r111 = r109.getString("argConversationId");
    L34:
        Intent r112 = r110.f267528b;
        if (r112 == null) goto L39;
        Bundle r113 = r112.getExtras();
        if (r113 == null) goto L39;
        r102 = r113.getString("argBotId");
    L39:
        String r114 = r102;
        Intent r115 = r110.f267528b;
        if (r115 == null) goto L45;
        Bundle r116 = r115.getExtras();
        if (r116 == null) goto L45;
        String r117 = r116.getString("landing_channel");
        if (r117 == null) goto L45;
    L46:
        String r118 = r117;
        long r119 = SystemClock.elapsedRealtime();
        Intent r120 = r110.f267528b;
        if (r120 == null) goto L49;
        r120.putExtra("enter_session", r119);
    L49:
        com.larus.bmhome.chat.trace.appreciable.f r121 = com.larus.bmhome.chat.trace.appreciable.f.f310120a;
        String r122 = r110.f267529c;
        if (r122 != null) goto L52;
        r122 = "unknown";
    L52:
        com.larus.bmhome.chat.trace.appreciable.f.k(r121, r111, r114, r118, r119, r122);
    L45:
        r117 = ChatLandingChannel.START_OTHER.getChannel();
    L33:
        r111 = null;
        goto L34
    L7:
        if (StringsKt.contains$default(r100, "//flow/chat_page", false, 2, null) != true) goto L9;
        r103 = true;
    L53:
        return false;
    }
}
