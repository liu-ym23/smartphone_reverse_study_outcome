package gh3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f481265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f481266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f481267c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f481265a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_KEY_ID, r100, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_KEY_RANK, this.f481266b, r101);
        appendParam("request_id", this.f481267c, r101);
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
