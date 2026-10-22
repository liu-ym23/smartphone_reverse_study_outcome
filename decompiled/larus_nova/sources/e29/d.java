package e29;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f470843a = 0;

    static {
    }

    public static ICommunityHostBehaviorProvider c() {
        return (ICommunityHostBehaviorProvider) ServiceManager.get().getService(ICommunityHostBehaviorProvider.class);
    }

    public static e a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ICommunityHostBehaviorProvider r101 = c();
        if (r101 == null) goto L7;
        e r102 = r101.d(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new e(false, 0);
    }

    public static a b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ICommunityHostBehaviorProvider r101 = c();
        if (r101 == null) goto L7;
        a r102 = r101.p(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new a(0);
    }
}
