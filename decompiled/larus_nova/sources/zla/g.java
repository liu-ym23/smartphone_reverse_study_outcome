package zla;

import android.content.Context;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<f, Unit> f572821a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function1<? super f, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        this.f572821a = r100;
    }

    @Override // zla.h
    public final void b(AbstractDialog r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    @Override // zla.h
    public final void c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        h.a.a(this, r100);
    }

    @Override // zla.h
    public final void a(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dialogContainer");
        this.f572821a.invoke(r101);
    }
}
