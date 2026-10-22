package com.larus.avlink.gallery.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larus.avlink.gallery.banner.GalleryState;
import com.larus.avlink.gallery.thumbnail.ThumbnailManager;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.impl.databinding.LarusPageAlbumSyncBannerBinding;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001&\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0002YZB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0012\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020)J\u000e\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u000fJ\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u00020)J\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020<J\u001c\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u00182\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0002J/\u0010?\u001a\u00020)2\b\b\u0001\u0010@\u001a\u00020\u00072\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010CJ^\u0010D\u001a\u00020)2\b\b\u0002\u0010E\u001a\u0002002\b\b\u0002\u0010F\u001a\u0002002\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010H\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020\u00072\b\b\u0002\u0010J\u001a\u0002072\b\b\u0002\u0010K\u001a\u0002072\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020)0MH\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\b\u0010P\u001a\u000207H\u0002J\b\u0010Q\u001a\u00020)H\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010>\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020)H\u0014J\b\u0010U\u001a\u00020)H\u0014J\u000e\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020\u0007J\u000e\u0010X\u001a\u00020)2\u0006\u0010W\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'¨\u0006["}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumSyncBanner;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusPageAlbumSyncBannerBinding;", "bannerStateManager", "Lcom/larus/avlink/gallery/banner/BannerStateManager;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "syncActionHandler", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;", "getSyncActionHandler", "()Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;", "setSyncActionHandler", "(Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;)V", "bannerStateMachine", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/avlink/model/BannerStateMachineState;", "rotateAnimator", "Landroid/animation/ValueAnimator;", "rotateDrawable", "Landroid/graphics/drawable/RotateDrawable;", "originalSyncDrawable", "Landroid/graphics/drawable/Drawable;", "overrideBgDrawable", "Ljava/lang/Integer;", "overrideTextColor", "overrideIconTintColor", "wifiStateListener", "Lcom/larus/dora/api/wrapper/FlowDoraWifiStateListener;", "albumCountChangeListener", "com/larus/avlink/gallery/view/AlbumSyncBanner$albumCountChangeListener$1", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner$albumCountChangeListener$1;", "initRotateDrawable", "", "startRotationAnimation", "stopRotationAnimation", "setStaticDrawable", "drawableRes", "wifiStateChange", "reason", "", "updateProgress", "progress", "hideProgress", "setLifecycleOwner", "owner", "inErrorState", "", "inNetworkErrorState", "eraseError", "handleEvent", "event", "Lcom/larus/avlink/model/BannerEvent;", "updateUIForState", "state", "showByState", "type", SoloKtvContext.SOLO_PAGE_FIRST, "second", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "show", "title", "buttonText", "bgDrawable", "titleDrawable", "btnColor", "showCloseBtn", "showRotate", "onButtonClick", "Lkotlin/Function0;", ECSaasScrollViewController.SEARCH_SCROLL_STATE_IDLE, "hide", "showMediaDiff", "observeStateChanges", "updateUi", "Lcom/larus/avlink/gallery/view/BannerState;", "onAttachedToWindow", "onDetachedFromWindow", "setOverrideBackground", "resId", "setOverrideTextColor", "Companion", "SyncActionHandler", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumSyncBanner extends ConstraintLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f292844n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusPageAlbumSyncBannerBinding f292845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q98.a f292846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LifecycleOwner f292847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f292848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f292849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f292850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RotateDrawable f292851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f292852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f292853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f292854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f292855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h49.i f292856l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f292857m;

    public static final class a {
    }

    public interface b {
        void TF();

        void bj(Function1<? super Boolean, Unit> r100);

        void ib();
    }

    public static final class c implements com.larus.avlink.gallery.thumbnail.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlbumSyncBanner f292858a;

        public c(AlbumSyncBanner r100) {
            this.f292858a = r100;
        }

        @Override // com.larus.avlink.gallery.thumbnail.a
        public final void a(int r100, int r101) {
            FLogger r102 = FLogger.f375446a;
            r102.i("AlbumSyncBanner", "AlbumCountChanged: photo=" + r100 + " video=" + r101);
            z98.b r103 = (z98.b) this.f292858a.f292849e.getValue();
            if ((r103 instanceof z98.b.j) == false) goto L5;
        L19:
            r102.i("AlbumSyncBanner", "Ignoring album count change during transfer: photo=" + r100 + ", video=" + r101 + ", state=" + r103.getClass().getSimpleName());
            return;
        L5:
            if ((r103 instanceof z98.b.k) == true) goto L19;
            if (r100 != 0) goto L14;
            if (r101 != 0) goto L14;
            r102.i("AlbumSyncBanner", "AlbumCount trigger: Idle");
            if (Intrinsics.areEqual(r103, z98.b.g.f571048b) == true) goto L21;
            this.f292858a.n6(z98.b.e.f571046b, null);
            return;
        L21:
            return;
        L14:
            if (this.f292858a.V5() == false) goto L17;
            r102.i("AlbumSyncBanner", "AlbumCount ignored in error state: ".concat(this.f292858a.f292849e.getValue().getClass().getSimpleName()));
            return;
        L17:
            this.f292858a.T5(new z98.a.h(r100, r101));
        }
    }

    public static final class d implements h49.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlbumSyncBanner f292859a;

        @Override // h49.i
        public final void c() {
        }

        public d(AlbumSyncBanner r100) {
            this.f292859a = r100;
        }

        @Override // h49.i
        public final void a(FlowDoraGlassOpenState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // h49.i
        @Deprecated(message = "使用ThumbnailManager")
        public final void b(b49.e r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // h49.i
        public final void d(b49.f r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
        }

        @Override // h49.i
        public final void e(FlowDoraGlassOpenState r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // h49.i
        public final void f(int r100, int r101, final String r102) {
            FLogger.f375446a.i("AlbumSyncBanner", "wifi changed: old=" + r100 + " new=" + r101 + " reason=" + r102);
            z98.b r103 = (z98.b) this.f292859a.f292849e.getValue();
            if (r101 == 2) goto L9;
            if (r101 == 0) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r103, z98.b.k.f571052b) == true) goto L11;
            final AlbumSyncBanner r104 = this.f292859a;
            r104.getClass();
            com.larus.utils.y.c(new j(r102, r104));
            return;
        L11:
            return;
        }
    }

    static {
    }

    public AlbumSyncBanner(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AlbumSyncBanner(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void U5() {
        com.larus.utils.t0.e(new s(this));
    }

    public final boolean V5() {
        z98.b r100 = (z98.b) this.f292849e.getValue();
        if ((r100 instanceof z98.b.C8434b) == false) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof z98.b.n) == true) goto L18;
        if ((r100 instanceof z98.b.c) == true) goto L18;
        if ((r100 instanceof z98.b.l) == true) goto L18;
        if ((r100 instanceof z98.b.a) == true) goto L18;
        if ((r100 instanceof z98.b.f) == true) goto L18;
        if ((r100 instanceof z98.b.h) == true) goto L18;
        return false;
    }

    public final boolean b6() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L7;
        VisionService r101 = r100.V();
        if (r101 == null) goto L7;
        Pair<Integer, Integer> r102 = r101.l();
    L9:
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L16;
    L17:
        if (r102 == null) goto L20;
        FLogger.f375446a.i("AlbumSyncBanner", "DiffMedia: images=" + r102.getFirst().intValue() + ", videos=" + r102.getSecond().intValue());
        T5(new z98.a.h(r102.getFirst().intValue(), r102.getSecond().intValue()));
        return true;
    L20:
        return false;
    L16:
        if (r102.getFirst().intValue() == 0) goto L20;
    L11:
        if (r102.getSecond().intValue() != 0) goto L13;
        r103 = true;
    L7:
        r102 = null;
        goto L9
    }

    public final void c6() {
        ValueAnimator r100 = this.f292850f;
        boolean r101 = false;
        if (r100 == null) goto L8;
        if (r100.isRunning() != true) goto L8;
        r101 = true;
    L8:
        if (r101 == false) goto L11;
        FLogger.f375446a.d("AlbumSyncBanner", "Rotation animation already running, skipping restart");
        return;
    L11:
        i6();
        Integer r102 = this.f292855k;
        if (r102 == null) goto L18;
        int r103 = r102.intValue();
        Drawable r104 = this.f292852h;
        if (r104 == null) goto L16;
        r104.setTint(ContextCompat.getColor(getContext(), r103));
        Unit r105 = Unit.INSTANCE;
    L17:
        if (r105 == null) goto L18;
    L21:
        final RotateDrawable r106 = this.f292851g;
        if (r106 == null) goto L25;
        this.f292845a.f293267f.setCompoundDrawablesWithIntrinsicBounds(r106, null, null, null);
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{0, 10000});
        r107.setDuration(1000);
        r107.setRepeatCount(-1);
        r107.setInterpolator(new LinearInterpolator());
        r107.addUpdateListener(new i(r106));
        this.f292850f = r107;
        r107.start();
        FLogger.f375446a.d("AlbumSyncBanner", "Started rotation animation");
        return;
    L25:
        return;
    L16:
        r105 = null;
    L18:
        Drawable r108 = this.f292852h;
        if (r108 == null) goto L21;
        r108.setTintList(null);
        Unit r109 = Unit.INSTANCE;
        goto L21
    }

    public final void i6() {
        ValueAnimator r100 = this.f292850f;
        if (r100 != null) goto L5;
    L7:
        this.f292850f = null;
        RotateDrawable r101 = this.f292851g;
        if (r101 == null) goto L11;
        r101.setLevel(0);
        return;
    L11:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        r100.cancel();
        FLogger.f375446a.d("AlbumSyncBanner", "Stopped rotation animation");
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f292856l != null) goto L9;
        d r100 = new d(this);
        this.f292856l = r100;
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L9;
        IDoraService.j r102 = r101.S();
        if (r102 == null) goto L9;
        r102.e(r100);
    L9:
        ThumbnailManager r103 = ThumbnailManager.f292763a;
        ThumbnailManager.g(this.f292857m);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h49.i r100 = this.f292856l;
        if (r100 == null) goto L9;
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L9;
        IDoraService.j r102 = r101.S();
        if (r102 == null) goto L9;
        r102.c(r100);
    L9:
        this.f292856l = null;
        ThumbnailManager r103 = ThumbnailManager.f292763a;
        ThumbnailManager.p(this.f292857m);
    }

    public final b getSyncActionHandler() {
        return this.f292848d;
    }

    private final void setStaticDrawable(int r100) {
        i6();
        Drawable r101 = ContextCompat.getDrawable(getContext(), r100);
        if (r101 == null) goto L5;
        Drawable r102 = r101.mutate();
    L6:
        Integer r103 = this.f292855k;
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
        if (r102 == null) goto L11;
        r102.setTint(ContextCompat.getColor(getContext(), r104));
    L11:
        this.f292845a.f293267f.setCompoundDrawablesWithIntrinsicBounds(r102, null, null, null);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void T5(z98.a r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        z98.b r100 = (z98.b) this.f292849e.getValue();
        String r101 = r110.f571025a;
        FLogger r102 = FLogger.f375446a;
        r102.i("AlbumSyncBanner", "handle event:" + r101);
        if ((r100 instanceof z98.b.e) == false) goto L29;
        if ((r110 instanceof z98.a.f) == false) goto L8;
        z98.b r103 = z98.b.g.f571048b;
    L335:
        if (Intrinsics.areEqual(r103, r100) == true) goto L337;
    L340:
        this.f292849e.setValue(r103);
        r102.i("AlbumSyncBanner", "State transition: " + r100.f571041a + " --" + r101 + "--> " + r103.f571041a);
        LifecycleOwner r104 = this.f292847c;
        if (r104 == null) goto L347;
        LifecycleCoroutineScope r105 = LifecycleOwnerKt.getLifecycleScope(r104);
        if (r105 == null) goto L348;
        BuildersKt.launch$default(r105, Dispatchers.getMain(), null, new AlbumSyncBanner$handleEvent$1(this, r103, r110, null), 2, null);
        return;
    L348:
        return;
    L347:
        return;
    L337:
        if (Intrinsics.areEqual(r103, z98.b.i.f571050b) == true) goto L340;
        r102.i("AlbumSyncBanner", "No transition: " + r100.f571041a + " --" + r101 + "--> " + r103.f571041a);
        return;
    L8:
        if ((r110 instanceof z98.a.m) == false) goto L11;
        r103 = z98.b.n.f571055b;
        goto L335
    L11:
        if ((r110 instanceof z98.a.e) == false) goto L14;
        r103 = z98.b.f.f571047b;
        goto L335
    L14:
        if ((r110 instanceof z98.a.g) == false) goto L17;
        r103 = z98.b.h.f571049b;
        goto L335
    L17:
        if ((r110 instanceof z98.a.b) == false) goto L20;
        r103 = z98.b.c.f571044b;
        goto L335
    L20:
        if ((r110 instanceof z98.a.k) == false) goto L23;
        r103 = z98.b.l.f571053b;
        goto L335
    L23:
        if ((r110 instanceof z98.a.C8433a) == false) goto L26;
        r103 = z98.b.a.f571042b;
        goto L335
    L26:
        if ((r110 instanceof z98.a.h) == false) goto L333;
        r103 = z98.b.i.f571050b;
    L333:
        r103 = r100;
        goto L335
    L29:
        if ((r100 instanceof z98.b.i) == false) goto L61;
        if ((r110 instanceof z98.a.m) == false) goto L34;
        r103 = z98.b.n.f571055b;
        goto L335
    L34:
        if ((r110 instanceof z98.a.b) == false) goto L37;
        r103 = z98.b.c.f571044b;
        goto L335
    L37:
        if ((r110 instanceof z98.a.k) == false) goto L40;
        r103 = z98.b.l.f571053b;
        goto L335
    L40:
        if ((r110 instanceof z98.a.e) == false) goto L43;
        r103 = z98.b.f.f571047b;
        goto L335
    L43:
        if ((r110 instanceof z98.a.g) == false) goto L46;
        r103 = z98.b.h.f571049b;
        goto L335
    L46:
        if ((r110 instanceof z98.a.C8433a) == false) goto L49;
        r103 = z98.b.a.f571042b;
        goto L335
    L49:
        if ((r110 instanceof z98.a.l) == false) goto L52;
        r103 = z98.b.m.f571054b;
        goto L335
    L52:
        if ((r110 instanceof z98.a.c) == false) goto L55;
        r103 = z98.b.d.f571045b;
        goto L335
    L55:
        if ((r110 instanceof z98.a.d) == false) goto L58;
        r103 = z98.b.e.f571046b;
        goto L335
    L58:
        if ((r110 instanceof z98.a.j) == false) goto L333;
        r103 = z98.b.k.f571052b;
        goto L335
    L61:
        if ((r100 instanceof z98.b.m) == false) goto L90;
        if ((r110 instanceof z98.a.m) == false) goto L66;
        r103 = z98.b.n.f571055b;
        goto L335
    L66:
        if ((r110 instanceof z98.a.b) == false) goto L69;
        r103 = z98.b.c.f571044b;
        goto L335
    L69:
        if ((r110 instanceof z98.a.e) == false) goto L72;
        r103 = z98.b.f.f571047b;
        goto L335
    L72:
        if ((r110 instanceof z98.a.g) == false) goto L75;
        r103 = z98.b.h.f571049b;
        goto L335
    L75:
        if ((r110 instanceof z98.a.k) == false) goto L78;
        r103 = z98.b.l.f571053b;
        goto L335
    L78:
        if ((r110 instanceof z98.a.C8433a) == false) goto L81;
        r103 = z98.b.a.f571042b;
        goto L335
    L81:
        if ((r110 instanceof z98.a.j) == false) goto L84;
        r103 = z98.b.k.f571052b;
        goto L335
    L84:
        if ((r110 instanceof z98.a.d) == false) goto L87;
        r103 = z98.b.e.f571046b;
        goto L335
    L87:
        if ((r110 instanceof z98.a.n) == false) goto L333;
        r103 = z98.b.C8434b.f571043b;
        goto L335
    L90:
        if ((r100 instanceof z98.b.k) == false) goto L119;
        if ((r110 instanceof z98.a.i) == false) goto L95;
        r103 = z98.b.j.f571051b;
        goto L335
    L95:
        if ((r110 instanceof z98.a.k) == false) goto L98;
        r103 = z98.b.l.f571053b;
        goto L335
    L98:
        if ((r110 instanceof z98.a.C8433a) == false) goto L101;
        r103 = z98.b.a.f571042b;
        goto L335
    L101:
        if ((r110 instanceof z98.a.e) == false) goto L104;
        r103 = z98.b.f.f571047b;
        goto L335
    L104:
        if ((r110 instanceof z98.a.g) == false) goto L107;
        r103 = z98.b.h.f571049b;
        goto L335
    L107:
        if ((r110 instanceof z98.a.l) == false) goto L110;
        r103 = z98.b.m.f571054b;
        goto L335
    L110:
        if ((r110 instanceof z98.a.d) == false) goto L113;
        r103 = z98.b.e.f571046b;
        goto L335
    L113:
        if ((r110 instanceof z98.a.n) == false) goto L116;
        r103 = z98.b.C8434b.f571043b;
        goto L335
    L116:
        if ((r110 instanceof z98.a.m) == false) goto L333;
        r103 = z98.b.n.f571055b;
        goto L335
    L119:
        if ((r100 instanceof z98.b.l) == false) goto L142;
        if ((r110 instanceof z98.a.h) == false) goto L124;
        r103 = z98.b.i.f571050b;
        goto L335
    L124:
        if ((r110 instanceof z98.a.m) == false) goto L127;
        r103 = z98.b.n.f571055b;
        goto L335
    L127:
        if ((r110 instanceof z98.a.C8433a) == false) goto L130;
        r103 = z98.b.a.f571042b;
        goto L335
    L130:
        if ((r110 instanceof z98.a.e) == false) goto L133;
        r103 = z98.b.f.f571047b;
        goto L335
    L133:
        if ((r110 instanceof z98.a.b) == false) goto L136;
        r103 = z98.b.c.f571044b;
        goto L335
    L136:
        if ((r110 instanceof z98.a.d) == false) goto L139;
        r103 = z98.b.e.f571046b;
        goto L335
    L139:
        if ((r110 instanceof z98.a.c) == false) goto L333;
        r103 = z98.b.d.f571045b;
        goto L335
    L142:
        if ((r100 instanceof z98.b.a) == false) goto L165;
        if ((r110 instanceof z98.a.h) == false) goto L147;
        r103 = z98.b.i.f571050b;
        goto L335
    L147:
        if ((r110 instanceof z98.a.m) == false) goto L150;
        r103 = z98.b.n.f571055b;
        goto L335
    L150:
        if ((r110 instanceof z98.a.e) == false) goto L153;
        r103 = z98.b.f.f571047b;
        goto L335
    L153:
        if ((r110 instanceof z98.a.k) == false) goto L156;
        r103 = z98.b.l.f571053b;
        goto L335
    L156:
        if ((r110 instanceof z98.a.b) == false) goto L159;
        r103 = z98.b.c.f571044b;
        goto L335
    L159:
        if ((r110 instanceof z98.a.d) == false) goto L162;
        r103 = z98.b.e.f571046b;
        goto L335
    L162:
        if ((r110 instanceof z98.a.c) == false) goto L333;
        r103 = z98.b.d.f571045b;
        goto L335
    L165:
        if ((r100 instanceof z98.b.n) == false) goto L188;
        if ((r110 instanceof z98.a.h) == false) goto L170;
        r103 = z98.b.i.f571050b;
        goto L335
    L170:
        if ((r110 instanceof z98.a.b) == false) goto L173;
        r103 = z98.b.c.f571044b;
        goto L335
    L173:
        if ((r110 instanceof z98.a.e) == false) goto L176;
        r103 = z98.b.f.f571047b;
        goto L335
    L176:
        if ((r110 instanceof z98.a.k) == false) goto L179;
        r103 = z98.b.l.f571053b;
        goto L335
    L179:
        if ((r110 instanceof z98.a.C8433a) == false) goto L182;
        r103 = z98.b.a.f571042b;
        goto L335
    L182:
        if ((r110 instanceof z98.a.d) == false) goto L185;
        r103 = z98.b.e.f571046b;
        goto L335
    L185:
        if ((r110 instanceof z98.a.c) == false) goto L333;
        r103 = z98.b.d.f571045b;
        goto L335
    L188:
        if ((r100 instanceof z98.b.f) == false) goto L211;
        if ((r110 instanceof z98.a.h) == false) goto L193;
        r103 = z98.b.i.f571050b;
        goto L335
    L193:
        if ((r110 instanceof z98.a.b) == false) goto L196;
        r103 = z98.b.c.f571044b;
        goto L335
    L196:
        if ((r110 instanceof z98.a.m) == false) goto L199;
        r103 = z98.b.n.f571055b;
        goto L335
    L199:
        if ((r110 instanceof z98.a.k) == false) goto L202;
        r103 = z98.b.l.f571053b;
        goto L335
    L202:
        if ((r110 instanceof z98.a.C8433a) == false) goto L205;
        r103 = z98.b.a.f571042b;
        goto L335
    L205:
        if ((r110 instanceof z98.a.d) == false) goto L208;
        r103 = z98.b.e.f571046b;
        goto L335
    L208:
        if ((r110 instanceof z98.a.c) == false) goto L333;
        r103 = z98.b.d.f571045b;
        goto L335
    L211:
        if ((r100 instanceof z98.b.h) == false) goto L234;
        if ((r110 instanceof z98.a.h) == false) goto L216;
        r103 = z98.b.i.f571050b;
        goto L335
    L216:
        if ((r110 instanceof z98.a.b) == false) goto L219;
        r103 = z98.b.c.f571044b;
        goto L335
    L219:
        if ((r110 instanceof z98.a.m) == false) goto L222;
        r103 = z98.b.n.f571055b;
        goto L335
    L222:
        if ((r110 instanceof z98.a.k) == false) goto L225;
        r103 = z98.b.l.f571053b;
        goto L335
    L225:
        if ((r110 instanceof z98.a.C8433a) == false) goto L228;
        r103 = z98.b.a.f571042b;
        goto L335
    L228:
        if ((r110 instanceof z98.a.d) == false) goto L231;
        r103 = z98.b.e.f571046b;
        goto L335
    L231:
        if ((r110 instanceof z98.a.c) == false) goto L333;
        r103 = z98.b.d.f571045b;
        goto L335
    L234:
        if ((r100 instanceof z98.b.c) == false) goto L257;
        if ((r110 instanceof z98.a.h) == false) goto L239;
        r103 = z98.b.i.f571050b;
        goto L335
    L239:
        if ((r110 instanceof z98.a.m) == false) goto L242;
        r103 = z98.b.n.f571055b;
        goto L335
    L242:
        if ((r110 instanceof z98.a.e) == false) goto L245;
        r103 = z98.b.f.f571047b;
        goto L335
    L245:
        if ((r110 instanceof z98.a.k) == false) goto L248;
        r103 = z98.b.l.f571053b;
        goto L335
    L248:
        if ((r110 instanceof z98.a.C8433a) == false) goto L251;
        r103 = z98.b.a.f571042b;
        goto L335
    L251:
        if ((r110 instanceof z98.a.d) == false) goto L254;
        r103 = z98.b.e.f571046b;
        goto L335
    L254:
        if ((r110 instanceof z98.a.c) == false) goto L333;
        r103 = z98.b.d.f571045b;
        goto L335
    L257:
        if ((r100 instanceof z98.b.C8434b) == false) goto L283;
        if ((r110 instanceof z98.a.m) == false) goto L262;
        r103 = z98.b.n.f571055b;
        goto L335
    L262:
        if ((r110 instanceof z98.a.b) == false) goto L265;
        r103 = z98.b.c.f571044b;
        goto L335
    L265:
        if ((r110 instanceof z98.a.k) == false) goto L268;
        r103 = z98.b.l.f571053b;
        goto L335
    L268:
        if ((r110 instanceof z98.a.C8433a) == false) goto L271;
        r103 = z98.b.a.f571042b;
        goto L335
    L271:
        if ((r110 instanceof z98.a.l) == false) goto L274;
        r103 = z98.b.m.f571054b;
        goto L335
    L274:
        if ((r110 instanceof z98.a.h) == false) goto L277;
        r103 = z98.b.i.f571050b;
        goto L335
    L277:
        if ((r110 instanceof z98.a.c) == false) goto L280;
        r103 = z98.b.d.f571045b;
        goto L335
    L280:
        if ((r110 instanceof z98.a.d) == false) goto L333;
        r103 = z98.b.e.f571046b;
        goto L335
    L283:
        if ((r100 instanceof z98.b.j) == false) goto L300;
        if ((r110 instanceof z98.a.f) == false) goto L288;
        r103 = z98.b.g.f571048b;
        goto L335
    L288:
        if ((r110 instanceof z98.a.c) == false) goto L291;
        r103 = z98.b.d.f571045b;
        goto L335
    L291:
        if ((r110 instanceof z98.a.i) == false) goto L294;
        r103 = z98.b.e.f571046b;
        goto L335
    L294:
        if ((r110 instanceof z98.a.h) == false) goto L297;
        r103 = z98.b.i.f571050b;
        goto L335
    L297:
        if ((r110 instanceof z98.a.d) == false) goto L333;
        r103 = z98.b.e.f571046b;
        goto L335
    L300:
        if ((r100 instanceof z98.b.g) == false) goto L311;
        if ((r110 instanceof z98.a.h) == false) goto L305;
        r103 = z98.b.i.f571050b;
        goto L335
    L305:
        if ((r110 instanceof z98.a.c) == false) goto L308;
        r103 = z98.b.d.f571045b;
        goto L335
    L308:
        if ((r110 instanceof z98.a.d) == false) goto L333;
        r103 = z98.b.e.f571046b;
        goto L335
    L311:
        if ((r100 instanceof z98.b.d) == false) goto L333;
        if ((r110 instanceof z98.a.h) == false) goto L316;
        r103 = z98.b.i.f571050b;
        goto L335
    L316:
        if ((r110 instanceof z98.a.m) == false) goto L319;
        r103 = z98.b.n.f571055b;
        goto L335
    L319:
        if ((r110 instanceof z98.a.e) == false) goto L322;
        r103 = z98.b.f.f571047b;
        goto L335
    L322:
        if ((r110 instanceof z98.a.b) == false) goto L325;
        r103 = z98.b.c.f571044b;
        goto L335
    L325:
        if ((r110 instanceof z98.a.k) == false) goto L328;
        r103 = z98.b.l.f571053b;
        goto L335
    L328:
        if ((r110 instanceof z98.a.C8433a) == false) goto L331;
        r103 = z98.b.a.f571042b;
        goto L335
    L331:
        if ((r110 instanceof z98.a.d) == false) goto L333;
        r103 = z98.b.e.f571046b;
        goto L335
    }

    public final void k6(final int r100) {
        com.larus.utils.t0.e(new r(this, r100));
    }

    public final void setLifecycleOwner(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f292847c = r100;
        if (r100 == null) goto L7;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r100);
        if (r101 == null) goto L7;
        BuildersKt.launch$default(r101, null, null, new AlbumSyncBanner$observeStateChanges$1(this, null), 3, null);
    L7:
        r100.getLifecycle().addObserver(new AnonymousClass1(this));
    }

    public final void setOverrideBackground(final int r100) {
        this.f292853i = Integer.valueOf(r100);
        com.larus.utils.t0.e(new m(this, r100));
    }

    public final void setOverrideTextColor(final int r100) {
        this.f292854j = Integer.valueOf(r100);
        this.f292855k = Integer.valueOf(r100);
        com.larus.utils.t0.e(new g(this, r100));
    }

    public final void setSyncActionHandler(b r100) {
        this.f292848d = r100;
    }

    public static void R5(AlbumSyncBanner r100, int r101) {
        r100.f292845a.f293267f.setTextColor(ContextCompat.getColor(r100.getContext(), r101));
        y r102 = (y) r100.f292846b.f532137b.getValue();
        if (r102.f293053h == true) goto L5;
    L7:
        r100.setStaticDrawable(r102.f293048c);
        return;
    L5:
        if (r102.f293048c != R.drawable.larus_ic_album_real_sync) goto L7;
        r100.c6();
    }

    public static final void S5(final AlbumSyncBanner r100, final y r101) {
        r100.getClass();
        int r102 = 8;
        boolean r103 = false;
        if (r101.f293046a == false) goto L5;
        int r104 = 0;
    L6:
        r100.setVisibility(r104);
        r100.f292845a.f293267f.setText(r101.f293047b);
        TextView r105 = r100.f292845a.f293267f;
        Context r106 = r100.getContext();
        Integer r107 = r100.f292854j;
        if (r107 == null) goto L9;
        int r108 = r107.intValue();
    L10:
        r105.setTextColor(ContextCompat.getColor(r106, r108));
        if (r101.f293053h == true) goto L13;
    L15:
        r100.setStaticDrawable(r101.f293048c);
    L16:
        ConstraintLayout r109 = r100.f292845a.f293262a;
        Integer r110 = r100.f292853i;
        if (r110 == null) goto L19;
        int r111 = r110.intValue();
    L20:
        r109.setBackgroundResource(r111);
        if (r101.f293052g == false) goto L23;
        com.larus.utils.e1.x(r100.f292845a.f293264c);
    L24:
        com.larus.utils.e1.d(r100.f292845a.f293264c, new k(r100));
        TextView r112 = r100.f292845a.f293263b;
        r112.setText(r101.f293051f);
        if (r101.f293051f.length() <= 0) goto L27;
        boolean r113 = true;
    L28:
        if (r113 == false) goto L30;
        r102 = 0;
    L30:
        r112.setVisibility(r102);
        r112.setOnClickListener(null);
        if (r101.f293051f.length() <= 0) goto L33;
        r103 = true;
    L33:
        if (r103 == false) goto L36;
        com.larus.utils.e1.d(r112, new l(r101));
        return;
    L36:
        return;
    L27:
        r113 = false;
        goto L28
    L23:
        com.larus.utils.e1.o(r100.f292845a.f293264c);
        goto L24
    L19:
        r111 = r101.f293049d;
        goto L20
    L13:
        if (r101.f293048c != R.drawable.larus_ic_album_real_sync) goto L15;
        r100.c6();
        goto L16
    L9:
        r108 = r101.f293050e;
        goto L10
    L5:
        r104 = 8;
        goto L6
    }

    public final void n6(z98.b r100, z98.a r101) {
        if ((r100 instanceof z98.b.e) == false) goto L6;
        com.larus.utils.t0.e(new q(this));
        return;
    L6:
        if ((r100 instanceof z98.b.i) == false) goto L11;
        if ((r101 instanceof z98.a.h) == false) goto L51;
        z98.a.h r102 = (z98.a.h) r101;
        Z5(0, Integer.valueOf(r102.f571033b), Integer.valueOf(r102.f571034c));
        return;
    L51:
        return;
    L11:
        if ((r100 instanceof z98.b.n) == false) goto L14;
        Z5(5, 0, 0);
        return;
    L14:
        if ((r100 instanceof z98.b.c) == false) goto L17;
        Z5(8, 0, 0);
        return;
    L17:
        if ((r100 instanceof z98.b.l) == false) goto L20;
        Z5(4, 0, 0);
        return;
    L20:
        if ((r100 instanceof z98.b.a) == false) goto L23;
        Z5(9, 0, 0);
        return;
    L23:
        if ((r100 instanceof z98.b.m) == false) goto L26;
        Z5(1, 0, 0);
        return;
    L26:
        if ((r100 instanceof z98.b.k) == false) goto L29;
        Z5(2, 0, 0);
        return;
    L29:
        if ((r100 instanceof z98.b.f) == false) goto L32;
        Z5(10, 0, 0);
        return;
    L32:
        if ((r100 instanceof z98.b.h) == false) goto L35;
        Z5(11, 0, 0);
        return;
    L35:
        if ((r100 instanceof z98.b.j) == false) goto L38;
        Z5(3, 0, 0);
        return;
    L38:
        if ((r100 instanceof z98.b.g) == false) goto L41;
        Z5(7, 0, 0);
        return;
    L41:
        if ((r100 instanceof z98.b.C8434b) == false) goto L44;
        Z5(6, 0, 0);
        return;
    L44:
        if ((r100 instanceof z98.b.d) == true) goto L46;
        FLogger.f375446a.w("AlbumSyncBanner", "Unhandled state: " + r100);
        return;
    L46:
        if (b6() == true) goto L64;
        i6();
        this.f292846b.a();
        com.larus.utils.e1.o(this.f292845a.f293266e);
        return;
    }

    public AlbumSyncBanner(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_page_album_sync_banner, this, false);
        int r103 = R.id.album_sync_banner_btn;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.album_sync_banner_btn);
        if (r104 == null) goto L23;
        r103 = R.id.banner_close;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.banner_close);
        if (r105 == null) goto L23;
        r103 = R.id.banner_divider;
        View r106 = ViewBindings.findChildViewById(r102, R.id.banner_divider);
        if (r106 == null) goto L23;
        r103 = R.id.progress_bar;
        ProgressBar r107 = (ProgressBar) ViewBindings.findChildViewById(r102, R.id.progress_bar);
        if (r107 == null) goto L23;
        r103 = R.id.title_text;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.title_text);
        if (r108 == null) goto L23;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        this.f292845a = new LarusPageAlbumSyncBannerBinding(r109, r104, r105, r106, r107, r108);
        this.f292846b = new q98.a();
        this.f292849e = kotlinx.coroutines.flow.j1.a(z98.b.e.f571046b);
        this.f292857m = new c(this);
        addView(r109);
        LifecycleOwner r111 = this.f292847c;
        Drawable r112 = null;
        if (r111 == null) goto L17;
        LifecycleCoroutineScope r113 = LifecycleOwnerKt.getLifecycleScope(r111);
        if (r113 == null) goto L17;
        BuildersKt.launch$default(r113, null, null, new AlbumSyncBanner$observeStateChanges$1(this, null), 3, null);
    L17:
        Drawable r114 = ContextCompat.getDrawable(getContext(), R.drawable.larus_ic_album_real_sync);
        if (r114 == null) goto L20;
        r112 = r114.mutate();
    L20:
        this.f292852h = r112;
        RotateDrawable r115 = new RotateDrawable();
        r115.setDrawable(this.f292852h);
        r115.setFromDegrees(0.0f);
        r115.setToDegrees(360.0f);
        r115.setPivotXRelative(true);
        r115.setPivotYRelative(true);
        r115.setPivotX(0.5f);
        r115.setPivotY(0.5f);
        this.f292851g = r115;
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public final void Z5(@GalleryState int r110, Integer r111, Integer r112) {
        switch(r110) {
            case -1: goto L54;
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L70;
        };
    L5:
        GalleryMobHelper.e(GalleryMobHelper.f293006a, 6);
        U5();
        Y5(this, getContext().getString(R.string.larus_dora_g_record_sync_forbidden_cn), "", 0, 0, 0, true, false, null, 220);
        return;
    L6:
        GalleryMobHelper.e(GalleryMobHelper.f293006a, 5);
        U5();
        Y5(this, getContext().getString(R.string.larus_dora_album_lowpower_cn), "", 0, 0, 0, true, false, null, 220);
        return;
    L7:
        U5();
        GalleryMobHelper.e(GalleryMobHelper.f293006a, 6);
        Y5(this, getContext().getString(R.string.larus_dora_album_close_ap_cn), "", 0, 0, 0, true, false, null, 220);
        return;
    L8:
        GalleryMobHelper.e(GalleryMobHelper.f293006a, 3);
        U5();
        Y5(this, getContext().getString(R.string.larus_dora_album_gps_off), "", 0, 0, 0, true, false, null, 220);
        return;
    L9:
        U5();
        Y5(this, getContext().getString(R.string.larus_dora_album_sync_banner_title), getContext().getString(R.string.larus_dora_album_go_authorize_cn), 0, 0, 0, false, false, new p(this), 124);
        return;
    L10:
        GalleryMobHelper.e(GalleryMobHelper.f293006a, 4);
        U5();
        Y5(this, getContext().getString(R.string.larus_dora_album_connection_lost_cn), "", 0, 0, 0, true, false, null, 220);
        return;
    L11:
        U5();
        GalleryMobHelper.e(GalleryMobHelper.f293006a, 1);
        Y5(this, getContext().getString(R.string.larus_dora_album_enable_wifi_cn), getContext().getString(R.string.larus_dora_album_banner_open_wifi), 0, 0, 0, true, false, new o(this), 92);
        return;
    L12:
        U5();
        GalleryMobHelper.e(GalleryMobHelper.f293006a, 2);
        Y5(this, getContext().getString(R.string.larus_dora_album_close_vpn_cn), "", 0, 0, 0, true, false, null, 220);
        return;
    L13:
        FLogger.f375446a.i("zhstest", "trans complete");
        k6(100);
        Y5(this, getContext().getString(R.string.larus_dora_album_transfer_completed_cn), "", R.color.larus_base_1, R.drawable.larus_ic_album_success, R.color.larus_neutral_70, false, false, null, 224);
        return;
    L14:
        Y5(this, getContext().getString(R.string.larus_dora_album_transferring_cn), "", R.color.larus_base_1, R.drawable.larus_ic_album_real_sync, R.color.larus_neutral_70, false, true, null, 160);
        return;
    L15:
        FLogger.f375446a.i("AlbumSyncBanner", "change text: WIFI_CONNECTING");
        Y5(this, getContext().getString(R.string.larus_dora_album_connecting_device_cn), "", R.color.larus_base_1, R.drawable.larus_ic_album_real_sync, R.color.larus_neutral_70, false, true, null, 160);
        return;
    L16:
        U5();
        int r100 = 0;
        if (r111 != null) goto L20;
    L31:
        if (r112 != null) goto L34;
    L44:
        Context r101 = getContext();
        Object[] r102 = new Object[2];
        if (r111 == null) goto L47;
        int r103 = r111.intValue();
    L48:
        r102[0] = Integer.valueOf(r103);
        if (r112 == null) goto L51;
        r100 = r112.intValue();
    L51:
        r102[1] = Integer.valueOf(r100);
        String r104 = r101.getString(R.string.larus_dora_album_sync_banner_diff, r102);
    L30:
        String r105 = r104;
        Intrinsics.checkNotNull(r105);
        Y5(this, r105, getContext().getString(R.string.larus_dora_album_to_sync_cn), R.color.larus_base_1, R.drawable.larus_ic_album_real_sync, R.color.larus_neutral_70, false, false, new n(this), 96);
        return;
    L47:
        r103 = 0;
        goto L48
    L34:
        if (r112.intValue() != 0) goto L44;
        if (r111 != null) goto L38;
    L39:
        Context r106 = getContext();
        Object[] r107 = new Object[1];
        if (r111 == null) goto L42;
        int r108 = r111.intValue();
    L43:
        r107[0] = Integer.valueOf(r108);
        r104 = r106.getString(R.string.larus_dora_album_sync_banner_photo_only, r107);
        goto L30
    L42:
        r108 = 0;
        goto L43
    L38:
        if (r111.intValue() == 0) goto L44;
    L20:
        if (r111.intValue() != 0) goto L31;
        if (r112 != null) goto L24;
    L25:
        Context r109 = getContext();
        Object[] r113 = new Object[1];
        if (r112 == null) goto L28;
        int r114 = r112.intValue();
    L29:
        r113[0] = Integer.valueOf(r114);
        r104 = r109.getString(R.string.larus_dora_album_sync_banner_video_only, r113);
        goto L30
    L28:
        r114 = 0;
        goto L29
    L24:
        if (r112.intValue() == 0) goto L31;
    L70:
        return;
    L54:
        if (b6() == true) goto L69;
        i6();
        this.f292846b.a();
        com.larus.utils.e1.o(this.f292845a.f293266e);
        return;
    }

    public /* synthetic */ AlbumSyncBanner(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void Y5(AlbumSyncBanner r110, String r111, String r112, int r113, int r114, int r115, boolean r116, boolean r117, Function0 r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = r110.getContext().getString(R.string.larus_dora_album_sync_banner_title);
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.getContext().getString(R.string.larus_dora_album_to_sync_cn);
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r102 = R.color.larus_additional_orange;
    L15:
        if ((r211 & 8) == 0) goto L17;
        int r103 = R.drawable.larus_ic_album_sync;
    L19:
        if ((r211 & 16) == 0) goto L21;
        int r104 = R.color.larus_additional_brown;
    L22:
        boolean r105 = false;
        if ((r211 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r211 & 64) != 0) goto L31;
        r105 = r117;
    L31:
        if ((r211 & 128) == 0) goto L33;
        Function0 r107 = new h();
    L34:
        q98.a r108 = r110.f292846b;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "buttonText");
        Intrinsics.checkNotNullParameter(r107, "onButtonClick");
        StateFlowImpl r109 = r108.f532136a;
    L35:
        Object r118 = r109.getValue();
        ((y) r118).getClass();
        if (r109.compareAndSet(r118, y.a(true, r100, r103, r102, r104, r101, r106, r105, r107)) == false) goto L35;
        return;
    L33:
        r107 = r210;
        goto L34
    L25:
        r106 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
