package com.ss.android.lark.time.format.common;

import com.larksuite.framework.utils.f;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.model.SubInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f441322a = 0;

    static {
    }

    public static String a(Date r100, TimeZone r101, String r102, Locale r103) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Intrinsics.checkNotNullParameter(r101, "tz");
        Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
        if (r103 != null) goto L5;
        SimpleDateFormat r104 = new SimpleDateFormat(r102);     // Catch: IllegalArgumentException -> L12
    L6:
        r104.setTimeZone(r101);     // Catch: IllegalArgumentException -> L12
        Intrinsics.checkNotNullParameter(r104, "sdf");     // Catch: IllegalArgumentException -> L12
        Intrinsics.checkNotNullParameter(r100, "date");     // Catch: IllegalArgumentException -> L12
        String r105 = r104.format(r100);     // Catch: Exception -> L9
    L11:
        return r105;
    L9:
        Log.e("FormatUtil", "format error!");     // Catch: IllegalArgumentException -> L12
        r105 = "";
    L5:
        r104 = new SimpleDateFormat(r102, r103);     // Catch: IllegalArgumentException -> L12
    L17:
        return r102;
    }

    public static String b(Date r100, TimeZone r101, String r102, boolean r103, Locale r104) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Intrinsics.checkNotNullParameter(r101, "tz");
        Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
        if (r104 == null) goto L7;
        if (r103 == false) goto L12;
        String r105 = f.a(r102, r100.getTime(), r101, r104);
        Intrinsics.checkNotNull(r105);
        return r105;
    L12:
        return a(r100, r101, r102, r104);
    L7:
        Intrinsics.checkNotNullParameter(r100, "date");
        Intrinsics.checkNotNullParameter(r101, "tz");
        Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
        if (r103 == true) goto L11;
        return a(r100, r101, r102, null);
    L11:
        return f.a(r102, r100.getTime(), r101, null);
    }
}
