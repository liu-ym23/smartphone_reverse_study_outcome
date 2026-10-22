package com.ss.android.ttve.mediacodec;

import com.byted.cast.common.ErrorCode;
import com.ss.texturerender.effect.AbsEffect;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a[] f449890a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f449891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f449892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f449893c;

        public a(int r100, int r101, int r102) {
            this.f449891a = r100;
            this.f449892b = r101;
            this.f449893c = r102;
        }
    }

    static {
        f449890a = new a[]{new a(128, 20250, 4000), new a(256, 40500, 10000), new a(512, 108000, AbsEffect.OPTION_EFFECT_FLOAT_SRCROPSIZEU), new a(1024, 216000, 20000), new a(2048, 245760, 20000), new a(4096, 245760, 50000), new a(8192, 522240, 50000), new a(16384, 589824, 135000), new a(32768, 983040, 240000), new a(65536, 2073600, 240000), new a(131072, 4177920, 240000), new a(262144, 8355840, 480000), new a(524288, 16711680, ErrorCode.LICENSE_USER_VALID)};
    }
}
