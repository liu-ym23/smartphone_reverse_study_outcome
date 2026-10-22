package laa;

import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputCloseMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f508234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateInfo f508235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricSpecialInputCloseMethod f508236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DMTaskState f508237d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f508234a == r101.f508234a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508235b, r101.f508235b) == true) goto L15;
        return false;
    L15:
        if (this.f508236c == r101.f508236c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508237d, r101.f508237d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f508234a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        StateInfo r102 = this.f508235b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        ObricSpecialInputCloseMethod r106 = this.f508236c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        DMTaskState r109 = this.f508237d;
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
        return "ObricSpecialInputOpenState(isOpen=" + this.f508234a + ", stateInfo=" + this.f508235b + ", closeMethod=" + this.f508236c + ", relatedTask=" + this.f508237d + ')';
    }

    public t(boolean r100, StateInfo r101, ObricSpecialInputCloseMethod r102, DMTaskState r103) {
        this.f508234a = r100;
        this.f508235b = r101;
        this.f508236c = r102;
        this.f508237d = r103;
    }
}
