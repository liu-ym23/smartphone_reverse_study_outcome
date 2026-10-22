package qi5;

import android.net.Uri;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s45.i;
import s45.p;
import t45.c;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f533149a = null;

    static {
        f533149a = new a();
    }

    public a() {
    }

    public static String a(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return r100;
    L5:
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == true) goto L56;
        return r100;
    L56:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        c r103 = p.a();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.domain.container.ISpaceKitUrlHelper");     // Catch: Throwable -> L22
        String r104 = r103.T6(r100, r101);     // Catch: Throwable -> L22
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
        String r106 = r104;
    L18:
        if (r106 != null) goto L20;
        r106 = r100;
    L20:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L22
    L24:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 != null) goto L27;
        Object r109 = r107;
    L28:
        String r110 = (String) r109;
        Intrinsics.checkNotNullParameter(r110, "url");
        boolean r111 = StringsKt.isBlank(r110);
        String r112 = r110;
        r112 = r110;
        if (r111 == true) goto L51;
        if (r101 == null) goto L51;
        r112 = r110;
        if (r101.intValue() != 12) goto L51;
        Uri r113 = UriProtector.parse(r110);     // Catch: Throwable -> L44
        String r114 = r113.getEncodedPath();     // Catch: Throwable -> L44
        if (r114 != null) goto L39;
        r114 = "";
    L39:
        if (StringsKt.startsWith$default(r114, "/file/", false, 2, null) == true) goto L41;
        String r115 = r110;
    L42:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L44
    L46:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L49;
        Object r118 = r116;
    L50:
        r112 = (String) r118;
        goto L51
    L49:
        tt5.a.l("OfficeLinkShareCopyUrlHelper", "transform office Drive file copy link failed", r117);
        r118 = r110;
        goto L50
    L41:
        String r119 = r113.buildUpon().encodedPath("/drive/file/" + StringsKt.removePrefix(r114, "/file/")).build().toString();     // Catch: Throwable -> L44
        Intrinsics.checkNotNull(r119);     // Catch: Throwable -> L44
        r115 = r119;
    L44:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L51:
        i.f540569a.getClass();
        Intrinsics.checkNotNullParameter(r112, "rawUrl");
        if (StringsKt.isBlank(r112) == false) goto L55;
        return r112;
    L55:
        return i.a(r112);
    L27:
        tt5.a.l("OfficeLinkShareCopyUrlHelper", "concat office link share copy url for doubao failed", r108);
        r109 = r100;
        goto L28
    L17:
        r106 = null;
        goto L18
    L11:
        if (StringsKt.isBlank(r104) == true) goto L14;
        r105 = false;
    L22:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
