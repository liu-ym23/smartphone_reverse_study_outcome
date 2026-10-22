package com.larus.xbridge.custom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/xbridge/custom/GuideType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_DIALOG", "WALLET", "CASH_OUT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum GuideType extends Enum<GuideType> {
    public static final GuideType CASH_OUT = null;
    public static final a Companion = null;
    public static final GuideType NO_DIALOG = null;
    public static final GuideType WALLET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GuideType[] f379679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f379680b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<GuideType> getEntries() {
        return f379680b;
    }

    static {
        GuideType r100 = new GuideType("NO_DIALOG", 0, 0);
        NO_DIALOG = r100;
        GuideType r101 = new GuideType("WALLET", 1, 1);
        WALLET = r101;
        GuideType r102 = new GuideType("CASH_OUT", 2, 2);
        CASH_OUT = r102;
        GuideType[] r103 = {r100, r101, r102};
        f379679a = r103;
        f379680b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static GuideType[] values() {
        return (GuideType[]) f379679a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GuideType valueOf(String r100) {
        return (GuideType) r27.a.a(GuideType.class, r100);
    }

    public GuideType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
