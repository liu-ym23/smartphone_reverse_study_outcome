package uc5;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailListStyleAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ int c;
    public final /* synthetic */ Document d;
    public final /* synthetic */ FolderDetailListStyleAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        l3 r0 = this.e.o;
        if (r0 == null) goto L6;
        r0.u0(r5, this.c, this.d, false);
        return;
    }

    public o(FolderDetailListStyleAdapter r1, int r2, Document r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
