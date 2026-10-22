package com.obric.miniapp.alarm;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f397460b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f397459a, r101.f397459a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397460b, r101.f397460b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f397459a.hashCode() * 31) + this.f397460b.hashCode();
    }

    public final String toString() {
        return "PendingEntry(alarmId='" + this.f397459a + "', payload=" + this.f397460b + ')';
    }

    public e0(String r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "alarmId");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        this.f397459a = r100;
        this.f397460b = r101;
    }
}
