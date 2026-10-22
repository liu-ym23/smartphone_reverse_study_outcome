package com.ss.android.ugc.aweme.search.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class ECSearchDisplayUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScreenType f453408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Point[] f453409b;

    public static final enum ScreenType extends Enum<ScreenType> {
        public static final ScreenType FULL_SCREEN = null;
        public static final ScreenType NORMAL_SCREEN = null;
        public static final ScreenType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenType[] f453410a = null;

        static {
            ScreenType r100 = new ScreenType("FULL_SCREEN", 0);
            FULL_SCREEN = r100;
            ScreenType r101 = new ScreenType("NORMAL_SCREEN", 1);
            NORMAL_SCREEN = r101;
            ScreenType r102 = new ScreenType("UNKNOWN", 2);
            UNKNOWN = r102;
            f453410a = new ScreenType[]{r100, r101, r102};
        }

        public static ScreenType[] values() {
            return (ScreenType[]) f453410a.clone();
        }

        public static ScreenType valueOf(String r100) {
            return (ScreenType) a.a(ScreenType.class, r100);
        }

        public ScreenType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f453408a = ScreenType.UNKNOWN;
        f453409b = new Point[2];
    }

    public static int a(Context r100) {
        if (r100 == null) goto L5;
        Resources r101 = r100.getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels;
    L5:
        return 0;
    }
}
