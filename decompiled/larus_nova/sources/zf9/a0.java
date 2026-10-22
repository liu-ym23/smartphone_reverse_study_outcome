package zf9;

import android.net.Uri;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 extends DefaultCacheKeyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f571765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f571766b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f571767c = null;

    static {
        f571765a = new a0();
        f571766b = LazyKt.lazy(new y());
        f571767c = LazyKt.lazy(new z());
    }

    public a0() {
    }

    @Override // com.facebook.imagepipeline.cache.DefaultCacheKeyFactory
    public final String getCacheKeySourceUriStr(Uri r100) {
        return getUriCacheKey(r100);
    }

    public final String getUriCacheKey(Uri r100) {
        String r101 = "";
        if (r100 != null) goto L6;
        return "";
    L6:
        if (Intrinsics.areEqual("http", r100.getScheme()) == false) goto L8;
    L11:
        String r102 = r100.getEncodedPath();
        if (r102 == null) goto L15;
        r101 = r102;
    L15:
        List r103 = (List) f571766b.getValue();
        boolean r104 = true;
        if ((r103 instanceof Collection) == true) goto L18;
    L20:
        Iterator r105 = r103.iterator();
    L22:
        if (r105.hasNext() == false) goto L19;
        if (StringsKt.contains$default(r101, (String) r105.next(), false, 2, null) == false) goto L22;
        boolean r106 = true;
    L26:
        if (r106 == true) goto L28;
        String r107 = r100.getHost();
        if (r107 == null) goto L42;
        String[] r108 = (String[]) f571767c.getValue();
        int r109 = r108.length;
        int r110 = 0;
    L32:
        if (r110 >= r109) goto L37;
        if (Intrinsics.areEqual(r108[r110], r107) == true) goto L38;
        r110 = r110 + 1;
    L38:
        if (r104 == false) goto L42;
        return toStringWithoutHost(r100);
    L37:
        r104 = false;
    L42:
        return r100.toString();
    L28:
        return toStringWithoutHost(r100);
    L19:
        r106 = false;
        goto L26
    L18:
        if (r103.isEmpty() == false) goto L20;
    L8:
        if (Intrinsics.areEqual("https", r100.getScheme()) == true) goto L11;
        return r100.toString();
    }

    public final String toStringWithoutHost(Uri r100) {
        StringBuilder r101 = new StringBuilder();
        String r102 = r100.getEncodedPath();
        if (r102 == null) goto L6;
        r101.append(r102);
    L6:
        return r101.toString();
    }
}
