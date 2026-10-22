package com.bytedance.kmp.performance.platform;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f252778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f252779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f252780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Function1<md6.a, Unit>> f252781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final buc.a f252782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f252783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f252784g;

    /* JADX WARN: Type inference failed for: r0v11, types: [com.bytedance.kmp.performance.platform.c] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.kmp.performance.platform.d] */
    public f() {
        this.f252778a = new Handler(Looper.getMainLooper());
        this.f252779b = -1;
        this.f252780c = -1;
        this.f252781d = new ArrayList();
        this.f252782e = buc.b.a(false);
        Context r100 = com.bytedance.kmp.performance.b.f252707a.getContext();
        if (r100 == null) goto L5;
        Window r101 = a.a(r100);
    L6:
        if (r101 != null) goto L8;
    L10:
        this.f252783f = new d(this);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        this.f252784g = new c(this);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
