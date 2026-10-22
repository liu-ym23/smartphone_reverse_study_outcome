package com.bytedance.ee.bear.facade.common;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa5.e;
import sa5.f;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/ExtensionFragmentImpl;", "Lcom/bytedance/ee/bear/facade/common/BaseExtensionHostImpl;", "Landroidx/lifecycle/LifecycleObserver;", "fragmentRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "extensions", "", "Lcom/bytedance/ee/bear/facade/common/BaseExtension;", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/util/List;)V", LiveCommonConstants.REASON_ON_DEDTROY, "", "Companion", "base-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionFragmentImpl extends f implements LifecycleObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Fragment> f226399b;

    public static final class a {
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        tt5.a.h("ExtensionFragmentImpl", LiveCommonConstants.REASON_ON_DEDTROY);
        Fragment r100 = this.f226399b.get();
        if (r100 == null) goto L7;
        Lifecycle r101 = r100.getLifecycle();
        if (r101 == null) goto L7;
        r101.removeObserver(this);
    L7:
        ((ArrayList) this.f541167a).clear();
    }

    public ExtensionFragmentImpl(WeakReference<Fragment> r100, List<? extends e> r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentRef");
        this.f226399b = r100;
        Fragment r102 = r100.get();
        if (r102 == null) goto L7;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L7;
        r103.addObserver(this);
    L7:
        if (r101 == null) goto L10;
        ArrayList r104 = (ArrayList) this.f541167a;
        r104.addAll(r101);
        return;
    }
}
