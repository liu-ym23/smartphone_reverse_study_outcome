package com.obric.assistant.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.n4;
import com.larus.bmhome.utils.i;
import com.larus.common.apphost.AppHost;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.spi.chat.ObricInteractionServiceDelegate;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements q97.a {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        return Intrinsics.areEqual(k0.a(r103), "//flow/chat_page");
    L7:
        r103 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r8v7, types: [T, android.app.Activity, java.lang.Object] */
    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        Activity r100 = null;
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
        if (r111 == null) goto L43;
        Intent r107 = r111.f267528b;
        if (r107 == null) goto L43;
        Bundle r108 = r107.getExtras();
        if (r108 == null) goto L43;
        String r109 = r108.getString("preview_collection_id");
    L44:
        FLogger r112 = FLogger.f375446a;
        r112.i("ObricChatPageRouterInterceptor", "onInterceptRoute isMainBot = " + r106 + ", ConversaitonId = " + r103 + ", ConversaitonType = " + r105 + ", previewCollectionId = " + r109);
        if (r106 == false) goto L71;
        if (r111 == null) goto L50;
        Intent r113 = r111.f267528b;
        if (r113 == null) goto L50;
        int r114 = r113.getFlags();
    L52:
        if ((r114 & 67108864) == 0) goto L71;
        if ((r110 instanceof Activity) == false) goto L56;
        r100 = (Activity) r110;
    L56:
        if (r100 == null) goto L71;
        r112.i("ObricChatPageRouterInterceptor", "mockClearTopForObricChatActivity");
        final int r115 = r100.getTaskId();
        List<Activity> r116 = AppHost.f326268a.a().g();
        final Ref.ObjectRef r117 = new Ref.ObjectRef();
        int r118 = r116.size() - 1;
        if (r118 < 0) goto L68;
    L59:
        int r119 = r118 - 1;
        ?? r120 = (Activity) ListProtector.get(r116, r118);
        if (r120.getTaskId() == r115) goto L62;
    L64:
        if (r119 < 0) goto L68;
        r118 = r119;
        goto L59
    L62:
        if (n4.class.isAssignableFrom(r120.getClass()) == false) goto L64;
        r117.element = r120;
    L68:
        if (r117.element != 0) goto L70;
        FLogger.f375446a.i("ObricChatPageRouterInterceptor", "couldn't find target activity");
        goto L71
    L70:
        SoftReference<Handler> r121 = y.f375498a;
        Runnable r122 = new com.obric.assistant.router.a(r117, r115);
        Intrinsics.checkNotNullParameter(r122, "action");
        y.c(r122);
    L50:
        r114 = 0;
    L71:
        if (r106 == false) goto L87;
        if (r109 != null) goto L74;
    L77:
        boolean r123 = true;
    L78:
        if (r123 == false) goto L87;
        if (r111 == null) goto L83;
        Intent r124 = r111.f267528b;
        if (r124 == null) goto L83;
        r124.putExtra("as_container", ObricInteractionServiceDelegate.f392860b.a());
    L83:
        if (r111 == null) goto L87;
        Intent r125 = r111.f267528b;
        if (r125 == null) goto L87;
        r125.putExtra("obric_allow_show_when_locked", true);
        goto L87
    L74:
        if (r109.length() == 0) goto L77;
        r123 = false;
    L87:
        return false;
    L43:
        r109 = null;
    L33:
        if (i.g(r103) == true) goto L36;
        r106 = false;
        goto L37
    L22:
        if (r105.intValue() != (-1)) goto L28;
        if (r103.length() != 0) goto L26;
        boolean r126 = true;
    L27:
        if (r126 == true) goto L36;
    L26:
        r126 = false;
        goto L27
    L17:
        r105 = null;
    L7:
        r102 = null;
        goto L8
    }
}
