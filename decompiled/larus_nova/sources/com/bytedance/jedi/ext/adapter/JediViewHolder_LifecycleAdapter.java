package com.bytedance.jedi.ext.adapter;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

/* JADX INFO: loaded from: classes19.dex */
public class JediViewHolder_LifecycleAdapter implements GeneratedAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JediViewHolder f250963a;

    public JediViewHolder_LifecycleAdapter(JediViewHolder r100) {
        this.f250963a = r100;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public final void callMethods(LifecycleOwner r100, Lifecycle.Event r101, boolean r102, MethodCallsLogger r103) {
        if (r103 == null) goto L5;
        boolean r104 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        if (r101 != Lifecycle.Event.ON_CREATE) goto L16;
        if (r104 == true) goto L12;
    L13:
        this.f250963a.create$ext_adapter_release();
        return;
    L12:
        if (r103.approveCall("create$ext_adapter_release", 1) == true) goto L13;
        return;
    L16:
        if (r101 != Lifecycle.Event.ON_START) goto L23;
        if (r104 == true) goto L19;
    L20:
        this.f250963a.start$ext_adapter_release();
        return;
    L19:
        if (r103.approveCall("start$ext_adapter_release", 1) == true) goto L20;
        return;
    L23:
        if (r101 != Lifecycle.Event.ON_RESUME) goto L30;
        if (r104 == true) goto L26;
    L27:
        this.f250963a.resume$ext_adapter_release();
        return;
    L26:
        if (r103.approveCall("resume$ext_adapter_release", 1) == true) goto L27;
        return;
    L30:
        if (r101 != Lifecycle.Event.ON_PAUSE) goto L37;
        if (r104 == true) goto L33;
    L34:
        this.f250963a.pause$ext_adapter_release();
        return;
    L33:
        if (r103.approveCall("pause$ext_adapter_release", 1) == true) goto L34;
        return;
    L37:
        if (r101 != Lifecycle.Event.ON_STOP) goto L44;
        if (r104 == true) goto L40;
    L41:
        this.f250963a.stop$ext_adapter_release();
        return;
    L40:
        if (r103.approveCall("stop$ext_adapter_release", 1) == true) goto L41;
        return;
    L44:
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L55;
        if (r104 == true) goto L47;
    L48:
        this.f250963a.destroy$ext_adapter_release();
        return;
    L47:
        if (r103.approveCall("destroy$ext_adapter_release", 1) == true) goto L48;
        return;
    L55:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
