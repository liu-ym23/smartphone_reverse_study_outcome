package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.protocol3.checker.AdminChecker;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WikiTreeMoreProvider a;
        public final /* synthetic */ m1 b;

        public a(WikiTreeMoreProvider r1, m1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            TreeNode r0 = this.a.m;
            SpaceFileOpenEntity r5 = new SpaceFileOpenEntity(r0.obj_token, r0.title);
            r5.setUrl(this.a.m.getObjUrl());
            r5.setOriginUrl(this.a.m.url);
            r5.setAppId("56");
            r5.setMountPoint(DocumentType.WIKI_NAME);
            if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L5;
            r5.setBizScene(DriveBizScene.DriveBizScene_CCM);
            r5.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
        L5:
            ((com.bytedance.ee.bear.g) org.koin.java.a.c(com.bytedance.ee.bear.g.class, null, null, 6)).a(this.b.getHost().getHostFragment().getContext(), r5);
            this.b.getHost().a();
        }
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ WikiTreeMoreProvider c;

        public b(WikiTreeMoreProvider r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r7) {
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L6;
            PermissionResponse r8 = WikiTreeMoreProvider.m(this.c, "DOWNLOAD");
            r8.getCallback().a(eu5.b.a, r8);
            PermissionResponse.Companion.getClass();
            PermissionResponse.a.d(r8);
            return;
        L6:
            gj5.b r9 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r2 = FileBizDomain.FileBizDomainCCM;
            TreeNode r3 = this.c.m;
            gj5.c r10 = r9.g("CCM_FILE_DOWNLOAD", r2, r3.obj_type, r3.obj_token);
            if (r10.a == false) goto L9;
            return;
        L9:
            FileAuthResultFrom r11 = r10.b;
            if (r11 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L13;
            Toast.showFailureText(eu5.b.a, 2131887246);
            return;
        L13:
            if (r11 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L17;
            gj5.b r12 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            TreeNode r0 = this.c.m;
            r12.c("CCM_FILE_DOWNLOAD", r2, r0.obj_type, r0.obj_token);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.n r1 = com.bytedance.ee.bear.more.protocol3.f.n.c;
        a r5 = new a(this.c, this);
        List r3 = CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{sbb.e.l}), new BizChecker(((ya5.b) org.koin.java.a.c(ya5.b.class, null, null, 6)).a())});
        AdminChecker r6 = new AdminChecker(AdminChecker.AdminPermissionType.Download);
        Intrinsics.checkNotNullParameter("", "disableReason");
        r6.b = "";
        r6.d = new b(this.c);
        WikiTreeMoreProvider r7 = this.c;
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, r3, CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), r6, new WikiTreeMoreProvider.b(r7.n.getOriginCanDownload(r7.m.isShortcut()))}), r5, 2);
    }

    public m1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
