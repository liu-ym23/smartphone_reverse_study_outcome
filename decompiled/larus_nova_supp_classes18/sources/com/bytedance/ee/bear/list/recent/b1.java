package com.bytedance.ee.bear.list.recent;

import android.content.DialogInterface;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ a1.a a;
    public final /* synthetic */ Document b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public b1(a1.a r1, Document r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = "recent";
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r9, int r10) {
        this.a.c2(this.b);
        lc5.f.a r11 = lc5.f.a;
        String r0 = this.c;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r1 = r0;
        String r2 = this.d;
        Document r3 = this.b;
        r11.S(new lc5.v(r1, r2, r3.d, r3.getType(), this.b.F, "remove", "ccm_space_home_page_view"));
    }
}
