package com.bytedance.ee.bear.middleground.comment.uitls;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ View.OnLongClickListener c;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        this.c.onLongClick(this.b);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r3) {
        this.a.onClick(this.b);
        return super.onSingleTapUp(r3);
    }

    public u(View.OnClickListener r1, RecyclerView r2, View.OnLongClickListener r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
