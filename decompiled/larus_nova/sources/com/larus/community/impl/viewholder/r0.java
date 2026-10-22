package com.larus.community.impl.viewholder;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f330105a = false;

    static {
        if (z2.f365865a.creationFeedThumbRatioLimit43() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        f330105a = r100;
        boolean r101 = m29.a.f511679a;
        m29.a.c("CreationViewHolderUtils", "use is 4_3:" + r100);
        return;
    L5:
        if (AppHost.f326268a.isOversea() == true) goto L7;
        r100 = true;
        goto L8
    }

    public static ResizeOptions a() {
        if (z2.f365865a.getCreationPreviewPerformanceOptConfig().f365598g == true) goto L7;
        return null;
    L7:
        return new ResizeOptions(i5.q(), i5.q());
    }

    public static int b(final Integer r100, final Integer r110, final int r111, final String r112) {
        Intrinsics.checkNotNullParameter(r112, "trackTag");
        boolean r101 = f330105a;
        if (r101 == false) goto L5;
        float r102 = 1.3333334f;
    L6:
        if (r101 == false) goto L8;
        float r103 = 0.75f;
    L9:
        final Ref.FloatRef r104 = new Ref.FloatRef();
        float r105 = r111;
        float r106 = r102 * r105;
        r104.element = r106;
        if (r100 == null) goto L25;
        if (r110 == null) goto L25;
        if (r100.intValue() == 0) goto L25;
        if (r111 == (-1)) goto L25;
        float r107 = (r110.intValue() * r111) / r100.intValue();
        if (r107 > r106) goto L23;
        r106 = r105 * r103;
        if (r107 < r106) goto L23;
        r106 = r107;
    L23:
        r104.element = r106;
        m29.a.a("CreationViewHolderUtils", new q0(r112, r100, r110, r111, r104));
    L25:
        return (int) r104.element;
    L8:
        r103 = 0.5625f;
        goto L9
    L5:
        r102 = 1.7777778f;
        goto L6
    }
}
