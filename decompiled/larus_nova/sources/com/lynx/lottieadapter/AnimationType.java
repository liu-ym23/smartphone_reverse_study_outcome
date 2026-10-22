package com.lynx.lottieadapter;

import r27.a;

/* JADX INFO: loaded from: classes4.dex */
public final enum AnimationType extends Enum<AnimationType> {
    public static final AnimationType ANIMAX = null;
    public static final AnimationType EMPTY = null;
    public static final AnimationType LOTTIE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationType[] f381380a = null;

    static {
        AnimationType r100 = new AnimationType("LOTTIE", 0);
        LOTTIE = r100;
        AnimationType r101 = new AnimationType("ANIMAX", 1);
        ANIMAX = r101;
        AnimationType r102 = new AnimationType("EMPTY", 2);
        EMPTY = r102;
        f381380a = new AnimationType[]{r100, r101, r102};
    }

    public static AnimationType[] values() {
        return (AnimationType[]) f381380a.clone();
    }

    public static AnimationType valueOf(String r100) {
        return (AnimationType) a.a(AnimationType.class, r100);
    }

    public AnimationType(String r100, int r101) {
        super(r100, r101);
    }
}
