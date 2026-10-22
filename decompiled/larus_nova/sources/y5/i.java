package y5;

import android.view.View;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements x5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletPopupSchemaParam f566199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f566200b;

    @Override // x5.a
    public final void invoke() {
        if (this.f566199a.getShowMask() == false) goto L5;
        this.f566200b.setVisibility(0);
        this.f566200b.setAlpha(1.0f);
        return;
    L5:
        this.f566200b.setVisibility(0);
        this.f566200b.setAlpha(0.0f);
    }

    public i(AppletPopupSchemaParam r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f566199a = r100;
        this.f566200b = r101;
    }
}
