package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.util.info.AppInfoUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final /* synthetic */ int f = 0;
    public final Context a;
    public ShareDocInfo b;
    public final ShareParams c;
    public final BaseOpenTencentHandler d;
    public final String e;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public final void a(boolean r9) {
        ShareDocInfo r0 = this.b;
        if (r0 == null) goto L47;
        IDocPublicPermission r1 = r0.g;
        if (r1.isLinkShareAnyoneRead() == false) goto L7;
    L8:
        boolean r3 = false;
        if (r1.hasLinkPassword() == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        cj5.c.b r4 = new cj5.c.b();
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L26;
        String r5 = this.c.getUrl();
        if (r5.length() != 0) goto L19;
        boolean r7 = true;
    L21:
        if (Boolean.valueOf(r7).booleanValue() == false) goto L24;
        r5 = null;
    L24:
        if (r5 != null) goto L30;
        r5 = this.c.getOriginUrl();
    L30:
        r4.a = r5;
        r4.b = r0.c;
        r4.c = r0.getType();
        r4.d = this.c.getRealToken();
        r4.e = this.c.getRealType();
        r4.f = this.c.isWiki();
        r4.g = r0.f.canManageContainerPermissionMeta();
        r4.h = r0.i();
        if (r9 == true) goto L33;
        if (r2 == false) goto L33;
    L34:
        r4.i = r3;
        String r10 = this.e;
        String r6 = "";
        if (r10 != null) goto L37;
        r10 = "";
    L37:
        r4.k = r10;
        ShareDocInfo r11 = this.b;
        if (r11 == null) goto L45;
        DocMetaInfo r12 = r11.e;
        if (r12 == null) goto L45;
        String r13 = r12.getTenantName();
        if (r13 == null) goto L45;
        r6 = r13;
    L45:
        r4.l = r6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).rb(this.a, r4, com.bytedance.ee.bear.share.externalshare.external.g.c(this.c.getModule(), com.bytedance.ee.bear.share.externalshare.external.g.g(r0, true, this.c)), null);
        return;
    L33:
        r3 = true;
        goto L34
    L19:
        r7 = false;
        goto L21
    L26:
        BaseOpenTencentHandler r8 = this.d;
        if (r8 == null) goto L29;
        r5 = r8.e();
        goto L30
    L29:
        r5 = null;
        goto L30
    L11:
        if (TextUtils.isEmpty(r1.linkPassword()) == true) goto L13;
        r2 = true;
        goto L14
    L7:
        if (r1.isLinkShareAnyoneEdit() == true) goto L8;
        return;
    }

    public m(Context r2, ShareDocInfo r3, ShareParams r4, BaseOpenTencentHandler r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
