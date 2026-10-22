package g2a;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends c {
    public a() {
    }

    @Override // g2a.c
    public final String b(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (r101 != 0) goto L6;
        return "[erase-" + r100.length() + ']';
    L6:
        if (r100.length() <= r101) goto L9;
        return StringsKt.take(r100, r101) + "[erase-" + (r100.length() - r101) + ']';
    L9:
        return r100.toString();
    }
}
