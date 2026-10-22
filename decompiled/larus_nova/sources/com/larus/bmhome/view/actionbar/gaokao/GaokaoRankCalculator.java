package com.larus.bmhome.view.actionbar.gaokao;

import android.content.Context;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoProvinceZhiyuanResponse;
import com.larus.nova.R;
import com.larus.utils.o0;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class GaokaoRankCalculator {
    public GaokaoRankCalculator() {
    }

    public final Object a(Context r100, String r101, String r102, String r103, Continuation<? super String> r110) {
        if ((r110 instanceof GaokaoRankCalculator$calculateRank$1) == false) goto L7;
        GaokaoRankCalculator$calculateRank$1 r104 = (GaokaoRankCalculator$calculateRank$1) r110;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r111 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = (Context) r104.L$0;
        ResultKt.throwOnFailure(r111);
    L21:
        dm9.a r112 = (dm9.a) r111;
        if ((r112 instanceof dm9.a.b) == false) goto L30;
        GaokaoProvinceZhiyuanResponse r108 = (GaokaoProvinceZhiyuanResponse) ((dm9.a.b) r112).f469231a.getData();
        if (r108 == null) goto L26;
        String r109 = r108.getRank();
    L28:
        if (o0.d(r109) == false) goto L31;
        return r109;
    L31:
        return null;
    L26:
        r109 = null;
        goto L28
    L30:
        t19.s.f544207a.g(r100, R.string.larus_call_camera_internet_error_toast, false);
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (r103 != null) goto L18;
        return "";
    L18:
        CoroutineDispatcher r113 = Dispatchers.getIO();
        GaokaoRankCalculator$calculateRank$result$1 r114 = new GaokaoRankCalculator$calculateRank$result$1(r101, r102, r103, null);
        r104.L$0 = r100;
        r104.label = 1;
        r111 = BuildersKt.withContext(r113, r114, r104);
        if (r111 != r106) goto L21;
        return r106;
    L7:
        r104 = new GaokaoRankCalculator$calculateRank$1(this, r110);
        goto L8
    }
}
