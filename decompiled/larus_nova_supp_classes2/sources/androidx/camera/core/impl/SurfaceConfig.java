package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.internal.utils.SizeUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class SurfaceConfig {
    public static final long DEFAULT_STREAM_USE_CASE_VALUE = 0;

    public static final enum ConfigSize extends Enum<ConfigSize> {
        private static final /* synthetic */ ConfigSize[] $VALUES = null;
        public static final ConfigSize MAXIMUM = null;
        public static final ConfigSize NOT_SUPPORT = null;
        public static final ConfigSize PREVIEW = null;
        public static final ConfigSize RECORD = null;
        public static final ConfigSize ULTRA_MAXIMUM = null;
        public static final ConfigSize VGA = null;
        public static final ConfigSize s1440p = null;
        public static final ConfigSize s720p = null;
        final int mId;

        private static /* synthetic */ ConfigSize[] $values() {
            return new ConfigSize[]{VGA, s720p, PREVIEW, s1440p, RECORD, MAXIMUM, ULTRA_MAXIMUM, NOT_SUPPORT};
        }

        static {
            VGA = new ConfigSize("VGA", 0, 0);
            s720p = new ConfigSize("s720p", 1, 1);
            PREVIEW = new ConfigSize("PREVIEW", 2, 2);
            s1440p = new ConfigSize("s1440p", 3, 3);
            RECORD = new ConfigSize("RECORD", 4, 4);
            MAXIMUM = new ConfigSize("MAXIMUM", 5, 5);
            ULTRA_MAXIMUM = new ConfigSize("ULTRA_MAXIMUM", 6, 6);
            NOT_SUPPORT = new ConfigSize("NOT_SUPPORT", 7, 7);
            $VALUES = $values();
        }

        public static ConfigSize[] values() {
            return (ConfigSize[]) $VALUES.clone();
        }

        public int getId() {
            return this.mId;
        }

        public static ConfigSize valueOf(String r1) {
            return (ConfigSize) r27.a.a(ConfigSize.class, r1);
        }

        private ConfigSize(String r1, int r2, int r3) {
            super(r1, r2);
            this.mId = r3;
        }
    }

    public static final enum ConfigType extends Enum<ConfigType> {
        private static final /* synthetic */ ConfigType[] $VALUES = null;
        public static final ConfigType JPEG = null;
        public static final ConfigType JPEG_R = null;
        public static final ConfigType PRIV = null;
        public static final ConfigType RAW = null;
        public static final ConfigType YUV = null;

        private static /* synthetic */ ConfigType[] $values() {
            return new ConfigType[]{PRIV, YUV, JPEG, JPEG_R, RAW};
        }

        static {
            PRIV = new ConfigType("PRIV", 0);
            YUV = new ConfigType("YUV", 1);
            JPEG = new ConfigType("JPEG", 2);
            JPEG_R = new ConfigType("JPEG_R", 3);
            RAW = new ConfigType("RAW", 4);
            $VALUES = $values();
        }

        public static ConfigType[] values() {
            return (ConfigType[]) $VALUES.clone();
        }

        public static ConfigType valueOf(String r1) {
            return (ConfigType) r27.a.a(ConfigType.class, r1);
        }

        private ConfigType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract ConfigSize getConfigSize();

    public abstract ConfigType getConfigType();

    public abstract long getStreamUseCase();

    public SurfaceConfig() {
    }

    public static ConfigType getConfigType(int r1) {
        if (r1 != 35) goto L7;
        return ConfigType.YUV;
    L7:
        if (r1 != 256) goto L11;
        return ConfigType.JPEG;
    L11:
        if (r1 != 4101) goto L15;
        return ConfigType.JPEG_R;
    L15:
        if (r1 != 32) goto L19;
        return ConfigType.RAW;
    L19:
        return ConfigType.PRIV;
    }

    public final boolean isSupported(SurfaceConfig r3) {
        ConfigType r0 = r3.getConfigType();
        if (r3.getConfigSize().getId() <= getConfigSize().getId()) goto L5;
    L7:
        return false;
    L5:
        if (r0 != getConfigType()) goto L7;
        return true;
    }

    public static SurfaceConfig create(ConfigType r3, ConfigSize r4) {
        return new AutoValue_SurfaceConfig(r3, r4, 0);
    }

    public static SurfaceConfig create(ConfigType r1, ConfigSize r2, long r3) {
        return new AutoValue_SurfaceConfig(r1, r2, r3);
    }

    public static SurfaceConfig transformSurfaceConfig(int r3, int r4, Size r5, SurfaceSizeDefinition r6) {
        ConfigType r0 = getConfigType(r4);
        ConfigSize r1 = ConfigSize.NOT_SUPPORT;
        int r7 = SizeUtil.getArea(r5);
        if (r3 != 1) goto L11;
        if (r7 > SizeUtil.getArea(r6.getS720pSize(r4))) goto L8;
        r1 = ConfigSize.s720p;
    L28:
        return create(r0, r1);
    L8:
        if (r7 > SizeUtil.getArea(r6.getS1440pSize(r4))) goto L28;
        r1 = ConfigSize.s1440p;
        goto L28
    L11:
        if (r7 > SizeUtil.getArea(r6.getAnalysisSize())) goto L14;
        r1 = ConfigSize.VGA;
        goto L28
    L14:
        if (r7 > SizeUtil.getArea(r6.getPreviewSize())) goto L17;
        r1 = ConfigSize.PREVIEW;
        goto L28
    L17:
        if (r7 > SizeUtil.getArea(r6.getRecordSize())) goto L20;
        r1 = ConfigSize.RECORD;
        goto L28
    L20:
        if (r7 > SizeUtil.getArea(r6.getMaximumSize(r4))) goto L22;
        r1 = ConfigSize.MAXIMUM;
        goto L28
    L22:
        Size r8 = r6.getUltraMaximumSize(r4);
        if (r8 == null) goto L28;
        if (r7 > SizeUtil.getArea(r8)) goto L28;
        r1 = ConfigSize.ULTRA_MAXIMUM;
        goto L28
    }
}
