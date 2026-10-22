package com.ss.android.lark.watermark.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/watermark/core/WatermarkType;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIEW", "EXPORT", "watermark-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WatermarkType extends Enum<WatermarkType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WatermarkType[] $VALUES = null;
    public static final WatermarkType EXPORT = null;
    public static final WatermarkType PREVIEW = null;

    private static final /* synthetic */ WatermarkType[] $values() {
        return new WatermarkType[]{PREVIEW, EXPORT};
    }

    public static EnumEntries<WatermarkType> getEntries() {
        return $ENTRIES;
    }

    static {
        PREVIEW = new WatermarkType("PREVIEW", 0);
        EXPORT = new WatermarkType("EXPORT", 1);
        WatermarkType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static WatermarkType[] values() {
        return (WatermarkType[]) $VALUES.clone();
    }

    public static WatermarkType valueOf(String r100) {
        return (WatermarkType) a.a(WatermarkType.class, r100);
    }

    private WatermarkType(String r100, int r101) {
        super(r100, r101);
    }
}
