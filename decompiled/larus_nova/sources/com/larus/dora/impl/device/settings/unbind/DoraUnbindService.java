package com.larus.dora.impl.device.settings.unbind;

import com.bytedance.dora.device.DoraDevice;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraUnbindService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraUnbindService f334932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DoraUnbindStep f334933b;

    public DoraUnbindService() {
    }

    static {
        f334932a = new DoraUnbindService();
        f334933b = DoraUnbindStep.API;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0066 -> B:22:0x0069). Please report as a decompilation issue!!! */
    public final Object a(Continuation<? super DoraUnbindState> r100) {
        if ((r100 instanceof DoraUnbindService$unbind$1) == false) goto L7;
        DoraUnbindService$unbind$1 r101 = (DoraUnbindService$unbind$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        DoraDevice r106 = (DoraDevice) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L22:
        DoraUnbindState r107 = (DoraUnbindState) r103;
        DoraUnbindState r108 = DoraUnbindState.UNBIND_SUCCESS;
        if (r107 == r108) goto L25;
        return r107;
    L25:
        DoraUnbindStep r109 = f334933b.next();
        if (r109 != null) goto L29;
        g49.d.d("DoraUnbindService", "unbind finished");
        f334933b = DoraUnbindStep.API;
        return r108;
    L29:
        f334933b = r109;
    L19:
        g49.d.d("DoraUnbindService", "unbind step: " + f334933b);
        DoraUnbindStep r110 = f334933b;
        r101.L$0 = r106;
        r101.label = 1;
        r103 = r110.step(r106, r101);
        if (r103 != r104) goto L22;
        return r104;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        DoraDevice r111 = kj4.a.g().c();
        if (r111 == null) goto L17;
        r106 = r111;
        goto L19
    L17:
        return DoraUnbindState.NO_DEVICE_CONNECTED;
    L7:
        r101 = new DoraUnbindService$unbind$1(this, r100);
        goto L8
    }
}
