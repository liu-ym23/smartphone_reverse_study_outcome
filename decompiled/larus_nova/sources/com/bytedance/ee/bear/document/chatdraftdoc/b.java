package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.DocumentMeta;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements k05.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f219194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f219195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f219196c;

    @Override // k05.a
    public final void a(CreateResponse r100) {
        i r101 = h.f219209a;
        if (r101 == null) goto L5;
        r101.f219212a.clear();
    L5:
        if (r100 == null) goto L9;
        DocumentMeta r102 = r100.getMeta();
        if (r102 == null) goto L9;
        String r103 = r102.getUrl();
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        StringBuilder r104 = new StringBuilder("create draft doc done. chatId: ");
        r104.append(this.f219194a);
        r104.append(", url: ");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Any");
        r104.append(du5.b.f(r103));
        tt5.a.h("ChatDraftDocManager", r104.toString());
        Toast.cancelLoading();
        boolean r105 = false;
        if (r103.length() <= 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L18;
        String r107 = this.f219194a;
        com.bytedance.ee.util.ui.j.f(new d(this.f219195b));
        com.bytedance.ee.util.ui.j.d(new e(r107, r103), 250);
        return;
    L18:
        if (r100 != null) goto L20;
    L22:
        if (r105 == true) goto L26;
        Toast.showFailureText(this.f219196c, R.string.LarkCCM_DocsInIM_SendToChat_NewDoc_Failed_Toast);
        return;
    L26:
        return;
    L20:
        if (r100.getFullQuote() != true) goto L22;
        r105 = true;
        goto L22
    L15:
        r106 = false;
    L9:
        r103 = null;
        goto L10
    }

    public b(String r100, Function0<Unit> r101, Activity r102) {
        this.f219194a = r100;
        this.f219195b = r101;
        this.f219196c = r102;
    }
}
