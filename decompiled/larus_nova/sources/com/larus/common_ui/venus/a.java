package com.larus.common_ui.venus;

import android.graphics.Color;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a extends ShapeDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4189a f327952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f327953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f327954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f327955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f327956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f327957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f327958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f327959h;

    /* JADX INFO: renamed from: com.larus.common_ui.venus.a$a, reason: collision with other inner class name */
    public static final class C4189a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f327960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f327961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f327962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f327963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f327964e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f327965f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f327966g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f327967h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f327968i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f327969j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f327970k;

        public final int hashCode() {
            return (this.f327962c + this.f327963d) + ((int) (((((long) this.f327966g) + ((long) this.f327964e)) + ((long) this.f327961b)) / ((long) 3)));
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof C4189a) == true) goto L5;
            return false;
        L5:
            C4189a r101 = (C4189a) r100;
            if (r101.f327961b == this.f327961b) goto L8;
            return false;
        L8:
            if (r101.f327964e == this.f327964e) goto L10;
            return false;
        L10:
            if (r101.f327962c == this.f327962c) goto L12;
            return false;
        L12:
            if (r101.f327963d == this.f327963d) goto L14;
            return false;
        L14:
            if (r101.f327966g == this.f327966g) goto L16;
            return false;
        L16:
            if (r101.f327965f == this.f327965f) goto L18;
            return false;
        L18:
            if (Arrays.equals(r101.f327960a, this.f327960a) == false) goto L27;
            return true;
        L27:
            return false;
        }

        public C4189a(float[] r100, int r101, int r102, int r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r104 & 16) == 0) goto L9;
            r102 = 0;
        L9:
            if ((r104 & 64) == 0) goto L11;
            r103 = 0;
        L11:
            Intrinsics.checkNotNullParameter(r100, "outerRadii");
            this.f327960a = r100;
            this.f327961b = r101;
            this.f327962c = 0;
            this.f327963d = 0;
            this.f327964e = r102;
            this.f327965f = false;
            this.f327966g = r103;
            this.f327967h = false;
            this.f327968i = false;
            this.f327969j = false;
            this.f327970k = false;
        }
    }

    public a(C4189a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f327952a = r100;
        b(r100);
    }

    public final void b(C4189a r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r110.f327960a.length != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        float r101 = r110.f327964e;
        this.f327959h = r101;
        float r102 = r110.f327962c;
        float r103 = r110.f327963d;
        float r104 = Color.alpha(r110.f327966g) / 255;
        this.f327953b = r101;
        this.f327954c = r101;
        this.f327955d = r101;
        this.f327956e = r101;
        boolean r105 = r110.f327965f;
        if (r105 == false) goto L12;
        this.f327953b = 0.0f;
        this.f327954c = 0.0f;
    L12:
        if (r110.f327967h == false) goto L15;
        this.f327953b = 0.0f;
    L15:
        if (r110.f327969j == false) goto L18;
        this.f327954c = 0.0f;
    L18:
        if (r110.f327968i == false) goto L21;
        this.f327955d = 0.0f;
    L21:
        if (r110.f327970k == false) goto L23;
        this.f327956e = 0.0f;
    L23:
        this.f327957f = r102;
        this.f327958g = r103;
        if (r110.f327962c == 0) goto L28;
        if (r105 == true) goto L28;
        this.f327953b -= r102;
        this.f327954c += r102;
        float r106 = r104 * r102;
        float r107 = r106 / 2;
        this.f327959h = r101 - r107;
        this.f327957f = (r102 - r106) + r107;
    L28:
        if (r110.f327963d == 0) goto L30;
        this.f327955d -= r103;
        this.f327956e += r103;
        float r108 = r104 * r103;
        float r109 = r108 / 2;
        this.f327959h = r101 - r109;
        this.f327958g = (r103 - r108) + r109;
    L30:
        getPaint().setAntiAlias(true);
        getPaint().setColor(r110.f327961b);
        getPaint().setShadowLayer(this.f327959h, this.f327957f, this.f327958g, r110.f327966g);
        setShape(new RoundRectShape(r110.f327960a, null, null));
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void a(int r100, LayerDrawable r101) {
        Intrinsics.checkNotNullParameter(r101, "layerDrawable");
        r101.setLayerInset(r100, (int) this.f327953b, (int) this.f327955d, (int) this.f327954c, (int) this.f327956e);
    }
}
