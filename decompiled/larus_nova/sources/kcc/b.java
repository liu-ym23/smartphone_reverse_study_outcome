package kcc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.viewstub.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f502692a;

    public b(a r100) {
        this.f502692a = r100;
    }

    @Override // com.ss.android.lark.widget.light.viewstub.h
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f502692a.a(r100);
    }

    @Override // com.ss.android.lark.widget.light.viewstub.h
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = this.f502692a.b(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return r101;
    }
}
