package com.ss.android.lark.search.doubao.chat.holder.msg;

import android.view.View;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f440081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchMessageInfo f440082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f440083c;

    public b(a r100, SearchMessageInfo r101, int r102) {
        this.f440081a = r100;
        this.f440082b = r101;
        this.f440083c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f440081a.f440080a.f440246c.onItemClick(this.f440082b, false, this.f440083c);
    }
}
