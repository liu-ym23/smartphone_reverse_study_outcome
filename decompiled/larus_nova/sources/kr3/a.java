package kr3;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f505704a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return "";
    L13:
        if (StringsKt.startsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == false) goto L16;
        return r100;
    L16:
        return HTTP.URL_DEFAULT + r100;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static Uri b(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "queryParameterName");
        Intrinsics.checkNotNullParameter(r102, "queryParameterValue");
        if (r100.isHierarchical() == true) goto L5;
        return r100;
    L5:
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();
    L7:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();
        if (Intrinsics.areEqual(r105, r101) == false) goto L10;
        r103.appendQueryParameter(r101, r102);
        goto L7
    L10:
        Iterator<String> r106 = UriProtector.getQueryParameters(r100, r105).iterator();
    L12:
        if (r106.hasNext() == false) goto L7;
        r103.appendQueryParameter(r105, r106.next());
        goto L12
    L16:
        return r103.build();
    }
}
