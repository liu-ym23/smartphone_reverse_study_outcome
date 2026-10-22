package com.larus.camera.impl.ui.arch;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.component.video.CaptureRecorderComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx8.d;
import tx8.e;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ?\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH\u0016¢\u0006\u0002\u0010\u001cJ?\u0010\u001d\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH\u0016¢\u0006\u0002\u0010\u001cJ?\u0010\u001e\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\"H\u0016J9\u0010#\u001a\u00020\u0012\"\b\b\u0000\u0010$*\u00020\u0016\"\b\b\u0001\u0010\u0013*\u00020\u00142\u0006\u0010%\u001a\u0002H$2\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010&J9\u0010'\u001a\u00020\u0012\"\b\b\u0000\u0010$*\u00020\u0016\"\b\b\u0001\u0010\u0013*\u00020\u00142\u0006\u0010%\u001a\u0002H$2\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010&J \u0010(\u001a\u00020)\"\b\b\u0000\u0010$*\u00020\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0*H\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006-"}, d2 = {"Lcom/larus/camera/impl/ui/arch/CameraContainer;", "Landroid/widget/FrameLayout;", "Lcom/larus/camera/impl/ui/arch/Container;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "group", "Lcom/larus/camera/impl/ui/arch/ComponentGroup;", "getGroup", "()Lcom/larus/camera/impl/ui/arch/ComponentGroup;", "group$delegate", "Lkotlin/Lazy;", "initComponents", "", "VM", "Landroidx/lifecycle/ViewModel;", "C", "Lcom/larus/camera/impl/ui/arch/Component;", "viewModel", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "components", "", "(Landroidx/lifecycle/ViewModel;Landroidx/lifecycle/LifecycleOwner;Ljava/util/List;)V", "replaceComponents", "replaceComponentsByDiff", "newComponents", "releaseComponents", "asView", "Landroid/view/ViewGroup;", "addComponent", ExifInterface.GPS_DIRECTION_TRUE, "component", "(Lcom/larus/camera/impl/ui/arch/Component;Landroidx/lifecycle/ViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "addComponentIfNotExists", "removeComponent", "", "Ljava/lang/Class;", "Companion", "LayoutParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraContainer extends FrameLayout implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f321792b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f321793a;

    public static final class a {
    }

    public static final class b extends FrameLayout.LayoutParams {
        public b(int r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public CameraContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CameraContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // tx8.e
    public final CameraContainer asView() {
        return this;
    }

    private final com.larus.camera.impl.ui.arch.a getGroup() {
        return (com.larus.camera.impl.ui.arch.a) this.f321793a.getValue();
    }

    public final void c() {
        Iterator<T> r100 = getGroup().c().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).c(this);
        goto L4
    L6:
        getGroup().a();
    }

    public final void d(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        FLogger.f375446a.i("CameraContainer" + hashCode(), "removeComponent " + getGroup().c());
        Iterator<T> r101 = getGroup().c().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((d) r102).getClass(), r100) == false) goto L4;
    L9:
        d r103 = (d) r102;
        if (r103 == null) goto L16;
        r103.c(this);
        List<? extends d> r104 = CollectionsKt.toMutableList(getGroup().c());
        r104.remove(r103);
        getGroup().b(r104);
        return;
    L16:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static final void f(d r100, List<d> r101) {
        if (r101.isEmpty() == true) goto L11;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        d r103 = (d) r102.next();
        if (Intrinsics.areEqual(r100.getClass(), r103.getClass()) == false) goto L7;
        boolean r104 = false;
    L12:
        if (r104 == false) goto L18;
        ((ArrayList) r101).add(r100);
        return;
    L18:
        return;
    L11:
        r104 = true;
        goto L12
    }

    public CameraContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f321793a = LazyKt.lazy(new tx8.a());
    }

    public final void a(CaptureRecorderComponent r100, CameraCaptureViewModel r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "component");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        FLogger.f375446a.i("CameraContainer" + hashCode(), "addComponentIfNotExists " + getGroup().c());
        Iterator<T> r103 = getGroup().c().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((d) r104).getClass(), CaptureRecorderComponent.class) == false) goto L4;
    L10:
        if (((d) r104) != null) goto L16;
        r100.b(r101, this, r102);
        List<? extends d> r105 = CollectionsKt.toMutableList(getGroup().c());
        r105.add(r100);
        getGroup().b(r105);
        return;
    L16:
        return;
    L8:
        r104 = null;
        goto L10
    }

    public final void b(BaseCameraViewModel r100, LifecycleOwner r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "components");
        getGroup().a();
        Iterator r103 = CollectionsKt.asReversed(getGroup().b(r102)).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((d) r103.next()).b(r100, this, r101);
        goto L4
    }

    public final void e(CameraResultViewModel r110, LifecycleOwner r111, List r112) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        Intrinsics.checkNotNullParameter(r111, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r112, "newComponents");
        List<d> r100 = getGroup().c();
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        final List r103 = CollectionsKt.toMutableList(r100);
        List<d> r104 = r100;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        r105.add(((d) r106.next()).getClass());
        goto L4
    L6:
        Set r107 = CollectionsKt.toSet(r105);
        Iterator r113 = r112.iterator();
    L8:
        if (r113.hasNext() == false) goto L23;
        final d r108 = (d) r113.next();
        if (r107.contains(r108.getClass()) == true) goto L11;
        f(r108, r102);
        goto L8
    L11:
        Iterator<T> r109 = r104.iterator();
    L13:
        if (r109.hasNext() == false) goto L17;
        Object r114 = r109.next();
        if (Intrinsics.areEqual(r108.getClass(), ((d) r114).getClass()) == false) goto L13;
    L18:
        d r115 = (d) r114;
        if (r115 == null) goto L21;
        f(r115, r101);
    L21:
        CollectionsKt.removeAll(r103, new tx8.b(r108));
        goto L8
    L17:
        r114 = null;
        goto L18
    L23:
        getGroup().a();
        Iterator r116 = CollectionsKt.asReversed(getGroup().b(CollectionsKt.plus(r101, r102))).iterator();
    L25:
        if (r116.hasNext() == false) goto L32;
        d r117 = (d) r116.next();
        if (r101.contains(r117) == true) goto L28;
        if (r102.contains(r117) == false) goto L25;
        r117.b(r110, this, r111);
        goto L25
    L28:
        r117.a(this);
        goto L25
    L32:
        FLogger.f375446a.i("CameraContainer", "[replaceComponentsByDiff] componentsToKeep:" + r101 + ", componentsToAdd:" + r102 + ", componentsToRemove:" + r103);
        postDelayed(new tx8.c(r103, this), 100);
    }

    public /* synthetic */ CameraContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
