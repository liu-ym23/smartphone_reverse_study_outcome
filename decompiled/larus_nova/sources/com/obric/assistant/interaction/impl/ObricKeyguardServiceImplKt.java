package com.obric.assistant.interaction.impl;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tH\u0080@¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TOP_ACTIVITY_KEYGUARD_CHECK_COUNT", "", "TOP_ACTIVITY_KEYGUARD_CHECK_INTERVAL_MS", "", "waitForTopActivityKeyguardUnlocked", "", "isKeyguardLocked", "Lkotlin/Function0;", "waitForNextCheck", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ObricKeyguardServiceImplKt {
    private static final int TOP_ACTIVITY_KEYGUARD_CHECK_COUNT = 3;
    private static final long TOP_ACTIVITY_KEYGUARD_CHECK_INTERVAL_MS = 500;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.ObricKeyguardServiceImplKt$waitForTopActivityKeyguardUnlocked$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricKeyguardServiceImplKt", f = "ObricKeyguardServiceImpl.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER}, m = "waitForTopActivityKeyguardUnlocked", n = {"isKeyguardLocked", "waitForNextCheck"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return ObricKeyguardServiceImplKt.waitForTopActivityKeyguardUnlocked(null, null, this);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005b -> B:27:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0074 -> B:26:0x007a). Please report as a decompilation issue!!! */
    public static final Object waitForTopActivityKeyguardUnlocked(Function0<Boolean> r100, Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Boolean> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r102.I$1;
        int r107 = r102.I$0;
        Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r108 = (Function2) r102.L$1;
        Function0<Boolean> r109 = (Function0) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L26:
        int r112 = r107;
        Function0<Boolean> r113 = r109;
        Object r114 = r104;
        AnonymousClass1 r115 = r102;
        Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r116 = r108;
        Object r117 = r114;
    L27:
        r106 = r106 + 1;
    L15:
        if (r106 >= r112) goto L29;
        if (r113.invoke().booleanValue() == true) goto L21;
        return Boxing.boxBoolean(true);
    L21:
        if (r106 >= 2) goto L27;
        Long r118 = Boxing.boxLong(500);
        r115.L$0 = r113;
        r115.L$1 = r116;
        r115.I$0 = r112;
        r115.I$1 = r106;
        r115.label = 1;
        if (r116.invoke(r118, r115) != r117) goto L25;
        return r117;
    L25:
        r109 = r113;
        r107 = r112;
        Object r119 = r117;
        r108 = r116;
        r102 = r115;
        r104 = r119;
        goto L26
    L29:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r112 = 3;
        r117 = r104;
        r115 = r102;
        r116 = r101;
        r113 = r100;
        r106 = 0;
    L7:
        r102 = new AnonymousClass1(r110);
        goto L8
    }
}
