package com.larus.photopicker.v2.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.ui.DynamicGridItemDecoration;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaSelectorViewModel;
import com.larus.platform.model.MediaPickerUIMode;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001d\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u00020+H\u0000¢\u0006\u0002\b4J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u0002062\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010=\u001a\u00020+H\u0002J\b\u0010>\u001a\u00020+H\u0002J\u0015\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u000201H\u0000¢\u0006\u0002\bAJ\b\u0010B\u001a\u00020+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/photopicker/v2/impl/MediaSelectorListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "TAG", "", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusFragmentMediaListBinding;", "myAdapter", "Lcom/larus/photopicker/v2/impl/ui/MediaListAdapterV2;", "dynamicGridItemDecoration", "Lcom/larus/photopicker/v2/impl/ui/DynamicGridItemDecoration;", "recyclerViewScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "bottomSheetViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "getBottomSheetViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "bottomSheetViewModel$delegate", "Lkotlin/Lazy;", "mobViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "getMobViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "mobViewModel$delegate", "mediaGalleryViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "getMediaGalleryViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "mediaGalleryViewModel$delegate", "mediaSelectorViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaSelectorViewModel;", "getMediaSelectorViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaSelectorViewModel;", "mediaSelectorViewModel$delegate", "curMediaTab", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "mediaStateManager", "Lcom/larus/photopicker/v2/impl/strategy/GenericStateManager;", "Lcom/larus/photopicker/v2/impl/strategy/MediaSelectorListState;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "adjustScrollForInput", "addedItemUri", "extraPadding", "", "adjustScrollForInput$impl_mainlandRelease", "scrollToTop", "scrollToTop$impl_mainlandRelease", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "initViewModel", "updateInputFooterHeight", "height", "updateInputFooterHeight$impl_mainlandRelease", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaSelectorListFragment extends Fragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f364303p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f364304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final et3.c f364305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusFragmentMediaListBinding f364306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaListAdapterV2 f364307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DynamicGridItemDecoration f364308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaSelectorListFragment$initViews$1$scrollListener$1 f364309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f364310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f364311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f364312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f364313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MediaTab f364314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final up9.x<up9.g0> f364315o;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f364316a = null;

        static {
            int[] r100 = new int[MediaPickerUIMode.values().length];
            r100[MediaPickerUIMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MediaPickerUIMode.INVISIBLE_BOTTOM_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f364316a = r100;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f364317a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f364317a = r100;
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
            return this.f364317a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f364317a.invoke(r100);
        }
    }

    public static final class d implements Function0<BottomSheetViewModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f364318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f364319b;

        public d(Fragment r100, Class r101) {
            this.f364318a = r100;
            this.f364319b = r101;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel] */
        @Override // kotlin.jvm.functions.Function0
        public final BottomSheetViewModel invoke() {
            int r100 = e0.f364440a;
            Fragment r101 = e0.a(this.f364318a, this.f364319b);
            if (r101 != null) goto L5;
            return null;
        L5:
            Fragment r102 = this.f364318a;
            final n2 r103 = new n2(r101);
            o2 r104 = new o2(r102);
            return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(r102, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new MediaSelectorListFragment$special$$inlined$findViewModel$1$3(r103), r104).getValue();
        }
    }

    static {
    }

    public final MediaGalleryLiveDataViewModel S90() {
        return (MediaGalleryLiveDataViewModel) this.f364312l.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        LarusFragmentMediaListBinding r100 = this.f364306f;
        if (r100 == null) goto L12;
        RecyclerView r101 = r100.f364385c;
        if (r101 == null) goto L12;
        MediaSelectorListFragment$initViews$1$scrollListener$1 r102 = this.f364309i;
        if (r102 == null) goto L9;
        r101.removeOnScrollListener(r102);
    L9:
        r101.setOnTouchListener(null);
        r101.setAdapter(null);
        DynamicGridItemDecoration r103 = this.f364308h;
        if (r103 == null) goto L12;
        r101.removeItemDecoration(r103);
    L12:
        this.f364309i = null;
        MediaListAdapterV2 r104 = this.f364307g;
        if (r104 == null) goto L15;
        r104.f364629c = new vp9.h();
        r104.f364630d = new vp9.i();
    L15:
        this.f364305e.f();
        ((up9.g0) this.f364315o.a()).onDestroyView();
        this.f364306f = null;
        super.onDestroyView();
    }

    public MediaSelectorListFragment() {
        this.f364304d = "MediaSelectorListFragment";
        this.f364305e = new et3.c("photo_album", false, null);
        int r100 = e0.f364440a;
        this.f364310j = LazyKt.lazy(new d(this, c0.class));
        d0 r101 = new d0(this, c0.class);
        this.f364311k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaMobViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r101), new Injection$provideViewModel$$inlined$viewModels$default$2(r101, this));
        d0 r102 = new d0(this, MediaGalleryFragment.class);
        this.f364312l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaGalleryLiveDataViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r102), new Injection$provideViewModel$$inlined$viewModels$default$2(r102, this));
        d0 r103 = new d0(this, MediaSelectorFragment.class);
        this.f364313m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaSelectorViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r103), new Injection$provideViewModel$$inlined$viewModels$default$2(r103, this));
        this.f364314n = MediaTab.ALL;
        this.f364315o = new up9.x();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L7;
        String r102 = r101.getString(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);
        if (r102 == null) goto L7;
        this.f364314n = MediaTab.valueOf(r102);
    L7:
        up9.x<up9.g0> r103 = this.f364315o;
        Function0 r104 = new l2(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "initialStateFactory");
        r103.f551151a = (S) r104.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.photopicker.v2.impl.j2] */
    /* JADX WARN: Type inference failed for: r3v8, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.photopicker.v2.impl.MediaSelectorListFragment$initViews$1$scrollListener$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusFragmentMediaListBinding r102 = this.f364306f;
        if (r102 == null) goto L26;
        final GestureDetectorCompat r103 = new GestureDetectorCompat(requireContext(), new vp9.t(r102.f364385c, (MediaSelectorViewModel) this.f364313m.getValue()));
        ?? r104 = new j2(this);
        MediaGalleryUIConfig r105 = S90().getUiConfig();
        this.f364307g = ((up9.g0) this.f364315o.a()).n(requireContext(), r105.f364485b, S90().getLazyLoadConfig().f364367a, r104);
        if (this.f364314n != CollectionsKt.first(r105.f364484a)) goto L11;
        Integer r106 = r105.f364495l;
        if (r106 == null) goto L10;
        int r107 = r106.intValue();
    L12:
        this.f364308h = new DynamicGridItemDecoration(r105.f364485b, r107);
        RecyclerView r108 = r102.f364385c;
        r108.setHasFixedSize(true);
        DynamicGridItemDecoration r109 = this.f364308h;
        MediaListAdapterV2 r110 = null;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicGridItemDecoration");
        r109 = null;
    L15:
        r108.addItemDecoration(r109);
        r108.setNestedScrollingEnabled(false);
        r108.setItemAnimator(null);
        r108.setLayoutManager(new GridLayoutManager(requireContext(), r105.f364485b));
        MediaListAdapterV2 r111 = this.f364307g;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("myAdapter");
        r111 = null;
    L18:
        r108.setAdapter(r111);
        ?? r112 = new MediaSelectorListFragment$initViews$1$scrollListener$1(this);
        this.f364309i = r112;
        r108.addOnScrollListener(r112);
        r108.setOnTouchListener(new k2(r103));
        if (this.f364314n != CollectionsKt.first(r105.f364484a)) goto L21;
        int r113 = r105.f364497n;
        ViewCompat.setPaddingRelative(r108, r113, 0, r113, 0);
    L21:
        up9.g0.a r114 = ((up9.g0) this.f364315o.a()).c();
        Context r115 = requireContext();
        MediaListAdapterV2 r116 = this.f364307g;
        if (r116 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("myAdapter");
    L25:
        r114.a(r115, r110);
        goto L26
    L24:
        r110 = r116;
        goto L25
    L10:
        r107 = r105.f364494k;
        goto L12
    L11:
        r107 = r105.f364494k;
    L26:
        final LarusFragmentMediaListBinding r117 = this.f364306f;
        if (r117 == null) goto L31;
        ((MediaSelectorViewModel) this.f364313m.getValue()).getInjectInputFooterHeight().observe(getViewLifecycleOwner(), new c(new c2(this)));
        ((up9.g0) this.f364315o.a()).c().b(getViewLifecycleOwner(), (BottomSheetViewModel) this.f364310j.getValue(), r117);
        S90().getEnterOrExitPreviewPage().observe(getViewLifecycleOwner(), new c(new e2(this, r117)));
        ((MediaSelectorViewModel) this.f364313m.getValue()).getBottomSelectorHeight().observe(getViewLifecycleOwner(), new c(new f2(this)));
        S90().getFastMediaItems().observe(getViewLifecycleOwner(), new c(new g2(this, r117)));
        S90().getCurrentFolder().observe(getViewLifecycleOwner(), new c(new h2(this, r117)));
        S90().getSelectionManager().f364707i.observe(getViewLifecycleOwner(), new c(new i2(this)));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_fragment_media_list, r101, false);
        int r104 = R.id.empty_media_tv;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.empty_media_tv);
        if (r105 == null) goto L9;
        r104 = R.id.recycler_view;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(r103, R.id.recycler_view);
        if (r106 == null) goto L9;
        FrameLayout r107 = (FrameLayout) r103;
        this.f364306f = new LarusFragmentMediaListBinding(r107, r105, r106);
        return r107;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
