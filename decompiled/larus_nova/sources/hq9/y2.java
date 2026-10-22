package hq9;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f486825d;

    public y2() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y2) == true) goto L8;
        return false;
    L8:
        y2 r101 = (y2) r100;
        if (Intrinsics.areEqual(this.f486822a, r101.f486822a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486823b, r101.f486823b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486824c, r101.f486824c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486825d, r101.f486825d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f486822a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f486823b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f486824c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f486825d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocationAuthData(questionId=" + this.f486822a + ", questionLocalMessageId=" + this.f486823b + ", conversationId=" + this.f486824c + ", traceInfo=" + this.f486825d + ')';
    }

    public y2(String r100, String r101, String r102, JSONObject r103) {
        this.f486822a = r100;
        this.f486823b = r101;
        this.f486824c = r102;
        this.f486825d = r103;
    }
}
