package y00;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livehostapi.TTLiveSDK;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f565560a;

    public a(Activity r100) {
        this.f565560a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Bundle r101 = new Bundle();
        r101.putString("fragment_type", "simple");
        TTLiveSDK.hostService().action().openLiveBrowser("https://webcast.amemv.com/falcon/webcast_douyin/page/anchor_agreement/index.html?type=fullscreen&title=&hide_more=0&hide_nav_bar=0&hide_status_bar=0&__live_platform__=webcast", r101, this.f565560a);
    }
}
