package com.bytedance.ee.bear.bitable.homepage.list;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class x0 extends LinearLayout implements xuc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f212902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f212903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f212904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f212905d;

    public static final class a {
    }

    static {
    }

    @Override // xuc.d
    public final void c(int r100, int r101, float r102, boolean r103) {
    }

    @Override // xuc.d
    public final void d(int r100, int r101, float r102, boolean r103) {
    }

    @Override // xuc.b
    public int getContentBottom() {
        Paint.FontMetrics r100 = this.f212905d.getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((r100.bottom - r100.top) / 2));
    }

    @Override // xuc.b
    public int getContentLeft() {
        Rect r100 = new Rect();
        this.f212905d.getPaint().getTextBounds(this.f212905d.getText().toString(), 0, this.f212905d.getText().length(), r100);
        int r101 = r100.width();
        return (getLeft() + (getWidth() / 2)) - (r101 / 2);
    }

    @Override // xuc.b
    public int getContentRight() {
        Rect r100 = new Rect();
        this.f212905d.getPaint().getTextBounds(this.f212905d.getText().toString(), 0, this.f212905d.getText().length(), r100);
        int r101 = r100.width();
        return (getLeft() + (getWidth() / 2)) + (r101 / 2);
    }

    @Override // xuc.b
    public int getContentTop() {
        Paint.FontMetrics r100 = this.f212905d.getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((r100.bottom - r100.top) / 2));
    }

    @Override // xuc.d
    public final void a(int r100, int r101) {
        this.f212905d.setTextColor(this.f212902a);
        this.f212904c.setVisibility(0);
        TextView r102 = this.f212905d;
        int r103 = h18.e.f483540a;
        r102.setTypeface(h18.e.a(getContext()), 1);
    }

    @Override // xuc.d
    public final void b(int r100, int r101) {
        this.f212905d.setTextColor(this.f212903b);
        this.f212904c.setVisibility(8);
        TextView r102 = this.f212905d;
        int r103 = h18.e.f483540a;
        r102.setTypeface(h18.e.a(getContext()), 0);
    }

    public x0(Context r100, int r101, int r102, String r103, int r104, int r105, w0.b r106) {
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r106, "clickListener");
        super(r100);
        this.f212902a = r101;
        this.f212903b = r102;
        setOrientation(0);
        AppCompatImageView r107 = new AppCompatImageView(getContext());
        this.f212904c = r107;
        r107.setImageResource(r104);
        r107.setImageTintList(getResources().getColorStateList(r105));
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(UIHelper.getDimens(R.dimen.dp_14), UIHelper.getDimens(R.dimen.dp_14));
        r108.rightMargin = UIHelper.getDimens(R.dimen.dp_4);
        r108.gravity = 16;
        addView(r107, r108);
        TextView r109 = new TextView(getContext());
        this.f212905d = r109;
        r109.setTextSize(12.0f);
        r109.setText(r103);
        r109.setMaxLines(1);
        addView(r109);
        setOnClickListener(r106);
        setBackground(UIHelper.getDrawable(R.drawable.bitable_v4_tab_bg));
        setPadding(UIHelper.getDimens(R.dimen.dp_16), UIHelper.getDimens(R.dimen.dp_4), UIHelper.getDimens(R.dimen.dp_16), UIHelper.getDimens(R.dimen.dp_4));
    }
}
