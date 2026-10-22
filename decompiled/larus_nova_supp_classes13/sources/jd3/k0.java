package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k0 extends com.bytedance.android.ec.core.event.a {
    public final String a;

    public final void buildParams() {
        String r0 = this.a;
        if (r0 == null) goto L6;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("label_name", r0, com.bytedance.android.ec.core.event.a.b.a.a);
        return;
    }

    public k0(String r2) {
        super("label_explanation_click");
        this.a = r2;
    }
}
