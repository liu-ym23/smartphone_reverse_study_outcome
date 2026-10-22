package com.bytedance.ee.bear.document.ssrrender;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class HtmlCacheRequestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<a> f221894a = null;

    public interface a {
        boolean a(OfflineDoc r100);
    }

    static {
        f221894a = new ArrayList();
    }

    @JvmStatic
    public static final void a(final OfflineDoc r100) {
        Intrinsics.checkNotNullParameter(r100, "offlineDoc");
        CollectionsKt.removeAll(f221894a, new HtmlCacheRequestManager$notifyOnFail$1(r100));
    }

    @JvmStatic
    public static final void b(final OfflineDoc r100) {
        Intrinsics.checkNotNullParameter(r100, "offlineDoc");
        CollectionsKt.removeAll(f221894a, new HtmlCacheRequestManager$notifyOnSuccess$1(r100));
    }

    @JvmStatic
    public static final void c(final OfflineDoc r100) {
        Intrinsics.checkNotNullParameter(r100, "offlineDoc");
        CollectionsKt.removeAll(f221894a, new HtmlCacheRequestManager$notifyOnThrowable$1(r100));
    }
}
