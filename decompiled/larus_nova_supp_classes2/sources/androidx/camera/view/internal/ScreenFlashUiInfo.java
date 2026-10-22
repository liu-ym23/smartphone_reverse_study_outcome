package androidx.camera.view.internal;

import androidx.camera.core.ImageCapture;
import java.util.Objects;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ScreenFlashUiInfo {
    private final ProviderType mProviderType;
    private final ImageCapture.ScreenFlash mScreenFlash;

    public static final enum ProviderType extends Enum<ProviderType> {
        private static final /* synthetic */ ProviderType[] $VALUES = null;
        public static final ProviderType PREVIEW_VIEW = null;
        public static final ProviderType SCREEN_FLASH_VIEW = null;

        private static /* synthetic */ ProviderType[] $values() {
            return new ProviderType[]{PREVIEW_VIEW, SCREEN_FLASH_VIEW};
        }

        static {
            PREVIEW_VIEW = new ProviderType("PREVIEW_VIEW", 0);
            SCREEN_FLASH_VIEW = new ProviderType("SCREEN_FLASH_VIEW", 1);
            $VALUES = $values();
        }

        public static ProviderType[] values() {
            return (ProviderType[]) $VALUES.clone();
        }

        public static ProviderType valueOf(String r1) {
            return (ProviderType) a.a(ProviderType.class, r1);
        }

        private ProviderType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mProviderType, this.mScreenFlash});
    }

    public ProviderType getProviderType() {
        return this.mProviderType;
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ScreenFlashUiInfo) == true) goto L8;
        return false;
    L8:
        ScreenFlashUiInfo r6 = (ScreenFlashUiInfo) r5;
        if (this.mProviderType == r6.mProviderType) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.mScreenFlash, r6.mScreenFlash) == false) goto L13;
        return true;
    }

    public ScreenFlashUiInfo(ProviderType r1, ImageCapture.ScreenFlash r2) {
        this.mProviderType = r1;
        this.mScreenFlash = r2;
    }
}
