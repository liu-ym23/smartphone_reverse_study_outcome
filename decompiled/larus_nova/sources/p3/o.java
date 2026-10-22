package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements Property {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property.NodeInfo f527519c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527520b;

    public static final class a {
    }

    static {
        f527519c = new Property.NodeInfo("DAV:", "getetag");
    }

    public final String toString() {
        String r100 = this.f527520b;
        if (r100 != null) goto L6;
        return "(null)";
    L6:
        return r100;
    }

    public o(String r100) {
        String r101 = null;
        if (r100 != null) goto L5;
    L10:
        this.f527520b = r101;
        return;
    L5:
        if (StringsKt.startsWith$default(r100, "W/", false, 2, null) == true) goto L7;
    L9:
        r101 = q3.b.a(r100);
        goto L10
    L7:
        if (r100.length() < 3) goto L9;
        r100 = r100.substring(2);
        goto L9
    }
}
