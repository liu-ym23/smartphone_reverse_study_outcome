package com.facebook.fresco.ui.common;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface ControllerListener2<INFO> {

    public static class Extras {

        @Nullable
        public Object callerContext;

        @Nullable
        public Map<String, Object> componentExtras;

        @Nullable
        public Map<String, Object> datasourceExtras;
        public float focusX;
        public float focusY;

        @Nullable
        public Map<String, Object> imageExtras;

        @Nullable
        public Uri mainUri;

        @Nullable
        public Object scaleType;

        @Nullable
        public Map<String, Object> shortcutExtras;
        public int viewportHeight;
        public int viewportWidth;

        public Extras makeExtrasCopy() {
            Extras r100 = new Extras();
            r100.componentExtras = copyMap(this.componentExtras);
            r100.shortcutExtras = copyMap(this.shortcutExtras);
            r100.datasourceExtras = copyMap(this.datasourceExtras);
            r100.imageExtras = copyMap(this.imageExtras);
            r100.callerContext = this.callerContext;
            r100.mainUri = this.mainUri;
            r100.viewportWidth = this.viewportWidth;
            r100.viewportHeight = this.viewportHeight;
            r100.scaleType = this.scaleType;
            r100.focusX = this.focusX;
            r100.focusY = this.focusY;
            return r100;
        }

        public Extras() {
            this.viewportWidth = -1;
            this.viewportHeight = -1;
            this.focusX = -1.0f;
            this.focusY = -1.0f;
        }

        private static Map<String, Object> copyMap(Map<String, Object> r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return new ConcurrentHashMap(r100);
        }

        public static Extras of(@Nullable Map<String, Object> r100) {
            Extras r101 = new Extras();
            r101.componentExtras = r100;
            return r101;
        }
    }

    void onFailure(String r100, @Nullable Throwable r101, @Nullable Extras r102);

    void onFinalImageSet(String r100, @Nullable INFO r101, @Nullable Extras r102);

    void onIntermediateImageFailed(String r100);

    void onIntermediateImageSet(String r100, @Nullable INFO r101);

    void onRelease(String r100, @Nullable Extras r101);

    void onSubmit(String r100, @Nullable Object r101, @Nullable Extras r102);
}
