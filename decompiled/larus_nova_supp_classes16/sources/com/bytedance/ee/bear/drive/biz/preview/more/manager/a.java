package com.bytedance.ee.bear.drive.biz.preview.more.manager;

import android.view.View;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.biz.preview.more.q;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.ImImportFileMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToSpaceMenu;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b a;
    public final /* synthetic */ DriveIMAttachmentMoreMenuManager b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.manager.a$a, reason: collision with other inner class name */
    public static final class C0146a implements com.bytedance.ee.bear.drive.biz.preview.more.a {
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b b;

        @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
        public final <T extends BaseMoreMenuAction> void a(T r3) {
            Intrinsics.checkNotNullParameter(r3, "t");
            DriveIMAttachmentMoreMenuManager r4 = this.a;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r0 = this.b;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r0, JSEventListener.ACTION);
            e65.a r5 = r4.a;
            r5.c.handleSave2SpaceMenuClick(r0, r5);
        }

        public C0146a(DriveIMAttachmentMoreMenuManager r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements com.bytedance.ee.bear.drive.biz.preview.more.a {
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b b;

        @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
        public final <T extends BaseMoreMenuAction> void a(T r8) {
            Intrinsics.checkNotNullParameter(r8, "t");
            DriveIMAttachmentMoreMenuManager r0 = this.a;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r1 = this.b;
            ImImportFileMenu r9 = (ImImportFileMenu) r8;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, JSEventListener.ACTION);
            Intrinsics.checkNotNullParameter(r9, "menu");
            if (r1.a() == true) goto L10;
            ImportFileEntity r2 = new ImportFileEntity(r0.a.b.getFileId(), r0.a.b.getFileName());
            r2.d = true;
            r2.e = r9.p;
            Pair[] r4 = new Pair[2];
            r4[0] = TuplesKt.to("messageId", r9.n);
            String r10 = r9.o;
            if (r10 != null) goto L8;
            r10 = "";
        L8:
            r4[1] = TuplesKt.to("sourceId", r10);
            r2.c = MapsKt.hashMapOf(r4);
            u85.a.a(r1.getActivity(), r2);
            o75.b.a().Ke().n(r0.a.b.getFileModel(), "import_as", "ccm_docs_page_view");
            return;
        }

        public b(DriveIMAttachmentMoreMenuManager r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r1, DriveIMAttachmentMoreMenuManager r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        boolean r6 = ((dn4.a) this.a.c.getHost().getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.sheet.im_download_optimization_toast_enabled");
        if (this.b.b.isSheetFile() == false) goto L6;
        if (r6 == false) goto L6;
        com.bytedance.ee.bear.drive.biz.preview.more.b r7 = new q(this.a.getActivity(), this.b.a, this.a);
    L7:
        r7.h(SaveToSpaceMenu.class, new C0146a(this.b, this.a));
        r7.h(ImImportFileMenu.class, new b(this.b, this.a));
        r7.d.a();
        r7.d.q();
        return;
    L6:
        r7 = new com.bytedance.ee.bear.drive.biz.preview.more.b(this.a.getActivity(), this.b.a, this.a);
        goto L7
    }
}
