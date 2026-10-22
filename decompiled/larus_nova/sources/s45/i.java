package s45;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f540569a = null;

    static {
        f540569a = new i();
    }

    public i() {
    }

    public static String a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L12
        String r103 = r102.getEncodedPath();     // Catch: Throwable -> L12
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        if (StringsKt.startsWith$default(r103, "/drive/folder/", false, 2, null) == true) goto L9;
        String r104 = r100;
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 != null) goto L17;
        Object r107 = r105;
    L19:
        return (String) r107;
    L17:
        tt5.a.l("OfficeFolderCopyLinkUrlHelper", "transform office folder copy link failed", r106);
        r107 = r100;
        goto L19
    L9:
        String r108 = r102.buildUpon().encodedPath("/drive/shr/" + StringsKt.removePrefix(r103, "/drive/folder/")).build().toString();     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L12
        r104 = r108;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static String b(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "rawUrl");
        if (r102 == true) goto L5;
        return r100;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L11;
        if (r101 == 0) goto L9;
        return r100;
    L9:
        return a(r100);
    L11:
        return r100;
    }
}
