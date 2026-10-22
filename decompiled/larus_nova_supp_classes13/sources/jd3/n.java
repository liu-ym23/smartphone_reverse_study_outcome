package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.android.ec.core.event.a {
    public final Map<String, String> a;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        appendParam(this.a);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "comment_card");
    }

    public n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
        this.a = new LinkedHashMap();
    }
}
