package com.ss.android.lark.time.format.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/time/format/entity/LengthType;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "LONG", "SHORT", "MIN", "Companion", "time-format_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LengthType extends Enum<LengthType> {
    public static final a Companion = null;
    public static final LengthType LONG = null;
    public static final LengthType MIN = null;
    public static final LengthType SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LengthType[] f441332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441333b = null;
    private final int number;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LengthType a(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            return LengthType.LONG;
        L13:
            return LengthType.MIN;
        L14:
            return LengthType.SHORT;
        L11:
            return LengthType.LONG;
        }
    }

    @JvmStatic
    public static final LengthType forNumber(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<LengthType> getEntries() {
        return f441333b;
    }

    static {
        LengthType r100 = new LengthType("LONG", 0, 0);
        LONG = r100;
        LengthType r101 = new LengthType("SHORT", 1, 1);
        SHORT = r101;
        LengthType r102 = new LengthType("MIN", 2, 2);
        MIN = r102;
        LengthType[] r103 = {r100, r101, r102};
        f441332a = r103;
        f441333b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static LengthType[] values() {
        return (LengthType[]) f441332a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final LengthType valueOf(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static LengthType valueOf(String r100) {
        return (LengthType) r27.a.a(LengthType.class, r100);
    }

    public LengthType(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
