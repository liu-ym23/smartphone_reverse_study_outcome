package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.android.livesdk.livecommerce.utils.j0;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
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
import vi2.h;
import vi2.q;
import xi2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECAnchorFlashUploadImage$handle$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.hybrid.bridges.ECAnchorFlashUploadImage$handle$1$1", f = "ECAnchorFlashUploadImage.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class ECAnchorFlashUploadImage$handle$$inlined$runCatching$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $base64Str$inlined;
    final /* synthetic */ FlashController $controller$inlined;
    final /* synthetic */ ECBaseBridgeMethod.a $iReturn$inlined;
    int label;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECAnchorFlashUploadImage$handle$$inlined$runCatching$lambda$1 a;

        public a(ECAnchorFlashUploadImage$handle$$inlined$runCatching$lambda$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            h0 r8 = (h0) r7;
            ECBaseBridgeMethod.a r0 = this.a.$iReturn$inlined;
            JSONObject r1 = new JSONObject();
            dm.a.b r2 = dm.a.a("ECAnchorFlashUploadImage");
            StringBuilder r3 = new StringBuilder("picTosKey = ");
            String r4 = null;
            if (r8 == null) goto L7;
            h0.a r5 = r8.data;
            if (r5 == null) goto L7;
            String r6 = r5.picTosKey;
        L8:
            r3.append(r6);
            r2.a(r3.toString());
            if (r8 == null) goto L13;
            h0.a r9 = r8.data;
            if (r9 == null) goto L13;
            String r10 = r9.picTosKey;
        L14:
            r1.put("imgUrl", r10);
            if (r8 == null) goto L17;
            r4 = ((g) r8).statusMessage;
        L17:
            r1.put("errorDesc", r4);
            Unit r11 = Unit.INSTANCE;
            r0.onSuccess(r1);
            return;
        L13:
            r10 = null;
        L7:
            r6 = null;
            goto L8
        }
    }

    public ECAnchorFlashUploadImage$handle$$inlined$runCatching$lambda$1(Continuation r1, FlashController r2, String r3, ECBaseBridgeMethod.a r4) {
        this.$controller$inlined = r2;
        this.$base64Str$inlined = r3;
        this.$iReturn$inlined = r4;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        return new ECAnchorFlashUploadImage$handle$$inlined$runCatching$lambda$1(r5, this.$controller$inlined, this.$base64Str$inlined, this.$iReturn$inlined);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        byte[] r5 = (byte[]) r4;
        if (r5 == null) goto L14;
        int r2 = r5.length;
    L16:
        if (r2 <= 0) goto L18;
        String r3 = h.a;
        String r6 = h.d(si2.g.z);
        h.e(null, null, r6, new q(r6, r5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), com.bytedance.android.livesdk.livecommerce.hybrid.bridges.a.a);
    L20:
        return Unit.INSTANCE;
    L18:
        dm.a.a("ECAnchorFlashUploadImage").b("byteArray is empty", null);
        goto L20
    L14:
        r2 = 0;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        int r7 = j0.a;
        String r8 = this.$base64Str$inlined;
        this.label = 1;
        r4 = j0.a(r8, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
