package com.ss.android.lark.passport.flow.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import uzb.l;
import vyb.d;
import vyb.e;

/* JADX INFO: loaded from: classes37.dex */
public class CommonTitleBar extends ConstraintLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f437793s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f437794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f437795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f437796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f437797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f437798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f437799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f437800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f437801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f437802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f437803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f437804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f437805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f437806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f437807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f437808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f437809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f437810q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Activity f437811r;

    public interface a {
        View getActionView();
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    public static abstract class c implements b {
        public c() {
        }

        @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
        public final void a() {
        }

        @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
        public final void c() {
        }

        @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
        public final void d() {
        }
    }

    public final void R5() {
        this.f437804k.setVisibility(0);
        setLeftIconDrawable(R.drawable.passport_flow_core_icon_close);
    }

    public TextView getRightTextView() {
        return this.f437807n;
    }

    public TextView getTitleView() {
        return this.f437806m;
    }

    public CommonTitleBar(Context r100) {
        this(r100, null);
    }

    private void setLeftIconDrawable(int r100) {
        int r101 = UDColorUtils.getColor(this.f437810q, R.color.icon_n1);
        Drawable r102 = UDIconUtils.getIconDrawable(this.f437810q, r100, r101);
        this.f437804k.setImageDrawable(r102);
    }

    public void setLeftClickAction(a r100) {
        this.f437800g = 2;
        this.f437805l.setVisibility(8);
        this.f437804k.setVisibility(8);
        this.f437808o.setVisibility(0);
        this.f437808o.addView(r100.getActionView(), new FrameLayout.LayoutParams(-2, -2));
        this.f437808o.setOnClickListener(new e());
    }

    public void setLeftIconRes(int r100) {
        this.f437802i = r100;
        this.f437805l.setVisibility(8);
        this.f437804k.setVisibility(0);
        this.f437808o.setVisibility(8);
        setLeftIconDrawable(this.f437802i);
    }

    public void setLeftText(String r100) {
        this.f437800g = 1;
        this.f437805l.setVisibility(0);
        this.f437804k.setVisibility(8);
        this.f437808o.setVisibility(8);
        this.f437803j = r100;
        this.f437805l.setText(r100);
    }

    public void setLeftTextColor(int r100) {
        this.f437798e = r100;
        this.f437805l.setTextColor(r100);
    }

    public void setLeftTextSize(float r100) {
        this.f437797d = l.c(getContext(), r100);
        this.f437805l.setTextSize(r100);
    }

    public void setRightTvEnable(boolean r100) {
        this.f437807n.setEnabled(r100);
    }

    public void setRithtText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f437807n.setVisibility(8);
        return;
    L5:
        this.f437807n.setVisibility(0);
        this.f437807n.setText(r100);
        if (this.f437801h == true) goto L10;
        this.f437807n.setTextColor(this.f437799f);
        return;
    }

    public void setTitleClickListener(b r100) {
        this.f437809p = r100;
    }

    public void setTitleColor(int r100) {
        this.f437795b = r100;
        this.f437806m.setTextColor(r100);
    }

    public void setTitleText(CharSequence r100) {
        this.f437794a = r100;
        TextView r101 = this.f437806m;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        this.f437806m.setText(this.f437794a);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void setTitleTextSize(int r100) {
        float r101 = r100;
        this.f437796c = l.c(getContext(), r101);
        this.f437806m.setTextSize(r101);
    }

    public CommonTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CommonTitleBar(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f437794a = "";
        l.b(getContext(), android.R.color.transparent);
        this.f437795b = l.b(getContext(), R.color.text_title);
        this.f437796c = l.c(getContext(), 17.0f);
        this.f437797d = l.c(getContext(), 17.0f);
        this.f437798e = l.b(getContext(), R.color.text_title);
        this.f437799f = l.b(getContext(), R.color.text_title);
        this.f437800g = 0;
        this.f437801h = false;
        this.f437802i = R.drawable.passport_flow_core_icon_back;
        this.f437803j = "";
        this.f437810q = r110;
        TypedArray r113 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.flow_tb_background, R.attr.flow_tb_left_icon, R.attr.flow_tb_left_padding, R.attr.flow_tb_left_text, R.attr.flow_tb_left_text_color, R.attr.flow_tb_left_text_size, R.attr.flow_tb_left_type, R.attr.flow_tb_right_padding, R.attr.flow_tb_right_text, R.attr.flow_tb_right_text_color, R.attr.flow_tb_right_text_size, R.attr.flow_tb_title_color, R.attr.flow_tb_title_text, R.attr.flow_tb_title_text_size, R.attr.flow_tb_use_default_selector});
        this.f437794a = r113.getString(12);
        int r114 = r113.getColor(0, r110.getResources().getColor(android.R.color.transparent));
        this.f437795b = r113.getColor(11, r110.getResources().getColor(R.color.text_title));
        this.f437802i = r113.getResourceId(1, R.drawable.passport_flow_core_icon_back);
        int r100 = r113.getDimensionPixelOffset(2, l.a(getContext(), 16.0f));
        this.f437803j = r113.getString(3);
        String r101 = r113.getString(8);
        this.f437796c = r113.getDimension(13, l.c(getContext(), 17.0f));
        this.f437797d = r113.getDimension(5, l.c(getContext(), 17.0f));
        this.f437798e = r113.getColor(4, r110.getResources().getColor(R.color.text_title));
        boolean r102 = r113.getBoolean(14, false);
        this.f437801h = r102;
        if (r102 == true) goto L5;
        this.f437799f = r113.getColor(9, r110.getResources().getColor(R.color.text_title));
    L5:
        this.f437800g = r113.getInteger(6, 0);
        r113.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.passport_flow_common_title_bar, this, true);
        this.f437809p = new com.ss.android.lark.passport.flow.core.widget.a(this);
        setBackgroundColor(r114);
        this.f437804k = (ImageView) findViewById(R.id.left_icon);
        this.f437805l = (TextView) findViewById(R.id.left_text);
        this.f437806m = (TextView) findViewById(R.id.center);
        this.f437807n = (TextView) findViewById(R.id.tv_right);
        this.f437806m.setClickable(false);
        this.f437808o = (FrameLayout) findViewById(R.id.left_container);
        TextView r115 = this.f437806m;
        if (TextUtils.isEmpty(this.f437794a) == false) goto L8;
        int r116 = 8;
    L9:
        r115.setVisibility(r116);
        this.f437806m.setText(this.f437794a);
        this.f437806m.setTextColor(this.f437795b);
        TextView r117 = this.f437806m;
        Context r118 = getContext();
        int r119 = (int) this.f437796c;
        Resources r120 = r118.getResources();
        r117.setTextSize((int) ((r119 / WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).scaledDensity) + 0.5f));
        TextView r121 = this.f437806m;
        int r122 = h18.e.f483540a;
        r121.setTypeface(h18.e.b(getContext(), 1));
        setRithtText(r101);
        int r123 = this.f437800g;
        if (r123 == 0) goto L16;
        if (r123 == 1) goto L15;
        if (r123 != 2) goto L17;
        this.f437805l.setVisibility(8);
        this.f437804k.setVisibility(8);
        this.f437808o.setVisibility(0);
    L17:
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f437804k.getLayoutParams())).leftMargin = r100;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f437805l.getLayoutParams())).leftMargin = r100;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f437808o.getLayoutParams())).leftMargin = r100;
        this.f437804k.setOnClickListener(new vyb.a(this));
        this.f437805l.setOnClickListener(new vyb.b(this));
        this.f437806m.setOnClickListener(new vyb.c(this));
        this.f437807n.setOnClickListener(new d(this));
        return;
    L15:
        this.f437805l.setVisibility(0);
        this.f437804k.setVisibility(8);
        this.f437808o.setVisibility(8);
        this.f437805l.setText(this.f437803j);
        TextView r124 = this.f437805l;
        Context r125 = getContext();
        int r103 = (int) this.f437797d;
        Resources r126 = r125.getResources();
        r124.setTextSize((int) ((r103 / WindowDisplayMetricsOverride.apply(r126, r126.getDisplayMetrics()).scaledDensity) + 0.5f));
        this.f437805l.setTextColor(this.f437798e);
        goto L17
    L16:
        this.f437805l.setVisibility(8);
        this.f437804k.setVisibility(0);
        this.f437808o.setVisibility(8);
        setLeftIconDrawable(this.f437802i);
        goto L17
    L8:
        r116 = 0;
        goto L9
    }
}
