package com.bytedance.ee.bear.facade.common;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa5.e;
import sa5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/ExtensionFragmentImpl;", "Lcom/bytedance/ee/bear/facade/common/BaseExtensionHostImpl;", "Landroidx/lifecycle/LifecycleObserver;", "fragmentRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "extensions", "", "Lcom/bytedance/ee/bear/facade/common/BaseExtension;", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/util/List;)V", "onDestroy", "", "Companion", "base-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionFragmentImpl extends f implements LifecycleObserver {
    public final WeakReference<Fragment> b;

    public static final class a {
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        tt5.a.h("ExtensionFragmentImpl", "onDestroy");
        Fragment r0 = this.b.get();
        if (r0 == null) goto L7;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L7;
        r1.removeObserver(this);
    L7:
        ((ArrayList) this.a).clear();
    }

    public ExtensionFragmentImpl(WeakReference<Fragment> r2, List<? extends e> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentRef");
        this.b = r2;
        Fragment r4 = r2.get();
        if (r4 == null) goto L7;
        Lifecycle r5 = r4.getLifecycle();
        if (r5 == null) goto L7;
        r5.addObserver(this);
    L7:
        if (r3 == null) goto L10;
        ArrayList r6 = (ArrayList) this.a;
        r6.addAll(r3);
        return;
    }
}
