package com.larus.camera.impl.ui.component.generalonly;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.ui.viewmodel.ChangeState;
import com.larus.nova.R;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.e1;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class AlbumThumbListComponent extends com.larus.camera.impl.ui.arch.b implements com.larus.camera.impl.ui.component.capture.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f322065u = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f322066m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f322067n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f322068o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f322069p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f322070q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f322071r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f322072s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f322073t;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f322074a;

        public b(Function0<Unit> r100) {
            this.f322074a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0<Unit> r101 = this.f322074a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    static {
    }

    public AlbumThumbListComponent() {
        super(com.larus.camera.impl.ui.arch.c.f321812c, 1);
        this.f322066m = fx8.a.f479110a;
        this.f322067n = LazyKt.lazy(new com.larus.camera.impl.ui.component.generalonly.a(this));
        this.f322068o = LazyKt.lazy(new com.larus.camera.impl.ui.component.generalonly.b(this));
        this.f322069p = LazyKt.lazy(new c(this));
        this.f322070q = LazyKt.lazy(new d(this));
        this.f322071r = LazyKt.lazy(new e());
        this.f322072s = LazyKt.lazy(new f(this));
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        e1.o((View) this.f322067n.getValue());
        ((LinkedHashMap) ((com.larus.camera.impl.utils.album.d.c) com.larus.camera.impl.utils.album.d.f322719a.getValue()).f483123a.f483125b).clear();
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r100, (ConstraintLayout) h(R.id.container), 0, null, 6, null);
        ICameraEventExt r101 = r100.getCameraData().getEventExt();
        if (r101 == null) goto L12;
        String r102 = r101.getConversationId();
        if (r102 == null) goto L13;
        BuildersKt.launch$default(k(), Dispatchers.getMain(), null, new AlbumThumbListComponent$onViewCreated$1(r100, this, r102, null), 2, null);
        return;
    L13:
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        ((LinkedHashMap) ((com.larus.camera.impl.utils.album.d.c) com.larus.camera.impl.utils.album.d.f322719a.getValue()).f483123a.f483125b).clear();
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f322066m;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        ((FrameLayout.LayoutParams) r101).width = -1;
        ((FrameLayout.LayoutParams) r101).height = -1;
        return r101;
    }

    public static final void p(AlbumThumbListComponent r100, boolean r101) {
        CameraCaptureViewModel r102 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) r100.f321801e.getValue()).a();
        if (r102 == null) goto L10;
        if (r101 == false) goto L7;
        r100.f322073t = true;
        r102.albumThumbListStateChanged(ChangeState.SHOW);
        CameraCaptureViewModel.showCameraItemMobOnCapture$default(r102, "album_thumbnail", null, 2, null);
        e1.x((View) r100.f322067n.getValue());
        return;
    L7:
        r100.f322073t = false;
        r102.albumThumbListStateChanged(ChangeState.HIDE);
        e1.o((View) r100.f322067n.getValue());
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return r100.inflate(R.layout.larus_layout_album_thumb_list_component, r101, false);
    }

    public final void q(final View r100, int r101, int r102, Function0<Unit> r103) {
        final CameraCaptureViewModel r104 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r104 != null) goto L5;
        return;
    L5:
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{r101, r102});
        if (r101 <= 0) goto L8;
        r105.setInterpolator(new AccelerateInterpolator());
    L9:
        r105.addUpdateListener(new h(r100, r104));
        r105.addListener(new b(r103));
        r105.setDuration(200);
        r105.start();
        return;
    L8:
        r105.setInterpolator(new DecelerateInterpolator());
        goto L9
    }
}
