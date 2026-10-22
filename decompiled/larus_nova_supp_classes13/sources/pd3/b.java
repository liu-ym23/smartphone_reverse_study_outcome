package pd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends pd3.a {
    public String j;

    public static final class a {
    }

    static {
    }

    public b() {
        super("inflow_price_feedback_panel_click");
    }

    @Override // pd3.a
    public final void buildParams() {
        super.buildParams();
        String r0 = this.j;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("title", r0, com.bytedance.android.ec.core.event.a.b.a.a);
    }
}
