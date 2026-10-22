package com.larksuite.component.ui.list.iconitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c08.a;
import c08.b;
import c08.c;
import c08.d;
import com.larksuite.component.ui.list.LarkListItemView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public class IconItemView extends LarkListItemView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f284239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f284240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f284241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f284242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f284243f;

    @Override // com.larksuite.component.ui.list.LarkListItemView
    public final void b() {
        registerModelBinder(b.class, IconItemView.class, new a());
        registerModelBinder(d.class, IconItemView.class, new c());
    }

    public IconItemView(Context r100) {
        super(r100);
    }

    @Override // com.larksuite.component.ui.list.LarkListItemView
    public final View a(ViewGroup r110) {
        Context r111 = r110.getContext();
        int r100 = (int) j08.b.a(r111, 12.0f);
        LinearLayout r101 = new LinearLayout(r111);
        r101.setOrientation(0);
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f284239b = new ImageView(r111);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);
        r102.gravity = 16;
        r102.setMarginStart((int) j08.b.a(r111, 20.0f));
        r101.addView(this.f284239b, r102);
        LinearLayout r103 = new LinearLayout(r111);
        this.f284243f = r103;
        r103.setOrientation(1);
        this.f284243f.setPaddingRelative(0, r100, 0, r100);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(0, -2);
        r104.gravity = 16;
        r104.weight = 1.0f;
        r104.setMarginStart(r100);
        r104.setMarginEnd(r100);
        this.f284243f.setLayoutParams(r104);
        TextView r105 = new TextView(r111);
        this.f284240c = r105;
        r105.setTextColor(ContextCompat.getColor(r111, R.color.text_title));
        this.f284240c.setTextSize(16.0f);
        this.f284240c.setEllipsize(TextUtils.TruncateAt.END);
        this.f284240c.setSingleLine(true);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        this.f284240c.setLayoutParams(r106);
        TextView r107 = new TextView(r111);
        this.f284242e = r107;
        r107.setTextColor(ContextCompat.getColor(r111, R.color.text_placeholder));
        this.f284242e.setTextSize(14.0f);
        this.f284242e.setEllipsize(TextUtils.TruncateAt.END);
        this.f284242e.setMaxLines(2);
        this.f284242e.setPaddingRelative(0, (int) j08.b.a(r111, 2.0f), 0, 0);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        this.f284242e.setLayoutParams(r108);
        this.f284243f.addView(this.f284240c);
        this.f284243f.addView(this.f284242e);
        r101.addView(this.f284243f, r104);
        TextView r109 = new TextView(r111);
        this.f284241d = r109;
        r109.setTextColor(ContextCompat.getColor(r111, R.color.icon_n3));
        this.f284241d.setCompoundDrawablePadding((int) j08.b.a(r111, 5.0f));
        this.f284241d.setSingleLine(true);
        this.f284241d.setEllipsize(TextUtils.TruncateAt.START);
        this.f284241d.setTextSize(14.0f);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        r112.setMarginEnd((int) j08.b.a(r111, 20.0f));
        r112.gravity = 16;
        r101.addView(this.f284241d, r112);
        return r101;
    }

    public final void c(int r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.icon_margin_start, R.attr.icon_size, R.attr.subtitle_size, R.attr.tag_size, R.attr.title_size});
        int r102 = r101.getDimensionPixelSize(0, (int) j08.b.a(getContext(), 20.0f));
        int r103 = r101.getDimensionPixelSize(1, (int) j08.b.a(getContext(), 20.0f));
        int r104 = r101.getDimensionPixelSize(4, j08.b.e(getContext(), 16.0f));
        int r105 = r101.getDimensionPixelSize(2, j08.b.e(getContext(), 14.0f));
        int r106 = r101.getDimensionPixelSize(3, j08.b.e(getContext(), 14.0f));
        r101.recycle();
        ((LinearLayout.LayoutParams) this.f284239b.getLayoutParams()).setMarginStart(r102);
        this.f284239b.getLayoutParams().width = r103;
        this.f284239b.getLayoutParams().height = r103;
        this.f284240c.setTextSize(0, r104);
        this.f284242e.setTextSize(0, r105);
        this.f284241d.setTextSize(0, r106);
        requestLayout();
    }

    public IconItemView(Context r100, AttributeSet r101) {
        super(r100, r101);
        if (r101 == null) goto L6;
        c(r101.getStyleAttribute());
        return;
    }

    public IconItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (r101 == null) goto L6;
        c(r101.getStyleAttribute());
        return;
    }
}
