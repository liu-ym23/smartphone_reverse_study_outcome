package hg3;

import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f485007a;

    public static final class a {
    }

    static {
    }

    public c(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(SocialConstants.PARAM_APP_DESC, "order_list_preload");
        r101.put("type", "COMMON_LOG");
        Unit r102 = Unit.INSTANCE;
        this.f485007a = r101;
    }
}
