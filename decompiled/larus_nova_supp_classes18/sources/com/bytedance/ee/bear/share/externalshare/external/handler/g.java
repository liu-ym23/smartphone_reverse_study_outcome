package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends BaseOpenTencentHandler {
    public ShareDocInfo g;
    public final IDocPublicPermission h;
    public final Function0<Boolean> i;
    public final Function0<Unit> j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.handler.BaseOpenTencentHandler
    public final String e() {
        if (this.a.isWikiShortcutInSpace() == false) goto L10;
        int r0 = n.a;
        if (n.e(this.a) == false) goto L9;
        return n.a(this.a.getUrl(), this.a);
    L9:
        return this.a.getUrl();
    L10:
        ShareDocInfo r1 = this.g;
        if (r1 == null) goto L52;
        DocMetaInfo r2 = r1.e;
        if (r2 == null) goto L52;
        String r3 = r2.getUrl();
        if (r3 == null) goto L52;
        if (r3.length() <= 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == true) goto L23;
        r3 = null;
    L23:
        if (r3 == null) goto L52;
        if (this.a.getType() == 8) goto L27;
    L29:
        if (r3 == null) goto L52;
        Uri r5 = UriProtector.parse(r3);
        int r6 = n.a;
        boolean r7 = n.e(this.a);
        if (this.a.isWiki() == false) goto L34;
        String r8 = super.e();
        String r9 = r5.getHost();
        tt5.a.h("DocOpenTencentHandler", "getHandlerUrl()...metaInfo host = " + r9);
        r3 = UriProtector.parse(r8).buildUpon().authority(r9).build().toString();
    L50:
        Intrinsics.checkNotNull(r3);
        return r3;
    L34:
        if (this.a.isPhoenix() == false) goto L41;
        BearUrl r10 = p.a().Z(r3);
        r3 = UriProtector.parse(r3).buildUpon().path(p.a().j8(r10.a, r10.b)).toString();
        if (r7 == false) goto L50;
        if (p.a().L5(r3) == true) goto L50;
        r3 = n.a(r3, this.a);
        goto L50
    L41:
        if (this.a.getType() == 3) goto L43;
    L45:
        Intrinsics.checkNotNull(r3);
        if (r7 == false) goto L50;
        if (p.a().L5(r3) == true) goto L50;
        r3 = n.a(r3, this.a);
        goto L50
    L43:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.android.sheet_share_url_extra_params_enabled") == false) goto L45;
        r3 = UriProtector.parse(super.e()).buildUpon().authority(r5.getHost()).build().toString();
        goto L45
    L27:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.share.add_extra_param") == false) goto L29;
        int r11 = n.a;
        r3 = n.f(r3, super.e());
        goto L29
    L19:
        r4 = false;
    L52:
        tt5.a.h("DocOpenTencentHandler", "getHandlerUrl()...metaInfo url is empty.");
        return super.e();
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.handler.BaseOpenTencentHandler
    public final void b() {
        i();
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.handler.BaseOpenTencentHandler
    public final void d() {
        k();
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.handler.BaseOpenTencentHandler
    public final void c(ShareType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        Intrinsics.checkNotNullParameter(r3, "toPlatform");
        j(r2, r3);
    }

    public g(ShareParams r8, Context r9, ShareDocInfo r10, ExternalShareMinaConfig r11, BearUrl r12, IDocPublicPermission r13, Function0<Boolean> r14, Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r8, "shareParams");
        Intrinsics.checkNotNullParameter(r11, "externalShareMinaConfig");
        Intrinsics.checkNotNullParameter(r14, "checkUsableSecret");
        Intrinsics.checkNotNullParameter(r15, "dismissDialog");
        super(r8, r9, r10, r11, r12, r15);
        this.g = r10;
        this.h = r13;
        this.i = r14;
        this.j = r15;
    }
}
