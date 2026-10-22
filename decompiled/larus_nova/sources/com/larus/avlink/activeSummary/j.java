package com.larus.avlink.activeSummary;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes24.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f291478c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile j f291479d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f291480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f291481b;

    public static final class a {
        public a() {
        }
    }

    static {
        f291478c = new a();
    }

    public j() {
        this.f291480a = new Handler(Looper.getMainLooper());
        this.f291481b = new AtomicInteger(23000);
    }
}
