package com.larus.slides.impl.select;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.ChatParam;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.nova.R;
import com.larus.office.base.utils.SlidesFileUtils;
import com.larus.permission.api.IPermissionX;
import com.larus.slides.impl.select.utils.ImageSaveUtils;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/slides/impl/select/GenerateImageUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageFragment$bindObservers$2", f = "GenerateImageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GenerateImageFragment$bindObservers$2 extends SuspendLambda implements Function2<o, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GenerateImageFragment this$0;

    public GenerateImageFragment$bindObservers$2(GenerateImageFragment r100, Continuation<? super GenerateImageFragment$bindObservers$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        GenerateImageFragment$bindObservers$2 r102 = new GenerateImageFragment$bindObservers$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(o r100, Continuation<? super Unit> r101) {
        return ((GenerateImageFragment$bindObservers$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(o r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(PictureSaveActionSheet r100) {
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

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r100) {
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

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.slides.impl.select.m, kotlin.jvm.functions.Function1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L108;
        ResultKt.throwOnFailure(r110);
        o r111 = (o) this.L$0;
        if ((r111 instanceof o.e) == false) goto L9;
        ((o.e) r111).getClass();
        l0 r112 = (l0) this.this$0.f369581i.getValue();
        if (r112 == null) goto L104;
        INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r112);
    L104:
        return Unit.INSTANCE;
    L9:
        String r100 = null;
        if ((r111 instanceof o.b) == false) goto L18;
        FragmentActivity r101 = this.this$0.getActivity();
        if (r101 == null) goto L14;
        ((o.b) r111).getClass();
        r101.setResult(11, null);
    L14:
        FragmentActivity r113 = this.this$0.getActivity();
        if (r113 == null) goto L104;
        r113.finish();
        goto L104
    L18:
        if ((r111 instanceof o.c) == false) goto L24;
        com.bytedance.router.i r102 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/create_bot");
        GenerateImageFragment r103 = this.this$0;
        if (r103.getArguments() == null) goto L22;
        r102.g(r103.getArguments());
    L22:
        ((o.c) r111).getClass();
        r102.f267555d = R.anim.larus_router_slide_in_right;
        r102.f267556e = R.anim.larus_router_no_anim;
        r102.e(11);
        goto L104
    L24:
        if ((r111 instanceof o.g) == false) goto L26;
        t19.s r104 = t19.s.f544207a;
        Context r105 = this.this$0.getContext();
        String r114 = ((o.g) r111).f369656a.toString(this.this$0.getContext());
        r104.getClass();
        t19.s.c(r105, r114);
        goto L104
    L26:
        boolean r106 = false;
        if ((r111 instanceof o.a) == false) goto L38;
        FragmentActivity r107 = this.this$0.getActivity();
        if (r107 == null) goto L31;
        r107.setResult(100, new Intent().putExtras(((o.a) r111).f369654a));
    L31:
        FragmentActivity r115 = this.this$0.getActivity();
        if (r115 == null) goto L34;
        r115.finish();
    L34:
        FragmentActivity r116 = this.this$0.getActivity();
        if (r116 == null) goto L104;
        r116.overridePendingTransition(0, R.anim.larus_fade_out);
        goto L104
    L38:
        if ((r111 instanceof o.d) == false) goto L44;
        PictureSaveActionSheet r108 = this.this$0.f369579g;
        if (r108 == null) goto L42;
        INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r108);
    L42:
        PictureSaveActionSheet r109 = new PictureSaveActionSheet();
        ((o.d) r111).getClass();
        Intrinsics.checkNotNullParameter(null, "pictureData");
        r109.f369624i = null;
        r109.f369621f = null;
        r109.f369622g = null;
        INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r109, this.this$0.getParentFragmentManager(), "PictureSaveActionSheet");
        this.this$0.f369579g = r109;
        goto L104
    L44:
        if ((r111 instanceof o.f) == false) goto L106;
        PolarisFileWrapper r117 = new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), "images");
        if (r117.exists() == true) goto L48;
        r117.mkdirs();
    L48:
        Lazy r118 = ImageSaveUtils.f369667a;
        FragmentActivity r119 = this.this$0.getActivity();
        String r120 = ((o.f) r111).f369655a;
        String r121 = r117.getAbsolutePath();
        final GenerateImageFragment r122 = this.this$0;
        ?? r123 = new m(r122);
        if (r120 != null) goto L51;
    L52:
        r106 = true;
    L54:
        if (r106 == false) goto L56;
        FLogger.f375446a.e("ImageSaveUtils", "no url");
    L67:
        GenerateImageFragment r124 = this.this$0;
        int r125 = GenerateImageFragment.f369576n;
        lr9.a r126 = r124.U90();
        if (r126 == null) goto L70;
        String r127 = r126.e();
    L71:
        lr9.a r128 = this.this$0.U90();
        if (r128 == null) goto L74;
        String r129 = r128.f();
    L75:
        lr9.a r130 = this.this$0.U90();
        if (r130 == null) goto L78;
        Integer r131 = r130.g();
    L79:
        lr9.a r132 = this.this$0.U90();
        if (r132 == null) goto L82;
        String r133 = r132.b();
    L83:
        lr9.a r134 = this.this$0.U90();
        if (r134 == null) goto L86;
        Integer r135 = r134.c();
    L87:
        ChatParam r136 = (ChatParam) this.this$0.f369583k.getValue();
        if (r136 == null) goto L90;
        String r137 = r136.f296889a;
    L91:
        ChatParam r138 = (ChatParam) this.this$0.f369583k.getValue();
        if (r138 == null) goto L94;
        String r139 = r138.f296890b;
    L95:
        lr9.a r140 = this.this$0.U90();
        if (r140 == null) goto L98;
        String r141 = r140.d();
    L99:
        lr9.a r142 = this.this$0.U90();
        if (r142 == null) goto L102;
        r100 = r142.a();
    L102:
        tx9.a.a(r127, r129, r131, r133, r135, r100, r137, r139, r141, NameKeys.LoadStrategy_Use);
        goto L104
    L98:
        r141 = null;
        goto L99
    L94:
        r139 = null;
        goto L95
    L90:
        r137 = null;
        goto L91
    L86:
        r135 = null;
        goto L87
    L82:
        r133 = null;
        goto L83
    L78:
        r131 = null;
        goto L79
    L74:
        r129 = null;
        goto L75
    L70:
        r127 = null;
        goto L71
    L56:
        if (r119 != null) goto L59;
        FLogger.f375446a.e("ImageSaveUtils", "no activity");
        goto L67
    L59:
        if (SlidesFileUtils.b(r121) == false) goto L62;
        FLogger.f375446a.i("ImageSaveUtils", "save to sandbox dir, no need permission check");
        ImageSaveUtils.a(r120, r121, r123);
        goto L67
    L62:
        if (Build.VERSION.SDK_INT > 29) goto L66;
        IPermissionX r143 = (IPermissionX) ServiceManager.get().getService(IPermissionX.class);
        if (r143 == null) goto L67;
        r143.a(r119, CollectionsKt.mutableListOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}), new com.larus.slides.impl.select.utils.g(r120, r121, r123));
        goto L67
    L66:
        ImageSaveUtils.a(r120, r121, r123);
        goto L67
    L51:
        if (r120.length() != 0) goto L54;
    L106:
        throw new NoWhenBranchMatchedException();
    L108:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static void INVOKEVIRTUAL_com_larus_slides_impl_select_GenerateImageFragment$bindObservers$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(PictureSaveActionSheet r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        PictureSaveActionSheet r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
