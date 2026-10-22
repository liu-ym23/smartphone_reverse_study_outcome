package dr2;

import com.bytedance.android.livesdk.config.LiveSettingKeys;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements a {
    public l() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.a
    public final String vl() {
        return LiveSettingKeys.LIVE_DIAMOND_EXCHANGE_URL.getValue();
    }

    @Override // dr2.a
    public final boolean wc() {
        return LiveSettingKeys.LIVE_SAAS_DIAMOND_EXCHANGE_ENABLE.getValue().booleanValue();
    }
}
