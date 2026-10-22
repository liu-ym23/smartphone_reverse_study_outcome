package com.bytedance.ee.bear.bitable.card.view.title;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import dp4.a;
import h18.e;

/* JADX INFO: loaded from: classes15.dex */
public class BitableCardTitleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f208926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f208927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f208928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f208929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Typeface f208930e;

    public BitableCardTitleView(Context r100) {
        super(r100);
        this.f208927b = "";
    }

    public void setData(a r100) {
        if (r100 == null) goto L8;
        cp4.a r101 = r100.f469588b;
        if (r101 == null) goto L9;
        setRecordTitle(r101.f464637d);
        return;
    L9:
        return;
    }

    public void setDefaultTitle(String r100) {
        this.f208927b = r100;
    }

    public void setRecordTitle(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = this.f208927b;
    L6:
        if (this.f208926a != null) goto L20;
        this.f208926a = new TextView(getContext());
        int r101 = this.f208929d;
        if (r101 != 0) goto L11;
        r101 = getResources().getColor(R.color.text_title);
    L11:
        Float r102 = this.f208928c;
        if (r102 == null) goto L14;
        float r103 = r102.floatValue();
    L15:
        Typeface r104 = this.f208930e;
        if (r104 != null) goto L19;
        int r105 = e.f483540a;
        r104 = e.b(getContext(), 1);
    L19:
        this.f208926a.setTextColor(r101);
        this.f208926a.setTextSize(0, r103);
        this.f208926a.setTypeface(r104);
        this.f208926a.setSingleLine(true);
        this.f208926a.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.gravity = 16;
        addView(this.f208926a, r106);
        goto L20
    L14:
        r103 = getResources().getDimensionPixelSize(R.dimen.bitable_card_title_size);
    L20:
        this.f208926a.setText(r100);
    }

    public void setTitleColor(int r100) {
        this.f208929d = r100;
    }

    public void setTitleSize(float r100) {
        this.f208928c = Float.valueOf(r100);
    }

    public void setTypeface(Typeface r100) {
        this.f208930e = r100;
    }

    public BitableCardTitleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public BitableCardTitleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f208927b = "";
    }
}
