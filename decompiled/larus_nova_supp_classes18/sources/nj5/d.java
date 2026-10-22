package nj5;

import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(oj5.c r3) {
        Intrinsics.checkNotNullParameter(r3, "moreInfo");
        String r0 = r3.getContainerUrl();
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        String r1 = UriProtector.parse(r0).buildUpon().clearQuery().toString();
        if (r3.o() == false) goto L12;
        BearUrl r4 = p.a().Z(r1);
        return UriProtector.parse(r1).buildUpon().path(p.a().j8(r4.a, r4.b)).toString();
    L12:
        return r1;
    }
}
