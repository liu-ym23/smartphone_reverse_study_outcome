package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f243994f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qw5.a f243995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw5.a f243996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final buc.c f243997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.flow_audio.impl.business.asr.a> f243998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.flow_audio.impl.business.asr.a> f243999e;

    public static final class a {
    }

    static {
        f243994f = zw5.b.a("FlowAsrRetryController");
    }

    public m(qw5.a r100, zw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "logContext");
        this.f243995a = r100;
        this.f243996b = r101;
        this.f243997c = buc.b.b();
        ArrayList r102 = new ArrayList();
        this.f243998d = r102;
        ArrayList r103 = new ArrayList();
        this.f243999e = r103;
        gw5.i r104 = r100.f535002j;
        if (r104 == null) goto L8;
        gw5.c r105 = r104.f483066g;
        if (r105 == null) goto L8;
        List<String> r106 = r105.f483042c;
        if (r106 == null) goto L8;
    L9:
        b r107 = new b(r106);
        Intrinsics.checkNotNullParameter(r107, com.heytap.mcssdk.constant.b.f276366p);
        r103.add(r107);
        gw5.i r108 = r100.f535002j;
        if (r108 == null) goto L15;
        gw5.c r109 = r108.f483066g;
        if (r109 == null) goto L15;
        List<String> r110 = r109.f483043d;
        if (r110 == null) goto L15;
    L16:
        c r111 = new c(r110);
        Intrinsics.checkNotNullParameter(r111, com.heytap.mcssdk.constant.b.f276366p);
        r102.add(r111);
        return;
    L15:
        r110 = CollectionsKt.emptyList();
    L8:
        r106 = CollectionsKt.emptyList();
        goto L9
    }

    public final void a(hw5.a r100, String r101) {
        IKMPLoggerService r102 = lp7.a.f510233a;
        lp7.a.c(f243994f, this.f243996b.a("retry rejected reason=" + r101 + " currentRetryCount=" + this.f243997c.b() + ' ' + zw5.b.b(r100)));
    }
}
