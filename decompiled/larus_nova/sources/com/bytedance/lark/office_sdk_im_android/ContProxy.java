package com.bytedance.lark.office_sdk_im_android;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/ContProxy;", "Lcom/bytedance/lark/office_sdk_im_android/MoltenFFICallback;", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "callbackObj", "", "getCallbackObj", "()Ljava/lang/Object;", "into", "", "onInvoke", "methodId", "params", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ContProxy implements MoltenFFICallback {
    private final Continuation<byte[]> cont;

    public final long into() {
        return CallbackInstance.INSTANCE.registerInstance(this);
    }

    @Override // com.bytedance.lark.office_sdk_im_android.MoltenFFICallback
    public Object getCallbackObj() {
        return this.cont;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContProxy(Continuation<? super byte[]> r100) {
        Intrinsics.checkNotNullParameter(r100, "cont");
        this.cont = r100;
    }

    @Override // com.bytedance.lark.office_sdk_im_android.MoltenFFICallback
    public byte[] onInvoke(long r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != 1) goto L7;
        this.cont.resumeWith(Result.m9449constructorimpl(r101));
        return new byte[0];
    L7:
        if (r100 != 2) goto L10;
        Continuation<byte[]> r102 = this.cont;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException(new String(r101, Charsets.UTF_8)))));
        return new byte[0];
    L10:
        Continuation<byte[]> r104 = this.cont;
        Result.Companion r105 = Result.Companion;
        r104.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("Unknown method[" + r100 + "] when invoke callback."))));
        return new byte[0];
    }

    @Override // com.bytedance.lark.office_sdk_im_android.MoltenFFICallback
    public void onInvokeAsync(long r100, long r101, byte[] r102) {
        MoltenFFICallback.DefaultImpls.onInvokeAsync(this, r100, r101, r102);
    }
}
