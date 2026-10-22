package com.bytedance.ee.bear.document.ssrrender;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class HtmlCacheRequestManager {
    public static final ArrayList<a> a = null;

    public interface a {
        boolean a(OfflineDoc r1);
    }

    static {
        a = new ArrayList();
    }

    @JvmStatic
    public static final void a(final OfflineDoc r2) {
        Intrinsics.checkNotNullParameter(r2, "offlineDoc");
        CollectionsKt.removeAll(a, new HtmlCacheRequestManager$notifyOnFail$1(r2));
    }

    @JvmStatic
    public static final void b(final OfflineDoc r2) {
        Intrinsics.checkNotNullParameter(r2, "offlineDoc");
        CollectionsKt.removeAll(a, new HtmlCacheRequestManager$notifyOnSuccess$1(r2));
    }

    @JvmStatic
    public static final void c(final OfflineDoc r2) {
        Intrinsics.checkNotNullParameter(r2, "offlineDoc");
        CollectionsKt.removeAll(a, new HtmlCacheRequestManager$notifyOnThrowable$1(r2));
    }
}
