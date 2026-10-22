package laa;

import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DMTaskState f508238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateInfo f508239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricSpecialInputScene f508240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f508241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f508242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f508243f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f508238a, r101.f508238a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508239b, r101.f508239b) == true) goto L15;
        return false;
    L15:
        if (this.f508240c == r101.f508240c) goto L18;
        return false;
    L18:
        if (this.f508241d == r101.f508241d) goto L21;
        return false;
    L21:
        if (this.f508242e == r101.f508242e) goto L24;
        return false;
    L24:
        if (this.f508243f == r101.f508243f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        DMTaskState r100 = this.f508238a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        StateInfo r104 = this.f508239b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f508240c.hashCode()) * 31;
        int r106 = 1231;
        if (this.f508241d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f508242e == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f508243f == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricSpecialInputStatus(relatedTask=" + this.f508238a + ", currentStateInfo=" + this.f508239b + ", currentScene=" + this.f508240c + ", isChatWindow=" + this.f508241d + ", oIsAutoTimerTask=" + this.f508242e + ", oIsConditionTask=" + this.f508243f + ')';
    }

    public v(DMTaskState r100, StateInfo r101, ObricSpecialInputScene r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r102, "currentScene");
        this.f508238a = r100;
        this.f508239b = r101;
        this.f508240c = r102;
        this.f508241d = r103;
        this.f508242e = r104;
        this.f508243f = r105;
    }
}
