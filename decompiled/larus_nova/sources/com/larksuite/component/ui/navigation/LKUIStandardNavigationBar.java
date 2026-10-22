package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.larus.nova.R;
import j08.b;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIStandardNavigationBar extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f284314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f284315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f284316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RightStyle f284317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f284318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f284319j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f284320k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinearLayout f284321l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f284322m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f284323n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinearLayout f284324o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f284325p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f284326q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f284327r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f284328s;

    public static final enum RightStyle extends Enum<RightStyle> {
        public static final RightStyle ICON = null;
        public static final RightStyle TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RightStyle[] f284329a = null;

        static {
            RightStyle r100 = new RightStyle("ICON", 0);
            ICON = r100;
            RightStyle r101 = new RightStyle(CardAdapter.TEXT, 1);
            TEXT = r101;
            f284329a = new RightStyle[]{r100, r101};
        }

        public static RightStyle[] values() {
            return (RightStyle[]) f284329a.clone();
        }

        public static RightStyle valueOf(String r100) {
            return (RightStyle) r27.a.a(RightStyle.class, r100);
        }

        public RightStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284330a = null;

        static {
            int[] r100 = new int[RightStyle.values().length];
            f284330a = r100;
            r100[RightStyle.ICON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f284330a[RightStyle.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public final void a() {
        int r100 = a.f284330a[this.f284317h.ordinal()];
        if (r100 != 1) goto L5;
        this.f284328s.setVisibility(8);
        this.f284325p.setVisibility(0);
        this.f284326q.setVisibility(0);
        return;
    L5:
        if (r100 != 2) goto L11;
        this.f284328s.setVisibility(0);
        this.f284325p.setVisibility(8);
        this.f284326q.setVisibility(8);
        return;
    }

    public LinearLayout getLeftContainer() {
        return this.f284321l;
    }

    public ImageView getLeftImageView1() {
        return this.f284322m;
    }

    public ImageView getLeftImageView2() {
        return this.f284323n;
    }

    public LinearLayout getRightContainer() {
        return this.f284324o;
    }

    public ImageView getRightImageView1() {
        return this.f284325p;
    }

    public ImageView getRightImageView2() {
        return this.f284326q;
    }

    public TextView getRightTextView() {
        return this.f284328s;
    }

    public String getTitle() {
        return this.f284318i;
    }

    public TextView getTitleView() {
        return this.f284327r;
    }

    public LKUIStandardNavigationBar(Context r100) {
        this(r100, null);
    }

    public void setLeftDrawable1Res(int r100) {
        this.f284310a = r100;
        this.f284322m.setImageResource(r100);
    }

    public void setLeftDrawable2Res(int r100) {
        this.f284311b = r100;
        this.f284323n.setImageResource(r100);
    }

    public void setRightDrawable1Res(int r100) {
        this.f284312c = r100;
        this.f284325p.setImageResource(r100);
    }

    public void setRightDrawable2Res(int r100) {
        this.f284313d = r100;
        this.f284326q.setImageResource(r100);
    }

    public void setRightStyle(RightStyle r100) {
        this.f284317h = r100;
        a();
    }

    public void setRightText(String r100) {
        this.f284314e = r100;
        this.f284328s.setText(r100);
    }

    public void setRightTextColor(int r100) {
        this.f284315f = r100;
        this.f284328s.setTextColor(r100);
    }

    public void setRightTextSize(float r100) {
        this.f284316g = r100;
        this.f284328s.setTextSize(r100);
    }

    public void setTitle(String r100) {
        this.f284318i = r100;
        this.f284327r.setText(r100);
    }

    public void setTitleTextColor(int r100) {
        this.f284319j = r100;
        this.f284327r.setTextColor(r100);
    }

    public void setTitleTextSize(float r100) {
        this.f284320k = r100;
        this.f284327r.setTextSize(r100);
    }

    public LKUIStandardNavigationBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LKUIStandardNavigationBar(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f284310a = R.drawable.lkui_navigation_back;
        this.f284311b = 0;
        this.f284312c = 0;
        this.f284313d = 0;
        RightStyle r113 = RightStyle.ICON;
        this.f284317h = r113;
        RelativeLayout.inflate(getContext(), R.layout.lkui_navigation_standard, this);
        this.f284321l = (LinearLayout) findViewById(R.id.leftContainer);
        ImageView r100 = (ImageView) findViewById(R.id.leftImage1);
        this.f284322m = r100;
        ImageView r101 = (ImageView) findViewById(R.id.leftImage2);
        this.f284323n = r101;
        TextView r102 = (TextView) findViewById(R.id.title);
        this.f284327r = r102;
        this.f284324o = (LinearLayout) findViewById(R.id.rightContainer);
        ImageView r103 = (ImageView) findViewById(R.id.rightImage1);
        this.f284325p = r103;
        ImageView r104 = (ImageView) findViewById(R.id.rightImage2);
        this.f284326q = r104;
        TextView r105 = (TextView) findViewById(R.id.rightText);
        this.f284328s = r105;
        if (r111 == null) goto L5;
        TypedArray r114 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.standard_navigation_left_drawable1, R.attr.standard_navigation_left_drawable2, R.attr.standard_navigation_right_drawable1, R.attr.standard_navigation_right_drawable2, R.attr.standard_navigation_right_text, R.attr.standard_navigation_title, R.attr.standard_right_style, R.attr.standard_right_textColor, R.attr.standard_right_textSize, R.attr.standard_title_textColor, R.attr.standard_title_textSize});
        this.f284310a = r114.getResourceId(0, this.f284310a);
        this.f284311b = r114.getResourceId(1, this.f284311b);
        this.f284312c = r114.getResourceId(2, this.f284312c);
        this.f284313d = r114.getResourceId(3, this.f284313d);
        this.f284318i = r114.getString(5);
        this.f284319j = r114.getColor(9, ContextCompat.getColor(getContext(), R.color.lkui_N900));
        this.f284320k = r114.getDimension(10, b.e(getContext(), 17.0f));
        this.f284314e = r114.getString(4);
        this.f284315f = r114.getColor(7, ContextCompat.getColor(getContext(), R.color.lkui_N900));
        this.f284316g = r114.getDimension(8, b.e(getContext(), 16.0f));
        this.f284317h = RightStyle.values()[r114.getInt(6, r113.ordinal())];
        r114.recycle();
    L6:
        r100.setImageResource(this.f284310a);
        r101.setImageResource(this.f284311b);
        r103.setImageResource(this.f284312c);
        r104.setImageResource(this.f284313d);
        r102.setText(this.f284318i);
        r102.setTextSize(0, a08.b.a(this.f284320k, getContext()));
        r102.setTextColor(this.f284319j);
        r105.setText(this.f284314e);
        r105.setTextSize(0, a08.b.a(this.f284316g, getContext()));
        r105.setTextColor(this.f284315f);
        a();
        return;
    L5:
        this.f284320k = b.e(getContext(), 17.0f);
        this.f284319j = ContextCompat.getColor(getContext(), R.color.lkui_N900);
        this.f284316g = b.e(getContext(), 16.0f);
        this.f284315f = ContextCompat.getColor(getContext(), R.color.lkui_N900);
        goto L6
    }
}
