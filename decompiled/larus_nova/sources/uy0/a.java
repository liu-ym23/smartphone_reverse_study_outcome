package uy0;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f552061a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r100;
    L8:
        if (StringsKt.endsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == false) goto L11;
        return r100;
    L11:
        return r100.concat(HTTP.URL_DEFAULT);
    L5:
        r101 = false;
        goto L6
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        int r101 = StringsKt.lastIndexOf$default(r100, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r101 == (-1)) goto L7;
        int r102 = r101 + 1;
        if (r102 >= r100.length()) goto L7;
        return r100.substring(r102);
    L7:
        return null;
    }
}
