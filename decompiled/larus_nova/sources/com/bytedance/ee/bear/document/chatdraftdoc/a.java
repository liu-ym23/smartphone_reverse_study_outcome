package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.DocumentMeta;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.QueryResponse;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements k05.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f219191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f219193c;

    @Override // k05.c
    public final void a(QueryResponse r100) {
        m r101 = h.f219210b;
        if (r101 == null) goto L5;
        r101.f219218a.clear();
    L5:
        StringBuilder r102 = new StringBuilder("query draft doc done. exist: ");
        if (r100 == null) goto L8;
        Boolean r103 = Boolean.valueOf(r100.getExist());
    L9:
        r102.append(r103);
        r102.append(", documentMeta: ");
        if (r100 == null) goto L12;
        DocumentMeta r104 = r100.getMeta();
    L13:
        r102.append(r104);
        tt5.a.h("ChatDraftDocManager", r102.toString());
        if (r100 != null) goto L18;
        Toast.showFailureText(this.f219191a, R.string.LarkCCM_DocsInIM_SendToChat_NewDoc_Failed_Toast);
        return;
    L18:
        if (r100.getExist() == false) goto L26;
        Activity r105 = this.f219191a;
        String r106 = this.f219192b;
        DocumentMeta r107 = r100.getMeta();
        if (r107 == null) goto L22;
        String r108 = r107.getUrl();
    L23:
        if (r108 != null) goto L25;
        r108 = "";
    L25:
        Function0<Unit> r109 = this.f219193c;
        new UDDialogBuilder(r105).title(R.string.Lark_IM_Docs_NewDocs_ContinueEdit_Descrip).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_IM_Docs_NewDocs_ContinueEdit_Button, new f(r108, r106, r109)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Lark_IM_Docs_NewDocs_ContinueEdit_No_Button, new g(r105, r106, r109)).addActionButton(R.id.ud_dialog_btn_secondary2, R.string.Doc_Facade_Cancel, null).show();
        return;
    L22:
        r108 = null;
        goto L23
    L26:
        Activity r110 = this.f219191a;
        Toast.showLoading(r110, r110.getText(R.string.LarkCCM_DocsInIM_SendToChat_NewDocCreating_Toast));
        h.a(this.f219191a, this.f219192b, this.f219193c);
        return;
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    public a(FragmentActivity r100, String r101, Function0 r102) {
        this.f219191a = r100;
        this.f219192b = r101;
        this.f219193c = r102;
    }
}
