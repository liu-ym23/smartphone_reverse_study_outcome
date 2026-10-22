package io.ktor.util;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes41.dex */
public final class n<Key, Value> implements Map.Entry<Key, Value>, KMutableMap.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f491968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Value f491969b;

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Key r100 = this.f491968a;
        Intrinsics.checkNotNull(r100);
        int r101 = r100.hashCode() + TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER;
        Value r102 = this.f491969b;
        Intrinsics.checkNotNull(r102);
        return r101 + r102.hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f491968a);
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(this.f491969b);
        return r100.toString();
    }

    @Override // java.util.Map.Entry
    public final Key getKey() {
        return this.f491968a;
    }

    @Override // java.util.Map.Entry
    public final Value getValue() {
        return this.f491969b;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof Map.Entry) == false) goto L16;
        Map.Entry r101 = (Map.Entry) r100;
        if (Intrinsics.areEqual(r101.getKey(), this.f491968a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r101.getValue(), this.f491969b) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // java.util.Map.Entry
    public final Value setValue(Value r100) {
        this.f491969b = r100;
        return r100;
    }

    public n(Key r100, Value r101) {
        this.f491968a = r100;
        this.f491969b = r101;
    }
}
