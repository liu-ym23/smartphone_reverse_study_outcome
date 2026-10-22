package pea;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f528744e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f528747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f528748d;

    public static final class a {
        public static c a(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "pic");
            return new c(r100, r101, r102);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f528745a == r101.f528745a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528746b, r101.f528746b) == true) goto L15;
        return false;
    L15:
        if (this.f528747c == r101.f528747c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528748d, r101.f528748d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f528745a * 31) + this.f528746b.hashCode()) * 31) + this.f528747c) * 31;
        String r101 = this.f528748d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("type", this.f528745a);
        r100.put("pic", this.f528746b);
        return r100;
    }

    public final String toString() {
        return "{\"type\":" + this.f528745a + ",\"pic\":\"" + this.f528746b + "\", \"picResId\":" + this.f528747c + '}';
    }

    public final int getType() {
        return this.f528745a;
    }

    public c(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pic");
        this.f528745a = 1;
        this.f528746b = r100;
        this.f528747c = r101;
        this.f528748d = r102;
    }
}
