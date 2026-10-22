package s5;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements h37.e {
    public a() {
    }

    @Override // h37.e
    public final SharedPreferences a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new f(r100, r101);
    }
}
