package com.larus.office.base;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class f0 implements etb.d {
    public f0() {
    }

    @Override // etb.d
    public final boolean isEnable() {
        boolean r100 = com.larus.platform.exp.i.f365385a.a();
        FLogger.f375446a.i("OfficeSdkInitor", "Enable new drive list is " + r100);
        return r100;
    }
}
