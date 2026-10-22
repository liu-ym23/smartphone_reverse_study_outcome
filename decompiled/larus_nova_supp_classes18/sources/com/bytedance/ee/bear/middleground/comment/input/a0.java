package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 implements CommentImageAdapter.b {
    public final /* synthetic */ BaseInputComment a;

    public a0(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter.b
    public final void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r5) {
        BaseInputComment r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        b2 r2 = r0.X;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        ((ArrayList) r2.k).remove(r5);
        r0.A0();
        this.a.q0();
        if (this.a.U.isSelected() == false) goto L5;
        BaseInputComment r1 = this.a;
        FileSelectConfig r3 = r1.J();
        r3.maxSelectImageNum = 9 - ((ArrayList) r1.X.k).size();
        FileSelectConfig r4 = r1.J();
        r4.ccmPickViewHeight = r1.K();
        r1.s0();
    L5:
        this.a.a.N.a(new ef5.s(1, CollectionsKt.listOf(r5), this.a));
    }
}
