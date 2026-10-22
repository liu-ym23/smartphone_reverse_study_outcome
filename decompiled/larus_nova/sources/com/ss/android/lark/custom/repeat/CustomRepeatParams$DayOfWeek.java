package com.ss.android.lark.custom.repeat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/custom/repeat/CustomRepeatParams$DayOfWeek;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "Companion", "custom-repeat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CustomRepeatParams$DayOfWeek extends Enum<CustomRepeatParams$DayOfWeek> {
    public static final a Companion = null;
    public static final CustomRepeatParams$DayOfWeek FRIDAY = null;
    public static final CustomRepeatParams$DayOfWeek MONDAY = null;
    public static final CustomRepeatParams$DayOfWeek SATURDAY = null;
    public static final CustomRepeatParams$DayOfWeek SUNDAY = null;
    public static final CustomRepeatParams$DayOfWeek THURSDAY = null;
    public static final CustomRepeatParams$DayOfWeek TUESDAY = null;
    public static final CustomRepeatParams$DayOfWeek WEDNESDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomRepeatParams$DayOfWeek[] f420290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420291b = null;
    private final int number;

    public static EnumEntries<CustomRepeatParams$DayOfWeek> getEntries() {
        return f420291b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek$a] */
    static {
        CustomRepeatParams$DayOfWeek r100 = new CustomRepeatParams$DayOfWeek("SUNDAY", 0, 0);
        SUNDAY = r100;
        CustomRepeatParams$DayOfWeek r101 = new CustomRepeatParams$DayOfWeek("MONDAY", 1, 1);
        MONDAY = r101;
        CustomRepeatParams$DayOfWeek r102 = new CustomRepeatParams$DayOfWeek("TUESDAY", 2, 2);
        TUESDAY = r102;
        CustomRepeatParams$DayOfWeek r103 = new CustomRepeatParams$DayOfWeek("WEDNESDAY", 3, 3);
        WEDNESDAY = r103;
        CustomRepeatParams$DayOfWeek r104 = new CustomRepeatParams$DayOfWeek("THURSDAY", 4, 4);
        THURSDAY = r104;
        CustomRepeatParams$DayOfWeek r105 = new CustomRepeatParams$DayOfWeek("FRIDAY", 5, 5);
        FRIDAY = r105;
        CustomRepeatParams$DayOfWeek r110 = new CustomRepeatParams$DayOfWeek("SATURDAY", 6, 6);
        SATURDAY = r110;
        CustomRepeatParams$DayOfWeek[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f420290a = r111;
        f420291b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static CustomRepeatParams$DayOfWeek[] values() {
        return (CustomRepeatParams$DayOfWeek[]) f420290a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static CustomRepeatParams$DayOfWeek valueOf(String r100) {
        return (CustomRepeatParams$DayOfWeek) r27.a.a(CustomRepeatParams$DayOfWeek.class, r100);
    }

    public CustomRepeatParams$DayOfWeek(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
