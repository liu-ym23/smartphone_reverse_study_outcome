package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import yu7.b;
import yu7.c;

/* JADX INFO: loaded from: classes23.dex */
public final class zzb extends Fragment implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap f274476d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f274477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f274479c;

    static {
        f274476d = new WeakHashMap();
    }

    public zzb() {
        this.f274477a = Collections.synchronizedMap(new ArrayMap());
        this.f274478b = 0;
    }

    @Override // yu7.b
    public final Activity ng() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f274478b = 5;
        Iterator r100 = this.f274477a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).getClass();
        goto L4
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f274478b = 3;
        Iterator r100 = this.f274477a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).getClass();
        goto L4
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f274478b = 2;
        Iterator r100 = this.f274477a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).getClass();
        goto L4
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f274478b = 4;
        Iterator r100 = this.f274477a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((LifecycleCallback) r100.next()).a();
        goto L4
    }

    @Override // yu7.b
    public final void NB(LifecycleCallback r100) {
        if (this.f274477a.containsKey("TaskOnStopCallback") == true) goto L9;
        this.f274477a.put("TaskOnStopCallback", r100);
        if (this.f274478b <= 0) goto L10;
        new l(Looper.getMainLooper()).post(new c(this, r100));
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("LifecycleCallback with tag TaskOnStopCallback already added to this fragment.");
    }

    @Override // yu7.b
    public final LifecycleCallback hY(Class r100) {
        return (LifecycleCallback) r100.cast(this.f274477a.get("TaskOnStopCallback"));
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f274478b = 1;
        this.f274479c = r100;
        Iterator r101 = this.f274477a.entrySet().iterator();
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

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        if (r100 == null) goto L9;
        Iterator r101 = this.f274477a.entrySet().iterator();
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

    @Override // android.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Iterator r103 = this.f274477a.values().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((LifecycleCallback) r103.next()).getClass();
        goto L4
    }

    @Override // android.app.Fragment
    public final void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        super.dump(r100, r101, r102, r103);
        Iterator r104 = this.f274477a.values().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((LifecycleCallback) r104.next()).getClass();
        goto L4
    }
}
