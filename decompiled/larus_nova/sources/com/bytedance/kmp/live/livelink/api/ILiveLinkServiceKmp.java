package com.bytedance.kmp.live.livelink.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.utility.ServiceLookup;
import ec6.a;
import ec6.b;
import hh1.v0;
import kotlin.Metadata;
import uf2.d0;

/* JADX INFO: loaded from: classes19.dex */
@ServiceLookup("com.bytedance.android.live.livelink.LiveLinkServiceKmp")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/ILiveLinkServiceKmp;", "Lcom/bytedance/android/live/base/IService;", "Lhh1/v0;", "factory", "Luf2/d0;", "liveCore", "Lec6/a;", "wrapLiveVideoClientFactory", "iLiveAVClientFactory", "unWrapLiveVideoClientFactory", "Lec6/b;", "bizLiveAVClient", "Lcom/bytedance/android/live/pushstream/d;", "unWrapBizLiveAVClient", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILiveLinkServiceKmp extends IService {
    d unWrapBizLiveAVClient(b r100);

    v0 unWrapLiveVideoClientFactory(a r100);

    a wrapLiveVideoClientFactory(v0 r100, d0 r101);
}
