package com.bytedance.android.livesdk.livecommerce.userinfo.fragment.repository;

import io.reactivex.Observable;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class AbsRepository {
    public AbsRepository() {
    }

    public static /* synthetic */ Object b(AbsRepository r6, Function0 r7, Continuation r8) {
        return r6.a(5, 500, r7, r8);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0053 -> B:26:0x0072). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0068 -> B:25:0x006d). Please report as a decompilation issue!!! */
    public final <V> Object a(int r6, long r7, Function0<? extends Observable<V>> r9, Continuation<? super Observable<V>> r10) {
        if ((r10 instanceof AbsRepository$tryGetObservable$1) == false) goto L7;
        AbsRepository$tryGetObservable$1 r0 = (AbsRepository$tryGetObservable$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = r0.I$2;
        int r8 = r0.I$1;
        long r12 = r0.J$0;
        int r4 = r0.I$0;
        Function0<? extends Observable<V>> r5 = (Function0) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L25:
        int r13 = r8;
        int r14 = r4;
        Object r15 = r2;
        AbsRepository$tryGetObservable$1 r16 = r0;
        Function0<? extends Observable<V>> r17 = r5;
    L26:
        r13 = r13 + 1;
    L15:
        if (r13 >= r6) goto L27;
        Observable r18 = (Observable) r17.invoke();
        if (r18 == null) goto L20;
        return r18;
    L20:
        if (r13 >= (r14 - 1)) goto L26;
        r16.L$0 = r17;
        r16.I$0 = r14;
        r16.J$0 = r12;
        r16.I$1 = r13;
        r16.I$2 = r6;
        r16.label = 1;
        if (DelayKt.delay(r12, r16) != r15) goto L24;
        return r15;
    L24:
        r5 = r17;
        r0 = r16;
        r2 = r15;
        r4 = r14;
        r8 = r13;
        goto L25
    L27:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r13 = 0;
        r15 = r2;
        r16 = r0;
        r17 = r9;
        r12 = r7;
        r14 = r6;
    L7:
        r0 = new AbsRepository$tryGetObservable$1(this, r10);
        goto L8
    }
}
