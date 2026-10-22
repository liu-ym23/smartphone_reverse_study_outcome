package f6;

import com.bytedance.android.scope.j;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements WidgetManager.IWidgetConfigHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f475664a;

    public e(j r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f475664a = r100;
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager.IWidgetConfigHandler
    public final void onDestroy(Widget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        boolean r101 = r100 instanceof b;
        Object r102 = r100;
        if (r101 == true) goto L5;
        r102 = null;
    L5:
        b r103 = (b) r102;
        if (r103 == null) goto L9;
        r103.hp(null);
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager.IWidgetConfigHandler
    public final void onLoad(Widget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        boolean r101 = r100 instanceof b;
        Object r102 = r100;
        if (r101 == true) goto L5;
        r102 = null;
    L5:
        b r103 = (b) r102;
        if (r103 == null) goto L9;
        r103.hp(this.f475664a);
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.WidgetManager.IWidgetConfigHandler
    public final void onUnload(Widget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        boolean r101 = r100 instanceof b;
        Object r102 = r100;
        if (r101 == true) goto L5;
        r102 = null;
    L5:
        b r103 = (b) r102;
        if (r103 == null) goto L9;
        r103.hp(null);
        return;
    }
}
