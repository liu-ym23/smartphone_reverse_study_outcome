package com.bytedance.scene;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public class SceneActivityCompatibilityLayerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArrayCompat<na7.a> f268603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArrayCompat<na7.c> f268604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.scene.navigation.b> f268605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<c> f268606d;

    public class a implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f268607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f268608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SceneActivityCompatibilityLayerFragment f268609c;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.f268607a.getLifecycle().removeObserver(this);
            this.f268609c.f268603a.remove(this.f268608b);
        }

        public a(SceneActivityCompatibilityLayerFragment r100, LifecycleOwner r101, int r102) {
            this.f268609c = r100;
            this.f268607a = r101;
            this.f268608b = r102;
        }
    }

    public class b implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f268610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f268611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SceneActivityCompatibilityLayerFragment f268612c;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.f268610a.getLifecycle().removeObserver(this);
            this.f268612c.f268603a.remove(this.f268611b);
        }

        public b(SceneActivityCompatibilityLayerFragment r100, LifecycleOwner r101, int r102) {
            this.f268612c = r100;
            this.f268610a = r101;
            this.f268611b = r102;
        }
    }

    public interface c {
        void onActivityCreated();
    }

    public SceneActivityCompatibilityLayerFragment() {
        this.f268603a = new SparseArrayCompat();
        this.f268604b = new SparseArrayCompat();
        this.f268605c = new ArrayList();
        this.f268606d = new HashSet();
    }

    public final boolean a(LifecycleOwner r100) {
        qa7.f.a();
        if (qa7.g.c(getActivity()) == true) goto L6;
        return false;
    L6:
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Iterator r101 = new HashSet(this.f268606d).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).onActivityCreated();
        goto L4
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        ArrayList r101 = new ArrayList(this.f268605c);
        int r102 = r101.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L8;
        com.bytedance.scene.navigation.b r103 = (com.bytedance.scene.navigation.b) ListProtector.get(r101, r102);
        if (r103 == null) goto L3;
        r103.b();
        goto L3
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        na7.a r103 = this.f268603a.get(r100);
        if (r103 == null) goto L6;
        r103.onResult(r101, r102);
        this.f268603a.remove(r100);
        return;
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {Integer.valueOf(r210), r211, r212};
        f06.b r112 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(102612);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r213 = r102;
        f06.d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r111, "void", r112);     // Catch: Exception -> L24
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L24
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        na7.c r107 = this.f268604b.get(r210);
        if (r107 == null) goto L30;
        r107.onResult(r212);
        this.f268604b.remove(r210);
        return;
    L30:
        return;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r213;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    public final void c(LifecycleOwner r100, Intent r101, int r102, na7.a r103) {
        if (a(r100) == true) goto L5;
        return;
    L5:
        if (r102 >= 0) goto L8;
        startActivity(r101);
        return;
    L8:
        this.f268603a.put(r102, r103);
        startActivityForResult(r101, r102);
        r100.getLifecycle().addObserver(new a(this, r100, r102));
    }

    public final void b(LifecycleOwner r100, Intent r101, int r102, Bundle r103, na7.a r104) {
        if (a(r100) == true) goto L5;
        return;
    L5:
        if (r102 >= 0) goto L8;
        startActivity(r101);
        return;
    L8:
        this.f268603a.put(r102, r104);
        startActivityForResult(r101, r102, r103);
        r100.getLifecycle().addObserver(new b(this, r100, r102));
    }
}
