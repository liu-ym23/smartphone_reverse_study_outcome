package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;

/* JADX INFO: loaded from: classes43.dex */
public final class v implements Property {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property.NodeInfo f527530c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527531b;

    public static final class a {
    }

    static {
        f527530c = new Property.NodeInfo("urn:ietf:params:xml:ns:caldav", "schedule-tag");
    }

    public final String toString() {
        String r100 = this.f527531b;
        if (r100 != null) goto L6;
        return "(null)";
    L6:
        return r100;
    }

    public v(String r100) {
        if (r100 == null) goto L5;
        String r101 = q3.b.a(r100);
    L6:
        this.f527531b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
