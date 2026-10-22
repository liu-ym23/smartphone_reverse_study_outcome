package com.ss.android.lark.feed.app.tablayout;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f420822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f420823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f420824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f420825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f420826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f420827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f420828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f420829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f420830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f420831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f420832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final GradientDrawable.Orientation f420833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f420834m;

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        Drawable r100 = this.f420834m;
        if (r100 == null) goto L7;
        int[] r101 = r100.getState();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return super.getState();
    }

    public d() {
        this.f420828g = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f420830i = 0.5f;
        this.f420831j = 0.5f;
        this.f420832k = 0.5f;
        this.f420833l = GradientDrawable.Orientation.LEFT_RIGHT;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        Drawable r101 = this.f420834m;
        if (r101 == null) goto L6;
        r101.setColorFilter(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "stateSet");
        Drawable r101 = this.f420834m;
        if (r101 == null) goto L6;
        return r101.setState(r100);
    L6:
        return super.setState(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r100) {
        super.setTintList(r100);
        Drawable r101 = this.f420834m;
        if (r101 == null) goto L6;
        r101.setTintList(r100);
        return;
    }
}
