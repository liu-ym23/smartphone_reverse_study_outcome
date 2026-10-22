package com.ss.android.account.adapter;

import android.content.Context;
import com.bytedance.sdk.account.impl.BDAccountManagerAdapter;
import com.bytedance.sdk.account.platform.BaseAccountAdapter;
import com.bytedance.sdk.account.platform.CNInternetIdPlatformDelegate;
import com.bytedance.sdk.account.platform.DouyinPlatformDelegate;
import com.bytedance.sdk.account.platform.HotsoonPlatformDelegate;
import com.bytedance.sdk.account.platform.QQPlatformDelegate;
import com.bytedance.sdk.account.platform.TaptapPlatformDelegate;
import com.bytedance.sdk.account.platform.TouTiaoPlatformDelegate;
import com.bytedance.sdk.account.platform.WeiboPlatformDelegate;
import com.bytedance.sdk.account.platform.WeixinPlatformDelegate;
import com.bytedance.sdk.account.platform.XiguaPlatformDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import tb7.a;

/* JADX INFO: loaded from: classes5.dex */
public class InternalAccountAdapter {
    public InternalAccountAdapter() {
    }

    public static void init(Context r100) {
        BDAccountManagerAdapter.init();
        BaseAccountAdapter.delegateMap.put("weixin", new WeixinPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("qzone_sns", new QQPlatformDelegate.QQLoginFactor());
        BaseAccountAdapter.delegateMap.put("sina_weibo", new WeiboPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(ShareChannel.DOUYIN, new DouyinPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("toutiao", new TouTiaoPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("aweme_v2", new DouyinPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("toutiao_v2", new TouTiaoPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("taptap", new TaptapPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("live_stream", new HotsoonPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("video_article", new XiguaPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("cn_internet_id_auth", new CNInternetIdPlatformDelegate.Factory());
        a.a("InternalAccountAdapter", "call init");
    }
}
