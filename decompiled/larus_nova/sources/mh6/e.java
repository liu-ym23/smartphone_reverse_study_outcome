package mh6;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public static final long a() {
        String r100 = vm2.e.g().get("fetch_delay");
        if (r100 == null) goto L7;
        Long r101 = StringsKt.toLongOrNull(r100);
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 1000;
    }
}
