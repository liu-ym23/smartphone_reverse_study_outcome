package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.DocumentMeta;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.QueryResponse;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements k05.c {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // k05.c
    public final void a(QueryResponse r8) {
        m r0 = h.b;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        StringBuilder r1 = new StringBuilder("query draft doc done. exist: ");
        if (r8 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r8.getExist());
    L9:
        r1.append(r2);
        r1.append(", documentMeta: ");
        if (r8 == null) goto L12;
        DocumentMeta r3 = r8.getMeta();
    L13:
        r1.append(r3);
        tt5.a.h("ChatDraftDocManager", r1.toString());
        if (r8 != null) goto L18;
        Toast.showFailureText(this.a, 2131888930);
        return;
    L18:
        if (r8.getExist() == false) goto L26;
        Activity r4 = this.a;
        String r5 = this.b;
        DocumentMeta r9 = r8.getMeta();
        if (r9 == null) goto L22;
        String r10 = r9.getUrl();
    L23:
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        Function0<Unit> r6 = this.c;
        new UDDialogBuilder(r4).title(2131891055).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL).addActionButton(2131391777, 2131891054, new f(r10, r5, r6)).addActionButton(2131391778, 2131891056, new g(r4, r5, r6)).addActionButton(2131391779, 2131887716, null).show();
        return;
    L22:
        r10 = null;
        goto L23
    L26:
        Activity r11 = this.a;
        Toast.showLoading(r11, r11.getText(2131888929));
        h.a(this.a, this.b, this.c);
        return;
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public a(FragmentActivity r1, String r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
