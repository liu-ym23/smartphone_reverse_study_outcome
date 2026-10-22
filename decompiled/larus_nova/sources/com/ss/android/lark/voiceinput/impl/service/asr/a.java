package com.ss.android.lark.voiceinput.impl.service.asr;

import com.ss.android.lark.voiceinput.impl.service.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes38.dex */
public interface a extends bbc.a, b {

    /* JADX INFO: renamed from: com.ss.android.lark.voiceinput.impl.service.asr.a$a, reason: collision with other inner class name */
    public static final class C5386a {
        public static Object a(Continuation r100) {
            if ((r100 instanceof IVoiceAsr$retryIoAF18A) == false) goto L7;
            IVoiceAsr$retryIoAF18A r101 = (IVoiceAsr$retryIoAF18A) r100;
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
            return ((Result) r103).m9458unboximpl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            r101.label = 1;
            Result.Companion r106 = Result.Companion;
            Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(new UnsupportedOperationException("retry is not supported")));
            if (r107 != r104) goto L18;
            return r104;
        L18:
            return r107;
        L7:
            r101 = new IVoiceAsr$retryIoAF18A(r100);
            goto L8
        }

        public static Object b(Continuation r100) {
            if ((r100 instanceof IVoiceAsr$switchLanguagegIAlus) == false) goto L7;
            IVoiceAsr$switchLanguagegIAlus r101 = (IVoiceAsr$switchLanguagegIAlus) r100;
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
            return ((Result) r103).m9458unboximpl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            r101.label = 1;
            Result.Companion r106 = Result.Companion;
            Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(new UnsupportedOperationException("switch language is not supported")));
            if (r107 != r104) goto L18;
            return r104;
        L18:
            return r107;
        L7:
            r101 = new IVoiceAsr$switchLanguagegIAlus(r100);
            goto L8
        }
    }

    b1 a();

    Object b(Continuation<? super Result<Unit>> r100);

    Object c(Continuation<? super Result<Unit>> r100);

    Object e(abc.b r100, Continuation<? super Result<Unit>> r101);

    d1<yac.a> getEvents();

    Object h(String r100, abc.a r101);

    void m(d r100);
}
