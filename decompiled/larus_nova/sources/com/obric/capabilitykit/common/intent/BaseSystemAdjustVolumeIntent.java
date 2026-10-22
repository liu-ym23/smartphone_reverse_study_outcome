package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/common/intent/BaseSystemAdjustVolumeIntent;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lcom/obric/capabilitykit/common/intent/SystemAdjustVolumeParams;", "Lcom/obric/capabilitykit/common/intent/Empty;", "()V", "name", "", "getName", "()Ljava/lang/String;", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BaseSystemAdjustVolumeIntent implements IntentFunction<SystemAdjustVolumeParams, Empty> {
    private final String name;

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return false;
    }

    public BaseSystemAdjustVolumeIntent() {
        this.name = "System_AdjustVolume";
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public final String getName() {
        return this.name;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public Boolean isTaskOnGoing(DispatchContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dispatchContext");
        return null;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r100, DispatchContext r101, Continuation<? super IntentResult<Empty>> r102) {
        return doAction((SystemAdjustVolumeParams) r100, r101, r102);
    }

    public Object doAction(SystemAdjustVolumeParams r100, DispatchContext r101, Continuation<? super IntentResult<Empty>> r102) {
        IntentFunction.a.a();
        throw null;
    }
}
