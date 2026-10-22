package com.bytedance.ee.bear.middleground.comment.extension.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/extension/events/ReactionCacheActionType;", "", "<init>", "(Ljava/lang/String;I)V", "CACHE_ADD", "CACHE_DELETE", "REMOVE_CACHE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReactionCacheActionType extends Enum<ReactionCacheActionType> {
    public static final ReactionCacheActionType CACHE_ADD = null;
    public static final ReactionCacheActionType CACHE_DELETE = null;
    public static final ReactionCacheActionType REMOVE_CACHE = null;
    public static final /* synthetic */ ReactionCacheActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReactionCacheActionType> getEntries() {
        return b;
    }

    static {
        ReactionCacheActionType r0 = new ReactionCacheActionType("CACHE_ADD", 0);
        CACHE_ADD = r0;
        ReactionCacheActionType r1 = new ReactionCacheActionType("CACHE_DELETE", 1);
        CACHE_DELETE = r1;
        ReactionCacheActionType r3 = new ReactionCacheActionType("REMOVE_CACHE", 2);
        REMOVE_CACHE = r3;
        ReactionCacheActionType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ReactionCacheActionType[] values() {
        return (ReactionCacheActionType[]) a.clone();
    }

    public static ReactionCacheActionType valueOf(String r1) {
        return (ReactionCacheActionType) a.a(ReactionCacheActionType.class, r1);
    }

    public ReactionCacheActionType(String r1, int r2) {
        super(r1, r2);
    }
}
