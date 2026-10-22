package q20;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531349a = 0;

    static {
    }

    public static String a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        int r101 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;     // Catch: Exception -> L5
        return com.bytedance.ies.bullet.kit.resourceloader.loader.b.c(r100) + '_' + com.bytedance.ies.bullet.kit.resourceloader.loader.b.c(UriProtector.parse(UriProtector.getQueryParameter(r100, "url"))) + ')';
    L6:
        return com.bytedance.ies.bullet.kit.resourceloader.loader.b.c(r100);
    }

    public static Uri b(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r101, "newValue");
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        Uri.Builder r103 = r100.buildUpon();
        if (r102.contains("url") == false) goto L14;
        r103.clearQuery();
        Iterator<String> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L6;
        if (Intrinsics.areEqual(r105, "url") == false) goto L12;
        String r106 = r101;
    L13:
        r103.appendQueryParameter(r105, r106);
        goto L6
    L12:
        r106 = UriProtector.getQueryParameter(r100, r105);
    L16:
        return r103.build();
    L14:
        r103.appendQueryParameter("url", r101);
        goto L16
    }
}
