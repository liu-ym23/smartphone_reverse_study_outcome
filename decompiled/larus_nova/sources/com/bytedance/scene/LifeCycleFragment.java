package com.bytedance.scene;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.scene.exceptions.OnSaveInstanceStateMethodMissingException;

/* JADX INFO: loaded from: classes19.dex */
public class LifeCycleFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f268581a;

    public LifeCycleFragment() {
        this.f268581a = null;
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        i r100 = this.f268581a;
        if (r100 == null) goto L13;
        SceneLifecycleManager<T> r101 = ((l) r100).f268739f;
        SceneLifecycleManager.SceneLifecycleManagerState r102 = r101.f268614b;
        if (r102 != SceneLifecycleManager.SceneLifecycleManagerState.STOP) goto L7;
    L11:
        r101.f268614b = SceneLifecycleManager.SceneLifecycleManagerState.NONE;
        r101.f268613a.m();
        r101.f268613a.l();
        r101.f268613a.p();
        r101.f268613a.h0();
        r101.f268613a.o();
        r101.f268613a.f268588f = null;
        r101.f268613a = null;
        return;
    L7:
        if (r102 == SceneLifecycleManager.SceneLifecycleManagerState.ACTIVITY_CREATED) goto L11;
        throw new IllegalStateException("invoke onStop() or onActivityCreated() first, current state " + r101.f268614b.toString());
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        i r100 = this.f268581a;
        if (r100 == null) goto L9;
        SceneLifecycleManager<T> r101 = ((l) r100).f268739f;
        if (r101.f268614b != SceneLifecycleManager.SceneLifecycleManagerState.RESUME) goto L8;
        r101.f268614b = SceneLifecycleManager.SceneLifecycleManagerState.PAUSE;
        r101.f268613a.L();
        return;
    L8:
        throw new IllegalStateException("invoke onResume() first, current state " + r101.f268614b.toString());
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        i r100 = this.f268581a;
        if (r100 == null) goto L13;
        SceneLifecycleManager<T> r101 = ((l) r100).f268739f;
        SceneLifecycleManager.SceneLifecycleManagerState r102 = r101.f268614b;
        if (r102 != SceneLifecycleManager.SceneLifecycleManagerState.START) goto L7;
    L11:
        r101.f268614b = SceneLifecycleManager.SceneLifecycleManagerState.RESUME;
        r101.f268613a.M();
        return;
    L7:
        if (r102 == SceneLifecycleManager.SceneLifecycleManagerState.PAUSE) goto L11;
        throw new IllegalStateException("invoke onStart() or onPause() first, current state " + r101.f268614b.toString());
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        i r100 = this.f268581a;
        if (r100 == null) goto L13;
        SceneLifecycleManager<T> r101 = ((l) r100).f268739f;
        SceneLifecycleManager.SceneLifecycleManagerState r102 = r101.f268614b;
        if (r102 != SceneLifecycleManager.SceneLifecycleManagerState.ACTIVITY_CREATED) goto L7;
    L11:
        r101.f268614b = SceneLifecycleManager.SceneLifecycleManagerState.START;
        r101.f268613a.O();
        return;
    L7:
        if (r102 == SceneLifecycleManager.SceneLifecycleManagerState.STOP) goto L11;
        throw new IllegalStateException("invoke onActivityCreated() or onStop() first, current state " + r101.f268614b.toString());
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        i r100 = this.f268581a;
        if (r100 == null) goto L13;
        SceneLifecycleManager<T> r101 = ((l) r100).f268739f;
        SceneLifecycleManager.SceneLifecycleManagerState r102 = r101.f268614b;
        if (r102 != SceneLifecycleManager.SceneLifecycleManagerState.PAUSE) goto L7;
    L11:
        r101.f268614b = SceneLifecycleManager.SceneLifecycleManagerState.STOP;
        r101.f268613a.P();
        return;
    L7:
        if (r102 == SceneLifecycleManager.SceneLifecycleManagerState.START) goto L11;
        throw new IllegalStateException("invoke onPause() or onStart() first, current state " + r101.f268614b.toString());
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle r110) {
        super.onActivityCreated(r110);
        i r100 = this.f268581a;
        if (r100 == null) goto L43;
        Activity r101 = getActivity();
        l r102 = (l) r100;
        q r103 = r102.f268735b;
        int r104 = r102.f268734a;
        b r105 = (b) r103;
        View r106 = r105.f268638a.findViewById(r104);
        if (r106 == null) goto L45;
        ViewGroup r107 = (ViewGroup) r106;
        SceneLifecycleManager<T> r108 = r102.f268739f;
        T r109 = r102.f268736c;
        n.b r111 = r102.f268737d;
        boolean r112 = r102.f268738e;
        if (r112 == true) goto L11;
        r110 = null;
    L11:
        if (r108.f268614b != SceneLifecycleManager.SceneLifecycleManagerState.NONE) goto L38;
        qa7.g.d(r101, "activity can't be null");
        qa7.g.d(r109, "scene can't be null");
        qa7.g.d(r111, "rootScopeFactory can't be null");
        State r113 = r109.f268590h;
        State r114 = State.NONE;
        if (r113 != r114) goto L36;
        r108.f268615c = r112;
        if (r112 == true) goto L20;
        if (r110 == null) goto L20;
        throw new IllegalArgumentException("savedInstanceState should be null when not support restore");
    L20:
        r108.f268614b = SceneLifecycleManager.SceneLifecycleManagerState.ACTIVITY_CREATED;
        r108.f268613a = r109;
        if (r112 == true) goto L23;
        r109.a();
    L23:
        T r115 = r108.f268613a;
        r115.f268588f = r111;
        r115.h(r101);
        r108.f268613a.i(null);
        if (r110 != null) goto L26;
    L30:
        r108.f268613a.j(r110);
        r108.f268613a.k(r110, r107);
        View r116 = r108.f268613a.f268586d;
        if (r116 == null) goto L34;
        r107.addView(r116, new ViewGroup.LayoutParams(-1, -1));
        r108.f268613a.g(r110);
        return;
    L34:
        throw new IllegalStateException("requireView() should not be called before onCreateView() or after onDestroyView()");
    L26:
        if (r110.getBoolean("SceneLifecycleManager_onSaveInstanceState_TAG") == true) goto L30;
        throw new OnSaveInstanceStateMethodMissingException("savedInstanceState argument is not null, but previous onSaveInstanceState() is missing");
    L36:
        throw new IllegalStateException("Scene state must be " + r114.name);
    L38:
        throw new IllegalStateException("invoke onDestroyView() first, current state " + r108.f268614b.toString());
    L45:
        throw new IllegalArgumentException(" " + r105.f268638a.getResources().getResourceName(r104) + " view not found");     // Catch: Resources.NotFoundException -> L41
    L42:
        throw new IllegalArgumentException(" " + r104 + " view not found");
    L43:
        FragmentManager r117 = getActivity().getFragmentManager();
        qa7.g.a(r117, r117.beginTransaction().remove(this), false);
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setRetainInstance(false);
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        i r101 = this.f268581a;
        if (r101 == null) goto L15;
        l r102 = (l) r101;
        if (r102.f268738e == false) goto L16;
        r100.putString("SCENE", r102.f268736c.getClass().getName());
        SceneLifecycleManager<T> r103 = r102.f268739f;
        r103.getClass();
        if (r103.f268614b == SceneLifecycleManager.SceneLifecycleManagerState.NONE) goto L14;
        if (r103.f268615c == false) goto L12;
        r103.f268613a.N(r100);
        r100.putBoolean("SceneLifecycleManager_onSaveInstanceState_TAG", true);
        return;
    L12:
        throw new IllegalArgumentException("cant invoke onSaveInstanceState when not support restore");
    L14:
        throw new IllegalStateException("invoke onActivityCreated() first, current state " + r103.f268614b.toString());
    L16:
        return;
    }
}
