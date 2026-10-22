package com.bytedance.scene.group;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes19.dex */
public abstract class ReuseGroupScene extends GroupScene {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f268658u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LayoutInflater f268659v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Context f268660w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f268661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f268662y;

    public abstract ViewGroup A0();

    @Override // com.bytedance.scene.Scene
    public final void V() {
        this.f268595m = true;
        int r100 = this.f268661x;
        if (r100 != (-1)) goto L8;
        if (this.f268662y != (-1)) goto L8;
        return;
    L8:
        if (r100 == h0().hashCode()) goto L10;
    L11:
        this.f268658u = null;
        this.f268659v = null;
        this.f268660w = null;
        return;
    L10:
        if (this.f268662y != h0().getTheme().hashCode()) goto L11;
    }

    @Override // com.bytedance.scene.Scene
    public final void a0() {
        this.f268595m = true;
        this.f268661x = h0().hashCode();
        this.f268662y = h0().getTheme().hashCode();
        this.f268659v = R();
        this.f268660w = j0();
        this.f268658u = (ViewGroup) this.f268586d;
    }

    @Override // com.bytedance.scene.Scene
    public final Context d0() {
        Context r100 = this.f268660w;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return super.d0();
    }

    public ReuseGroupScene() {
        this.f268661x = -1;
        this.f268662y = -1;
    }

    @Override // com.bytedance.scene.Scene
    public final LayoutInflater c0() {
        if (getActivity() == null) goto L10;
        LayoutInflater r100 = this.f268659v;
        if (r100 == null) goto L8;
        return r100;
    L8:
        return super.c0();
    L10:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Scene is attached to the Activity.");
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        ViewGroup r103 = this.f268658u;
        if (r103 != null) goto L5;
    L9:
        ViewGroup r104 = this.f268658u;
        if (r104 == null) goto L13;
        return r104;
    L13:
        return A0();
    L5:
        if (r103.getParent() == null) goto L9;
        throw new IllegalArgumentException("ReuseGroupScene reuseView already have parent");
    }
}
