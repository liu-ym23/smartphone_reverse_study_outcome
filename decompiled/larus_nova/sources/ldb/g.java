package ldb;

import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.EmergencyFixConfig;
import com.larksuite.framework.utils.j0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class g implements jdb.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public String f508883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jdb.d f508884b;

    @Inject
    public g(jdb.d r100) {
        Log.i("UserFeatureGatingService", "UserFeatureGatingService start");
        this.f508884b = r100;
        Log.i("UserFeatureGatingService", "UserFeatureGatingService finish");
        if (TextUtils.isEmpty(this.f508883a) == false) goto L5;
        Log.w("UserFeatureGatingService", "wtf, invalid uid within user-state-framework.");
        return;
    L5:
        Log.i("UserFeatureGatingService", "uid info:" + j0.a(this.f508883a));
    }

    @Override // jdb.g
    public final boolean isCurrentEnable(String r100) {
        Log.i("UserFeatureGatingService", "from UserFeatureGatingService.");
        return this.f508884b.x(this.f508883a, r100);
    }

    @Override // jdb.g
    public final boolean isEnable(String r100) {
        Log.i("UserFeatureGatingService", "from UserFeatureGatingService.");
        return this.f508884b.B0(this.f508883a, r100);
    }

    @Override // jdb.g
    public final void addFeatureGatingUpdateListener(String r100, jdb.c r101, String r102) {
        this.f508884b.T(this.f508883a, EmergencyFixConfig.SETTING_FG, r101, "_normal_fg");
    }
}
