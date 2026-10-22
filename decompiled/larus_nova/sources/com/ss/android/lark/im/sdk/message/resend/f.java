package com.ss.android.lark.im.sdk.message.resend;

import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f425960a = null;

    static {
        f425960a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        s r101 = (s) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return t.e(r101, FinalResendMessageStepV2$callSdkPreResendMessage$1$1.INSTANCE);
    }
}
