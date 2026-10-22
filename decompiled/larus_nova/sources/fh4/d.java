package fh4;

import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f477005e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f477006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f477007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f477008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f477009d;

    public final String toString() {
        return "EnsureConfig{sampledLogType=" + this.f477006a + ", isCoreExceptionEnable=" + this.f477007b + ", exceptionMessage=" + this.f477008c + ", isAllEnable=" + this.f477009d + '}';
    }

    public d() {
        this.f477009d = true;
    }

    public final boolean a(String r100) {
        if (f477005e == false) goto L6;
        return false;
    L6:
        if (this.f477009d == false) goto L9;
        return true;
    L9:
        if ("core_exception_monitor".equals(r100) == true) goto L11;
        Set<String> r101 = this.f477006a;
        if (r101 != null) goto L15;
        return false;
    L15:
        if (r101.contains(r100) == false) goto L19;
        return true;
    L19:
        return false;
    L11:
        return this.f477007b;
    }

    public final boolean b(String r100, String r101) {
        boolean r102 = false;
        if (f477005e == false) goto L6;
        return false;
    L6:
        if (a(r100) == true) goto L9;
        return false;
    L9:
        if (this.f477009d == true) goto L18;
        JSONObject r103 = this.f477008c;
        if (r103 == null) goto L15;
        double r104 = r103.optDouble(r101, 1.0d);
        if (Math.random() <= r104) goto L15;
    L17:
        return r102;
    L15:
        r102 = true;
        goto L17
    L18:
        return true;
    }

    public d(Set<String> r100, JSONObject r101, boolean r102) {
        this.f477006a = r100;
        this.f477007b = r102;
        if (r101 == null) goto L5;
        this.f477008c = r101;
        return;
    L5:
        this.f477008c = new JSONObject();
    }
}
