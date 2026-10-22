package ft9;

import android.content.SharedPreferences;
import h37.e;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l implements e {
    public static final Set<String> a = null;

    public static final class a {
    }

    public l() {
    }

    static {
        a = SetsKt.setOf("nova_settings.sp");
    }

    @Override // h37.e
    public final SharedPreferences a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (a.contains(r2) == false) goto L6;
        r3 = 4;
    L6:
        return new xg9.e(r2, r3);
    }
}
