package uc5;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c5 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ com.bytedance.ee.bear.list.folder.i c;

    public c5(com.bytedance.ee.bear.list.folder.i r3) {
        this.c = r3;
        super(400);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        com.bytedance.ee.bear.list.folder.i r0 = this.c;
        Document r1 = r0.V;
        if (r1 == null) goto L6;
        r0.Y(r5, -99, r1, true);
        return;
    }
}
