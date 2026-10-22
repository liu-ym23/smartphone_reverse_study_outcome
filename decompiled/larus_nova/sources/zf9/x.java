package zf9;

import android.net.Uri;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x extends DefaultCacheKeyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f571783a = null;

    static {
        f571783a = new x();
    }

    public x() {
    }

    @Override // com.facebook.imagepipeline.cache.DefaultCacheKeyFactory
    public final String getCacheKeySourceUriStr(Uri r100) {
        return getUriCacheKey(r100);
    }

    public final String getUriCacheKey(Uri r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (Intrinsics.areEqual("http", r100.getScheme()) == true) goto L12;
        if (Intrinsics.areEqual("https", r100.getScheme()) == true) goto L12;
        return r100.toString();
    L12:
        return toStringWithoutHost(r100);
    }

    public final String toStringWithoutHost(Uri r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getScheme());
        r101.append(":");
        if (r100.getEncodedAuthority() == null) goto L5;
        r101.append("//");
    L5:
        String r102 = r100.getEncodedPath();
        if (r102 == null) goto L9;
        r101.append(r102);
    L9:
        return r101.toString();
    }
}
