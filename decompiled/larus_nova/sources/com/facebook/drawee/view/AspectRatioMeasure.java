package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class AspectRatioMeasure {

    /* JADX INFO: loaded from: classes3.dex */
    public static class Spec {
        public int height;
        public int width;

        public Spec() {
        }
    }

    public AspectRatioMeasure() {
    }

    private static boolean shouldAdjust(int r100) {
        if (r100 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r100 == (-2)) goto L7;
        return false;
    }

    public static void updateMeasureSpec(Spec r100, float r101, @Nullable ViewGroup.LayoutParams r102, int r103, int r104) {
        if (r101 <= 0.0f) goto L13;
        if (r102 != null) goto L7;
        return;
    L7:
        if (shouldAdjust(r102.height) == false) goto L10;
        r100.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(r100.width) - r103) / r101) + r104), r100.height), 1073741824);
        return;
    L10:
        if (shouldAdjust(r102.width) == false) goto L15;
        r100.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(r100.height) - r104) * r101) + r103), r100.width), 1073741824);
        return;
    L15:
        return;
    }
}
