package com.bytedance.ies.sve_core;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/sve_core/EffectReportFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sve-core_release"}, k = 1, mv = {1, 4, 0})
public final class EffectReportFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f248667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<u<?>> f248668e;

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        S90(j.a.f248686a);
        super.onDestroy();
        ((ArrayList) this.f248667d).clear();
        Iterator<T> r100 = this.f248668e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        u<?> r101 = (u) r100.next();
        d.c(this).removeState(r101);
        goto L4
    }

    public EffectReportFragment() {
        this.f248667d = new ArrayList();
        this.f248668e = new ArrayList();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        S90(j.b.f248687a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        S90(j.c.f248688a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        S90(j.d.f248689a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        S90(j.e.f248690a);
    }

    public final void S90(i r100) {
        Iterator<T> r101 = this.f248667d.iterator();
    L4:
        if (r101.hasNext() == false) goto L21;
        b r102 = (b) r101.next();
        if ((r100 instanceof j.d) == true) goto L7;
        if ((r100 instanceof j.c) == true) goto L10;
        if ((r100 instanceof j.b) == true) goto L13;
        if ((r100 instanceof j.e) == true) goto L16;
        if ((r100 instanceof j.a) == true) goto L19;
        r102.f248683a.a(r102.f248684b.invoke(r100));
        goto L4
    L19:
        r102.f248683a.getClass();
        goto L4
    L16:
        r102.f248683a.getClass();
        goto L4
    L13:
        r102.f248683a.getClass();
        goto L4
    L10:
        r102.f248683a.getClass();
        goto L4
    L7:
        r102.f248683a.getClass();
        goto L4
    }
}
