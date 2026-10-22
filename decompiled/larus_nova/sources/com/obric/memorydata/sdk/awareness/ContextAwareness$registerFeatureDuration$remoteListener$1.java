package com.obric.memorydata.sdk.awareness;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/sdk/awareness/ContextAwareness$registerFeatureDuration$remoteListener$1", "Lcom/obric/memorydata/sdk/awareness/IFeatureDurationListener$Stub;", "onTriggered", "", "featureName", "", "targetFeatureValue", "durationSec", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwareness$registerFeatureDuration$remoteListener$1 extends IFeatureDurationListener.Stub {
    final /* synthetic */ e.b $key;

    public ContextAwareness$registerFeatureDuration$remoteListener$1(e.b r100) {
        this.$key = r100;
    }

    @Override // com.obric.memorydata.sdk.awareness.IFeatureDurationListener
    public void onTriggered(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        Intrinsics.checkNotNullParameter(r101, "targetFeatureValue");
        Set<k> r103 = e.f397121m.get(this.$key);
        if (r103 != null) goto L5;
        r103 = SetsKt.emptySet();
    L5:
        Iterator<T> r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((k) r104.next()).a();
        goto L7
    L9:
        this.$key.getClass();
    }
}
