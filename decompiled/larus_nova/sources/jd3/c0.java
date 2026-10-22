package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f498270b;

    public static final class a {
    }

    static {
    }

    public c0() {
        Intrinsics.checkNotNullParameter("ec_order_video_download_image", "eventName");
        super("ec_order_video_download_image");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f498269a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("product_id", r100, r101);
        Integer r102 = this.f498270b;
        if (r102 == null) goto L5;
        String r103 = String.valueOf(r102.intValue());
    L6:
        appendParam("image_size", r103, r101);
        appendParam("image_url", null, r101);
        appendParam("error_msg", null, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
