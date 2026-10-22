package com.bytedance.awemeopen.apps.framework.comment.write.utils;

import android.content.SharedPreferences;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f194575a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SharedPreferences f194576b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f194577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f194578d;

    static {
        f194575a = TimeUnit.DAYS.toMillis(3);
        f194576b = z54.a.b("comment");
    }
}
