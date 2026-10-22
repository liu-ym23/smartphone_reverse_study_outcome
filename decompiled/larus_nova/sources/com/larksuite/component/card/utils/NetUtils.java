package com.larksuite.component.card.utils;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public final class NetUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283948a = 0;

    public static final class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Response> f283949a;

        public a(kotlinx.coroutines.j r100) {
            this.f283949a = r100;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call r100, IOException r101) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r101, "e");
            kotlinx.coroutines.i<Response> r102 = this.f283949a;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r101)));
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call r100, Response r101) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r101, "response");
            this.f283949a.resumeWith(Result.m9449constructorimpl(r101));
        }
    }

    static {
    }

    public static Object a(String r100, Continuation r101) {
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        final Call r103 = new OkHttpClient.Builder().build().newCall(new Request.Builder().url(r100).build());
        r103.enqueue(new a(r102));
        r102.i(new NetUtils$getSuspend$2$2(r103));
        Object r104 = r102.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L5:
        return r104;
    }
}
