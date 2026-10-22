package u2;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f548382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f548383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f548384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Object> f548385g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f548379a, r101.f548379a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548380b, r101.f548380b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548381c, r101.f548381c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f548382d, r101.f548382d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f548383e, r101.f548383e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f548384f, r101.f548384f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f548385g, r101.f548385g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f548379a.hashCode() * 31) + this.f548380b.hashCode()) * 31) + this.f548381c.hashCode()) * 31) + this.f548382d.hashCode()) * 31) + this.f548383e.hashCode()) * 31) + this.f548384f.hashCode()) * 31;
        HashMap<String, Object> r101 = this.f548385g;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppletGrantingMsgData(msgID=" + this.f548379a + ", queryMsgID=" + this.f548380b + ", cardID=" + this.f548381c + ", conversationID=" + this.f548382d + ", sectionID=" + this.f548383e + ", senderID=" + this.f548384f + ", traceInfo=" + this.f548385g + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, HashMap<String, Object> r106) {
        Intrinsics.checkNotNullParameter(r100, "msgID");
        Intrinsics.checkNotNullParameter(r101, "queryMsgID");
        Intrinsics.checkNotNullParameter(r102, "cardID");
        Intrinsics.checkNotNullParameter(r103, "conversationID");
        Intrinsics.checkNotNullParameter(r104, "sectionID");
        Intrinsics.checkNotNullParameter(r105, "senderID");
        this.f548379a = r100;
        this.f548380b = r101;
        this.f548381c = r102;
        this.f548382d = r103;
        this.f548383e = r104;
        this.f548384f = r105;
        this.f548385g = r106;
    }
}
