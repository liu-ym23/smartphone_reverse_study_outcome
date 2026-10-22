package com.bytedance.jedi.ext.adapter.internal;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public final class JediViewHolderProxyManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f251015e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f251016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f251017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<Object> f251018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lifecycle f251019d;

    public static final class a {
        public a() {
        }
    }

    static {
        f251015e = new a();
    }

    public final void a(JediViewHolderProxy r100) {
        this.f251019d.removeObserver(r100);
        Lifecycle.State r101 = this.f251019d.getCurrentState();
        int r102 = c.f251031a[r101.ordinal()];
        if (r102 == 2) goto L15;
        if (r102 != 3) goto L7;
        r100.onDestroy();
    L17:
        this.f251018c.remove(r100);
        return;
    L7:
        if (r102 != 4) goto L9;
        r100.onStop();
        r100.onDestroy();
        goto L17
    L9:
        if (r102 != 5) goto L17;
        r100.onStop();
        r100.onDestroy();
        goto L17
    L15:
        if (r100.f251006e == true) goto L17;
        r100.onDestroy();
        goto L17
    }

    public JediViewHolderProxyManager(Lifecycle r100, JediViewHolderProxyHost r101) {
        this.f251019d = r100;
        Function0<Unit> r102 = new AnonymousClass1(this);
        r101.f251013f.add(r102);
        this.f251018c = new CopyOnWriteArraySet();
    }
}
