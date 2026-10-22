package com.bytedance.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.bytedance.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f264424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f264425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, List<Layer>> f264426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, k> f264427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, qz6.c> f264428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SparseArrayCompat<qz6.d> f264429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LongSparseArray<Layer> f264430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Layer> f264431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Rect f264432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f264433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f264434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f264435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<String> f264436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f264437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f264438o;

    public final float b() {
        return (long) (((this.f264434k - this.f264433j) / this.f264435l) * 1000.0f);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> r101 = this.f264431h.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(r101.next().a("\t"));
        goto L4
    L7:
        return r100.toString();
    }

    public d() {
        this.f264424a = new s();
        this.f264425b = new HashSet();
        this.f264436m = new HashSet();
        this.f264438o = 0;
    }

    public final void a(String r100) {
        this.f264425b.add(r100);
    }
}
