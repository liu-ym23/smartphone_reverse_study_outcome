package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.nova.R;
import com.ss.android.download.api.config.HttpMethod;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.biz.external.f f225830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlaceHolderView f225831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PreviewViewModel f225832c;

    public x(Context r110, PlaceHolderView r111, com.bytedance.ee.bear.drive.biz.external.f r112, ViewOwner r113, z r114) {
        this.f225830a = r112;
        this.f225831b = r111;
        PreviewViewModel r115 = (PreviewViewModel) r113.viewModel(PreviewViewModel.class);
        this.f225832c = r115;
        if (r115.getBizType() != 4) goto L5;
        r111.setNoExportPermissionTips(r110.getResources().getString(R.string.Drive_Drive_AttachFileNotSupportPreviewNoPermissionTips));
        r111.setNoExportPermissionTipsVisibility(false);
    L5:
        com.bytedance.ee.drive.render.k.e r116 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(r110).b().c();
        if (r116 != null) goto L8;
    L10:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L39;
        s55.a r117 = s55.a.f540731a;
        String r118 = r114.f225852t;
        int r100 = r115.getBizType();
        String r101 = r114.f225847o;
        Intrinsics.checkNotNullParameter(HttpMethod.DOWNLOAD, WikiFolderPushPlugin.OPT);
        if (TextUtils.isEmpty(r118) == true) goto L15;
        BizDomain r119 = pw4.b.a(r118);
    L30:
        Integer r102 = Integer.valueOf(r100);
        if (r102 != null) goto L34;
        sbb.e r103 = sbb.e.f541301l;
    L37:
        boolean r120 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(r101, r103, r119, ""), HttpMethod.DOWNLOAD), null).getAllow();
    L50:
        if (r120 == true) goto L52;
        r111.setBtnOpenExternalVisibility(false);
        tt5.a.h("PlaceHolderViewWrapper", "adminEnable=false, hide open external btn. sdkAppId: " + r114.f225848p);
        return;
    L52:
        r111.setOnBtnOpenExternalClickListener(new v(this));
        r111.addOnAttachStateChangeListener(new w(this));
        r115.liveOuterExportVisible().observe(r113.lifecycleOwner(), new s(this));
        r115.liveOuterNetState().observe(r113.lifecycleOwner(), new t(this));
        return;
    L34:
        if (r102.intValue() != 3) goto L36;
        r103 = sbb.e.f541313x;
        goto L37
    L36:
        r103 = sbb.e.f541301l;
        goto L37
    L15:
        Integer r121 = Integer.valueOf(r100);
        int r104 = pw4.b.f530833a;
        if (r121 != null) goto L19;
        r119 = BizDomain.FileBizDomainOPENPLATFORM;
        goto L30
    L19:
        if (r121.intValue() != 3) goto L22;
        r119 = BizDomain.FileBizDomainIM;
        goto L30
    L22:
        if (r121.intValue() != 2) goto L24;
    L29:
        r119 = BizDomain.FileBizDomainCCM;
        goto L30
    L24:
        if (r121.intValue() == 4) goto L29;
        if (r121.intValue() == 5) goto L29;
        r119 = BizDomain.FileBizDomainOPENPLATFORM;
        goto L30
    L39:
        if (r115.getBizType() != 2) goto L41;
    L49:
        r120 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_ATTACHMENT_DOWNLOAD", pw4.b.a(r114.f225852t).toFileBizDomain(), sbb.e.f541301l.f541317b, r114.f225847o).f481503a;
        goto L50
    L41:
        if (r115.getBizType() == 4) goto L49;
        if (r115.getBizType() == 5) goto L49;
        if (r115.getBizType() != 3) goto L48;
        r120 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("IM_MSG_FILE_DOWNLOAD", FileBizDomain.FileBizDomainIM, sbb.e.f541313x.f541317b, r114.f225847o).f481503a;
        goto L50
    L48:
        r120 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_ATTACHMENT_DOWNLOAD", FileBizDomain.FileBizDomainUNKNOWN, sbb.e.f541301l.f541317b, r114.f225847o).f481503a;
        goto L50
    L8:
        if (Boolean.TRUE.equals(r116.f242748a) == false) goto L10;
        r111.setOpenExternalVisibility(false);
        r111.addOnAttachStateChangeListener(new u(this));
    }
}
