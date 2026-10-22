package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class k0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498373a;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498373a;
        if (r100 == null) goto L6;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        return;
    }

    public k0(String r100) {
        super("label_explanation_click");
        this.f498373a = r100;
    }
}
