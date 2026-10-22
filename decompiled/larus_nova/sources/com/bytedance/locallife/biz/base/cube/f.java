package com.bytedance.locallife.biz.base.cube;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f256536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<fp6.h, at6.a.InterfaceC0224a> f256537b = null;

    public static final class a implements at6.a.InterfaceC0224a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fp6.h f256538a;

        public a(fp6.h r100) {
            this.f256538a = r100;
        }

        @Override // at6.a.InterfaceC0224a
        public final void a(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f256538a.a(new com.bytedance.locallife.cube.b(r100, r101));
        }
    }

    public f() {
    }

    static {
        f256536a = new f();
        f256537b = new ConcurrentHashMap();
    }

    public final void a(fp6.h r100) {
        Intrinsics.checkNotNullParameter(r100, "cubeBroadcastReceiver");
        a r101 = new a(r100);
        f256537b.put(r100, r101);
        HostServiceUtilsKt.q().b(r101);
    }

    public final void b(fp6.h r100) {
        Intrinsics.checkNotNullParameter(r100, "cubeBroadcastReceiver");
        at6.a.InterfaceC0224a r101 = f256537b.remove(r100);
        if (r101 == null) goto L6;
        HostServiceUtilsKt.q().a(r101);
        return;
    }
}
