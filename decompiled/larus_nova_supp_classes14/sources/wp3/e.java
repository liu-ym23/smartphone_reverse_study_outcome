package wp3;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final /* synthetic */ int c = 0;
    public String a;
    public String b;

    public static final class a {
        public static e a(up3.f r4) {
            Intrinsics.checkNotNullParameter(r4, "dto");
            String r0 = r4.d();
            boolean r1 = true;
            if (r0 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            String r3 = null;
            if (r2 == false) goto L27;
            List<String> r5 = r4.e();
            if (r5 != null) goto L14;
        L17:
            boolean r6 = true;
        L18:
            if (r6 == false) goto L27;
            String r7 = r4.j();
            if (r7 != null) goto L22;
        L25:
            if (r1 == false) goto L27;
            return null;
        L22:
            if (r7.length() == 0) goto L25;
            r1 = false;
            goto L25
        L14:
            if (r5.isEmpty() == true) goto L17;
            r6 = false;
        L27:
            e r8 = new e();
            String r9 = r4.d();
            if (r9 != null) goto L32;
            List<String> r10 = r4.e();
            if (r10 == null) goto L33;
            r3 = (String) CollectionsKt.firstOrNull(r10);
        L33:
            r8.a = r3;
            r8.b = r4.j();
            return r8;
        L32:
            r3 = r9;
            goto L33
        L5:
            if (r0.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    static {
    }

    public e() {
    }
}
