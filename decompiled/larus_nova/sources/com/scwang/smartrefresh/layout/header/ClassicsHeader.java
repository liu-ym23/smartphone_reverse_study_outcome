package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import cqa.e;
import cqa.g;
import cqa.h;
import fqa.d;
import hqa.b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes34.dex */
public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements e {
    public final String A;
    public final String B;
    public final String C;
    public final String D;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f405977q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Date f405978r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f405979s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SharedPreferences f405980t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DateFormat f405981u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f405982v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f405983w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f405984x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f405985y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f405986z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405987a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f405987a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f405987a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f405987a[RefreshState.Refreshing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f405987a[RefreshState.RefreshReleased.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f405987a[RefreshState.ReleaseToRefresh.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f405987a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f405987a[RefreshState.Loading.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public ClassicsHeader(Context r100) {
        this(r100, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics
    public final void k(int r100) {
        this.f405979s.setTextColor((16777215 & r100) | (-872415232));
        super.k(r100);
    }

    public final void l(Date r100) {
        this.f405978r = r100;
        this.f405979s.setText(this.f405981u.format(r100));
        if (this.f405980t != null) goto L5;
        return;
    L5:
        if (isInEditMode() == true) goto L9;
        this.f405980t.edit().putLong(this.f405977q, r100.getTime()).apply();
        return;
    }

    public ClassicsHeader(Context r110, AttributeSet r111) {
        super(r110, r111, 0);
        this.f405977q = "LAST_UPDATE_TIME";
        this.f405982v = true;
        View.inflate(r110, R.layout.srl_classics_header, this);
        ImageView r100 = (ImageView) findViewById(R.id.srl_classics_arrow);
        this.f406002e = r100;
        TextView r101 = (TextView) findViewById(R.id.srl_classics_update);
        this.f405979s = r101;
        ImageView r102 = (ImageView) findViewById(R.id.srl_classics_progress);
        this.f406003f = r102;
        this.f406001d = (TextView) findViewById(R.id.srl_classics_title);
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.srlAccentColor, R.attr.srlClassicsSpinnerStyle, R.attr.srlDrawableArrow, R.attr.srlDrawableArrowSize, R.attr.srlDrawableMarginRight, R.attr.srlDrawableProgress, R.attr.srlDrawableProgressSize, R.attr.srlDrawableSize, R.attr.srlEnableLastTime, R.attr.srlFinishDuration, R.attr.srlPrimaryColor, R.attr.srlTextFailed, R.attr.srlTextFinish, R.attr.srlTextLoading, R.attr.srlTextPulling, R.attr.srlTextRefreshing, R.attr.srlTextRelease, R.attr.srlTextSecondary, R.attr.srlTextSizeTime, R.attr.srlTextSizeTitle, R.attr.srlTextTimeMarginTop, R.attr.srlTextUpdate});
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r100.getLayoutParams();
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r102.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = r112.getDimensionPixelSize(20, b.c(0.0f));
        int r105 = r112.getDimensionPixelSize(4, b.c(20.0f));
        r104.rightMargin = r105;
        r103.rightMargin = r105;
        r103.width = r112.getLayoutDimension(3, r103.width);
        r103.height = r112.getLayoutDimension(3, r103.height);
        r104.width = r112.getLayoutDimension(6, r104.width);
        r104.height = r112.getLayoutDimension(6, r104.height);
        r103.width = r112.getLayoutDimension(7, r103.width);
        r103.height = r112.getLayoutDimension(7, r103.height);
        r104.width = r112.getLayoutDimension(7, r104.width);
        r104.height = r112.getLayoutDimension(7, r104.height);
        this.f406010m = r112.getInt(9, this.f406010m);
        boolean r106 = r112.getBoolean(8, true);
        this.f405982v = r106;
        this.f478467b = dqa.b.f469721h[r112.getInt(1, this.f478467b.f469722a)];
        if (r112.hasValue(2) == false) goto L6;
        this.f406002e.setImageDrawable(r112.getDrawable(2));
    L9:
        if (r112.hasValue(5) == false) goto L12;
        this.f406003f.setImageDrawable(r112.getDrawable(5));
    L15:
        if (r112.hasValue(19) == false) goto L18;
        this.f406001d.setTextSize(0, r112.getDimensionPixelSize(19, b.c(16.0f)));
    L18:
        if (r112.hasValue(18) == false) goto L21;
        r101.setTextSize(0, r112.getDimensionPixelSize(18, b.c(12.0f)));
    L21:
        if (r112.hasValue(10) == false) goto L26;
        int r107 = r112.getColor(10, 0);
        this.f406008k = true;
        this.f406009l = r107;
        g r108 = this.f406004g;
        if (r108 == null) goto L26;
        ((SmartRefreshLayout.j) r108).c(this, r107);
    L26:
        if (r112.hasValue(0) == false) goto L29;
        int r109 = r112.getColor(0, 0);
        r101.setTextColor((16777215 & r109) | (-872415232));
        super.k(r109);
    L29:
        if (r112.hasValue(14) == false) goto L31;
        this.f405983w = r112.getString(14);
    L33:
        if (r112.hasValue(13) == false) goto L35;
        this.f405985y = r112.getString(13);
    L37:
        if (r112.hasValue(16) == false) goto L39;
        this.f405986z = r112.getString(16);
    L41:
        if (r112.hasValue(12) == false) goto L43;
        this.A = r112.getString(12);
    L45:
        if (r112.hasValue(11) == false) goto L47;
        this.B = r112.getString(11);
    L49:
        if (r112.hasValue(17) == false) goto L51;
        this.D = r112.getString(17);
    L53:
        if (r112.hasValue(15) == false) goto L55;
        this.f405984x = r112.getString(15);
    L57:
        if (r112.hasValue(21) == false) goto L59;
        this.C = r112.getString(21);
    L60:
        this.f405981u = new SimpleDateFormat(this.C, Locale.getDefault());
        r112.recycle();
        r102.animate().setInterpolator(null);
        if (r106 == false) goto L63;
        int r113 = 0;
    L64:
        r101.setVisibility(r113);
        TextView r114 = this.f406001d;
        if (isInEditMode() == false) goto L67;
        String r115 = this.f405984x;
    L68:
        r114.setText(r115);
        if (isInEditMode() == false) goto L71;
        r100.setVisibility(8);
    L84:
    L80:
        th = move-exception;
        th.printStackTrace();
    L82:
        String r116 = this.f405977q + r110.getClass().getName();
        this.f405977q = r116;
        SharedPreferences r117 = r110.getSharedPreferences("ClassicsHeader", 0);
        this.f405980t = r117;
        l(new Date(r117.getLong(r116, System.currentTimeMillis())));
        return;
    L73:
        if ((r110 instanceof FragmentActivity) == false) goto L82;
        FragmentManager r118 = ((FragmentActivity) r110).getSupportFragmentManager();     // Catch: Throwable -> L80
        if (r118 == null) goto L82;
        if (r118.getFragments().size() <= 0) goto L82;
        l(new Date());     // Catch: Throwable -> L80
        return;
    L71:
        r102.setVisibility(8);
        goto L84
    L67:
        r115 = this.f405983w;
        goto L68
    L63:
        r113 = 8;
        goto L64
    L59:
        this.C = r110.getString(R.string.srl_header_update);
        goto L60
    L55:
        this.f405984x = r110.getString(R.string.srl_header_refreshing);
        goto L57
    L51:
        this.D = r110.getString(R.string.srl_header_secondary);
        goto L53
    L47:
        this.B = r110.getString(R.string.srl_header_failed);
        goto L49
    L43:
        this.A = r110.getString(R.string.srl_header_finish);
        goto L45
    L39:
        this.f405986z = r110.getString(R.string.srl_header_release);
        goto L41
    L35:
        this.f405985y = r110.getString(R.string.srl_header_loading);
        goto L37
    L31:
        this.f405983w = r110.getString(R.string.srl_header_pulling);
        goto L33
    L12:
        if (this.f406003f.getDrawable() != null) goto L15;
        d r119 = new d();
        this.f406006i = r119;
        r119.a(-10066330);
        this.f406003f.setImageDrawable(this.f406006i);
        goto L15
    L6:
        if (this.f406002e.getDrawable() != null) goto L9;
        fqa.a r120 = new fqa.a();
        this.f406005h = r120;
        r120.a(-10066330);
        this.f406002e.setImageDrawable(this.f406005h);
        goto L9
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, fqa.b, cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        if (r101 == false) goto L6;
        this.f406001d.setText(this.A);
        if (this.f405978r == null) goto L8;
        l(new Date());
    L8:
        return super.j(r100, r101);
    L6:
        this.f406001d.setText(this.B);
        goto L8
    }

    @Override // fqa.b, gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        ImageView r103 = this.f406002e;
        TextView r104 = this.f405979s;
        int r105 = 8;
        switch(a.f405987a[r102.ordinal()]) {
            case 1: goto L13;
            case 2: goto L16;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L5;
            default: goto L22;
        };
    L5:
        r103.setVisibility(8);
        if (this.f405982v == false) goto L8;
        r105 = 4;
    L8:
        r104.setVisibility(r105);
        this.f406001d.setText(this.f405985y);
        return;
    L9:
        this.f406001d.setText(this.D);
        r103.animate().rotation(0.0f);
        return;
    L10:
        this.f406001d.setText(this.f405986z);
        r103.animate().rotation(180.0f);
        return;
    L11:
        this.f406001d.setText(this.f405984x);
        r103.setVisibility(8);
        return;
    L16:
        this.f406001d.setText(this.f405983w);
        r103.setVisibility(0);
        r103.animate().rotation(0.0f);
        return;
    L22:
        return;
    L13:
        if (this.f405982v == false) goto L15;
        r105 = 0;
    L15:
        r104.setVisibility(r105);
        goto L16
    }
}
