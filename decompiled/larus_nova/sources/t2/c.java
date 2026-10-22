package t2;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = UriProtector.parse(r100).getPath();
        if (r101 == null) goto L11;
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101;
    L11:
        return StringsKt.substringBefore$default(r100, '?', null, 2, null);
    }
}
