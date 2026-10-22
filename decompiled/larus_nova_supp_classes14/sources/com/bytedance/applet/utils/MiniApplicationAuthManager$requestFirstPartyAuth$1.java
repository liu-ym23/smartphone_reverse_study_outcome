package com.bytedance.applet.utils;

import android.text.SpannableStringBuilder;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.api.OperateResult;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.DismissReason;
import com.larus.login.api.LoginService;
import com.larus.login.api.NotifyBinderDialogType;
import com.larus.login.api.g0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.MiniApplicationAuthManager$requestFirstPartyAuth$1", f = "MiniApplicationAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniApplicationAuthManager$requestFirstPartyAuth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<OperateResult, String, Unit> $callback;
    final /* synthetic */ com.bytedance.ai.api.p $config;
    final /* synthetic */ boolean $isMiniApplication;
    final /* synthetic */ String $optionalScope;
    final /* synthetic */ String $requiredScope;
    final /* synthetic */ Map<String, Object> $traceInfo;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DismissReason.values().length];
            r0[DismissReason.Confirm.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public MiniApplicationAuthManager$requestFirstPartyAuth$1(com.bytedance.ai.api.p r1, Map<String, ? extends Object> r2, boolean r3, String r4, String r5, Function2<? super OperateResult, ? super String, Unit> r6, Continuation<? super MiniApplicationAuthManager$requestFirstPartyAuth$1> r7) {
        this.$config = r1;
        this.$traceInfo = r2;
        this.$isMiniApplication = r3;
        this.$requiredScope = r4;
        this.$optionalScope = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MiniApplicationAuthManager$requestFirstPartyAuth$1(this.$config, this.$traceInfo, this.$isMiniApplication, this.$requiredScope, this.$optionalScope, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L45;
        ResultKt.throwOnFailure(r21);
        if ((System.currentTimeMillis() - o.a) < 500) goto L7;
        o.a = System.currentTimeMillis();
        FragmentActivity r1 = AppHost.a.a().getTopActivity();
        WeakReference<g0> r3 = null;
        if ((r1 instanceof FragmentActivity) == false) goto L11;
        final FragmentActivity r5 = r1;
    L12:
        if (r5 == null) goto L14;
        FragmentManager r2 = r5.getSupportFragmentManager();
        WeakReference<g0> r4 = o.b;
        if (r4 == null) goto L18;
        g0 r6 = r4.get();
    L20:
        if ((r6 instanceof DialogFragment) == false) goto L22;
        DialogFragment r7 = (DialogFragment) r6;
    L23:
        if (r7 == null) goto L27;
        boolean r8 = true;
        if (r7.isVisible() != true) goto L27;
    L28:
        if (r8 == false) goto L32;
        return Unit.INSTANCE;
    L32:
        if (r2.isStateSaved() == true) goto L34;
        JSONObject r9 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r10 = this.$traceInfo.entrySet().iterator();
    L37:
        if (r10.hasNext() == false) goto L39;
        Map.Entry<String, Object> r11 = r10.next();
        r9.put(r11.getKey(), r11.getValue());
        goto L37
    L39:
        com.larus.platform.service.o.a.reportEvent("bind_douyin_popup_show", r9);
        Integer r12 = Boxing.boxInt(2131239970);
        com.bytedance.ai.api.p r13 = this.$config;
        String r14 = r13.d;
        LoginService r15 = LoginService.a;
        SpannableStringBuilder r16 = r15.g(r5, r13.e);
        com.bytedance.ai.api.p r17 = this.$config;
        com.larus.login.api.i r18 = new com.larus.login.api.i(r12, null, r14, r16, r17.f, r17.g, false, null, null, false, 32450);
        final Map<String, Object> r19 = this.$traceInfo;
        final boolean r20 = this.$isMiniApplication;
        final String r22 = this.$requiredScope;
        final String r23 = this.$optionalScope;
        final Function2<OperateResult, String, Unit> r110 = this.$callback;
        g0 r24 = r15.M(r2, new com.larus.login.api.h(r18, null, new s(r5, r19, r20, r22, r23, r110), 14), NotifyBinderDialogType.CheckNeedBinder);
        WeakReference<g0> r25 = o.b;
        if (r24 == null) goto L42;
        r3 = new WeakReference(r24);
    L42:
        o.b = r3;
        return Unit.INSTANCE;
    L34:
        return Unit.INSTANCE;
    L27:
        r8 = false;
        goto L28
    L22:
        r7 = null;
        goto L23
    L18:
        r6 = null;
        goto L20
    L14:
        return Unit.INSTANCE;
    L11:
        r5 = null;
        goto L12
    L7:
        return Unit.INSTANCE;
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
