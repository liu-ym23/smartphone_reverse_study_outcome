package uw8;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.internal.h;
import org.commonmark.internal.j;
import wvc.f;
import wvc.g;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends j.a {
    public a() {
    }

    @Override // org.commonmark.internal.j.a, wvc.e
    public final f a(g r100, h.a r101) {
        Intrinsics.checkNotNull(r100);
        h r102 = (h) r100;
        if (r102.f525696g < 4) goto L5;
        return null;
    L5:
        CharSequence r103 = r102.f525690a;
        if (r103 != null) goto L9;
        return null;
    L9:
        if (StringsKt.trim(r103).length() > 1) goto L12;
        return null;
    L12:
        return super.a(r100, r101);
    }
}
