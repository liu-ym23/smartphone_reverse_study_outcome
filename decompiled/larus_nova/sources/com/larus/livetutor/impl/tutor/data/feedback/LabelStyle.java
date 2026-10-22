package com.larus.livetutor.impl.tutor.data.feedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/livetutor/impl/tutor/data/feedback/LabelStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LABEL_NORMAL", "LABEL_SAME_WIDTH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LabelStyle extends Enum<LabelStyle> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LabelStyle[] $VALUES = null;
    public static final LabelStyle LABEL_NORMAL = null;
    public static final LabelStyle LABEL_SAME_WIDTH = null;

    private static final /* synthetic */ LabelStyle[] $values() {
        return new LabelStyle[]{LABEL_NORMAL, LABEL_SAME_WIDTH};
    }

    public static EnumEntries<LabelStyle> getEntries() {
        return $ENTRIES;
    }

    static {
        LABEL_NORMAL = new LabelStyle("LABEL_NORMAL", 0);
        LABEL_SAME_WIDTH = new LabelStyle("LABEL_SAME_WIDTH", 1);
        LabelStyle[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LabelStyle[] values() {
        return (LabelStyle[]) $VALUES.clone();
    }

    public static LabelStyle valueOf(String r100) {
        return (LabelStyle) r27.a.a(LabelStyle.class, r100);
    }

    private LabelStyle(String r100, int r101) {
        super(r100, r101);
    }
}
