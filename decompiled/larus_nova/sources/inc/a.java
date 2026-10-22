package inc;

import com.larus.platform.model.comment.CommentInfo;
import com.larus.utils.o0;
import com.story.ai.biz.comment.model.ChildCommentItem;
import com.story.ai.biz.comment.model.CommentListItem;
import com.story.ai.biz.comment.model.CommentSection;
import com.story.ai.biz.comment.model.ExpandAndCollapseCommentItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f490632a;

    public /* synthetic */ a(String r100) {
        this.f490632a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = this.f490632a;
        CommentSection r102 = (CommentSection) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        if ((r102 instanceof CommentListItem) == false) goto L6;
        boolean r103 = com.story.ai.biz.comment.model.b.a(r102, r101);
    L27:
        return Boolean.valueOf(r103);
    L6:
        if ((r102 instanceof ChildCommentItem) == false) goto L13;
        CommentListItem r104 = ((ChildCommentItem) r102).getParentCommentItem();
        if (r104 != null) goto L10;
    L25:
        r103 = false;
        goto L27
    L10:
        if (com.story.ai.biz.comment.model.b.a(r104, r101) != true) goto L25;
    L24:
        r103 = true;
        goto L27
    L13:
        if ((r102 instanceof ExpandAndCollapseCommentItem) == false) goto L25;
        CommentListItem r105 = ((ExpandAndCollapseCommentItem) r102).getParentCommentItem();
        if (r105 == null) goto L19;
        CommentInfo r106 = r105.getCommentData();
        if (r106 == null) goto L19;
        String r107 = r106.c();
    L21:
        if (Intrinsics.areEqual(r107, r101) == false) goto L25;
        if (o0.d(r101) == false) goto L25;
    L19:
        r107 = null;
        goto L21
    }
}
