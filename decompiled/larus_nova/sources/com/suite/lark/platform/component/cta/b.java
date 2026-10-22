package com.suite.lark.platform.component.cta;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f460475f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f460476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f460477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f460478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f460479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.suite.lark.platform.component.cta.model.a f460480e;

    public static final class a {
    }

    static {
    }

    public b(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "featureKey");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r103, "checkpointUserId");
        this.f460476a = r100;
        this.f460477b = r101;
        this.f460478c = r102;
        this.f460479d = r103;
        this.f460480e = new com.suite.lark.platform.component.cta.model.a();
    }

    public static final void a(b r100, Context r101, goc.b r102, goc.b.d r110, goc.a r111) {
        r100.getClass();
        goc.b.a r103 = r110.a();
        if (r103 == null) goto L5;
        String r104 = r103.a();
    L6:
        String r105 = "";
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        if (r104.length() <= 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        ((eoc.a) ClaymoreServiceLoader.loadFirst(eoc.a.class)).a();
    L15:
        if (r111 == null) goto L20;
        String r107 = r110.e();
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r111.a(r107);
    L20:
        goc.b.g r108 = r102.b();
        if (r108 == null) goto L35;
        goc.b.h r109 = r108.b();
        if (r109 == null) goto L36;
        int r112 = moc.a.f514621a;
        String r113 = r100.f460476a;
        String r114 = r100.f460477b;
        String r115 = r109.b();
        if (r115 != null) goto L28;
        String r116 = "";
    L29:
        boolean r117 = r109.a();
        boolean r118 = r109.d();
        r r119 = r.f570318c3;
        String r120 = r110.e();
        if (r120 == null) goto L33;
        r105 = r120;
    L33:
        moc.a.a(r113, r114, r116, r117, r118, r119.a(r105));
        return;
    L28:
        r116 = r115;
        goto L29
    L36:
        return;
    L35:
        return;
    L12:
        r106 = false;
        goto L13
    L5:
        r104 = null;
        goto L6
    }
}
