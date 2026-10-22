package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements Property {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property.NodeInfo f527517c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527518b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f527518b, ((m) r100).f527518b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f527518b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "GetContentType(type=" + this.f527518b + ')';
    }

    static {
        f527517c = new Property.NodeInfo("DAV:", "getcontenttype");
    }

    public final String getType() {
        return this.f527518b;
    }

    public m(String r100) {
        this.f527518b = r100;
    }
}
