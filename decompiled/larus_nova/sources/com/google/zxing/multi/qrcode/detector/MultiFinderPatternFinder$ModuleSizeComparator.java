package com.google.zxing.multi.qrcode.detector;

import androidx.camera.video.AudioStats;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final class MultiFinderPatternFinder$ModuleSizeComparator implements Comparator<com.google.zxing.qrcode.detector.a>, Serializable {
    private MultiFinderPatternFinder$ModuleSizeComparator() {
    }

    public /* synthetic */ MultiFinderPatternFinder$ModuleSizeComparator(a r100) {
        this();
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(com.google.zxing.qrcode.detector.a r100, com.google.zxing.qrcode.detector.a r101) {
        r101.getClass();
        r100.getClass();
        double r102 = 0.0f - 0.0f;
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return -1;
    L6:
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        return 1;
    L8:
        return 0;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(com.google.zxing.qrcode.detector.a r100, com.google.zxing.qrcode.detector.a r101) {
        return compare2(r100, r101);
    }
}
