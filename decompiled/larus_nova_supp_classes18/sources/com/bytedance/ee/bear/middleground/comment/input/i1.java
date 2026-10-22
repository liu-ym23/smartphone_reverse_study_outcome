package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i1 implements CommentImageAdapter.b {
    public final /* synthetic */ InputComment a;

    public i1(InputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter.b
    public final void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r5) {
        InputComment r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        b2 r2 = r0.i0;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        ((ArrayList) r2.k).remove(r5);
        r0.e0();
        this.a.U();
        if (this.a.X.isSelected() == false) goto L5;
        InputComment r1 = this.a;
        FileSelectConfig r3 = r1.f0;
        r3.maxSelectImageNum = 9 - ((ArrayList) r1.i0.k).size();
        InputComment r4 = this.a;
        FileSelectConfig r6 = r4.f0;
        r6.ccmPickViewHeight = r4.Z.getKeyboardFixedHeight();
        this.a.W();
    L5:
        this.a.a.N.a(new ef5.s(1, CollectionsKt.listOf(r5), this.a));
    }
}
