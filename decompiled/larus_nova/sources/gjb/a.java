package gjb;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.videosend.tools.l;
import ebb.e;
import ebb.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements f {
    @Inject
    public a() {
    }

    @Override // ebb.f
    public final List<File> a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r101 = new ArrayList();
        Object r102 = e.f471981a;
        e.c(wkb.b.a().getRealPath(), 15);
        e.c(l.a(r100).getRealPath(), 15);
        return r101;
    }

    @Override // ebb.f
    public final List<File> b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return CollectionsKt.emptyList();
    }
}
