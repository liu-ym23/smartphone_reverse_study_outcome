package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final /* synthetic */ class nj implements Function0 {
    public final /* synthetic */ int a;

    public /* synthetic */ nj(int r1) {
        this.a = r1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int r0 = this.a;
        Integer r1 = Integer.valueOf(((INovaSetting) SettingsManager.obtain(INovaSetting.class)).maxALogDirSizeMb());
        if (r1.intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L12;
        r0 = r1.intValue();
    L12:
        return Integer.valueOf(r0);
    L5:
        r2 = false;
        goto L6
    }
}
