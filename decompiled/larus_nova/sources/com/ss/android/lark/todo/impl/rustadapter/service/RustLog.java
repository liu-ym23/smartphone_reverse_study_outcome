package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.squareup.wire.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class RustLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444237a = 0;

    public interface a<T> extends SdkSender.IParser<T> {
        String a(T r100);
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f444238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ErrorResult f444239b;

        public b(T r100, ErrorResult r101) {
            this.f444238a = r100;
            this.f444239b = r101;
        }
    }

    static {
    }

    public static Object a(final Command r100, Message.Builder r110, final a r111, String r112, Continuation r113) {
        final kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r113), 1);
        r101.C();
        final String r102 = com.ss.android.lark.sdk.a.a();
        final long r103 = System.currentTimeMillis();
        int r104 = com.ss.android.lark.todo.impl.utils.g.f444289a;
        Intrinsics.checkNotNull(r102);
        Log.i("TaskRustLog", com.ss.android.lark.todo.impl.utils.g.e(r102, r100.toString(), new String[]{HiAnalyticsConstant.Direction.REQUEST, r112}));
        SdkSender.asynSendRequestNonWrap(r100, r110, new RustLog$sdkRequestWithErr$2$1(r102, r100, r111, r101, r103), r111);
        Object r105 = r101.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r113);
    L5:
        return r105;
    }
}
