package com.story.ai.biz.comment.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.platform.model.comment.CommentContent;
import com.larus.platform.model.comment.CommentInfo;
import com.larus.platform.model.comment.LikeInfo;
import com.story.ai.biz.comment.model.BaseComment;
import com.story.ai.biz.comment.model.CommentSection;
import com.story.ai.biz.comment.model.ExpandAndCollapseCommentItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0017¨\u0006\n"}, d2 = {"Lcom/story/ai/biz/comment/adapter/CommentItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/story/ai/biz/comment/model/CommentSection;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentItemDiffCallback extends DiffUtil.ItemCallback<CommentSection> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommentItemDiffCallback f459780a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f459781a = null;

        static {
            int[] r100 = new int[CommentSection.CommentItemType.values().length];
            r100[CommentSection.CommentItemType.PARENT_COMMENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[CommentSection.CommentItemType.CHILD_COMMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[CommentSection.CommentItemType.EXPAND_COLLAPSE_COMMENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[CommentSection.CommentItemType.FOOTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[CommentSection.CommentItemType.CUSTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[CommentSection.CommentItemType.LOADING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[CommentSection.CommentItemType.EMPTY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[CommentSection.CommentItemType.FAIL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[CommentSection.CommentItemType.UNKNOWN.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f459781a = r100;
        }
    }

    static {
        f459780a = new CommentItemDiffCallback();
    }

    private CommentItemDiffCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(CommentSection r100, CommentSection r101) {
        CommentSection r102 = r100;
        CommentSection r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        switch(a.f459781a[r103.getCommentItemType().ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L8;
            case 4: goto L76;
            case 5: goto L75;
            case 6: goto L76;
            case 7: goto L76;
            case 8: goto L76;
            case 9: goto L7;
            default: goto L5;
        };
    L8:
        ExpandAndCollapseCommentItem r104 = (ExpandAndCollapseCommentItem) r102;
        ExpandAndCollapseCommentItem r105 = (ExpandAndCollapseCommentItem) r103;
        if (Intrinsics.areEqual(r104.getContent(), r105.getContent()) == false) goto L76;
        if (r104.getState() != r105.getState()) goto L76;
    L13:
        BaseComment r106 = (BaseComment) r102;
        if (r106.getCommentData() == null) goto L76;
        CommentInfo r107 = r106.getCommentData();
        Long r108 = null;
        if (r107 == null) goto L19;
        CommentContent r109 = r107.e();
    L20:
        BaseComment r110 = (BaseComment) r103;
        CommentInfo r111 = r110.getCommentData();
        if (r111 == null) goto L23;
        CommentContent r112 = r111.e();
    L25:
        if (Intrinsics.areEqual(r109, r112) == false) goto L76;
        CommentInfo r113 = r106.getCommentData();
        if (r113 == null) goto L29;
        Long r114 = r113.g();
    L30:
        CommentInfo r115 = r110.getCommentData();
        if (r115 == null) goto L33;
        Long r116 = r115.g();
    L35:
        if (Intrinsics.areEqual(r114, r116) == false) goto L76;
        CommentInfo r117 = r106.getCommentData();
        if (r117 == null) goto L41;
        LikeInfo r118 = r117.i();
        if (r118 == null) goto L41;
        Integer r119 = r118.b();
    L42:
        CommentInfo r120 = r110.getCommentData();
        if (r120 == null) goto L47;
        LikeInfo r121 = r120.i();
        if (r121 == null) goto L47;
        Integer r122 = r121.b();
    L49:
        if (Intrinsics.areEqual(r119, r122) == false) goto L76;
        CommentInfo r123 = r106.getCommentData();
        if (r123 == null) goto L55;
        LikeInfo r124 = r123.i();
        if (r124 == null) goto L55;
        Long r125 = r124.a();
    L56:
        CommentInfo r126 = r110.getCommentData();
        if (r126 == null) goto L62;
        LikeInfo r127 = r126.i();
        if (r127 == null) goto L62;
        r108 = r127.a();
    L62:
        if (Intrinsics.areEqual(r125, r108) == false) goto L76;
        if (r106.getSendState() != r110.getSendState()) goto L76;
        if (r106.getShowBgFlashing() != r110.getShowBgFlashing()) goto L76;
        if (r106.isPin() != r110.isPin()) goto L76;
        if (r106.isCreator() != r110.isCreator()) goto L76;
        if (r106.isSelfComment() != r110.isSelfComment()) goto L76;
        if (r106.isCacheData() != r110.isCacheData()) goto L76;
    L55:
        r125 = null;
    L47:
        r122 = null;
    L41:
        r119 = null;
        goto L42
    L33:
        r116 = null;
        goto L35
    L29:
        r114 = null;
        goto L30
    L23:
        r112 = null;
        goto L25
    L19:
        r109 = null;
    L75:
        return true;
    L76:
        return false;
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalArgumentException("unknown item type");
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(CommentSection r100, CommentSection r101) {
        CommentSection r102 = r100;
        CommentSection r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.getCommentItemType() == r103.getCommentItemType()) goto L6;
        return false;
    L6:
        switch(a.f459781a[r103.getCommentItemType().ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L23;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L10;
            default: goto L8;
        };
    L13:
        return true;
    L14:
        CommentInfo r104 = ((BaseComment) r102).getCommentData();
        String r105 = null;
        if (r104 == null) goto L17;
        String r106 = r104.c();
    L18:
        CommentInfo r107 = ((BaseComment) r103).getCommentData();
        if (r107 == null) goto L22;
        r105 = r107.c();
    L22:
        return Intrinsics.areEqual(r106, r105);
    L17:
        r106 = null;
        goto L18
    L23:
        return false;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        throw new IllegalArgumentException("unknown item type");
    L12:
        if (r102.getCommentItemType() == r103.getCommentItemType()) goto L13;
        return false;
    }
}
