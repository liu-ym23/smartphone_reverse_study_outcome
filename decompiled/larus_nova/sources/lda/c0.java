package lda;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f508801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OmniTaskTriggerType f508803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f508804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<Integer, c> f508805e;

    public c0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.f508801a == r101.f508801a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508802b, r101.f508802b) == true) goto L15;
        return false;
    L15:
        if (this.f508803c == r101.f508803c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508804d, r101.f508804d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508805e, r101.f508805e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f508801a;
        return (((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f508802b.hashCode()) * 31) + this.f508803c.hashCode()) * 31) + this.f508804d.hashCode()) * 31) + this.f508805e.hashCode();
    }

    public final String toString() {
        return "PendingOmniRecord(createdAt=" + this.f508801a + ", userQuery=" + this.f508802b + ", taskTriggerType=" + this.f508803c + ", latestReply=" + this.f508804d + ", steps=" + this.f508805e + ')';
    }

    public final void a(w r100) {
        Intrinsics.checkNotNullParameter(r100, "step");
        this.f508803c = r100.f508846j;
        String r101 = r100.f508842f;
        if (StringsKt.isBlank(r101) == false) goto L5;
        r101 = r100.f508841e;
    L5:
        String r102 = v.a(r101);
        if ((!StringsKt.isBlank(r102)) == false) goto L9;
        this.f508805e.put(Integer.valueOf(r100.f508840d), new c(r102));
    L9:
        if ((!StringsKt.isBlank(r100.f508842f)) == false) goto L12;
        this.f508804d = r100.f508842f;
        return;
    }

    public final b0 b(a0 r110) {
        Intrinsics.checkNotNullParameter(r110, "stop");
        List r100 = CollectionsKt.toList(this.f508805e.values());
        if (r100.isEmpty() == false) goto L5;
        r100 = CollectionsKt.listOf(new c("用户主动停止任务"));
    L5:
        List r111 = r100;
        String r101 = v.b(r110.f508781a);
        ModuleKey r102 = e.f508808a.f387358a;
        String r103 = r110.f508781a;
        long r104 = this.f508801a;
        String r105 = this.f508802b;
        String r106 = this.f508804d;
        if (StringsKt.isBlank(r106) == false) goto L9;
        r106 = "用户主动停止了 Omni 任务";
    L9:
        return new b0(r101, r102, r103, r104, r105, r106, OmniTaskStatus.USER_STOPPED, r110.f508786f, r111, j.a(this.f508801a, r110.f508784d));
    }

    public c0(long r100, String r101, OmniTaskTriggerType r102) {
        LinkedHashMap<Integer, c> r103 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "userQuery");
        Intrinsics.checkNotNullParameter(r102, "taskTriggerType");
        Intrinsics.checkNotNullParameter("", "latestReply");
        Intrinsics.checkNotNullParameter(r103, "steps");
        this.f508801a = r100;
        this.f508802b = r101;
        this.f508803c = r102;
        this.f508804d = "";
        this.f508805e = r103;
    }
}
