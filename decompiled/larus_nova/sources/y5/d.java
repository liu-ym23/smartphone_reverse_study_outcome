package y5;

import android.view.View;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements x5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletPopupSchemaParam f566186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f566187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f566188c;

    @Override // x5.a
    public final void invoke() {
        if (this.f566186a.getDisableOutsideClickClose() == true) goto L6;
        this.f566187b.setOnClickListener(new c(this));
        return;
    }

    public d(AppletPopupSchemaParam r100, View r101, com.bytedance.ai.view.popup.e r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f566186a = r100;
        this.f566187b = r101;
        this.f566188c = r102;
    }
}
