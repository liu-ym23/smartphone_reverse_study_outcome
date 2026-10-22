package r06;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f535478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f535479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f535480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f535481e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f535477a, ((e) r100).f535477a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f535477a.hashCode();
    }

    public final String toString() {
        return "SecureReportInfo(eventName=" + this.f535477a + ')';
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f535477a = r100;
        this.f535480d = 3;
    }
}
