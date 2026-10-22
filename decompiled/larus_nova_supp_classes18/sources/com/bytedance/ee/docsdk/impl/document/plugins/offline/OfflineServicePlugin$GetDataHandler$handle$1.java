package com.bytedance.ee.docsdk.impl.document.plugins.offline;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.OfflineDataManager;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.utils.OfflineUtils;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.ee.docsdk.impl.document.plugins.offline.OfflineServicePlugin$GetDataHandler$handle$1", f = "OfflineServicePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineServicePlugin$GetDataHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CallBackFunction $callback;
    final /* synthetic */ OfflineTransferModel $model;
    int label;

    public OfflineServicePlugin$GetDataHandler$handle$1(OfflineTransferModel r1, CallBackFunction r2, Continuation<? super OfflineServicePlugin$GetDataHandler$handle$1> r3) {
        this.$model = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OfflineServicePlugin$GetDataHandler$handle$1(this.$model, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r12);
        long r0 = System.currentTimeMillis();
        OfflineTransferModel r13 = this.$model;
        if (r13 == null) goto L31;
        ResourceData r14 = r13.parseResourceData();
        if (r14 == null) goto L31;
        if (TextUtils.isEmpty(r14.getReskey()) == true) goto L31;
        if (TextUtils.isEmpty(r14.getObj_token()) == true) goto L31;
        long r4 = System.currentTimeMillis();
        boolean r8 = false;
        ResourceData r15 = OfflineDataManager.get().loadResourceData(r14.getReskey(), r14.getObj_token(), 0);
        long r6 = System.currentTimeMillis();
        StringBuilder r9 = new StringBuilder("handle()...  dataType = ");
        r9.append(this.$model.getDataType());
        r9.append(" resourceData = ");
        if (r15 != null) goto L15;
        r8 = true;
    L15:
        r9.append(r8);
        r9.append(" cost1 = ");
        r9.append(r4 - r0);
        r9.append(" cost2 = ");
        r9.append(r6 - r4);
        Log.i("OfflineServicePlugin", r9.toString());
        if (r15 != null) goto L20;
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        return Unit.INSTANCE;
    L20:
        if (r15.hasPaged() == false) goto L24;
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        return Unit.INSTANCE;
    L24:
        if (TextUtils.isEmpty(r15.getReskey()) == false) goto L26;
    L28:
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        Log.w("OfflineServicePlugin", "The resValue is null.");
    L30:
        return Unit.INSTANCE;
    L26:
        if (TextUtils.isEmpty(r15.getObj_token()) == true) goto L28;
        OfflineUtils.INSTANCE.onJsSuccessCallback(r15.getResvalue(), this.$callback);
    L31:
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        Log.w("OfflineServicePlugin", "GetDataHandler.handle: model is null ");
        return Unit.INSTANCE;
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
