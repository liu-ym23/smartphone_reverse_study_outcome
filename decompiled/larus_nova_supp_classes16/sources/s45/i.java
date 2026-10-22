package s45;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public static String a(String r7) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Uri r3 = UriProtector.parse(r7);     // Catch: Throwable -> L12
        String r4 = r3.getEncodedPath();     // Catch: Throwable -> L12
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        if (StringsKt.startsWith$default(r4, "/drive/folder/", false, 2, null) == true) goto L9;
        String r0 = r7;
    L10:
        Object r1 = Result.constructor-impl(r0);     // Catch: Throwable -> L12
    L14:
        Throwable r5 = Result.exceptionOrNull-impl(r1);
        if (r5 != null) goto L17;
        Object r8 = r1;
    L19:
        return (String) r8;
    L17:
        tt5.a.l("OfficeFolderCopyLinkUrlHelper", "transform office folder copy link failed", r5);
        r8 = r7;
        goto L19
    L9:
        String r6 = r3.buildUpon().encodedPath("/drive/shr/" + StringsKt.removePrefix(r4, "/drive/folder/")).build().toString();     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L12
        r0 = r6;
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static String b(String r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "rawUrl");
        if (r3 == true) goto L5;
        return r1;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L11;
        if (r2 == 0) goto L9;
        return r1;
    L9:
        return a(r1);
    L11:
        return r1;
    }
}
