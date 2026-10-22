package com.ss.android.lark.todo.impl.features.detail.time;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements e18.a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f443546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f443547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<Integer> f443548c;

    @Override // e18.a
    public final int getItemsCount() {
        return this.f443548c.size();
    }

    public a() {
        ArrayList<Integer> r100 = g.f443558a;
        this.f443548c = new ArrayList(g.f443558a);
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    public final void b(int r100) {
        this.f443547b = r100;
        if (this.f443546a == false) goto L5;
        ArrayList<Integer> r101 = g.f443559b;
    L6:
        ArrayList<Integer> r102 = new ArrayList(r101);
        this.f443548c = r102;
        if (r102.contains(Integer.valueOf(this.f443547b)) == false) goto L9;
        return;
    L9:
        if (this.f443546a == false) goto L15;
        int r103 = this.f443547b;
        if (r103 == (-1)) goto L15;
        if (r103 == 0) goto L15;
        this.f443548c.add(Integer.valueOf(r103));
    L15:
        if (this.f443546a == true) goto L19;
        int r104 = this.f443547b;
        if (r104 == (-1)) goto L19;
        this.f443548c.add(Integer.valueOf(r104));
    L19:
        CollectionsKt.sort(this.f443548c);
        return;
    L5:
        r101 = g.f443558a;
        goto L6
    }

    @Override // e18.a
    public final b getItem(int r100) {
        return new b(r100, ((Number) ListProtector.get(this.f443548c, r100)).intValue(), this.f443546a);
    }

    @Override // e18.a
    public final int indexOf(b r100) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        return r101.f443549a;
    }
}
