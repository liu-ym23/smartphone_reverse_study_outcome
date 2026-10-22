package o89;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.p0;
import com.larus.utils.y0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f522393a = null;

    static {
        f522393a = LazyKt.lazy(new a());
    }

    public static uq9.c a() {
        return (uq9.c) f522393a.getValue();
    }

    public static boolean c() {
        if (a().getType() < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean d() {
        if (a().getType() >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String b(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == true) goto L22;
        Uri r102 = y0.h(r100);
        String r103 = UriProtector.getQueryParameter(r102, "url");
        if (r103 == null) goto L15;
        String r104 = p0.a(r103);
        if (r104 == null) goto L15;
        return r104;
    L15:
        String r105 = UriProtector.getQueryParameter(r102, "surl");
        if (r105 == null) goto L19;
        return p0.a(r105);
    L19:
        return null;
    L22:
        return r100;
    L5:
        if (StringsKt.startsWith$default(r100, "https", false, 2, null) != true) goto L7;
        r101 = true;
        goto L7
    }

    public static boolean e(String r100) {
        boolean r101 = false;
        if (d() == true) goto L5;
        return false;
    L5:
        String r102 = b(r100);
        if (r102 == null) goto L35;
        List<String> r103 = a().a();
        Boolean r104 = null;
        if (r103 == null) goto L29;
        List<String> r105 = r103;
        if ((r105 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r106 = r105.iterator();
    L16:
        if (r106.hasNext() == false) goto L27;
        String r107 = (String) r106.next();
        if (r107 != null) goto L20;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == false) goto L16;
        r101 = true;
        goto L27
    L20:
        if ((!StringsKt.isBlank(r107)) == false) goto L24;
        if (StringsKt.contains$default(r102, r107, false, 2, null) == false) goto L24;
        r108 = true;
    L27:
        r104 = Boolean.valueOf(r101);
        goto L29
    L12:
        if (r105.isEmpty() == false) goto L14;
    L29:
        return Intrinsics.areEqual(r104, Boolean.TRUE);
    L35:
        return false;
    }
}
