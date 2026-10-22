package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;

    public void buildParams() {
        String r0 = this.a;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("ad_extra_data", r0, r1);
        appendParam("scene_id", this.b, r1);
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        super(r2);
    }
}
