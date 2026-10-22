package com.bytedance.scene;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.scene.utlity.SceneInternalException;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public abstract class Scene implements LifecycleOwner, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f268583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f268584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f268585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f268586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Scene f268587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n.b f268588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f268589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public State f268590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StringBuilder f268591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bundle f268592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f268593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Runnable> f268594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f268595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f268596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f268597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SavedStateRegistryController f268598p;

    public class a extends ra7.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Scene f268599f;

        @Override // ra7.a, android.content.ContextWrapper, android.content.Context
        public final Object getSystemService(String r100) {
            if ("scene".equals(r100) == false) goto L7;
            return this.f268599f;
        L7:
            if ("layout_inflater".equals(r100) == false) goto L13;
            if (this.f268599f.getActivity() == null) goto L13;
            return this.f268599f.R();
        L13:
            return super.getSystemService(r100);
        }

        public a(Scene r100, Context r101, Resources.Theme r102) {
            this.f268599f = r100;
            super(r101, r102);
        }
    }

    public static class b extends Lifecycle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LifecycleRegistry f268600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<LifecycleObserver> f268601b;

        @Override // androidx.lifecycle.Lifecycle
        public final Lifecycle.State getCurrentState() {
            return this.f268600a.getCurrentState();
        }

        public b(LifecycleRegistry r100) {
            this.f268601b = new ArrayList();
            this.f268600a = r100;
        }

        @Override // androidx.lifecycle.Lifecycle
        public final void addObserver(LifecycleObserver r100) {
            ((ArrayList) this.f268601b).add(r100);
            this.f268600a.addObserver(r100);
        }

        public final void handleLifecycleEvent(Lifecycle.Event r100) {
            this.f268600a.handleLifecycleEvent(r100);
        }

        @Override // androidx.lifecycle.Lifecycle
        public final void removeObserver(LifecycleObserver r100) {
            ((ArrayList) this.f268601b).remove(r100);
            this.f268600a.removeObserver(r100);
        }
    }

    public static class c implements n.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewModelStore f268602a;

        @Override // com.bytedance.scene.n.c
        public final void onUnRegister() {
            this.f268602a.clear();
        }

        public c(ViewModelStore r100) {
            this.f268602a = r100;
        }
    }

    public void M() {
        this.f268595m = false;
        v(this, false);
        onResume();
        if (this.f268595m == false) goto L7;
        E(this, false);
        k0(State.RESUMED);
        this.f268597o.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        return;
    L7:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onResume()");
    }

    public void O() {
        this.f268595m = false;
        w(this, false);
        onStart();
        if (this.f268595m == false) goto L11;
        G(this, false);
        k0(State.STARTED);
        boolean r100 = S();
        if (r100 == this.f268596n) goto L8;
        this.f268596n = r100;
    L8:
        this.f268597o.handleLifecycleEvent(Lifecycle.Event.ON_START);
        return;
    L11:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onStart()");
    }

    public void V() {
        this.f268595m = true;
    }

    public abstract View Z(LayoutInflater r100, ViewGroup r101, Bundle r102);

    public void a0() {
        this.f268595m = true;
    }

    public void b0() {
        this.f268595m = true;
    }

    public void l() {
        this.f268595m = false;
        t(this, false);
        onDestroy();
        if (this.f268595m == false) goto L7;
        C(this, false);
        return;
    L7:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onDestroy()");
    }

    public void onDestroy() {
        this.f268595m = true;
    }

    public void onPause() {
        this.f268595m = true;
    }

    public void onResume() {
        this.f268595m = true;
        if (((ArrayList) this.f268594l).size() <= 0) goto L11;
        ArrayList r100 = new ArrayList(this.f268594l);
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((Runnable) r101.next()).run();
        goto L6
    L8:
        ((ArrayList) this.f268594l).removeAll(r100);
        return;
    }

    public void onStart() {
        this.f268595m = true;
    }

    public void onStop() {
        this.f268595m = true;
        boolean r100 = S();
        if (r100 == this.f268596n) goto L7;
        this.f268596n = r100;
        return;
    }

    public void p() {
        this.f268587e = null;
    }

    public void L() {
        this.f268597o.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        k0(State.STARTED);
        this.f268595m = false;
        u(this, false);
        onPause();
        if (this.f268595m == false) goto L7;
        D(this, false);
        return;
    L7:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onPause()");
    }

    public void P() {
        this.f268597o.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        k0(State.ACTIVITY_CREATED);
        this.f268595m = false;
        x(this, false);
        onStop();
        if (this.f268595m == false) goto L7;
        H(this, false);
        return;
    L7:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onStop()");
    }

    public final LayoutInflater R() {
        if (this.f268585c != null) goto L6;
        this.f268585c = c0();
    L6:
        return this.f268585c;
    }

    public boolean S() {
        if (this.f268590h.value < State.STARTED.value) goto L5;
        return true;
    L5:
        return false;
    }

    public LayoutInflater c0() {
        if (this.f268583a == null) goto L7;
        return new k(h0(), this);
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Scene is attached to the Activity.");
    }

    public Context d0() {
        if (this.f268583a == null) goto L7;
        Activity r100 = this.f268583a;
        return new a(this, r100, r100.getTheme());
    L7:
        throw new IllegalStateException("onGetContextThemeWrapper() cannot be executed until the Scene is attached to the Activity.");
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        SavedStateRegistryController r100 = this.f268598p;
        if (r100 == null) goto L7;
        return r100.getSavedStateRegistry();
    L7:
        throw new IllegalStateException("SavedStateRegistry is not created, you can't call before onCreate");
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        n r100 = this.f268589g;
        if (r100 == null) goto L11;
        if (((HashMap) r100.f268745d).containsKey(c.class) == true) goto L7;
        ViewModelStore r101 = new ViewModelStore();
        c r102 = new c(r101);
        ((HashMap) r100.f268745d).put(c.class, r102);
        return r101;
    L7:
        return ((c) r100.a(c.class)).f268602a;
    L11:
        throw new IllegalStateException("Scope is not created, you can't call before onCreate");
    }

    public final Bundle i0() {
        Bundle r100 = this.f268592j;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Scene " + this + " does not have any arguments.");
    }

    public final Context j0() {
        if (this.f268583a != null) goto L6;
        Context r100 = null;
    L9:
        if (r100 == null) goto L12;
        return r100;
    L12:
        throw new IllegalStateException("Scene " + this + " not attached to an activity.");
    L6:
        if (this.f268584b != null) goto L8;
        this.f268584b = d0();
    L8:
        r100 = this.f268584b;
        goto L9
    }

    public void m() {
        View r100 = this.f268586d;
        if (qa7.h.f532275a != 0) goto L10;
        qa7.h.f532275a = 2;     // Catch: NoSuchMethodException -> L7
        Method r101 = ViewGroup.class.getDeclaredMethod("cancelTouchTarget", new Class[]{View.class});     // Catch: NoSuchMethodException -> L7
        qa7.h.f532276b = r101;     // Catch: NoSuchMethodException -> L7
        r101.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        qa7.h.f532275a = 1;     // Catch: NoSuchMethodException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    L10:
        if (qa7.h.f532275a != 1) goto L20;
        ViewGroup r102 = (ViewGroup) r100.getParent();
        if (r102 == null) goto L20;
        qa7.h.f532276b.invoke(r102, new Object[]{r100});     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = move-exception;
        e.printStackTrace();
    L20:
        this.f268597o.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        k0(State.NONE);
        this.f268595m = false;
        z(this, false);
        a0();
        if (this.f268595m == false) goto L25;
        K(this, false);
        this.f268586d.cancelPendingInputEvents();
        this.f268586d = null;
        this.f268585c = null;
        return;
    L25:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onDestroyView()");
    }

    public void o() {
        Activity r100 = this.f268583a;
        this.f268583a = null;
        this.f268584b = null;
        this.f268595m = false;
        b0();
        if (this.f268595m == false) goto L19;
        if (r100.isChangingConfigurations() == true) goto L16;
        n r101 = this.f268589g;
        n r102 = r101.f268742a;
        if (r102 == null) goto L9;
        ((HashMap) r102.f268744c).remove(r101.f268743b);
    L9:
        Iterator r103 = ((HashMap) r101.f268745d).values().iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if ((r104 instanceof n.c) == false) goto L11;
        ((n.c) r104).onUnRegister();
        goto L11
    L15:
        ((HashMap) r101.f268745d).clear();
        ((HashMap) r101.f268744c).clear();
    L16:
        this.f268589g = null;
        ((ArrayList) this.f268594l).clear();
        return;
    L19:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onDetach()");
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder(128);
        String r101 = getClass().getSimpleName();
        if (r101.length() > 0) goto L7;
        r101 = getClass().getName();
        int r102 = r101.lastIndexOf(46);
        if (r102 <= 0) goto L7;
        r101 = r101.substring(r102 + 1);
    L7:
        r100.append(r101);
        r100.append('{');
        r100.append(Integer.toHexString(System.identityHashCode(this)));
        r100.append('}');
        return r100.toString();
    }

    public Scene() {
        this.f268588f = n.f268740e;
        State r100 = State.NONE;
        this.f268590h = r100;
        this.f268591i = new StringBuilder(r100.name);
        this.f268593k = true;
        new Handler(Looper.getMainLooper());
        this.f268594l = new ArrayList();
        this.f268595m = false;
        this.f268596n = false;
        this.f268597o = new b(new LifecycleRegistry(this));
    }

    public final Resources getResources() {
        return h0().getResources();
    }

    public final Activity h0() {
        Activity r100 = getActivity();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Scene " + this + " not attached to an activity.");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final Activity getActivity() {
        return this.f268583a;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f268597o;
    }

    public void N(Bundle r100) {
        this.f268595m = false;
        f0(r100);
        if (this.f268595m == false) goto L7;
        this.f268598p.performSave(r100);
        return;
    L7:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onSaveInstanceState()");
    }

    public final <T extends View> T Q(int r100) {
        View r101 = this.f268586d;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.findViewById(r100);
    }

    public void T(Bundle r100) {
        View r101 = h0().getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        int r103 = r101.getSystemUiVisibility();
        if ((r103 & 1024) == 0) goto L11;
        ViewCompat.requestApplyInsets(r101);
    L13:
        this.f268595m = true;
        return;
    L11:
        if ((r103 & 512) == 0) goto L13;
        ViewCompat.requestApplyInsets(r101);
        goto L13
    }

    public void W(Bundle r100) {
        this.f268595m = true;
    }

    public final boolean equals(Object r100) {
        return super.equals(r100);
    }

    public void f0(Bundle r100) {
        this.f268595m = true;
        if (this.f268592j == null) goto L5;
        r100.putBoolean("bd-scene-nav:scene_argument_has", true);
        r100.putBundle("bd-scene-nav:scene_argument", this.f268592j);
    L6:
        r100.putString("scope_key", this.f268589g.f268743b);
        SparseArray<Parcelable> r101 = new SparseArray();
        this.f268586d.saveHierarchyState(r101);
        r100.putSparseParcelableArray("bd-scene:views", r101);
        View r102 = this.f268586d.findFocus();
        if (r102 != null) goto L9;
    L11:
        F(this, r100, false);
        return;
    L9:
        if (r102.getId() == (-1)) goto L11;
        r100.putInt("bd-scene:focusedViewId", r102.getId());
        goto L11
    L5:
        r100.putBoolean("bd-scene-nav:scene_argument_has", false);
        goto L6
    }

    public void g(Bundle r100) {
        this.f268595m = false;
        r(this, r100, false);
        T(r100);
        if (this.f268595m == false) goto L23;
        A(this, r100, false);
        if (r100 == null) goto L20;
        this.f268595m = true;
        SparseArray<Parcelable> r101 = r100.getSparseParcelableArray("bd-scene:views");
        if (r101 == null) goto L9;
        this.f268586d.restoreHierarchyState(r101);
    L9:
        int r102 = r100.getInt("bd-scene:focusedViewId", -1);
        if (r102 == (-1)) goto L16;
        View r103 = this.f268586d.findViewById(r102);
        if (r103 == null) goto L16;
        r103.requestFocus();
    L16:
        if (this.f268595m == true) goto L20;
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onViewStateRestored()");
    L20:
        k0(State.ACTIVITY_CREATED);
        this.f268597o.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L23:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onActivityCreated()");
    }

    public void h(Activity r100) {
        this.f268583a = r100;
        if (this.f268597o.getCurrentState() == Lifecycle.State.INITIALIZED) goto L12;
        b r101 = this.f268597o;
        Iterator r102 = ((ArrayList) r101.f268601b).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        LifecycleObserver r103 = (LifecycleObserver) r102.next();
        r101.f268600a.removeObserver(r103);
        goto L6
    L8:
        r101.f268600a.markState(Lifecycle.State.INITIALIZED);
        Iterator r104 = ((ArrayList) r101.f268601b).iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        LifecycleObserver r105 = (LifecycleObserver) r104.next();
        r101.f268600a.addObserver(r105);
        goto L10
    L15:
        return;
    }

    public void i(Scene r100) {
        if (r100 == null) goto L4;
        this.f268587e = r100;
    L4:
        this.f268595m = false;
        V();
        if (this.f268595m == false) goto L8;
        return;
    L8:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onAttach()");
    }

    public void j(Bundle r100) {
        Scene r101 = this.f268587e;
        if (r101 != null) goto L5;
        this.f268589g = this.f268588f.N80();
    L17:
        if (r100 != null) goto L19;
    L25:
        this.f268595m = false;
        SavedStateRegistryController r102 = SavedStateRegistryController.create(this);
        this.f268598p = r102;
        r102.performRestore(r100);
        s(this, r100, false);
        W(r100);
        if (this.f268595m == false) goto L30;
        B(this, r100, false);
        return;
    L30:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onCreate()");
    L19:
        if (r100.getBoolean("bd-scene-nav:scene_argument_has") == false) goto L25;
        Bundle r103 = r100.getBundle("bd-scene-nav:scene_argument");
        if (r103 == null) goto L24;
        r103.setClassLoader(getClass().getClassLoader());
        this.f268592j = r103;
        goto L25
    L24:
        throw new IllegalStateException("can't get Scene arguments from savedInstanceState");
    L5:
        n r104 = r101.f268589g;
        if (r104 == null) goto L32;
        if (r100 == null) goto L9;
        String r105 = r100.getString("scope_key");
    L11:
        if (TextUtils.isEmpty(r105) == false) goto L13;
        n.a r106 = n.f268740e;
        r105 = "Scene #" + n.f268741f.getAndIncrement();
    L13:
        n r107 = (n) ((HashMap) r104.f268744c).get(r105);
        if (r107 != null) goto L16;
        r107 = new n(r104, r105);
        ((HashMap) r104.f268744c).put(r105, r107);
    L16:
        this.f268589g = r107;
        goto L17
    L9:
        r105 = null;
        goto L11
    L32:
        throw new IllegalStateException("Scope is not created, you can't call before onCreate");
    }

    public final void k0(State r100) {
        State r101 = this.f268590h;
        int r102 = r100.value;
        int r103 = r101.value;
        if (r102 > r103) goto L5;
        if (r102 < r103) goto L11;
    L20:
        this.f268590h = r100;
        this.f268591i.append(" - " + r100.name);
        return;
    L11:
        if (r101 != State.ACTIVITY_CREATED) goto L16;
        if (r100 == State.NONE) goto L20;
    L16:
        if ((r102 - r103) == (-1)) goto L20;
        throw new SceneInternalException("Cant setState from " + r101.name + " to " + r100.name);
    L5:
        if ((r102 - r103) == 1) goto L20;
        throw new SceneInternalException("Cant setState from " + r101.name + " to " + r100.name);
    }

    public void C(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.C(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void D(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.D(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void E(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.E(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void G(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.G(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void H(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.H(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void K(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.K(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void g0(View r100, Bundle r101) {
        this.f268595m = true;
    }

    public void k(Bundle r100, ViewGroup r101) {
        if (this.f268586d != null) goto L19;
        View r102 = Z(R(), r101, r100);
        if (r102 == null) goto L17;
        if (r102.getParent() != null) goto L15;
        r102.getId();
        j0();
        r102.getContext();
        r102.setTag(R.id.view_tree_lifecycle_owner, this);
        r102.setTag(R.id.view_tree_view_model_store_owner, this);
        r102.setTag(R.id.view_tree_saved_state_registry_owner, this);
        r102.setTag(R.id.bytedance_scene_view_scene_tag, this);
        r102.setSaveFromParentEnabled(false);
        this.f268586d = r102;
        this.f268595m = false;
        y(this, r100, false);
        g0(this.f268586d, r100);
        if (this.f268595m == false) goto L13;
        J(this, r100, false);
        k0(State.VIEW_CREATED);
        return;
    L13:
        throw new SuperNotCalledException("Scene " + this + " did not call through to super.onViewCreated()");
    L15:
        throw new IllegalArgumentException("onCreateView returned view already has a parent. You must call removeView() on the view's parent first.");
    L17:
        throw new IllegalArgumentException("onCreateView cant return null");
    L19:
        throw new IllegalArgumentException("Scene already call onCreateView");
    }

    public void t(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.t(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void u(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.u(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void v(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.v(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void w(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.w(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void x(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.x(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void z(Scene r100, boolean r101) {
        Scene r102 = this.f268587e;
        if (r102 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r103 = true;
    L7:
        r102.z(r100, r103);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public void A(Scene r100, Bundle r101, boolean r102) {
        Scene r103 = this.f268587e;
        if (r103 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r104 = true;
    L7:
        r103.A(r100, r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }

    public void B(Scene r100, Bundle r101, boolean r102) {
        Scene r103 = this.f268587e;
        if (r103 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r104 = true;
    L7:
        r103.B(r100, r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }

    public void F(Scene r100, Bundle r101, boolean r102) {
        Scene r103 = this.f268587e;
        if (r103 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r104 = true;
    L7:
        r103.F(r100, r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }

    public void J(Scene r100, Bundle r101, boolean r102) {
        Scene r103 = this.f268587e;
        if (r103 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r104 = true;
    L7:
        r103.J(r100, r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }

    public void r(Scene r100, Bundle r101, boolean r102) {
        Scene r103 = this.f268587e;
        if (r103 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r104 = true;
    L7:
        r103.r(r100, r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }

    public void s(Scene r100, Bundle r101, boolean r102) {
        Scene r103 = this.f268587e;
        if (r103 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r104 = true;
    L7:
        r103.s(r100, r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }

    public void y(Scene r100, Bundle r101, boolean r102) {
        Scene r103 = this.f268587e;
        if (r103 == null) goto L9;
        if (r100 != this) goto L6;
        boolean r104 = true;
    L7:
        r103.y(r100, r101, r104);
        return;
    L6:
        r104 = false;
        goto L7
    }
}
