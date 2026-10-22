package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x {
    public final com.bytedance.ee.bear.drive.biz.external.f a;
    public final PlaceHolderView b;
    public final PreviewViewModel c;

    public x(Context r10, PlaceHolderView r11, com.bytedance.ee.bear.drive.biz.external.f r12, ViewOwner r13, z r14) {
        this.a = r12;
        this.b = r11;
        PreviewViewModel r16 = (PreviewViewModel) r13.viewModel(PreviewViewModel.class);
        this.c = r16;
        if (r16.getBizType() != 4) goto L5;
        r11.setNoExportPermissionTips(r10.getResources().getString(2131888368));
        r11.setNoExportPermissionTipsVisibility(false);
    L5:
        com.bytedance.ee.drive.render.k.e r17 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(r10).b().c();
        if (r17 != null) goto L8;
    L10:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L39;
        s55.a r18 = s55.a.a;
        String r19 = r14.t;
        int r5 = r16.getBizType();
        String r6 = r14.o;
        Intrinsics.checkNotNullParameter("DOWNLOAD", "operation");
        if (TextUtils.isEmpty(r19) == true) goto L15;
        BizDomain r110 = pw4.b.a(r19);
    L30:
        Integer r2 = Integer.valueOf(r5);
        if (r2 != null) goto L34;
        sbb.e r3 = sbb.e.l;
    L37:
        boolean r111 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(r6, r3, r110, ""), "DOWNLOAD"), null).getAllow();
    L50:
        if (r111 == true) goto L52;
        r11.setBtnOpenExternalVisibility(false);
        tt5.a.h("PlaceHolderViewWrapper", "adminEnable=false, hide open external btn. sdkAppId: " + r14.p);
        return;
    L52:
        r11.setOnBtnOpenExternalClickListener(new v(this));
        r11.addOnAttachStateChangeListener(new w(this));
        r16.liveOuterExportVisible().observe(r13.lifecycleOwner(), new s(this));
        r16.liveOuterNetState().observe(r13.lifecycleOwner(), new t(this));
        return;
    L34:
        if (r2.intValue() != 3) goto L36;
        r3 = sbb.e.x;
        goto L37
    L36:
        r3 = sbb.e.l;
        goto L37
    L15:
        Integer r112 = Integer.valueOf(r5);
        int r7 = pw4.b.a;
        if (r112 != null) goto L19;
        r110 = BizDomain.FileBizDomainOPENPLATFORM;
        goto L30
    L19:
        if (r112.intValue() != 3) goto L22;
        r110 = BizDomain.FileBizDomainIM;
        goto L30
    L22:
        if (r112.intValue() != 2) goto L24;
    L29:
        r110 = BizDomain.FileBizDomainCCM;
        goto L30
    L24:
        if (r112.intValue() == 4) goto L29;
        if (r112.intValue() == 5) goto L29;
        r110 = BizDomain.FileBizDomainOPENPLATFORM;
        goto L30
    L39:
        if (r16.getBizType() != 2) goto L41;
    L49:
        r111 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_ATTACHMENT_DOWNLOAD", pw4.b.a(r14.t).toFileBizDomain(), sbb.e.l.b, r14.o).a;
        goto L50
    L41:
        if (r16.getBizType() == 4) goto L49;
        if (r16.getBizType() == 5) goto L49;
        if (r16.getBizType() != 3) goto L48;
        r111 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("IM_MSG_FILE_DOWNLOAD", FileBizDomain.FileBizDomainIM, sbb.e.x.b, r14.o).a;
        goto L50
    L48:
        r111 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_ATTACHMENT_DOWNLOAD", FileBizDomain.FileBizDomainUNKNOWN, sbb.e.l.b, r14.o).a;
        goto L50
    L8:
        if (Boolean.TRUE.equals(r17.a) == false) goto L10;
        r11.setOpenExternalVisibility(false);
        r11.addOnAttachStateChangeListener(new u(this));
    }
}
