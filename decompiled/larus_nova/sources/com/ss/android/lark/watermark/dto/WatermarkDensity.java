package com.ss.android.lark.watermark.dto;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/watermark/dto/WatermarkDensity;", "", "horizontalInterval", "", "verticalInterval", "codeString", "", "<init>", "(Ljava/lang/String;IFFLjava/lang/String;)V", "getHorizontalInterval", "()F", "getVerticalInterval", "getCodeString", "()Ljava/lang/String;", "LOW_DENSITY", "MID_DENSITY", "HIGH_DENSITY", "CONDENSED", "EXTRA_CONDENSED", "MOST_CONDENSED", "Companion", "watermark-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WatermarkDensity extends Enum<WatermarkDensity> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WatermarkDensity[] $VALUES = null;
    public static final WatermarkDensity CONDENSED = null;
    public static final Companion Companion = null;
    public static final WatermarkDensity EXTRA_CONDENSED = null;
    public static final WatermarkDensity HIGH_DENSITY = null;
    public static final WatermarkDensity LOW_DENSITY = null;
    public static final WatermarkDensity MID_DENSITY = null;
    public static final WatermarkDensity MOST_CONDENSED = null;
    private final String codeString;
    private final float horizontalInterval;
    private final float verticalInterval;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/watermark/dto/WatermarkDensity$Companion;", "", "<init>", "()V", "getWatermarkDensity", "Lcom/ss/android/lark/watermark/dto/WatermarkDensity;", "codeString", "", "watermark-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final WatermarkDensity getWatermarkDensity(String r100) {
            int r101 = 0;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L11;
            WatermarkDensity[] r103 = WatermarkDensity.values();
            int r104 = r103.length;
        L13:
            if (r101 >= r104) goto L19;
            WatermarkDensity r105 = r103[r101];
            if (Intrinsics.areEqual(r105.getCodeString(), r100) == true) goto L16;
            r101 = r101 + 1;
            goto L13
        L16:
            return r105;
        L19:
            return WatermarkDensity.MID_DENSITY;
        L11:
            return WatermarkDensity.MID_DENSITY;
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L9
        }
    }

    private static final /* synthetic */ WatermarkDensity[] $values() {
        return new WatermarkDensity[]{LOW_DENSITY, MID_DENSITY, HIGH_DENSITY, CONDENSED, EXTRA_CONDENSED, MOST_CONDENSED};
    }

    public static EnumEntries<WatermarkDensity> getEntries() {
        return $ENTRIES;
    }

    static {
        LOW_DENSITY = new WatermarkDensity("LOW_DENSITY", 0, 64.0f, 40.0f, "0");
        MID_DENSITY = new WatermarkDensity("MID_DENSITY", 1, 32.0f, 40.0f, "1");
        HIGH_DENSITY = new WatermarkDensity("HIGH_DENSITY", 2, 16.0f, 40.0f, "2");
        CONDENSED = new WatermarkDensity("CONDENSED", 3, 16.0f, 28.0f, "3");
        EXTRA_CONDENSED = new WatermarkDensity("EXTRA_CONDENSED", 4, 14.0f, 28.0f, "4");
        MOST_CONDENSED = new WatermarkDensity("MOST_CONDENSED", 5, 12.0f, 28.0f, "5");
        WatermarkDensity[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public static WatermarkDensity[] values() {
        return (WatermarkDensity[]) $VALUES.clone();
    }

    public final String getCodeString() {
        return this.codeString;
    }

    public final float getHorizontalInterval() {
        return this.horizontalInterval;
    }

    public final float getVerticalInterval() {
        return this.verticalInterval;
    }

    public static WatermarkDensity valueOf(String r100) {
        return (WatermarkDensity) a.a(WatermarkDensity.class, r100);
    }

    private WatermarkDensity(String r100, int r101, float r102, float r103, String r104) {
        super(r100, r101);
        this.horizontalInterval = r102;
        this.verticalInterval = r103;
        this.codeString = r104;
    }
}
