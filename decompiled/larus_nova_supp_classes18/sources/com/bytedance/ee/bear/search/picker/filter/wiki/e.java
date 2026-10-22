package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        b r6 = this.a;
        if (r6.o != 2) goto L5;
        return;
    L5:
        r6.getSearchTabWikiSpaceIndicatorFromXml().setVisibility(8);
        this.a.getSearchTabFolderIndicatorFromXml().setVisibility(0);
        this.a.getSearchTabDocIndicatorFromXml().setVisibility(8);
        this.a.getSearchTabWikiSpaceFromXml().setTextColor(this.a.getContext().getResources().getColor(2131106607));
        this.a.getSearchTabFolderFromXml().setTextColor(this.a.getContext().getResources().getColor(2131105568));
        this.a.getSearchTabDocFromXml().setTextColor(this.a.getContext().getResources().getColor(2131106607));
        b r7 = this.a;
        r7.o = 2;
        com.bytedance.ee.bear.search.picker.filter.a r8 = r7.getListener();
        if (r8 == null) goto L9;
        r8.K30();
        return;
    }
}
