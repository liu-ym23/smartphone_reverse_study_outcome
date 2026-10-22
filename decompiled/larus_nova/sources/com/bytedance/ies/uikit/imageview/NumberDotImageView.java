package com.bytedance.ies.uikit.imageview;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes19.dex */
public class NumberDotImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f248961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f248962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f248963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f248964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f248965e;

    public final void a() {
        UIUtils.dip2Px(this.f248962b, 5.0f);
        this.f248961a = (int) UIUtils.dip2Px(this.f248962b, 8.0f);
        UIUtils.dip2Px(this.f248962b, 3.0f);
        int r100 = (this.f248961a * 2) + 4;
        this.f248963c = r100;
        setMaxHeight(r100);
        setMinimumHeight(this.f248963c);
        Paint r101 = new Paint();
        this.f248964d = r101;
        r101.setAntiAlias(true);
        this.f248964d.setColor(getResources().getColor(R.color.white));
        this.f248964d.setAlpha(125);
        Paint r102 = new Paint();
        this.f248965e = r102;
        r102.reset();
        this.f248965e.setAntiAlias(true);
        this.f248965e.setColor(getResources().getColor(R.color.black));
        this.f248965e.setAlpha(255);
        invalidate();
    }

    public NumberDotImageView(Context r100) {
        super(r100);
        this.f248962b = r100;
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public NumberDotImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f248962b = r100;
        a();
    }

    public NumberDotImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248962b = r100;
        a();
    }
}
