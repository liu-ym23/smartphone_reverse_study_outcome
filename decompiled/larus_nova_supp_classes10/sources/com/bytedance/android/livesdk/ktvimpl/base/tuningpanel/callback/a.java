package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvModeTuningDataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends KSongViceSingerTuningButtonOuterCallback {
    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongViceSingerTuningButtonOuterCallback
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f() {
        KtvModeTuningDataContext.Companion.getClass();
        return KtvModeTuningDataContext.b.a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongViceSingerTuningButtonOuterCallback
    public final boolean g() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = f();
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.h() != true) goto L10;
        return false;
    L10:
        return true;
    }

    public a() {
    }
}
