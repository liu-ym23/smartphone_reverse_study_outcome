package com.larus.home.impl.route;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class EditInstructionRouterInterceptor implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f346050a = 0;

    public static final class a {
    }

    static {
    }

    public EditInstructionRouterInterceptor() {
    }

    public static final boolean d(EditInstructionRouterInterceptor r100) {
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        String r102 = null;
        ChatFragment r103 = com.larus.home.impl.utils.b.b(null);     // Catch: Throwable -> L20
        if (r103 == null) goto L10;
        t1a.b r104 = r103.WF();     // Catch: Throwable -> L20
        if (r104 == null) goto L10;
        com.larus.bmhome.chat.component.cvs.y r105 = (com.larus.bmhome.chat.component.cvs.y) r104.getAbility(com.larus.bmhome.chat.component.cvs.y.class);     // Catch: Throwable -> L20
        if (r105 == null) goto L10;
        String r106 = r105.getBotId();     // Catch: Throwable -> L20
    L11:
        com.larus.bmhome.chat.api.e0 r107 = AuthModelDelegate.f297134b.e().getValue();     // Catch: Throwable -> L20
        if (r107 == null) goto L16;
        LaunchInfo r108 = r107.f297186a;     // Catch: Throwable -> L20
        if (r108 == null) goto L16;
        r102 = r108.W();     // Catch: Throwable -> L20
    L16:
        if (Intrinsics.areEqual(r106, r102) == false) goto L19;
        return true;
    L19:
        return false;
    L10:
        r106 = null;
    L20:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Object r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9452exceptionOrNullimpl(r110) == null) goto L26;
        r110 = Boolean.FALSE;
    L26:
        return ((Boolean) r110).booleanValue();
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("Router matchInterceptRules -> ");
        if (r100 == null) goto L7;
        Uri r103 = r100.f267530d;
        if (r103 == null) goto L7;
        String r104 = r103.getAuthority();
    L8:
        r102.append(r104);
        r101.d("EditInstructionRouterInterceptor", r102.toString());
        int r105 = com.larus.utils.k0.f375428a;
        if (r100 == null) goto L11;
        Uri r106 = r100.f267530d;
    L12:
        String r107 = com.larus.utils.k0.a(String.valueOf(r106));
        if (r107 != null) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == true) goto L28;
        if (r107 != null) goto L21;
    L23:
        boolean r109 = false;
    L24:
        if (r109 == true) goto L29;
        return false;
    L29:
        return true;
    L21:
        if (StringsKt.contains$default(r107, "flow/creation_template", false, 2, null) != true) goto L23;
        r109 = true;
        goto L24
    L28:
        return true;
    L15:
        if (StringsKt.contains$default(r107, "flow/edit_instruction", false, 2, null) != true) goto L17;
        r108 = true;
        goto L18
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v19, types: [T, java.lang.Integer] */
    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        if (r110 == null) goto L48;
        if (r111 == null) goto L48;
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        String r112 = UriProtector.getQueryParameter(r111.f267530d, "actionbar_instruction_type");
        if (r112 == null) goto L9;
        T r113 = StringsKt.toIntOrNull(r112);
    L10:
        r100.element = r113;
        FLogger r114 = FLogger.f375446a;
        r114.i("EditInstructionRouterInterceptor", "instructionType:" + r100.element + " from schema");
        if (r100.element != 0) goto L37;
        String r101 = UriProtector.getQueryParameter(r111.f267530d, com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE);
        if (r101 == null) goto L15;
        Integer r102 = StringsKt.toIntOrNull(r101);
    L16:
        if (r102 != null) goto L19;
    L21:
        if (r102 != null) goto L24;
    L26:
        if (r102 != null) goto L29;
    L31:
        if (r102 == null) goto L37;
        if (r102.intValue() != 7) goto L37;
        r100.element = 28;
        goto L37
    L29:
        if (r102.intValue() != 5) goto L31;
        r100.element = 18;
        goto L37
    L24:
        if (r102.intValue() != 3) goto L26;
        r100.element = 11;
        goto L37
    L19:
        if (r102.intValue() != 2) goto L21;
        r100.element = 4;
        goto L37
    L15:
        r102 = null;
    L37:
        if (((Integer) r100.element) != null) goto L40;
        r114.e("EditInstructionRouterInterceptor", "final instructionType is null");
        return false;
    L40:
        Activity r115 = AppHost.f326268a.a().getCurrentActivity();
        if ((r115 instanceof FragmentActivity) == false) goto L43;
        FragmentActivity r103 = (FragmentActivity) r115;
    L44:
        if (r103 != null) goto L46;
        return false;
    L46:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r103), null, null, new EditInstructionRouterInterceptor$onInterceptRoute$2(r111, this, r100, r103, null), 3, null);
        return true;
    L43:
        r103 = null;
        goto L44
    L9:
        r113 = 0;
    L48:
        return false;
    }

    public final Object e(String r110, Continuation<? super List<com.larus.bmhome.actionbar.model.z0>> r210) {
        if ((r210 instanceof EditInstructionRouterInterceptor$getActionBarItemsFromRemote$1) == false) goto L7;
        EditInstructionRouterInterceptor$getActionBarItemsFromRemote$1 r100 = (EditInstructionRouterInterceptor$getActionBarItemsFromRemote$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Job r105 = (Job) r100.L$2;
        com.larus.common_ui.dialog.l0 r106 = (com.larus.common_ui.dialog.l0) r100.L$1;
        FragmentActivity r107 = (FragmentActivity) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L39:
        List r108 = (List) r102;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
        if (r107.isFinishing() == false) goto L42;
    L61:
        return r108;
    L42:
        if (r107.isDestroyed() == true) goto L61;
        Handler r109 = DialogLancet.resolveDialogHandler(r106);
        if (r109 != null) goto L46;
    L48:
        DialogLancet.beforeDialogDismiss(r106);
        r106.dismiss();     // Catch: Throwable -> L51 Exception -> L53
    L58:
        DialogLancet.afterDialogDismiss(r106);
        goto L61
    L51:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r106);
        throw th;
    L53:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L51
        Throwable r111 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L51
        if (r111 == null) goto L58;
        com.bytedance.crash.d.d(r111, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L51
        goto L58
    L46:
        if (Looper.myLooper() == r109.getLooper()) goto L48;
        r109.post(DialogLancet.createDismissRunnable(r106));
        goto L61
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r110 != null) goto L17;
        return null;
    L17:
        AppHost.Companion r112 = AppHost.f326268a;
        Activity r113 = r112.a().getCurrentActivity();
        if ((r113 instanceof FragmentActivity) == false) goto L20;
        FragmentActivity r114 = (FragmentActivity) r113;
    L21:
        if (r114 != null) goto L23;
        return null;
    L23:
        com.larus.common_ui.dialog.l0 r115 = new com.larus.common_ui.dialog.l0(r114, 0.0f, false, 6);
        Job r116 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r114), null, null, new EditInstructionRouterInterceptor$getActionBarItemsFromRemote$delayShowLoadingJob$1(r114, r115, null), 3, null);
        r100.L$0 = r114;
        r100.L$1 = r115;
        r100.L$2 = r116;
        r100.label = 1;
        kotlinx.coroutines.j r117 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r117.C();
        Activity r118 = r112.a().getCurrentActivity();
        if ((r118 instanceof FragmentActivity) == false) goto L26;
        FragmentActivity r119 = (FragmentActivity) r118;
    L27:
        if (r119 == null) goto L32;
        LifecycleCoroutineScope r120 = LifecycleOwnerKt.getLifecycleScope(r119);
        if (r120 == null) goto L32;
        BuildersKt.launch$default(r120, Dispatchers.getIO(), null, new EditInstructionRouterInterceptor$updateConfigFromRemote$2$1(r117, r120, r110, null), 2, null);
    L33:
        r102 = r117.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L36:
        if (r102 != r103) goto L38;
        return r103;
    L38:
        r107 = r114;
        r106 = r115;
        r105 = r116;
    L32:
        r117.resumeWith(Result.m9449constructorimpl(null));
        goto L33
    L26:
        r119 = null;
        goto L27
    L20:
        r114 = null;
    L7:
        r100 = new EditInstructionRouterInterceptor$getActionBarItemsFromRemote$1(this, r210);
        goto L8
    }

    public static final Object c(EditInstructionRouterInterceptor r110, Integer r111, Continuation r112) {
        Integer r100 = r111;
        r110.getClass();
        if ((r112 instanceof EditInstructionRouterInterceptor$getItemDataOfMainActionBar$1) == false) goto L7;
        EditInstructionRouterInterceptor$getItemDataOfMainActionBar$1 r101 = (EditInstructionRouterInterceptor$getItemDataOfMainActionBar$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        com.larus.bmhome.actionbar.model.z0 r106 = (com.larus.bmhome.actionbar.model.z0) r101.L$1;
        r100 = (Integer) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L49:
        List r107 = (List) r103;
        if (r107 == null) goto L161;
        FLogger.f375446a.i("EditInstructionRouterInterceptor", "getItemDataOfMainActionBar from remote success");
        Iterator r108 = r107.iterator();
    L53:
        if (r108.hasNext() == false) goto L61;
        Object r109 = r108.next();
        com.larus.bmhome.actionbar.model.r r113 = ((com.larus.bmhome.actionbar.model.z0) r109).f295621q;
        if (r113 == null) goto L57;
        Integer r114 = r113.f295408a;
    L59:
        if (Intrinsics.areEqual(r114, r100) == false) goto L53;
        Object r115 = r109;
    L62:
        com.larus.bmhome.actionbar.model.z0 r116 = (com.larus.bmhome.actionbar.model.z0) r115;
    L164:
        return r116;
    L57:
        r114 = null;
        goto L59
    L61:
        r115 = null;
        goto L62
    L161:
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List<com.larus.bmhome.actionbar.model.z0> r117 = (List) r101.L$1;
        r100 = (Integer) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L89:
        List r118 = (List) r103;
        if (r118 == null) goto L121;
        FLogger.f375446a.i("EditInstructionRouterInterceptor", "getItemDataOfMainActionBar from remote success");
        List r119 = r118;
        Iterator r120 = r119.iterator();
    L93:
        if (r120.hasNext() == false) goto L105;
        Object r121 = r120.next();
        com.larus.bmhome.actionbar.model.r r122 = ((com.larus.bmhome.actionbar.model.z0) r121).f295621q;
        if (r122 == null) goto L102;
        Integer r123 = r122.f295408a;
        if (r123 == null) goto L102;
        if (r123.intValue() != 28) goto L102;
        boolean r124 = true;
    L103:
        if (r124 == false) goto L93;
    L106:
        com.larus.bmhome.actionbar.model.z0 r125 = (com.larus.bmhome.actionbar.model.z0) r121;
        if (r125 != null) goto L163;
        Iterator r126 = r119.iterator();
    L110:
        if (r126.hasNext() == false) goto L118;
        Object r127 = r126.next();
        com.larus.bmhome.actionbar.model.r r128 = ((com.larus.bmhome.actionbar.model.z0) r127).f295621q;
        if (r128 == null) goto L114;
        Integer r129 = r128.f295408a;
    L116:
        if (Intrinsics.areEqual(r129, r100) == false) goto L110;
        Object r130 = r127;
    L119:
        r116 = (com.larus.bmhome.actionbar.model.z0) r130;
        goto L164
    L114:
        r129 = null;
        goto L116
    L118:
        r130 = null;
        goto L119
    L163:
        return r125;
    L102:
        r124 = false;
        goto L103
    L105:
        r121 = null;
        goto L106
    L121:
        if (r117 == null) goto L134;
        Iterator<T> r131 = r117.iterator();
    L124:
        if (r131.hasNext() == false) goto L132;
        Object r132 = r131.next();
        com.larus.bmhome.actionbar.model.r r133 = ((com.larus.bmhome.actionbar.model.z0) r132).f295621q;
        if (r133 == null) goto L128;
        Integer r134 = r133.f295408a;
    L130:
        if (Intrinsics.areEqual(r134, r100) == false) goto L124;
        Object r135 = r132;
    L133:
        r116 = (com.larus.bmhome.actionbar.model.z0) r135;
        goto L164
    L128:
        r134 = null;
        goto L130
    L132:
        r135 = null;
        goto L133
    L134:
        r116 = null;
        goto L164
    L16:
        ResultKt.throwOnFailure(r103);
        if (r100 != null) goto L19;
        FLogger.f375446a.e("EditInstructionRouterInterceptor", "getItemDataOfMainActionBar type is null");
        return null;
    L19:
        com.larus.bmhome.chat.api.e0 r136 = AuthModelDelegate.f297134b.e().getValue();
        if (r136 == null) goto L24;
        LaunchInfo r137 = r136.f297186a;
        if (r137 == null) goto L24;
        String r138 = r137.W();
    L25:
        List<com.larus.bmhome.actionbar.model.z0> r139 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r138);
        if (r111.intValue() != 4) goto L28;
    L65:
        if (r139 == null) goto L82;
        Iterator<T> r140 = r139.iterator();
    L68:
        if (r140.hasNext() == false) goto L80;
        Object r141 = r140.next();
        com.larus.bmhome.actionbar.model.r r142 = ((com.larus.bmhome.actionbar.model.z0) r141).f295621q;
        if (r142 == null) goto L77;
        Integer r143 = r142.f295408a;
        if (r143 == null) goto L77;
        if (r143.intValue() != 28) goto L77;
        boolean r144 = true;
    L78:
        if (r144 == false) goto L68;
    L81:
        com.larus.bmhome.actionbar.model.z0 r145 = (com.larus.bmhome.actionbar.model.z0) r141;
    L83:
        FLogger r146 = FLogger.f375446a;
        r146.i("EditInstructionRouterInterceptor", "getMixed from remote success, mainBotId: " + r138 + ", instructionType: " + r100);
        if (r145 != null) goto L137;
        r146.e("EditInstructionRouterInterceptor", "getItemDataOfMainActionBar from cache failed, mainBotId: " + r138 + ", instructionType: " + r100);
        r101.L$0 = r100;
        r101.L$1 = r139;
        r101.label = 1;
        r103 = r110.e(r138, r101);
        if (r103 == r104) goto L166;
        r117 = r139;
        goto L89
    L166:
        return r104;
    L137:
        return r145;
    L77:
        r144 = false;
        goto L78
    L80:
        r141 = null;
        goto L81
    L82:
        r145 = null;
        goto L83
    L28:
        if (r111.intValue() == 18) goto L65;
        if (r139 == null) goto L43;
        Iterator<T> r147 = r139.iterator();
    L33:
        if (r147.hasNext() == false) goto L41;
        Object r148 = r147.next();
        com.larus.bmhome.actionbar.model.r r149 = ((com.larus.bmhome.actionbar.model.z0) r148).f295621q;
        if (r149 == null) goto L37;
        Integer r150 = r149.f295408a;
    L39:
        if (Intrinsics.areEqual(r150, r100) == false) goto L33;
    L42:
        com.larus.bmhome.actionbar.model.z0 r151 = (com.larus.bmhome.actionbar.model.z0) r148;
    L44:
        if (r151 != null) goto L162;
        FLogger.f375446a.e("EditInstructionRouterInterceptor", "getItemDataOfMainActionBar from cache failed, mainBotId: " + r138 + ", instructionType: " + r100);
        r101.L$0 = r100;
        r101.L$1 = r151;
        r101.label = 2;
        r103 = r110.e(r138, r101);
        if (r103 == r104) goto L165;
        r106 = r151;
        goto L49
    L165:
        return r104;
    L162:
        return r151;
    L37:
        r150 = null;
        goto L39
    L41:
        r148 = null;
        goto L42
    L43:
        r151 = null;
    L24:
        r138 = null;
    L7:
        r101 = new EditInstructionRouterInterceptor$getItemDataOfMainActionBar$1(r110, r112);
        goto L8
    }
}
