package com.bytedance.ee.bear.list.create;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.v4;
import com.bytedance.ee.bear.list.x3;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import javax.annotation.Nullable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q0 {
    public static void h() {
        com.bytedance.ee.bear.route.h r0 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        int r1 = 2131889419;
    L6:
        if (r0 != null) goto L8;
    L10:
        Toast.showFailureText(eu5.b.a, r1);
        return;
    L8:
        if (r0.getCurrentActivity() == null) goto L10;
        Toast.showFailureText(r0.getCurrentActivity(), r1);
        return;
    L5:
        r1 = 2131887731;
        goto L6
    }

    public static void e(b r6) {
        if (TextUtils.isEmpty(r6.e) == false) goto L5;
        String r0 = r6.f;
    L6:
        Uri.Builder r1 = UriProtector.parse(r0).buildUpon();
        if (TextUtils.isEmpty(r6.g) == true) goto L9;
        r1.appendQueryParameter("ccm_open_type", r6.g);
    L9:
        String r2 = r1.toString();
        com.bytedance.ee.bear.appsetting.c r3 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r4 = LarkContext.getApplication();
        r3.getClass();
        UserSession r5 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r4, com.ss.android.lark.passportc.convention.a.class)).b();
        boolean r7 = ((dn4.a) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(r4, com.ss.android.lark.passportc.internal.v.class)).c(r5), dn4.a.class)).a().isCurrentEnable("ccm.bitable.big_screen_panel_adaptation_v2");
        boolean r8 = false;
        if (r7 == true) goto L12;
    L14:
        boolean r9 = false;
    L15:
        Boolean r10 = Boolean.valueOf(r9);
        if (r6.h != null) goto L18;
    L20:
        Boolean r11 = Boolean.valueOf(r8);
        if (r10.booleanValue() == true) goto L23;
    L27:
        Fragment r12 = null;
    L28:
        DocumentCreateInfo r13 = r6.h;
        if (r13 != null) goto L31;
    L33:
        String r14 = r6.d;
        com.bytedance.ee.bear.route.h r15 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        RouteBean r16 = new RouteBean();
        r16.l = r2;
        r16.f = r14;
        r16.c = 205;
        if (r12 == null) goto L36;
        r16.a(r12);
    L36:
        r15.m9(r2, r16);
        return;
    L31:
        if (r13.i == false) goto L33;
        i(r13);
        return;
    L23:
        if (r11.booleanValue() == false) goto L27;
        if (ForsetiHelper.s(r6.i) == false) goto L27;
        r12 = r6.i;
        goto L28
    L18:
        if (TextUtils.equals(r6.e, "tab_create") == false) goto L20;
        r8 = true;
        goto L20
    L12:
        if (ForsetiHelper.s(r6.i) == false) goto L14;
        r9 = true;
        goto L15
    L5:
        r0 = com.bytedance.ee.util.io.e.a(r6.f, "from", r6.e);
        goto L6
    }

    public static void i(DocumentCreateInfo r9) {
        Bundle r0 = new Bundle();
        WikiInfo r1 = new WikiInfo();
        r1.setInSpace(false);
        r1.setObjToken(r9.b);
        r1.setObjType(r9.f);
        r1.setSpaceId(r9.h);
        r1.setWikiToken(r9.a);
        r0.putSerializable("wiki_info", r1);
        String r2 = s45.p.a().J8(sbb.e.n.getType(), r9.a, "tab_create", "");
        RouteBean r8 = new WikiRouteBean(r9.b, r9.f, r9.a, r9.h, "");
        r8.l = r2;
        r8.n = r0;
        r8.c = 205;
        r8.f = r9.e;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r2, r8);
    }

    public static void c(b r2, Throwable r3) {
        Context r0 = r2.getContext();
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        int r1 = 2131889419;
    L6:
        d(r2, r3, r0.getString(r1));
        return;
    L5:
        r1 = 2131887731;
        goto L6
    }

    public static void f(Context r3, Throwable r4) {
        if (com.bytedance.ee.bear.contract.k0.c(r4) == false) goto L6;
        return;
    L6:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).a(r4, r3) == false) goto L10;
        tt5.a.h("DocumentCreator", "doOnWikiCreateFailed by exceed quota");
        return;
    L10:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).p(r4, r3, false) == false) goto L13;
        tt5.a.h("DocumentCreator", "doOnWikiCreateFailed by exceed user quota");
        return;
    L13:
        Toast.showFailureText(r3, ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).w(r4));
    }

    public static void d(b r12, Throwable r13, String r14) {
        tt5.a.e("DocumentCreator", "template create fail", r13, false);
        if (com.bytedance.ee.bear.contract.k0.c(r13) == false) goto L6;
        return;
    L6:
        if (v4.a(r12.getContext(), ax4.d.a(r13)) == false) goto L8;
        return;
    L8:
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if ((r13 instanceof NetService.ServerErrorException) == false) goto L51;
        NetService.ServerErrorException r15 = (NetService.ServerErrorException) r13;
        int r1 = r15.getCode();
        String r3 = r15.getMsg();
        if (r12.getContext() == null) goto L15;
        Activity r4 = Contexts.findActivity(r12.getContext());
        if ((r4 instanceof FragmentActivity) == false) goto L15;
        FragmentActivity r5 = (FragmentActivity) r4;
    L16:
        FragmentActivity r6 = r5;
        if (r1 != 11001) goto L34;
        if (r6 != null) goto L20;
    L31:
        e.b(r12.b, "popup_window");
        return;
    L20:
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand() == true) goto L30;
        m r16 = r12.b;
        String r17 = r15.getMsg();
        int r2 = e.a;
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r16, "createInfo");
        Intrinsics.checkNotNullParameter(r17, "msg");
        Intrinsics.checkNotNullParameter(r6, "context");
        UDDialogBuilder r7 = new UDDialogBuilder(r6);
        r7.autoDismiss(true);
        r7.title(2131887883);
        Intrinsics.checkNotNullParameter(r17, "value");
        r7.message(r17);
        r7.messageGravity(8388611);
        BearUDDialogBuilder.ActionBottomOrientation r18 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r18, "value");
        if (r18 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L24;
        UDBaseDialogBuilder.ActionBottomOrientation r19 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L25:
        r7.actionButtonOrientation(r19);
        r7.addActionButton(2131391777, 2131887788, new g(r6, r16));
        r7.addActionButton(2131391778, 2131887716, new h(r16));
        UDDialog r110 = r7.build();
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L55;
        DialogLancet.handleBlockedDialogShow(r110);
        goto L31
    L55:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
    L29:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L31
    L24:
        r19 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L25
    L30:
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).j(r6, FullQuotoConfig.CREATE_TEMPLATE);
        goto L31
    L34:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).l(r1, r6) == false) goto L37;
        return;
    L37:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).k(r1) == false) goto L42;
        if (r6 == null) goto L57;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).c(r6, null, null, !TextUtils.isEmpty(r12.b.a.a), false, "");
        return;
    L57:
        return;
    L42:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).s(r1) == false) goto L47;
        if (r6 == null) goto L58;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).c(r6, null, null, !TextUtils.isEmpty(r12.b.a.a), true, "");
        return;
    L58:
        return;
    L47:
        if (r1 != 4202) goto L50;
        Toast.showFailureText(r12.getContext(), 2131887146);
        return;
    L50:
        jw4.a.d(r0, new jw4.b(r12.b.a.b, r12.c, r1, r3));
    L52:
        Toast.showFailureText(r12.getContext(), r14, 0);
        return;
    L15:
        r5 = null;
        goto L16
    L51:
        jw4.a.d(r0, new jw4.b(r12.b.a.b, r12.c, -1, "unknown"));
        goto L52
    }

    public static Flowable<OfflineDoc> a(int r2, String r3, boolean r4, boolean r5) {
        tt5.a.h("DocumentCreator", "createOfflineDocumentFlow()...type = " + r2 + "isSpaceV2 " + r4);
        if (r5 == false) goto L7;
        return x3.c().b(r3, r2, r4);
    L7:
        return x3.c().a(r3, r2, r4);
    }

    public static void g(m r10, int r11, boolean r12, @Nullable final p r13, CreateSelectResult r14) {
        tt5.a.h("DocumentCreator", "handleCreateDocumentOnline ... type = " + r11 + ", isCreateInWiki = " + r12);
        if (r13 != null) goto L5;
        r13 = new p(new q.a());
    L5:
        r13.a.b.run();
        String r0 = r10.a.a;
        if (TextUtils.isEmpty(r0) == false) goto L11;
        if (r14 == null) goto L11;
        if (TextUtils.isEmpty(r14.c) == true) goto L11;
        r0 = r14.c;
    L11:
        String r2 = r0;
        if (r14 != null) goto L14;
    L16:
        String r15 = "";
    L17:
        iw4.a r16 = r10.a;
        b(r11, r2, r16.b, r16.d, r12, r15, r16.e, r16.f, null).subscribe(new i0(r13), new j0(r13));
        return;
    L14:
        if (TextUtils.isEmpty(r14.e) == true) goto L16;
        r15 = r14.e;
        goto L17
    }

    public static Flowable<DocumentCreateInfo> b(final int r10, String r11, String r12, boolean r13, boolean r14, String r15, int r16, String r17, er5.c r18) {
        tt5.a.h("DocumentCreator", "createOnlineDocumentFlow()...type = " + r10 + ", module = " + r12 + "isSpaceV2 " + r13);
        g0 r8 = new g0();
        if (r14 == true) goto L5;
        y0 r9 = new y0(r10, "", "", r11, r12, r13);
        r9.g = r16;
        r9.h = r17;
        r9.i = r15;
        r9.j = r18;
        return r8.a(r9);
    L5:
        return ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).b(r15, r11, r10, "", "").observeOn(fo5.d.b()).map(new r()).map(new z0(sbb.e.n.b, "", r11)).observeOn(fo5.d.d()).map(new x(r10)).doOnError(new y(r10));
    }
}
