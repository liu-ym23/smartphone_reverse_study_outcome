package jw1;

import com.bytedance.android.livehostapi.business.depend.ad.IHostDislikeListener;
import com.bytedance.android.livesdk.feed.live.HotsoonLiveAdViewHolder;
import com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd;

/* JADX INFO: loaded from: classes8.dex */
public final class w implements IHostDislikeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HotsoonLiveAdViewHolder f500702a;

    public w(HotsoonLiveAdViewHolder r100) {
        this.f500702a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ad.IHostDislikeListener
    public final void onDislike(String r100, boolean r101) {
        if (r100.equals(((HotsoonAd) this.f500702a.f124144g.getItem()).getHostMixId()) == false) goto L6;
        HotsoonLiveAdViewHolder r102 = this.f500702a;
        r102.f124147j = true;
        r102.f124149l = r101;
        return;
    }
}
