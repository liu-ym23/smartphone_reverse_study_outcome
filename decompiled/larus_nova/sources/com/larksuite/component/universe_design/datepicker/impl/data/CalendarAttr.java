package com.larksuite.component.universe_design.datepicker.impl.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final class CalendarAttr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SelectState f284796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DateState f284797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MonthState f284798c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/CalendarAttr$DateState;", "", "<init>", "(Ljava/lang/String;I)V", "PAST_DATE", "FUTURE_DATE", "CURRENT_DATE", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DateState extends Enum<DateState> {
        public static final DateState CURRENT_DATE = null;
        public static final DateState FUTURE_DATE = null;
        public static final DateState PAST_DATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DateState[] f284799a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284800b = null;

        public static EnumEntries<DateState> getEntries() {
            return f284800b;
        }

        static {
            DateState r100 = new DateState("PAST_DATE", 0);
            PAST_DATE = r100;
            DateState r101 = new DateState("FUTURE_DATE", 1);
            FUTURE_DATE = r101;
            DateState r102 = new DateState("CURRENT_DATE", 2);
            CURRENT_DATE = r102;
            DateState[] r103 = {r100, r101, r102};
            f284799a = r103;
            f284800b = EnumEntriesKt.enumEntries(r103);
        }

        public static DateState[] values() {
            return (DateState[]) f284799a.clone();
        }

        public static DateState valueOf(String r100) {
            return (DateState) a.a(DateState.class, r100);
        }

        public DateState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/CalendarAttr$MonthState;", "", "<init>", "(Ljava/lang/String;I)V", "CURRENT_MONTH", "LAST_MONTH", "NEXT_MONTH", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MonthState extends Enum<MonthState> {
        public static final MonthState CURRENT_MONTH = null;
        public static final MonthState LAST_MONTH = null;
        public static final MonthState NEXT_MONTH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MonthState[] f284801a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284802b = null;

        public static EnumEntries<MonthState> getEntries() {
            return f284802b;
        }

        static {
            MonthState r100 = new MonthState("CURRENT_MONTH", 0);
            CURRENT_MONTH = r100;
            MonthState r101 = new MonthState("LAST_MONTH", 1);
            LAST_MONTH = r101;
            MonthState r102 = new MonthState("NEXT_MONTH", 2);
            NEXT_MONTH = r102;
            MonthState[] r103 = {r100, r101, r102};
            f284801a = r103;
            f284802b = EnumEntriesKt.enumEntries(r103);
        }

        public static MonthState[] values() {
            return (MonthState[]) f284801a.clone();
        }

        public static MonthState valueOf(String r100) {
            return (MonthState) a.a(MonthState.class, r100);
        }

        public MonthState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/CalendarAttr$SelectState;", "", "<init>", "(Ljava/lang/String;I)V", "SELECT", "UN_SELECT", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SelectState extends Enum<SelectState> {
        public static final SelectState SELECT = null;
        public static final SelectState UN_SELECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SelectState[] f284803a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284804b = null;

        public static EnumEntries<SelectState> getEntries() {
            return f284804b;
        }

        static {
            SelectState r100 = new SelectState("SELECT", 0);
            SELECT = r100;
            SelectState r101 = new SelectState("UN_SELECT", 1);
            UN_SELECT = r101;
            SelectState[] r102 = {r100, r101};
            f284803a = r102;
            f284804b = EnumEntriesKt.enumEntries(r102);
        }

        public static SelectState[] values() {
            return (SelectState[]) f284803a.clone();
        }

        public static SelectState valueOf(String r100) {
            return (SelectState) a.a(SelectState.class, r100);
        }

        public SelectState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalendarAttr) == true) goto L8;
        return false;
    L8:
        CalendarAttr r101 = (CalendarAttr) r100;
        if (this.f284796a == r101.f284796a) goto L12;
        return false;
    L12:
        if (this.f284797b == r101.f284797b) goto L15;
        return false;
    L15:
        if (this.f284798c == r101.f284798c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f284796a.hashCode() * 31) + this.f284797b.hashCode()) * 31) + this.f284798c.hashCode();
    }

    public final String toString() {
        return "CalendarAttr(selectState=" + this.f284796a + ", dateState=" + this.f284797b + ", monthState=" + this.f284798c + ')';
    }

    public CalendarAttr(SelectState r100, DateState r101, MonthState r102) {
        Intrinsics.checkNotNullParameter(r100, "selectState");
        Intrinsics.checkNotNullParameter(r101, "dateState");
        Intrinsics.checkNotNullParameter(r102, "monthState");
        this.f284796a = r100;
        this.f284797b = r101;
        this.f284798c = r102;
    }
}
