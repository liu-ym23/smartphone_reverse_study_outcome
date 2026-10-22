package com.bytedance.ee.bear.drive.biz.preview.orientation;

import android.app.Activity;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f223672a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.orientation.a$a, reason: collision with other inner class name */
    public static final class C3208a {
        @JvmStatic
        public static boolean a(Activity r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100.getResources().getConfiguration().orientation != 2) goto L8;
        L9:
            return true;
        L8:
            if (r100.getRequestedOrientation() == 0) goto L9;
            return false;
        }

        @JvmStatic
        public static boolean b(Activity r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100.getResources().getConfiguration().orientation != 1) goto L8;
        L9:
            return true;
        L8:
            if (r100.getRequestedOrientation() == 1) goto L9;
            return false;
        }
    }

    static {
    }
}
