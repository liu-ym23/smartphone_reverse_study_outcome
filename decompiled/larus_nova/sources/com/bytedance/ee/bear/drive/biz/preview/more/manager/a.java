package com.bytedance.ee.bear.drive.biz.preview.more.manager;

import android.view.View;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.drive.biz.preview.more.q;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.ImImportFileMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToSpaceMenu;
import com.larus.platform.api.creation.TplType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b f223550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DriveIMAttachmentMoreMenuManager f223551b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.manager.a$a, reason: collision with other inner class name */
    public static final class C3202a implements com.bytedance.ee.bear.drive.biz.preview.more.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager f223552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b f223553b;

        @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
        public final <T extends BaseMoreMenuAction> void a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            DriveIMAttachmentMoreMenuManager r101 = this.f223552a;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r102 = this.f223553b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "action");
            e65.a r103 = r101.f223542a;
            r103.f471140c.handleSave2SpaceMenuClick(r102, r103);
        }

        public C3202a(DriveIMAttachmentMoreMenuManager r100, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r101) {
            this.f223552a = r100;
            this.f223553b = r101;
        }
    }

    public static final class b implements com.bytedance.ee.bear.drive.biz.preview.more.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager f223554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b f223555b;

        @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
        public final <T extends BaseMoreMenuAction> void a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            DriveIMAttachmentMoreMenuManager r101 = this.f223554a;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r102 = this.f223555b;
            ImImportFileMenu r103 = (ImImportFileMenu) r100;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "action");
            Intrinsics.checkNotNullParameter(r103, TplType.MENU);
            if (r102.a() == true) goto L10;
            ImportFileEntity r104 = new ImportFileEntity(r101.f223542a.f471139b.getFileId(), r101.f223542a.f471139b.getFileName());
            r104.f224404d = true;
            r104.f224405e = r103.f226003p;
            Pair[] r105 = new Pair[2];
            r105[0] = TuplesKt.to("messageId", r103.f226001n);
            String r106 = r103.f226002o;
            if (r106 != null) goto L8;
            r106 = "";
        L8:
            r105[1] = TuplesKt.to("sourceId", r106);
            r104.f224403c = MapsKt.hashMapOf(r105);
            u85.a.a(r102.getActivity(), r104);
            o75.b.a().Ke().n(r101.f223542a.f471139b.getFileModel(), "import_as", "ccm_docs_page_view");
            return;
        }

        public b(DriveIMAttachmentMoreMenuManager r100, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r101) {
            this.f223554a = r100;
            this.f223555b = r101;
        }
    }

    public a(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r100, DriveIMAttachmentMoreMenuManager r101) {
        this.f223550a = r100;
        this.f223551b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        boolean r101 = ((dn4.a) this.f223550a.f217026c.getHost().getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.sheet.im_download_optimization_toast_enabled");
        if (this.f223551b.f223543b.isSheetFile() == false) goto L6;
        if (r101 == false) goto L6;
        com.bytedance.ee.bear.drive.biz.preview.more.b r102 = new q(this.f223550a.getActivity(), this.f223551b.f223542a, this.f223550a);
    L7:
        r102.h(SaveToSpaceMenu.class, new C3202a(this.f223551b, this.f223550a));
        r102.h(ImImportFileMenu.class, new b(this.f223551b, this.f223550a));
        r102.f223480d.a();
        r102.f223480d.q();
        return;
    L6:
        r102 = new com.bytedance.ee.bear.drive.biz.preview.more.b(this.f223550a.getActivity(), this.f223551b.f223542a, this.f223550a);
        goto L7
    }
}
