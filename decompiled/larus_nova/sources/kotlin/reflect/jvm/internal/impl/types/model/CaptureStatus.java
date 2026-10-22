package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum CaptureStatus extends Enum<CaptureStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CaptureStatus[] $VALUES = null;
    public static final CaptureStatus FOR_INCORPORATION = null;
    public static final CaptureStatus FOR_SUBTYPING = null;
    public static final CaptureStatus FROM_EXPRESSION = null;

    private static final /* synthetic */ CaptureStatus[] $values() {
        return new CaptureStatus[]{FOR_SUBTYPING, FOR_INCORPORATION, FROM_EXPRESSION};
    }

    static {
        FOR_SUBTYPING = new CaptureStatus("FOR_SUBTYPING", 0);
        FOR_INCORPORATION = new CaptureStatus("FOR_INCORPORATION", 1);
        FROM_EXPRESSION = new CaptureStatus("FROM_EXPRESSION", 2);
        CaptureStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static CaptureStatus[] values() {
        return (CaptureStatus[]) $VALUES.clone();
    }

    public static CaptureStatus valueOf(String r100) {
        return (CaptureStatus) a.a(CaptureStatus.class, r100);
    }

    private CaptureStatus(String r100, int r101) {
        super(r100, r101);
    }
}
