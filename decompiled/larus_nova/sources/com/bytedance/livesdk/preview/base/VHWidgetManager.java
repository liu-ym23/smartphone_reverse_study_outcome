package com.bytedance.livesdk.preview.base;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.livesdk.preview.LivePreviewVHMonitor;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/livesdk/preview/base/VHWidgetManager;", "", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/livesdk/preview/merge/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VHWidgetManager extends Fragment implements com.bytedance.livesdk.preview.merge.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f256412l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f256413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f256414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f256415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f256416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f256417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f256418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f256419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f256420k;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ap2.b f256421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f256422b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f256421a, r101.f256421a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f256422b, r101.f256422b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ap2.b r100 = this.f256421a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ViewGroup r104 = this.f256422b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "DynamicWithContianer(widget=" + this.f256421a + ", container=" + this.f256422b + ")";
        }

        public b(ap2.b r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            this.f256421a = r100;
            this.f256422b = r101;
        }
    }

    static {
    }

    public VHWidgetManager() {
        f r100 = new f();
        Intrinsics.checkNotNullParameter(r100, "widgetsCache");
        this.f256420k = r100;
        this.f256413d = LazyKt.lazy(VHWidgetManager$TAG$2.INSTANCE);
        this.f256414e = new ArrayList();
        this.f256416g = LazyKt.lazy(new VHWidgetManager$mVHWidgetPriorityManager$2(this));
        this.f256417h = LazyKt.lazy(VHWidgetManager$mPreviewDialogManager$2.INSTANCE);
        this.f256418i = VHWidgetManager$mJudgeAllViewLoadedWhenAsyncAction$1.INSTANCE;
        this.f256419j = LazyKt.lazy(LazyThreadSafetyMode.NONE, VHWidgetManager$enableWidgetPreload$2.INSTANCE);
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final void ME(AbsMergeWidget r100) {
        if (r100 == null) goto L5;
        Z90(r100);
        return;
    }

    public final void Z90(AbsMergeWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if (r100.getMergeStatus() != PreviewWidgetState.UNLOAD) goto L5;
        return;
    L5:
        Y90(r100, "unload");
        boolean r101 = r100 instanceof VHWidget;
        if (r101 == false) goto L11;
        Iterator r102 = ((Map) ((VHWidget) r100).f256410d.getValue()).values().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        Z90((VHWidget) r102.next());
    L11:
        PreviewWidgetState r103 = r100.getMergeStatus();
        PreviewWidgetState r104 = PreviewWidgetState.UNLOAD;
        if (r103 == r104) goto L45;
        int r105 = e.f256424a;
        String r106 = "unLoad widget " + r100.getMergeTag();
        Intrinsics.checkNotNullParameter(r106, "logString");
        fl6.a.a(4, "PriorityWidget_", r106);
        r100.setMergeStatus(r104);
        getLifecycle().removeObserver(r100);
        int r107 = c.f256423a[getLifecycle().getCurrentState().ordinal()];
        if (r107 == 3) goto L22;
        if (r107 != 4) goto L18;
        r100.onStop();
        r100.onDestroy();
    L23:
        View r108 = r100.contentView;
        ViewGroup r109 = null;
        if (r108 == null) goto L26;
        ViewParent r110 = r108.getParent();
    L28:
        if ((r110 instanceof ViewGroup) == true) goto L30;
        r110 = null;
    L30:
        ViewGroup r111 = (ViewGroup) r110;
        if (r111 != null) goto L33;
    L37:
        f r112 = this.f256420k;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "widget");
        r112.f256425a.remove(r100);
        if ((r100 instanceof PriorityWidget) == false) goto L40;
        r112.f256426b.remove(r100);
    L40:
        if (r101 == false) goto L42;
        ((VHWidget) r100).Jq();
    L42:
        r100.onMergeUnLoad();
        return;
    L33:
        if (Intrinsics.areEqual(r111, r100.containerView) == false) goto L35;
        r109 = r111;
    L35:
        if (r109 == null) goto L37;
        r109.removeView(r100.contentView);
        goto L37
    L26:
        r110 = null;
        goto L28
    L18:
        if (r107 != 5) goto L23;
        r100.onPause();
        r100.onStop();
        r100.onDestroy();
        goto L23
    L22:
        r100.onDestroy();
        goto L23
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final <T extends com.bytedance.android.live.core.tetris.widgets.a> T eW(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClazz");
        return r100.newInstance();
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final void fW(AbsMergeWidget r100) {
        U90(null, r100, false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Iterator<T> r101 = this.f256420k.f256425a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((AbsMergeWidget) r101.next()).onConfigurationChanged(r100);
        goto L4
    }

    public static final boolean S90(VHWidgetManager r100, AbsMergeWidget r101) {
        if (r100.isRemoving() == false) goto L5;
    L15:
        return true;
    L5:
        if (r100.isDetached() == true) goto L15;
        if (r100.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r101 == null) goto L10;
        PreviewWidgetState r102 = r101.getMergeStatus();
    L12:
        if (r102 == PreviewWidgetState.UNLOAD) goto L15;
        return false;
    L10:
        r102 = null;
        goto L12
    }

    public static void Y90(AbsMergeWidget r100, String r101) {
        fl6.a.a(4, "VHWidgetManager", r100.getMergeTag() + ": " + r101);
    }

    public final void V90(VHWidget r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "onViewLoadedFinishedAction");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getMergeStatus() != PreviewWidgetState.UNLOAD) goto L10;
        r100.setMergeStatus(PreviewWidgetState.LOADING);
        Intrinsics.throwUninitializedPropertyAccessException("mVMManager");
        Intrinsics.checkNotNullParameter(null, "<set-?>");
        r100.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("mVHPreviewContext");
        Intrinsics.checkNotNullParameter(null, "<set-?>");
        r100.f256409c = null;
        throw null;
    }

    public final void W90(final VHWidget r100, final Room r101) {
        if (r100.getMergeStatus() != PreviewWidgetState.UNLOAD) goto L11;
        boolean r102 = r100 instanceof DynamicWidget;
        if (r102 == true) goto L8;
        if (r102 == true) goto L11;
        Y90(r100, "loadDynamicVHWidget  " + r100.getMergeTag() + "   " + r100.getMergeStatus());
        V90(r100, new VHWidgetManager$loadDynamicVHWidget$1(this, r100, r101));
        return;
    L8:
        DynamicWidget r103 = (DynamicWidget) r100;
        Intrinsics.throwUninitializedPropertyAccessException("mVHPreviewContext");
        int r104 = com.bytedance.livesdk.preview.b.f256400a;
        Intrinsics.throwUninitializedPropertyAccessException("mVHPreviewContext");
        throw null;
    L11:
        if (r100.getMergeStatus() != PreviewWidgetState.LOADED) goto L17;
        Y90(r100, "load subWidget");
        Iterator r105 = ((Map) r100.f256410d.getValue()).values().iterator();
    L14:
        if (r105.hasNext() == false) goto L23;
        W90((VHWidget) r105.next(), r101);
        goto L14
    L23:
        return;
    L17:
        if (r100.getMergeStatus() == PreviewWidgetState.LOADING) goto L20;
        return;
    L20:
        throw new IllegalAccessException();
    }

    public final void T90(AbsMergeWidget r100, ViewParent r101, View r102) {
        ViewGroup r103 = null;
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r104 = (ViewGroup) r101;
        if (r104 == null) goto L14;
        if (r102 == null) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        r103 = r104;
    L12:
        if (r103 == null) goto L14;
        r103.addView(r102);
        goto L14
    L9:
        r105 = false;
    L14:
        r100.contentView = r102;
        r100.setMergeStatus(PreviewWidgetState.LOADED);
        r100.setLoadedEnvironment(AbsMergeWidget.MergeWidgetEnvironment.PREVIEW);
        v.a();
        f r106 = this.f256420k;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "widget");
        r106.f256425a.add(r100);
        if ((r100 instanceof PriorityWidget) == false) goto L18;
        r106.f256426b.add(r100);
    L18:
        if ((r100 instanceof VHWidget) == false) goto L20;
        getLifecycle().addObserver(r100);
        final VHWidget r107 = (VHWidget) r100;
        r107.Gq(new VHWidget$onSubViewLoaded$1(r107));
        r107.Bq();
    L20:
        r100.onMergeLoad();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbsMergeWidget U90(ViewGroup r100, AbsMergeWidget r101, boolean r102) {
        if ((r101 instanceof VHWidget) == false) goto L6;
        VHWidget r103 = (VHWidget) r101;
        X90(r103, r102, r100);
        return r103;
    L6:
        if ((r101 instanceof ap2.b) == true) goto L30;
        if (r101 == 0) goto L9;
        r101.setMergeStatus(PreviewWidgetState.LOADING);
    L9:
        VHWidgetManager$doLoadMergeWidget$1 r104 = VHWidgetManager$doLoadMergeWidget$1.INSTANCE;
        if (r101 == 0) goto L35;
        r101.context = getContext();
        r101.setMergeWidgetManager(this);
        Intrinsics.throwUninitializedPropertyAccessException("mVHPreviewContext");
        r101.setMergeContext(null);
        r101.containerView = r100;
        r101.dataCenter = null;
        int r105 = e.f256424a;
        String r106 = "load widget " + r101.getMergeTag();
        Intrinsics.checkNotNullParameter(r106, "logString");
        fl6.a.a(4, "PriorityWidget_", r106);
        if (r101.getLayoutId() != 0) goto L22;
        if ((r101 instanceof VHWidget) == false) goto L17;
        VHWidget r107 = (VHWidget) r101;
    L17:
        ViewGroup r108 = r101.containerView;
        if ((r108 instanceof ViewGroup) == true) goto L20;
        r108 = null;
    L20:
        T90(r101, r108, null);
        r104.invoke();
        return r101;
    L22:
        if ((r101 instanceof VHWidget) == false) goto L24;
        VHWidget r109 = (VHWidget) r101;
    L24:
        if (r102 == true) goto L36;
        ViewGroup r110 = r101.containerView;
        if ((r110 instanceof ViewGroup) == true) goto L29;
        r110 = null;
    L29:
        T90(r101, r110, null);
        r104.invoke();
        return r101;
    L36:
        return r101;
    L35:
        return r101;
    L30:
        fl6.a.a(4, "VHWidgetManager", "doLoadMergeWidget  " + r101.getMergeTag() + "   is IPreviewDynamicWidget");
        ((ArrayList) this.f256414e).add(new b((ap2.b) r101, r100));
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X90(final VHWidget r100, final boolean r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        System.currentTimeMillis();
        if ((r100 instanceof ap2.b) == true) goto L5;
        this.f256415f++;
        r100.getClass();
        V90(r100, new VHWidgetManager$loadWidget$1(this, r100, r101));
    L6:
        Lazy r103 = LivePreviewVHMonitor.f256396c;
        this.f256418i.invoke(Integer.valueOf(this.f256415f));
        return;
    L5:
        ((ArrayList) this.f256414e).add(new b((ap2.b) r100, r102));
        goto L6
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final void li(ViewGroup r100, AbsMergeWidget r101, boolean r102, boolean r103) {
        U90(r100, r101, r102);
    }

    @Override // com.bytedance.livesdk.preview.merge.a
    public final AbsMergeWidget Gq(ViewGroup r100, LiveRecyclableWidget r101, boolean r102, boolean r103, Object[] r104) {
        return U90(r100, r101, r102);
    }
}
