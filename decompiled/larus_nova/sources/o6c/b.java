package o6c;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final String a(String r100, com.ss.android.lark.storage.a r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "spaceName");
        Intrinsics.checkNotNullParameter(r101, "domain");
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return r100 + '.' + r101.a();
    L6:
        return r100 + '.' + r101.a() + '.' + r102;
    }
}
