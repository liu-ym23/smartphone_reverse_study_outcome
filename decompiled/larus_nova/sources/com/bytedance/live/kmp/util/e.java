package com.bytedance.live.kmp.util;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import java.text.SimpleDateFormat;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f255169a = null;

    static {
        new SimpleDateFormat("MM月dd日");
        f255169a = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static long b() {
        i97.a r100 = i97.a.f488802a;
        return System.currentTimeMillis() + com.bytedance.android.livesdk.utils.ntp.a.f159087a;
    }

    @JvmStatic
    public static final long a() {
        return b();
    }

    public static String c(int r110) {
        StringBuilder r100 = new StringBuilder();
        if (r110 > 0) goto L6;
        return "";
    L6:
        long r101 = r110 / AnnouncementViewModel.HOUR_DURATION;
        long r102 = ((long) r110) - (((long) AnnouncementViewModel.HOUR_DURATION) * r101);
        long r103 = 60;
        long r104 = r102 / r103;
        long r105 = r102 - (r103 * r104);
        long r106 = 10;
        if (r101 >= r106) goto L9;
        r100.append("0");
    L9:
        r100.append(r101);
        r100.append(":");
        if (r104 >= r106) goto L12;
        r100.append("0");
    L12:
        r100.append(r104);
        r100.append(":");
        if (r105 >= r106) goto L15;
        r100.append("0");
    L15:
        r100.append(r105);
        return r100.toString();
    }
}
