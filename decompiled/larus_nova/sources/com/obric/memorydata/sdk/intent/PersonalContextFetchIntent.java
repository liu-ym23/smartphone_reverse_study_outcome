package com.obric.memorydata.sdk.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.BasePCPersonalContextFetchIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCPersonalContextFetchParams;
import com.obric.memorydata.sdk.MemoryResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/sdk/intent/PersonalContextFetchIntent;", "Lcom/obric/capabilitykit/common/intent/BasePCPersonalContextFetchIntent;", "<init>", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "Lcom/obric/capabilitykit/common/intent/PCPersonalContextFetchParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PCPersonalContextFetchParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDispatchIntentImplInfo", "Lcom/obric/capabilitykit/common/intent/AppIntentImplInfo;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalContextFetchIntent extends BasePCPersonalContextFetchIntent {
    private final AppIntentImplInfo getDispatchIntentImplInfo() {
        return null;
    }

    public PersonalContextFetchIntent() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.capabilitykit.common.intent.BasePCPersonalContextFetchIntent
    public Object doAction(PCPersonalContextFetchParams r110, DispatchContext r111, Continuation<? super IntentResult<Empty>> r112) {
        if (getDispatchIntentImplInfo() != null) goto L11;
        pka.a.f529681a.getClass();
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "dispatchContext");
        MemoryResponse r100 = pka.a.b("pcPersonalContextFetchIntent", r110, r111);
        IntentResult r101 = (IntentResult) r100.f397053c;
        if (r100.f397051a != 0) goto L9;
        if (r101 == null) goto L9;
        return r101;
    L9:
        return new IntentResult(-2002, null, null, "executePersonalContextFetchIntent error", false, false, 256, null, null, null, 950, null);
    L11:
        throw new UnsupportedOperationException("not support dispatch intent");
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCPersonalContextFetchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r100, DispatchContext r101, Continuation<? super IntentResult<Empty>> r102) {
        return doAction((PCPersonalContextFetchParams) r100, r101, r102);
    }
}
