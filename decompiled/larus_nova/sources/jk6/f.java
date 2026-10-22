package jk6;

import android.text.SpannableString;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements ik6.c {
    public f() {
    }

    @Override // ik6.c
    public final void a(SpanRendClient r110, ik6.d r111) {
        Intrinsics.checkNotNullParameter(r110, "client");
        Intrinsics.checkNotNullParameter(r111, "rendItem");
        StringBuilder r100 = new StringBuilder();
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r111.f490269a.f472943a.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        ek6.d r103 = (ek6.d) r102.next();
        ik6.a r104 = r110.a(r103);
        if (r104 == null) goto L4;
        String r105 = r104.e(r103);
        if (r105.length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L4;
        r101.put(r103, new ak6.c(r100.length(), r100.length() + r105.length()));
        r100.append(r105);
        goto L4
    L10:
        r106 = false;
        goto L11
    L13:
        SpannableString r112 = new SpannableString(r100);
        Intrinsics.checkNotNullParameter(r112, "spannable");
        r111.f490271c = r112;
        Intrinsics.checkNotNullParameter(r101, "indexMap");
        r111.f490272d = r101;
    }
}
