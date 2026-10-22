package com.bytedance.scene.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.collection.LruCache;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.scene.Scene;
import com.bytedance.scene.State;
import com.bytedance.scene.group.ReuseGroupScene;
import com.bytedance.scene.m;
import com.bytedance.scene.p;
import com.bytedance.scene.ui.template.SwipeBackGroupScene;
import com.bytedance.scene.utlity.SceneInstanceUtility;
import com.bytedance.scene.utlity.SceneInternalException;
import com.bytedance.scene.view.AnimationContainerLayout;
import com.bytedance.scene.view.NavigationFrameLayout;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class NavigationScene extends Scene implements com.bytedance.scene.navigation.c, m, p {
    public final c A;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f268752q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i f268753r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f268754s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FrameLayout f268755t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimationContainerLayout f268756u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ka7.a f268757v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<la7.d.b> f268758w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LruCache<Class, ReuseGroupScene> f268759x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<com.bytedance.scene.navigation.c> f268760y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<qa7.e<na7.b, Boolean>> f268761z;

    public static final enum TranslucentOption extends Enum<TranslucentOption> {
        public static final TranslucentOption FROM_TRANSLUCENT = null;
        public static final TranslucentOption TO_TRANSLUCENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TranslucentOption[] f268762a = null;

        static {
            TranslucentOption r100 = new TranslucentOption("TO_TRANSLUCENT", 0);
            TO_TRANSLUCENT = r100;
            TranslucentOption r101 = new TranslucentOption("FROM_TRANSLUCENT", 1);
            FROM_TRANSLUCENT = r101;
            f268762a = new TranslucentOption[]{r100, r101};
        }

        public static TranslucentOption[] values() {
            return (TranslucentOption[]) f268762a.clone();
        }

        public static TranslucentOption valueOf(String r100) {
            return (TranslucentOption) r27.a.a(TranslucentOption.class, r100);
        }

        public TranslucentOption(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f268763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f268764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NavigationScene f268765c;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.f268763a.getLifecycle().removeObserver(this);
            this.f268765c.f268754s.h(this.f268764b);
        }

        public a(NavigationScene r100, LifecycleOwner r101, j r102) {
            this.f268765c = r100;
            this.f268763a = r101;
            this.f268764b = r102;
        }
    }

    public class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationScene f268766a;

        @Override // com.bytedance.scene.navigation.j
        public final boolean onBackPressed() {
            return this.f268766a.p0();
        }

        public b(NavigationScene r100) {
            this.f268766a = r100;
        }
    }

    public class c implements la7.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationScene f268767a;

        @Override // la7.d.b
        public final void onFinish() {
            Iterator r100 = new ArrayList(this.f268767a.f268758w).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((la7.d.b) r100.next()).onFinish();
            goto L4
        }

        @Override // la7.d.b
        public final void onStart() {
            Iterator r100 = new ArrayList(this.f268767a.f268758w).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((la7.d.b) r100.next()).onStart();
            goto L4
        }

        public c(NavigationScene r100) {
            this.f268767a = r100;
        }

        @Override // la7.d.b
        public final void onProgress(float r100) {
            Iterator r101 = new ArrayList(this.f268767a.f268758w).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((la7.d.b) r101.next()).onProgress(r100);
            goto L4
        }
    }

    @Override // com.bytedance.scene.Scene
    public final void V() {
        this.f268595m = true;
    }

    @Override // com.bytedance.scene.m
    public final void a() {
        this.f268752q = false;
    }

    @Override // com.bytedance.scene.Scene
    public final void L() {
        m0(State.STARTED);
        super.L();
    }

    @Override // com.bytedance.scene.Scene
    public final void P() {
        m0(State.ACTIVITY_CREATED);
        super.P();
    }

    @Override // com.bytedance.scene.Scene
    public final void a0() {
        State r100 = State.NONE;
        e r101 = this.f268754s;
        String r102 = r101.a("NavigationManager dispatchChildrenState");
        e.j r103 = new e.j(r101, r100);
        e.b r104 = e.f268776m;
        r101.e(r103);
        r101.d(r102);
        this.f268595m = true;
    }

    public final void n0() {
        Scene r100 = this.f268754s.f();
        if (r100 == null) goto L8;
        View r101 = r100.f268586d;
        if (r101 == null) goto L9;
        ((InputMethodManager) r101.getContext().getSystemService("input_method")).hideSoftInputFromWindow(r101.getWindowToken(), 0);
        return;
    L9:
        return;
    }

    public NavigationScene() {
        this.f268752q = true;
        this.f268757v = new ka7.a();
        this.f268758w = new ArrayList();
        this.f268759x = new LruCache(3);
        this.f268760y = new ArrayList();
        this.f268761z = new ArrayList();
        this.A = new c(this);
    }

    @Override // com.bytedance.scene.Scene
    public final void M() {
        super.M();
        m0(State.RESUMED);
    }

    @Override // com.bytedance.scene.Scene
    public final void O() {
        super.O();
        m0(State.STARTED);
    }

    @Override // com.bytedance.scene.Scene
    public final void onStop() {
        super.onStop();
        this.f268754s.c();
    }

    public final boolean p0() {
        qa7.f.a();
        if (qa7.g.c(getActivity()) == true) goto L5;
        return false;
    L5:
        e r100 = this.f268754s;
        r100.getClass();
        ArrayList r101 = new ArrayList(r100.f268784h);
        int r102 = r101.size() - 1;
    L6:
        if (r102 < 0) goto L13;
        qa7.e r103 = (qa7.e) ListProtector.get(r101, r102);
        if (((LifecycleOwner) r103.f532273a).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L12;
        if (((j) r103.f532274b).onBackPressed() == false) goto L12;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L17;
        return true;
    L17:
        if (((ArrayList) this.f268754s.f268778b.f268820a).size() <= 1) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L23;
        q0();
        return true;
    L23:
        return false;
    L19:
        r105 = false;
    L12:
        r102 = r102 - 1;
        goto L6
    L13:
        r104 = false;
        goto L14
    }

    public final void q0() {
        qa7.f.a();
        if (qa7.g.c(getActivity()) == true) goto L5;
        return;
    L5:
        n0();
        e r100 = this.f268754s;
        r100.getClass();
        r100.i(new e.g(r100));
    }

    @Override // com.bytedance.scene.m
    public final boolean c() {
        return this.f268752q;
    }

    @Override // com.bytedance.scene.Scene
    public final void T(Bundle r110) {
        super.T(r110);
        if (r110 != null) goto L5;
    L14:
        i r111 = this.f268753r;
        Scene r112 = SceneInstanceUtility.c(h0(), r111.f268815a, r111.f268816b);
        e r100 = this.f268754s;
        na7.e r101 = new na7.e(null, null);
        r100.getClass();
        if (r112 == null) goto L22;
        r100.i(new e.i(r100, r112, r101));
    L17:
        NavigationScene r113 = d.a(this);
        if (r113 == null) goto L25;
        r113.l0(this, new b(this));
        return;
    L25:
        return;
    L22:
        throw new NullPointerException("scene can't be null");
    L5:
        if (this.f268752q == false) goto L14;
        e r102 = this.f268754s;
        Activity r103 = h0();
        k r104 = r102.f268778b;
        r104.getClass();
        r104.f268820a = new ArrayList(r110.getParcelableArrayList("bd-scene-nav:record_stack"));
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r106 >= ((ArrayList) r104.f268820a).size()) goto L10;
        Record r107 = (Record) ListProtector.get(r104.f268820a, r106);
        r107.f268768a = SceneInstanceUtility.c(r103, r107.f268774g, null);
        r106 = r106 + 1;
        goto L8
    L10:
        ArrayList r114 = r110.getParcelableArrayList("bd-scene-nav:navigation_scene_manager");
        List<Record> r108 = r102.f268778b.b();
    L12:
        if (r105 > (((ArrayList) r108).size() - 1)) goto L17;
        Record r109 = (Record) ListProtector.get(r108, r105);
        e.g(r102.f268777a, r109.f268768a, State.ACTIVITY_CREATED, (Bundle) ListProtector.get(r114, r105), false, null);
        r105 = r105 + 1;
        goto L12
    }

    @Override // com.bytedance.scene.Scene
    public final void W(Bundle r100) {
        this.f268595m = true;
        this.f268754s = new e(this);
        Bundle r101 = this.f268592j;
        if (r101 == null) goto L15;
        String r102 = r101.getString("extra_rootScene");
        if (r102 == null) goto L13;
        i r103 = new i(r102, r101.getBundle("extra_rootScene_arguments"));
        r103.f268817c = r101.getBoolean("extra_drawWindowBackground");
        r103.f268818d = r101.getBoolean("extra_fixSceneBackground_enabled");
        r103.f268819e = r101.getInt("extra_sceneBackground");
        this.f268753r = r103;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.getBoolean("bd-scene-navigation:support_restore", this.f268752q) == true) goto L17;
        this.f268752q = false;
        return;
    L17:
        return;
    L13:
        throw new IllegalStateException("root scene class name cant be null");
    L15:
        throw new IllegalArgumentException("NavigationScene need NavigationSceneOptions bundle");
    }

    @Override // com.bytedance.scene.p
    public final String b(String r100) {
        return this.f268754s.a(r100);
    }

    @Override // com.bytedance.scene.p
    public final void e(String r100) {
        this.f268754s.d(r100);
    }

    @Override // com.bytedance.scene.Scene
    public final void f0(Bundle r100) {
        super.f0(r100);
        if (r100.containsKey("bd-scene-navigation:support_restore") == true) goto L22;
        r100.putBoolean("bd-scene-navigation:support_restore", this.f268752q);
        if (this.f268752q == false) goto L31;
        e r101 = this.f268754s;
        k r102 = r101.f268778b;
        r102.getClass();
        ArrayList r103 = new ArrayList(r102.f268820a);
        ArrayList<? extends Parcelable> r104 = new ArrayList(r103.size());
        int r105 = 0;
    L8:
        if (r105 > (r103.size() - 1)) goto L13;
        Record r106 = (Record) ListProtector.get(r103, r105);
        if (r106.f268768a.f268593k == false) goto L12;
        r104.add(r106);
    L12:
        r105 = r105 + 1;
        goto L8
    L13:
        r100.putParcelableArrayList("bd-scene-nav:record_stack", r104);
        ArrayList<? extends Parcelable> r107 = new ArrayList();
        Iterator r108 = ((ArrayList) r101.f268778b.b()).iterator();
    L15:
        if (r108.hasNext() == false) goto L19;
        Scene r109 = ((Record) r108.next()).f268768a;
        if (r109.f268593k == false) goto L15;
        Bundle r110 = new Bundle();
        r109.N(r110);
        r107.add(r110);
        goto L15
    L19:
        r100.putParcelableArrayList("bd-scene-nav:navigation_scene_manager", r107);
        return;
    L31:
        return;
    L22:
        throw new IllegalArgumentException("outState already contains key bd-scene-navigation:support_restore");
    }

    @Override // com.bytedance.scene.Scene
    public final void g(Bundle r100) {
        super.g(r100);
        e r101 = this.f268754s;
        if (r101.f268781e.size() != 0) goto L5;
        return;
    L5:
        if (r101.b() == true) goto L8;
        return;
    L8:
        if ((System.currentTimeMillis() - r101.f268782f) <= 800) goto L10;
        boolean r102 = true;
    L11:
        ArrayList r103 = new ArrayList(r101.f268781e);
        int r104 = 0;
    L13:
        if (r104 >= r103.size()) goto L19;
        e.InterfaceC3756e r105 = (e.InterfaceC3756e) ListProtector.get(r103, r104);
        if (r104 >= (r103.size() - 1)) goto L17;
        boolean r106 = true;
    L18:
        r101.f268788l = r106 | r102;
        String r107 = r101.a("NavigationManager executePendingOperation");
        e.b r108 = e.f268776m;
        r101.e(r105);
        r101.d(r107);
        r101.f268788l = false;
        r104 = r104 + 1;
        goto L13
    L17:
        r106 = false;
        goto L18
    L19:
        r101.f268781e.removeAll(r103);
        if (r101.f268781e.size() > 0) goto L23;
        r101.f268782f = -1;
        return;
    L23:
        throw new IllegalStateException("why mPendingActionList still have item?");
    L10:
        r102 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void i(Scene r100) {
        super.i(r100);
        if (r100 != 0) goto L6;
        return;
    L6:
        if ((r100 instanceof m) == false) goto L12;
        if (((m) r100).c() == true) goto L13;
        this.f268752q = false;
        return;
    L13:
        return;
    L12:
        throw new SceneInternalException("unknown parent Scene type " + r100.getClass());
    }

    public final void m0(State r100) {
        if (this.f268590h.value < State.VIEW_CREATED.value) goto L7;
        e r101 = this.f268754s;
        String r102 = r101.a("NavigationManager dispatchCurrentChildState");
        e.k r103 = new e.k(r101, r100);
        e.b r104 = e.f268776m;
        r101.e(r103);
        r101.d(r102);
        return;
    L7:
        throw new IllegalArgumentException("dispatchCurrentChildState can only call when state is VIEW_CREATED, ACTIVITY_CREATED, STARTED, RESUMED");
    }

    public final boolean o0(la7.d r100) {
        e r101 = this.f268754s;
        if (((ArrayList) r101.f268778b.f268820a).size() <= 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        return false;
    L9:
        if (r101.f268778b.a().f268769b == true) goto L20;
        r101.f();
        k r103 = r101.f268778b;
        if (((ArrayList) r103.f268820a).size() >= 2) goto L14;
        Record r104 = null;
    L15:
        if (r104 == null) goto L21;
        r100.getClass();
        return true;
    L21:
        return false;
    L14:
        ArrayList r105 = (ArrayList) r103.f268820a;
        r104 = (Record) ListProtector.get(r105, r105.size() - 2);
        goto L15
    L20:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public final boolean r0(la7.d r110) {
        qa7.f.a();
        r110.f508219i = this.A;
        e r100 = this.f268754s;
        r100.getClass();
        CancellationSignal r101 = la7.d.f508210k;
        if (r101 == null) goto L6;
        r101.cancel();
        la7.d.f508210k = null;
    L6:
        if (r100.f268778b.a().f268769b == true) goto L25;
        Scene r102 = r100.f();
        k r103 = r100.f268778b;
        if (((ArrayList) r103.f268820a).size() >= 2) goto L10;
        Record r104 = null;
    L11:
        boolean r105 = false;
        if (r104 == null) goto L21;
        Scene r106 = r104.f268768a;
        NavigationScene r107 = r100.f268777a;
        r110.f508213c = true;
        r110.f508211a = r107;
        r110.f508215e = r102;
        r110.f508216f = r106;
        SwipeBackGroupScene.a r108 = (SwipeBackGroupScene.a) r110;
        ArrayList r109 = new ArrayList();
        ma7.c r111 = new ma7.c(r108.f268838l);
        r111.a(2048, 1.0f, -1.0f);
        r109.add(new ma7.b(r111));
        ma7.c r112 = new ma7.c(r108.f268839m);
        r112.a(1, 0.0f, r102.f268586d.getWidth() - 0.0f);
        r109.add(new ma7.b(r112));
        ma7.c r113 = new ma7.c(r106.f268586d);
        float r114 = (-r106.f268586d.getWidth()) / 2;
        r113.a(1, r114, 0.0f - r114);
        r109.add(new ma7.b(r113));
        r110.f508212b = r109;
        if (r110.f508219i == null) goto L17;
        r109.add(new la7.d.a(r110));
    L17:
        r110.f508218h = r110.f508216f.f268586d.getVisibility();
        r110.f508216f.f268586d.setVisibility(0);
        r110.f508217g = r110.f508215e.f268586d.getBackground();
        ViewCompat.setBackground(r110.f508215e.f268586d, null);
        CancellationSignal r115 = new CancellationSignal();
        r110.f508220j = r115;
        r115.setOnCancelListener(new la7.a(r110));
        la7.d.f508210k = r110.f508220j;
        la7.d.b r116 = r110.f508219i;
        if (r116 == null) goto L20;
        r116.onStart();
    L20:
        r105 = true;
    L21:
        if (r105 == true) goto L23;
        r110.f508219i = null;
    L23:
        return r105;
    L10:
        ArrayList r117 = (ArrayList) r103.f268820a;
        r104 = (Record) ListProtector.get(r117, r117.size() - 2);
        goto L11
    L25:
        throw new IllegalArgumentException("InteractionNavigationPopAnimationFactory can't support translucent Scene");
    }

    public void startActivity(Intent r100) {
        Activity r101 = getActivity();
        if (qa7.g.c(r101) == true) goto L5;
        return;
    L5:
        r101.startActivity(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void C(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).p();
    L11:
        super.C(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void D(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).i();
    L11:
        super.D(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void E(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).d();
    L11:
        super.E(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void G(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).a();
    L11:
        super.G(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void H(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).q();
    L11:
        super.H(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void K(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).e();
    L11:
        super.K(r100, r101);
    }

    public final void l0(LifecycleOwner r100, j r101) {
        qa7.f.a();
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        List<qa7.e<LifecycleOwner, j>> r102 = this.f268754s.f268784h;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new qa7.e(r100, r101));
        r100.getLifecycle().addObserver(new a(this, r100, r101));
    }

    public final void s0(Scene r100, na7.e r101) {
        qa7.f.a();
        if (qa7.g.c(getActivity()) == true) goto L5;
        return;
    L5:
        Scene r102 = r100.f268587e;
        if (r102 == null) goto L13;
        if (r102 != this) goto L11;
        throw new IllegalArgumentException("Scene is already pushed");
    L11:
        throw new IllegalArgumentException("Scene already has a parent, parent " + r100.f268587e);
    L13:
        if (this.f268752q == true) goto L15;
    L21:
        if (r101 != null) goto L23;
        r101 = new na7.e(null, null);
    L23:
        n0();
        e r103 = this.f268754s;
        r103.getClass();
        r103.i(new e.i(r103, r100, r101));
        return;
    L15:
        if (r100.f268593k == false) goto L21;
        if (SceneInstanceUtility.d(r100) == true) goto L21;
        throw new IllegalArgumentException("Scene " + r100.getClass().getName() + " must be a public class or public static class, and have only one parameterless constructor to be properly recreated from instance state.");
    }

    public void setResult(Scene r100, Object r101) {
        this.f268754s.setResult(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void t(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).g();
    L11:
        super.t(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void u(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).f();
    L11:
        super.u(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void v(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).j();
    L11:
        super.v(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void w(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).b();
    L11:
        super.w(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void x(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).r();
    L11:
        super.x(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void z(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).o();
    L11:
        super.z(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void A(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).k();
    L11:
        super.A(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void B(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).s();
    L11:
        super.B(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void F(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).l();
    L11:
        super.F(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void J(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).c();
    L11:
        super.J(r100, r101, r102);
    }

    @Override // com.bytedance.scene.Scene
    public final View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        NavigationFrameLayout r103 = new NavigationFrameLayout(j0());
        r103.setOnApplyWindowInsetsListener(new qa7.d());
        r103.setId(R.id.navigation_scene_content);
        FrameLayout r104 = new FrameLayout(j0());
        this.f268755t = r104;
        r104.setOnApplyWindowInsetsListener(new qa7.d());
        r103.addView(this.f268755t, new FrameLayout.LayoutParams(-1, -1));
        AnimationContainerLayout r105 = new AnimationContainerLayout(j0());
        r105.setOnApplyWindowInsetsListener(new qa7.d());
        this.f268756u = r105;
        r103.addView(r105, new FrameLayout.LayoutParams(-1, -1));
        if (this.f268753r.f268817c == false) goto L5;
        ViewCompat.setBackground(r103, qa7.g.b(j0()));
    L5:
        return r103;
    }

    @Override // com.bytedance.scene.navigation.c
    public final void f(Scene r100, Scene r101, boolean r102) {
        Iterator r103 = new ArrayList(this.f268760y).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((com.bytedance.scene.navigation.c) r103.next()).f(r100, r101, r102);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void r(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).h();
    L11:
        super.r(r100, r101, r102);
    }

    public void requestPermissions(String[] r100, int r101, na7.c r102) {
        Activity r103 = getActivity();
        if (qa7.g.c(r103) == true) goto L5;
        return;
    L5:
        com.bytedance.scene.a.requestPermissions(r103, this, r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void s(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).m();
    L11:
        super.s(r100, r101, r102);
    }

    public void startActivityForResult(Intent r100, int r101, na7.a r102) {
        Activity r103 = getActivity();
        if (qa7.g.c(r103) == true) goto L5;
        return;
    L5:
        com.bytedance.scene.a.startActivityForResult(r103, this, r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void y(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268761z).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).n();
    L11:
        super.y(r100, r101, r102);
    }
}
