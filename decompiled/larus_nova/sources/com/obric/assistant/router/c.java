package com.obric.assistant.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements q97.a {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        String r104 = k0.a(r103);
        if (Intrinsics.areEqual(r104, "//flow/chat_multi_tab") == false) goto L11;
    L14:
        return true;
    L11:
        if (Intrinsics.areEqual(r104, "//flow/chat_page_double_tab") == true) goto L14;
        return false;
    L7:
        r103 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        Bundle r100 = null;
        if (r111 == null) goto L7;
        Intent r101 = r111.f267528b;
        if (r101 == null) goto L7;
        Bundle r102 = r101.getExtras();
    L8:
        String r103 = "";
        if (r102 == null) goto L15;
        String r104 = r102.getString("argConversationId", "");
        if (r104 == null) goto L15;
        r103 = r104;
    L15:
        if (r102 == null) goto L17;
        Integer r105 = Integer.valueOf(r102.getInt("argBotConversationType", -1));
    L19:
        if (r105 != null) goto L22;
    L28:
        if (r105 == null) goto L33;
        if (r105.intValue() != 1) goto L33;
    L36:
        boolean r106 = true;
    L37:
        FLogger.f375446a.i("ObricMultiTabChatPageRouterInterceptor", "onInterceptRoute isMainBot = " + r106 + ", conversationId = " + r103 + ", conversationType = " + r105);
        if (r106 == false) goto L46;
        i r112 = SmartRouter.buildRoute(r110, "//flow/chat_page");
        if (r111 == null) goto L44;
        Intent r113 = r111.f267528b;
        if (r113 == null) goto L44;
        r100 = r113.getExtras();
    L44:
        r112.f267554c.putExtras(r100);
        r112.d();
        return true;
    L46:
        return false;
    L33:
        if (com.larus.bmhome.utils.i.g(r103) == true) goto L36;
        r106 = false;
        goto L37
    L22:
        if (r105.intValue() != (-1)) goto L28;
        if (r103.length() != 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == true) goto L36;
    L26:
        r107 = false;
        goto L27
    L17:
        r105 = null;
    L7:
        r102 = null;
        goto L8
    }
}
