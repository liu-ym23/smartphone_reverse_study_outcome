package com.bytedance.ee.bear.facade.common.extension;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iu5.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sa5.e;
import ta5.h;
import ta5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ActivityTitleBarReporter extends e implements LifecycleObserver {
    public d a;
    public final AppCompatActivity b;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ActivityTitleBarReporter a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            View r0 = this.a.b.getWindow().getDecorView();
            if (c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r1 = ThreadMethodProxy.currentThread();
            if (r1 == c.a) goto L7;
            c.a(r1, "getDecorView");
        L7:
            final BaseTitleBar r2 = r0.findViewWithTag("BaseTitleBar");
            if (r2 == null) goto L14;
            r0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (r2.getLeftExtraClickListener() != null) goto L12;
            r2.setLeftExtraClickListener(new h(this, r2));
        L12:
            f.a(new i(this, r2));
            return;
        }

        public a(ActivityTitleBarReporter r1) {
            this.a = r1;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        View r0 = this.b.getWindow().getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == c.a) goto L7;
        c.a(r1, "getDecorView");
    L7:
        r0.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public ActivityTitleBarReporter(AppCompatActivity r1) {
        this.b = r1;
        r1.getLifecycle().addObserver(this);
    }

    public static Map k(Object r3) {
        HashMap r0 = new HashMap();
        if ((r3 instanceof Map) == false) goto L5;
        Map r4 = (Map) r3;
    L6:
        if (r4 == null) goto L15;
        Iterator r5 = r4.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r5.next();
        if ((r1.getKey() instanceof String) == false) goto L9;
        if ((r1.getValue() instanceof String) == false) goto L9;
        r0.put((String) r1.getKey(), (String) r1.getValue());
    L15:
        return r0;
    L5:
        r4 = null;
        goto L6
    }
}
