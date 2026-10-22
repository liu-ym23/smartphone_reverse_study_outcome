package com.obric.audio.enroll.sidauth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f395551a = 0;

    static {
    }

    public static String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (r101 != 220014) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        return r100 + " ret=" + r101 + " registerAudioLoadFromDbFailed";
    L10:
        return r100 + " ret=" + r101;
    L5:
        r102 = false;
        goto L7
    }
}
