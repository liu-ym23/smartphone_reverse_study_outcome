package jl9;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.larus.business.multitask_management.impl.view.u;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f499557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, Map<String, String>, Unit> f499558b;

    public final Context getContext() {
        Object r100 = this.f499557a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.content.Context");
        return (Context) r100;
    }

    public b(Context r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        this.f499557a = r100;
        this.f499558b = r101;
    }
}
