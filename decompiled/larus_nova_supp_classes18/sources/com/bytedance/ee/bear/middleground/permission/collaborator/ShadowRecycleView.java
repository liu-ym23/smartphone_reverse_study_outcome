package com.bytedance.ee.bear.middleground.permission.collaborator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShadowRecycleView extends RecyclerView {
    public Drawable a;
    public int b;
    public boolean c;

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r6) {
        super/*android.view.ViewGroup*/.dispatchDraw(r6);
        if (this.c == false) goto L6;
        this.a.setBounds(0, getHeight() - this.b, getWidth(), getHeight());
        this.a.draw(r6);
        return;
    }

    public void setShowShadow(boolean r1) {
        this.c = r1;
    }

    public ShadowRecycleView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.a = r2.getResources().getDrawable(2131247749);
        this.b = (int) r2.getResources().getDimension(2131168140);
    }

    public ShadowRecycleView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = r1.getResources().getDrawable(2131247749);
        this.b = (int) r1.getResources().getDimension(2131168140);
    }
}
