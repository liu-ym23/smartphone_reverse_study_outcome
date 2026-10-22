package com.lynx.tasm.animation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes32.dex */
public final class AnimationConstant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f381792a = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutAnimationType {
    }

    static {
        f381792a = new int[]{1, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
    }
}
