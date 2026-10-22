package androidx.camera.core;

import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CaptureBundles {

    public static final class CaptureBundleImpl implements CaptureBundle {
        final List<CaptureStage> mCaptureStageList;

        @Override // androidx.camera.core.impl.CaptureBundle
        public List<CaptureStage> getCaptureStages() {
            return this.mCaptureStageList;
        }

        public CaptureBundleImpl(List<CaptureStage> r2) {
            if (r2 == null) goto L9;
            if (r2.isEmpty() == true) goto L9;
            this.mCaptureStageList = Collections.unmodifiableList(new ArrayList(r2));
            return;
        L9:
            throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
        }
    }

    private CaptureBundles() {
    }

    public static CaptureBundle singleDefaultCaptureBundle() {
        return createCaptureBundle(new CaptureStage[]{new CaptureStage.DefaultCaptureStage()});
    }

    public static CaptureBundle createCaptureBundle(CaptureStage... r1) {
        return new CaptureBundleImpl(Arrays.asList(r1));
    }

    public static CaptureBundle createCaptureBundle(List<CaptureStage> r1) {
        return new CaptureBundleImpl(r1);
    }
}
