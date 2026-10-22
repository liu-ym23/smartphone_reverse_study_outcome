package com.story.ai.biz.comment.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/story/ai/biz/comment/api/CommentPageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "LOADING", "ERROR", "SUCCESS", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentPageStatus extends Enum<CommentPageStatus> {
    public static final CommentPageStatus EMPTY = null;
    public static final CommentPageStatus ERROR = null;
    public static final CommentPageStatus LOADING = null;
    public static final CommentPageStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentPageStatus[] f459846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f459847b = null;

    public static EnumEntries<CommentPageStatus> getEntries() {
        return f459847b;
    }

    static {
        CommentPageStatus r100 = new CommentPageStatus("EMPTY", 0);
        EMPTY = r100;
        CommentPageStatus r101 = new CommentPageStatus("LOADING", 1);
        LOADING = r101;
        CommentPageStatus r102 = new CommentPageStatus("ERROR", 2);
        ERROR = r102;
        CommentPageStatus r103 = new CommentPageStatus("SUCCESS", 3);
        SUCCESS = r103;
        CommentPageStatus[] r104 = {r100, r101, r102, r103};
        f459846a = r104;
        f459847b = EnumEntriesKt.enumEntries(r104);
    }

    public static CommentPageStatus[] values() {
        return (CommentPageStatus[]) f459846a.clone();
    }

    public static CommentPageStatus valueOf(String r100) {
        return (CommentPageStatus) a.a(CommentPageStatus.class, r100);
    }

    public CommentPageStatus(String r100, int r101) {
        super(r100, r101);
    }
}
