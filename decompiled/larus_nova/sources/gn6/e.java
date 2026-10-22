package gn6;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.etkit.TrackModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements hn6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f481813a;

    public e() {
        fn6.c r100 = fn6.b.f477930a;
        fn6.c r101 = fn6.b.f477930a;
        if (r101 == null) goto L6;
        List<String> r102 = r101.c();
        if (r102 == null) goto L6;
    L7:
        this.f481813a = r102;
        return;
    L6:
        r102 = new ArrayList();
        goto L7
    }

    @Override // hn6.e
    public final boolean a(TrackModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return this.f481813a.contains(r100.f450807a);
    }
}
