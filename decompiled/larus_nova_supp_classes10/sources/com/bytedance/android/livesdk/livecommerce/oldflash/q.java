package com.bytedance.android.livesdk.livecommerce.oldflash;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public final String a;
    public final String b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public final void b(String r5) {
        com.bytedance.android.livesdk.livecommerce.event.x r0 = new com.bytedance.android.livesdk.livecommerce.event.x(this.a, this.b, this.c);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.f("attribute_name", r5);
        r0.k();
    }

    public final void a(boolean r5, String r6) {
        com.bytedance.android.livesdk.livecommerce.event.a0 r0 = new com.bytedance.android.livesdk.livecommerce.event.a0(this.a, this.b, this.c);
        if (r5 == false) goto L5;
        String r7 = "auto";
    L6:
        r0.f("auto_type", r7);
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        r0.f("attribute_name", r6);
        r0.k();
        return;
    L5:
        r7 = "manual";
        goto L6
    }

    public q(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "productType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void c(String r5, String r6, boolean r7) {
        com.bytedance.android.livesdk.livecommerce.event.x r0 = new com.bytedance.android.livesdk.livecommerce.event.x(this.a, this.b, this.c);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.f("attribute_name", r5);
        r0.f("click_area", r6);
        if (r7 == false) goto L8;
        String r8 = "auto";
    L9:
        r0.f("auto_type", r8);
        r0.k();
        return;
    L8:
        r8 = "manual";
        goto L9
    }
}
