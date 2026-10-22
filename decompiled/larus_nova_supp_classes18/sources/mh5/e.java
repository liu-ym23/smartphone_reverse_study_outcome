package mh5;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final ml5.b a = null;
    public static final String b = null;
    public static final LruCache<String, Boolean> c = null;

    static {
        c = new LruCache(100);
        String r0 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getUid();
        b = r0;
        if (TextUtils.isEmpty(r0) == true) goto L5;
        ml5.b r1 = new ml5.b("dlp_banner_sp_name" + du5.b.g(r0));
    L6:
        a = r1;
        Flowable.just("").subscribeOn(fo5.d.b()).subscribe(a.a, b.a);
        return;
    L5:
        r1 = new ml5.b("dlp_banner_sp_name");
        goto L6
    }

    public static boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return ((Boolean) a.a(du5.b.g(b + r3), Boolean.FALSE)).booleanValue();
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        a.b(du5.b.g(b + r3), Boolean.TRUE);
    }

    public static void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        LruCache<String, Boolean> r0 = c;
        r0.put(du5.b.g(r3), Boolean.TRUE);
        Map<String, Boolean> r4 = r0.snapshot();
        if (r4 != null) goto L5;
        return;
    L5:
        if ((!r4.isEmpty()) == false) goto L20;
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<Map.Entry<String, Boolean>> r5 = r4.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Map.Entry<String, Boolean> r2 = r5.next();
        if (r2.getValue().booleanValue() == false) goto L8;
        r1.add(r2.getKey());
        goto L8
    L12:
        Intrinsics.checkNotNullParameter(r1, WikiFolderPushPlugin.DATA);
        Flowable.just("").subscribeOn(fo5.d.b()).subscribe(new c(r1), d.a);
        return;
    }
}
