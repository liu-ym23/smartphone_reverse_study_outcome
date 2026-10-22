package com.ss.android.lark.search.doubao.chat.holder.msg;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f440084a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f440085b = null;

    static {
        f440084a = new SimpleDateFormat("M/d", Locale.getDefault());
        f440085b = new SimpleDateFormat("yyyy/M/d", Locale.getDefault());
    }

    public static String a(long r100) {
        long r101 = r100 * ((long) 1000);
        Calendar r102 = Calendar.getInstance();
        int r103 = r102.get(1);
        r102.setTimeInMillis(r101);
        if (r102.get(1) != r103) goto L5;
        String r104 = f440084a.format(Long.valueOf(r101));
        Intrinsics.checkNotNull(r104);
        return r104;
    L5:
        String r105 = f440085b.format(Long.valueOf(r101));
        Intrinsics.checkNotNull(r105);
        return r105;
    }
}
