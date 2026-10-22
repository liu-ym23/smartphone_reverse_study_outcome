package com.larus.luckydog.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/luckydog/api/LuckyDogCountTaskType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DO_CREATION", "WRITE_WISHES", "COLLECT_PRIZE", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LuckyDogCountTaskType extends Enum<LuckyDogCountTaskType> {
    public static final LuckyDogCountTaskType COLLECT_PRIZE = null;
    public static final a Companion = null;
    public static final LuckyDogCountTaskType DO_CREATION = null;
    public static final LuckyDogCountTaskType WRITE_WISHES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyDogCountTaskType[] f358391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358392b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LuckyDogCountTaskType a(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            return null;
        L13:
            return LuckyDogCountTaskType.COLLECT_PRIZE;
        L14:
            return LuckyDogCountTaskType.WRITE_WISHES;
        L11:
            return LuckyDogCountTaskType.DO_CREATION;
        }
    }

    @JvmStatic
    public static final LuckyDogCountTaskType findByValue(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<LuckyDogCountTaskType> getEntries() {
        return f358392b;
    }

    static {
        LuckyDogCountTaskType r100 = new LuckyDogCountTaskType("DO_CREATION", 0, 0);
        DO_CREATION = r100;
        LuckyDogCountTaskType r101 = new LuckyDogCountTaskType("WRITE_WISHES", 1, 1);
        WRITE_WISHES = r101;
        LuckyDogCountTaskType r102 = new LuckyDogCountTaskType("COLLECT_PRIZE", 2, 2);
        COLLECT_PRIZE = r102;
        LuckyDogCountTaskType[] r103 = {r100, r101, r102};
        f358391a = r103;
        f358392b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static LuckyDogCountTaskType[] values() {
        return (LuckyDogCountTaskType[]) f358391a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static LuckyDogCountTaskType valueOf(String r100) {
        return (LuckyDogCountTaskType) r27.a.a(LuckyDogCountTaskType.class, r100);
    }

    public LuckyDogCountTaskType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
