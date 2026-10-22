package s3c;

import android.view.View;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import v3c.g;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f540513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchColdAndHotInfo f540514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f540515c;

    public b(a r100, SearchColdAndHotInfo r101, int r102) {
        this.f540513a = r100;
        this.f540514b = r101;
        this.f540515c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = this.f540513a.f540512b;
        SearchColdAndHotInfo r102 = this.f540514b;
        r101.onItemClick(r102, r102.isSelected(), this.f540515c);
    }
}
