package uc5;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailListStyleAdapter;

/* JADX INFO: loaded from: classes18.dex */
public final class o extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f549558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Document f549559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FolderDetailListStyleAdapter f549560e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        l3 r101 = this.f549560e.f227967o;
        if (r101 == null) goto L6;
        r101.u0(r100, this.f549558c, this.f549559d, false);
        return;
    }

    public o(FolderDetailListStyleAdapter r100, int r101, Document r102) {
        this.f549560e = r100;
        this.f549558c = r101;
        this.f549559d = r102;
    }
}
