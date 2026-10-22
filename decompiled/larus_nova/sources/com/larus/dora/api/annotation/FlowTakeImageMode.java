package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface FlowTakeImageMode {
    public static final int continuous = 2;
    public static final int continuousEnd = 4;
    public static final int earphonePic = 6;
    public static final int explore = 3;
    public static final int exploreEnd = 5;
    public static final int fakeShoot = 11;
    public static final int kwsIntention = 8;
    public static final int llmIntention = 7;
    public static final int normal = 1;
    public static final int onlyPic = 9;
    public static final int silentShoot = 10;
    public static final int unknown = 0;
}
