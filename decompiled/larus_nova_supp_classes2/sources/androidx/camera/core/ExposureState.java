package androidx.camera.core;

import android.util.Range;
import android.util.Rational;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ExposureState {
    int getExposureCompensationIndex();

    Range<Integer> getExposureCompensationRange();

    Rational getExposureCompensationStep();

    boolean isExposureCompensationSupported();
}
