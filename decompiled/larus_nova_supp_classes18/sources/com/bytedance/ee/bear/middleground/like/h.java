package com.bytedance.ee.bear.middleground.like;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.net.URI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends BaseTitleBar.e {
    public final /* synthetic */ LikeListActivity j;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r10) {
        LikeListActivity r11 = this.j;
        String r0 = r11.m;
        r11.getClass();
        if (TextUtils.isEmpty(r0) == false) goto L15;
    L8:
        String r1 = null;
    L9:
        r11.m = r1;
        if (TextUtils.isEmpty(this.j.m) == false) goto L13;
        tt5.a.h("LikeListActivity", "url is empty");
        return;
    L13:
        int r12 = p.a;
        String r13 = this.j.m;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r13);
        return;
    L15:
        URI r2 = new URI(r0);     // Catch: Exception -> L7
        r1 = new URI(r2.getScheme(), r2.getAuthority(), r2.getPath(), null, r2.getFragment()).toString();     // Catch: Exception -> L7
    L7:
        tt5.a.d("LikeListActivity", "getUrlWithoutParameter fail");
        goto L8
    }

    public h(LikeListActivity r1, CharSequence r2) {
        this.j = r1;
        super(r2, 2131103350);
    }
}
