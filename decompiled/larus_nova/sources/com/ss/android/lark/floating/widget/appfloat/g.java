package com.ss.android.lark.floating.widget.appfloat;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/* JADX INFO: loaded from: classes35.dex */
public final class g<T> implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Point f421954a;

    public g(Point r100) {
        this.f421954a = r100;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float r100, Object r101, Object r102) {
        Point r103 = (Point) r101;
        Point r104 = (Point) r102;
        Point r105 = this.f421954a;
        int r106 = r103.x;
        r105.x = (int) (r106 + ((r104.x - r106) * r100));
        int r107 = r103.y;
        r105.y = (int) (r107 + ((r104.y - r107) * r100));
        return r105;
    }
}
