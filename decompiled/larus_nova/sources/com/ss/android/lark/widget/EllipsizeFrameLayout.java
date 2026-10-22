package com.ss.android.lark.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class EllipsizeFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f445601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f445602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f445603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f445604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f445605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f445606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f445607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f445608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f445609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f445610j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f445611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f445612b;

        public final int hashCode() {
            return Objects.hash(new Object[]{Float.valueOf(this.f445611a), Float.valueOf(this.f445612b)});
        }

        public a() {
            this(0.9f, 0.9f);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f445611a == r101.f445611a) goto L11;
        L13:
            return false;
        L11:
            if (this.f445612b != r101.f445612b) goto L13;
            return true;
        }

        public a(float r100, float r101) {
            this.f445611a = r100;
            this.f445612b = r101;
        }
    }

    public interface b {
        void a(boolean r100);
    }

    public interface c {
        boolean a();
    }

    public EllipsizeFrameLayout(Context r100) {
        this(r100, null);
    }

    public void setEllipsizeListener(b r100) {
        this.f445604d = r100;
    }

    public void setEnableEllipsize(boolean r100) {
        if (this.f445603c == r100) goto L6;
        this.f445603c = r100;
        requestLayout();
        return;
    }

    public void setMaxHeightFactor(a r100) {
        this.f445606f = r100;
        this.f445601a = (int) (Math.max(0, ((this.f445607g - this.f445608h) - this.f445609i) - this.f445610j) * r100.f445611a);
        this.f445602b = (int) (Math.max(0, ((this.f445607g - this.f445608h) - this.f445609i) - this.f445610j) * r100.f445612b);
        requestLayout();
    }

    public void setShouldEllipsizeListener(c r100) {
        this.f445605e = r100;
    }

    public EllipsizeFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        boolean r102 = false;
        if (this.f445603c == false) goto L14;
        int r103 = getMeasuredHeight();
        if (r103 < this.f445601a) goto L7;
        r102 = true;
    L7:
        if (r102 == false) goto L11;
        c r104 = this.f445605e;
        if (r104 == null) goto L11;
        r102 = r104.a();
    L11:
        if (r102 == false) goto L13;
        r103 = this.f445602b;
    L13:
        setMeasuredDimension(getMeasuredWidth(), r103);
    L14:
        b r105 = this.f445604d;
        if (r105 == null) goto L18;
        r105.a(r102);
        return;
    }

    public EllipsizeFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445606f = new a();
        int r103 = UIHelper.dp2px(44.0f);
        this.f445608h = r103;
        int r104 = UIHelper.dp2px(102.0f);
        this.f445610j = r104;
        this.f445607g = DeviceUtils.getScreenHeight(getContext());
        int r105 = DeviceUtils.getStatusHeight(getContext());
        this.f445609i = r105;
        int r106 = (int) (Math.max(0, ((this.f445607g - r103) - r105) - r104) * this.f445606f.f445611a);
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ellipsizeHeight, R.attr.enableEllipsize});
        this.f445601a = r107.getDimensionPixelSize(0, r106);
        this.f445603c = r107.getBoolean(1, true);
        r107.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
