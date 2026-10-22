package com.bytedance.timon.calendar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timon/calendar/Frequency;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "DAILY", "WEEKLY", "MONTHLY", "YEARLY", "permission-keeper-calendar_release"}, k = 1, mv = {1, 7, 1})
public final enum Frequency extends Enum<Frequency> {
    public static final Frequency DAILY = null;
    public static final Frequency MONTHLY = null;
    public static final Frequency WEEKLY = null;
    public static final Frequency YEARLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Frequency[] f270566a = null;
    private final String value;

    public static Frequency valueOf(String r100) {
        return (Frequency) r27.a.a(Frequency.class, r100);
    }

    public static Frequency[] values() {
        return (Frequency[]) f270566a.clone();
    }

    static {
        Frequency r100 = new Frequency("DAILY", 0, "DAILY");
        DAILY = r100;
        Frequency r101 = new Frequency("WEEKLY", 1, "WEEKLY");
        WEEKLY = r101;
        Frequency r102 = new Frequency("MONTHLY", 2, "MONTHLY");
        MONTHLY = r102;
        Frequency r103 = new Frequency("YEARLY", 3, "YEARLY");
        YEARLY = r103;
        f270566a = new Frequency[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public Frequency(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
