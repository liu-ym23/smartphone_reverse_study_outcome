package com.bytedance.android.shopping.deepfeed.action;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/action/DeepFeedCommentClickArea;", "", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "Container", "ContentImageContainer", "CommentContent", "Avatar", "ContentText", "ContentMore", "ImpressionWords", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DeepFeedCommentClickArea extends Enum<DeepFeedCommentClickArea> {
    public static final DeepFeedCommentClickArea Avatar = null;
    public static final DeepFeedCommentClickArea CommentContent = null;
    public static final DeepFeedCommentClickArea Container = null;
    public static final DeepFeedCommentClickArea ContentImageContainer = null;
    public static final DeepFeedCommentClickArea ContentMore = null;
    public static final DeepFeedCommentClickArea ContentText = null;
    public static final DeepFeedCommentClickArea ImpressionWords = null;
    public static final /* synthetic */ DeepFeedCommentClickArea[] a = null;
    private final String str;

    static {
        DeepFeedCommentClickArea r1 = new DeepFeedCommentClickArea("Container", 0, "container");
        Container = r1;
        DeepFeedCommentClickArea r2 = new DeepFeedCommentClickArea("ContentImageContainer", 1, "image");
        ContentImageContainer = r2;
        DeepFeedCommentClickArea r3 = new DeepFeedCommentClickArea("CommentContent", 2, "comment_content");
        CommentContent = r3;
        DeepFeedCommentClickArea r4 = new DeepFeedCommentClickArea("Avatar", 3, "avatar");
        Avatar = r4;
        DeepFeedCommentClickArea r5 = new DeepFeedCommentClickArea("ContentText", 4, "text");
        ContentText = r5;
        DeepFeedCommentClickArea r6 = new DeepFeedCommentClickArea("ContentMore", 5, "more");
        ContentMore = r6;
        DeepFeedCommentClickArea r7 = new DeepFeedCommentClickArea("ImpressionWords", 6, "word");
        ImpressionWords = r7;
        a = new DeepFeedCommentClickArea[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static DeepFeedCommentClickArea valueOf(String r1) {
        return (DeepFeedCommentClickArea) r27.a.a(DeepFeedCommentClickArea.class, r1);
    }

    public static DeepFeedCommentClickArea[] values() {
        return (DeepFeedCommentClickArea[]) a.clone();
    }

    public final String getStr() {
        return this.str;
    }

    public DeepFeedCommentClickArea(String r1, int r2, String r3) {
        super(r1, r2);
        this.str = r3;
    }
}
