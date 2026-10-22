package com.ss.android.lark.widget.richtext.genv2;

import java.util.Comparator;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<Object, Pair<Integer, Integer>> f448321a;

    public a(Map<Object, Pair<Integer, Integer>> r100) {
        this.f448321a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        Pair<Integer, Integer> r102 = this.f448321a.get(r100);
        int r103 = -1;
        if (r102 == null) goto L5;
        int r104 = r102.getFirst().intValue();
    L6:
        Pair<Integer, Integer> r105 = this.f448321a.get(r101);
        if (r105 == null) goto L9;
        int r106 = r105.getFirst().intValue();
    L10:
        if (r104 != r106) goto L21;
        Pair<Integer, Integer> r107 = this.f448321a.get(r100);
        if (r107 == null) goto L15;
        int r108 = r107.getSecond().intValue();
    L16:
        Pair<Integer, Integer> r109 = this.f448321a.get(r101);
        if (r109 == null) goto L20;
        r103 = r109.getSecond().intValue();
    L20:
        return r103 - r108;
    L15:
        r108 = -1;
        goto L16
    L21:
        return r104 - r106;
    L9:
        r106 = -1;
        goto L10
    L5:
        r104 = -1;
        goto L6
    }
}
