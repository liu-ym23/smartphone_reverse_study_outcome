package com.ss.android.lark.time.format.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/time/format/entity/DatePreciseness;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "DAY", "MONTH", "Companion", "time-format_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DatePreciseness extends Enum<DatePreciseness> {
    public static final a Companion = null;
    public static final DatePreciseness DAY = null;
    public static final DatePreciseness MONTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DatePreciseness[] f441328a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441329b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DatePreciseness> getEntries() {
        return f441329b;
    }

    static {
        DatePreciseness r100 = new DatePreciseness("DAY", 0, 0);
        DAY = r100;
        DatePreciseness r101 = new DatePreciseness("MONTH", 1, 1);
        MONTH = r101;
        DatePreciseness[] r102 = {r100, r101};
        f441328a = r102;
        f441329b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static DatePreciseness[] values() {
        return (DatePreciseness[]) f441328a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final DatePreciseness forNumber(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L11;
        return DAY;
    L11:
        return MONTH;
    L9:
        return DAY;
    }

    @JvmStatic
    public static final DatePreciseness valueOf(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L11;
        return DAY;
    L11:
        return MONTH;
    L9:
        return DAY;
    }

    public static DatePreciseness valueOf(String r100) {
        return (DatePreciseness) r27.a.a(DatePreciseness.class, r100);
    }

    public DatePreciseness(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
