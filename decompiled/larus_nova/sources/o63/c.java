package o63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f522178f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f522180e;

    public static final class a {
    }

    static {
    }

    @Override // o63.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f522179d;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam("is_click", r100, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_PRODUCT_ID, this.f522180e);
        super.buildParams();
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
