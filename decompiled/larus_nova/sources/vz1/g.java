package vz1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.larus.nova.R;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DiamondConfig f557677a;

    public static final String a(Long r100, boolean r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DiamondConfig r102 = f557677a;
        if (r102 != null) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.config.j r103 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r104 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.f126567d.getClass();
        r102 = (DiamondConfig) r103.c(r104, DiamondConfig.a.a());
    L9:
        if (nz1.a.k().a() == false) goto L15;
        if (r100.longValue() <= nz1.a.k().b()) goto L15;
        if (r101 == false) goto L15;
        return String.valueOf(nz1.a.k().b()) + " " + r102.f126569b + Marker.ANY_NON_NULL_MARKER;
    L15:
        if (r100.longValue() <= 0) goto L18;
        return String.valueOf(r100.longValue()) + " " + r102.f126569b;
    L18:
        return s1.B(R.string.ttlive_live_free);
    }
}
