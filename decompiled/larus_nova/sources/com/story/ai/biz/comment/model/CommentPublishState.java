package com.story.ai.biz.comment.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/story/ai/biz/comment/model/CommentPublishState;", "", "<init>", "(Ljava/lang/String;I)V", "SENDING", "SUCCESS", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentPublishState extends Enum<CommentPublishState> {
    public static final CommentPublishState FAIL = null;
    public static final CommentPublishState SENDING = null;
    public static final CommentPublishState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentPublishState[] f459895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f459896b = null;

    public static EnumEntries<CommentPublishState> getEntries() {
        return f459896b;
    }

    static {
        CommentPublishState r100 = new CommentPublishState("SENDING", 0);
        SENDING = r100;
        CommentPublishState r101 = new CommentPublishState("SUCCESS", 1);
        SUCCESS = r101;
        CommentPublishState r102 = new CommentPublishState("FAIL", 2);
        FAIL = r102;
        CommentPublishState[] r103 = {r100, r101, r102};
        f459895a = r103;
        f459896b = EnumEntriesKt.enumEntries(r103);
    }

    public static CommentPublishState[] values() {
        return (CommentPublishState[]) f459895a.clone();
    }

    public static CommentPublishState valueOf(String r100) {
        return (CommentPublishState) r27.a.a(CommentPublishState.class, r100);
    }

    public CommentPublishState(String r100, int r101) {
        super(r100, r101);
    }
}
