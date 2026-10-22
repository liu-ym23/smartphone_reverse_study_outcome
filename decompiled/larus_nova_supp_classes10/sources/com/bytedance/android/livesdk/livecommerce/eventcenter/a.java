package com.bytedance.android.livesdk.livecommerce.eventcenter;

import com.bytedance.android.ec.core.utils.w0;
import kotlin.jvm.internal.Intrinsics;
import sl.m;
import sl.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final com.bytedance.android.livesdk.livecommerce.ability.f<?> a(sl.g r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$convert2Standard");
        int r0 = r6.a();
        Object r3 = null;
        if (r0 != 1) goto L5;
        sl.a r1 = r6.b();
        if (r1 != null) goto L20;
        return null;
    L20:
        String r2 = c(r6.a(), r1.a());
        String r4 = "";
        switch(r2.hashCode()) {
            case -1236338690: goto L51;
            case -826929628: goto L42;
            case 804212474: goto L33;
            case 1045365711: goto L24;
            default: goto L60;
        };
    L24:
        if (r2.equals("add_cart_jump") == false) goto L60;
        int r5 = w0.a;
        sl.a r7 = r6.b();
        if (r7 == null) goto L31;
        String r8 = r7.b();
        if (r8 == null) goto L31;
        r4 = r8;
    L31:
        r3 = w0.b(r4, sl.c.class);
        goto L60
    L33:
        if (r2.equals("add_cart_open_page_list") == false) goto L60;
        int r9 = w0.a;
        sl.a r10 = r6.b();
        if (r10 == null) goto L40;
        String r11 = r10.b();
        if (r11 == null) goto L40;
        r4 = r11;
    L40:
        r3 = w0.b(r4, sl.d.class);
        goto L60
    L42:
        if (r2.equals("open_page_list_show_dialog") == false) goto L60;
        int r12 = w0.a;
        sl.a r13 = r6.b();
        if (r13 == null) goto L49;
        String r14 = r13.b();
        if (r14 == null) goto L49;
        r4 = r14;
    L49:
        r3 = w0.b(r4, sl.f.class);
        goto L60
    L51:
        if (r2.equals("add_cart") == false) goto L60;
        int r15 = w0.a;
        sl.a r16 = r6.b();
        if (r16 == null) goto L58;
        String r17 = r16.b();
        if (r17 == null) goto L58;
        r4 = r17;
    L58:
        r3 = w0.b(r4, sl.b.class);
    L60:
        return new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", r2, r3);
    L5:
        if (r0 != 3) goto L7;
        sl.k r18 = r6.c();
        if (r18 != null) goto L16;
        return null;
    L16:
        return new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", c(r6.a(), null), r18);
    L7:
        if (r0 == 4) goto L9;
        return null;
    L9:
        m r19 = r6.d();
        if (r19 != null) goto L12;
        return null;
    L12:
        return new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", c(r6.a(), null), new n(r19.a(), r19.b(), 4));
    }

    public static final Object b(String r3, sl.h r4) {
        String r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = r3.hashCode();
        if (r1 == (-60996298)) goto L19;
        if (r1 == 1779691326) goto L11;
        return null;
    L11:
        if (r3.equals("biz_change_store") == false) goto L29;
        int r5 = w0.a;
        sl.a r6 = r4.b();
        if (r6 == null) goto L16;
        String r7 = r6.b();
        if (r7 == null) goto L16;
    L30:
        return w0.b(r7, sl.e.class);
    L16:
        r7 = "";
        goto L30
    L29:
        return null;
    L19:
        if (r3.equals("open_schema") == false) goto L31;
        m r2 = r4.c();
        if (r2 == null) goto L23;
        int r8 = r2.a();
    L24:
        m r9 = r4.c();
        if (r9 == null) goto L28;
        r0 = r9.b();
    L28:
        return new n(r8, r0, 4);
    L23:
        r8 = 0;
        goto L24
    L31:
        return null;
    }

    public static final String c(int r2, String r3) {
        if (r2 != 1) goto L5;
        if (r3 != null) goto L14;
        return "none";
    L14:
        switch(r3.hashCode()) {
            case -2097270865: goto L29;
            case -811145358: goto L26;
            case -424159202: goto L23;
            case -2350374: goto L20;
            case 462619172: goto L17;
            default: goto L45;
        };
    L45:
        return "none";
    L17:
        if (r3.equals("OPEN_PAGE_LIST_SHOW_DIALOG") == false) goto L34;
        return "open_page_list_show_dialog";
    L34:
        return "none";
    L20:
        if (r3.equals("ADD_CART_OPEN_PAGE_LIST") == false) goto L36;
        return "add_cart_open_page_list";
    L36:
        return "none";
    L23:
        if (r3.equals("ADD_CART") == false) goto L38;
        return "add_cart";
    L38:
        return "none";
    L26:
        if (r3.equals("CHANGE_STORE") == false) goto L40;
        return "biz_change_store";
    L40:
        return "none";
    L29:
        if (r3.equals("ADD_CART_JUMP") == false) goto L42;
        return "add_cart_jump";
    L42:
        return "none";
    L5:
        if (r2 != 3) goto L7;
        return "show_dialog";
    L7:
        if (r2 != 4) goto L43;
        return "open_schema";
    L43:
        return "none";
    }
}
