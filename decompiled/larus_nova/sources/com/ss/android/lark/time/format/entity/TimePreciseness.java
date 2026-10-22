package com.ss.android.lark.time.format.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/time/format/entity/TimePreciseness;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "HOUR", "MINUTE", "SECOND", "Companion", "time-format_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TimePreciseness extends Enum<TimePreciseness> {
    public static final a Companion = null;
    public static final TimePreciseness HOUR = null;
    public static final TimePreciseness MINUTE = null;
    public static final TimePreciseness SECOND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimePreciseness[] f441334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441335b = null;
    private final int number;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TimePreciseness a(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            return TimePreciseness.MINUTE;
        L13:
            return TimePreciseness.SECOND;
        L14:
            return TimePreciseness.MINUTE;
        L11:
            return TimePreciseness.HOUR;
        }
    }

    @JvmStatic
    public static final TimePreciseness forNumber(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<TimePreciseness> getEntries() {
        return f441335b;
    }

    static {
        TimePreciseness r100 = new TimePreciseness("HOUR", 0, 0);
        HOUR = r100;
        TimePreciseness r101 = new TimePreciseness("MINUTE", 1, 1);
        MINUTE = r101;
        TimePreciseness r102 = new TimePreciseness("SECOND", 2, 2);
        SECOND = r102;
        TimePreciseness[] r103 = {r100, r101, r102};
        f441334a = r103;
        f441335b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TimePreciseness[] values() {
        return (TimePreciseness[]) f441334a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final TimePreciseness valueOf(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static TimePreciseness valueOf(String r100) {
        return (TimePreciseness) r27.a.a(TimePreciseness.class, r100);
    }

    public TimePreciseness(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
