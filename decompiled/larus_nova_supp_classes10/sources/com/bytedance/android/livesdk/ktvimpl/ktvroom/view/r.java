package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class r {
    public volatile float a;
    public volatile float b;
    public volatile float c;
    public volatile float d;
    public volatile float e;
    public volatile float f;
    public volatile boolean g;
    public final RectF h;
    public final RectF i;
    public final Matrix j;

    public final void a() {
        this.a = 1.0f;
        this.b = 1.0f;
        this.c = 1.0f;
        this.f = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.g = false;
    }

    public r() {
        this.a = 1.0f;
        this.b = 1.0f;
        this.c = 1.0f;
        this.h = new RectF();
        this.i = new RectF();
        this.j = new Matrix();
    }
}
