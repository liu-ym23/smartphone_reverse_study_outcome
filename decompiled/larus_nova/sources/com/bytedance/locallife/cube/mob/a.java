package com.bytedance.locallife.cube.mob;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f257255a = 0;

    static {
    }

    public static String a(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        Object r103 = "";
        if (r102 == false) goto L46;
        return "";
    L46:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L38
        Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L38
        String r106 = UriProtector.getQueryParameter(r105, "channel");     // Catch: Throwable -> L38
        String r107 = UriProtector.getQueryParameter(r105, "bundle");     // Catch: Throwable -> L38
        String r108 = a36.b.b(r105);     // Catch: Throwable -> L38
        if (r106 != null) goto L15;
    L18:
        boolean r109 = true;
    L19:
        if (r109 == false) goto L35;
        if (r107 != null) goto L22;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == false) goto L35;
        if (r108 != null) goto L30;
    L33:
        if (r101 == true) goto L36;
        r100 = a36.b.d(UriProtector.parse(r108));     // Catch: Throwable -> L38
    L36:
        Object r111 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L38
    L41:
        if (Result.m9455isFailureimpl(r111) == true) goto L45;
        r103 = r111;
    L45:
        return (String) r103;
    L30:
        if (r108.length() == 0) goto L33;
        r101 = false;
        goto L33
    L22:
        if (r107.length() == 0) goto L25;
        r110 = false;
    L35:
        r100 = new Uri.Builder().scheme(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW).authority(r106).path(r107).build().toString();     // Catch: Throwable -> L38
        goto L36
    L15:
        if (r106.length() == 0) goto L18;
        r109 = false;
    L38:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static String b(String r100) {
        if (r100 == null) goto L5;
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r100), "bundle");
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }
}
