package com.bytedance.locallife.live.settings;

import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URLEncoder;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes21.dex */
public final class DebugLynxTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f260634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f260635b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f260636c = null;

    static {
        f260634a = LazyKt.lazy(DebugLynxTool$keve$2.INSTANCE);
        f260635b = "debug_local_life_shelf";
        f260636c = "debug_local_life_shelf_switch";
    }

    public static boolean b() {
        if (LiveLifeSaaSUtil.A() == true) goto L5;
        return false;
    L5:
        Keva r100 = (Keva) f260634a.getValue();
        if (r100 != null) goto L8;
        return false;
    L8:
        return r100.getBoolean(f260636c, false);
    }

    public static String a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L11
        String r103 = UriProtector.getQueryParameter(r102, "bundle");     // Catch: Throwable -> L11
        Uri.Builder r104 = r102.buildUpon().clearQuery();     // Catch: Throwable -> L11
        StringBuilder r105 = new StringBuilder("http://");     // Catch: Throwable -> L11
        Keva r106 = (Keva) f260634a.getValue();     // Catch: Throwable -> L11
        if (r106 == null) goto L6;
        String r107 = r106.getString(f260635b, "");     // Catch: Throwable -> L11
    L7:
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        r105.append(r107);     // Catch: Throwable -> L11
        r105.append('/');     // Catch: Throwable -> L11
        return r104.appendQueryParameter("surl", r105.toString()).build().toString() + "output%2F" + URLEncoder.encode(r103, "UTF-8");
    L6:
        r107 = null;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th))) == null) goto L16;
        return "";
    L16:
        throw new KotlinNothingValueException();
    }
}
