package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import com.google.android.gms.internal.common.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import yu7.b;
import yu7.d;

/* JADX INFO: loaded from: classes23.dex */
public final class zzd extends Fragment implements b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final WeakHashMap f274480g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f274481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f274482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f274483f;

    static {
        f274480g = new WeakHashMap();
    }

    public zzd() {
        this.f274481d = Collections.synchronizedMap(new ArrayMap());
        this.f274482e = 0;
    }

    @Override // yu7.b
    public final /* synthetic */ Activity ng() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f274482e = 5;
        Iterator r100 = this.f274481d.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f274482e = 3;
        Iterator r100 = this.f274481d.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f274482e = 2;
        Iterator r100 = this.f274481d.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f274482e = 4;
        Iterator r100 = this.f274481d.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).a();
        goto L4
    }

    @Override // yu7.b
    public final void NB(LifecycleCallback r100) {
        if (this.f274481d.containsKey("TaskOnStopCallback") == true) goto L9;
        this.f274481d.put("TaskOnStopCallback", r100);
        if (this.f274482e <= 0) goto L10;
        new l(Looper.getMainLooper()).post(new d(this, r100));
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("LifecycleCallback with tag TaskOnStopCallback already added to this fragment.");
    }

    @Override // yu7.b
    public final LifecycleCallback hY(Class r100) {
        return (LifecycleCallback) r100.cast(this.f274481d.get("TaskOnStopCallback"));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f274482e = 1;
        this.f274483f = r100;
        Iterator r101 = this.f274481d.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        LifecycleCallback r103 = (LifecycleCallback) r102.getValue();
        if (r100 == null) goto L8;
        r100.getBundle((String) r102.getKey());
    L8:
        r103.getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        if (r100 == null) goto L9;
        Iterator r101 = this.f274481d.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Map.Entry r102 = (Map.Entry) r101.next();
        Bundle r103 = new Bundle();
        ((LifecycleCallback) r102.getValue()).getClass();
        r100.putBundle((String) r102.getKey(), r103);
        goto L7
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Iterator r103 = this.f274481d.values().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((LifecycleCallback) r103.next()).getClass();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        super.dump(r100, r101, r102, r103);
        Iterator r104 = this.f274481d.values().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((LifecycleCallback) r104.next()).getClass();
        goto L4
    }
}
