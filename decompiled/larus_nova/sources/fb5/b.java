package fb5;

import com.bytedance.ee.bear.config.AtRegexConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtRegexConfig f476263a;

    public static final class a {
    }

    static {
    }

    public b() {
        ArrayList<String> r100 = null;
        AtRegexConfig r101 = (AtRegexConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(AtRegexConfig.KEY, AtRegexConfig.class, null);
        this.f476263a = r101;
        StringBuilder r102 = new StringBuilder("blackSuffixList = ");
        if (r101 == null) goto L5;
        r100 = r101.getBlackSuffixList();
    L5:
        r102.append(r100);
        tt5.a.h("EndCharRemovalProcessor", r102.toString());
    }

    @Override // fb5.c
    public final Pair<String, Boolean> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        AtRegexConfig r101 = this.f476263a;
        if (r101 == null) goto L26;
        ArrayList<String> r102 = r101.getBlackSuffixList();
        if (r102 == null) goto L26;
        if (r102.isEmpty() == true) goto L10;
    L11:
        Iterator<String> r103 = r102.iterator();
    L12:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L22;
        String r105 = r103.next();
        if (r105.length() <= 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L12;
        if (StringsKt.endsWith$default(r100, r105, false, 2, null) == false) goto L12;
        r100 = r100.substring(0, r100.length() - r105.length());
        r104 = true;
        goto L22
    L17:
        r106 = false;
    L22:
        if (r104 == true) goto L11;
        return new Pair(r100, Boolean.FALSE);
    L10:
        return new Pair(r100, Boolean.FALSE);
    L26:
        return new Pair(r100, Boolean.FALSE);
    }
}
