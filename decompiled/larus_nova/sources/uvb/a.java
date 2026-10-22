package uvb;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.DevEnvUtil;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f551862a = null;

    static {
        f551862a = new a();
    }

    public a() {
    }

    public static String d(String r110) {
        return StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, ';', ',', false, 4, null), '\n', ' ', false, 4, null), '\r', ' ', false, 4, null), '\t', ' ', false, 4, null)).toString();
    }

    public static void b(View r100, c.a r101) {
        Map r102 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "extraFields");
        if (r100 == null) goto L34;
        a r103 = f551862a;
        Context r104 = r100.getContext();
        r103.getClass();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(DevEnvUtil.isDebugMode(r104)));     // Catch: Throwable -> L7
    L9:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L13;
        r106 = r107;
    L13:
        if (((Boolean) r106).booleanValue() == false) goto L35;
        f551862a.getClass();
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "extraFields");
        StringBuilder r108 = new StringBuilder();
        r108.append("minutes-auto:id=");
        r108.append(d(r101.f551896a));
        a(r108, "label", r101.f551897b);
        a(r108, "hint", r101.f551898c);
        a(r108, "expected", r101.f551899d);
        Iterator r109 = r102.entrySet().iterator();
    L17:
        if (r109.hasNext() == false) goto L23;
        Map.Entry r110 = (Map.Entry) r109.next();
        String r111 = (String) r110.getKey();
        String r112 = (String) r110.getValue();
        if ((!StringsKt.isBlank(r111)) == false) goto L17;
        if ((!StringsKt.isBlank(r112)) == false) goto L17;
        f551862a.getClass();
        a(r108, r111, r112);
        goto L17
    L23:
        r100.setContentDescription(r108.toString());
        return;
    L35:
        return;
    L7:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void c(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pageName");
        f551862a.getClass();
        Intrinsics.checkNotNullParameter(r101, "pageName");
        String r102 = "minutes-office-sdk-page-" + new Regex("([a-z0-9])([A-Z])").replace(r101, "$1-$2").toLowerCase(Locale.ROOT);
        b(r100, new c.a(r102, r101, "", r102));
    }

    public static void a(StringBuilder r100, String r101, String r102) {
        r100.append(';');
        r100.append(d(r101));
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(d(r102));
    }
}
