package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class y extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498571a;

    public y() {
        super("invalid_activity_event");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498571a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(com.bytedance.android.ec.core.event.a.KEY_PAGE_LOCATION, r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
    }
}
