package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b {
    public final View a;
    public sz3.c b;
    public com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m c;
    public final ViewGroup d;
    public final Context e;
    public r14.c f;
    public boolean g;

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public final Context getContext() {
        return this.e;
    }

    public b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
        this.d = (ViewGroup) r2.findViewById(2131367728);
        this.e = r2.getContext();
    }

    public void b(sz3.c r1, com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r2) {
        this.b = r1;
        this.c = r2;
        this.f = r1.f;
        e();
        if (this.g == true) goto L5;
        d();
        this.g = true;
    L5:
        c();
    }
}
