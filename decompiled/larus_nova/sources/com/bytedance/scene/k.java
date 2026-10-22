package com.bytedance.scene;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes19.dex */
public final class k extends LayoutInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scene f268728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f268729b;

    public final void a() {
        if (this.f268729b == null) goto L5;
        return;
    L5:
        this.f268728a.getClass();
        Activity r100 = this.f268728a.h0();
        this.f268729b = this.f268728a.h0().getLayoutInflater().cloneInContext(r100);
        LayoutInflater.Filter r101 = getFilter();
        if (r101 == null) goto L8;
        this.f268729b.setFilter(r101);
    L8:
        LayoutInflater.Factory2 r102 = getFactory2();
        if (r102 == null) goto L11;
        this.f268729b.setFactory2(r102);
        return;
    L11:
        LayoutInflater.Factory r103 = getFactory();
        if (r103 == null) goto L16;
        this.f268729b.setFactory(r103);
        return;
    }

    @Override // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context r100) {
        return new k(r100, this.f268728a);
    }

    @Override // android.view.LayoutInflater
    public final void setFactory(LayoutInflater.Factory r100) {
        super.setFactory(r100);
        LayoutInflater r101 = this.f268729b;
        if (r101 == null) goto L6;
        r101.setFactory(r100);
        return;
    }

    @Override // android.view.LayoutInflater
    public final void setFactory2(LayoutInflater.Factory2 r100) {
        super.setFactory2(r100);
        LayoutInflater r101 = this.f268729b;
        if (r101 == null) goto L6;
        r101.setFactory2(r100);
        return;
    }

    public k(Context r100, Scene r101) {
        super(r100);
        this.f268728a = r101;
    }

    @Override // android.view.LayoutInflater
    public final View inflate(int r100, ViewGroup r101) {
        a();
        return this.f268729b.inflate(r100, r101);
    }

    @Override // android.view.LayoutInflater
    public final View inflate(XmlPullParser r100, ViewGroup r101) {
        a();
        return this.f268729b.inflate(r100, r101);
    }

    @Override // android.view.LayoutInflater
    public final View inflate(int r100, ViewGroup r101, boolean r102) {
        a();
        return this.f268729b.inflate(r100, r101, r102);
    }

    @Override // android.view.LayoutInflater
    public final View inflate(XmlPullParser r100, ViewGroup r101, boolean r102) {
        a();
        return this.f268729b.inflate(r100, r101, r102);
    }
}
