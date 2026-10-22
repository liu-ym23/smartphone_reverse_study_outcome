package com.bytedance.ee.bear.facade.common;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sa5.e;
import sa5.m;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class ExtensionActivityImpl implements m, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f226398a;

    public final boolean c() {
        Iterator r100 = ((ArrayList) this.f226398a).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((e) r100.next()).j() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        a.h("DelegateActivityImpl", LiveCommonConstants.REASON_ON_DEDTROY);
        ((ArrayList) this.f226398a).clear();
    }

    @Override // sa5.o
    public final void Xi(e r100) {
        if (((ArrayList) this.f226398a).contains(r100) == true) goto L6;
        ((ArrayList) this.f226398a).add(r100);
        return;
    }

    public final boolean a(KeyEvent r100) {
        Iterator r101 = ((ArrayList) this.f226398a).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((e) r101.next()).g(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean b(MotionEvent r100) {
        Iterator r101 = ((ArrayList) this.f226398a).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((e) r101.next()).h(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final void d(Configuration r100) {
        Iterator r101 = ((ArrayList) this.f226398a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((e) r101.next()).getClass();
        goto L4
    }

    @Override // sa5.o
    public final e vb(Class r100) {
        Iterator r101 = ((ArrayList) this.f226398a).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        e r102 = (e) r101.next();
        if (r100.isAssignableFrom(r102.getClass()) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public ExtensionActivityImpl(AppCompatActivity r100, List<e> r101) {
        ArrayList r102 = new ArrayList();
        this.f226398a = r102;
        r100.getLifecycle().addObserver(this);
        if (r101 == null) goto L6;
        r102.addAll(r101);
        return;
    }
}
