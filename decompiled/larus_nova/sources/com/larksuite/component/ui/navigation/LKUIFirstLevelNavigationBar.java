package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import j08.b;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIFirstLevelNavigationBar extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f284271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f284272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f284273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f284274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f284275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f284276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f284277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f284278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f284279n;

    public ImageView getLeftImageView() {
        return this.f284275j;
    }

    public ImageView getRightImageView1() {
        return this.f284276k;
    }

    public ImageView getRightImageView2() {
        return this.f284277l;
    }

    public ImageView getRightImageView3() {
        return this.f284278m;
    }

    public ImageView getRightImageView4() {
        return this.f284279n;
    }

    public String getTitle() {
        return this.f284271f;
    }

    public TextView getTitleView() {
        return this.f284274i;
    }

    public LKUIFirstLevelNavigationBar(Context r100) {
        this(r100, null);
    }

    public void setLeftDrawableRes(int r100) {
        this.f284266a = r100;
        this.f284275j.setImageResource(r100);
    }

    public void setRightDrawable1Res(int r100) {
        this.f284267b = r100;
        this.f284276k.setImageResource(r100);
    }

    public void setRightDrawable2Res(int r100) {
        this.f284268c = r100;
        this.f284277l.setImageResource(r100);
    }

    public void setRightDrawable3Res(int r100) {
        this.f284269d = r100;
        this.f284278m.setImageResource(r100);
    }

    public void setRightDrawable4Res(int r100) {
        this.f284270e = r100;
        this.f284279n.setImageResource(r100);
    }

    public void setTitle(String r100) {
        this.f284271f = r100;
        this.f284274i.setText(r100);
    }

    public void setTitleTextColor(int r100) {
        this.f284272g = r100;
        this.f284274i.setTextColor(r100);
    }

    public void setTitleTextSize(float r100) {
        this.f284273h = r100;
        this.f284274i.setTextSize(r100);
    }

    public LKUIFirstLevelNavigationBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LKUIFirstLevelNavigationBar(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f284266a = 0;
        this.f284267b = 0;
        this.f284268c = 0;
        this.f284269d = 0;
        this.f284270e = 0;
        RelativeLayout.inflate(r110, R.layout.lkui_navigation_first_level, this);
        TextView r113 = (TextView) findViewById(R.id.title);
        this.f284274i = r113;
        ImageView r100 = (ImageView) findViewById(R.id.leftIcon);
        this.f284275j = r100;
        ImageView r101 = (ImageView) findViewById(R.id.rightIcon1);
        this.f284276k = r101;
        ImageView r102 = (ImageView) findViewById(R.id.rightIcon2);
        this.f284277l = r102;
        ImageView r103 = (ImageView) findViewById(R.id.rightIcon3);
        this.f284278m = r103;
        ImageView r104 = (ImageView) findViewById(R.id.rightIcon4);
        this.f284279n = r104;
        if (r111 == null) goto L5;
        TypedArray r114 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.first_level_navigation_left_drawable, R.attr.first_level_navigation_right_drawable1, R.attr.first_level_navigation_right_drawable2, R.attr.first_level_navigation_right_drawable3, R.attr.first_level_navigation_right_drawable4, R.attr.first_level_navigation_title, R.attr.first_level_title_textColor, R.attr.first_level_title_textSize});
        this.f284266a = r114.getResourceId(0, this.f284266a);
        this.f284267b = r114.getResourceId(1, this.f284267b);
        this.f284268c = r114.getResourceId(2, this.f284268c);
        this.f284269d = r114.getResourceId(3, this.f284269d);
        this.f284270e = r114.getResourceId(4, this.f284270e);
        this.f284271f = r114.getString(5);
        this.f284272g = r114.getColor(6, ContextCompat.getColor(getContext(), R.color.lkui_N900));
        this.f284273h = r114.getDimension(7, b.e(getContext(), 26.0f));
        r114.recycle();
    L6:
        r113.setText(this.f284271f);
        r113.setTextSize(0, a08.b.a(this.f284273h, r113.getContext()));
        r113.setTextColor(this.f284272g);
        r100.setImageResource(this.f284266a);
        r101.setImageResource(this.f284267b);
        r102.setImageResource(this.f284268c);
        r103.setImageResource(this.f284269d);
        r104.setImageResource(this.f284270e);
        return;
    L5:
        this.f284273h = b.e(getContext(), 26.0f);
        this.f284272g = ContextCompat.getColor(getContext(), R.color.lkui_N900);
        goto L6
    }
}
