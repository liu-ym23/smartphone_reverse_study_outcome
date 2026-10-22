package com.larus.photopicker.v2.impl.ui;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.photopicker.v2.impl.Injection$provideViewModel$$inlined$viewModels$default$1;
import com.larus.photopicker.v2.impl.Injection$provideViewModel$$inlined$viewModels$default$2;
import com.larus.photopicker.v2.impl.MediaGalleryFragment;
import com.larus.photopicker.v2.impl.MediaPreviewFragment;
import com.larus.photopicker.v2.impl.d0;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaPreviewViewModel;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import op9.d;
import qp9.a0;
import qp9.k;
import wp9.g;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH&J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020-H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/BaseMediaPreviewItemFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mediaGalleryViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "getMediaGalleryViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "mediaGalleryViewModel$delegate", "Lkotlin/Lazy;", "mediaPreviewViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaPreviewViewModel;", "getMediaPreviewViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaPreviewViewModel;", "mediaPreviewViewModel$delegate", "updateThrottler", "Lcom/larus/photopicker/v2/impl/utils/UpdateThrottler;", "uiMediaItem", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "getUiMediaItem", "()Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "setUiMediaItem", "(Lcom/larus/photopicker/v2/impl/model/UIMediaItem;)V", "curPosition", "", "getCurPosition", "()I", "setCurPosition", "(I)V", "provideGestureLayout", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "initView", "nonNullMediaItem", "initViewModel", "onResume", "onPause", "onDestroyView", "provideAnimationConfiguration", "Lcom/larus/photopicker/v2/impl/others/scale/AppearOrDisappearAnimationConfiguration;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseMediaPreviewItemFragment extends Fragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f364603i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f364604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f364605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f364606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f364607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f364608h;

    public static final class a {
    }

    public static final class b implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseMediaPreviewItemFragment f364609a;

        @Override // qp9.a0
        public final void a() {
        }

        @Override // qp9.a0
        public final void b() {
        }

        @Override // qp9.a0
        public final void onClick() {
        }

        @Override // qp9.a0
        public final void onExit() {
            this.f364609a.S90().getEnterOrExitPreviewPage().setValue(TuplesKt.to(Boolean.FALSE, Integer.valueOf(this.f364609a.f364608h)));
        }

        public b(BaseMediaPreviewItemFragment r100) {
            this.f364609a = r100;
        }

        @Override // qp9.a0
        public final void c(float r100) {
            if (this.f364609a.f364606f.a() == true) goto L14;
            boolean r101 = true;
            if (r100 != 1.0f) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L14;
            if (r100 == 0.0f) goto L13;
            r101 = false;
        L13:
            if (r101 == true) goto L14;
            return;
        L7:
            r102 = false;
        L14:
            ((MediaPreviewViewModel) this.f364609a.f364605e.getValue()).getPreviewPageAlphaPercentChange().setValue(Float.valueOf(r100));
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f364610a;

        public c(vp9.a r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f364610a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f364610a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f364610a.invoke(r100);
        }
    }

    static {
    }

    public abstract ScaleGestureLayout V90();

    public static qp9.a U90() {
        qp9.a r100 = new qp9.a();
        r100.f534380e = 220;
        r100.f534381f = 220;
        r100.f534382g = 220;
        r100.f534383h = 220;
        Pair<? extends PointF, ? extends PointF> r101 = qp9.b.f534385a;
        PointF r102 = r101.component1();
        PointF r103 = r101.component2();
        rp9.b r104 = new rp9.b(r102, r103);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f534376a = r104;
        rp9.b r105 = new rp9.b(r102, r103);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r100.f534377b = r105;
        rp9.b r106 = new rp9.b(r102, r103);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f534378c = r106;
        rp9.b r107 = new rp9.b(r102, r103);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f534379d = r107;
        return r100;
    }

    public final MediaGalleryLiveDataViewModel S90() {
        return (MediaGalleryLiveDataViewModel) this.f364604d.getValue();
    }

    public BaseMediaPreviewItemFragment() {
        int r100 = e0.f364440a;
        d0 r101 = new d0(this, MediaGalleryFragment.class);
        this.f364604d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaGalleryLiveDataViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r101), new Injection$provideViewModel$$inlined$viewModels$default$2(r101, this));
        d0 r102 = new d0(this, MediaPreviewFragment.class);
        this.f364605e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaPreviewViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r102), new Injection$provideViewModel$$inlined$viewModels$default$2(r102, this));
        this.f364606f = new g(8);
        this.f364608h = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        V90().k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        V90().k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L10;
        int r102 = r101.getInt("media_item_position");
        this.f364608h = r102;
        List<d> r103 = S90().getCurrentPreviewItems().getValue();
        if (r103 == null) goto L7;
        d r104 = (d) CollectionsKt.getOrNull(r103, r102);
    L8:
        this.f364607g = r104;
        return;
    L7:
        r104 = null;
        goto L8
    }

    public void T90(d r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "nonNullMediaItem");
        Intrinsics.checkNotNullParameter(r101, "view");
        final ScaleGestureLayout r102 = V90();
        mp9.c r103 = r100.f524790a;
        int r104 = r103.f514741j;
        int r105 = r103.f514742k;
        r102.getClass();
        r102.f364572p = new Rect(0, 0, r104, r105);
        r102.post(new k(r102));
        r102.setZoomListener(new b(this));
        if (this.f364608h == S90().getCurPreviewPosition()) goto L5;
        return;
    L5:
        if (S90().isNeedAnimWhenEnterPreview() == false) goto L9;
        S90().getEnterOrExitPreviewPage().setValue(TuplesKt.to(Boolean.TRUE, Integer.valueOf(this.f364608h)));
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [vp9.a] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        d r102 = this.f364607g;
        if (r102 != null) goto L5;
        return;
    L5:
        T90(r102, r100);
        S90().getCapturePositionViewRect().observe(getViewLifecycleOwner(), new c(new vp9.a(this)));
    }
}
