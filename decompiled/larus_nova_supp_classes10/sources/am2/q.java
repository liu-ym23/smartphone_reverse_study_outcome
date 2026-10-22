package am2;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public static final /* synthetic */ int g = 0;
    public final String a;
    public final String b;
    public final String c;
    public String d;
    public String e;
    public String f;

    public static final class a {
        public static void a(q r4, Map r5) {
            Intrinsics.checkNotNullParameter(r4, "endPageLog");
            if (r5 == null) goto L22;
            boolean r1 = false;
            if (r4.d.length() <= 0) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == false) goto L11;
            r5.put("is_inserted", r4.d);
        L11:
            if (r4.e.length() <= 0) goto L13;
            boolean r2 = true;
        L14:
            if (r2 == false) goto L17;
            r5.put("lifve_end_anchor_id", r4.e);
        L17:
            if (r4.f.length() <= 0) goto L19;
            r1 = true;
        L19:
            if (r1 == false) goto L23;
            r5.put("live_end_room_id", r4.f);
            return;
        L23:
            return;
        L13:
            r2 = false;
            goto L14
        L7:
            r0 = false;
            goto L8
        }
    }

    static {
    }

    public q() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
    }
}
