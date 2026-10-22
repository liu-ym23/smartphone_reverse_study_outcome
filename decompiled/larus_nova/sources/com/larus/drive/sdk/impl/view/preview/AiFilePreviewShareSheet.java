package com.larus.drive.sdk.impl.view.preview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.nestedfile.INestFileService;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.common_ui.dialog.l0;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.drive.sdk.impl.databinding.LarusDialogAiFilePreviewShareBinding;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u0018\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020%H\u0002J\u001c\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\r2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010%H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010/\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0010H\u0002J\u0018\u00104\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010/\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/drive/sdk/impl/view/preview/AiFilePreviewShareSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogAiFilePreviewShareBinding;", "sharePanelView", "Lcom/larus/bmhome/share/panel/AbsSharePanelView;", "resolveUrlJob", "Lkotlinx/coroutines/Job;", "saveDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "savingToSpace", "", "openResultReported", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_START, "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "resolveShareUrl", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/larus/drive/sdk/impl/store/AiFilePreviewSession;", "(Lcom/larus/drive/sdk/impl/store/AiFilePreviewSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSharePanel", "fileUrl", "reportOpenResult", "success", "errorCode", "resolveTraceFileType", "fileName", "openFileForwardPicker", "file", "Lcom/larus/bmhome/share/panel/HostForwardFileContent;", "requestDownloadCurrentFile", "saveToSpace", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiFilePreviewShareSheet extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f342271j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogAiFilePreviewShareBinding f342272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.bmhome.share.panel.a f342273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f342274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l0 f342275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f342276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f342277i;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.preview.AiFilePreviewShareSheet$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.AiFilePreviewShareSheet$onViewCreated$3", f = "AiFilePreviewShareSheet.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.drive.sdk.impl.store.a $session;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AiFilePreviewShareSheet this$0;

        public AnonymousClass3(AiFilePreviewShareSheet r100, com.larus.drive.sdk.impl.store.a r101, Continuation<? super AnonymousClass3> r102) {
            this.this$0 = r100;
            this.$session = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass3 r102 = new AnonymousClass3(this.this$0, this.$session, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_AiFilePreviewShareSheet$onViewCreated$3_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(AiFilePreviewShareSheet r100) {
            r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L11;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            boolean r103 = true;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            CoroutineScope r104 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r100);
        L11:
            String r105 = (String) r100;
            if (r105 == null) goto L18;
            if (StringsKt.isBlank(r105) == true) goto L18;
            r103 = false;
        L18:
            if (r103 == false) goto L24;
            FLogger.f375446a.w("AiFilePreviewShare", "dismiss share sheet, reason=share_url_unavailable");
            AiFilePreviewShareSheet r106 = this.this$0;
            a r107 = AiFilePreviewShareSheet.f342271j;
            r106.W90(false, "share_url_unavailable");
            Context r108 = this.this$0.getContext();
            if (r108 == null) goto L22;
            s.f544207a.g(r108, R.string.larus_file_cant_open_toast, false);
        L22:
            INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_AiFilePreviewShareSheet$onViewCreated$3_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
            return Unit.INSTANCE;
        L24:
            AiFilePreviewShareSheet r109 = this.this$0;
            com.larus.drive.sdk.impl.store.a r110 = this.$session;
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
            AiFilePreviewShareSheet.V90(r109, r110, r105);     // Catch: Throwable -> L27
            Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            AiFilePreviewShareSheet r113 = this.this$0;
            Throwable r114 = Result.m9452exceptionOrNullimpl(r112);
            if (r114 == null) goto L36;
            FLogger.f375446a.e("AiFilePreviewShare", "show share panel failed, errorType=".concat(r114.getClass().getSimpleName()));
            a r115 = AiFilePreviewShareSheet.f342271j;
            r113.W90(false, "share_panel_unavailable");
            Context r116 = r113.getContext();
            if (r116 == null) goto L34;
            s.f544207a.g(r116, R.string.larus_file_cant_open_toast, false);
        L34:
            INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_AiFilePreviewShareSheet$onViewCreated$3_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r113);
        L36:
            return Unit.INSTANCE;
        L27:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L29
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoroutineScope r118 = (CoroutineScope) this.L$0;
            AiFilePreviewShareSheet r119 = this.this$0;
            com.larus.drive.sdk.impl.store.a r120 = this.$session;
            this.L$0 = r118;
            this.label = 1;
            r100 = AiFilePreviewShareSheet.U90(r119, r120, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_BottomSheetDialog;
    }

    static {
        f342271j = new a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Job r100 = this.f342274f;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f342274f = null;
        l0 r101 = this.f342275g;
        if (r101 == null) goto L8;
        T90(r101);
    L8:
        this.f342275g = null;
        com.larus.bmhome.share.panel.a r102 = this.f342273e;
        if (r102 == null) goto L11;
        r102.b();
    L11:
        this.f342273e = null;
        this.f342272d = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r101 = (BottomSheetDialog) r100;
    L6:
        if (r101 == null) goto L11;
        FrameLayout r102 = (FrameLayout) r101.findViewById(R.id.design_bottom_sheet);
        if (r102 == null) goto L12;
        r102.setBackgroundResource(android.R.color.transparent);
        BottomSheetBehavior r103 = BottomSheetBehavior.from(r102);
        r103.setSkipCollapsed(true);
        r103.setState(3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public AiFilePreviewShareSheet() {
    }

    public static void S90(AiFilePreviewShareSheet r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void T90(l0 r100) {
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        W90(false, "cancel");
        super.onCancel(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        Context r101 = getContext();
        if (r101 == null) goto L7;
        Resources.Theme r102 = r101.getTheme();
        if (r102 == null) goto L7;
        v19.f.a(r102);
    L7:
        super.onCreate(r100);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setSoftInputMode(16);
    L5:
        return r101;
    }

    public final void W90(boolean r100, String r101) {
        if (this.f342277i == false) goto L5;
        return;
    L5:
        Bundle r102 = getArguments();
        if (r102 == null) goto L19;
        String r103 = r102.getString("open_result_request_key");
        if (r103 != null) goto L10;
        return;
    L10:
        if ((!StringsKt.isBlank(r103)) == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L21;
        this.f342277i = true;
        FragmentManager r104 = getParentFragmentManager();
        Bundle r105 = new Bundle();
        r105.putBoolean("result_success", r100);
        if (r101 == null) goto L17;
        r105.putString("result_error_code", r101);
    L17:
        Unit r106 = Unit.INSTANCE;
        r104.setFragmentResult(r103, r105);
        return;
    L21:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        if (r102 == null) goto L5;
        String r103 = r102.getString("request_id");
    L7:
        if (r103 == null) goto L20;
        DrivePreviewRequestStore r104 = DrivePreviewRequestStore.f341970a;
        monitor-enter(r104);
        Intrinsics.checkNotNullParameter(r103, "requestId");     // Catch: Throwable -> L17
        DrivePreviewRequestStore.a r105 = DrivePreviewRequestStore.a(r103, true);     // Catch: Throwable -> L17
        if (r105 != null) goto L14;
        monitor-exit(r104);
        goto L20
    L14:
        com.larus.drive.sdk.impl.store.a r106 = r105.f341977d;     // Catch: Throwable -> L17
        monitor-exit(r104);
    L22:
        if (r106 != null) goto L25;
        FLogger.f375446a.w("AiFilePreviewShare", "dismiss share sheet because preview session is unavailable");
        W90(false, "session_unavailable");
        S90(this);
        return;
    L25:
        LarusDialogAiFilePreviewShareBinding r107 = this.f342272d;
        if (r107 == null) goto L30;
        AppCompatImageView r108 = r107.f341694b;
        if (r108 == null) goto L30;
        r108.setOnClickListener(new com.larus.drive.sdk.impl.view.preview.a(this));
    L30:
        LarusDialogAiFilePreviewShareBinding r109 = this.f342272d;
        if (r109 == null) goto L46;
        AppCompatTextView r110 = r109.f341697e;
        if (r110 == null) goto L46;
        String r111 = r106.f341984e;
        if (r111 != null) goto L37;
    L42:
        r111 = r106.f341980a.getCurrent().getTitle();
        if (r111 != null) goto L45;
        r111 = "";
    L45:
        r110.setText(r111);
        goto L46
    L37:
        if ((true ^ StringsKt.isBlank(r111)) == true) goto L40;
        r111 = null;
    L40:
        if (r111 == null) goto L42;
    L46:
        FLogger.f375446a.i("AiFilePreviewShare", "share sheet opened");
        this.f342274f = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass3(this, r106, null), 3, null);
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        r106 = null;
        goto L22
    L5:
        r103 = null;
        goto L7
    }

    public static final Object U90(AiFilePreviewShareSheet r210, com.larus.drive.sdk.impl.store.a r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof AiFilePreviewShareSheet$resolveShareUrl$1) == false) goto L7;
        AiFilePreviewShareSheet$resolveShareUrl$1 r100 = (AiFilePreviewShareSheet$resolveShareUrl$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        Object r105 = null;
        boolean r106 = true;
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L16;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L13
    L31:
        String r107 = (String) r102;     // Catch: Throwable -> L13
    L33:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L13
    L36:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L40;
        FLogger.f375446a.e("AiFilePreviewShare", "resolve share url failed, errorType=".concat(r109.getClass().getSimpleName()));
    L40:
        if (Result.m9455isFailureimpl(r108) == true) goto L43;
        r105 = r108;
    L43:
        String r110 = (String) r105;
        if (r110 != null) goto L46;
    L49:
        if (r106 == true) goto L52;
        FLogger.f375446a.i("AiFilePreviewShare", "resolve share url, source=dynamic");
        return r110;
    L52:
        if (Result.m9456isSuccessimpl(r108) == false) goto L60;
        FLogger.f375446a.w("AiFilePreviewShare", "resolve share url failed, reason=empty_result");
        return r110;
    L60:
        return r110;
    L46:
        if (StringsKt.isBlank(r110) == true) goto L49;
        r106 = false;
        goto L49
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r102);
        String r111 = r211.f341983d;
        if (r111 != null) goto L20;
    L25:
        UplinkFileInfo r112 = new UplinkFileInfo(r211.f341984e, r211.f341981b, null, Boxing.boxInt(FileType.FileTypeFile.getValue()), null, r211.f341982c, null, r211.f341985f, null, null, 852, null);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L13
        INestFileService r114 = (INestFileService) ServiceManager.get().getService(INestFileService.class);     // Catch: Throwable -> L13
        if (r114 == null) goto L32;
        Context r115 = r210.requireContext();     // Catch: Throwable -> L13
        r100.label = 1;     // Catch: Throwable -> L13
        r102 = r114.a(r115, r112, r100);     // Catch: Throwable -> L13
        if (r102 != r103) goto L31;
        return r103;
    L32:
        r107 = null;
        goto L33
    L20:
        if ((!StringsKt.isBlank(r111)) == true) goto L23;
        r111 = null;
    L23:
        if (r111 == null) goto L25;
        FLogger.f375446a.i("AiFilePreviewShare", "resolve share url, source=direct");
        return r111;
    L13:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new AiFilePreviewShareSheet$resolveShareUrl$1(r210, r212);
        goto L8
    }

    public static final void V90(AiFilePreviewShareSheet r910, com.larus.drive.sdk.impl.store.a r911, String r912) {
        Context r110 = r910.getContext();
        if (r110 != null) goto L5;
        r910.W90(false, "fragment_unavailable");
        return;
    L5:
        FLogger r111 = FLogger.f375446a;
        r111.i("AiFilePreviewShare", "create share panel");
        String r100 = r911.f341984e;
        if (r100 != null) goto L8;
    L13:
        r100 = r911.f341980a.getCurrent().getTitle();
        if (r100 != null) goto L16;
    L18:
        r100 = null;
    L19:
        if (r100 != null) goto L21;
        r100 = "file";
    L21:
        String r101 = r911.f341981b;
        String r102 = r911.f341985f;
        if (r102 != null) goto L24;
        r102 = "";
    L24:
        com.larus.bmhome.share.panel.c r103 = new com.larus.bmhome.share.panel.c(r101, r100, r102);
        ShareServiceDelegate r104 = ShareServiceDelegate.f313831b;
        ShareScene r105 = ShareScene.BOT_FILE_PREVIEW;
        com.larus.bmhome.share.panel.b r106 = new com.larus.bmhome.share.panel.b(null, null, r912, null, null, null, null, r100, null, null, null, r912, r100, null, null, null, false, false, null, null, false, false, null, false, null, r103, 33548155);
        String r107 = r911.f341980a.getCurrent().getFileExt();
        if (r107 == null) goto L41;
        String r108 = StringsKt.trim(r107).toString();
        if (r108 == null) goto L41;
        String r109 = StringsKt.removePrefix(r108, ".");
        if (r109 == null) goto L41;
        String r112 = r109.toLowerCase(Locale.ROOT);
        if (r112 == null) goto L41;
        if (r112.length() <= 0) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == true) goto L39;
        r112 = null;
    L39:
        if (r112 == null) goto L41;
    L46:
        String r810 = r112;
    L48:
        com.larus.bmhome.share.panel.a r114 = IShareService.a.a(r104, r110, r105, r106, true, new com.larus.bmhome.share.panel.h(null, null, null, "preview", null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to(ShareChannel.MESSAGE_FORWARD, "select_more_conversations")), false, null, null, r810, null, -17, -1, 751), new c(r910, r103, r911, r100), null, 512);
        if (r114 != null) goto L51;
        r111.w("AiFilePreviewShare", "dismiss share sheet, reason=share_panel_unavailable");
        r910.W90(false, "share_panel_unavailable");
        s.f544207a.g(r110, R.string.larus_file_cant_open_toast, false);
        S90(r910);
        return;
    L51:
        r910.f342273e = r114;
        LarusDialogAiFilePreviewShareBinding r115 = r910.f342272d;
        if (r115 == null) goto L56;
        ProgressBar r116 = r115.f341696d;
        if (r116 == null) goto L56;
        r116.setVisibility(8);
    L56:
        LarusDialogAiFilePreviewShareBinding r117 = r910.f342272d;
        if (r117 == null) goto L61;
        FrameLayout r118 = r117.f341695c;
        if (r118 == null) goto L61;
        r114.setVisibility(0);
        r118.addView(r114, new FrameLayout.LayoutParams(-1, -2));
    L61:
        r910.W90(true, null);
        r111.i("AiFilePreviewShare", "share panel shown");
        return;
    L35:
        r113 = false;
    L41:
        r112 = StringsKt.trim(StringsKt.substringAfterLast(r100, '.', "")).toString().toLowerCase(Locale.ROOT);
        if (r112.length() <= 0) goto L44;
        boolean r119 = true;
    L45:
        if (r119 == true) goto L46;
        r810 = null;
        goto L48
    L44:
        r119 = false;
        goto L45
    L16:
        if ((!StringsKt.isBlank(r100)) == false) goto L18;
    L8:
        if ((!StringsKt.isBlank(r100)) == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dialog_ai_file_preview_share, r101, false);
        int r104 = R.id.share_close;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.share_close);
        if (r105 == null) goto L13;
        r104 = R.id.share_panel_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.share_panel_container);
        if (r106 == null) goto L13;
        r104 = R.id.share_progress;
        ProgressBar r107 = (ProgressBar) ViewBindings.findChildViewById(r103, R.id.share_progress);
        if (r107 == null) goto L13;
        r104 = R.id.share_title;
        AppCompatTextView r108 = (AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.share_title);
        if (r108 == null) goto L13;
        RoundLinearLayout r109 = (RoundLinearLayout) r103;
        this.f342272d = new LarusDialogAiFilePreviewShareBinding(r109, r105, r106, r107, r108);
        return r109;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
