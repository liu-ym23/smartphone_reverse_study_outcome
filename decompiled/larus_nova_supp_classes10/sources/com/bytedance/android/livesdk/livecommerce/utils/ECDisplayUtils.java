package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.sdk.ECSdk;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECDisplayUtils {
    public static ScreenType a;
    public static volatile Point[] b;

    public static final enum ScreenType extends Enum<ScreenType> {
        public static final ScreenType FULL_SCREEN = null;
        public static final ScreenType NORMAL_SCREEN = null;
        public static final ScreenType UNKNOWN = null;
        public static final /* synthetic */ ScreenType[] a = null;

        static {
            ScreenType r0 = new ScreenType("FULL_SCREEN", 0);
            FULL_SCREEN = r0;
            ScreenType r1 = new ScreenType("NORMAL_SCREEN", 1);
            NORMAL_SCREEN = r1;
            ScreenType r3 = new ScreenType("UNKNOWN", 2);
            UNKNOWN = r3;
            a = new ScreenType[]{r0, r1, r3};
        }

        public static ScreenType[] values() {
            return (ScreenType[]) a.clone();
        }

        public static ScreenType valueOf(String r1) {
            return (ScreenType) r27.a.a(ScreenType.class, r1);
        }

        public ScreenType(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        a = ScreenType.UNKNOWN;
        b = new Point[2];
    }

    public static int a(Context r7) {
        com.bytedance.android.ec.core.opt.ab.d.a();
        ScreenType r0 = a;
        ScreenType r1 = ScreenType.UNKNOWN;
        char r3 = 0;
        if (r0 == r1) goto L8;
        if (a == ScreenType.FULL_SCREEN) goto L27;
    L28:
        boolean r2 = false;
    L29:
        if (r2 == false) goto L31;
        if (r7 != null) goto L35;
    L37:
        if (r7 == null) goto L50;
        if (th.a.f(r7).getConfiguration().orientation == 1) goto L43;
        r3 = 1;
    L43:
        if (b[r3] != null) goto L52;
        WindowManager r4 = (WindowManager) r7.getSystemService("window");
        if (r4 == null) goto L51;
        Display r8 = r4.getDefaultDisplay();
        Point r5 = new Point();
        r8.getRealSize(r5);
        b[r3] = r5;
        goto L52
    L51:
        return b(r7);
    L52:
        return b[r3].y;
    L50:
        return b(r7);
    L35:
        if (ECSdk.c() == false) goto L37;
        com.bytedance.android.ec.core.opt.ab.d.a();
        goto L37
    L31:
        return b(r7);
    L27:
        r2 = true;
        goto L29
    L8:
        if (Build.VERSION.SDK_INT <= 21) goto L23;
        if (r7 == null) goto L11;
        WindowManager r6 = (WindowManager) r7.getSystemService("window");
    L12:
        if (r6 == null) goto L23;
        Display r9 = r6.getDefaultDisplay();
        Point r10 = new Point();
        r9.getRealSize(r10);
        int r11 = r10.x;
        int r12 = r10.y;
        if (r11 >= r12) goto L16;
        float r13 = r11;
        float r14 = r12;
    L18:
        if ((r14 / r13) < 1.97f) goto L20;
        ScreenType r15 = ScreenType.FULL_SCREEN;
    L21:
        a = r15;
        goto L23
    L20:
        r15 = ScreenType.NORMAL_SCREEN;
        goto L21
    L16:
        float r16 = r12;
        r14 = r11;
        r13 = r16;
        goto L18
    L11:
        r6 = null;
    L23:
        if (a != r1) goto L26;
        a = ScreenType.NORMAL_SCREEN;
    L26:
        if (a != ScreenType.FULL_SCREEN) goto L28;
        goto L27
    }

    public static int b(Context r1) {
        if (r1 == null) goto L5;
        Resources r2 = r1.getResources();
        return WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).heightPixels;
    L5:
        return 0;
    }

    public static boolean c(Context r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getResources().getConfiguration().orientation != 2) goto L9;
        return true;
    L9:
        return false;
    }
}
