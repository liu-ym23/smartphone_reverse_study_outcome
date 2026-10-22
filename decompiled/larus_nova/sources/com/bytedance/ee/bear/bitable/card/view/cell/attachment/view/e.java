package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AttachmentCoverView f207469b;

    @Override // w85.a.b
    public final void e(String r100) {
    }

    public e(AttachmentCoverView r100, String r101) {
        this.f207469b = r100;
        super(r101);
    }

    @Override // w85.a.b
    public final void c(String r100, w85.b r101) {
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        AttachmentEntity r103 = null;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.attachmentcover.rendererror") == false) goto L11;
        String r104 = this.f207492a;
        AttachmentEntity r105 = this.f207469b.f207411n;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r105 = null;
    L8:
        if (TextUtils.equals(r104, r105.getAttachmentToken()) == true) goto L11;
        tt5.a.h(this.f207469b.f207413p, "attachmentToken has change, ignore success result");
        return;
    L11:
        this.f207469b.f207406i = DriveFile.Status.SUCCESS;
        if (r101 == null) goto L23;
        File r106 = r101.f558653b;
        if (r106 == null) goto L24;
        String r107 = r106.getAbsolutePath();
        if (r107 == null) goto L25;
        AttachmentCoverView r108 = this.f207469b;
        AttachmentEntity r109 = r108.f207411n;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
    L21:
        r108.c(r107, r103.getName());
        return;
    L20:
        r103 = r109;
        goto L21
    L25:
        return;
    L24:
        return;
    }

    @Override // w85.a.b
    public final void a(String r100, String r101, int r102) {
        tt5.a.d(this.f207469b.f207413p, "onFailed, key = " + r101 + ", errorCode = " + r102);
        int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
        AttachmentEntity r104 = null;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.attachmentcover.rendererror") == false) goto L11;
        String r105 = this.f207492a;
        AttachmentEntity r106 = this.f207469b.f207411n;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r106 = null;
    L8:
        if (TextUtils.equals(r105, r106.getAttachmentToken()) == true) goto L11;
        tt5.a.h(this.f207469b.f207413p, "attachmentToken has change, ignore fail result");
        return;
    L11:
        AttachmentCoverView r107 = this.f207469b;
        r107.f207406i = DriveFile.Status.FAILED;
        AttachmentEntity r108 = r107.f207411n;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
        r108 = null;
    L14:
        String r109 = r108.getAvailableLocalPath();
        if (r109 == null) goto L22;
        AttachmentCoverView r110 = this.f207469b;
        tt5.a.h(r110.f207413p, "download failed, then render cover by available non-empty local path");
        AttachmentEntity r111 = r110.f207411n;
        if (r111 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentEntity");
    L20:
        r110.c(r109, r104.getName());
        return;
    L19:
        r104 = r111;
        goto L20
    }
}
