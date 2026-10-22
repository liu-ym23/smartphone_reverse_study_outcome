package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a);
        appendParam("comment_module", this.b);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "comment_card");
    }

    public o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
        this.a = "";
        this.b = "";
    }
}
