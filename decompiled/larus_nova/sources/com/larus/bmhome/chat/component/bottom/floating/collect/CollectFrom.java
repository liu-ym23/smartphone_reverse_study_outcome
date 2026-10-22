package com.larus.bmhome.chat.component.bottom.floating.collect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/collect/CollectFrom;", "", "<init>", "(Ljava/lang/String;I)V", "COPY", "LIKE", "COLLECT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CollectFrom extends Enum<CollectFrom> {
    public static final CollectFrom COLLECT = null;
    public static final CollectFrom COPY = null;
    public static final CollectFrom LIKE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollectFrom[] f299613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f299614b = null;

    public static EnumEntries<CollectFrom> getEntries() {
        return f299614b;
    }

    static {
        CollectFrom r100 = new CollectFrom("COPY", 0);
        COPY = r100;
        CollectFrom r101 = new CollectFrom("LIKE", 1);
        LIKE = r101;
        CollectFrom r102 = new CollectFrom("COLLECT", 2);
        COLLECT = r102;
        CollectFrom[] r103 = {r100, r101, r102};
        f299613a = r103;
        f299614b = EnumEntriesKt.enumEntries(r103);
    }

    public static CollectFrom[] values() {
        return (CollectFrom[]) f299613a.clone();
    }

    public static CollectFrom valueOf(String r100) {
        return (CollectFrom) a.a(CollectFrom.class, r100);
    }

    public CollectFrom(String r100, int r101) {
        super(r100, r101);
    }
}
