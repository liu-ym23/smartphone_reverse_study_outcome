package com.bytedance.ee.bear.drive.biz.preview.vc.connector;

import com.bytedance.ee.bear.drive.biz.preview.vc.comment.DriveDocCommentFollowConnector;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends AbsFollowableContentProvider {
    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final Class<? extends e>[] c() {
        return new Class[]{com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.class, DriveDocCommentFollowConnector.class, com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class};
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final e e() {
        return new com.bytedance.ee.bear.drive.biz.preview.vc.comment.a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final e f() {
        return new DriveDocCommentFollowConnector();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider
    public final e h() {
        return new com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("NOT_BLOCK_PREVIEW", new l65.b(ExportFileExtension.PDF, "drive_pdf_update")), TuplesKt.to("BLOCK_PREVIEW", new l65.b(ExportFileExtension.PDF, "drive_pdf_update"))}));
    }

    public c(l65.f r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "followableContentManager");
        super(r100, r101, r102);
    }
}
