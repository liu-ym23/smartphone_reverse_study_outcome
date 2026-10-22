package vwa;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements b {

    /* JADX INFO: renamed from: vwa.a$a, reason: collision with other inner class name */
    public static final class C8046a {
    }

    static {
    }

    public a() {
    }

    @Override // vwa.b
    public final void a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        g r101 = f.b(r100);
        DesktopCompatFragment r102 = null;
        if (r101 == null) goto L6;
        r101.g(null);
        return;
    L6:
        if ((r100 instanceof DesktopCompatFragment) == false) goto L8;
        r102 = (DesktopCompatFragment) r100;
    L8:
        if (r102 == null) goto L12;
        r102.finish();
        return;
    }
}
