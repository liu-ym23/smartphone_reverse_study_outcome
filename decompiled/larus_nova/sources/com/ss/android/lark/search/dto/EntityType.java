package com.ss.android.lark.search.dto;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/search/dto/EntityType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHATTER", "CHAT", "toString", "", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntityType extends Enum<EntityType> {
    public static final EntityType CHAT = null;
    public static final EntityType CHATTER = null;
    public static final a Companion = null;
    public static final EntityType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntityType[] f440121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440122b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EntityType> getEntries() {
        return f440122b;
    }

    static {
        EntityType r100 = new EntityType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        EntityType r101 = new EntityType("CHATTER", 1, 1);
        CHATTER = r101;
        EntityType r102 = new EntityType("CHAT", 2, 2);
        CHAT = r102;
        EntityType[] r103 = {r100, r101, r102};
        f440121a = r103;
        f440122b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static EntityType[] values() {
        return (EntityType[]) f440121a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 1) goto L5;
        return "CHATTER";
    L5:
        if (r100 == 2) goto L7;
        return "UNKNOWN";
    L7:
        return "CHAT";
    }

    public final int getValue() {
        return this.value;
    }

    public static EntityType valueOf(String r100) {
        return (EntityType) r27.a.a(EntityType.class, r100);
    }

    public EntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
