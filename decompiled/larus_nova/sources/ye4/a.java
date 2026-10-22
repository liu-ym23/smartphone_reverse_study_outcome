package ye4;

import com.bytedance.ies.bullet.core.BulletContext;
import ia.c;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import m16.b;
import t36.d;
import y36.p;

/* JADX INFO: loaded from: classes15.dex */
public interface a {

    /* JADX INFO: renamed from: ye4.a$a, reason: collision with other inner class name */
    public static final class C8332a {
        public static d c(b r100, c r101) {
            if (r100 == null) goto L8;
            BulletContext r102 = (BulletContext) r100.c(BulletContext.class);
            if (r102 == null) goto L8;
            d r103 = r102.f246437e;
            if (r103 == null) goto L8;
            return r103;
        L8:
            if (r101 == null) goto L10;
            d r104 = r101.getSchemaData();
        L11:
            if (r104 != null) goto L15;
            if (r101 != null) goto L18;
            return null;
        L18:
            return r101.getCurrentSchema();
        L15:
            return r104;
        L10:
            r104 = null;
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static String a(a r100, b r101, c r102) {
            d r103 = r100.U6(r101, r102);
            if (r103 == null) goto L5;
            String r104 = (String) new p(r103, "cj_session_id", "").f565862b;
        L6:
            if (r104 != null) goto L9;
            return "";
        L9:
            return r104;
        L5:
            r104 = null;
            goto L6
        }

        public static Map<String, Object> b(a r100, b r101, c r102) {
            return MapsKt.mapOf(TuplesKt.to("cj_session_id", r100.hj(r101, r102)));
        }
    }

    d U6(b r100, c r101);

    String hj(b r100, c r101);
}
