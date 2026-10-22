package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f195701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public sz3.c f195702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m f195703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f195704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f195705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r14.c f195706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f195707g;

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public final Context getContext() {
        return this.f195705e;
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f195701a = r100;
        this.f195704d = (ViewGroup) r100.findViewById(R.id.container);
        this.f195705e = r100.getContext();
    }

    public void b(sz3.c r100, com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r101) {
        this.f195702b = r100;
        this.f195703c = r101;
        this.f195706f = r100.f543930f;
        e();
        if (this.f195707g == true) goto L5;
        d();
        this.f195707g = true;
    L5:
        c();
    }
}
