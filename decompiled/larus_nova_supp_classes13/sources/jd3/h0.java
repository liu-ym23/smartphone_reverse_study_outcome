package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h0 extends com.bytedance.android.ec.core.event.a {
    public Long a;
    public Long b;
    public Long c;
    public Long d;
    public String e;
    public String f;
    public String g;

    public static final class a {
    }

    static {
    }

    public h0() {
        super("product_comment_tag_click");
    }

    public final void buildParams() {
        Long r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0.longValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r3 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, r2, r3);
        Long r4 = this.b;
        if (r4 == null) goto L9;
        String r5 = String.valueOf(r4.longValue());
    L10:
        appendParam("order_id", r5, r3);
        Long r6 = this.c;
        if (r6 == null) goto L13;
        String r7 = String.valueOf(r6.longValue());
    L14:
        appendParam("comment_id", r7, r3);
        Long r8 = this.d;
        if (r8 == null) goto L17;
        r1 = String.valueOf(r8.longValue());
    L17:
        appendParam("comment_rank", r1, r3);
        appendParam("comment_module", this.e, r3);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, this.f, r3);
        appendParam("tag_type", this.g, r3);
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
