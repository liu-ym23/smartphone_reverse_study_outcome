package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;

    public d() {
        super("click_activity_entrance");
    }

    public final void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, r0, r1);
        appendParam("module_name", this.b, r1);
        appendParam("activity_name", this.c, r1);
    }
}
