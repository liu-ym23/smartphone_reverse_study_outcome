package com.larus.ui.arch.component.external.delegate;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1a.e;
import t1a.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u0000 %*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0002%&B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0004J\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\tH\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\tH\u0000¢\u0006\u0002\b#J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0002R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/larus/ui/arch/component/external/delegate/BaseComponentWidget;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/ui/arch/context/external/VWidgetData;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentWidget;", "<init>", "()V", "onContainerViewSetListener", "Ljava/util/ArrayList;", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentWidget$OnContainerViewSetListener;", "Lkotlin/collections/ArrayList;", "isOnCreateViewCalled", "", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", WidgetCostModule.TYPE_ON_CREATE, "", "handleOnCreateView", "onViewCreated", "view", "handleOnViewCreated", "attachable", "Lcom/larus/ui/arch/component/internal/attach/Attachable;", "handleOnParentViewCreated", "handleOnParentViewCreated$component_release", "isContainerViewAssigned", "isContainerViewAssigned$component_release", "addContainerViewSetListener", "listener", "addContainerViewSetListener$component_release", "removeContainerViewSetListener", "removeContainerViewSetListener$component_release", "onContainerViewSet", "Companion", "OnContainerViewSetListener", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseComponentWidget<T extends f> extends ComponentFeature implements e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<b> f375152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f375153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f375154j;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes31.dex */
    public interface b {
        void a(View r100);
    }

    static {
    }

    public void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public final View F2() {
        View r100 = this.f375154j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
        return null;
    }

    public final void L2() {
        if (this.f375153i == false) goto L5;
        return;
    L5:
        this.f375153i = true;
        S1();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public void onCreate() {
        ComponentStateController r100 = this.f375151e;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("stateController");
        r100 = null;
    L7:
        if (r100.f375169e == null) goto L10;
        L2();
        return;
    }

    public BaseComponentWidget() {
        this.f375152h = new ArrayList();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void v2(Attachable r100) {
        Intrinsics.checkNotNullParameter(r100, "attachable");
        B2();
        L2();
    }

    public final void N2(View r100, Attachable r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "attachable");
        Iterator<b> r102 = this.f375152h.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r100);
        goto L4
    L6:
        onViewCreated(r100);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r101, "attachable");
        ComponentStateController r103 = r101.getComponentStateController$component_release(this);
        if (r103 == null) goto L23;
        List<ComponentFeature> r104 = r103.f375168d;
        if (r104 == null) goto L31;
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((ArrayList) r104).iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        if (((ComponentFeature) r107).getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L12;
        r105.add(r107);
        goto L12
    L16:
        r108 = false;
        goto L17
    L19:
        Iterator r109 = r105.iterator();
    L21:
        if (r109.hasNext() == false) goto L32;
        ((ComponentFeature) r109.next()).v2(r101);
        goto L21
    L32:
        return;
    L31:
        return;
    }
}
