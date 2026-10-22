package com.bytedance.ee.bear.middleground.comment.detail;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<unused var>", "", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DetailComment$1 extends Lambda implements Function2<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Unit> {
    public static final DetailComment$1 INSTANCE = null;

    static {
        INSTANCE = new DetailComment$1();
    }

    public DetailComment$1() {
        super(2);
    }

    public final void invoke(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (List) r2);
        return Unit.INSTANCE;
    }
}
