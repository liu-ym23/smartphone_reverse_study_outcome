package com.ss.android.lark.forseti.util.animation;

import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiMode;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f424578a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.forseti.util.animation.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5018a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f424579a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f424580b = null;

        static {
            int[] r100 = new int[ForsetiMode.values().length];
            r100[ForsetiMode.Compact.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r100[ForsetiMode.Regular.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            f424579a = r100;
            int[] r101 = new int[ForsetiChainType.values().length];
            r101[ForsetiChainType.TYPE_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            f424580b = r101;
        }
    }

    static {
    }
}
