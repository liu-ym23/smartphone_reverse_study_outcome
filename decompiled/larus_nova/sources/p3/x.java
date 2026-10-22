package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x implements Property {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property.NodeInfo f527532c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527533b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f527533b, ((x) r100).f527533b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f527533b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SyncToken(token=" + this.f527533b + ')';
    }

    static {
        f527532c = new Property.NodeInfo("DAV:", "sync-token");
    }

    public x(String r100) {
        this.f527533b = r100;
    }
}
