package com.ss.android.lark.statistics.announce_opendoc;

import com.larksuite.framework.thread.CoreThreadPool;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AnnounceOpenDocHitPoint extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnounceOpenDocHitPoint f440620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f440621b = null;

    static {
        f440620a = new AnnounceOpenDocHitPoint();
        f440621b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AnnounceOpenDocHitPoint$statistics$2.INSTANCE);
    }

    public AnnounceOpenDocHitPoint() {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter("message", "from");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r100));
    }
}
