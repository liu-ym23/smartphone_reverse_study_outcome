package com.bytedance.applet.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.bytedance.applet.databinding.LarusAppletWebBrowserBinding;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment$floatingSpeakerController$1$setChatInputVisible$1", f = "AppletFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletFragment$floatingSpeakerController$1$setChatInputVisible$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $focusAtEnd;
    final /* synthetic */ boolean $visible;
    int label;
    final /* synthetic */ AppletFragment this$0;
    final /* synthetic */ AppletFragment$floatingSpeakerController$1 this$1;

    public AppletFragment$floatingSpeakerController$1$setChatInputVisible$1(boolean r1, boolean r2, AppletFragment r3, AppletFragment$floatingSpeakerController$1 r4, Continuation<? super AppletFragment$floatingSpeakerController$1$setChatInputVisible$1> r5) {
        this.$visible = r1;
        this.$focusAtEnd = r2;
        this.this$0 = r3;
        this.this$1 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AppletFragment$floatingSpeakerController$1$setChatInputVisible$1(this.$visible, this.$focusAtEnd, this.this$0, this.this$1, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static View INVOKEVIRTUAL_com_bytedance_applet_view_AppletFragment$floatingSpeakerController$1$setChatInputVisible$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L89;
        ResultKt.throwOnFailure(r6);
        FLogger.a.d("FloatingSpeaker", "setChatInputVisible " + this.$visible + ' ' + this.$focusAtEnd);
        AppletFragment r7 = this.this$0;
        int r0 = AppletFragment.J;
        if (r7.W90() == false) goto L7;
        LarusAppletWebBrowserBinding r8 = this.this$0.f;
        Integer r2 = null;
        if (r8 == null) goto L17;
        FloatingSpeakerView r9 = r8.f;
        if (r9 == null) goto L17;
        if (r9.getVisibility() != 0) goto L15;
        boolean r10 = true;
    L16:
        Boolean r11 = Boxing.boxBoolean(r10);
    L18:
        LarusAppletWebBrowserBinding r3 = this.this$0.f;
        if (r3 == null) goto L28;
        FloatingSpeakerView r4 = r3.f;
        if (r4 == null) goto L28;
        if (this.$visible == false) goto L25;
        int r5 = 0;
    L26:
        r4.setVisibility(r5);
        goto L28
    L25:
        r5 = 8;
    L28:
        if (((Boolean) this.this$0.G.getValue()).booleanValue() == false) goto L37;
        LarusAppletWebBrowserBinding r12 = this.this$0.f;
        if (r12 == null) goto L35;
        FloatingSpeakerView r13 = r12.f;
        if (r13 == null) goto L35;
        r13.setEnable(true);
    L35:
        return Unit.INSTANCE;
    L37:
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(false)) == false) goto L58;
        if (this.$visible == false) goto L58;
        AppletFragment$floatingSpeakerController$1 r14 = this.this$1;
        Window r1 = (Window) this.this$0.I.invoke();
        if (r1 == null) goto L45;
        WindowManager.LayoutParams r15 = r1.getAttributes();
        if (r15 == null) goto L45;
        r2 = Boxing.boxInt(r15.softInputMode);
    L45:
        r14.a = r2;
        Window r16 = (Window) this.this$0.I.invoke();
        if (r16 == null) goto L48;
        r16.setSoftInputMode(18);
    L48:
        AppletFragment$floatingSpeakerController$1 r17 = this.this$1;
        if (r17.f != null) goto L82;
        r17.f = new AppletFragment$floatingSpeakerController$1.KeyBoardLayoutListener(r17);
        Window r18 = (Window) this.this$0.I.invoke();
        if (r18 == null) goto L82;
        View r19 = INVOKEVIRTUAL_com_bytedance_applet_view_AppletFragment$floatingSpeakerController$1$setChatInputVisible$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r18);
        if (r19 == null) goto L82;
        ViewTreeObserver r20 = r19.getViewTreeObserver();
        if (r20 == null) goto L82;
        r20.addOnGlobalLayoutListener(this.this$1.f);
    L82:
        if (this.$focusAtEnd == false) goto L87;
        if (this.$visible == false) goto L87;
        SoftReference r21 = y.a;
        final AppletFragment r22 = this.this$0;
        Runnable r23 = new q(r22);
        Intrinsics.checkNotNullParameter(r23, "action");
        y.d(r23, 501);
    L87:
        return Unit.INSTANCE;
    L58:
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == false) goto L82;
        if (this.$visible == true) goto L82;
        Integer r24 = this.this$1.a;
        if (r24 == null) goto L67;
        AppletFragment r25 = this.this$0;
        int r26 = r24.intValue();
        Window r27 = (Window) r25.I.invoke();
        if (r27 == null) goto L67;
        r27.setSoftInputMode(r26);
    L67:
        if (this.this$1.f == null) goto L82;
        Window r28 = (Window) this.this$0.I.invoke();
        if (r28 == null) goto L75;
        View r29 = INVOKEVIRTUAL_com_bytedance_applet_view_AppletFragment$floatingSpeakerController$1$setChatInputVisible$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r28);
        if (r29 == null) goto L75;
        ViewTreeObserver r30 = r29.getViewTreeObserver();
        if (r30 == null) goto L75;
        r30.removeOnGlobalLayoutListener(this.this$1.f);
    L75:
        AppletFragment$floatingSpeakerController$1.KeyBoardLayoutListener r31 = this.this$1.f;
        if (r31 == null) goto L80;
        Job r32 = r31.a;
        if (r32 == null) goto L80;
        Job.DefaultImpls.cancel$default(r32, null, 1, null);
    L80:
        this.this$1.f = null;
        goto L82
    L15:
        r10 = false;
    L17:
        r11 = null;
        goto L18
    L7:
        return Unit.INSTANCE;
    L89:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
