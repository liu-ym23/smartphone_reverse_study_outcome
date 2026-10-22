package nt1;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.dislike.layout.ShareFansItemLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareFansItemLayout f520475a;

    public e(ShareFansItemLayout r100) {
        this.f520475a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L6;
    L8:
        ShareFansItemLayout.a(this.f520475a, false, r100);
    L10:
        return false;
    L6:
        if (r102 == 3) goto L8;
    L9:
        ShareFansItemLayout.a(this.f520475a, true, r100);
        goto L10
    }
}
