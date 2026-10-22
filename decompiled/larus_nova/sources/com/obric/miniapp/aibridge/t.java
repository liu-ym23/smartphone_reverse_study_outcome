package com.obric.miniapp.aibridge;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f397373e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f397374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f397377d;

    public static final class a {
        public a() {
        }

        public static t b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "sessionKey");
            Intrinsics.checkNotNullParameter(r101, "sessionTag");
            return new t(true, r100, r101, null);
        }

        public static t a(String r100, String r101, String r102, String r103) {
            int r104 = t.f397373e;
            Intrinsics.checkNotNullParameter(r100, "sessionKey");
            Intrinsics.checkNotNullParameter(r101, "sessionTag");
            Intrinsics.checkNotNullParameter(r102, "code");
            Intrinsics.checkNotNullParameter(r103, "message");
            JSONObject r105 = new JSONObject();
            r105.put("code", r102);
            r105.put("message", r103);
            return new t(false, r100, r101, r105);
        }
    }

    static {
        new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f397374a == r101.f397374a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397375b, r101.f397375b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397376c, r101.f397376c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397377d, r101.f397377d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f397374a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f397375b.hashCode()) * 31) + this.f397376c.hashCode()) * 31;
        JSONObject r102 = this.f397377d;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "LiveCardOpResult(ok=" + this.f397374a + ", sessionKey=" + this.f397375b + ", sessionTag=" + this.f397376c + ", error=" + this.f397377d + ')';
    }

    public t(boolean r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r101, "sessionKey");
        Intrinsics.checkNotNullParameter(r102, "sessionTag");
        this.f397374a = r100;
        this.f397375b = r101;
        this.f397376c = r102;
        this.f397377d = r103;
    }
}
