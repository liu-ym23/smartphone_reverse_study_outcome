package ox6;

import android.content.Context;
import bu6.c;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f527090a = 0;

    /* JADX INFO: renamed from: ox6.a$a, reason: collision with other inner class name */
    public static final class C7125a {
        public C7125a() {
        }

        public static /* synthetic */ c b(Context r100, String r101, String r110, String r111, String r112, String r113) {
            return a(r100, true, r101, r110, r111, r112, r113, null);
        }

        public static c a(Context r110, boolean r111, String r112, String r113, String r114, String r115, String r116, String r117) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r111 == false) goto L5;
            String r100 = "product_page_search_icon";
        L7:
            return new c(r112, r113, r100, r110.getString(R.string.trade_goods_search_default_suggest), r114, r115, r116, r117);
        L5:
            r100 = "product_page_search_bar";
            goto L7
        }
    }

    static {
        new C7125a();
    }
}
