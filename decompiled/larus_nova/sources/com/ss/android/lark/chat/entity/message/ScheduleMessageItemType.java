package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItemType;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "QUASI_SCHEDULE_MESSAGE", "SCHEDULE_MESSAGE", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScheduleMessageItemType extends Enum<ScheduleMessageItemType> {
    public static final a Companion = null;
    public static final ScheduleMessageItemType QUASI_SCHEDULE_MESSAGE = null;
    public static final ScheduleMessageItemType SCHEDULE_MESSAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScheduleMessageItemType[] f415308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415309b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ScheduleMessageItemType> getEntries() {
        return f415309b;
    }

    static {
        ScheduleMessageItemType r100 = new ScheduleMessageItemType("QUASI_SCHEDULE_MESSAGE", 0, 1);
        QUASI_SCHEDULE_MESSAGE = r100;
        ScheduleMessageItemType r101 = new ScheduleMessageItemType("SCHEDULE_MESSAGE", 1, 2);
        SCHEDULE_MESSAGE = r101;
        ScheduleMessageItemType[] r102 = {r100, r101};
        f415308a = r102;
        f415309b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ScheduleMessageItemType[] values() {
        return (ScheduleMessageItemType[]) f415308a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final ScheduleMessageItemType fromValue(int r100) {
        Companion.getClass();
        ScheduleMessageItemType[] r101 = values();
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        return r101[r100];
    L11:
        return QUASI_SCHEDULE_MESSAGE;
    L5:
        if (r100 >= r101.length) goto L7;
        r102 = true;
        goto L8
    }

    public static ScheduleMessageItemType valueOf(String r100) {
        return (ScheduleMessageItemType) r27.a.a(ScheduleMessageItemType.class, r100);
    }

    public ScheduleMessageItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
