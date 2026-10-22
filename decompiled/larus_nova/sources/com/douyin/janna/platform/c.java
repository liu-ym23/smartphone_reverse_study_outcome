package com.douyin.janna.platform;

import android.content.Context;
import com.douyin.janna.api.CapabilityType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends a {
    public c(Context r100) {
        super(r100);
        Set<CapabilityType> r101 = this.f273605h;
        HashSet r102 = (HashSet) r101;
        r102.add(CapabilityType.SET_REFRESH_RATE);
        this.f273600c = true;
        g(new fs7.a(0, null));
        boolean r103 = hq7.a.f486512a;
    }
}
