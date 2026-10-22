package com.larksuite.component.universe_design.datepicker.impl.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/MonthShowMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_SIX_ROW", "AUTO_HEIGHT", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MonthShowMode extends Enum<MonthShowMode> {
    public static final MonthShowMode AUTO_HEIGHT = null;
    public static final a Companion = null;
    public static final MonthShowMode FIXED_SIX_ROW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonthShowMode[] f284805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284806b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MonthShowMode> getEntries() {
        return f284806b;
    }

    static {
        MonthShowMode r100 = new MonthShowMode("FIXED_SIX_ROW", 0, 0);
        FIXED_SIX_ROW = r100;
        MonthShowMode r101 = new MonthShowMode("AUTO_HEIGHT", 1, 1);
        AUTO_HEIGHT = r101;
        MonthShowMode[] r102 = {r100, r101};
        f284805a = r102;
        f284806b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static MonthShowMode[] values() {
        return (MonthShowMode[]) f284805a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MonthShowMode valueOf(String r100) {
        return (MonthShowMode) r27.a.a(MonthShowMode.class, r100);
    }

    public MonthShowMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
