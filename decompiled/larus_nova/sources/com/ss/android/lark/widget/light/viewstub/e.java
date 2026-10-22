package com.ss.android.lark.widget.light.viewstub;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.widget.light.layout.TextLayoutViewHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f446338b;

    public e(Context r100) {
        this.f446338b = r100;
    }

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final View a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "stubSpan");
        return r100.b(this.f446338b);
    }

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        TextLayoutViewHelperKt.a(r100, r101);
    }
}
