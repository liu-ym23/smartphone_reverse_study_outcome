package mi7;

import android.net.Uri;
import ci7.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class n {
    static {
    }

    public static boolean a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        IZlinkDepend r102 = p.a();     // Catch: Throwable -> L17
        Object r103 = null;
        if (r102 == null) goto L14;
        List<String> r104 = r102.getSchemeList();     // Catch: Throwable -> L17
        if (r104 == null) goto L14;
        Iterator<T> r105 = r104.iterator();     // Catch: Throwable -> L17
    L9:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual((String) r106, UriProtector.parse(r100).getScheme()) == false) goto L9;
        r103 = r106;
    L13:
        r103 = (String) r103;     // Catch: Throwable -> L17
    L14:
        if (r103 == null) goto L25;
        return true;
    L25:
        return false;
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return false;
    }

    public static Uri b(Uri r100) {
        if (r100.isHierarchical() == true) goto L5;
        return r100;
    L5:
        Uri.Builder r101 = r100.buildUpon().clearQuery();
        Iterator<String> r102 = UriProtector.getQueryParameterNames(r100).iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        if ((!Intrinsics.areEqual(r103, "scheme")) == false) goto L7;
        Iterator<String> r104 = UriProtector.getQueryParameters(r100, r103).iterator();
    L12:
        if (r104.hasNext() == false) goto L7;
        r101.appendQueryParameter(r103, r104.next());
        goto L12
    L15:
        return r101.build();
    }
}
