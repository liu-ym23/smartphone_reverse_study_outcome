package hs1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<e> f486947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f486948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<Integer, View> f486949c;

    @Override // hs1.e
    public final void onCreate() {
        Iterator<T> r100 = this.f486947a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).onCreate();
        goto L4
    }

    @Override // hs1.e
    public final void onDestroy() {
        Iterator<T> r100 = this.f486947a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).onDestroy();
        goto L4
    L6:
        ((LinkedHashMap) this.f486949c).clear();
    }

    @Override // hs1.e
    public final void onPause() {
        Iterator<T> r100 = this.f486947a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).onPause();
        goto L4
    }

    @Override // hs1.e
    public final void onResume() {
        Iterator<T> r100 = this.f486947a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).onResume();
        goto L4
    }

    @Override // hs1.e
    public final void onStart() {
        Iterator<T> r100 = this.f486947a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).onStart();
        goto L4
    }

    @Override // hs1.e
    public final void onStop() {
        Iterator<T> r100 = this.f486947a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((e) r100.next()).onStop();
        goto L4
    }

    public d() {
        this.f486947a = new ArrayList();
        this.f486949c = new LinkedHashMap();
    }

    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f486947a.add(r100);
    }

    @Override // hs1.e
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Iterator<T> r101 = this.f486947a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((e) r101.next()).c(r100);
        goto L4
    }

    @Override // hs1.e
    public final void b(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Iterator<T> r102 = this.f486947a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((e) r102.next()).b(r100, r101);
        goto L4
    }
}
