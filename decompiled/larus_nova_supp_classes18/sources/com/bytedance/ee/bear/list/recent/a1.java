package com.bytedance.ee.bear.list.recent;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.ContextsKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a1 {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void S6(Document r1);

        void c2(Document r1);
    }

    static {
    }

    @JvmStatic
    public static final void a(Context r11, Document r12, ce5.a r13, CompositeDisposable r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r13, "userComponentAbility");
        int r0 = oj5.d.b;
        oj5.d r1 = oj5.d.a.a(r12.O);
        if (r1 == null) goto L23;
        String r2 = r12.d;
        if (r2 != null) goto L7;
        String r5 = "";
    L8:
        String r3 = r12.G1;
        if (r3 != null) goto L11;
        String r6 = "";
    L12:
        int r7 = r12.y1;
        String r15 = r1.d();
        if (r15 != null) goto L15;
        String r4 = "";
    L16:
        FragmentActivity r16 = ContextsKt.requireActivity(r11);
        if ((r16 instanceof FragmentActivity) == false) goto L24;
        com.bytedance.ee.bear.contract.route.parcelable.a r8 = (com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6);
        FragmentActivity r9 = r16;
        NetService r10 = r13.c;
        if (r14 != null) goto L21;
        r14 = new CompositeDisposable();
    L21:
        r8.q(r4, r5, r6, r7, r9, r10, r14);
        return;
    L24:
        return;
    L15:
        r4 = r15;
        goto L16
    L11:
        r6 = r3;
        goto L12
    L7:
        r5 = r2;
        goto L8
    }

    @JvmStatic
    public static final void b(Context r9, Document r10, ce5.a r11, a r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r12, "handler");
        c(r9, r10, r11, r12, r13, r14, r15, true);
    }

    @JvmStatic
    public static final void c(Context r30, Document r31, ce5.a r32, a r33, String r34, String r35, boolean r36, boolean r37) {
        String r8 = r34;
        Intrinsics.checkNotNullParameter(r30, "context");
        Intrinsics.checkNotNullParameter(r31, "item");
        Intrinsics.checkNotNullParameter(r32, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r33, "handler");
        Boolean r13 = AppInfoUtils.f();
        if (r13.booleanValue() == false) goto L5;
        String r2 = r30.getString(2131889453);
    L6:
        BearUDDialogBuilder r14 = new BearUDDialogBuilder(r30);
        Intrinsics.checkNotNull(r2);
        r14.i(r2);
        r14.a.titleSize(16);
        r14.a.titleGravity(8388611);
        if (r13.booleanValue() == false) goto L10;
        String r1 = r30.getString(2131889414);
        String r17 = "ListAnalysis";
        String r19 = "item";
    L36:
        Intrinsics.checkNotNull(r1);
        r14.f(r1);
        r14.a.messageTextSize(14);
        r14.a.messageGravity(8388611);
        r14.a(BearUDDialogBuilder.ActionBottomOrientation.VERTICAL);
        if (r37 == false) goto L44;
        BearUDDialogBuilder.a r3 = new BearUDDialogBuilder.a();
        r3.a = 2131391777;
        r3.d = 2131106622;
        if (r13.booleanValue() == false) goto L41;
        int r4 = 2131889446;
    L42:
        r3.b = r4;
        r3.f = new b1(r33, r31, r8);
        r14.d(r3);
    L52:
        BearUDDialogBuilder.a r15 = new BearUDDialogBuilder.a();
        r15.a = 2131391778;
        r15.d = 2131102093;
        if (r13.booleanValue() == false) goto L55;
        int r5 = 2131889421;
    L56:
        r15.b = r5;
        r15.f = new c1(r31, r30, r33, r34, r35);
        r14.d(r15);
        BearUDDialogBuilder.a r6 = new BearUDDialogBuilder.a();
        r6.a = 2131391779;
        r6.d = 2131106622;
        if (r13.booleanValue() == false) goto L59;
        int r7 = 2131888904;
    L60:
        r6.b = r7;
        r6.f = null;
        r14.d(r6);
        Dialog r9 = r14.e();
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L94;
        DialogLancet.handleBlockedDialogShow(r9);
    L65:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(r9);
        lc5.f.a r10 = lc5.f.a;
        if (r8 != null) goto L68;
        String r11 = "";
    L69:
        lc5.w r12 = new lc5.w(r11, r31.d, r31.getType(), r31.F);
        Intrinsics.checkNotNullParameter(r12, "param");
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L74
        lc5.f.a.b(r10, new lc5.g(r16, r12.a, r12.b, r12.c, r12.getType(), r12.e, r12.f, r12.g, r12.h));     // Catch: Exception -> L74
        r16.put("is_shared_folder", false);     // Catch: Exception -> L74
        r16.put("delete_content_type", r12.j);     // Catch: Exception -> L74
        r16.put("delete_type", r12.k);     // Catch: Exception -> L74
        r16.put("module", r12.a);     // Catch: Exception -> L74
        com.bytedance.ee.bear.contract.d r0 = lc5.f.a.d();     // Catch: Exception -> L74
        if (r0 == null) goto L76;
        r0.i("ccm_space_delete_or_remove_view", r16);     // Catch: Exception -> L74
    L76:
        String r18 = r17;
    L78:
        if (r36 == false) goto L98;
        lc5.f.a r20 = lc5.f.a;
        if (r8 != null) goto L82;
        r8 = "";
    L82:
        if (r36 == false) goto L84;
        String r21 = "more_btn";
    L85:
        Intrinsics.checkNotNullParameter(r31, r19);
        Intrinsics.checkNotNullParameter("delete", "click");
        Intrinsics.checkNotNullParameter("ccm_space_delete_or_remove_view", "target");
        Intrinsics.checkNotNullParameter(r8, "module");
        Intrinsics.checkNotNullParameter(r21, "viewFrom");
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L88
        lc5.f.a.b(r20, new lc5.g(r110, r8, "recent", r31.d, r31.getType(), r31.F, "", "", ""));     // Catch: Exception -> L88
        r110.put("click", "delete");     // Catch: Exception -> L88
        r110.put("target", "ccm_space_delete_or_remove_view");     // Catch: Exception -> L88
        r110.put("module", r8);     // Catch: Exception -> L88
        r110.put("view_from", r21);     // Catch: Exception -> L88
        tt5.a.b(r18, "report reportRightClickMenuClick, params: " + r110);     // Catch: Exception -> L88
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).a("ccm_space_right_click_menu_click", r110);     // Catch: Exception -> L88
        return;
    L88:
        e = move-exception;
        tt5.a.d(r18, e.getMessage());
        return;
    L84:
        r21 = "right_click";
        goto L85
    L98:
        return;
    L74:
        e = move-exception;
        r18 = r17;
        tt5.a.d(r18, e.getMessage());
        goto L78
    L68:
        r11 = r8;
        goto L69
    L94:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L91
    L64:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L65
    L59:
        r7 = 2131891541;
        goto L60
    L55:
        r5 = 2131889598;
        goto L56
    L41:
        r4 = 2131889602;
        goto L42
    L44:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L46;
        int r22 = 60;
    L47:
        String r23 = String.valueOf(r22);
        if (r13.booleanValue() == false) goto L50;
        String r24 = r30.getString(2131889414);
    L51:
        Intrinsics.checkNotNull(r24);
        r14.f(r24);
        goto L52
    L50:
        r24 = xo5.a.c(r30, 2131886312, "num", r23);
        goto L51
    L46:
        r22 = 30;
        goto L47
    L10:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L12;
        int r25 = 60;
    L13:
        String r26 = String.valueOf(r25);
        String r111 = r30.getString(2131889597);
        r19 = "item";
        if (r31.getType() != 16) goto L34;
        int r27 = oj5.d.b;
        oj5.d r28 = oj5.d.a.a(r31.O);
        if (r28 == null) goto L34;
        Integer r112 = r28.f();
        if (r112 != null) goto L20;
        r17 = "ListAnalysis";
    L27:
        boolean r29 = false;
    L28:
        if (r29 == true) goto L35;
        String r38 = r28.e();
        if (r38 != null) goto L32;
        r38 = "";
    L32:
        r1 = xo5.a.d(r30, 2131889582, MapsKt.mapOf(new Pair[]{TuplesKt.to("WikiSpaceName", r38), TuplesKt.to("num", r26)}));
    L35:
        r1 = xo5.a.d(r30, 2131889599, MapsKt.mapOf(new Pair[]{TuplesKt.to("OnlyRemoveFromList", r111), TuplesKt.to("num", r26)}));
        goto L36
    L20:
        r17 = "ListAnalysis";
        if (2 != r112.intValue()) goto L27;
        if (TextUtils.isEmpty(r28.c()) == true) goto L27;
        if (TextUtils.equals(r28.c(), r32.b.b) == false) goto L27;
        r29 = true;
    L34:
        r17 = "ListAnalysis";
        goto L35
    L12:
        r25 = 30;
        goto L13
    L5:
        r2 = xo5.a.c(r30, 2131887252, "doc_name", com.bytedance.ee.bear.list.t0.g(r30, r31));
        goto L6
    }
}
