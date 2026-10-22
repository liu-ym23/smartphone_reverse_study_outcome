package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.Spanned;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class c0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spanned f232326a;

    public c0(Spanned r100) {
        this.f232326a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Spanned r102 = this.f232326a;
        Integer r103 = Integer.valueOf(r102.getSpanStart((un5.e) r100));
        Spanned r104 = this.f232326a;
        return ComparisonsKt.compareValues(r103, Integer.valueOf(r104.getSpanStart((un5.e) r101)));
    }
}
