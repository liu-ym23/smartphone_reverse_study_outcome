package com.bytedance.ee.bear.basesdk.business.comment;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "content", "", "imageEntities", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "bySend", "", "tmpId", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseCommentPlugin$init$4 extends Lambda implements Function4<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Unit> {
    final /* synthetic */ a this$0;

    public BaseCommentPlugin$init$4(a r100) {
        this.this$0 = r100;
        super(4);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101, Boolean r102, String r103) {
        Intrinsics.checkNotNull(r102);
        r102.booleanValue();
        a r104 = this.this$0;
        int r105 = a.f206587a;
        r104.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101, Boolean r102, String r103) {
        invoke2(r100, r101, r102, r103);
        return Unit.INSTANCE;
    }
}
