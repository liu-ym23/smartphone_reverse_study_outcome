package jf;

import android.content.Context;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.jump.model.g;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface c {

    public static final class a {
        public static void b(String r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "clickArea");
            Intrinsics.checkNotNullParameter(r101, "promotionParams");
        }

        public static Map a(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "eventParams");
            return MapsKt.emptyMap();
        }
    }

    void a();

    void b();

    boolean c(Context r100, com.bytedance.android.btm.api.model.d r101, boolean r102);

    void d(Context r100, com.bytedance.android.btm.api.model.d r101);

    void e(Context r100, com.bytedance.android.btm.api.model.d r101);

    void f(String r100, g r101);

    void g(String r100, ql.a r101, BtmItemBuilder r102);

    void h();

    boolean i(String r100, com.bytedance.android.btm.api.model.d r101);

    Map<String, String> j(String r100, Map<String, String> r101);

    boolean k(String r100);

    void l();

    void m();

    void n(String r100, g r101);
}
