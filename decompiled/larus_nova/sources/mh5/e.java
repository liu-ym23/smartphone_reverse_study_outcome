package mh5;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.ee.bear.contract.b0;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ml5.b f513960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f513961b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, Boolean> f513962c = null;

    static {
        f513962c = new LruCache(100);
        String r100 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getUid();
        f513961b = r100;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        ml5.b r101 = new ml5.b("dlp_banner_sp_name" + du5.b.g(r100));
    L6:
        f513960a = r101;
        Flowable.just("").subscribeOn(fo5.d.b()).subscribe(a.f513956a, b.f513957a);
        return;
    L5:
        r101 = new ml5.b("dlp_banner_sp_name");
        goto L6
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return ((Boolean) f513960a.a(du5.b.g(f513961b + r100), Boolean.FALSE)).booleanValue();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        f513960a.b(du5.b.g(f513961b + r100), Boolean.TRUE);
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        LruCache<String, Boolean> r101 = f513962c;
        r101.put(du5.b.g(r100), Boolean.TRUE);
        Map<String, Boolean> r102 = r101.snapshot();
        if (r102 != null) goto L5;
        return;
    L5:
        if ((!r102.isEmpty()) == false) goto L20;
        LinkedHashSet r103 = new LinkedHashSet();
        Iterator<Map.Entry<String, Boolean>> r104 = r102.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Map.Entry<String, Boolean> r105 = r104.next();
        if (r105.getValue().booleanValue() == false) goto L8;
        r103.add(r105.getKey());
        goto L8
    L12:
        Intrinsics.checkNotNullParameter(r103, "data");
        Flowable.just("").subscribeOn(fo5.d.b()).subscribe(new c(r103), d.f513959a);
        return;
    }
}
