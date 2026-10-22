package com.ss.android.lark.watermark.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/watermark/core/WatermarkPointContext;", "", "<init>", "(Ljava/lang/String;I)V", "CCM", "watermark-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WatermarkPointContext extends Enum<WatermarkPointContext> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WatermarkPointContext[] $VALUES = null;
    public static final WatermarkPointContext CCM = null;

    private static final /* synthetic */ WatermarkPointContext[] $values() {
        return new WatermarkPointContext[]{CCM};
    }

    public static EnumEntries<WatermarkPointContext> getEntries() {
        return $ENTRIES;
    }

    static {
        CCM = new WatermarkPointContext("CCM", 0);
        WatermarkPointContext[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static WatermarkPointContext[] values() {
        return (WatermarkPointContext[]) $VALUES.clone();
    }

    public static WatermarkPointContext valueOf(String r100) {
        return (WatermarkPointContext) a.a(WatermarkPointContext.class, r100);
    }

    private WatermarkPointContext(String r100, int r101) {
        super(r100, r101);
    }
}
