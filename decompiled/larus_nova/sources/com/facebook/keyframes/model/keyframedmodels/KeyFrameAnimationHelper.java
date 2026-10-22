package com.facebook.keyframes.model.keyframedmodels;

import android.view.animation.Interpolator;
import com.facebook.keyframes.util.KFPathInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KeyFrameAnimationHelper {
    public KeyFrameAnimationHelper() {
    }

    public static List<Interpolator> buildInterpolatorList(float[][][] r110) {
        if (r110 == null) goto L4;
        ArrayList r100 = new ArrayList();
        int r101 = r110.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L9;
        float[][] r103 = r110[r102];
        float[] r104 = r103[0];
        float r105 = r104[0];
        float r106 = r104[1];
        float[] r107 = r103[1];
        r100.add(new KFPathInterpolator(r105, r106, r107[0], r107[1]));
        r102 = r102 + 1;
        goto L6
    L9:
        return Collections.unmodifiableList(r100);
    L4:
        return Collections.emptyList();
    }
}
