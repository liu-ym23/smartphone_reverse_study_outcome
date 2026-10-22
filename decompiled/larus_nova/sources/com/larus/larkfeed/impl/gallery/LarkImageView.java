package com.larus.larkfeed.impl.gallery;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.larkfeed.impl.databinding.LarusSocialGalleryLarkImageViewBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002!2\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB=\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010'\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010(\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020&H\u0014J\b\u00100\u001a\u00020&H\u0014J\u0018\u00104\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208J\u001c\u00109\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u0001062\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\b\u0010<\u001a\u00020&H\u0002J\u0006\u0010=\u001a\u00020\u001aJ\u000e\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010BJ\u001e\u0010D\u001a\u00020&2\u0016\b\u0002\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020&\u0018\u00010FJ\n\u0010G\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010H\u001a\u00020&2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006P"}, d2 = {"Lcom/larus/larkfeed/impl/gallery/LarkImageView;", "Landroid/widget/FrameLayout;", "Lcom/larus/gallery/api/IGalleryCustomView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "mediaSecurityGuard", "Lcom/larus/larkfeed/impl/gallery/SocialGalleryMediaSecurityGuard;", "source", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/larkfeed/impl/gallery/SocialGalleryMediaSecurityGuard;Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;)V", "binding", "Lcom/larus/larkfeed/impl/databinding/LarusSocialGalleryLarkImageViewBinding;", "delegate", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuPreviewViewDelegate;", "originLoadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "contentView", "Landroid/view/View;", "onGalleryCustomViewListener", "Lcom/larus/gallery/api/GalleryCustomViewListener;", "isFullScreenMode", "", "isShowOtherView", "longPressTriggered", "gestureDetector", "Landroid/view/GestureDetector;", "isSecurityMasked", "callback", "com/larus/larkfeed/impl/gallery/LarkImageView$callback$1", "Lcom/larus/larkfeed/impl/gallery/LarkImageView$callback$1;", "getView", "getScalableView", "bindGalleryState", "", "refreshView", "setOnGalleryCustomViewListener", "listener", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "onAttachedToWindow", "onDetachedFromWindow", "loadDefaultListener", "com/larus/larkfeed/impl/gallery/LarkImageView$loadDefaultListener$1", "Lcom/larus/larkfeed/impl/gallery/LarkImageView$loadDefaultListener$1;", "bind", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "data", "Lcom/larus/gallery/api/GalleryData;", "bindPreviewContent", WsConstants.KEY_PAYLOAD, "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryImageItem;", "loadDefault", "isNeedShowOrigin", "startPhotoEdit", "activity", "Landroidx/fragment/app/FragmentActivity;", "isShowFileReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAnimatedImage", "loadOrigin", "onLoadResult", "Lkotlin/Function1;", "showOriginLoadingDialog", "dismissOriginLoadingDialog", "dialog", "applyPreviewState", "state", "Lcom/larus/larkfeed/impl/gallery/PreviewState;", "presentation", "Lcom/larus/larkfeed/impl/gallery/MediaSecurityPresentation;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkImageView extends FrameLayout implements com.larus.gallery.api.u {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f355169o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f355170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GallerySource f355171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusSocialGalleryLarkImageViewBinding f355172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kza.i f355173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.common_ui.dialog.l0 f355174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f355175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.larus.gallery.api.j f355176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f355177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f355178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f355179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final GestureDetector f355180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f355181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f355182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g f355183n;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355184a = null;

        static {
            int[] r100 = new int[PreviewState.values().length];
            r100[PreviewState.Allow.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PreviewState.Loading.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PreviewState.Deny.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f355184a = r100;
        }
    }

    static {
    }

    public LarkImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, null, null, 30);
    }

    public LarkImageView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, 0, null, null, 28);
    }

    public LarkImageView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, r111, null, null, 24);
    }

    @Override // com.larus.gallery.api.u
    public View getView() {
        return this;
    }

    public final boolean f() {
        if (this.f355181l == true) goto L13;
        kza.i r100 = this.f355173d;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.b() != true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.larus.gallery.api.u
    public View getScalableView() {
        View r100 = this.f355175f;
        if ((r100 instanceof FlowLargeImageView) == false) goto L5;
        FlowLargeImageView r101 = (FlowLargeImageView) r100;
    L6:
        if (r101 == null) goto L11;
        SubsamplingScaleImageView r102 = r101.getScaleImageView();
        if (r102 == null) goto L11;
        return r102;
    L11:
        return this;
    L5:
        r101 = null;
        goto L6
    }

    public final void h() {
        if (this.f355181l == false) goto L5;
        return;
    L5:
        kza.i r100 = this.f355173d;
        if (r100 != null) goto L8;
        return;
    L8:
        LarusSocialGalleryLarkImageViewBinding r101 = this.f355172c;
        if (r101 == null) goto L13;
        RelativeLayout r102 = r101.f355155c;
        if (r102 == null) goto L13;
        e1.o(r102);
    L13:
        LarusSocialGalleryLarkImageViewBinding r103 = this.f355172c;
        if (r103 == null) goto L18;
        ProgressBar r104 = r103.f355154b;
        if (r104 == null) goto L18;
        e1.x(r104);
    L18:
        r100.i(this.f355183n);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        d(this.f355174e);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public static void c(com.larus.common_ui.dialog.l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void d(com.larus.common_ui.dialog.l0 r100) {
        if (r100 != null) goto L18;
        return;
    L18:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100.isShowing() == false) goto L7;
        c(r100);     // Catch: Throwable -> L9
    L7:
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L15;
        FLogger.f375446a.e("LarkImageView", "dismissOriginLoadingDialog failed, errorMsg: " + r103.getMessage());
    L15:
        if (this.f355174e != r100) goto L20;
        this.f355174e = null;
        return;
    L20:
        return;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getActionMasked() != 0) goto L5;
        this.f355179j = false;
    L5:
        this.f355180k.onTouchEvent(r100);
        return super.dispatchTouchEvent(r100);
    }

    public final Object e(Continuation<? super Boolean> r100) {
        if ((r100 instanceof LarkImageView$isAnimatedImage$1) == false) goto L7;
        LarkImageView$isAnimatedImage$1 r101 = (LarkImageView$isAnimatedImage$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        boolean r106 = ((Boolean) r103).booleanValue();
    L22:
        return Boxing.boxBoolean(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        kza.i r107 = this.f355173d;
        if (r107 == null) goto L20;
        r101.label = 1;
        r103 = r107.g(r101);
        if (r103 != r104) goto L19;
        return r104;
    L20:
        r106 = false;
    L7:
        r101 = new LarkImageView$isAnimatedImage$1(this, r100);
        goto L8
    }

    public final Object g(Continuation<? super Boolean> r100) {
        if ((r100 instanceof LarkImageView$isShowFileReady$1) == false) goto L7;
        LarkImageView$isShowFileReady$1 r101 = (LarkImageView$isShowFileReady$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        File r107 = (File) r103;
    L21:
        if (r107 != null) goto L25;
        r106 = false;
    L25:
        return Boxing.boxBoolean(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        kza.i r108 = this.f355173d;
        if (r108 == null) goto L20;
        r101.label = 1;
        r103 = r108.c();
        if (r103 != r104) goto L19;
        return r104;
    L20:
        r107 = null;
    L7:
        r101 = new LarkImageView$isShowFileReady$1(this, r100);
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.f355179j;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f355179j == false) goto L10;
        if (isPressed() == false) goto L11;
        setPressed(false);
        return true;
    L11:
        return true;
    L10:
        return super.onTouchEvent(r100);
    }

    @Override // com.larus.gallery.api.u
    public void setOnGalleryCustomViewListener(com.larus.gallery.api.j r100) {
        this.f355176g = r100;
    }

    @Override // com.larus.gallery.api.u
    public final void a(boolean r100, boolean r101) {
        this.f355177h = r100;
        this.f355178i = r101;
        kza.i r102 = this.f355173d;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.gallery.api.u
    public final void b(boolean r100, boolean r101) {
        this.f355177h = r100;
        this.f355178i = r101;
    }

    public LarkImageView(Context r110, AttributeSet r111, int r112, b0 r113, GallerySource r114, int r115) {
        View r100 = null;
        if ((r115 & 2) == 0) goto L6;
        r111 = null;
    L6:
        if ((r115 & 4) == 0) goto L9;
        r112 = 0;
    L9:
        if ((r115 & 8) == 0) goto L12;
        r113 = null;
    L12:
        if ((r115 & 16) == 0) goto L14;
        r114 = GallerySource.DEFAULT;
    L14:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "source");
        super(r110, r111, r112);
        this.f355170a = r113;
        this.f355171b = r114;
        this.f355178i = true;
        this.f355180k = new GestureDetector(r110, new f(this));
        this.f355182m = new e(this);
        Object r116 = xp9.o.f564776a;
        if ((r116 instanceof OfficeSDKUserApi) == false) goto L17;
        OfficeSDKUserApi r117 = (OfficeSDKUserApi) r116;
    L18:
        if (r117 == null) goto L22;
        aza.d r118 = (aza.d) r117.getService(aza.d.class);
        if (r118 == null) goto L22;
        kza.h r119 = r118.X9();
    L23:
        if (r119 == null) goto L25;
        FlowLargeImageView r120 = r119.a(r110, r114);
    L26:
        this.f355173d = r120;
        if (r120 == null) goto L34;
        View r121 = r120.getView();
        if (r121 == null) goto L34;
        setClipToPadding(false);
        if ((r121 instanceof ViewGroup) == false) goto L33;
        ((ViewGroup) r121).setClipChildren(false);
    L33:
        r100 = r121;
    L34:
        this.f355175f = r100;
        if (r100 == null) goto L37;
        addView(r100);
    L37:
        LayoutInflater.from(r110).inflate(R.layout.larus_social_gallery_lark_image_view, this);
        int r122 = R.id.loading_view;
        ProgressBar r101 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_view);
        if (r101 == null) goto L50;
        r122 = R.id.retry_icon;
        if (((ImageView) ViewBindings.findChildViewById(this, R.id.retry_icon)) == null) goto L50;
        r122 = R.id.retry_view;
        RelativeLayout r123 = (RelativeLayout) ViewBindings.findChildViewById(this, R.id.retry_view);
        if (r123 == null) goto L50;
        r122 = R.id.security_mask_view;
        View r102 = ViewBindings.findChildViewById(this, R.id.security_mask_view);
        if (r102 == null) goto L50;
        r122 = R.id.security_placeholder_view;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.security_placeholder_view);
        if (r103 == null) goto L50;
        this.f355172c = new LarusSocialGalleryLarkImageViewBinding(this, r101, r123, r102, r103);
        e1.d(r123, new d(this));
        setClipToPadding(false);
        setClipChildren(false);
        this.f355183n = new g(this);
        return;
    L50:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r122)));
    L25:
        r120 = null;
    L22:
        r119 = null;
        goto L23
    L17:
        r117 = null;
        goto L18
    }
}
