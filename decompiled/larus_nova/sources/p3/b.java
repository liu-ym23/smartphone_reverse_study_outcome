package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Property {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property.NodeInfo f527507c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527508b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f527508b, ((b) r100).f527508b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f527508b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CalendarData(iCalendar=" + this.f527508b + ')';
    }

    static {
        f527507c = new Property.NodeInfo("urn:ietf:params:xml:ns:caldav", "calendar-data");
    }

    public b(String r100) {
        this.f527508b = r100;
    }
}
