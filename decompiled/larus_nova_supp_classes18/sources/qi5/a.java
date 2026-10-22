package qi5;

import android.net.Uri;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s45.i;
import s45.p;
import t45.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static String a(String r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_URL);
        if (StringsKt.isBlank(r7) == false) goto L5;
        return r7;
    L5:
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == true) goto L56;
        return r7;
    L56:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        c r4 = p.a();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.domain.container.ISpaceKitUrlHelper");     // Catch: Throwable -> L22
        String r5 = r4.T6(r7, r8);     // Catch: Throwable -> L22
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        String r9 = r5;
    L18:
        if (r9 != null) goto L20;
        r9 = r7;
    L20:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L22
    L24:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 != null) goto L27;
        Object r12 = r10;
    L28:
        String r13 = (String) r12;
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_URL);
        boolean r0 = StringsKt.isBlank(r13);
        String r14 = r13;
        r14 = r13;
        if (r0 == true) goto L51;
        if (r8 == null) goto L51;
        r14 = r13;
        if (r8.intValue() != 12) goto L51;
        Uri r15 = UriProtector.parse(r13);     // Catch: Throwable -> L44
        String r1 = r15.getEncodedPath();     // Catch: Throwable -> L44
        if (r1 != null) goto L39;
        r1 = "";
    L39:
        if (StringsKt.startsWith$default(r1, "/file/", false, 2, null) == true) goto L41;
        String r16 = r13;
    L42:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L44
    L46:
        Throwable r2 = Result.exceptionOrNull-impl(r17);
        if (r2 != null) goto L49;
        Object r18 = r17;
    L50:
        r14 = (String) r18;
        goto L51
    L49:
        tt5.a.l("OfficeLinkShareCopyUrlHelper", "transform office Drive file copy link failed", r2);
        r18 = r13;
        goto L50
    L41:
        String r19 = r15.buildUpon().encodedPath("/drive/file/" + StringsKt.removePrefix(r1, "/file/")).build().toString();     // Catch: Throwable -> L44
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L44
        r16 = r19;
    L44:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L51:
        i.a.getClass();
        Intrinsics.checkNotNullParameter(r14, "rawUrl");
        if (StringsKt.isBlank(r14) == false) goto L55;
        return r14;
    L55:
        return i.a(r14);
    L27:
        tt5.a.l("OfficeLinkShareCopyUrlHelper", "concat office link share copy url for doubao failed", r11);
        r12 = r7;
        goto L28
    L17:
        r9 = null;
        goto L18
    L11:
        if (StringsKt.isBlank(r5) == true) goto L14;
        r6 = false;
    L22:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
