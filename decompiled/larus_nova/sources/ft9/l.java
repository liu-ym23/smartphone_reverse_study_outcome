package ft9;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class l implements h37.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f478818a = null;

    public static final class a {
    }

    public l() {
    }

    static {
        f478818a = SetsKt.setOf("nova_settings.sp");
    }

    @Override // h37.e
    public final SharedPreferences a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (f478818a.contains(r100) == false) goto L6;
        r101 = 4;
    L6:
        return new xg9.e(r100, r101);
    }
}
