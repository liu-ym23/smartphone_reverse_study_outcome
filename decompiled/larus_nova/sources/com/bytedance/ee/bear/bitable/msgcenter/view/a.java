package com.bytedance.ee.bear.bitable.msgcenter.view;

import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f214725a = null;

    static {
        f214725a = new HashMap();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        HashMap r101 = new HashMap();
        r101.put("click", r100);
        c("ccm_bitable_notification_click", r101);
    }

    public static void a(BitableMsgCardModel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "click");
        HashMap r102 = new HashMap();
        if (r100.getUnread() == false) goto L5;
        String r103 = "unread";
    L6:
        r102.put("read_status", r103);
        r102.put("template_type", r100.getTemplateType());
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r100.getId());
        r102.put("click", r101);
        c("ccm_bitable_notification_message_click", r102);
        return;
    L5:
        r103 = "read";
        goto L6
    }

    public static void c(String r100, HashMap r101) {
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        if (r101 == null) goto L5;
        r101.putAll(f214725a);
    L5:
        r102.n(r100, r101);
    }
}
