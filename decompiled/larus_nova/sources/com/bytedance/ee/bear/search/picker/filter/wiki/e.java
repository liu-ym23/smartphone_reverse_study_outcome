package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f236975a;

    public e(b r100) {
        this.f236975a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f236975a;
        if (r101.f236972o != 2) goto L5;
        return;
    L5:
        r101.getSearchTabWikiSpaceIndicatorFromXml().setVisibility(8);
        this.f236975a.getSearchTabFolderIndicatorFromXml().setVisibility(0);
        this.f236975a.getSearchTabDocIndicatorFromXml().setVisibility(8);
        this.f236975a.getSearchTabWikiSpaceFromXml().setTextColor(this.f236975a.getContext().getResources().getColor(R.color.text_caption));
        this.f236975a.getSearchTabFolderFromXml().setTextColor(this.f236975a.getContext().getResources().getColor(R.color.primary_pri_500));
        this.f236975a.getSearchTabDocFromXml().setTextColor(this.f236975a.getContext().getResources().getColor(R.color.text_caption));
        b r102 = this.f236975a;
        r102.f236972o = 2;
        com.bytedance.ee.bear.search.picker.filter.a r103 = r102.getListener();
        if (r103 == null) goto L9;
        r103.K30();
        return;
    }
}
