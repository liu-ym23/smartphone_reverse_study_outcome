package com.ss.android.lark.coremd.facade.setspan.permission;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import eab.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements q<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q<f> f419817a;

    public b(com.ss.android.lark.coremd.facade.setspan.b r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f419817a = r100;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r110) {
        Intrinsics.checkNotNullParameter(r110, "parseContext");
        IMContextExtend.a r100 = IMContextExtend.A;
        ValidateIMFileResult r101 = null;
        if (((Boolean) r100.b(new IMMediaSpanPermissionInterceptor$produceSpan$1$1(r110))).booleanValue() == false) goto L5;
        return null;
    L5:
        final ResourceCleanScene r102 = (ResourceCleanScene) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$resourceCleanScene$1(r110));
        v9b.b r103 = (v9b.b) r100.b(new IMMediaSpanPermissionInterceptor$produceSpan$1$permissionContextData$1(r110));
        String r104 = (String) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$resourceKey$1(r110));
        ValidateIMFileResult r105 = r103.f553908c;
        if (r105 == null) goto L8;
        ValidateIMFileResult.Companion.getClass();
        final ValidateIMFileResult r106 = ValidateIMFileResult.a.a(r105, r104);
    L9:
        ValidateIMFileResult r107 = r103.f553908c;
        if (r107 == null) goto L12;
        ValidateIMFileResult.Companion.getClass();
        r101 = ValidateIMFileResult.a.a(r107, r104);
    L12:
        if (r101 == null) goto L16;
        IMFileResult r108 = r101.getResultType();
        if (r108 == null) goto L16;
        final int r109 = r108.getValue();
    L17:
        final ValidateResult r111 = r103.f553906a;
        final v9b.a r112 = (v9b.a) r100.b(new IMMediaSpanPermissionInterceptor$produceSpan$1$messageContextData$1(r110));
        boolean r113 = false;
        if (r102 != null) goto L20;
    L22:
        boolean r114 = false;
    L23:
        if (r114 == false) goto L26;
        int r115 = d.f419819a;
        return d.a(r110.getContext().getString(R.string.Lark_IM_FileRemovedByPolicy_Error), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$2(r110))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$3(r110))).intValue(), r110, r103, new IMMediaSpanPermissionInterceptor$produceSpan$1$4(r110, r102, r112));
    L26:
        EntityDomain r116 = xbc.c.f563188a;
        if (r109 == 0) goto L34;
        if (r109 != 1) goto L30;
    L33:
        r113 = true;
        goto L34
    L30:
        if (r109 == 2) goto L34;
        if (r109 == 3) goto L33;
    L34:
        if (r113 == false) goto L41;
        if (r109 != 3) goto L37;
        String r117 = r110.getContext().getString(R.string.Lark_IM_NoReceivingPermission_Text);
    L38:
        int r118 = d.f419819a;
        return d.a(r117, ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$5(r110))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$6(r110))).intValue(), r110, r103, new IMMediaSpanPermissionInterceptor$produceSpan$1$7(r109, r110, r106));
    L37:
        r117 = "";
        goto L38
    L41:
        if (r103.f553907b == true) goto L45;
        int r119 = d.f419819a;
        return d.a(r110.getContext().getString(R.string.Lark_IM_UnableToPreviewVideo_Text), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$8(r110))).intValue(), ((Number) com.ss.android.lark.coremd.ext.i.a(IMMediaExtend.class, new IMMediaSpanPermissionInterceptor$produceSpan$1$9(r110))).intValue(), r110, r103, new IMMediaSpanPermissionInterceptor$produceSpan$1$10(r110, r111));
    L45:
        return this.f419817a.a(r110);
    L20:
        if (r102.isCSAMDelete() != true) goto L22;
        r114 = true;
    L16:
        r109 = 4;
        goto L17
    L8:
        r106 = null;
        goto L9
    }
}
