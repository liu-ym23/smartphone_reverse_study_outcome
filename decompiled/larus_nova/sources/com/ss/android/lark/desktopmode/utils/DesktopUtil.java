package com.ss.android.lark.desktopmode.utils;

import android.content.Context;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes35.dex */
public final class DesktopUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f420394a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f420395b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f420396c = null;

    public @interface CaptionBarType {
        public static final int CAPTION_CLOSE = 7;
        public static final int CAPTION_DIVIDER = 4;
        public static final int CAPTION_MAX = 6;
        public static final int CAPTION_MORE = 3;
        public static final int CAPTION_PIN = 2;
        public static final int CAPTION_RETURN = 0;
        public static final int CAPTION_SMALL = 5;
        public static final int CAPTION_TITLE = 1;
    }

    static {
        f420395b = new AtomicInteger(-1);
        f420396c = new AtomicBoolean(false);
    }

    public static boolean a(Context r100) {
        if (f420395b.get() == (-1)) goto L5;
    L21:
        return false;
    L5:
        if (f420394a == (-1)) goto L22;
    L15:
        Log.e("DesktopUtil", "isDesktopMode:false desktop feature is not enabled");
        if (DevEnvUtil.isDebugMode(r100) == false) goto L19;
        Log.e("DesktopUtil", "desktop mode called by: %s" + android.util.Log.getStackTraceString(new Throwable()));
    L19:
        if (f420396c.get() == false) goto L21;
        f420395b.compareAndSet(-1, 0);
        goto L21
    L22:
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L8:
        if (((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getDisplayId() != 0) goto L10;
        int r101 = 1;
    L11:
        f420394a = r101;     // Catch: Exception -> L13
        goto L15
    L10:
        r101 = 2;
        goto L11
    }
}
