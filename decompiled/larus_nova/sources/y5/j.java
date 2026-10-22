package y5;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ai.utils.l;
import com.bytedance.ai.utils.o;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements x5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletPopupSchemaParam f566201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f566202b;

    @Override // x5.a
    public final void invoke() {
        int r100 = this.f566201a.getRealWidth(this.f566202b.getContext());
        ViewGroup.LayoutParams r101 = this.f566202b.getLayoutParams();
        if (r100 <= 0) goto L5;
        r100 = RangesKt.coerceAtMost(r100, l.c(null));
    L10:
        r101.width = r100;
        return;
    L5:
        if (r100 != 0) goto L10;
        if (Intrinsics.areEqual(this.f566201a.getRealGravity(this.f566202b.getContext()), "center") == false) goto L9;
        int r102 = o.f37679a;
        r100 = o.b(this.f566202b.getContext(), 300.0d);
        goto L10
    L9:
        r100 = -1;
        goto L10
    }

    public j(AppletPopupSchemaParam r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f566201a = r100;
        this.f566202b = r101;
    }
}
