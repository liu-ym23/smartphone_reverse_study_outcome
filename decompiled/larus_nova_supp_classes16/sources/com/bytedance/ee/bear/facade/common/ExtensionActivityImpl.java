package com.bytedance.ee.bear.facade.common;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sa5.e;
import sa5.m;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ExtensionActivityImpl implements m, LifecycleObserver {
    public final List<e> a;

    public final boolean c() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((e) r0.next()).j() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        a.h("DelegateActivityImpl", "onDestroy");
        ((ArrayList) this.a).clear();
    }

    @Override // sa5.o
    public final void Xi(e r2) {
        if (((ArrayList) this.a).contains(r2) == true) goto L6;
        ((ArrayList) this.a).add(r2);
        return;
    }

    public final boolean a(KeyEvent r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((e) r0.next()).g(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean b(MotionEvent r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((e) r0.next()).h(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final void d(Configuration r2) {
        Iterator r3 = ((ArrayList) this.a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((e) r3.next()).getClass();
        goto L4
    }

    @Override // sa5.o
    public final e vb(Class r4) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        e r1 = (e) r0.next();
        if (r4.isAssignableFrom(r1.getClass()) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public ExtensionActivityImpl(AppCompatActivity r2, List<e> r3) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r2.getLifecycle().addObserver(this);
        if (r3 == null) goto L6;
        r0.addAll(r3);
        return;
    }
}
