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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.ee.docsdk.impl.document.plugins.offline.OfflineServicePlugin$SetDataHandler$addDataToStorage$1", f = "OfflineServicePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineServicePlugin$SetDataHandler$addDataToStorage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CallBackFunction $callback;
    final /* synthetic */ ResourceData $data;
    final /* synthetic */ long $start;
    int label;

    public OfflineServicePlugin$SetDataHandler$addDataToStorage$1(ResourceData r1, long r2, CallBackFunction r4, Continuation<? super OfflineServicePlugin$SetDataHandler$addDataToStorage$1> r5) {
        this.$data = r1;
        this.$start = r2;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new OfflineServicePlugin$SetDataHandler$addDataToStorage$1(this.$data, this.$start, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r19);
        long r7 = System.currentTimeMillis();
        ResourceData r9 = OfflineDataManager.get().loadSubInfo(this.$data.getObj_token(), this.$data.getReskey(), 0);     // Catch: Exception -> L19
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L19
        if (r9 != null) goto L8;
    L13:
        Pair<Long, String> r6 = OfflineDataManager.get().insertResourceData(this.$data);     // Catch: Exception -> L19
        long r14 = ((Number) r6.first).longValue();     // Catch: Exception -> L19
        String r8 = (String) r6.second;     // Catch: Exception -> L19
    L14:
        Log.i("OfflineServicePlugin", "addDataToStorage()...  dataType = " + this.$data.getDataType() + " ret = " + r14 + " cost1 = " + (r7 - this.$start) + " cost2 = " + (r10 - r7) + " cost3 = " + (System.currentTimeMillis() - r10));     // Catch: Exception -> L19
        if (r14 <= 0) goto L17;
        OfflineUtils.INSTANCE.onJsSuccessCallback("", this.$callback);     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L17:
        OfflineUtils.INSTANCE.onJsFailCallback("insert error " + r8, "", this.$callback);     // Catch: Exception -> L19
        throw new RuntimeException("SetDataHandler ret <= 0   ret: " + r14);     // Catch: Exception -> L19
    L8:
        if (r9.getId() <= 0) goto L13;
        this.$data.setId(r9.getId());     // Catch: Exception -> L19
        this.$data.setSubblock_preload_status(r9.getSubblock_preload_status());     // Catch: Exception -> L19
        this.$data.setLoadFrom(r9.getLoadFrom());     // Catch: Exception -> L19
        r14 = OfflineDataManager.get().updateResourceData(this.$data);     // Catch: Exception -> L19
        if (r14 > 0) goto L12;
        Log.i("OfflineServicePlugin", "updateResourceData fail! ret = " + r14);     // Catch: Exception -> L19
        Pair<Long, String> r11 = OfflineDataManager.get().insertResourceData(this.$data);     // Catch: Exception -> L19
        r14 = ((Number) r11.first).longValue();     // Catch: Exception -> L19
        r8 = (String) r11.second;     // Catch: Exception -> L19
        goto L14
    L12:
        r8 = "";
    L19:
        e = move-exception;
        OfflineUtils.INSTANCE.onJsFailCallback("unkonw error " + e.getMessage(), "", this.$callback);
        Log.e("OfflineServicePlugin", "addDataToStorage: ", e);
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
