package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.lark.utils.ContextsKt;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseOpenTencentHandler {
    public final ShareParams a;
    public final Context b;
    public com.bytedance.ee.bear.share.export.f c;
    public final ExternalShareMinaConfig d;
    public final BearUrl e;
    public final Function0<Unit> f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ShareType.More.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements com.bytedance.ee.bear.middleground_permission_export.model.a {
        public final /* synthetic */ BaseOpenTencentHandler a;
        public final /* synthetic */ ShareType b;
        public final /* synthetic */ String c;

        public c(BaseOpenTencentHandler r1, ShareType r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.a
        public final void onComplete() {
            this.a.j(this.b, this.c);
        }
    }

    public static final class d implements com.bytedance.ee.bear.bizwidget.shareview.h.c {
        public final /* synthetic */ ShareType a;
        public final /* synthetic */ BaseOpenTencentHandler b;
        public final /* synthetic */ String c;

        public d(ShareType r1, BaseOpenTencentHandler r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.a != ShareType.Wechat) goto L6;
            com.bytedance.ee.bear.share.d.g(this.b.a.getToken(), this.b.a.getType(), this.b.a.getSubType(), this.b.a.isWiki(), true);
        L6:
            if (this.b.getContext() != null) goto L8;
            tt5.a.d("BaseShareExternalPresenter", "setOnShareBtnClickListener()....context == null");
            return;
        L8:
            if (this.a != ShareType.WechatMoments) goto L10;
            km5.c.f(this.b.getContext());
        L11:
            this.b.f.invoke();
            return;
        L10:
            km5.c.j(this.b.getContext(), this.a, this.c, null);
            goto L11
        }
    }

    public static final class e implements com.bytedance.ee.bear.bizwidget.shareview.h.c {
        public final /* synthetic */ ShareType a;
        public final /* synthetic */ BaseOpenTencentHandler b;

        public e(ShareType r1, BaseOpenTencentHandler r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a != ShareType.Wechat) goto L6;
            com.bytedance.ee.bear.share.d.g(this.b.a.getToken(), this.b.a.getType(), this.b.a.getSubType(), this.b.a.isWiki(), false);
            return;
        }
    }

    public static final class f implements com.bytedance.ee.bear.bizwidget.shareview.h.b {
        public final /* synthetic */ BaseOpenTencentHandler a;

        public f(BaseOpenTencentHandler r1) {
            this.a = r1;
        }

        public final void onDismiss() {
            this.a.f.invoke();
        }
    }

    static {
    }

    public void b() {
        com.bytedance.ee.bear.share.externalshare.external.handler.a r1 = new com.bytedance.ee.bear.share.externalshare.external.handler.a(new BaseOpenTencentHandler$doShareMore$1(this));
        com.bytedance.ee.bear.share.export.f r0 = this.c;
        if (r0 == null) goto L6;
        int r2 = n.a;
        n.g(r0, r1, this.a, this.b);
        return;
    }

    public void d() {
        com.bytedance.ee.bear.share.externalshare.external.handler.a r1 = new com.bytedance.ee.bear.share.externalshare.external.handler.a(new BaseOpenTencentHandler$doShareToWeibo$1(this));
        com.bytedance.ee.bear.share.export.f r0 = this.c;
        if (r0 == null) goto L6;
        int r2 = n.a;
        n.g(r0, r1, this.a, this.b);
        return;
    }

    public String e() {
        if (TextUtils.isEmpty(this.a.getOriginUrl()) == false) goto L7;
        return this.a.getUrl();
    L7:
        if (this.a.getType() == sbb.e.l.b) goto L18;
        if (this.a.getType() == sbb.e.i.b) goto L18;
        int r0 = n.a;
        if (n.e(this.a) == true) goto L14;
        ShareParams r1 = this.a;
        r1.setUrl(n.b(r1.getUrl()));
        ShareParams r2 = this.a;
        r2.setUrl(a(r2.getUrl()));
        return this.a.getUrl();
    L14:
        return n.a(this.a.getUrl(), this.a);
    L18:
        return this.a.getOriginUrl();
    }

    public final HashMap<String, String> f() {
        HashMap<String, String> r0 = new HashMap();
        r0.put("Doc_name", this.a.getDocName());
        String r1 = a(g());
        s45.i r2 = s45.i.a;
        int r3 = this.a.getType();
        boolean r4 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        r2.getClass();
        r0.put("Doc_url", s45.i.b(r1, r3, r4));
        r0.put("emoji", "👉");
        return r0;
    }

    public final void i() {
        Context r0 = this.b;
        if (r0 != null) goto L6;
        tt5.a.d("BaseShareExternalPresenter", "onShareMore()...activity is null");
        return;
    L6:
        km5.c.b(ContextsKt.findActivity(r0), a(g()));
        this.f.invoke();
    }

    public final void k() {
        Context r0 = this.b;
        if (r0 != null) goto L6;
        tt5.a.d("BaseShareExternalPresenter", "onShareToWeibo()...context == null");
        return;
    L6:
        String r1 = xo5.a.d(r0, 2131888254, f());
        ExternalShareMinaConfig r2 = this.d;
        ShareType r3 = ShareType.Weibo;
        if (r2.isShareChannelBanned(r3) == true) goto L9;
        km5.c.i(r0, r3, r1, null);
    L10:
        this.f.invoke();
        return;
    L9:
        km5.c.j(r0, r3, r1, null);
        goto L10
    }

    public final String g() {
        String r0 = e();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "";
    L6:
        if (this.a.getType() == sbb.e.i.b) goto L8;
    L9:
        r0 = UriProtector.parse(r0).buildUpon().clearQuery().toString();
        int r1 = n.a;
        if (n.e(this.a) == false) goto L13;
        r0 = n.a(r0, this.a);
    L13:
        return a(n.b(r0));
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.share.add_extra_param") == true) goto L13;
        goto L9
    }

    public final Context getContext() {
        return this.b;
    }

    public final String a(String r4) {
        t45.c r0 = p.a();
        Integer r1 = Integer.valueOf(this.a.getRealType());
        if (r1.intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        int r3 = r1.intValue();
    L12:
        String r5 = r0.T6(r4, Integer.valueOf(r3));
        if (r5 != null) goto L16;
        return "";
    L16:
        return r5;
    L11:
        r3 = this.a.getType();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final void h(ShareType r8) {
        Intrinsics.checkNotNullParameter(r8, "shareType");
        int r9 = b.a[r8.ordinal()];
        if (r9 != 1) goto L5;
        String r10 = this.a.getToken();
        int r0 = this.a.getType();
        String r3 = this.a.getSubType();
        boolean r4 = this.a.isWiki();
        String r5 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "subType");
        com.bytedance.ee.bear.share.d.f("share_wechat", "ccm_permission_share_wechat_view", new com.bytedance.ee.bear.share.c(r10, r0, r3, r4));
        int r11 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.e("wechat", this.c, this.a);
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.WeChat, this.a, this.e);
        return;
    L5:
        if (r9 != 2) goto L7;
        String r12 = this.a.getToken();
        int r1 = this.a.getType();
        String r6 = this.a.getSubType();
        boolean r7 = this.a.isWiki();
        String r13 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "subType");
        com.bytedance.ee.bear.share.d.f("share_wechat_moments", "none", new com.bytedance.ee.bear.share.c(r12, r1, r6, r7));
        int r14 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.e("wechat_article", this.c, this.a);
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.WeChatMoments, this.a, this.e);
        return;
    L7:
        if (r9 != 3) goto L9;
        String r15 = this.a.getToken();
        int r2 = this.a.getType();
        String r16 = this.a.getSubType();
        boolean r17 = this.a.isWiki();
        String r18 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r16, "subType");
        com.bytedance.ee.bear.share.d.f("share_qq", "none", new com.bytedance.ee.bear.share.c(r15, r2, r16, r17));
        int r19 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.e("qq", this.c, this.a);
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.QQ, this.a, this.e);
        return;
    L9:
        if (r9 != 4) goto L11;
        String r20 = this.a.getToken();
        int r21 = this.a.getType();
        String r22 = this.a.getSubType();
        boolean r23 = this.a.isWiki();
        String r24 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r20, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r22, "subType");
        com.bytedance.ee.bear.share.d.f("share_weibo", "none", new com.bytedance.ee.bear.share.c(r20, r21, r22, r23));
        int r25 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.e("weibo", this.c, this.a);
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.Weibo, this.a, this.e);
        return;
    L11:
        if (r9 != 5) goto L23;
        String r26 = this.a.getToken();
        int r27 = this.a.getType();
        String r28 = this.a.getSubType();
        boolean r29 = this.a.isWiki();
        String r30 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r26, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r28, "subType");
        com.bytedance.ee.bear.share.d.f("share_more", "none", new com.bytedance.ee.bear.share.c(r26, r27, r28, r29));
        int r31 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.e("more", this.c, this.a);
        com.bytedance.ee.bear.share.externalshare.external.g.a(AppDetail.Others, this.a, this.e);
        return;
    }

    public void c(ShareType r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        Intrinsics.checkNotNullParameter(r4, "toPlatform");
        c r0 = new c(this, r3, r4);
        com.bytedance.ee.bear.share.export.f r5 = this.c;
        if (r5 == null) goto L6;
        int r6 = n.a;
        n.g(r5, r0, this.a, this.b);
        return;
    }

    public final void j(final ShareType r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "shareType");
        Intrinsics.checkNotNullParameter(r10, "toPlatform");
        if (this.b != null) goto L6;
        tt5.a.d("BaseShareExternalPresenter", "shareToTencentApp()...context == null");
        return;
    L6:
        boolean r0 = this.d.isShareChannelBanned(r9);
        boolean r1 = this.d.isShareDomainBanned(r9);
        com.bytedance.ee.bear.share.export.f r2 = this.c;
        if (r2 == null) goto L9;
        boolean r3 = r2.canExport();
    L11:
        if (r1 == false) goto L19;
        int r4 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.f(r10, "2", this.c, this.a);
        if (this.a.getType() == sbb.e.g.b) goto L15;
    L18:
        String r11 = xo5.a.d(this.b, 2131888214, f());
        Intrinsics.checkNotNull(r11);
        l(r9, r11);
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).p(r11, new Token("LARK-PSDA-ccm_android_share_dialog_set_clipboard_when_share_to_tencent_banned"));
        return;
    L15:
        if (this.a.getSource() != 2) goto L18;
        if (r3 == false) goto L18;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).m(r9.name());
        return;
    L19:
        if (r0 == false) goto L30;
        int r5 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.f(r10, "1", this.c, this.a);
        if (r9 == ShareType.WechatMoments) goto L23;
    L29:
        String r12 = xo5.a.d(this.b, 2131888213, f());
        Intrinsics.checkNotNull(r12);
        l(r9, r12);
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r12, false, new Token("LARK-PSDA-ccm_android_share_dialog_set_clipboard_when_share_to_tencent_channel_banned"));
        return;
    L23:
        if (this.a.getType() != sbb.e.g.b) goto L29;
        if (this.a.getSource() != 2) goto L29;
        if (r3 == false) goto L29;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.c(com.bytedance.ee.bear.contract.m.class, null, null, 6)).m(r9.name());
        return;
    L30:
        int r6 = com.bytedance.ee.bear.share.externalshare.external.g.a;
        com.bytedance.ee.bear.share.externalshare.external.g.f(r10, "0", this.c, this.a);
        if (r9 == ShareType.Wechat) goto L33;
    L35:
        com.bytedance.ee.bear.share.i.a((NetService) org.koin.java.a.c(NetService.class, null, null, 6), String.valueOf(this.a.getType()), this.a.getToken(), new BaseOpenTencentHandler$shareOnToTencentApp$2(this, r9));
        return;
    L33:
        if (this.d.isEnableShareMiniApp() == false) goto L35;
        km5.c.h(this.b, a(g()), this.a);
        this.f.invoke();
        return;
    L9:
        r3 = false;
        goto L11
    }

    public final void l(ShareType r6, String r7) {
        com.bytedance.ee.bear.bizwidget.shareview.h.a r0 = new com.bytedance.ee.bear.bizwidget.shareview.h.a(this.b);
        r0.a(r6);
        Context r1 = this.b;
        if (r1 == null) goto L6;
        String r2 = r1.getString(2131888225);
        if (r2 == null) goto L6;
    L7:
        r0.a.c.setText(r2);
        r0.a.d.setVisibility(0);
        r0.a.d.setText(r7);
        Context r3 = this.b;
        if (r6 != ShareType.WechatMoments) goto L10;
        int r4 = 2131888247;
    L11:
        String r5 = xo5.a.c(r3, r4, "channelName", km5.c.c(r3, r6));
        r0.a.g.setText(r5);
        d r8 = new d(r6, this, r7);
        r0.a.e.setOnClickListener(new com.bytedance.ee.bear.bizwidget.shareview.f(r0, r8));
        e r9 = new e(r6, this);
        r0.a.h.setOnClickListener(new com.bytedance.ee.bear.bizwidget.shareview.e(r0, r9));
        f r10 = new f(this);
        r0.a.b.setOnDismissListener(new com.bytedance.ee.bear.bizwidget.shareview.g(r10));
        r0.b();
        if (r6 != ShareType.Wechat) goto L15;
        String r11 = this.a.getToken();
        int r12 = this.a.getType();
        String r13 = this.a.getSubType();
        boolean r14 = this.a.isWiki();
        String r15 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "subType");
        com.bytedance.ee.bear.share.d.h("ccm_permission_share_wechat_view", r11, r12, r13, r14);
        return;
    L15:
        return;
    L10:
        r4 = 2131888236;
    L6:
        r2 = "";
        goto L7
    }

    public BaseOpenTencentHandler(ShareParams r2, Context r3, com.bytedance.ee.bear.share.export.f r4, ExternalShareMinaConfig r5, BearUrl r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r5, "externalShareMinaConfig");
        Intrinsics.checkNotNullParameter(r7, "dismiss");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
