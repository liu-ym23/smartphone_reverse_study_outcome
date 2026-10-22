package com.xiaomi.push;

import android.content.Context;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes41.dex */
public class dl extends dk {
    @Override // com.xiaomi.push.ad.a
    /* JADX INFO: renamed from: a */
    public String mo8851a() {
        return Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR;
    }

    @Override // com.xiaomi.push.dk
    public String b() {
        return "ram:" + i.m9282a() + ",rom:" + i.m9287b() + "|ramOriginal:" + i.c() + ",romOriginal:" + i.d();
    }

    @Override // com.xiaomi.push.dk
    public gg a() {
        return gg.f463696w;
    }

    public dl(Context r100, int r101) {
        super(r100, r101);
    }
}
