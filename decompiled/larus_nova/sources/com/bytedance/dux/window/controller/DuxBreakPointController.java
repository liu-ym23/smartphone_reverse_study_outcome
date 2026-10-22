package com.bytedance.dux.window.controller;

import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.dux.window.bean.DuxBreakPointStore;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import hm4.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/dux/window/controller/DuxBreakPointController;", "", "Landroidx/lifecycle/Observer;", "Lhm4/d;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBreakPointController implements Observer<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f205930a = 0;

    public static final class a {
    }

    static {
        new hm4.b(Integer.MAX_VALUE);
    }

    public DuxBreakPointController() {
        new CopyOnWriteArraySet();
    }

    public final void a(Observer<d> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        SystemClock.uptimeMillis();
        if ((r100 instanceof DuxBreakPointStore) == true) goto L5;
        return;
    L5:
        ((DuxBreakPointStore) r100).getClass();
        throw null;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(d r100) {
        d r101 = r100;
        if (r101 == null) goto L19;
        WeakReference<View> r102 = r101.f485937e;
        if (r102 == null) goto L8;
        View r103 = r102.get();
    L9:
        if (r103 == null) goto L20;
        float r104 = r101.f485936d.f485914a;
        CopyOnWriteArraySet r105 = b.a(r103);
        if (r105 == null) goto L18;
        Iterator r106 = r105.iterator();
        if (r106.hasNext() == false) goto L21;
        ((DuxBreakPointStore) r106.next()).getClass();
        throw null;
    L21:
        return;
    L18:
        return;
    L20:
        return;
    L8:
        r103 = null;
        goto L9
    }
}
