package nj5;

import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s45.p;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f519451a = 0;

    static {
    }

    public static String a(oj5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "moreInfo");
        String r101 = r100.getContainerUrl();
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = UriProtector.parse(r101).buildUpon().clearQuery().toString();
        if (r100.o() == false) goto L12;
        BearUrl r103 = p.a().Z(r102);
        return UriProtector.parse(r102).buildUpon().path(p.a().j8(r103.f222560a, r103.f222561b)).toString();
    L12:
        return r102;
    }
}
