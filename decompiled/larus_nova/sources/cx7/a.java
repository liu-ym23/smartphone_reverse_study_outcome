package cx7;

import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static c a(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == false) goto L8;
        dx7.a r102 = r100.get(r101);
        if (r102.getType() != IvyReadableType.Array) goto L8;
        return r102.a();
    L8:
        return null;
    }

    public static int c(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == false) goto L8;
        dx7.a r102 = r100.get(r101);
        if (r102.getType() != IvyReadableType.Int) goto L8;
        return r102.d();
    L8:
        return 0;
    }

    public static final boolean b(dx7.b r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == true) goto L5;
        return r102;
    L5:
        dx7.a r103 = r100.get(r101);
        if (r103.getType() == IvyReadableType.Boolean) goto L8;
        return r102;
    L8:
        return r103.b();
    }

    public static final String d(d r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        if (r100.hasKey(r101) == true) goto L5;
        return r102;
    L5:
        dx7.a r103 = r100.get(r101);
        if (r103.getType() == IvyReadableType.String) goto L8;
        return r102;
    L8:
        return r103.f();
    }
}
