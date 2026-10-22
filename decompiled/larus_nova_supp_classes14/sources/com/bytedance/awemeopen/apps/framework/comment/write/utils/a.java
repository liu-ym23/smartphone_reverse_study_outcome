package com.bytedance.awemeopen.apps.framework.comment.write.utils;

import android.content.SharedPreferences;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final long a = 0;
    public static final SharedPreferences b = null;
    public static long c;
    public static int d;

    static {
        a = TimeUnit.DAYS.toMillis(3);
        b = z54.a.b("comment");
    }
}
