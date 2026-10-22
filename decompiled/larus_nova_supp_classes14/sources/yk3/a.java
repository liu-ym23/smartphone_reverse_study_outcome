package yk3;

import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Deprecated(message = "3D功能已下线, 请检查此埋点上报是否合理")
public final class a extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;

    public a() {
        super("3dmodel_click_product");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("author_id", r0, r1);
        appendParam("product_id", this.b, r1);
        appendParam("enter_from", this.c, r1);
        appendParam("click_area", this.d, r1);
    }
}
