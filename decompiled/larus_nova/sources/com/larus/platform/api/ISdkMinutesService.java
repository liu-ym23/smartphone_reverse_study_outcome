package com.larus.platform.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
public interface ISdkMinutesService {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static Object a(final ISdkMinutesService r100, Continuation<? super Flow<Boolean>> r101) {
            if ((r101 instanceof ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1) == false) goto L7;
            ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1 r102 = (ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            r100 = (ISdkMinutesService) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L17:
            final kotlinx.coroutines.flow.i1 r107 = (kotlinx.coroutines.flow.i1) r104;
            if (r107 != null) goto L22;
            return null;
        L22:
            return new ISdkMinutesService$DefaultImpls$getRecordingOrInterpretationInProgressFlow$$inlined$map$1(r107, r100);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            r102.L$0 = r100;
            r102.label = 1;
            r104 = r100.b(r102);
            if (r104 != r105) goto L17;
            return r105;
        L7:
            r102 = new ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1(r101);
            goto L8
        }
    }

    void A0(String r100, String r101);

    void B0();

    void a(String r100);

    Object b(Continuation<? super kotlinx.coroutines.flow.i1<Triple<String, Integer, Integer>>> r100);

    void c(Fragment r100, String r101, String r102, String r103, Map r104, String r105, com.larus.office.card.minutes.model.j r106);

    boolean d();

    void e(Context r100, String r101, String r102, String r103);

    void f(Fragment r100, String r101, String r102, String r103, Map r104, String r105, com.larus.office.card.minutes.model.j r106);

    String getDeviceId();

    boolean j();

    String k();

    kotlinx.coroutines.flow.i1<Pair<String, Long>> l();

    boolean m();

    void n(String r100);

    void o(String r100, boolean r101);

    boolean y0();

    kotlinx.coroutines.flow.i1<Pair<String, String>> z0();
}
