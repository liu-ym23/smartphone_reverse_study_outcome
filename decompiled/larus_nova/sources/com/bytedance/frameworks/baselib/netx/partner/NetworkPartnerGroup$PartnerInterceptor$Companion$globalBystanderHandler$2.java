package com.bytedance.frameworks.baselib.netx.partner;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/frameworks/baselib/netx/partner/NetworkPartnerGroup$PartnerInterceptor$Companion$globalBystanderHandler$2$a", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/frameworks/baselib/netx/partner/NetworkPartnerGroup$PartnerInterceptor$Companion$globalBystanderHandler$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class NetworkPartnerGroup$PartnerInterceptor$Companion$globalBystanderHandler$2 extends Lambda implements Function0<a> {
    public static final NetworkPartnerGroup$PartnerInterceptor$Companion$globalBystanderHandler$2 INSTANCE = null;

    public static final class a extends Handler {
        public a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.dispatchMessage(r100);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        INSTANCE = new NetworkPartnerGroup$PartnerInterceptor$Companion$globalBystanderHandler$2();
    }

    public NetworkPartnerGroup$PartnerInterceptor$Companion$globalBystanderHandler$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("PartnerBystanderThread");
        ThreadMethodProxy.start(r100);
        return new a(r100.getLooper());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
