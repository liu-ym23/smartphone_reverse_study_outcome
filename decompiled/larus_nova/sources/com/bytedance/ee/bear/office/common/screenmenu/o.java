package com.bytedance.ee.bear.office.common.screenmenu;

import android.graphics.Rect;
import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class o<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenMenuLayout f235238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f235239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f235240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f235241d;

    public o(ScreenMenuLayout r100, Rect r101, int r102, int r103) {
        this.f235238a = r100;
        this.f235239b = r101;
        this.f235240c = r102;
        this.f235241d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Pair r102 = (Pair) r100;
        Pair r103 = (Pair) r101;
        return ComparisonsKt.compareValues(Integer.valueOf(ScreenMenuLayout.c(this.f235238a, this.f235239b, ((Number) r102.getFirst()).intValue(), ((Number) r102.getSecond()).intValue(), this.f235240c, this.f235241d)), Integer.valueOf(ScreenMenuLayout.c(this.f235238a, this.f235239b, ((Number) r103.getFirst()).intValue(), ((Number) r103.getSecond()).intValue(), this.f235240c, this.f235241d)));
    }
}
