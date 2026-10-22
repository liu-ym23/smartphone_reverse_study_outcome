package com.bytedance.bdp.bdpplatform.service.ui.picker.wheel;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public abstract class d extends ja4.e<View> {
    public static boolean Q;
    public final float D;
    public final int E;
    public final int F;
    public final int G;
    public final Typeface H;
    public final int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f201486J;
    public final int K;
    public final int L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final WheelView.a P;

    @Override // ja4.b
    public final void a() {
        Q = false;
    }

    public final WheelView g() {
        WheelView r100 = new WheelView(this.f497851a);
        r100.setLineSpaceMultiplier(this.D);
        r100.setTextPadding(this.E);
        r100.setTextSize(this.F);
        r100.setOutTextSize(this.G);
        r100.setTypeface(this.H);
        int r101 = this.I;
        int r102 = this.f201486J;
        r100.f201462r = r101;
        r100.f201463s = r102;
        r100.f201450f.setColor(r101);
        r100.f201451g.setColor(r102);
        r100.setDividerConfig(this.P);
        r100.setOffset(this.L);
        r100.setCycleDisable(this.M);
        r100.setUseWeight(this.N);
        r100.setTextSizeAutoFit(this.O);
        return r100;
    }

    public d(Activity r100) {
        super(r100);
        this.D = 3.0f;
        this.E = -1;
        this.F = 17;
        this.G = 15;
        this.H = Typeface.DEFAULT;
        this.I = -6710887;
        this.f201486J = -14540254;
        this.K = -14540254;
        this.L = 5;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = new WheelView.a();
    }
}
