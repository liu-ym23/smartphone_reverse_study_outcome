package com.ss.android.lark.officewebview.util;

import android.content.Context;
import android.webkit.WebSettings;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes37.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437550a = 0;

    static {
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = WebSettings.getDefaultUserAgent(r100.getApplicationContext());     // Catch: Exception -> L5
    L6:
        StringBuffer r102 = new StringBuffer();
        if (r101 == null) goto L19;
        int r103 = r101.length();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L19;
        char r105 = r101.charAt(r104);
        if (Intrinsics.compare(r105, 31) > 0) goto L13;
    L16:
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r102.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(r105)}, 1)));
    L17:
        r104 = r104 + 1;
        goto L9
    L13:
        if (Intrinsics.compare(r105, 127) >= 0) goto L16;
        r102.append(r105);
    L19:
        return r102.toString();
    L5:
        r101 = System.getProperty("http.agent");
        goto L6
    }
}
