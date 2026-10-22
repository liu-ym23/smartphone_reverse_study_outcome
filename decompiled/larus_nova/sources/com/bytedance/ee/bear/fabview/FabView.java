package com.bytedance.ee.bear.fabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes16.dex */
public class FabView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f226389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f226390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f226391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f226392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f226393e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabType {
        public static final int TYPE_IMAGE = 0;
        public static final int TYPE_MULTIPLE = 2;
        public static final int TYPE_TEXT = 1;
    }

    public FabView(Context r100) {
        this(r100, null);
    }

    private void setColor(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f226392d <= 0) goto L10;
        Drawable r101 = r100.getBackground();
        if ((r101 instanceof GradientDrawable) == false) goto L11;
        int r102 = getContext().getResources().getColor(this.f226392d);
        GradientDrawable r103 = (GradientDrawable) r101;
        r101.mutate();
        r103.setColor(r102);
        r103.setStroke(n.d(1), r102);
        return;
    L11:
        return;
    }

    public final void b(Context r100) {
        LayoutInflater r101 = LayoutInflater.from(r100);
        removeAllViews();
        int r102 = this.f226389a;
        if (r102 != 0) goto L5;
        r101.inflate(R.layout.sheet_fab_view_image, this);
    L12:
        int r103 = 0;
    L14:
        if (r103 >= getChildCount()) goto L16;
        a(getChildAt(r103), isEnabled());
        r103 = r103 + 1;
        goto L14
    L16:
        setColor(getChildAt(0));
        ImageView r104 = (ImageView) findViewById(R.id.fab_image);
        if (r104 == null) goto L21;
        r104.setImageResource(this.f226390b);
        if (this.f226391c <= 0) goto L21;
        r104.setColorFilter(getContext().getResources().getColor(this.f226391c));
    L21:
        TextView r105 = (TextView) findViewById(R.id.fab_text);
        if (r105 == null) goto L26;
        r105.setText(this.f226393e);
        return;
    L26:
        return;
    L5:
        if (r102 != 1) goto L7;
        r101.inflate(R.layout.sheet_fab_view_text, this);
        goto L12
    L7:
        if (r102 != 2) goto L12;
        r101.inflate(R.layout.sheet_fab_view_multiple, this);
        goto L12
    }

    public void setColorRes(int r100) {
        this.f226392d = r100;
    }

    public void setImageRes(int r100) {
        this.f226390b = r100;
    }

    public void setImageTintRes(int r100) {
        this.f226391c = r100;
    }

    public void setTextRes(String r100) {
        this.f226393e = r100;
    }

    public void setType(int r100) {
        this.f226389a = r100;
    }

    public FabView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void a(View r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setEnabled(r101);
        if ((r100 instanceof ViewGroup) == false) goto L12;
        ViewGroup r102 = (ViewGroup) r100;
        if (r102.getChildCount() <= 0) goto L14;
        int r103 = 0;
    L10:
        if (r103 >= r102.getChildCount()) goto L15;
        a(r102.getChildAt(r103), r101);
        r103 = r103 + 1;
        goto L10
    L15:
        return;
    L14:
        return;
    }

    public FabView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.fabColor, R.attr.fabImage, R.attr.fabImageTint, R.attr.fabText, R.attr.fabType});
        this.f226389a = r103.getInteger(4, 0);
        this.f226390b = r103.getResourceId(1, 0);
        this.f226391c = r103.getResourceId(2, 0);
        this.f226393e = r103.getString(3);
        this.f226392d = r103.getResourceId(0, R.color.bg_float);
        r103.recycle();
    L5:
        int r104 = n.d(6);
        setPadding(r104, r104, r104, r104);
        setClipToPadding(false);
        b(r100);
    }
}
