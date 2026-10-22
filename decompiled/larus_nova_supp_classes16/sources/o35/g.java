package o35;

import com.bytedance.ee.bear.document.offline.base.datapage.OfflineResultModelV2;
import com.bytedance.ee.bear.document.render.core.offline.datapage.JsResult;
import io.reactivex.Flowable;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static void a(final OfflineResultModelV2 r2, final m r3, final String r4) {
        Flowable.just("").observeOn(fo5.d.d()).subscribe(new e(r4, r2, r3), new f(r4, r3));
    }

    public static void b(int r4, m r5, String r6) {
        JsResult r1 = JsResult.FAIL;
        a(new OfflineResultModelV2(r1.getCode(), r1.getMessage(), "", r4), r5, r6);
    }

    public static void c(int r4, m r5, String r6) {
        JsResult r1 = JsResult.SUCCESS;
        a(new OfflineResultModelV2(r1.getCode(), r1.getMessage(), "", r4), r5, r6);
    }
}
