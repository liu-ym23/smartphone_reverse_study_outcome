package ac5;

import android.content.Context;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.route.a {

    /* JADX INFO: renamed from: ac5.a$a, reason: collision with other inner class name */
    public static final class C0004a {
    }

    static {
    }

    public final String e(BearUrl r1, RouteBean r2) {
        return "";
    }

    public a() {
    }

    public final boolean b(Context r5, BearUrl r6, RouteBean r7) {
        Intrinsics.checkNotNullParameter(r6, "bearUrl");
        com.bytedance.ee.bear.lark.dependency.i r8 = (com.bytedance.ee.bear.lark.dependency.i) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.i.class, null, null, 6);
        if (StringsKt.startsWith$default(r6.e, "http://", false, 2, null) == false) goto L6;
        r6.e.substring(7);
    L8:
        r8.a();
        return false;
    L6:
        if (StringsKt.startsWith$default(r6.e, "https://", false, 2, null) == false) goto L8;
        r6.e.substring(8);
        goto L8
    }
}
