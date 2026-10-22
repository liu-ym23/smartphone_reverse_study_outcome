package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import yu7.a;
import yu7.b;

/* JADX INFO: loaded from: classes23.dex */
public class LifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f274475a;

    public LifecycleCallback(b r100) {
        this.f274475a = r100;
    }

    public void a() {
    }

    public Activity getActivity() {
        Activity r100 = this.f274475a.ng();
        Preconditions.checkNotNull(r100);
        return r100;
    }

    private static b getChimeraLifecycleFragmentImpl(a r100) {
        throw new IllegalStateException("Method not available in SDK.");
    }
}
