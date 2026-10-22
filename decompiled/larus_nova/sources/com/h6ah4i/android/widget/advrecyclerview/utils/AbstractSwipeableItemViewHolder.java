package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import bw7.f;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractSwipeableItemViewHolder extends RecyclerView.ViewHolder implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f276054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f276055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f276056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f276057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f276058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f276059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f276060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f276061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f276062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f276063j;

    @Override // bw7.f
    public void W0(float r100) {
    }

    @Override // bw7.f
    public abstract ConstraintLayout r1();

    @Override // bw7.f
    public final void x2() {
        this.f276057d = true;
    }

    @Override // bw7.f
    public final boolean G0() {
        return this.f276057d;
    }

    @Override // bw7.f
    public final float G2() {
        return this.f276062i;
    }

    @Override // bw7.f
    public final float H1() {
        return this.f276059f;
    }

    @Override // bw7.f
    public final float I1() {
        return this.f276061h;
    }

    @Override // bw7.f
    public final int a1() {
        return this.f276055b;
    }

    @Override // bw7.f
    public final float h0() {
        return this.f276060g;
    }

    @Override // bw7.f
    public final float j2() {
        return this.f276063j;
    }

    @Override // bw7.f
    public final int n0() {
        return this.f276054a;
    }

    @Override // bw7.f
    public final float u2() {
        return this.f276058e;
    }

    @Override // bw7.f
    public final int u3() {
        return this.f276056c;
    }

    public AbstractSwipeableItemViewHolder(View r100) {
        super(r100);
        this.f276055b = 0;
        this.f276056c = 0;
        this.f276057d = true;
        this.f276060g = -65536.0f;
        this.f276061h = -65537.0f;
        this.f276062i = 65536.0f;
        this.f276063j = 65537.0f;
    }

    @Override // bw7.f
    public final void j3(int r100) {
        this.f276055b = r100;
    }

    @Override // bw7.f
    public final void o1(int r100) {
        this.f276054a = r100;
    }

    @Override // bw7.f
    public final void o3(int r100) {
        this.f276056c = r100;
    }

    @Override // bw7.f
    public final void r3(float r100) {
        this.f276059f = r100;
    }

    @Override // bw7.f
    public final void z0(float r100) {
        this.f276058e = r100;
    }
}
