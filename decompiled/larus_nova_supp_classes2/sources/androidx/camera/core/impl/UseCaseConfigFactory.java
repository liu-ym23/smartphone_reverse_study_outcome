package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.InitializationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface UseCaseConfigFactory {
    public static final UseCaseConfigFactory EMPTY_INSTANCE = null;

    public static final enum CaptureType extends Enum<CaptureType> {
        private static final /* synthetic */ CaptureType[] $VALUES = null;
        public static final CaptureType IMAGE_ANALYSIS = null;
        public static final CaptureType IMAGE_CAPTURE = null;
        public static final CaptureType METERING_REPEATING = null;
        public static final CaptureType PREVIEW = null;
        public static final CaptureType STREAM_SHARING = null;
        public static final CaptureType VIDEO_CAPTURE = null;

        private static /* synthetic */ CaptureType[] $values() {
            return new CaptureType[]{IMAGE_CAPTURE, PREVIEW, IMAGE_ANALYSIS, VIDEO_CAPTURE, STREAM_SHARING, METERING_REPEATING};
        }

        static {
            IMAGE_CAPTURE = new CaptureType("IMAGE_CAPTURE", 0);
            PREVIEW = new CaptureType("PREVIEW", 1);
            IMAGE_ANALYSIS = new CaptureType("IMAGE_ANALYSIS", 2);
            VIDEO_CAPTURE = new CaptureType("VIDEO_CAPTURE", 3);
            STREAM_SHARING = new CaptureType("STREAM_SHARING", 4);
            METERING_REPEATING = new CaptureType("METERING_REPEATING", 5);
            $VALUES = $values();
        }

        public static CaptureType[] values() {
            return (CaptureType[]) $VALUES.clone();
        }

        public static CaptureType valueOf(String r1) {
            return (CaptureType) r27.a.a(CaptureType.class, r1);
        }

        private CaptureType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface Provider {
        UseCaseConfigFactory newInstance(Context r1) throws InitializationException;
    }

    Config getConfig(CaptureType r1, int r2);

    static {
        EMPTY_INSTANCE = new AnonymousClass1();
    }
}
