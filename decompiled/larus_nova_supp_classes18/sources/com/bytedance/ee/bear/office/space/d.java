package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.adapter.i0;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ OfficeSpaceFragment a;

    public d(OfficeSpaceFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        OfficeSpaceFragment r5 = this.a;
        int r0 = OfficeSpaceFragment.v;
        OfficeSpaceTab r6 = r5.W90();
        if (r6 == null) goto L5;
        i0.a.g(r6, ThumbGlideUrl.SOURCE_SEARCH, null);
    L5:
        OfficeSpaceFragment.S90(this.a, OfficeSpaceHeaderAction.SEARCH);
    }
}
