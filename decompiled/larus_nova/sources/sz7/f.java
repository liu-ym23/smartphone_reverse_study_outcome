package sz7;

import android.content.Context;
import com.larksuite.component.ui.avatar.ImageKeyType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements b<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f543991a;

    public final Context getContext() {
        return this.f543991a;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f543991a = r100;
    }

    @Override // sz7.b
    public final void a(Context r100, g r101, a r102, c r103, x r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "avatarVO");
        Intrinsics.checkNotNullParameter(r103, "badgeVO");
        Intrinsics.checkNotNullParameter(r104, "miniIconVO");
        String r105 = r101.f543992a;
        if (r105 != null) goto L5;
    L7:
        r102.f543986e = null;
        return;
    L5:
        if (r101.f543993b != ImageKeyType.IMAGE) goto L7;
        r102.f543983b = r105;
        r102.f543984c = null;
        r102.f543987f = r101.f543994c;
        r102.f543988g = r101.f543995d;
        goto L7
    }
}
