package o63;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522194d;

    public static final class a {
    }

    static {
    }

    public i() {
        super("pd_matching_buy_reduce_tab_click");
    }

    @Override // o63.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f522194d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, null, r101);
        super.buildParams();
    }
}
