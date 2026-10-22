package com.larus.voicecall.impl.video;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.common_ui.dialog.l0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusDialogVideoFaceMemoryAuthBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016JG\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2'\u0010\u001c\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001d¢\u0006\u0002\b!H\u0082@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/voicecall/impl/video/VideoFaceMemoryAuthDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/voicecall/impl/databinding/LarusDialogVideoFaceMemoryAuthBinding;", "dismissReason", "", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getTheme", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "withLoading", ExifInterface.GPS_DIRECTION_TRUE, PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoFaceMemoryAuthDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f379566g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogVideoFaceMemoryAuthBinding f379567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f379568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l0 f379569f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog$onDestroy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog$onDestroy$1", f = "VideoFaceMemoryAuthDialog.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            SettingRepoDelegate r103 = SettingRepoDelegate.f307752b;
            this.label = 1;
            if (r103.X(false, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_RoundCornerBottomSheetDialog;
    }

    public VideoFaceMemoryAuthDialog() {
        this.f379568e = "other";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        FLogger.f375446a.i("face_auth", "onDestroy: " + this.f379568e);
        if (Intrinsics.areEqual(this.f379568e, "confirm") == true) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
        c3a.a.a(false, true);
        return;
    }

    public static void S90(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        by7.a r101 = new by7.a("face_memory_pop_up_show");
        r101.d("pop_up_type", "first_time_auth");
        r101.b();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        LarusDialogVideoFaceMemoryAuthBinding r102 = this.f379567d;
        LarusDialogVideoFaceMemoryAuthBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        Object r104 = r102.f378227a.getParent();
        if ((r104 instanceof View) == false) goto L8;
        View r105 = (View) r104;
    L9:
        if (r105 == null) goto L11;
        r105.setBackground(null);
    L11:
        LarusDialogVideoFaceMemoryAuthBinding r106 = this.f379567d;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L14:
        r106.f378228b.setOnClickListener(new p(this));
        LarusDialogVideoFaceMemoryAuthBinding r107 = this.f379567d;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L17:
        r107.f378230d.setOnClickListener(new q(this));
        LarusDialogVideoFaceMemoryAuthBinding r108 = this.f379567d;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r103.f378229c.setOnClickListener(new r(this));
        return;
    L20:
        r103 = r108;
        goto L21
    L8:
        r105 = null;
        goto L9
    }

    public final <T> Object T90(CoroutineContext r100, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r110, Continuation<? super T> r111) {
        if ((r111 instanceof VideoFaceMemoryAuthDialog$withLoading$1) == false) goto L7;
        VideoFaceMemoryAuthDialog$withLoading$1 r101 = (VideoFaceMemoryAuthDialog$withLoading$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L25:
        l0 r105 = this.f379569f;
        if (r105 == null) goto L28;
        S90(r105);
    L28:
        this.f379569f = null;
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        l0 r113 = this.f379569f;
        if (r113 == null) goto L17;
        S90(r113);
    L17:
        l0 r114 = new l0(requireActivity(), 0.0f, false, 6);
        this.f379569f = r114;
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r114);
    L22:
        VideoFaceMemoryAuthDialog$withLoading$result$1 r115 = new VideoFaceMemoryAuthDialog$withLoading$result$1(r110, null);
        r101.label = 1;
        r112 = BuildersKt.withContext(r100, r115, r101);
        if (r112 != r103) goto L25;
        return r103;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L21:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
    L7:
        r101 = new VideoFaceMemoryAuthDialog$withLoading$1(this, r111);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dialog_video_face_memory_auth, r101, false);
        int r104 = R.id.close_btn;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.close_btn);
        if (r105 == null) goto L17;
        r104 = R.id.confirm_btn;
        AppCompatButton r106 = (AppCompatButton) ViewBindings.findChildViewById(r103, R.id.confirm_btn);
        if (r106 == null) goto L17;
        r104 = R.id.head_img;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.head_img)) == null) goto L17;
        r104 = R.id.refuse_btn;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.refuse_btn);
        if (r107 == null) goto L17;
        r104 = R.id.subtitle_txt;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.subtitle_txt)) == null) goto L17;
        r104 = R.id.title_txt;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.title_txt)) == null) goto L17;
        ConstraintLayout r108 = (ConstraintLayout) r103;
        this.f379567d = new LarusDialogVideoFaceMemoryAuthBinding(r108, r105, r106, r107);
        return r108;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
