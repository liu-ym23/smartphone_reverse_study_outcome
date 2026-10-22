package lda;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class j {
    public static /* synthetic */ String c(String r100) {
        return b(r100, 96);
    }

    public static final String a(long r100, long r101) {
        if (r101 > 0) goto L7;
        r101 = System.currentTimeMillis();
    L7:
        return Math.max(1, (int) Math.ceil(Math.max(0, r101 - r100) / 1000.0d)) + " 秒";
    }

    public static final String b(String r100, int r101) {
        String r102 = StringsKt.replace$default(r100, "\n", "\\n", false, 4, null);
        if (r102.length() > r101) goto L6;
        return r102;
    L6:
        return StringsKt.take(r102, r101) + "...";
    }
}
