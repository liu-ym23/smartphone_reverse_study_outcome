package com.ss.android.lark.blueprint;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class BlueprintCell<Data> implements m<Data>, xza.a<Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f410619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f410620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f410621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<j, i<Data, Object>> f410622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, List<i<Data, Object>>> f410623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<j, Integer> f410624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f410625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BlueprintCellViewHolder<? super Data> f410626h;

    @Override // com.ss.android.lark.blueprint.m
    public final void a() {
        Iterator<T> r100 = this.f410620b.b().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        j r101 = (j) r100.next();
        i r102 = (i) ((LinkedHashMap) this.f410622d).get(r101);
        if (r102 == null) goto L4;
        r102.a(this, l());
        goto L4
    }

    public final q<Data> l() {
        return (q) this.f410621c.getValue();
    }

    @Override // com.ss.android.lark.blueprint.m
    public final g c() {
        return this.f410619a;
    }

    @Override // xza.a
    public final BlueprintCellViewHolder<Data> i() {
        return this.f410626h;
    }

    @Override // com.ss.android.lark.blueprint.m
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = this.f410625g;
        if (r101 != null) goto L6;
        View r102 = l().b(r100);
        r102.setTag(R.id.blueprint_cell, this);
        this.f410625g = r102;
        return r102;
    L6:
        return r101;
    }

    @Override // com.ss.android.lark.blueprint.m
    public final int g(j r100) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        LinkedHashMap r101 = (LinkedHashMap) this.f410624f;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = Integer.valueOf(k(r100));
        r101.put(r100, r102);
    L6:
        return ((Number) r102).intValue();
    }

    @Override // xza.a
    public final void h(BlueprintCellViewHolder<? super Data> r100) {
        this.f410626h = r100;
    }

    public int k(j r100) {
        Intrinsics.checkNotNullParameter(r100, "blockKey");
        return this.f410620b.b().indexOf(r100);
    }

    @Override // com.ss.android.lark.blueprint.m
    public void update(final Data r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Function0<Unit> r101 = new AnonymousClass1(this, r100);
        l().update(r100);
        r101.invoke();
        l().l(r100);
    }

    public BlueprintCell(g r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "cellSpec");
        this.f410619a = r100;
        this.f410620b = r101;
        this.f410621c = LazyKt.lazy(new BlueprintCell$layout$2(this));
        this.f410622d = new LinkedHashMap();
        this.f410623e = new LinkedHashMap();
        this.f410624f = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.blueprint.m
    public void d(final Data r100, final List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "patchData");
        if (r101.isEmpty() == false) goto L6;
        update(r100);
        return;
    L6:
        Function0<Unit> r102 = new BlueprintCell$patch$1(r101, this, r100);
        l().update(r100);
        r102.invoke();
        l().l(r100);
    }
}
