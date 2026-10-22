package com.ss.android.lark.flow.chat.multi_select;

import com.ss.android.eventbus.BaseEvent;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends BaseEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f422689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ForwardTargetBaseInfoNew> f422690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f422691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f422692d;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f422689a == r101.f422689a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f422690b, r101.f422690b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f422691c, r101.f422691c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f422692d, r101.f422692d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f422689a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Map<String, ForwardTargetBaseInfoNew> r102 = this.f422690b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f422691c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f422692d;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "MultiSelectResultEvent(isSuccess=" + this.f422689a + ", result=" + this.f422690b + ", errorTitle=" + this.f422691c + ", errorMessage=" + this.f422692d + ')';
    }

    public c(boolean r100, Map r101, String r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this.f422689a = r100;
        this.f422690b = r101;
        this.f422691c = r102;
        this.f422692d = r103;
    }
}
