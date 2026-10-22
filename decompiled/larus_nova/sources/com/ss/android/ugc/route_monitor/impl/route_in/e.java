package com.ss.android.ugc.route_monitor.impl.route_in;

import android.os.Message;
import com.ss.android.ugc.route_monitor.ComponentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f454516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentType f454517b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f454516a, r101.f454516a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f454517b, r101.f454517b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Message r100 = this.f454516a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ComponentType r104 = this.f454517b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "{launchComponentMessage.what = " + this.f454516a.what + ", launchComponentType = " + this.f454517b + '}';
    }

    public e(Message r100, ComponentType r101) {
        this.f454516a = r100;
        this.f454517b = r101;
    }
}
