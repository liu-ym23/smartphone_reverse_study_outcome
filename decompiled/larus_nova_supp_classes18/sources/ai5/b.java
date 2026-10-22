package ai5;

import by4.d;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a {
    public b() {
    }

    @Override // ai5.a
    public final boolean b() {
        int r0 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.all.web.co_avatar_switch");
        tt5.a.h("PermFGUtils", "showAvatar()...enable = " + r1);
        return r1;
    }

    @Override // ai5.a
    public final boolean a(String r3, vo5.a r4) {
        Intrinsics.checkNotNullParameter(r3, BenefitStore.FROM_SETTINGS);
        if (r4 == null) goto L10;
        d r5 = (d) r4.a(d.class);
        if (r5 == null) goto L11;
        com.ss.android.lark.storage.kv.repo.a r6 = r5.b("platform");
        if (r6 != null) goto L9;
        return false;
    L9:
        return r6.getBoolean(r3, false);
    L11:
        return false;
    L10:
        return false;
    }

    @Override // ai5.a
    public final void c(String r2, boolean r3, vo5.a r4) {
        Intrinsics.checkNotNullParameter(r2, BenefitStore.FROM_SETTINGS);
        if (r4 == null) goto L10;
        d r5 = (d) r4.a(d.class);
        if (r5 == null) goto L11;
        com.ss.android.lark.storage.kv.repo.a r6 = r5.b("platform");
        if (r6 == null) goto L12;
        r6.putBoolean(r2, r3);
        return;
    L12:
        return;
    L11:
        return;
    }
}
