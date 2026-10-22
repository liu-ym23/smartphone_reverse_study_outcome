package com.larus.platform.model.comment.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentItemCustomType;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "FAIL", "EMPTY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentItemCustomType extends Enum<CommentItemCustomType> {
    public static final CommentItemCustomType EMPTY = null;
    public static final CommentItemCustomType FAIL = null;
    public static final CommentItemCustomType LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentItemCustomType[] f365621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365622b = null;

    public static EnumEntries<CommentItemCustomType> getEntries() {
        return f365622b;
    }

    static {
        CommentItemCustomType r100 = new CommentItemCustomType("LOADING", 0);
        LOADING = r100;
        CommentItemCustomType r101 = new CommentItemCustomType("FAIL", 1);
        FAIL = r101;
        CommentItemCustomType r102 = new CommentItemCustomType("EMPTY", 2);
        EMPTY = r102;
        CommentItemCustomType[] r103 = {r100, r101, r102};
        f365621a = r103;
        f365622b = EnumEntriesKt.enumEntries(r103);
    }

    public static CommentItemCustomType[] values() {
        return (CommentItemCustomType[]) f365621a.clone();
    }

    public static CommentItemCustomType valueOf(String r100) {
        return (CommentItemCustomType) a.a(CommentItemCustomType.class, r100);
    }

    public CommentItemCustomType(String r100, int r101) {
        super(r100, r101);
    }
}
