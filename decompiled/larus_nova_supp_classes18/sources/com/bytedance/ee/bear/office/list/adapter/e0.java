package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static g0 a(boolean r3) {
        if (r3 == false) goto L4;
        g0 r0 = g0.c.a;
    L5:
        tt5.a.h("OfficeLongPressMoreLikeActionGuard", "more-like availability. action=copy_link, result=" + c(r0) + ", reason=enableCopyLink_" + r3);
        return r0;
    L4:
        r0 = g0.b.a;
        goto L5
    }

    public static String c(g0 r1) {
        if (Intrinsics.areEqual(r1, g0.c.a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r1, g0.b.a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r1 instanceof g0.a) == false) goto L13;
        return "Disabled";
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static g0 e(String r10, Context r11, oj5.c r12) {
        if ((r12 instanceof oj5.a) == false) goto L16;
        oj5.a r0 = (oj5.a) r12;
        if (r0.p == true) goto L8;
        g0.c r13 = g0.c.a;
        b(r10, r12, r13, "not_shortcut");
        return r13;
    L8:
        if (r0.q == false) goto L11;
        g0.a r14 = new g0.a(com.bytedance.ee.bear.more.office.f.c());
        b(r10, r12, r14, "shortcut_origin_deleted");
        return r14;
    L11:
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r0, r0.i.a, "VIEW"), Boolean.TRUE) == true) goto L14;
        g0.a r1 = new g0.a(r11.getString(2131887803));
        b(r10, r12, r1, "shortcut_operation_view_denied");
    L31:
        return r1;
    L14:
        g0.c r15 = g0.c.a;
        b(r10, r12, r15, "shortcut_operation_view_allowed");
        return r15;
    L16:
        if ((r12 instanceof oj5.b) == false) goto L27;
        oj5.b r2 = (oj5.b) r12;
        if (r2.q == true) goto L21;
        g0.c r16 = g0.c.a;
        b(r10, r12, r16, "not_shortcut");
        return r16;
    L21:
        if (r2.r == false) goto L24;
        g0.a r17 = new g0.a(com.bytedance.ee.bear.more.office.f.c());
        b(r10, r12, r17, "shortcut_origin_deleted");
        return r17;
    L24:
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).B(r2, r2.t, "VIEW"), Boolean.TRUE) == true) goto L26;
        r1 = new g0.a(r11.getString(2131887803));
        b(r10, r12, r1, "shortcut_operation_view_denied");
        goto L31
    L26:
        g0.c r18 = g0.c.a;
        b(r10, r12, r18, "shortcut_operation_view_allowed");
        return r18;
    L27:
        g0.c r19 = g0.c.a;
        b(r10, r12, r19, "unsupported_moreInfo_allow");
        return r19;
    }

    public static g0 f(Context r2, oj5.c r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "moreInfo");
        Intrinsics.checkNotNullParameter(r4, "isNetworkConnected");
        if (r3.o() == false) goto L5;
    L13:
        g0.b r5 = g0.b.a;
        b("star", r3, r5, "phoenix_or_origin_deleted");
        return r5;
    L5:
        if (r3.w() == true) goto L13;
        if (((Boolean) r4.invoke()).booleanValue() == true) goto L12;
        g0.a r6 = new g0.a(r2.getString(2131887951));
        b("star", r3, r6, "network_disconnected");
        return r6;
    L12:
        return e("star", r2, r3);
    }

    public static void b(String r2, oj5.c r3, g0 r4, String r5) {
        StringBuilder r0 = new StringBuilder("more-like availability. action=");
        r0.append(r2);
        r0.append(", result=");
        r0.append(c(r4));
        r0.append(", reason=");
        r0.append(r5);
        r0.append(", ");
        StringBuilder r6 = new StringBuilder("moreInfo=");
        r6.append(r3.getClass().getSimpleName());
        r6.append(", token=");
        String r7 = r3.getToken();
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        r6.append(du5.b.k(r7));
        r6.append(", type=");
        r6.append(r3.getType());
        r6.append(", realType=");
        r6.append(r3.i());
        r6.append(", isShortcut=");
        r6.append(r3.E());
        r6.append(", originDeleted=");
        r6.append(r3.w());
        r0.append(r6.toString());
        tt5.a.h("OfficeLongPressMoreLikeActionGuard", r0.toString());
    }

    public static g0 d(Context r1, Document r2, oj5.c r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r3, "moreInfo");
        Intrinsics.checkNotNullParameter(r4, "isNetworkConnected");
        if (((Boolean) r4.invoke()).booleanValue() == true) goto L7;
        g0.a r5 = new g0.a(r1.getString(2131887951));
        b("share", r3, r5, "network_disconnected");
        return r5;
    L7:
        if (r2.Q1 == false) goto L11;
        g0.a r6 = new g0.a(com.bytedance.ee.bear.more.office.f.c());
        b("share", r3, r6, "complaint_file");
        return r6;
    L11:
        return e("share", r1, r3);
    }
}
