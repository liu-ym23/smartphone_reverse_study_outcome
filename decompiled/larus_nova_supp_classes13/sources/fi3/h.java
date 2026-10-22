package fi3;

import com.bytedance.android.ec.core.utils.a2;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final /* synthetic */ int c = 0;
    public final String a;
    public final Map<String, Object> b;

    public static final class a {
        public static h a(Map r4) {
            Object r0 = null;
            if (r4 == null) goto L5;
            Object r1 = r4.get("event_name");
        L7:
            if ((r1 instanceof String) == true) goto L9;
            r1 = null;
        L9:
            String r2 = a2.d((String) r1);
            if (r2 != null) goto L13;
            return null;
        L13:
            if (r4 == null) goto L15;
            Object r5 = r4.get("event_params");
        L17:
            if ((r5 instanceof Map) == false) goto L20;
            r0 = r5;
        L20:
            Map r3 = (Map) r0;
            if (r3 != null) goto L24;
            r3 = MapsKt.emptyMap();
        L24:
            return new h(r2, r3);
        L15:
            r5 = null;
            goto L17
        L5:
            r1 = null;
            goto L7
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L10;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DialogActionParams(eventName=" + this.a + ", eventParams=" + this.b + ")";
    }

    public h(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "eventParams");
        this.a = r2;
        this.b = r3;
    }
}
