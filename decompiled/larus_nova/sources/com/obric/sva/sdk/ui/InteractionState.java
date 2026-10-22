package com.obric.sva.sdk.ui;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/sva/sdk/ui/InteractionState;", "", "data", "", "", "<init>", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "setData", "Lcom/obric/sva/sdk/ui/ActiveState;", "Lcom/obric/sva/sdk/ui/EyeDetectState;", "Lcom/obric/sva/sdk/ui/FinishState;", "Lcom/obric/sva/sdk/ui/GenerateState;", "Lcom/obric/sva/sdk/ui/ListenState;", "Lcom/obric/sva/sdk/ui/NoneState;", "Lcom/obric/sva/sdk/ui/StandByState;", "Lcom/obric/sva/sdk/ui/ThinkState;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InteractionState {
    private Map<String, ? extends Object> data;

    public /* synthetic */ InteractionState(Map r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    private InteractionState(Map<String, ? extends Object> r100) {
        this.data = r100;
    }

    public final void setData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }

    public /* synthetic */ InteractionState(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        this(r100, null);
    }
}
