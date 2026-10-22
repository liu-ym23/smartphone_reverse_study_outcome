package com.obric.assistant.card.utils;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f386555a = 0;

    static {
    }

    public static String f(String r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r111 = StringsKt.replace$default(r110, '-', '/', false, 4, null);
        List r100 = StringsKt.split$default(r111, new char[]{'/'}, false, 0, 6, null);
        if (r100.size() == 3) goto L5;
        return r111;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r100, 0), String.valueOf(Calendar.getInstance().get(1))) == true) goto L7;
        return r111;
    L7:
        return ((String) ListProtector.get(r100, 1)) + '/' + ((String) ListProtector.get(r100, 2));
    }

    public static String c(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Calendar r102 = Calendar.getInstance();
        r102.setTimeInMillis(r101);
        Calendar r103 = Calendar.getInstance();
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNull(r103);
        if (d(r102, r103) == false) goto L6;
        String r104 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(r101));
        Intrinsics.checkNotNull(r104);
        return r104;
    L6:
        if (e(r102, r103) == false) goto L8;
        String r105 = new SimpleDateFormat("MM/dd HH:mm", Locale.getDefault()).format(new Date(r101));
        Intrinsics.checkNotNull(r105);
        return r105;
    L8:
        String r106 = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault()).format(new Date(r101));
        Intrinsics.checkNotNull(r106);
        return r106;
    }

    public static boolean d(Calendar r100, Calendar r101) {
        if (r100.get(1) == r101.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r100.get(6) != r101.get(6)) goto L7;
        return true;
    }

    public static boolean e(Calendar r100, Calendar r101) {
        if (r100.get(1) == r101.get(1)) goto L7;
        return false;
    L7:
        return true;
    }

    public static String b(Context r100, long r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Calendar r102 = Calendar.getInstance();
        r102.setTimeInMillis(r101);
        Calendar r103 = Calendar.getInstance();
        r103.setTimeInMillis(r110);
        SimpleDateFormat r104 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Calendar r105 = Calendar.getInstance();
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNull(r103);
        if (d(r102, r103) == false) goto L12;
        String r111 = r104.format(new Date(r101)) + " - " + r104.format(new Date(r110));
        Intrinsics.checkNotNull(r105);
        if (d(r102, r105) == false) goto L8;
        return r111;
    L8:
        if (e(r102, r105) == false) goto L11;
        return new SimpleDateFormat("MM/dd", Locale.getDefault()).format(new Date(r101)) + ' ' + r111;
    L11:
        return new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(r101)) + ' ' + r111;
    L12:
        StringBuilder r106 = new StringBuilder();
        Intrinsics.checkNotNull(r105);
        if (e(r102, r105) == false) goto L15;
        String r107 = new SimpleDateFormat("MM/dd", Locale.getDefault()).format(new Date(r101));
    L16:
        r106.append(r107);
        r106.append(' ');
        r106.append(r104.format(new Date(r101)));
        String r108 = r106.toString();
        StringBuilder r109 = new StringBuilder();
        if (e(r103, r105) == false) goto L19;
        String r112 = new SimpleDateFormat("MM/dd", Locale.getDefault()).format(new Date(r110));
    L20:
        r109.append(r112);
        r109.append(' ');
        r109.append(r104.format(new Date(r110)));
        return i.a(r108, r109.toString(), '-');
    L19:
        r112 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(r110));
        goto L20
    L15:
        r107 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(r101));
        goto L16
    }

    public static String a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, DyPayConstant.KEY_START_TIME);
        Intrinsics.checkNotNullParameter(r103, "endTime");
        boolean r104 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r101 = i.a(f(r100), r101, ' ');
    L13:
        if (r102 != null) goto L15;
    L18:
        if (r104 == true) goto L24;
        if (Intrinsics.areEqual(r102, r100) == true) goto L24;
        r103 = i.a(f(r102), r103, ' ');
    L24:
        return i.a(r101, r103, '-');
    L15:
        if (r102.length() == 0) goto L18;
        r104 = false;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r105 = false;
        goto L10
    }
}
