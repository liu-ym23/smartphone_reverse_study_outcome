package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498265b;

    @Override // com.bytedance.android.ec.core.event.a
    public void buildParams() {
        String r100 = this.f498264a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("ad_extra_data", r100, r101);
        appendParam("scene_id", this.f498265b, r101);
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100);
    }
}
