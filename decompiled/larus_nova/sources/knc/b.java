package knc;

import com.suite.component.logger.api.f;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f504331a = 0;

    public static final class a {
        @JvmStatic
        public static void a(com.suite.component.logger.c r100) {
            Intrinsics.checkNotNullParameter(r100, "logEntity");
            if (r100.f460121g == null) goto L5;
            return;
        L5:
            if (r100.f460122h != null) goto L34;
            ThreadLocal<c.a> r101 = c.f504332a;
            c.a r102 = r101.get();
            if (r102 == null) goto L33;
            r100.f460121g = r102.f504333a;
            String r103 = r102.f504334b;
            boolean r104 = true;
            if (r103 != null) goto L12;
        L15:
            boolean r105 = true;
        L16:
            if (r105 == true) goto L26;
            String r106 = r100.f460116b;
            if (r106 != null) goto L20;
        L23:
            if (r104 == true) goto L26;
            String r107 = r102.f504334b + '#' + r100.f460116b;
        L27:
            r100.f460122h = r107;
            r100.f460123i = r102.f504335c;
            c.a r108 = r101.get();
            if (r108 != null) goto L30;
            r108 = new c.a();
        L30:
            r108.f504333a = null;
            r108.f504334b = null;
            r108.f504335c = -1;
            r101.set(r108);
            return;
        L20:
            if (r106.length() == 0) goto L23;
            r104 = false;
        L26:
            r107 = r102.f504334b;
            goto L27
        L12:
            if (r103.length() == 0) goto L15;
            r105 = false;
            goto L16
        L33:
            return;
        }
    }

    static {
    }

    public b() {
    }

    @Override // com.suite.component.logger.api.f
    public final boolean a(com.suite.component.logger.b r100, com.suite.component.logger.c r101) {
        Intrinsics.checkNotNullParameter(r100, "logContext");
        Intrinsics.checkNotNullParameter(r101, "logEntity");
        a.a(r101);
        return true;
    }
}
