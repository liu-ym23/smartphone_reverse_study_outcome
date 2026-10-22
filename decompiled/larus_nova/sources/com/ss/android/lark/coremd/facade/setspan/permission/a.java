package com.ss.android.lark.coremd.facade.setspan.permission;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.jvm.internal.Intrinsics;
import v7b.l;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements q<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q<l> f419816a;

    public a(com.ss.android.lark.coremd.facade.setspan.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f419816a = r100;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r110) {
        Intrinsics.checkNotNullParameter(r110, "parseContext");
        IMContextExtend.a r100 = IMContextExtend.A;
        if (((Boolean) r100.b(new IMImageSpanPermissionInterceptor$produceSpan$1$1(r110))).booleanValue() == true) goto L5;
        final AuthorizationServiceV2 r101 = owa.a.c();
        final ResourceCleanScene r102 = (ResourceCleanScene) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$resourceCleanScene$1(r110));
        v9b.b r103 = (v9b.b) r100.b(new IMImageSpanPermissionInterceptor$produceSpan$1$permissionContextData$1(r110));
        String r104 = (String) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$resourceKey$1(r110));
        ValidateIMFileResult r105 = r103.f553908c;
        ValidateIMFileResult r106 = null;
        if (r105 == null) goto L9;
        ValidateIMFileResult.Companion.getClass();
        final ValidateIMFileResult r107 = ValidateIMFileResult.a.a(r105, r104);
    L10:
        ValidateIMFileResult r108 = r103.f553908c;
        if (r108 == null) goto L13;
        ValidateIMFileResult.Companion.getClass();
        r106 = ValidateIMFileResult.a.a(r108, r104);
    L13:
        if (r106 == null) goto L17;
        IMFileResult r109 = r106.getResultType();
        if (r109 == null) goto L17;
        final int r111 = r109.getValue();
    L18:
        final ValidateResult r112 = r103.f553906a;
        final v9b.a r113 = (v9b.a) r100.b(new IMImageSpanPermissionInterceptor$produceSpan$1$messageContextData$1(r110));
        boolean r114 = false;
        if (r102 != null) goto L21;
    L23:
        boolean r115 = false;
    L24:
        if (r115 == false) goto L27;
        int r116 = d.f419819a;
        return d.a(r110.getContext().getString(R.string.Lark_IM_FileRemovedByPolicy_Error), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$2(r110))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$3(r110))).intValue(), r110, r103, new IMImageSpanPermissionInterceptor$produceSpan$1$4(r110, r102, r113));
    L27:
        EntityDomain r117 = xbc.c.f563188a;
        if (r111 == 0) goto L35;
        if (r111 != 1) goto L31;
    L34:
        r114 = true;
        goto L35
    L31:
        if (r111 == 2) goto L35;
        if (r111 == 3) goto L34;
    L35:
        if (r114 == false) goto L42;
        if (r111 != 3) goto L38;
        String r118 = r110.getContext().getString(R.string.Lark_IM_NoReceivingPermission_Text);
    L39:
        int r119 = d.f419819a;
        return d.a(r118, ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$5(r110))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$6(r110))).intValue(), r110, r103, new IMImageSpanPermissionInterceptor$produceSpan$1$7(r111, r110, r101, r107));
    L38:
        r118 = "";
        goto L39
    L42:
        if (r103.f553907b == true) goto L46;
        int r120 = d.f419819a;
        return d.a(r110.getContext().getString(R.string.Lark_IM_UnableToPreviewImage_Text), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$8(r110))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanPermissionInterceptor$produceSpan$1$9(r110))).intValue(), r110, r103, new IMImageSpanPermissionInterceptor$produceSpan$1$10(r110, r112, r101, r107));
    L46:
        return this.f419816a.a(r110);
    L21:
        if (r102.isCSAMDelete() != true) goto L23;
        r115 = true;
    L17:
        r111 = 4;
        goto L18
    L9:
        r107 = null;
        goto L10
    L5:
        return this.f419816a.a(r110);
    }
}
