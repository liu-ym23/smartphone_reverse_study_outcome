package emb;

import cbb.d;
import com.bytedance.ee.bear.basesdk.apisupport.c;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o0;
import ebb.g;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import qa5.b;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements g {

    /* JADX INFO: renamed from: emb.a$a, reason: collision with other inner class name */
    public static final class C5792a {
    }

    static {
    }

    @Inject
    public a() {
    }

    @Override // ebb.g
    public final void b() {
    }

    @Override // ebb.g
    public final Biz getBiz() {
        return Biz.DOCS;
    }

    @Override // ebb.g
    public final cbb.a a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteConfig");
        if (o0.a(LarkContext.getApplication()) == false) goto L6;
        tt5.a.h("CCMDiskCleanTask", "CCMDiskCleanTask.onRemoteClean. ");
        return new cbb.a(false, ((c) b.a.f532259a.f532258a.f()).a(r100), 5);
    L6:
        return new cbb.a(false, 0, 7);
    }
}
