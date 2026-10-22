package oe4;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f522987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f522988e;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f522984a, r101.f522984a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522985b, r101.f522985b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522986c, r101.f522986c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f522987d, r101.f522987d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522988e, r101.f522988e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f522984a.hashCode() * 31) + this.f522985b.hashCode()) * 31) + this.f522986c.hashCode()) * 31;
        List<String> r101 = this.f522987d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JSONObject r105 = this.f522988e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CJModelNames(llmModelName=" + this.f522984a + ", vitModelName=" + this.f522985b + ", loraName=" + this.f522986c + ", loraNameList=" + this.f522987d + ", extraParams=" + this.f522988e + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "llmModelName");
        Intrinsics.checkNotNullParameter("", "vitModelName");
        Intrinsics.checkNotNullParameter("", "loraName");
        this.f522984a = r100;
        this.f522985b = "";
        this.f522986c = "";
        this.f522987d = null;
        this.f522988e = null;
    }
}
