package uc5;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailGridStyleAdapter;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f549544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Document f549545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FolderDetailGridStyleAdapter f549546e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        l3 r101 = this.f549546e.f227959h;
        if (r101 == null) goto L6;
        r101.u0(r100, this.f549544c, this.f549545d, true);
        return;
    }

    public n(FolderDetailGridStyleAdapter r100, int r101, Document r102) {
        this.f549546e = r100;
        this.f549544c = r101;
        this.f549545d = r102;
    }
}
