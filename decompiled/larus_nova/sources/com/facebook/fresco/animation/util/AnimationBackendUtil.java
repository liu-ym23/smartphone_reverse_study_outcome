package com.facebook.fresco.animation.util;

import com.facebook.datasource.FrescoOptUtil;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

/* JADX INFO: loaded from: classes23.dex */
public class AnimationBackendUtil {
    public AnimationBackendUtil() {
    }

    public static boolean isUseIndividualCacheForCurrentAnimHeifRequest(boolean r100) {
        if (FrescoOptUtil.isOptHeifAnimDecode() == false) goto L6;
        return false;
    L6:
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheEnabled() == true) goto L10;
        if (r100 == true) goto L9;
        return false;
    L9:
        if (ImagePipelineFactory.getInstance().isAnimatedHeifIndividualCacheForImageRequestEnabled() == true) goto L10;
        return false;
    L10:
        return true;
    }
}
