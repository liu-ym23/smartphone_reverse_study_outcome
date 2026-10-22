package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvControlWidget$onCreate$4$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.viewmodel.i, Unit> {
    public KtvControlWidget$onCreate$4$1(KtvControlWidget r8) {
        super(1, r8, KtvControlWidget.class, "handleVoiceSceneChange", "handleVoiceSceneChange(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.chatroom.viewmodel.i r8) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        final KtvControlWidget r0 = (KtvControlWidget) ((CallableReference) this).receiver;
        int r1 = KtvControlWidget.v;
        r0.getClass();
        int r2 = r8.a;
        boolean r3 = false;
        if (r2 == 9) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r2 == 9) goto L10;
    L12:
        boolean r4 = false;
    L13:
        KtvUtilsKt.l(r5, r4);
        String r6 = "event:" + r8.a;
        ALogger.i(bb0.b.b(), r6 + ", invoke class :KtvControlWidget");
        ALogger.i(r0.d, "handleVoiceSceneChange:$" + r8.a);
        Integer r7 = Integer.valueOf(r8.a);
        if (r7.intValue() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L20;
        r7 = null;
    L20:
        if (r7 == null) goto L34;
        int r10 = r7.intValue();
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isEnterKtvDirectly() != null) goto L27;
        KtvContext r11 = KtvContext.a.g();
        if (r8.a != 9) goto L26;
        r3 = true;
    L26:
        r11.setEnterKtvDirectly(Boolean.valueOf(r3));
    L29:
        if (r0.r == null) goto L33;
        if (r10 == 9) goto L33;
        if (r10 == 9) goto L33;
        Long r12 = KtvLoggerHelper.a;
        KtvLoggerHelper.e0("switch_function_type");
        KtvLoggerHelper.d0("mode_switch");
    L33:
        r0.r = Integer.valueOf(r8.a);
        goto L34
    L27:
        KtvContext.a.g().setEnterKtvDirectly(Boolean.FALSE);
    L34:
        final int r13 = r8.a;
        Lazy r14 = KtvCommonSettingHelper.a;
        Intrinsics.checkNotNullParameter(new KtvControlWidget$onSceneChanged$1(r0, r13), "cb");
        r0.xq();
        return;
    L16:
        r9 = false;
        goto L17
    L10:
        if (r8.b != 61) goto L12;
        r4 = true;
        goto L13
    L5:
        if (r8.b != 0) goto L7;
        r5 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.chatroom.viewmodel.i) r1);
        return Unit.INSTANCE;
    }
}
