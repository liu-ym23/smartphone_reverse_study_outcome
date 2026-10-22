package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f219206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f219208c;

    public g(Activity r100, String r101, Function0<Unit> r102) {
        this.f219206a = r100;
        this.f219207b = r101;
        this.f219208c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        i r102 = h.f219209a;
        Activity r103 = this.f219206a;
        String r104 = this.f219207b;
        Function0<Unit> r105 = this.f219208c;
        Toast.showLoading(r103, r103.getText(R.string.LarkCCM_DocsInIM_SendToChat_NewDocCreating_Toast));
        NetService r106 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        l r107 = h.f219211c;
        if (r107 != null) goto L5;
        r107 = new l();
        h.f219211c = r107;
    L5:
        r107.a(r106, r104, new c(r103, r104, r105));
    }
}
