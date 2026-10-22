package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class DotImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f248949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f248951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f248952d;

    public final void a() {
        UIUtils.dip2Px(this.f248949a, 4.0f);
        int r100 = ((int) UIUtils.dip2Px(this.f248949a, 4.0f)) * 2;
        this.f248950b = r100;
        setMaxHeight(r100);
        setMinimumHeight(this.f248950b);
        Paint r101 = new Paint();
        this.f248951c = r101;
        r101.setAntiAlias(true);
        this.f248951c.setColor(getResources().getColor(R.color.dot_unselect_color));
        Paint r102 = new Paint();
        this.f248952d = r102;
        r102.reset();
        this.f248952d.setAntiAlias(true);
        this.f248952d.setColor(getResources().getColor(R.color.dot_select_color));
        invalidate();
    }

    public DotImageView(Context r100) {
        super(r100);
        this.f248949a = r100;
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public DotImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f248949a = r100;
        a();
    }

    public DotImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248949a = r100;
        a();
    }
}
