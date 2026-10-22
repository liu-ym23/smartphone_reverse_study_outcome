package com.bytedance.applet.aibridge.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applet/aibridge/calendar/UpdateCalendarType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "ADD", "UPDATE", "DELETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateCalendarType extends Enum<UpdateCalendarType> {
    public static final UpdateCalendarType ADD = null;
    public static final UpdateCalendarType DELETE = null;
    public static final UpdateCalendarType UPDATE = null;
    public static final /* synthetic */ UpdateCalendarType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<UpdateCalendarType> getEntries() {
        return b;
    }

    static {
        UpdateCalendarType r0 = new UpdateCalendarType("ADD", 0, 0);
        ADD = r0;
        UpdateCalendarType r1 = new UpdateCalendarType("UPDATE", 1, 1);
        UPDATE = r1;
        UpdateCalendarType r3 = new UpdateCalendarType("DELETE", 2, 2);
        DELETE = r3;
        UpdateCalendarType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UpdateCalendarType[] values() {
        return (UpdateCalendarType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static UpdateCalendarType valueOf(String r1) {
        return (UpdateCalendarType) a.a(UpdateCalendarType.class, r1);
    }

    public UpdateCalendarType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
