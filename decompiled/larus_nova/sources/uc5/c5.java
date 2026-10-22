package uc5;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public final class c5 extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.list.folder.i f549484c;

    public c5(com.bytedance.ee.bear.list.folder.i r100) {
        this.f549484c = r100;
        super(400);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        com.bytedance.ee.bear.list.folder.i r101 = this.f549484c;
        Document r102 = r101.V;
        if (r102 == null) goto L6;
        r101.Y(r100, -99, r102, true);
        return;
    }
}
