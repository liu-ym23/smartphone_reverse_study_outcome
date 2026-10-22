package rn;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends c<Unit, tn.a.b, View> {
    public b(tn.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(CollectionsKt.emptyList(), r100);
    }

    @Override // rn.c
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new View(r100);
    }
}
