package ci3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "btm");
        Intrinsics.checkNotNullParameter(r14, "cd");
        return CollectionsKt.joinToString$default(StringsKt.split$default(r13, new String[]{"."}, false, 0, 6, null).subList(0, 2), ".", null, null, 0, null, null, 62, null) + '.' + r14;
    }
}
