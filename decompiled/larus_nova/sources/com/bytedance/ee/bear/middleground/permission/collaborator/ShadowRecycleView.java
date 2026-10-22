package com.bytedance.ee.bear.middleground.permission.collaborator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ShadowRecycleView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f233157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f233158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f233159c;

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        if (this.f233159c == false) goto L6;
        this.f233157a.setBounds(0, getHeight() - this.f233158b, getWidth(), getHeight());
        this.f233157a.draw(r100);
        return;
    }

    public void setShowShadow(boolean r100) {
        this.f233159c = r100;
    }

    public ShadowRecycleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f233157a = r100.getResources().getDrawable(R.drawable.share_notify_lark_bg);
        this.f233158b = (int) r100.getResources().getDimension(R.dimen.share_shadow_padding);
    }

    public ShadowRecycleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f233157a = r100.getResources().getDrawable(R.drawable.share_notify_lark_bg);
        this.f233158b = (int) r100.getResources().getDimension(R.dimen.share_shadow_padding);
    }
}
