package com.lynx.markdown;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes32.dex */
public class a extends MarkdownView {
    long mDrawable;
    protected h mResourceManager;

    @Override // com.lynx.markdown.MarkdownView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    public long getDrawable() {
        return this.mDrawable;
    }

    public a(Context r100) {
        super(r100);
        this.mDrawable = 0;
        this.mResourceManager = null;
        setWillNotDraw(false);
    }

    public void attachDrawable(long r100) {
        this.mDrawable = r100;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        CustomDrawable.a(this.mDrawable, r100, this.mResourceManager);
    }

    @Override // com.lynx.markdown.MarkdownView, com.lynx.markdown.IMarkdownViewHandle
    public void align(int r100, int r101) {
        super.align(r100, r101);
        long r102 = this.mDrawable;
        if (r102 == 0) goto L6;
        CustomDrawable.align(r102, getLeft(), getTop());
        return;
    }

    @Override // com.lynx.markdown.MarkdownView, android.view.View
    public void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = View.MeasureSpec.getSize(r110);
        int r112 = View.MeasureSpec.getMode(r110);
        int r101 = View.MeasureSpec.getSize(r111);
        int r113 = View.MeasureSpec.getMode(r111);
        long r102 = this.mDrawable;
        float r103 = r100;
        int r104 = 2;
        if (r112 == Integer.MIN_VALUE) goto L7;
        if (r112 == 1073741824) goto L6;
        int r114 = 0;
    L8:
        float r105 = r101;
        if (r113 == Integer.MIN_VALUE) goto L13;
        if (r113 == 1073741824) goto L12;
        r104 = 0;
        goto L13
    L12:
        r104 = 1;
    L13:
        long r115 = CustomDrawable.measure(r102, r103, r114, r105, r104);
        setMeasuredDimension((int) (r115 >>> 32), (int) (r115 & BodyPartID.bodyIdMax));
        invalidate();
        return;
    L6:
        r114 = 1;
        goto L8
    L7:
        r114 = 2;
        goto L8
    }
}
