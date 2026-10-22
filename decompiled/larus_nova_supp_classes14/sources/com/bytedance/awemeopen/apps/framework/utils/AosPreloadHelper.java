package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.appserviceimpl.feed.preload.FeedListPreloader;
import com.bytedance.awemeopen.bizmodels.feed.preload.AosPreloadFeedListReason;
import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosPreloadHelper implements q54.b {
    public static final AosPreloadHelper a = null;
    public static final v24.c b = null;
    public static final v24.b c = null;
    public static final v24.a d = null;
    public static final h34.a e = null;

    public AosPreloadHelper() {
    }

    static {
        a = new AosPreloadHelper();
        d14.a r0 = b14.a.a;
        v24.c r1 = b14.a.a(v24.c.class);
        b = r1;
        r1.W2();
        FeedListPreloader r2 = FeedListPreloader.a;
        c = r2;
        r1.o2();
        d = com.bytedance.awemeopen.appserviceimpl.feed.preload.a.a;
        h34.a r3 = b14.a.a(h34.a.class);
        e = r3;
        r3.w();
        i14.b r4 = i14.b.a;
        r54.a r5 = AosExtConfig.b.z0();
        r2.f(new w14.a(r5.a, r5.b, r5.c, r5.d, r5.e, r5.f, r5.g));
    }

    public final void a() {
        c(AosPreloadFeedListReason.HOST_INVOKE_PRELOAD);
    }

    public static void c(AosPreloadFeedListReason r4) {
        Intrinsics.checkNotNullParameter(r4, "preloadReason");
        v24.b r0 = c;
        w24.b r1 = new w24.b();
        List r2 = q.b();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.n = r2;
        r1.r = "host_preload";
        Unit r3 = Unit.INSTANCE;
        r0.c(r4, r1);
    }

    public final void b(List<q54.a> r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "list");
        v24.a r1 = d;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r0 = r17.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        q54.a r3 = (q54.a) r0.next();
        r2.add(new AosAwemePreloadModel(r3.a, r3.b, r3.c, r3.d, r3.e, r3.f, r3.g, r3.h, r3.i, r3.j));
        goto L4
    L6:
        r1.a(r2, AosPreloadHelper$preload$2.INSTANCE, r18);
    }
}
