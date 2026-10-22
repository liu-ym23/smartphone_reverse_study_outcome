package fb5;

import com.bytedance.ee.bear.config.AtRegexConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements c {
    public final AtRegexConfig a;

    public static final class a {
    }

    static {
    }

    public b() {
        ArrayList<String> r3 = null;
        AtRegexConfig r0 = (AtRegexConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(AtRegexConfig.KEY, AtRegexConfig.class, null);
        this.a = r0;
        StringBuilder r1 = new StringBuilder("blackSuffixList = ");
        if (r0 == null) goto L5;
        r3 = r0.getBlackSuffixList();
    L5:
        r1.append(r3);
        tt5.a.h("EndCharRemovalProcessor", r1.toString());
    }

    @Override // fb5.c
    public final Pair<String, Boolean> a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "url");
        AtRegexConfig r0 = this.a;
        if (r0 == null) goto L26;
        ArrayList<String> r1 = r0.getBlackSuffixList();
        if (r1 == null) goto L26;
        if (r1.isEmpty() == true) goto L10;
    L11:
        Iterator<String> r2 = r1.iterator();
    L12:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L22;
        String r4 = r2.next();
        if (r4.length() <= 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L12;
        if (StringsKt.endsWith$default(r8, r4, false, 2, null) == false) goto L12;
        r8 = r8.substring(0, r8.length() - r4.length());
        r3 = true;
        goto L22
    L17:
        r5 = false;
    L22:
        if (r3 == true) goto L11;
        return new Pair(r8, Boolean.FALSE);
    L10:
        return new Pair(r8, Boolean.FALSE);
    L26:
        return new Pair(r8, Boolean.FALSE);
    }
}
