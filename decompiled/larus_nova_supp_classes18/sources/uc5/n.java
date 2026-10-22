package uc5;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderDetailGridStyleAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ int c;
    public final /* synthetic */ Document d;
    public final /* synthetic */ FolderDetailGridStyleAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        l3 r0 = this.e.h;
        if (r0 == null) goto L6;
        r0.u0(r5, this.c, this.d, true);
        return;
    }

    public n(FolderDetailGridStyleAdapter r1, int r2, Document r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
