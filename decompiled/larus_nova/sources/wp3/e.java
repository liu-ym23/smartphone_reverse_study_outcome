package wp3;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f560581c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f560582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f560583b;

    public static final class a {
        public static e a(up3.f r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            String r101 = r100.d();
            boolean r102 = true;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            String r104 = null;
            if (r103 == false) goto L27;
            List<String> r105 = r100.e();
            if (r105 != null) goto L14;
        L17:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L27;
            String r107 = r100.j();
            if (r107 != null) goto L22;
        L25:
            if (r102 == false) goto L27;
            return null;
        L22:
            if (r107.length() == 0) goto L25;
            r102 = false;
            goto L25
        L14:
            if (r105.isEmpty() == true) goto L17;
            r106 = false;
        L27:
            e r108 = new e();
            String r109 = r100.d();
            if (r109 != null) goto L32;
            List<String> r110 = r100.e();
            if (r110 == null) goto L33;
            r104 = (String) CollectionsKt.firstOrNull(r110);
        L33:
            r108.f560582a = r104;
            r108.f560583b = r100.j();
            return r108;
        L32:
            r104 = r109;
            goto L33
        L5:
            if (r101.length() == 0) goto L8;
            r103 = false;
            goto L9
        }
    }

    static {
    }

    public e() {
    }
}
