package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ UserInfo c;
    public final /* synthetic */ SearchUserResultAdapter.SearchUserViewHolder d;
    public final /* synthetic */ SearchUserResultAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        boolean r5 = !((ArrayList) this.e.e).contains(this.c);
        if (r5 == true) goto L5;
    L10:
        this.e.G2(this.d, this.c, r5);
        return;
    L5:
        if (this.c.getOwnerType() != 29) goto L10;
        if (this.e.F2() == false) goto L10;
        Context r6 = this.e.a;
        Toast.showFailureText(r6, xo5.a.c(r6, 2131889095, SheetInputData.InputData.FormatType.NUMBER, String.valueOf(10)));
    }

    public g(SearchUserResultAdapter r1, UserInfo r2, SearchUserResultAdapter.SearchUserViewHolder r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
