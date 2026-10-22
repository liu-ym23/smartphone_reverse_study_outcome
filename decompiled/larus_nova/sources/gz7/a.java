package gz7;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larksuite.component.card.plugin.ShowDatePickerPlugin;
import com.larksuite.component.card.utils.UniversalCardHostInfoManager;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UniversalCardHostInfoManager f483413a;

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        UniversalCardHostInfoManager r100 = this.f483413a;
        if (r100 == null) goto L15;
        r100.f283955e.clear();
        Activity r101 = UIUtils.getActivityFromContext(r100.f283951a);
        if (r101 == null) goto L19;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L16;
        View r103 = UniversalCardHostInfoManager.a(r102);
        if (r103 == null) goto L17;
        ViewTreeObserver r104 = r103.getViewTreeObserver();
        if (r104 == null) goto L18;
        r104.removeOnGlobalLayoutListener(r100.f283954d);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L19:
        return;
    }

    @Override // gz7.c
    public final void init() {
        UniversalCardHostInfoManager r100 = this.f483413a;
        if (r100 == null) goto L15;
        Activity r101 = UIUtils.getActivityFromContext(r100.f283951a);
        if (r101 == null) goto L19;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L16;
        View r103 = UniversalCardHostInfoManager.a(r102);
        if (r103 == null) goto L17;
        ViewTreeObserver r104 = r103.getViewTreeObserver();
        if (r104 == null) goto L18;
        r104.addOnGlobalLayoutListener(r100.f283954d);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L19:
        return;
    }

    public a(com.larksuite.component.card.service.b r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceContext");
        ILarkLynxContainer r101 = r100.f283930b;
        if (r101 == null) goto L5;
        UniversalCardHostInfoManager r102 = new UniversalCardHostInfoManager(r101.getLynxView().getContext(), r101);
    L6:
        this.f483413a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // gz7.c
    public final void a(ShowDatePickerPlugin.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        UniversalCardHostInfoManager r101 = this.f483413a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "observer");
        r101.f283955e.remove(r100);
        return;
    }

    @Override // gz7.c
    public final void h(ShowDatePickerPlugin.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        UniversalCardHostInfoManager r101 = this.f483413a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "observer");
        r101.f283955e.add(r100);
        return;
    }
}
