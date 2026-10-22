package com.bytedance.android.shopping.store.router;

import android.content.Intent;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ShopEntranceCheckActivity a;

    public b(ShopEntranceCheckActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intent r4 = new Intent("android.intent.action.VIEW", UriProtector.parse("https://bytedance.larkoffice.com/docx/JEIqdXpdVotjvixkjIrcog0nn0g"));
        this.a.startActivity(r4, null);
        this.a.finish();
    }
}
