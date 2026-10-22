package com.bytedance.ee.docsdk.impl.document.plugins.offline;

import android.util.Pair;
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
@DebugMetadata(c = "com.bytedance.ee.docsdk.impl.document.plugins.offline.OfflineServicePlugin$SetDataHandler$addDataToStorage$1", f = "OfflineServicePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineServicePlugin$SetDataHandler$addDataToStorage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CallBackFunction $callback;
    final /* synthetic */ ResourceData $data;
    final /* synthetic */ long $start;
    int label;

    public OfflineServicePlugin$SetDataHandler$addDataToStorage$1(ResourceData r100, long r101, CallBackFunction r102, Continuation<? super OfflineServicePlugin$SetDataHandler$addDataToStorage$1> r103) {
        this.$data = r100;
        this.$start = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfflineServicePlugin$SetDataHandler$addDataToStorage$1(this.$data, this.$start, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfflineServicePlugin$SetDataHandler$addDataToStorage$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r110);
        long r100 = System.currentTimeMillis();
        ResourceData r101 = OfflineDataManager.get().loadSubInfo(this.$data.getObj_token(), this.$data.getReskey(), 0);     // Catch: Exception -> L19
        long r111 = System.currentTimeMillis();     // Catch: Exception -> L19
        if (r101 != null) goto L8;
    L13:
        Pair<Long, String> r102 = OfflineDataManager.get().insertResourceData(this.$data);     // Catch: Exception -> L19
        long r112 = ((Number) r102.first).longValue();     // Catch: Exception -> L19
        String r103 = (String) r102.second;     // Catch: Exception -> L19
    L14:
        Log.i("OfflineServicePlugin", "addDataToStorage()...  dataType = " + this.$data.getDataType() + " ret = " + r112 + " cost1 = " + (r100 - this.$start) + " cost2 = " + (r111 - r100) + " cost3 = " + (System.currentTimeMillis() - r111));     // Catch: Exception -> L19
        if (r112 <= 0) goto L17;
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L17:
        OfflineUtils.INSTANCE.onJsFailCallback("insert error " + r103, "", this.$callback);     // Catch: Exception -> L19
        throw new RuntimeException("SetDataHandler ret <= 0   ret: " + r112);     // Catch: Exception -> L19
    L8:
        if (r101.getId() <= 0) goto L13;
        this.$data.setId(r101.getId());     // Catch: Exception -> L19
        this.$data.setSubblock_preload_status(r101.getSubblock_preload_status());     // Catch: Exception -> L19
        this.$data.setLoadFrom(r101.getLoadFrom());     // Catch: Exception -> L19
        r112 = OfflineDataManager.get().updateResourceData(this.$data);     // Catch: Exception -> L19
        if (r112 > 0) goto L12;
        Log.i("OfflineServicePlugin", "updateResourceData fail! ret = " + r112);     // Catch: Exception -> L19
        Pair<Long, String> r104 = OfflineDataManager.get().insertResourceData(this.$data);     // Catch: Exception -> L19
        r112 = ((Number) r104.first).longValue();     // Catch: Exception -> L19
        r103 = (String) r104.second;     // Catch: Exception -> L19
        goto L14
    L12:
        r103 = "";
    L19:
        e = move-exception;
        OfflineUtils.INSTANCE.onJsFailCallback("unkonw error " + e.getMessage(), "", this.$callback);
        Log.e("OfflineServicePlugin", "addDataToStorage: ", e);
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
