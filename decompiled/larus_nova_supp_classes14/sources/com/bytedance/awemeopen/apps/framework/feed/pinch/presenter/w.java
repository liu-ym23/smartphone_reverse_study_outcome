package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w extends b implements rz3.a {
    public final ViewGroup h;
    public FrameLayout i;
    public final View j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void d() {
    }

    @Override // rz3.a
    public final void a() {
        View r0 = this.j.findViewById(2131384556);
        if (r0 == null) goto L5;
        r0.setBackgroundResource(2131235341);
    L5:
        View r1 = this.j.findViewById(2131366984);
        if (r1 == null) goto L9;
        r1.setBackgroundResource(2131235341);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        this.h.setVisibility(0);
        View r0 = this.j.findViewById(2131392341);
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        FrameLayout r1 = (FrameLayout) this.j.findViewById(2131366985);
        this.i = r1;
        if (r1 == null) goto L9;
        r1.setOnClickListener(new v(this));
    L9:
        FrameLayout r2 = this.i;
        if (r2 == null) goto L13;
        r2.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        this.h.setVisibility(8);
    }

    public w(View r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        super(r2);
        this.h = r3;
        this.j = LayoutInflater.from(getContext()).inflate(2131561091, r3);
    }
}
