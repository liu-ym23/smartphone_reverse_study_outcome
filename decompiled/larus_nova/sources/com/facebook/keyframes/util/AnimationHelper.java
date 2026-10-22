package com.facebook.keyframes.util;

import com.facebook.keyframes.model.KFAnimation;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class AnimationHelper {
    public AnimationHelper() {
    }

    public static KFAnimation extractSpecialAnimationAnimationSet(List<KFAnimation> r100, KFAnimation.PropertyType r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = r100.size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        if (r100.get(r103).getPropertyType() == r101) goto L13;
        r103 = r103 + 1;
    L13:
        if (r103 != (-1)) goto L16;
        return null;
    L16:
        return r100.remove(r103);
    L12:
        r103 = -1;
        goto L13
    }
}
