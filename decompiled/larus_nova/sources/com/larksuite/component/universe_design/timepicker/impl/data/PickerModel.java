package com.larksuite.component.universe_design.timepicker.impl.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerModel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MONTHDAY_HOUR_MINUTE_12H", "MONTHDAY_HOUR_MINUTE_24H", "HOUR_MINUTE_12H", "HOUR_MINUTE_24H", "YEAR_MONTH_DAY", "MONTH_DAY", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PickerModel extends Enum<PickerModel> {
    public static final a Companion = null;
    public static final PickerModel HOUR_MINUTE_12H = null;
    public static final PickerModel HOUR_MINUTE_24H = null;
    public static final PickerModel MONTHDAY_HOUR_MINUTE_12H = null;
    public static final PickerModel MONTHDAY_HOUR_MINUTE_24H = null;
    public static final PickerModel MONTH_DAY = null;
    public static final PickerModel YEAR_MONTH_DAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PickerModel[] f285395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285396b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<PickerModel> getEntries() {
        return f285396b;
    }

    static {
        PickerModel r100 = new PickerModel("MONTHDAY_HOUR_MINUTE_12H", 0, 0);
        MONTHDAY_HOUR_MINUTE_12H = r100;
        PickerModel r101 = new PickerModel("MONTHDAY_HOUR_MINUTE_24H", 1, 1);
        MONTHDAY_HOUR_MINUTE_24H = r101;
        PickerModel r102 = new PickerModel("HOUR_MINUTE_12H", 2, 2);
        HOUR_MINUTE_12H = r102;
        PickerModel r103 = new PickerModel("HOUR_MINUTE_24H", 3, 3);
        HOUR_MINUTE_24H = r103;
        PickerModel r104 = new PickerModel("YEAR_MONTH_DAY", 4, 4);
        YEAR_MONTH_DAY = r104;
        PickerModel r105 = new PickerModel("MONTH_DAY", 5, 5);
        MONTH_DAY = r105;
        PickerModel[] r110 = {r100, r101, r102, r103, r104, r105};
        f285395a = r110;
        f285396b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static PickerModel[] values() {
        return (PickerModel[]) f285395a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PickerModel valueOf(String r100) {
        return (PickerModel) r27.a.a(PickerModel.class, r100);
    }

    public PickerModel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
