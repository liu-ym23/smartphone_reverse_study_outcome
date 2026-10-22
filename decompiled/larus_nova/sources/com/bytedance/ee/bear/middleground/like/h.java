package com.bytedance.ee.bear.middleground.like;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import java.net.URI;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends BaseTitleBar.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ LikeListActivity f232808j;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r110) {
        LikeListActivity r111 = this.f232808j;
        String r100 = r111.f232723m;
        r111.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L15;
    L8:
        String r101 = null;
    L9:
        r111.f232723m = r101;
        if (TextUtils.isEmpty(this.f232808j.f232723m) == false) goto L13;
        tt5.a.h("LikeListActivity", "url is empty");
        return;
    L13:
        int r112 = p.f232814a;
        String r113 = this.f232808j.f232723m;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r113);
        return;
    L15:
        URI r102 = new URI(r100);     // Catch: Exception -> L7
        r101 = new URI(r102.getScheme(), r102.getAuthority(), r102.getPath(), null, r102.getFragment()).toString();     // Catch: Exception -> L7
    L7:
        tt5.a.d("LikeListActivity", "getUrlWithoutParameter fail");
        goto L8
    }

    public h(LikeListActivity r100, CharSequence r101) {
        this.f232808j = r100;
        super(r101, R.color.like_list_right_btn_color);
    }
}
