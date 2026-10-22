package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.utils.j0;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.net.URI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECAnchorFlashScreenShot$handle$1$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.hybrid.bridges.ECAnchorFlashScreenShot$handle$1$1$1", f = "ECAnchorFlashScreenShot.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath$inlined;
    int label;
    final /* synthetic */ ECAnchorFlashScreenShot$handle$1 this$0;

    public ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1(Continuation r1, ECAnchorFlashScreenShot$handle$1 r2, String r3) {
        this.this$0 = r2;
        this.$filePath$inlined = r3;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1(r4, this.this$0, this.$filePath$inlined);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        String r7 = (String) r6;
        dm.a.a("ECAnchorFlashScreenShot").a("base64Str = " + r7);
        if (r7 != null) goto L14;
    L17:
        if (r2 == true) goto L19;
        ECBaseBridgeMethod.a r3 = this.this$0.$iReturn;
        JSONObject r4 = new JSONObject();
        r4.put("img", "data:image/jpeg;base64," + r7);
        Unit r8 = Unit.INSTANCE;
        r3.onSuccess(r4);
    L21:
        return Unit.INSTANCE;
    L19:
        dm.a.a("ECAnchorFlashScreenShot").b("base64Str is empty", null);
        goto L21
    L14:
        if (r7.length() == 0) goto L17;
        r2 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        int r9 = j0.a;
        PolarisFileWrapper r10 = new PolarisFileWrapper(new URI(this.$filePath$inlined));
        this.label = 1;
        r6 = j0.b(r10, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
