package com.larus.avlink.performance;

import com.larus.avlink.model.FlowDoraScene;
import com.larus.avlink.model.FlowDoraSceneState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f293535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f293536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f293537c;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f293535a, r101.f293535a) == true) goto L12;
        return false;
    L12:
        if (this.f293536b == r101.f293536b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f293537c, r101.f293537c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f293535a.hashCode() * 31) + this.f293536b) * 31;
        Integer r101 = this.f293537c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraSceneBatteryRecordEvent(sceneKey=" + this.f293535a + ", state=" + this.f293536b + ", rawScene=" + this.f293537c + ')';
    }

    public b(String r100, @FlowDoraSceneState int r101, @FlowDoraScene Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        this.f293535a = r100;
        this.f293536b = r101;
        this.f293537c = r102;
    }
}
