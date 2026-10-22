package fi3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f477268b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f477269a;

    public static final class a {
    }

    static {
    }

    public h0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f477269a, ((h0) r100).f477269a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f477269a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PdpAppointParams(requestParams=" + this.f477269a + ")";
    }

    public h0(Map<String, ? extends Object> r100) {
        this.f477269a = r100;
    }
}
