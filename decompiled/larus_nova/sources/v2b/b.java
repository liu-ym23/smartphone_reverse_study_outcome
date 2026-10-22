package v2b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.widget.light.layout.TextLayoutViewHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements com.ss.android.lark.widget.light.viewstub.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f552777b;

    public b(Context r100) {
        this.f552777b = r100;
    }

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final View a(com.ss.android.lark.widget.light.viewstub.h r100) {
        Intrinsics.checkNotNullParameter(r100, "stubSpan");
        return r100.b(this.f552777b);
    }

    @Override // com.ss.android.lark.widget.light.viewstub.f
    public final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        TextLayoutViewHelperKt.a(r100, r101);
    }
}
