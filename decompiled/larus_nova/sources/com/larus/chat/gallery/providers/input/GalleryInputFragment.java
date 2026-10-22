package com.larus.chat.gallery.providers.input;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 |2\u00020\u0001:\u0001|B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010:\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J&\u0010=\u001a\u0004\u0018\u00010\u00072\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010B\u001a\u000207H\u0002J\u001a\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0018\u0010E\u001a\u0002072\u0006\u0010>\u001a\u00020?2\u0006\u0010F\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u000207H\u0002J\u0015\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020\u000bH\u0000¢\u0006\u0002\bJJ\u001d\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u001fH\u0000¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u0002072\u0006\u0010P\u001a\u00020\u000bH\u0000¢\u0006\u0002\bQJ\u0010\u0010R\u001a\u0002072\u0006\u0010P\u001a\u00020\u000bH\u0002J\b\u0010S\u001a\u000207H\u0016J\b\u0010T\u001a\u000207H\u0002J\b\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u00020\u000bH\u0002J\b\u0010W\u001a\u00020\u0011H\u0002J\b\u0010X\u001a\u000207H\u0002J\b\u0010Y\u001a\u000207H\u0002J\u0010\u0010Z\u001a\u0002072\u0006\u0010[\u001a\u00020#H\u0002J\u0018\u0010\\\u001a\u0002072\u0006\u0010[\u001a\u00020#2\u0006\u0010]\u001a\u00020\u0011H\u0002J%\u0010^\u001a\u0002072\n\b\u0002\u0010[\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010`J\u0012\u0010a\u001a\u00020\u00112\b\b\u0002\u0010b\u001a\u00020\u0011H\u0002J\b\u0010c\u001a\u00020\u0011H\u0002J\f\u0010b\u001a\u00020\u0011*\u00020#H\u0002J\u001a\u0010d\u001a\u0002072\u0006\u0010e\u001a\u00020\u000b2\b\b\u0002\u0010f\u001a\u00020\u000bH\u0002J\u000f\u0010g\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010hJ\b\u0010i\u001a\u000207H\u0002J\b\u0010j\u001a\u00020\u0011H\u0002J\u0010\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u0011H\u0002J\b\u0010n\u001a\u000207H\u0016J\b\u0010o\u001a\u000207H\u0016J\r\u0010p\u001a\u000207H\u0000¢\u0006\u0002\bqJ\b\u0010r\u001a\u000207H\u0002J\b\u0010s\u001a\u000207H\u0002J*\u0010t\u001a\u0002072\u0006\u0010u\u001a\u00020\u000b2\b\b\u0002\u0010v\u001a\u00020\u000b2\u0010\b\u0002\u0010w\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106J\u000e\u0010x\u001a\u0002072\u0006\u0010y\u001a\u00020\u000bJ\u0010\u0010z\u001a\u0002072\b\u0010{\u001a\u0004\u0018\u000109R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u001b\u00100\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/larus/chat/gallery/providers/input/GalleryInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "cameraContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "rootView", "Landroid/view/View;", "pageUploadedImageProvider", "Lcom/larus/chat/gallery/impl/providers/input/GalleryPageUploadedImageProvider;", "imeShowingOnStart", "", "imeShowingStatusConsumed", "windowManager", "Landroid/view/WindowManager;", "interceptorView", "preHeight", "", "globalListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "contentView", "isImeShowing", "ignoreImeInsetsForNavigation", "localMediaBottomController", "Lcom/larus/chat/gallery/providers/input/LocalMediaBottomViewController;", "previewSuggestedActionArea", "previewInputContainer", "restingInputHeight", "previewAudioInputActive", "previewSuggestedActionsAvailable", "restingInputHeightSettlingUntil", "", "previewImeAnimation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "previewTargetInsets", "Landroidx/core/view/WindowInsetsCompat;", "inputLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "updatePreviewLayoutRunnable", "Ljava/lang/Runnable;", "updatePreviewInterceptorRunnable", "respectImeVisibility", "getRespectImeVisibility", "()Z", "prepareForNavigationEnabled", "getPrepareForNavigationEnabled", "useBurstResultSugLayout", "getUseBurstResultSugLayout", "originBottomMargin", "getOriginBottomMargin", "()I", "originBottomMargin$delegate", "Lkotlin/Lazy;", "updateInterceptRunnable", "Lkotlin/Function0;", "", "logTag", "", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "attachComponents", "onViewCreated", "view", "createPreviewSuggestedActionLayer", RootDescription.ROOT_ELEMENT, "updatePreviewSuggestedActionLayout", "setPreviewSuggestedActionsAvailable", "available", "setPreviewSuggestedActionsAvailable$impl_mainlandRelease", "onInputHeightWillChange", "deltaPx", "durationMs", "onInputHeightWillChange$impl_mainlandRelease", "setPreviewAudioInputActive", "active", "setPreviewAudioInputActive$impl_mainlandRelease", "setPreviewImeActive", WidgetCostModule.TYPE_ON_START, "watchOnImeStatus", "watchOnGlobalLayout", "isImeVisible", "getDecorViewInvisibleHeight", "watchOnInsetsAnimation", "watchOnPreviewInsetsAnimation", "applyPreviewSettledInsets", "insets", "applyPreviewBottomPadding", "imeBottom", "updateBottomPadding", "imeBottomInset", "(Landroidx/core/view/WindowInsetsCompat;Ljava/lang/Integer;)V", "minimumBottomPadding", "navigationInset", "currentNavigationInset", "updateInterceptorView", "isImeShow", "needSetExternalImeFunc", "previewInterceptorHeight", "()Ljava/lang/Integer;", "updatePreviewInterceptorBounds", "getInterceptorTopOffset", "getLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "h", "onDestroyView", "onStop", "prepareInsetsForNavigation", "prepareInsetsForNavigation$impl_mainlandRelease", "restoreRestingInsets", "removeImeInterceptView", "showLocalMediaBottom", "show", "enableSave", "onSaveClick", "setLocalMediaSaveLoading", "loading", "updatePageImageUrl", "url", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryInputFragment extends Fragment {
    public static final /* synthetic */ int D = 0;
    public final Lazy A;
    public final v B;
    public final String C;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f324863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zy8.r f324864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f324865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f324866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WindowManager f324867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f324868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f324869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l f324870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f324871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f324872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f324873n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h0 f324874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f324875p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f324876q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f324877r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f324878s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f324879t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f324880u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WindowInsetsAnimationCompat f324881v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WindowInsetsCompat f324882w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final r f324883x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s f324884y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final t f324885z;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryInputFragment f324886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f324887b;

        public b(GalleryInputFragment r100, View r101) {
            this.f324886a = r100;
            this.f324887b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            GalleryInputFragment.ia0(this.f324886a, ViewCompat.getRootWindowInsets(this.f324887b), null, 2);
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryInputFragment f324888a;

        public c(GalleryInputFragment r100) {
            this.f324888a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            GalleryInputFragment r109 = this.f324888a;
            int r110 = GalleryInputFragment.D;
            r109.la0();
        }
    }

    static {
    }

    public final void ea0() {
        ja0(false, false);
        fa0(false);
        ia0(this, null, 0, 1);
    }

    public final int V90() {
        View r100 = this.f324863d;
        if (r100 == null) goto L7;
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        if (r101 == null) goto L7;
        return r101.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L7:
        return 0;
    }

    public final int X90() {
        return ((Number) this.A.getValue()).intValue();
    }

    public final Integer ca0() {
        View r100 = this.f324876q;
        if (r100 != null) goto L5;
    L21:
        return null;
    L5:
        if (r100.isAttachedToWindow() == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L21;
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        int r103 = r102[1];
        if (Build.VERSION.SDK_INT >= 30) goto L18;
        int r104 = 0;
    L20:
        return Integer.valueOf(RangesKt.coerceAtLeast(r103 - r104, 0));
    L18:
        i0.f375410a.getClass();
        r104 = i0.g();
        goto L20
    L7:
        if (r100.getHeight() <= 0) goto L9;
        r101 = true;
        goto L10
    }

    public final void da0() {
        View r100 = this.f324868i;
        Unit r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L6:
        if (r102 != null) goto L19;
        return;
    L19:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        WindowManager r104 = this.f324867h;     // Catch: Throwable -> L13
        if (r104 == null) goto L11;
        r104.removeViewImmediate(this.f324868i);     // Catch: Throwable -> L13
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r105 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L13
    L15:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        FLogger.f375446a.e(this.C, "removeWindowView failed throwable=" + r106 + ", message=" + r106.getMessage());
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public final void ka0() {
        View r100 = this.f324868i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getParent() == null) goto L7;
        boolean r101 = true;
    L8:
        Unit r102 = null;
        if (r101 == true) goto L12;
        r100 = null;
    L12:
        if (r100 == null) goto L42;
        Integer r103 = ca0();
        if (r103 == null) goto L40;
        int r104 = r103.intValue();
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof WindowManager.LayoutParams) == false) goto L19;
        WindowManager.LayoutParams r106 = (WindowManager.LayoutParams) r105;
    L20:
        if (r106 != null) goto L23;
        return;
    L23:
        if (r106.height != r104) goto L25;
        return;
    L25:
        r106.height = r104;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L31
        WindowManager r108 = this.f324867h;     // Catch: Throwable -> L31
        if (r108 == null) goto L29;
        r108.updateViewLayout(r100, r106);     // Catch: Throwable -> L31
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Object r109 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L31
    L33:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L41;
        FLogger.f375446a.e(this.C, "updateWindowView failed throwable=" + r110);
        return;
    L41:
        return;
    L31:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L19:
        r106 = null;
        goto L20
    L40:
        return;
    L42:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void la0() {
        View r100 = this.f324875p;
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = this.f324876q;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f324872m == false) goto L11;
    L19:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L22;
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
    L23:
        int r104 = 0;
        if (r103 == null) goto L29;
        int r105 = RangesKt.coerceAtLeast(this.f324877r - i5.h(), 0);
        if (r103.bottomMargin == r105) goto L29;
        r103.bottomMargin = r105;
        r100.setLayoutParams(r103);
    L29:
        if (Z90() == false) goto L31;
        int r106 = V90() + i5.h();
    L32:
        View r107 = this.f324863d;
        if (r107 == null) goto L35;
        int r108 = r107.getPaddingBottom();
    L36:
        r100.setTranslationY(RangesKt.coerceAtLeast(r108 - r106, 0));
        if (this.f324879t == true) goto L40;
        r104 = 8;
    L44:
        r100.setVisibility(r104);
        return;
    L40:
        if (this.f324878s == false) goto L42;
    L43:
        r104 = 4;
        goto L44
    L42:
        if (this.f324877r != 0) goto L44;
    L35:
        r108 = 0;
        goto L36
    L31:
        r106 = X90();
        goto L32
    L22:
        r103 = null;
        goto L23
    L11:
        if (this.f324881v != null) goto L19;
        if (this.f324878s == true) goto L19;
        if (r101.getHeight() <= 0) goto L19;
        if (SystemClock.uptimeMillis() < this.f324880u) goto L19;
        this.f324877r = r101.getHeight();
        goto L19
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.chat.gallery.providers.input.r] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.chat.gallery.providers.input.s] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.chat.gallery.providers.input.t] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.chat.gallery.providers.input.v] */
    public GalleryInputFragment() {
        this.f324864e = new zy8.r();
        this.f324883x = new r(this);
        this.f324884y = new s(this);
        this.f324885z = new t(this);
        this.A = LazyKt.lazy(new u(this));
        this.B = new v(this);
        this.C = "GalleryInputFragment";
    }

    public final int W90() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L15;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L17;
        View r102 = S90(r101);
        if (r102 == null) goto L18;
        Rect r103 = new Rect();
        r102.getWindowVisibleDisplayFrame(r103);
        int r104 = Math.abs(r102.getBottom() - r103.bottom);
        if (Z90() == false) goto L12;
        int r105 = V90() + i5.h();
    L14:
        return RangesKt.coerceAtLeast(r104, r105);
    L12:
        r105 = X90();
        goto L14
    L18:
        return 0;
    L17:
        return 0;
    L15:
        return 0;
    }

    public final boolean Y90() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getBoolean("prepare_for_navigation", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean Z90() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getBoolean("respect_ime_visibility", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean aa0() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getBoolean("use_burst_result_sug_layout", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean ba0() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L13;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L14;
        View r102 = S90(r101);
        if (r102 == null) goto L16;
        Rect r103 = new Rect();
        r102.getWindowVisibleDisplayFrame(r103);
        int r104 = r102.getHeight();
        if ((r104 - r103.height()) <= (((double) r104) * 0.15d)) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    L14:
        return false;
    L13:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        da0();
        View r100 = this.f324871l;
        if (r100 == null) goto L7;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L7;
        r101.removeOnGlobalLayoutListener(this.f324870k);
    L7:
        View r102 = this.f324863d;
        if (r102 == null) goto L15;
        r102.removeCallbacks(this.f324884y);
        r102.removeCallbacks(this.f324885z);
        r102.removeOnLayoutChangeListener(this.f324883x);
        if (Z90() == false) goto L12;
    L13:
        ViewCompat.setOnApplyWindowInsetsListener(r102, null);
    L14:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r102, null);
        goto L15
    L12:
        if (aa0() == false) goto L14;
    L15:
        this.f324874o = null;
        Handler r103 = t0.f375468a;
        final v r104 = this.B;
        r103.removeCallbacks(new com.larus.chat.gallery.providers.input.c(r104));
        View r105 = this.f324876q;
        if (r105 == null) goto L18;
        r105.removeCallbacks(this.f324884y);
    L18:
        View r106 = this.f324876q;
        if (r106 == null) goto L21;
        r106.removeOnLayoutChangeListener(this.f324883x);
    L21:
        this.f324876q = null;
        this.f324875p = null;
        this.f324877r = 0;
        this.f324880u = 0;
        this.f324879t = false;
        this.f324878s = false;
        this.f324881v = null;
        this.f324882w = null;
        this.f324872m = false;
        this.f324863d = null;
        this.f324871l = null;
        this.f324870k = null;
        this.f324868i = null;
        this.f324867h = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (Y90() == true) goto L5;
        return;
    L5:
        View r100 = this.f324863d;
        if (r100 == null) goto L9;
        r100.post(new d(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        if (Y90() == false) goto L8;
        com.larus.chat.gallery.providers.input.a r100 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(this).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r100 == null) goto L9;
        r100.at();
        return;
    L9:
        return;
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void U90(WindowInsetsCompat r100) {
        int r101 = 0;
        if (r100.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f324872m = r102;
        fa0(r102);
        if (this.f324872m == false) goto L11;
        r101 = r100.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L11:
        T90(r100, r101);
        View r103 = this.f324863d;
        if (r103 == null) goto L14;
        r103.removeCallbacks(this.f324885z);
    L14:
        View r104 = this.f324863d;
        if (r104 == null) goto L17;
        r104.post(this.f324885z);
    L17:
        View r105 = this.f324863d;
        if (r105 == null) goto L21;
        r105.post(this.f324884y);
        return;
    L21:
        return;
    L5:
        if (this.f324873n == true) goto L7;
        r102 = true;
        goto L8
    }

    public final void fa0(boolean r100) {
        View r101 = this.f324875p;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        float r102 = 0.5f;
    L7:
        r101.setAlpha(r102);
        return;
    L6:
        r102 = 1.0f;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        t1a.b r101 = s1a.a.g(this);
        de8.c r102 = de8.c.f468084s;
        r101.n(de8.c.a.a(getArguments()), de8.c.class);
        s1a.a.g(this).k(this.f324864e, Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.n.class));
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new n(this));
    }

    public final void T90(WindowInsetsCompat r100, int r101) {
        if (Z90() == false) goto L6;
        ha0(r100, Integer.valueOf(r101));
        return;
    L6:
        if (this.f324873n == false) goto L8;
        r101 = 0;
    L8:
        View r102 = this.f324863d;
        if (r102 == null) goto L11;
        r102.setPaddingRelative(0, 0, 0, RangesKt.coerceAtLeast(r101, X90()));
    L11:
        la0();
    }

    public final void ha0(WindowInsetsCompat r100, Integer r101) {
        Integer r102 = null;
        if (r100 != null) goto L8;
        View r103 = this.f324863d;
        if (r103 == null) goto L7;
        r100 = ViewCompat.getRootWindowInsets(r103);
        goto L8
    L7:
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        int r104 = r100.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L12:
        if (this.f324873n == true) goto L26;
        if (r101 == null) goto L16;
        int r105 = r101.intValue();
    L27:
        int r106 = Math.max(r104 + i5.h(), r105);
        View r107 = this.f324863d;
        if (r107 == null) goto L30;
        r107.setPaddingRelative(0, 0, 0, r106);
    L30:
        la0();
        return;
    L16:
        if (r100 != null) goto L18;
    L24:
        if (r102 == null) goto L26;
        r105 = r102.intValue();
        goto L27
    L18:
        if (Z90() == true) goto L20;
    L22:
        int r108 = r100.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L23:
        r102 = Integer.valueOf(r108);
        goto L24
    L20:
        if (r100.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L22;
        r108 = 0;
    L26:
        r105 = 0;
        goto L27
    L10:
        r104 = V90();
        goto L12
    }

    public final void ja0(boolean r100, boolean r101) {
        boolean r102 = true;
        if (r100 == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f324872m = r103;
        if (r103 == false) goto L93;
        Unit r104 = null;
        if (this.f324868i != null) goto L25;
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L15;
        Object r106 = r105.getSystemService(LiveEndPageData.TAG_WINDOW);
    L17:
        if ((r106 instanceof WindowManager) == false) goto L19;
        WindowManager r107 = (WindowManager) r106;
    L20:
        this.f324867h = r107;
        View r108 = new View(getContext());
        e1.d(r108, new g(this));
        this.f324868i = r108;
        if (r101 == false) goto L25;
        com.larus.chat.gallery.providers.input.a r109 = (com.larus.chat.gallery.providers.input.a) s1a.a.g(this).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r109 == null) goto L25;
        r109.i1(new h(this));
        goto L25
    L19:
        r107 = null;
        goto L20
    L15:
        r106 = null;
    L25:
        View r110 = this.f324868i;
        if (r110 == null) goto L29;
        r110.setClickable(true);
    L29:
        if (aa0() == false) goto L37;
        View r111 = this.f324868i;
        if (r111 == null) goto L33;
        ViewParent r112 = r111.getParent();
    L34:
        if (r112 == null) goto L37;
        ka0();
        return;
    L33:
        r112 = null;
    L37:
        View r113 = this.f324868i;
        if (r113 == null) goto L40;
        ViewParent r114 = r113.getParent();
    L41:
        if (r114 == null) goto L98;
        da0();
    L98:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L87
        if (aa0() == false) goto L49;
        Integer r116 = ca0();     // Catch: Throwable -> L87
        if (r116 == null) goto L48;
        int r117 = r116.intValue();     // Catch: Throwable -> L87
    L82:
        WindowManager r118 = this.f324867h;     // Catch: Throwable -> L87
        if (r118 == null) goto L85;
        View r119 = this.f324868i;     // Catch: Throwable -> L87
        int r120 = RangesKt.coerceAtLeast(r117, 0);     // Catch: Throwable -> L87
        WindowManager.LayoutParams r121 = new WindowManager.LayoutParams();     // Catch: Throwable -> L87
        r121.type = 2;     // Catch: Throwable -> L87
        r121.flags = 552;     // Catch: Throwable -> L87
        r121.format = -2;     // Catch: Throwable -> L87
        r121.gravity = 8388659;     // Catch: Throwable -> L87
        r121.width = -1;     // Catch: Throwable -> L87
        r121.height = r120;     // Catch: Throwable -> L87
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r119, r121);     // Catch: Throwable -> L87
        r118.addView(r119, r121);     // Catch: Throwable -> L87
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L87
    L85:
        Object r122 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L87
    L89:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L92;
        FLogger.f375446a.e(this.C, "addWindowView failed throwable=" + r123 + ", message=" + r123.getMessage());
    L92:
        Result.m9448boximpl(r122);
        return;
    L48:
        return;
    L49:
        View r124 = this.f324863d;     // Catch: Throwable -> L87
        if (r124 == null) goto L59;
        Integer r125 = Integer.valueOf(r124.getHeight());     // Catch: Throwable -> L87
        if (r125.intValue() <= 0) goto L54;
        boolean r126 = true;
    L55:
        if (r126 == true) goto L58;
        r125 = null;
    L58:
        if (r125 == null) goto L59;
    L63:
        if (r125 != null) goto L65;
    L73:
        View r127 = this.f324863d;     // Catch: Throwable -> L87
        if (r127 == null) goto L76;
        int r128 = r127.getPaddingBottom();     // Catch: Throwable -> L87
    L77:
        int r129 = m0.f375450a;     // Catch: Throwable -> L87
        int r130 = m0.a(getContext()) - r128;     // Catch: Throwable -> L87
        if (Build.VERSION.SDK_INT >= 30) goto L80;
        int r131 = 0;
    L81:
        r117 = r130 - r131;     // Catch: Throwable -> L87
        goto L82
    L80:
        i0.f375410a.getClass();     // Catch: Throwable -> L87
        r131 = i0.g();     // Catch: Throwable -> L87
        goto L81
    L76:
        r128 = 0;
        goto L77
    L65:
        if (r125.intValue() > 0) goto L68;
        r102 = false;
    L68:
        if (r102 == true) goto L71;
        r125 = null;
    L71:
        if (r125 == null) goto L73;
        r128 = r125.intValue();     // Catch: Throwable -> L87
        goto L77
    L54:
        r126 = false;
    L59:
        View r132 = this.f324863d;     // Catch: Throwable -> L87
        if (r132 == null) goto L62;
        r125 = Integer.valueOf(r132.getMeasuredHeight());     // Catch: Throwable -> L87
        goto L63
    L62:
        r125 = null;
    L87:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L89
    L40:
        r114 = null;
        goto L41
    L93:
        View r134 = this.f324868i;
        if (r134 == null) goto L96;
        r134.setClickable(false);
    L96:
        da0();
        return;
    L5:
        if (this.f324873n == true) goto L7;
        r103 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [com.larus.chat.gallery.providers.input.l] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (aa0() == false) goto L8;
        if (Build.VERSION.SDK_INT < 30) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r100, new e(this));
        ViewCompat.requestApplyInsets(r100);
    L19:
        if (r100.isLaidOut() == true) goto L21;
    L23:
        r100.addOnLayoutChangeListener(new c(this));
    L25:
        if (Build.VERSION.SDK_INT >= 30) goto L27;
        FLogger.f375446a.i(this.C, "watchOnGlobalLayout");
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L63;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L58;
        WindowManager.LayoutParams r104 = r103.getAttributes();
        if (r104 != null) goto L43;
        return;
    L43:
        if ((r104.flags & 512) != 0) goto L49;
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L49;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L49;
        r106.clearFlags(512);
    L49:
        this.f324871l = r102.findViewById(R.id.content);
        this.f324869j = W90();
        this.f324870k = new l(this);
        View r107 = this.f324871l;
        if (r107 == null) goto L60;
        ViewTreeObserver r108 = r107.getViewTreeObserver();
        if (r108 == null) goto L61;
        r108.addOnGlobalLayoutListener(this.f324870k);
        return;
    L61:
        return;
    L60:
        return;
    L58:
        return;
    L63:
        return;
    L27:
        if (aa0() == false) goto L32;
        final View r109 = this.f324863d;
        if (r109 == null) goto L62;
        ViewCompat.setWindowInsetsAnimationCallback(r109, new GalleryInputFragment$watchOnPreviewInsetsAnimation$1(this, r109));
        return;
    L62:
        return;
    L32:
        View r110 = this.f324863d;
        if (r110 == null) goto L56;
        ViewExtKt.l(r110, new i(this), null, new j(this), new k(this), 2);
        return;
    L56:
        return;
    L21:
        if (r100.isLayoutRequested() == true) goto L23;
        la0();
    L8:
        if (Z90() == false) goto L15;
        ViewCompat.setOnApplyWindowInsetsListener(r100, new f(this));
        ViewCompat.requestApplyInsets(r100);
        if (r100.isLaidOut() == true) goto L12;
    L14:
        r100.addOnLayoutChangeListener(new b(this, r100));
        goto L19
    L12:
        if (r100.isLayoutRequested() == true) goto L14;
        ia0(this, ViewCompat.getRootWindowInsets(r100), null, 2);
        goto L19
    L15:
        View r111 = this.f324863d;
        if (r111 == null) goto L19;
        r111.setPadding(0, 0, 0, X90());
        goto L19
    }

    public final void ga0(boolean r100, boolean r101, Function0<Unit> r102) {
        if (r100 == false) goto L7;
        h0 r103 = this.f324874o;
        if (r103 == null) goto L11;
        r103.f324920f = r101;
        r103.f324922h = r102;
        r103.f324918d.invoke();
        r103.f324919e.invoke();
        r103.f324915a.setVisibility(8);
        r103.f324916b.setVisibility(0);
        r103.a();
        return;
    L11:
        return;
    L7:
        h0 r104 = this.f324874o;
        if (r104 == null) goto L13;
        r104.f324921g = false;
        r104.f324922h = null;
        r104.f324915a.setVisibility(0);
        r104.f324916b.setVisibility(8);
        r104.a();
        return;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.chat.gallery.providers.input.x] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.chat.gallery.providers.input.y] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(com.larus.nova.R.layout.larus_layout_gallery_input_view, r111, false);
        ViewStub r100 = (ViewStub) r113.findViewById(com.larus.nova.R.id.input_delegate);
        InputViewCreatorDelegate r101 = InputViewCreatorDelegate.f298409b;
        Intrinsics.checkNotNull(r100);
        r101.a(r100, Integer.valueOf(com.larus.nova.R.id.input_delegate));
        if (aa0() == false) goto L14;
        Intrinsics.checkNotNull(r113);
        if ((r113 instanceof FrameLayout) == false) goto L7;
        FrameLayout r114 = (FrameLayout) r113;
    L8:
        if (r114 == null) goto L14;
        r114.setClipToPadding(false);
        View r102 = r113.findViewById(com.larus.nova.R.id.input);
        if (r102 == null) goto L14;
        View r115 = r110.inflate(com.larus.nova.R.layout.larus_layout_gallery_preview_suggested_action, r114, false);
        r114.addView(r115, 0, new FrameLayout.LayoutParams(-1, -2, 80));
        this.f324875p = r115;
        this.f324876q = r102;
        r102.addOnLayoutChangeListener(this.f324883x);
        r115.setVisibility(8);
        r114.addOnLayoutChangeListener(this.f324883x);
        r102.post(this.f324884y);
        goto L14
    L7:
        r114 = null;
    L14:
        this.f324874o = new h0(r113.findViewById(com.larus.nova.R.id.input), r113.findViewById(com.larus.nova.R.id.local_media_bottom_container), (CommonDownLoadLayout) r113.findViewById(com.larus.nova.R.id.local_media_save_button), new x(this), new y(this));
        this.f324863d = r113;
        return r113;
    }

    public static /* synthetic */ void ia0(GalleryInputFragment r100, WindowInsetsCompat r101, Integer r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.ha0(r101, r102);
    }
}
