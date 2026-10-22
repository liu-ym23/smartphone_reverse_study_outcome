package po5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@FunctionalInterface
public interface a {
    public static final C0291a a = null;

    /* JADX INFO: renamed from: po5.a$a, reason: collision with other inner class name */
    public static final class C0291a {
        public static final /* synthetic */ C0291a a = null;

        static {
            a = new C0291a();
        }

        public C0291a() {
        }

        @JvmStatic
        public static mo5.g a(mo5.a r2, Map r3) {
            Object r4 = r3.get(ResourceData.KEY_TOKEN);
            if ((r4 instanceof String) == false) goto L5;
            String r5 = (String) r4;
        L6:
            if (r5 != null) goto L8;
        L11:
            boolean r0 = true;
        L12:
            if (r0 == false) goto L15;
            if (r2 != null) goto L19;
            return null;
        L19:
            return mo5.h.e(r2);
        L15:
            if (r2 != null) goto L17;
            return null;
        L17:
            return r2.q(r5);
        L8:
            if (r5.length() == 0) goto L11;
            r0 = false;
            goto L12
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
        a = C0291a.a;
    }

    boolean a(mo5.a r1, Map r2);
}
