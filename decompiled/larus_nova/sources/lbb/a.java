package lbb;

import android.text.TextUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        Intrinsics.checkNotNull(r100);
        if (StringsKt.startsWith$default(r100.toLowerCase(), "fake_", false, 2, null) == false) goto L8;
        return true;
    L8:
        return false;
    }
}
