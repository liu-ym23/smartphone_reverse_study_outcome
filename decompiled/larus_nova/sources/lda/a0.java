package lda;

import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f508782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f508784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OmniTaskTriggerType f508786f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f508781a, r101.f508781a) == true) goto L12;
        return false;
    L12:
        if (this.f508782b == r101.f508782b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508783c, r101.f508783c) == true) goto L18;
        return false;
    L18:
        if (this.f508784d == r101.f508784d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508785e, r101.f508785e) == true) goto L24;
        return false;
    L24:
        if (this.f508786f == r101.f508786f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508781a.hashCode() * 31;
        long r101 = this.f508782b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f508783c.hashCode()) * 31;
        long r103 = this.f508784d;
        return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f508785e.hashCode()) * 31) + this.f508786f.hashCode();
    }

    public final String toString() {
        return "OmniRuntimeUserStop(recordId=" + this.f508781a + ", createdAt=" + this.f508782b + ", userQuery=" + this.f508783c + ", finishTimeMillis=" + this.f508784d + ", reason=" + this.f508785e + ", taskTriggerType=" + this.f508786f + ')';
    }

    public a0(String r100, long r101, String r102, long r103, String r104, OmniTaskTriggerType r105) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r102, "userQuery");
        Intrinsics.checkNotNullParameter(r104, "reason");
        Intrinsics.checkNotNullParameter(r105, "taskTriggerType");
        this.f508781a = r100;
        this.f508782b = r101;
        this.f508783c = r102;
        this.f508784d = r103;
        this.f508785e = r104;
        this.f508786f = r105;
    }
}
