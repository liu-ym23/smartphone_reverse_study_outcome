package com.bytedance.jedi.ext.adapter.internal;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;

/* JADX INFO: loaded from: classes19.dex */
public class JediViewHolderProxy_LifecycleAdapter implements GeneratedAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JediViewHolderProxy f251024a;

    public JediViewHolderProxy_LifecycleAdapter(JediViewHolderProxy r100) {
        this.f251024a = r100;
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
        this.f251024a.onCreate();
        return;
    L12:
        if (r103.approveCall(WidgetCostModule.TYPE_ON_CREATE, 1) == true) goto L13;
        return;
    L16:
        if (r101 != Lifecycle.Event.ON_START) goto L23;
        if (r104 == true) goto L19;
    L20:
        this.f251024a.onStart();
        return;
    L19:
        if (r103.approveCall(WidgetCostModule.TYPE_ON_START, 1) == true) goto L20;
        return;
    L23:
        if (r101 != Lifecycle.Event.ON_STOP) goto L30;
        if (r104 == true) goto L26;
    L27:
        this.f251024a.onStop();
        return;
    L26:
        if (r103.approveCall("onStop", 1) == true) goto L27;
        return;
    L30:
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L39;
        if (r104 == true) goto L33;
    L34:
        this.f251024a.onDestroy();
        return;
    L33:
        if (r103.approveCall(LiveCommonConstants.REASON_ON_DEDTROY, 1) == true) goto L34;
        return;
    L39:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
