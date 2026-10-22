package ebb;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class i implements f {
    @Inject
    public i() {
    }

    @Override // ebb.f
    public final List<File> a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return CollectionsKt.emptyList();
    }

    @Override // ebb.f
    public final List<File> b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return CollectionsKt.emptyList();
    }
}
