package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        b r5 = this.a;
        if (r5.o != 0) goto L5;
        return;
    L5:
        r5.getSearchTabWikiSpaceIndicatorFromXml().setVisibility(0);
        this.a.getSearchTabDocIndicatorFromXml().setVisibility(8);
        this.a.getSearchTabFolderIndicatorFromXml().setVisibility(8);
        this.a.getSearchTabWikiSpaceFromXml().setTextColor(this.a.getContext().getResources().getColor(2131105568));
        this.a.getSearchTabDocFromXml().setTextColor(this.a.getContext().getResources().getColor(2131106607));
        this.a.getSearchTabFolderFromXml().setTextColor(this.a.getContext().getResources().getColor(2131106607));
        b r6 = this.a;
        r6.o = 0;
        com.bytedance.ee.bear.search.picker.filter.a r7 = r6.getListener();
        if (r7 == null) goto L9;
        r7.K30();
        return;
    }
}
