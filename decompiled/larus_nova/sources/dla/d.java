package dla;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements h37.e {
    public d() {
    }

    @Override // h37.e
    public final SharedPreferences a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new c(r100, r101);
    }
}
