package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.FeedSpeedControlViewModel;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p extends b {
    public final ViewGroup h;
    public FeedSpeedControlViewModel i;
    public o j;

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.lifecycle.Observer, com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.o] */
    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        ViewGroup r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setOnTouchListener(new n());
        sz3.c r1 = this.b;
        if (r1 == null) goto L21;
        LifecycleOwner r2 = r1.b;
        if (r2 == null) goto L21;
        FeedSpeedControlViewModel.a r3 = FeedSpeedControlViewModel.Companion;
        Activity r4 = r1.getActivity();
        if ((r4 instanceof LifecycleOwner) == false) goto L12;
        LifecycleOwner r5 = (LifecycleOwner) r4;
    L13:
        if (r5 != null) goto L15;
        r5 = r2;
    L15:
        r3.getClass();
        FeedSpeedControlViewModel r6 = FeedSpeedControlViewModel.a.a(r5, "");
        this.i = r6;
        ?? r7 = new o(this);
        if (r6 == null) goto L20;
        MutableLiveData<Pair<String, Boolean>> r8 = r6.getFastSpeedModeEvent();
        if (r8 == null) goto L20;
        r8.observe(r2, r7);
    L20:
        this.j = r7;
        goto L21
    L12:
        r5 = null;
    L21:
        this.h.setVisibility(8);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        o r0 = this.j;
        if (r0 == null) goto L9;
        FeedSpeedControlViewModel r1 = this.i;
        if (r1 == null) goto L9;
        MutableLiveData<Pair<String, Boolean>> r2 = r1.getFastSpeedModeEvent();
        if (r2 == null) goto L9;
        r2.removeObserver(r0);
    L9:
        this.i = null;
        this.j = null;
    }

    public p(View r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.h = r3;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void b(sz3.c r1, com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r2) {
        super.b(r1, r2);
    }
}
