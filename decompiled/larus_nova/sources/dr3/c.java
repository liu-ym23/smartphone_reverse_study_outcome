package dr3;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends e<Unit, fr3.a.b, View> {
    public c(fr3.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(CollectionsKt.emptyList(), r100);
    }

    @Override // dr3.e
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new View(r100);
    }
}
