package com.bytedance.ee.bear.middleground.comment.extension.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/extension/events/ReactionCacheActionType;", "", "<init>", "(Ljava/lang/String;I)V", "CACHE_ADD", "CACHE_DELETE", "REMOVE_CACHE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReactionCacheActionType extends Enum<ReactionCacheActionType> {
    public static final ReactionCacheActionType CACHE_ADD = null;
    public static final ReactionCacheActionType CACHE_DELETE = null;
    public static final ReactionCacheActionType REMOVE_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReactionCacheActionType[] f231581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f231582b = null;

    public static EnumEntries<ReactionCacheActionType> getEntries() {
        return f231582b;
    }

    static {
        ReactionCacheActionType r100 = new ReactionCacheActionType("CACHE_ADD", 0);
        CACHE_ADD = r100;
        ReactionCacheActionType r101 = new ReactionCacheActionType("CACHE_DELETE", 1);
        CACHE_DELETE = r101;
        ReactionCacheActionType r102 = new ReactionCacheActionType("REMOVE_CACHE", 2);
        REMOVE_CACHE = r102;
        ReactionCacheActionType[] r103 = {r100, r101, r102};
        f231581a = r103;
        f231582b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReactionCacheActionType[] values() {
        return (ReactionCacheActionType[]) f231581a.clone();
    }

    public static ReactionCacheActionType valueOf(String r100) {
        return (ReactionCacheActionType) a.a(ReactionCacheActionType.class, r100);
    }

    public ReactionCacheActionType(String r100, int r101) {
        super(r100, r101);
    }
}
