package androidx.camera.camera2.internal;

import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TemplateTypeUtil {

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.TemplateTypeUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType = null;

        static {
            int[] r0 = new int[UseCaseConfigFactory.CaptureType.values().length];
            $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType = r0;
            r0[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private TemplateTypeUtil() {
    }

    public static int getCaptureConfigTemplateType(UseCaseConfigFactory.CaptureType r2, int r3) {
        int r4 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[r2.ordinal()];
        if (r4 == 1) goto L8;
        if (r4 == 2) goto L6;
        return 1;
    L6:
        return 3;
    L8:
        if (r3 != 2) goto L11;
        return 5;
    L11:
        return 2;
    }

    public static int getSessionConfigTemplateType(UseCaseConfigFactory.CaptureType r2, int r3) {
        int r4 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[r2.ordinal()];
        if (r4 == 1) goto L8;
        if (r4 == 2) goto L6;
        return 1;
    L6:
        return 3;
    L8:
        if (r3 != 2) goto L11;
        return 5;
    L11:
        return 1;
    }
}
