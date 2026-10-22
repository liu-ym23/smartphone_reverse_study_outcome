package com.bytedance.scene.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AsyncLayoutGroupScene extends UserVisibleHintGroupScene {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f268644z;

    public class a implements h.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f268645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AsyncLayoutGroupScene f268646b;

        public a(AsyncLayoutGroupScene r100, FrameLayout r101, Bundle r102) {
            this.f268646b = r100;
            this.f268645a = r101;
        }
    }

    public abstract int B0();

    @Override // com.bytedance.scene.Scene
    public final void onPause() {
        this.f268595m = true;
    }

    @Override // com.bytedance.scene.Scene
    public final void onStart() {
        this.f268595m = true;
    }

    public AsyncLayoutGroupScene() {
        this.f268644z = false;
    }

    @Override // com.bytedance.scene.Scene
    public final void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.scene.Scene
    public final void onStop() {
        super.onStop();
    }

    @Override // com.bytedance.scene.group.UserVisibleHintGroupScene
    public final void A0(boolean r100) {
        super.A0(r100);
        if (r100 == false) goto L5;
        this.f268644z = false;
        return;
    L5:
        this.f268644z = true;
    }

    @Override // com.bytedance.scene.group.UserVisibleHintGroupScene, com.bytedance.scene.Scene
    public final void T(Bundle r100) {
        super.T(r100);
    }

    @Override // com.bytedance.scene.Scene
    public final void g0(View r100, Bundle r101) {
        this.f268595m = true;
    }

    @Override // com.bytedance.scene.group.GroupScene
    public final ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        if (this.f268644z == false) goto L13;
        FrameLayout r103 = new FrameLayout(j0());
        h r104 = new h(j0());
        int r105 = B0();
        a r106 = new a(this, r103, r102);
        h.d r107 = r104.f268715c.f268726w.acquire();
        if (r107 != null) goto L7;
        r107 = new h.d();
    L7:
        r107.f268719a = r104;
        r107.f268721c = r105;
        r107.f268720b = r101;
        r107.f268723e = r106;
        h.e r108 = r104.f268715c;
        r108.getClass();
        r108.f268725v.put(r107);     // Catch: InterruptedException -> L10
        return r103;
    L10:
        e = move-exception;
        throw new RuntimeException("Failed to enqueue async inflate request", e);
    L13:
        View r109 = r100.inflate(B0(), r101, false);
        if ((r109 instanceof ViewGroup) == false) goto L18;
        return (ViewGroup) r109;
    L18:
        throw new IllegalArgumentException("AsyncLayoutGroupScene getLayoutId() view must be ViewGroup");
    }
}
