package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Path;
import android.graphics.Rect;
import java.util.Arrays;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f426682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f426683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f426684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f426685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f426686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f426687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Path f426688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f426689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f426690i;

    public final String toString() {
        return "mRegion=" + this.f426682a + ", mRotation=" + this.f426683b + ", crop=" + Arrays.toString(this.f426684c) + ", scaleX=" + this.f426685d + ", scaleY=" + this.f426686e + ", svgPath=" + this.f426687f + ", ssivTileBackgroundColor=" + this.f426689h + ", applyWhiteBgTransformation=" + this.f426690i;
    }

    public b() {
        this.f426684c = new float[0];
        this.f426685d = 1.0f;
        this.f426686e = 1.0f;
        this.f426687f = "";
        this.f426690i = true;
    }
}
