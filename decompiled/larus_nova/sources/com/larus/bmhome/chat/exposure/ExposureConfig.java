package com.larus.bmhome.chat.exposure;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExposureConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f302949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f302950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExposureMode f302951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f302952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f302953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StrategyType f302954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f302955g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/exposure/ExposureConfig$ExposureMode;", "", "<init>", "(Ljava/lang/String;I)V", "AREA_RATIO", "TOP_EDGE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExposureMode extends Enum<ExposureMode> {
        public static final ExposureMode AREA_RATIO = null;
        public static final ExposureMode TOP_EDGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExposureMode[] f302956a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f302957b = null;

        public static EnumEntries<ExposureMode> getEntries() {
            return f302957b;
        }

        static {
            ExposureMode r100 = new ExposureMode("AREA_RATIO", 0);
            AREA_RATIO = r100;
            ExposureMode r101 = new ExposureMode("TOP_EDGE", 1);
            TOP_EDGE = r101;
            ExposureMode[] r102 = {r100, r101};
            f302956a = r102;
            f302957b = EnumEntriesKt.enumEntries(r102);
        }

        public static ExposureMode[] values() {
            return (ExposureMode[]) f302956a.clone();
        }

        public static ExposureMode valueOf(String r100) {
            return (ExposureMode) r27.a.a(ExposureMode.class, r100);
        }

        public ExposureMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/exposure/ExposureConfig$StrategyType;", "", "<init>", "(Ljava/lang/String;I)V", "ALL_VISIBLE", "BOTTOM_MOST", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StrategyType extends Enum<StrategyType> {
        public static final StrategyType ALL_VISIBLE = null;
        public static final StrategyType BOTTOM_MOST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StrategyType[] f302958a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f302959b = null;

        public static EnumEntries<StrategyType> getEntries() {
            return f302959b;
        }

        static {
            StrategyType r100 = new StrategyType("ALL_VISIBLE", 0);
            ALL_VISIBLE = r100;
            StrategyType r101 = new StrategyType("BOTTOM_MOST", 1);
            BOTTOM_MOST = r101;
            StrategyType[] r102 = {r100, r101};
            f302958a = r102;
            f302959b = EnumEntriesKt.enumEntries(r102);
        }

        public static StrategyType[] values() {
            return (StrategyType[]) f302958a.clone();
        }

        public static StrategyType valueOf(String r100) {
            return (StrategyType) r27.a.a(StrategyType.class, r100);
        }

        public StrategyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f302960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f302961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ExposureMode f302962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f302963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f302964e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public StrategyType f302965f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f302966g;

        public a() {
            this.f302961b = 1.0f;
            this.f302962c = ExposureMode.AREA_RATIO;
            this.f302963d = 0.5f;
            this.f302964e = 2000;
            this.f302965f = StrategyType.BOTTOM_MOST;
            this.f302966g = 16;
        }
    }

    public ExposureConfig() {
        this(0.0f, 1.0f, ExposureMode.AREA_RATIO, 0.5f, 2000, StrategyType.BOTTOM_MOST, 16);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExposureConfig) == true) goto L8;
        return false;
    L8:
        ExposureConfig r101 = (ExposureConfig) r100;
        if (Float.compare(this.f302949a, r101.f302949a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f302950b, r101.f302950b) == 0) goto L15;
        return false;
    L15:
        if (this.f302951c == r101.f302951c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f302952d, r101.f302952d) == 0) goto L21;
        return false;
    L21:
        if (this.f302953e == r101.f302953e) goto L24;
        return false;
    L24:
        if (this.f302954f == r101.f302954f) goto L27;
        return false;
    L27:
        if (this.f302955g == r101.f302955g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((Float.floatToIntBits(this.f302949a) * 31) + Float.floatToIntBits(this.f302950b)) * 31) + this.f302951c.hashCode()) * 31) + Float.floatToIntBits(this.f302952d)) * 31) + this.f302953e) * 31) + this.f302954f.hashCode()) * 31;
        long r101 = this.f302955g;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "ExposureConfig(effectiveAreaStart=" + this.f302949a + ", effectiveAreaEnd=" + this.f302950b + ", exposureMode=" + this.f302951c + ", minExposureRatio=" + this.f302952d + ", maxFlingVelocity=" + this.f302953e + ", strategy=" + this.f302954f + ", debounceIntervalMs=" + this.f302955g + ')';
    }

    public ExposureConfig(float r100, float r101, ExposureMode r102, float r103, int r104, StrategyType r105, long r106) {
        Intrinsics.checkNotNullParameter(r102, "exposureMode");
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f302949a = r100;
        this.f302950b = r101;
        this.f302951c = r102;
        this.f302952d = r103;
        this.f302953e = r104;
        this.f302954f = r105;
        this.f302955g = r106;
    }
}
