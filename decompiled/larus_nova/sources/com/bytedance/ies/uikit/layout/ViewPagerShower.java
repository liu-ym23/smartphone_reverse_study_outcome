package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public class ViewPagerShower extends LinearLayout {
    private ArrayList<ImageView> mAl;
    private final LinearLayout.LayoutParams mLayoutParams;
    private Drawable mNormalDrawable;
    private int mNow;
    private Drawable mSelectedDrawable;

    public ViewPagerShower(Context r100) {
        super(r100);
        this.mAl = new ArrayList();
        this.mNow = -1;
        this.mLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    }

    public void onPageSelect(int r100) {
        ArrayList<ImageView> r101 = this.mAl;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L27;
        int r102 = this.mNow;
        if (r102 >= 0) goto L10;
    L15:
        if (r100 >= 0) goto L17;
        return;
    L17:
        if (r100 < this.mAl.size()) goto L19;
        return;
    L19:
        if (this.mSelectedDrawable == null) goto L21;
        ((ImageView) ListProtector.get(this.mAl, r100)).setImageDrawable(this.mSelectedDrawable);
    L22:
        this.mNow = r100;
        return;
    L21:
        ((ImageView) ListProtector.get(this.mAl, r100)).setImageResource(R.drawable.dot_colour);
        goto L22
    L10:
        if (r102 >= this.mAl.size()) goto L15;
        if (this.mNormalDrawable == null) goto L14;
        ((ImageView) ListProtector.get(this.mAl, this.mNow)).setImageDrawable(this.mNormalDrawable);
        goto L15
    L14:
        ((ImageView) ListProtector.get(this.mAl, this.mNow)).setImageResource(R.drawable.dot_gray);
        goto L15
    }

    public ViewPagerShower(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mAl = new ArrayList();
        this.mNow = -1;
        this.mLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    }

    public void initDrawable(Drawable r100, Drawable r101) {
        this.mNormalDrawable = r100;
        this.mSelectedDrawable = r101;
    }

    public void initViews(int r100, int r101) {
        removeAllViews();
        this.mAl.clear();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L13;
        ImageView r103 = new ImageView(getContext());
        Drawable r104 = this.mNormalDrawable;
        if (r104 == null) goto L7;
        r103.setImageDrawable(r104);
    L9:
        if (r102 >= (r100 - 1)) goto L11;
        this.mLayoutParams.setMargins(0, 0, (int) UIUtils.dip2Px(getContext(), 10.0f), 0);
        addView(r103, this.mLayoutParams);
    L12:
        this.mAl.add(r103);
        r102 = r102 + 1;
        goto L3
    L11:
        addView(r103);
        goto L12
    L7:
        r103.setImageResource(R.drawable.dot_gray);
        goto L9
    L13:
        onPageSelect(r101);
    }
}
