package uw3;

import com.bytedance.applog.filter.NativeFilterJNI;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends a {
    public final String d;
    public boolean e;

    public final boolean d(String r1) {
        return false;
    }

    public final boolean e(HashSet<String> r1, String r2) {
        return false;
    }

    public final boolean b() {
        return !this.e;
    }

    public g(com.bytedance.applog.b r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "appLogInstance");
        super(null, null);
        String r0 = r2.j;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.d = r0;
        new f(r2, this, r3).b(new Object[0]);
    }

    public final boolean c(String r1, String r2) {
        if (this.e == true) goto L6;
        return true;
    L6:
        String r3 = this.d;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        return NativeFilterJNI.nativeIsEventAllowed(r3, r1);
    }
}
