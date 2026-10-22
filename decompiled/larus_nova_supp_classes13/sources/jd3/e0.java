package jd3;

import com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaProcessor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e0 extends com.bytedance.android.ec.core.event.a {
    public Integer a;
    public String b;
    public String c;
    public PdpSchemaProcessor d;

    public static final class a {
    }

    static {
    }

    public e0() {
        super("schema_report");
    }

    public final void buildParams() {
        Integer r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r3 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("statusCode", r2, r3);
        appendParam("statusMsg", this.b, r3);
        PdpSchemaProcessor r4 = this.d;
        if (r4 == null) goto L9;
        r1 = r4.n();
    L9:
        appendParam("schema", r1);
        appendParam("log_id", this.c);
        appendParam("location", "pdpSchemaConvertFail");
        appendParam("business", "productDetail");
        return;
    L5:
        r2 = null;
        goto L6
    }
}
