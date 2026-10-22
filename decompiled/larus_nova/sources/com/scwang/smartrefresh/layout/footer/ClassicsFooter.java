package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import cqa.d;
import cqa.g;
import cqa.h;
import dqa.b;

/* JADX INFO: loaded from: classes34.dex */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f405942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f405943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f405944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f405945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f405946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f405947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f405948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f405949x;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405950a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f405950a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f405950a[RefreshState.PullUpToLoad.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f405950a[RefreshState.Loading.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f405950a[RefreshState.LoadReleased.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f405950a[RefreshState.ReleaseToLoad.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f405950a[RefreshState.Refreshing.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public ClassicsFooter(Context r100) {
        this(r100, null);
    }

    @Override // fqa.b, cqa.d
    public final boolean c(boolean r100) {
        if (this.f405949x == r100) goto L10;
        this.f405949x = r100;
        ImageView r101 = this.f406002e;
        if (r100 == false) goto L7;
        this.f406001d.setText(this.f405948w);
        r101.setVisibility(8);
        return true;
    L7:
        this.f406001d.setText(this.f405942q);
        r101.setVisibility(0);
        return true;
    L10:
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, fqa.b, cqa.f
    public void setPrimaryColors(int... r100) {
        if (this.f478467b != b.f469718e) goto L6;
        super.setPrimaryColors(r100);
        return;
    }

    public ClassicsFooter(Context r100, AttributeSet r110) {
        super(r100, r110, 0);
        this.f405949x = false;
        View.inflate(r100, R.layout.srl_classics_footer, this);
        ImageView r101 = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.f406002e = r101;
        ImageView r102 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f406003f = r102;
        this.f406001d = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray r111 = r100.obtainStyledAttributes(r110, new int[]{R.attr.srlAccentColor, R.attr.srlClassicsSpinnerStyle, R.attr.srlDrawableArrow, R.attr.srlDrawableArrowSize, R.attr.srlDrawableMarginRight, R.attr.srlDrawableProgress, R.attr.srlDrawableProgressSize, R.attr.srlDrawableSize, R.attr.srlFinishDuration, R.attr.srlPrimaryColor, R.attr.srlTextFailed, R.attr.srlTextFinish, R.attr.srlTextLoading, R.attr.srlTextNothing, R.attr.srlTextPulling, R.attr.srlTextRefreshing, R.attr.srlTextRelease, R.attr.srlTextSizeTitle});
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r101.getLayoutParams();
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r102.getLayoutParams();
        int r105 = r111.getDimensionPixelSize(4, hqa.b.c(20.0f));
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
        this.f406010m = r111.getInt(8, this.f406010m);
        this.f478467b = b.f469721h[r111.getInt(1, this.f478467b.f469722a)];
        if (r111.hasValue(2) == false) goto L6;
        this.f406002e.setImageDrawable(r111.getDrawable(2));
    L9:
        if (r111.hasValue(5) == false) goto L12;
        this.f406003f.setImageDrawable(r111.getDrawable(5));
    L15:
        if (r111.hasValue(17) == false) goto L18;
        this.f406001d.setTextSize(0, r111.getDimensionPixelSize(17, hqa.b.c(16.0f)));
    L18:
        if (r111.hasValue(9) == false) goto L23;
        int r106 = r111.getColor(9, 0);
        this.f406008k = true;
        this.f406009l = r106;
        g r107 = this.f406004g;
        if (r107 == null) goto L23;
        ((SmartRefreshLayout.j) r107).c(this, r106);
    L23:
        if (r111.hasValue(0) == false) goto L26;
        k(r111.getColor(0, 0));
    L26:
        if (r111.hasValue(14) == false) goto L28;
        this.f405942q = r111.getString(14);
    L30:
        if (r111.hasValue(16) == false) goto L32;
        this.f405943r = r111.getString(16);
    L34:
        if (r111.hasValue(12) == false) goto L36;
        this.f405944s = r111.getString(12);
    L38:
        if (r111.hasValue(15) == false) goto L40;
        this.f405945t = r111.getString(15);
    L42:
        if (r111.hasValue(11) == false) goto L44;
        this.f405946u = r111.getString(11);
    L46:
        if (r111.hasValue(10) == false) goto L48;
        this.f405947v = r111.getString(10);
    L50:
        if (r111.hasValue(13) == false) goto L52;
        this.f405948w = r111.getString(13);
    L53:
        r111.recycle();
        r102.animate().setInterpolator(null);
        TextView r108 = this.f406001d;
        if (isInEditMode() == false) goto L56;
        String r112 = this.f405944s;
    L57:
        r108.setText(r112);
        if (isInEditMode() == false) goto L60;
        r101.setVisibility(8);
        return;
    L60:
        r102.setVisibility(8);
        return;
    L56:
        r112 = this.f405942q;
        goto L57
    L52:
        this.f405948w = r100.getString(R.string.srl_footer_nothing);
        goto L53
    L48:
        this.f405947v = r100.getString(R.string.srl_footer_failed);
        goto L50
    L44:
        this.f405946u = r100.getString(R.string.srl_footer_finish);
        goto L46
    L40:
        this.f405945t = r100.getString(R.string.srl_footer_refreshing);
        goto L42
    L36:
        this.f405944s = r100.getString(R.string.srl_footer_loading);
        goto L38
    L32:
        this.f405943r = r100.getString(R.string.srl_footer_release);
        goto L34
    L28:
        this.f405942q = r100.getString(R.string.srl_footer_pulling);
        goto L30
    L12:
        if (this.f406003f.getDrawable() != null) goto L15;
        fqa.d r109 = new fqa.d();
        this.f406006i = r109;
        r109.a(-10066330);
        this.f406003f.setImageDrawable(this.f406006i);
        goto L15
    L6:
        if (this.f406002e.getDrawable() != null) goto L9;
        fqa.a r113 = new fqa.a();
        this.f406005h = r113;
        r113.a(-10066330);
        this.f406002e.setImageDrawable(this.f406005h);
        goto L9
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, fqa.b, cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        if (this.f405949x == true) goto L10;
        TextView r102 = this.f406001d;
        if (r101 == false) goto L7;
        String r103 = this.f405946u;
    L8:
        r102.setText(r103);
        return super.j(r100, r101);
    L7:
        r103 = this.f405947v;
        goto L8
    L10:
        return 0;
    }

    @Override // fqa.b, gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        ImageView r103 = this.f406002e;
        if (this.f405949x == false) goto L5;
        return;
    L5:
        switch(a.f405950a[r102.ordinal()]) {
            case 1: goto L10;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L17;
        };
    L7:
        this.f406001d.setText(this.f405945t);
        r103.setVisibility(8);
        return;
    L8:
        this.f406001d.setText(this.f405943r);
        r103.animate().rotation(0.0f);
        return;
    L9:
        r103.setVisibility(8);
        this.f406001d.setText(this.f405944s);
        return;
    L10:
        r103.setVisibility(0);
    L11:
        this.f406001d.setText(this.f405942q);
        r103.animate().rotation(180.0f);
        return;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, fqa.b, cqa.f
    public final void f(h r100, int r101, int r102) {
        if (this.f405949x == true) goto L6;
        super.f(r100, r101, r102);
        return;
    }
}
