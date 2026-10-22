package ro1;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBannerWidget f538761a;

    public g(BaseBannerWidget r100) {
        this.f538761a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 == null) goto L6;
        this.f538761a.f115168g.onTouchEvent(r101);
        return false;
    L6:
        return false;
    }
}
