package com.ss.android.lark.framework.assembly.diskmanage;

import com.bytedance.lark.pb.basic.v1.TriggerDataCleanRequest;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import ebb.g;
import java.util.concurrent.CountDownLatch;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class e implements g {

    public static final class a {
    }

    static {
    }

    @Inject
    public e() {
    }

    @Override // ebb.g
    public final void b() {
    }

    @Override // ebb.g
    public final Biz getBiz() {
        return Biz.RUST;
    }

    @Override // ebb.g
    public final cbb.a a(cbb.d r110) {
        Intrinsics.checkNotNullParameter(r110, "remoteConfig");
        int r100 = 0;
        final cbb.a r101 = new cbb.a(false, 0, 7);
    L4:
        if (r100 >= 3) goto L9;
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        final CountDownLatch r103 = new CountDownLatch(1);
        cbb.c r104 = r110.f23126a;
        int r105 = (int) r104.f23124e;
        int r106 = (int) r104.f23122c;
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).triggerDataClean(Integer.valueOf(r105), Integer.valueOf(r106), TriggerDataCleanRequest.CleanType.AUTO, new RustCleanTask$performRemoteClean$1(r101, r103, r102));
        r103.await();
        if (r102.element == false) goto L8;
        Log.i("RustCleanTask", "retry perform remote clean");
        r100 = r100 + 1;
        goto L4
    L8:
        Log.i("RustCleanTask", "finish remote clean");
    L9:
        return r101;
    }
}
