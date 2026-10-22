package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes14.dex */
public class PullUpLoadMoreHelper implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f196993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LoadMoreRecyclerViewAdapter.b f196994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f196995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f196996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f196997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f196998f;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
    }

    public PullUpLoadMoreHelper(RecyclerView r100, LoadMoreRecyclerViewAdapter.b r101) {
        this.f196995c = false;
        this.f196996d = false;
        this.f196993a = r100;
        this.f196994b = r101;
        this.f196997e = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        r100.addOnItemTouchListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L5;
        this.f196998f = r101.getY();
        this.f196996d = true;
    L5:
        RecyclerView r102 = this.f196993a;
        if (r102 != null) goto L8;
    L21:
        return false;
    L8:
        if (this.f196995c == false) goto L21;
        if (this.f196996d == false) goto L21;
        if (r102.canScrollVertically(1) == true) goto L21;
        if ((this.f196998f - r101.getY()) <= this.f196997e) goto L21;
        LoadMoreRecyclerViewAdapter.b r103 = this.f196994b;
        if ((r103 instanceof LoadMoreRecyclerViewAdapter.c) == false) goto L18;
        ((LoadMoreRecyclerViewAdapter.c) r103).Zc(0);
    L20:
        this.f196995c = false;
        this.f196996d = false;
        goto L21
    L18:
        if (r103 == null) goto L20;
        r103.a();
        goto L20
    }
}
