package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f236974a;

    public d(b r100) {
        this.f236974a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f236974a;
        if (r101.f236972o != 1) goto L5;
        return;
    L5:
        r101.getSearchTabWikiSpaceIndicatorFromXml().setVisibility(8);
        this.f236974a.getSearchTabFolderIndicatorFromXml().setVisibility(8);
        this.f236974a.getSearchTabDocIndicatorFromXml().setVisibility(0);
        this.f236974a.getSearchTabWikiSpaceFromXml().setTextColor(this.f236974a.getContext().getResources().getColor(R.color.text_caption));
        this.f236974a.getSearchTabFolderFromXml().setTextColor(this.f236974a.getContext().getResources().getColor(R.color.text_caption));
        this.f236974a.getSearchTabDocFromXml().setTextColor(this.f236974a.getContext().getResources().getColor(R.color.primary_pri_500));
        b r102 = this.f236974a;
        r102.f236972o = 1;
        com.bytedance.ee.bear.search.picker.filter.a r103 = r102.getListener();
        if (r103 == null) goto L9;
        r103.K30();
        return;
    }
}
