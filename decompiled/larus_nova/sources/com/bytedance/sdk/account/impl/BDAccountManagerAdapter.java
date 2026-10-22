package com.bytedance.sdk.account.impl;

import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class BDAccountManagerAdapter {
    private static volatile boolean hadInit;

    public BDAccountManagerAdapter() {
    }

    public static void init() {
        if (hadInit == false) goto L6;
        return;
    L6:
        monitor-enter(BDAccountManagerAdapter.class);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (hadInit == false) goto L11;
        monitor-exit(BDAccountManagerAdapter.class);     // Catch: Throwable -> L14
        return;
    L11:
        ArrayList r100 = new ArrayList(Arrays.asList(j.f269009h1));     // Catch: Throwable -> L14
        r100.add(new cra.a("weixin"));     // Catch: Throwable -> L14
        r100.add(new cra.a(RomUtils.BRAND_HUAWEI));     // Catch: Throwable -> L14
        r100.add(new cra.a(DimLocationCheckUtil.XIAOMI));     // Catch: Throwable -> L14
        r100.add(new cra.a("flyme"));     // Catch: Throwable -> L14
        r100.add(new cra.a("qq_weibo"));     // Catch: Throwable -> L14
        r100.add(new cra.a("sina_weibo"));     // Catch: Throwable -> L14
        r100.add(new cra.a("qzone_sns"));     // Catch: Throwable -> L14
        r100.add(new cra.a("toutiao"));     // Catch: Throwable -> L14
        r100.add(new cra.a("toutiao_v2"));     // Catch: Throwable -> L14
        r100.add(new cra.a(ShareChannel.DOUYIN));     // Catch: Throwable -> L14
        r100.add(new cra.a("aweme_v2"));     // Catch: Throwable -> L14
        r100.add(new cra.a("live_stream"));     // Catch: Throwable -> L14
        r100.add(new cra.a(OnekeyLoginConstants.TELECOM));     // Catch: Throwable -> L14
        r100.add(new cra.a("renren_sns"));     // Catch: Throwable -> L14
        r100.add(new cra.a("kaixin_sns"));     // Catch: Throwable -> L14
        r100.add(new cra.a("flipchat"));     // Catch: Throwable -> L14
        r100.add(new cra.a("gogokid"));     // Catch: Throwable -> L14
        r100.add(new cra.a("cn_internet_id_auth"));     // Catch: Throwable -> L14
        j.f269009h1 = (cra.a[]) r100.toArray(new cra.a[0]);     // Catch: Throwable -> L14
        hadInit = true;     // Catch: Throwable -> L14
        monitor-exit(BDAccountManagerAdapter.class);     // Catch: Throwable -> L14
    }
}
