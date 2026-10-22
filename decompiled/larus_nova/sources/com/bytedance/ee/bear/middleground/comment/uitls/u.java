package com.bytedance.ee.bear.middleground.comment.uitls;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public final class u extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f232254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f232255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View.OnLongClickListener f232256c;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        this.f232256c.onLongClick(this.f232255b);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        this.f232254a.onClick(this.f232255b);
        return super.onSingleTapUp(r100);
    }

    public u(View.OnClickListener r100, RecyclerView r101, View.OnLongClickListener r102) {
        this.f232254a = r100;
        this.f232255b = r101;
        this.f232256c = r102;
    }
}
