package com.lynx.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import com.lynx.smartrefresh.layout.internal.InternalClassics;
import m6a.e;
import m6a.h;
import m6a.i;
import n6a.b;
import p6a.d;

/* JADX INFO: loaded from: classes32.dex */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f381560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f381561r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f381562s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f381563t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f381564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f381565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f381566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f381567x;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381568a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f381568a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f381568a[RefreshState.PullUpToLoad.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f381568a[RefreshState.Loading.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f381568a[RefreshState.LoadReleased.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f381568a[RefreshState.ReleaseToLoad.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f381568a[RefreshState.Refreshing.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public ClassicsFooter(Context r100) {
        this(r100, null);
    }

    @Override // p6a.b, m6a.e
    public final boolean c(boolean r100) {
        if (this.f381567x == r100) goto L10;
        this.f381567x = r100;
        ImageView r101 = this.f381620e;
        if (r100 == false) goto L7;
        this.f381619d.setText(this.f381566w);
        r101.setVisibility(8);
        return true;
    L7:
        this.f381619d.setText(this.f381560q);
        r101.setVisibility(0);
        return true;
    L10:
        return true;
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics, p6a.b, m6a.g
    public void setPrimaryColors(int... r100) {
        if (this.f527945b != b.f518184e) goto L6;
        super.setPrimaryColors(r100);
        return;
    }

    public ClassicsFooter(Context r100, AttributeSet r110) {
        super(r100, r110, 0);
        this.f381567x = false;
        View.inflate(r100, R.layout.srl_classics_footer, this);
        ImageView r101 = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.f381620e = r101;
        ImageView r102 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f381621f = r102;
        this.f381619d = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray r111 = r100.obtainStyledAttributes(r110, new int[]{R.attr.srlAccentColor, R.attr.srlClassicsSpinnerStyle, R.attr.srlDrawableArrow, R.attr.srlDrawableArrowSize, R.attr.srlDrawableMarginRight, R.attr.srlDrawableProgress, R.attr.srlDrawableProgressSize, R.attr.srlDrawableSize, R.attr.srlFinishDuration, R.attr.srlPrimaryColor, R.attr.srlTextFailed, R.attr.srlTextFinish, R.attr.srlTextLoading, R.attr.srlTextNothing, R.attr.srlTextPulling, R.attr.srlTextRefreshing, R.attr.srlTextRelease, R.attr.srlTextSizeTitle});
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r101.getLayoutParams();
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r102.getLayoutParams();
        int r105 = r111.getDimensionPixelSize(4, r6a.b.c(20.0f));
        r104.rightMargin = r105;
        r103.rightMargin = r105;
        r103.width = r111.getLayoutDimension(3, r103.width);
        r103.height = r111.getLayoutDimension(3, r103.height);
        r104.width = r111.getLayoutDimension(6, r104.width);
        r104.height = r111.getLayoutDimension(6, r104.height);
        r103.width = r111.getLayoutDimension(7, r103.width);
        r103.height = r111.getLayoutDimension(7, r103.height);
        r104.width = r111.getLayoutDimension(7, r104.width);
        r104.height = r111.getLayoutDimension(7, r104.height);
        this.f381628m = r111.getInt(8, this.f381628m);
        this.f527945b = b.f518187h[r111.getInt(1, this.f527945b.f518188a)];
        if (r111.hasValue(2) == false) goto L6;
        this.f381620e.setImageDrawable(r111.getDrawable(2));
    L9:
        if (r111.hasValue(5) == false) goto L12;
        this.f381621f.setImageDrawable(r111.getDrawable(5));
    L15:
        if (r111.hasValue(17) == false) goto L18;
        this.f381619d.setTextSize(0, r111.getDimensionPixelSize(17, r6a.b.c(16.0f)));
    L18:
        if (r111.hasValue(9) == false) goto L23;
        int r106 = r111.getColor(9, 0);
        this.f381626k = true;
        this.f381627l = r106;
        h r107 = this.f381622g;
        if (r107 == null) goto L23;
        ((SmartRefreshLayout.i) r107).c(this, r106);
    L23:
        if (r111.hasValue(0) == false) goto L26;
        g(r111.getColor(0, 0));
    L26:
        if (r111.hasValue(14) == false) goto L28;
        this.f381560q = r111.getString(14);
    L30:
        if (r111.hasValue(16) == false) goto L32;
        this.f381561r = r111.getString(16);
    L34:
        if (r111.hasValue(12) == false) goto L36;
        this.f381562s = r111.getString(12);
    L38:
        if (r111.hasValue(15) == false) goto L40;
        this.f381563t = r111.getString(15);
    L42:
        if (r111.hasValue(11) == false) goto L44;
        this.f381564u = r111.getString(11);
    L46:
        if (r111.hasValue(10) == false) goto L48;
        this.f381565v = r111.getString(10);
    L50:
        if (r111.hasValue(13) == false) goto L52;
        this.f381566w = r111.getString(13);
    L53:
        r111.recycle();
        r102.animate().setInterpolator(null);
        TextView r108 = this.f381619d;
        if (isInEditMode() == false) goto L56;
        String r112 = this.f381562s;
    L57:
        r108.setText(r112);
        if (isInEditMode() == false) goto L60;
        r101.setVisibility(8);
        return;
    L60:
        r102.setVisibility(8);
        return;
    L56:
        r112 = this.f381560q;
        goto L57
    L52:
        this.f381566w = r100.getString(R.string.srl_footer_nothing);
        goto L53
    L48:
        this.f381565v = r100.getString(R.string.srl_footer_failed);
        goto L50
    L44:
        this.f381564u = r100.getString(R.string.srl_footer_finish);
        goto L46
    L40:
        this.f381563t = r100.getString(R.string.srl_footer_refreshing);
        goto L42
    L36:
        this.f381562s = r100.getString(R.string.srl_footer_loading);
        goto L38
    L32:
        this.f381561r = r100.getString(R.string.srl_footer_release);
        goto L34
    L28:
        this.f381560q = r100.getString(R.string.srl_footer_pulling);
        goto L30
    L12:
        if (this.f381621f.getDrawable() != null) goto L15;
        d r109 = new d();
        this.f381624i = r109;
        r109.a(-10066330);
        this.f381621f.setImageDrawable(this.f381624i);
        goto L15
    L6:
        if (this.f381620e.getDrawable() != null) goto L9;
        p6a.a r113 = new p6a.a();
        this.f381623h = r113;
        r113.a(-10066330);
        this.f381620e.setImageDrawable(this.f381623h);
        goto L9
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics, p6a.b, m6a.g
    public final int e(SmartRefreshLayout r100, boolean r101) {
        if (this.f381567x == true) goto L10;
        TextView r102 = this.f381619d;
        if (r101 == false) goto L7;
        String r103 = this.f381564u;
    L8:
        r102.setText(r103);
        return super.e(r100, r101);
    L7:
        r103 = this.f381565v;
        goto L8
    L10:
        return 0;
    }

    @Override // p6a.b, q6a.e
    public final void i(i r100, RefreshState r101, RefreshState r102) {
        ImageView r103 = this.f381620e;
        if (this.f381567x == false) goto L5;
        return;
    L5:
        switch(a.f381568a[r102.ordinal()]) {
            case 1: goto L10;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L17;
        };
    L7:
        this.f381619d.setText(this.f381563t);
        r103.setVisibility(8);
        return;
    L8:
        this.f381619d.setText(this.f381561r);
        r103.animate().rotation(0.0f);
        return;
    L9:
        r103.setVisibility(8);
        this.f381619d.setText(this.f381562s);
        return;
    L10:
        r103.setVisibility(0);
    L11:
        this.f381619d.setText(this.f381560q);
        r103.animate().rotation(180.0f);
        return;
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics, p6a.b, m6a.g
    public final void n(i r100, int r101, int r102) {
        if (this.f381567x == true) goto L6;
        super.n(r100, r101, r102);
        return;
    }
}
