package po5;

import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
@FunctionalInterface
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7218a f530050a = null;

    /* JADX INFO: renamed from: po5.a$a, reason: collision with other inner class name */
    public static final class C7218a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C7218a f530051a = null;

        static {
            f530051a = new C7218a();
        }

        public C7218a() {
        }

        @JvmStatic
        public static mo5.g a(mo5.a r100, Map r101) {
            Object r102 = r101.get("token");
            if ((r102 instanceof String) == false) goto L5;
            String r103 = (String) r102;
        L6:
            if (r103 != null) goto L8;
        L11:
            boolean r104 = true;
        L12:
            if (r104 == false) goto L15;
            if (r100 != null) goto L19;
            return null;
        L19:
            return mo5.h.e(r100);
        L15:
            if (r100 != null) goto L17;
            return null;
        L17:
            return r100.q(r103);
        L8:
            if (r103.length() == 0) goto L11;
            r104 = false;
            goto L12
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        f530050a = C7218a.f530051a;
    }

    boolean a(mo5.a r100, Map r101);
}
