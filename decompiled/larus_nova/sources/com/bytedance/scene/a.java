package com.bytedance.scene;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashSet;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.scene.a$a, reason: collision with other inner class name */
    public static class C3754a implements SceneActivityCompatibilityLayerFragment.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SceneActivityCompatibilityLayerFragment f268619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f268620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f268621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Intent f268622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f268623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ na7.a f268624f;

        @Override // com.bytedance.scene.SceneActivityCompatibilityLayerFragment.c
        public final void onActivityCreated() {
            ((HashSet) this.f268619a.f268606d).remove(this);
            if (a.b(this.f268620b, this.f268621c) == false) goto L5;
            return;
        L5:
            this.f268619a.c(this.f268621c, this.f268622d, this.f268623e, this.f268624f);
        }

        public C3754a(SceneActivityCompatibilityLayerFragment r100, Activity r101, LifecycleOwner r102, Intent r103, int r104, na7.a r105) {
            this.f268619a = r100;
            this.f268620b = r101;
            this.f268621c = r102;
            this.f268622d = r103;
            this.f268623e = r104;
            this.f268624f = r105;
        }
    }

    public static class b implements SceneActivityCompatibilityLayerFragment.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SceneActivityCompatibilityLayerFragment f268625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f268626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f268627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Intent f268628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f268629e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Bundle f268630f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ na7.a f268631g;

        @Override // com.bytedance.scene.SceneActivityCompatibilityLayerFragment.c
        public final void onActivityCreated() {
            ((HashSet) this.f268625a.f268606d).remove(this);
            if (a.b(this.f268626b, this.f268627c) == false) goto L5;
            return;
        L5:
            this.f268625a.b(this.f268627c, this.f268628d, this.f268629e, this.f268630f, this.f268631g);
        }

        public b(SceneActivityCompatibilityLayerFragment r100, Activity r101, LifecycleOwner r102, Intent r103, int r104, Bundle r105, na7.a r106) {
            this.f268625a = r100;
            this.f268626b = r101;
            this.f268627c = r102;
            this.f268628d = r103;
            this.f268629e = r104;
            this.f268630f = r105;
            this.f268631g = r106;
        }
    }

    public static class c implements SceneActivityCompatibilityLayerFragment.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SceneActivityCompatibilityLayerFragment f268632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f268633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f268634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String[] f268635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f268636e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ na7.c f268637f;

        @Override // com.bytedance.scene.SceneActivityCompatibilityLayerFragment.c
        public final void onActivityCreated() {
            ((HashSet) this.f268632a.f268606d).remove(this);
            if (a.b(this.f268633b, this.f268634c) == false) goto L5;
            return;
        L5:
            SceneActivityCompatibilityLayerFragment r100 = this.f268632a;
            LifecycleOwner r101 = this.f268634c;
            String[] r102 = this.f268635d;
            int r103 = this.f268636e;
            na7.c r104 = this.f268637f;
            if (r100.a(r101) == false) goto L10;
            r100.f268604b.put(r103, r104);
            r100.requestPermissions(r102, r103);
            r101.getLifecycle().addObserver(new g(r100, r101, r103));
            return;
        }

        public c(SceneActivityCompatibilityLayerFragment r100, Activity r101, LifecycleOwner r102, String[] r103, int r104, na7.c r105) {
            this.f268632a = r100;
            this.f268633b = r101;
            this.f268634c = r102;
            this.f268635d = r103;
            this.f268636e = r104;
            this.f268637f = r105;
        }
    }

    public static SceneActivityCompatibilityLayerFragment a(Activity r100) {
        SceneActivityCompatibilityLayerFragment r101 = (SceneActivityCompatibilityLayerFragment) r100.getFragmentManager().findFragmentByTag(SceneActivityCompatibilityLayerFragment.class.getName());
        if (r101 != null) goto L6;
        SceneActivityCompatibilityLayerFragment r102 = new SceneActivityCompatibilityLayerFragment();
        FragmentTransaction r103 = r100.getFragmentManager().beginTransaction().add(r102, SceneActivityCompatibilityLayerFragment.class.getName());
        qa7.g.a(r100.getFragmentManager(), r103, false);
        return r102;
    L6:
        return r101;
    }

    public static boolean b(Activity r100, LifecycleOwner r101) {
        if (qa7.g.c(r100) == true) goto L6;
        return true;
    L6:
        if (r101.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        return false;
    L10:
        return true;
    }

    public static void requestPermissions(Activity r100, LifecycleOwner r110, String[] r111, int r112, na7.c r113) {
        qa7.f.a();
        if (b(r100, r110) == false) goto L5;
        return;
    L5:
        SceneActivityCompatibilityLayerFragment r101 = a(r100);
        if (r101.isAdded() == true) goto L8;
        c r102 = new c(r101, r100, r110, r111, r112, r113);
        ((HashSet) r101.f268606d).add(r102);
        return;
    L8:
        if (r101.a(r110) == false) goto L14;
        r101.f268604b.put(r112, r113);
        r101.requestPermissions(r111, r112);
        r110.getLifecycle().addObserver(new g(r101, r110, r112));
        return;
    }

    public static void startActivityForResult(Activity r100, LifecycleOwner r110, Intent r111, int r112, na7.a r113) {
        qa7.f.a();
        if (b(r100, r110) == false) goto L5;
        return;
    L5:
        SceneActivityCompatibilityLayerFragment r101 = a(r100);
        if (r101.isAdded() == false) goto L8;
        r101.c(r110, r111, r112, r113);
        return;
    L8:
        C3754a r102 = new C3754a(r101, r100, r110, r111, r112, r113);
        ((HashSet) r101.f268606d).add(r102);
    }

    public static void startActivityForResult(Activity r110, LifecycleOwner r111, Intent r112, int r113, Bundle r114, na7.a r115) {
        qa7.f.a();
        if (b(r110, r111) == false) goto L5;
        return;
    L5:
        SceneActivityCompatibilityLayerFragment r100 = a(r110);
        if (r100.isAdded() == false) goto L8;
        r100.b(r111, r112, r113, r114, r115);
        return;
    L8:
        b r101 = new b(r100, r110, r111, r112, r113, r114, r115);
        ((HashSet) r100.f268606d).add(r101);
    }
}
