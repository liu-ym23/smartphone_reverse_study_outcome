package ytb;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class r implements a4c.a, a4c.b, b4c.a, b4c.b, b4c.c {
    @Override // b4c.a
    public final void a() {
        Intrinsics.checkNotNullParameter("lark.search.time.trouble.shoot", "key");
    }

    @Override // a4c.a
    public final void b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "query");
    }

    @Override // b4c.a
    public final void isEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
    }

    @Override // b4c.c
    public final KVRepo d() {
        return (KVRepo) t.a(KVRepo.class);
    }

    @Inject
    public r() {
        new MutableLiveData();
    }

    @Override // b4c.b
    public final VFSPath c(com.ss.android.lark.storage.f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ITTVideoEngineEventSource.KEY_VOLUME);
        Intrinsics.checkNotNullParameter(r101, "fileName");
        return (VFSPath) t.a(VFSPath.class);
    }
}
