package kt6;

import android.text.TextUtils;
import com.larus.api.LocationService;
import com.larus.platform.model.GeoLocationInfo;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends com.bytedance.locallife.adapter.impl.host.location.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f506050a = null;

    static {
        f506050a = new a();
    }

    @Override // com.bytedance.locallife.adapter.impl.host.location.d, kt6.f
    public final String d() {
        GeoLocationInfo r100 = LocationService.f286873a.m();
        if (r100 == null) goto L6;
        String r101 = r100.getCity();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.locallife.adapter.impl.host.location.d, kt6.f
    public final String e() {
        GeoLocationInfo r100 = LocationService.f286873a.m();
        if (r100 == null) goto L6;
        String r101 = r100.getCityCode();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public a() {
    }

    @Override // com.bytedance.locallife.adapter.impl.host.location.d, kt6.f
    public final boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        return StringsKt.equals$default(r100, e(), false, 2, null);
    }

    @Override // com.bytedance.locallife.adapter.impl.host.location.d, kt6.f
    public final String c(NearbyPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        GeoLocationInfo r101 = LocationService.f286873a.m();
        if (r101 == null) goto L6;
        String r102 = r101.getCityCode();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }
}
