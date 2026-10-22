package com.bytedance.scene.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/* JADX INFO: loaded from: classes19.dex */
public abstract class UserVisibleHintGroupScene extends GroupScene {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i f268666u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f268667v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f268668w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f268669x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f268670y;

    public class a implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserVisibleHintGroupScene f268671a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.f268671a.f268666u.a(Lifecycle.Event.ON_DESTROY);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void onPause() {
            UserVisibleHintGroupScene r100 = this.f268671a;
            r100.f268668w = false;
            if (r100.f268667v == false) goto L6;
            r100.f268666u.a(Lifecycle.Event.ON_PAUSE);
            return;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            UserVisibleHintGroupScene r100 = this.f268671a;
            r100.f268668w = true;
            if (r100.f268667v == false) goto L6;
            r100.f268666u.a(Lifecycle.Event.ON_RESUME);
            return;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            UserVisibleHintGroupScene r100 = this.f268671a;
            r100.f268669x = true;
            if (r100.f268667v == false) goto L6;
            r100.f268666u.a(Lifecycle.Event.ON_START);
            return;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop() {
            UserVisibleHintGroupScene r100 = this.f268671a;
            r100.f268669x = false;
            if (r100.f268667v == false) goto L6;
            r100.f268666u.a(Lifecycle.Event.ON_STOP);
            return;
        }

        public a(UserVisibleHintGroupScene r100) {
            this.f268671a = r100;
        }
    }

    @Override // com.bytedance.scene.Scene
    public void a0() {
        this.f268595m = true;
        getLifecycle().removeObserver(this.f268670y);
    }

    public UserVisibleHintGroupScene() {
        this.f268666u = new i();
        this.f268667v = true;
        this.f268668w = false;
        this.f268669x = false;
        this.f268670y = new a(this);
    }

    @Override // com.bytedance.scene.Scene
    public final boolean S() {
        if (super.S() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f268667v == false) goto L7;
        return true;
    }

    public void A0(boolean r100) {
        if (this.f268667v != r100) goto L5;
        return;
    L5:
        this.f268667v = r100;
        boolean r101 = S();
        if (r101 == this.f268596n) goto L10;
        this.f268596n = r101;
    L10:
        if (this.f268667v == false) goto L18;
        if (this.f268669x == false) goto L15;
        this.f268666u.a(Lifecycle.Event.ON_START);
    L15:
        if (this.f268668w == false) goto L24;
        this.f268666u.a(Lifecycle.Event.ON_RESUME);
        return;
    L24:
        return;
    L18:
        if (this.f268668w == false) goto L21;
        this.f268666u.a(Lifecycle.Event.ON_PAUSE);
    L21:
        if (this.f268669x == false) goto L26;
        this.f268666u.a(Lifecycle.Event.ON_STOP);
        return;
    }

    @Override // com.bytedance.scene.Scene
    public void T(Bundle r100) {
        super.T(r100);
        this.f268666u.a(Lifecycle.Event.ON_CREATE);
        getLifecycle().addObserver(this.f268670y);
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public void W(Bundle r100) {
        super.W(r100);
        if (r100 == null) goto L6;
        this.f268667v = r100.getBoolean("bd-scene-nav:scene_user_visible_hint");
        return;
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public final void f0(Bundle r100) {
        super.f0(r100);
        r100.putBoolean("bd-scene-nav:scene_user_visible_hint", this.f268667v);
    }

    @Override // com.bytedance.scene.group.GroupScene, com.bytedance.scene.Scene
    public /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }
}
