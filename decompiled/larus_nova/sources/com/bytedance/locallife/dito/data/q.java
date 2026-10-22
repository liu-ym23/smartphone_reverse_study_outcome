package com.bytedance.locallife.dito.data;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.utils.LinearOrientation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f258233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f258234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f258235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f258236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f258237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f258238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f258239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearOrientation f258240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f258241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f258242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f258243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f258244l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f258245m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f258246n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f258247o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float[] f258248p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Path f258249q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f258250r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Path f258251s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<Integer> f258252t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<BaseDitoModel<?>> f258253u;

    public q() {
        this.f258237e = 1.0f;
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        this.f258239g = r100;
        this.f258244l = new Rect();
        this.f258245m = new Rect();
        this.f258246n = new Rect();
        this.f258247o = new RectF();
        this.f258249q = new Path();
        this.f258251s = new Path();
        this.f258253u = new ArrayList();
    }
}
