package com.larus.home.impl.main.side_bar.view.group.render;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m<ITEM> implements n<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f345683a;

    public static final class a {
    }

    static {
    }

    public m() {
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.n
    public final int b(int r100) {
        int r101 = Math.max(this.f345683a, r100);
        this.f345683a = r101;
        return r101;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.n
    public final void c(int r100) {
        int r101 = this.f345683a;
        int r102 = Integer.MAX_VALUE;
        if (r101 >= (Integer.MAX_VALUE - r100)) goto L6;
        r102 = r101 + r100;
    L6:
        this.f345683a = r102;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.n
    public final void d(int r100) {
        this.f345683a = r100;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.n
    public final List<zb9.i<ITEM>> a(List<zb9.i<ITEM>> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "loadedItems");
        if (r101 == true) goto L11;
        int r102 = r100.size();
        int r103 = this.f345683a;
        if (r103 < 2147483646) goto L7;
        int r104 = Integer.MAX_VALUE;
    L8:
        if (r102 != r104) goto L11;
        return r100;
    L7:
        r104 = r103 + 1;
    L11:
        return CollectionsKt.take(r100, this.f345683a);
    }
}
