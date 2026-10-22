package com.bytedance.notification.helper;

import android.view.View;
import com.bytedance.notification.activity.BannerActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f266067g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<BannerActivity> f266068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<View> f266069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f266070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f266071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f266072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f266073f;

    public static a a() {
        if (f266067g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f266067g != null) goto L9;
        f266067g = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f266067g;
    }

    public a() {
        this.f266073f = false;
    }
}
