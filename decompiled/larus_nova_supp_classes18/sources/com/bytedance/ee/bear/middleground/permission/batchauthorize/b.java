package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.AuthorizeStateNode;
import com.bytedance.ee.bear.middleground.permission.c;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import lg5.l;
import lg5.m;
import lg5.n;
import lg5.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public b(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r20) {
        AuthorizeStateNode.BatchAuthorizeState r1 = ((AuthorizeStateNode) this.a.i.getStateData().getValue()).getState();
        if (this.a.i.getInfo().getChatType() != 0) goto L5;
        final boolean r2 = true;
    L6:
        int r3 = BatchAuthorizeActivity.a.a[r1.ordinal()];
        if (r3 != 2) goto L9;
        final int r4 = this.a.i.getHasPermissionResultSize(Boolean.FALSE);
        if (r2 == false) goto L19;
        int r5 = 2131889471;
    L20:
        BatchAuthorizeActivity.C1(this.a, 2131889469, r5, new l(this, r4, r2), new m(r4, r2));
        c.o(false, r4, r2);
        JSONObject r6 = new JSONObject();
        String r10 = c.f;
        int r11 = c.g;
        if (c.c == false) goto L23;
        String r12 = ThumbGlideUrl.SOURCE_VC;
    L24:
        c.a(r6, r10, r11, r12, c.h, c.d, c.e, c.a, c.b, c.i);
        r6.put("click", "all_authorize");
        r6.put("target", "none");
        c.c("ccm_permission_cited_doc_authorize_click", r6);
        return;
    L23:
        r12 = "none";
        goto L24
    L19:
        r5 = 2131889470;
        goto L20
    L9:
        if (r3 != 3) goto L27;
        final int r7 = this.a.i.getHasPermissionResultSize(Boolean.TRUE);
        if (r2 == false) goto L14;
        int r8 = 2131887193;
    L15:
        BatchAuthorizeActivity.C1(this.a, 2131887194, r8, new n(this, r7, r2), new o(r7, r2));
        c.o(true, r7, r2);
        c.m();
        return;
    L14:
        r8 = 2131887192;
        goto L15
    L27:
        return;
    L5:
        r2 = false;
        goto L6
    }
}
