package com.ss.android.ugc.aweme.search.filter.view.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.ies.dmt.ui.widget.DoubleColorBallAnimationView;
import com.larus.nova.R;
import em4.k;

/* JADX INFO: loaded from: classes40.dex */
public class DmtTextLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoubleColorBallAnimationView f453266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f453267b;

    public DmtTextLoadingLayout(Context r100) {
        this(r100, null);
    }

    public void setBoxViewBackground(Drawable r100) {
        ViewCompat.setBackground(this.f453267b, r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        DoubleColorBallAnimationView r101 = this.f453266a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != 0) goto L8;
        k.a("widget/DoubleColorBallAnimationView>>>startAnimate");
        r101.f248442a.f();
        return;
    L8:
        if (r101.f248442a.isAnimating() == false) goto L12;
        DoubleColorBallAnimationView r102 = this.f453266a;
        r102.getClass();
        k.a("widget/DoubleColorBallAnimationView>>>stopAnimate");
        r102.f248442a.b();
        return;
    }

    public DmtTextLoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DmtTextLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ec_layout_loading_with_text, this, true);
        this.f453266a = (DoubleColorBallAnimationView) r103.findViewById(R.id.double_loading_view_text);
        this.f453267b = (LinearLayout) r103.findViewById(R.id.ll_box_view);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }
}
