package com.larus.camera.impl.ui.component.result.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;

/* JADX INFO: loaded from: classes26.dex */
public final class ResultTabControlComponent extends com.larus.camera.impl.ui.arch.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ResultConfirmControlStyle f322198m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f322199n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ResultInputControlBinder f322200o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/ResultTabControlComponent$DisplayState;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIRM", "INPUT", "HIDDEN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DisplayState extends Enum<DisplayState> {
        public static final DisplayState CONFIRM = null;
        public static final DisplayState HIDDEN = null;
        public static final DisplayState INPUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DisplayState[] f322201a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f322202b = null;

        public static EnumEntries<DisplayState> getEntries() {
            return f322202b;
        }

        static {
            DisplayState r100 = new DisplayState("CONFIRM", 0);
            CONFIRM = r100;
            DisplayState r101 = new DisplayState("INPUT", 1);
            INPUT = r101;
            DisplayState r102 = new DisplayState("HIDDEN", 2);
            HIDDEN = r102;
            DisplayState[] r103 = {r100, r101, r102};
            f322201a = r103;
            f322202b = EnumEntriesKt.enumEntries(r103);
        }

        public static DisplayState[] values() {
            return (DisplayState[]) f322201a.clone();
        }

        public static DisplayState valueOf(String r100) {
            return (DisplayState) r27.a.a(DisplayState.class, r100);
        }

        public DisplayState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r100 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = this.f322199n;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("confirmView");
        View r102 = null;
    L9:
        new f(r102, getContext(), k(), this.f322198m, new d0(this)).a();
        kotlinx.coroutines.flow.i1<px8.e> r103 = r100.getResultBottomState();
        kotlinx.coroutines.flow.i1<Boolean> r104 = r100.isInCropMode();
        String r105 = r100.getCameraData().getCaptureMode();
        if (fx8.a.f479114e.contains(r105) == false) goto L16;
        final ChannelFlowTransformLatest r106 = kotlinx.coroutines.flow.e.G(new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(r100.getEduImageAbility()), new ResultTabControlComponent$bottomReadyFlow$$inlined$flatMapLatest$1(null));
        Flow<Boolean> r107 = new ResultTabControlComponent$bottomReadyFlow$$inlined$map$1(r106);
        if (Intrinsics.areEqual(r105, "CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L14;
    L15:
        kotlinx.coroutines.flow.v0 r108 = new kotlinx.coroutines.flow.v0(r107, r100.getEduResultTabState(), new ResultTabControlComponent$bottomReadyFlow$1(null));
    L17:
        r107 = r108;
    L18:
        final Flow r109 = kotlinx.coroutines.flow.e.n(kotlinx.coroutines.flow.e.j(r103, r104, r107, new ResultTabControlComponent$onViewCreated$displayStateFlow$1(null)));
        ResultInputControlBinder r110 = this.f322200o;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r110 = null;
    L21:
        r110.b(new ResultTabControlComponent$onViewCreated$$inlined$map$1(r109));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getResultDetectionStatus(), new ResultTabControlComponent$onViewCreated$3(this, null)), k());
        final kotlinx.coroutines.flow.i1<px8.b> r111 = r100.getEduResultTabState();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(kotlinx.coroutines.flow.e.n(new ResultTabControlComponent$onViewCreated$$inlined$map$2(r111)), new ResultTabControlComponent$onViewCreated$5(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r109, new ResultTabControlComponent$onViewCreated$6(this, null)), k());
        return;
    L14:
        if (Intrinsics.areEqual(r105, "CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L18;
    L16:
        r108 = new kotlinx.coroutines.flow.v0(r100.getResultDetectionStatus(), r100.getEduResultTabState(), new ResultTabControlComponent$bottomReadyFlow$2(r100, null));
        goto L17
    L8:
        r102 = r101;
        goto L9
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        ResultInputControlBinder r100 = this.f322200o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r100 = null;
    L5:
        CameraResultViewModel r101 = r100.f322482c.invoke();
        if (r101 == null) goto L9;
        r101.enableFreeInputMode(false);
        return;
    }

    public ResultTabControlComponent(ResultConfirmControlStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "confirmControlStyle");
        com.larus.camera.impl.ui.arch.c r101 = com.larus.camera.impl.ui.arch.c.f321810a;
        super(80, com.larus.camera.impl.ui.arch.c.f321812c);
        this.f322198m = r100;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = new CameraContainer.b(-1, -1);
        ((FrameLayout.LayoutParams) r101).gravity = r100;
        return r101;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        FrameLayout r102 = new FrameLayout(r101.getContext());
        View r103 = r100.inflate(R.layout.larus_layout_view_control_component, r102, false);
        Intrinsics.checkNotNull(r103);
        com.larus.utils.e1.o(r103);
        this.f322199n = r103;
        r102.addView(r103, new FrameLayout.LayoutParams(-1, -1));
        ResultInputControlBinder r104 = new ResultInputControlBinder(r101.getContext(), k(), new e0(this));
        this.f322200o = r104;
        View r105 = r104.c(r100, r102, r101);
        com.larus.utils.e1.o(r105);
        ResultInputControlBinder r106 = this.f322200o;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r106 = null;
    L5:
        CameraContainer.b r107 = new CameraContainer.b(-2, -2);
        ((FrameLayout.LayoutParams) r107).gravity = 80;
        Unit r108 = Unit.INSTANCE;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "layoutParams");
        r102.addView(r105, r106.d().d(r107));
        return r102;
    }
}
