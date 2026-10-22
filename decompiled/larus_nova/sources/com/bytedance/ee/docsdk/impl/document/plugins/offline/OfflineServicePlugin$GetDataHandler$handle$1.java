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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.ee.docsdk.impl.document.plugins.offline.OfflineServicePlugin$GetDataHandler$handle$1", f = "OfflineServicePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineServicePlugin$GetDataHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CallBackFunction $callback;
    final /* synthetic */ OfflineTransferModel $model;
    int label;

    public OfflineServicePlugin$GetDataHandler$handle$1(OfflineTransferModel r100, CallBackFunction r101, Continuation<? super OfflineServicePlugin$GetDataHandler$handle$1> r102) {
        this.$model = r100;
        this.$callback = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfflineServicePlugin$GetDataHandler$handle$1(this.$model, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfflineServicePlugin$GetDataHandler$handle$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r110);
        long r100 = System.currentTimeMillis();
        OfflineTransferModel r111 = this.$model;
        if (r111 == null) goto L31;
        ResourceData r112 = r111.parseResourceData();
        if (r112 == null) goto L31;
        if (TextUtils.isEmpty(r112.getReskey()) == true) goto L31;
        if (TextUtils.isEmpty(r112.getObj_token()) == true) goto L31;
        long r101 = System.currentTimeMillis();
        boolean r102 = false;
        ResourceData r113 = OfflineDataManager.get().loadResourceData(r112.getReskey(), r112.getObj_token(), 0);
        long r103 = System.currentTimeMillis();
        StringBuilder r104 = new StringBuilder("handle()...  dataType = ");
        r104.append(this.$model.getDataType());
        r104.append(" resourceData = ");
        if (r113 != null) goto L15;
        r102 = true;
    L15:
        r104.append(r102);
        r104.append(" cost1 = ");
        r104.append(r101 - r100);
        r104.append(" cost2 = ");
        r104.append(r103 - r101);
        Log.i("OfflineServicePlugin", r104.toString());
        if (r113 != null) goto L20;
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        return Unit.INSTANCE;
    L20:
        if (r113.hasPaged() == false) goto L24;
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        return Unit.INSTANCE;
    L24:
        if (TextUtils.isEmpty(r113.getReskey()) == false) goto L26;
    L28:
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        Log.w("OfflineServicePlugin", "The resValue is null.");
    L30:
        return Unit.INSTANCE;
    L26:
        if (TextUtils.isEmpty(r113.getObj_token()) == true) goto L28;
        OfflineUtils.INSTANCE.onJsSuccessCallback(r113.getResvalue(), this.$callback);
    L31:
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);
        Log.w("OfflineServicePlugin", "GetDataHandler.handle: model is null ");
        return Unit.INSTANCE;
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
