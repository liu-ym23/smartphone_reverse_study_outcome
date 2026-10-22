package xib;

import android.view.View;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e<SearchBaseInfo> f564010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchBaseInfo f564011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f564012c;

    public d(e<SearchBaseInfo> r100, SearchBaseInfo r101, int r102) {
        this.f564010a = r100;
        this.f564011b = r101;
        this.f564012c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f564010a.f564014c.a(this.f564011b) == false) goto L6;
        return;
    L6:
        if (this.f564010a.f564006a == false) goto L8;
        SearchBaseInfo r101 = this.f564011b;
        r101.selected(true ^ r101.isSelected());
    L9:
        RecentForwardAdapterV3.b r102 = this.f564010a.f564013b;
        SearchBaseInfo r103 = this.f564011b;
        r102.a(r103, this.f564012c, r103.isSelected());
        return;
    L8:
        this.f564011b.selected(true);
        goto L9
    }
}
