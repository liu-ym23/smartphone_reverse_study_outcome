package com.larus.login.impl.agegate;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/login/impl/agegate/AgeRange;", "", "startAge", "", "endAge", "scope", "showText", "", "<init>", "(Ljava/lang/String;IIIILjava/lang/String;)V", "getStartAge", "()I", "getEndAge", "getScope", "getShowText", "()Ljava/lang/String;", "RANGE_2_12", "RANGE_13_17", "RANGE_18_24", "RANGE_25_40", "RANGE_41_60", "RANGE_61_100", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AgeRange extends Enum<AgeRange> {
    public static final AgeRange RANGE_13_17 = null;
    public static final AgeRange RANGE_18_24 = null;
    public static final AgeRange RANGE_25_40 = null;
    public static final AgeRange RANGE_2_12 = null;
    public static final AgeRange RANGE_41_60 = null;
    public static final AgeRange RANGE_61_100 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AgeRange[] f357308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f357309b = null;
    private final int endAge;
    private final int scope;
    private final String showText;
    private final int startAge;

    public static EnumEntries<AgeRange> getEntries() {
        return f357309b;
    }

    static {
        AgeRange r100 = new AgeRange("RANGE_2_12", 0, 2, 12, 1, "2 - 12");
        RANGE_2_12 = r100;
        AgeRange r101 = new AgeRange("RANGE_13_17", 1, 13, 17, 2, "13 - 17");
        RANGE_13_17 = r101;
        AgeRange r102 = new AgeRange("RANGE_18_24", 2, 18, 24, 3, "18 - 24");
        RANGE_18_24 = r102;
        AgeRange r103 = new AgeRange("RANGE_25_40", 3, 25, 40, 4, "25 - 40");
        RANGE_25_40 = r103;
        AgeRange r104 = new AgeRange("RANGE_41_60", 4, 41, 60, 5, "41 - 60");
        RANGE_41_60 = r104;
        AgeRange r105 = new AgeRange("RANGE_61_100", 5, 61, 100, 6, "61+");
        RANGE_61_100 = r105;
        AgeRange[] r106 = {r100, r101, r102, r103, r104, r105};
        f357308a = r106;
        f357309b = EnumEntriesKt.enumEntries(r106);
    }

    public static AgeRange[] values() {
        return (AgeRange[]) f357308a.clone();
    }

    public final int getEndAge() {
        return this.endAge;
    }

    public final int getScope() {
        return this.scope;
    }

    public final String getShowText() {
        return this.showText;
    }

    public final int getStartAge() {
        return this.startAge;
    }

    public static AgeRange valueOf(String r100) {
        return (AgeRange) r27.a.a(AgeRange.class, r100);
    }

    public AgeRange(String r100, int r101, int r102, int r103, int r104, String r105) {
        super(r100, r101);
        this.startAge = r102;
        this.endAge = r103;
        this.scope = r104;
        this.showText = r105;
    }
}
