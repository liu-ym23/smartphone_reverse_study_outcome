package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public Integer b;

    public static final class a {
    }

    static {
    }

    public c0() {
        Intrinsics.checkNotNullParameter("ec_order_video_download_image", "eventName");
        super("ec_order_video_download_image");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, r0, r1);
        Integer r2 = this.b;
        if (r2 == null) goto L5;
        String r3 = String.valueOf(r2.intValue());
    L6:
        appendParam("image_size", r3, r1);
        appendParam("image_url", null, r1);
        appendParam("error_msg", null, r1);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
