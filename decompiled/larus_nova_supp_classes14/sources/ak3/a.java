package ak3;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.store.router.hybridpage.slice.HybridPageSlcTemplateManager;
import com.bytedance.android.shopping.store.router.hybridpage.view.HybridPageCustomElementManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vj3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static boolean a;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
    }

    public final synchronized void a(Context r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "context");     // Catch: Throwable -> L11
        if (a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        a = true;     // Catch: Throwable -> L11
        dm.a.a("HybridPageSlcPreloadManager").i("initTemplateManager");     // Catch: Throwable -> L11
        HybridPageSlcTemplateManager.b(r3);     // Catch: Throwable -> L11
        HybridPageCustomElementManager.a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static String c(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "originalUrl");
        Intrinsics.checkNotNullParameter(r10, "suffix");
        List r0 = StringsKt.split$default(r9, new String[]{"/"}, false, 0, 6, null);
        if ((!r0.isEmpty()) == true) goto L5;
        return r9;
    L5:
        if (Intrinsics.areEqual((String) CollectionsKt.lastOrNull(r0), "main.json") == true) goto L7;
        return r9;
    L7:
        return CollectionsKt.joinToString$default(CollectionsKt.plus(CollectionsKt.dropLast(r0, 1), r10), "/", null, null, 0, null, null, 62, null);
    }

    public final void b(Context r3, b r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "setting");
        a(r3);
        Intrinsics.checkNotNullParameter(r4, "setting");
        String r5 = r4.b();
        if (r5 == null) goto L6;
        ECLiveHybridUtil.l(c(r5, "config.json"), false);
    L6:
        Intrinsics.checkNotNullParameter(r4, "setting");
        String r6 = r4.b();
        if (r6 == null) goto L11;
        ECLiveHybridUtil.l(c(r6, "page_card.js"), true);
        return;
    }
}
