package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements k05.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f219197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f219199c;

    @Override // k05.b
    public final void a(int r100) {
        l r101 = h.f219211c;
        if (r101 == null) goto L5;
        r101.f219215a.clear();
    L5:
        tt5.a.h("ChatDraftDocManager", "delete draft doc done. code: " + r100);
        if (r100 != 0) goto L8;
        h.a(this.f219197a, this.f219198b, this.f219199c);
        return;
    L8:
        Toast.cancelLoading();
        Toast.showFailureText(this.f219197a, R.string.LarkCCM_DocsInIM_SendToChat_NewDoc_Failed_Toast);
    }

    public c(Activity r100, String r101, Function0<Unit> r102) {
        this.f219197a = r100;
        this.f219198b = r101;
        this.f219199c = r102;
    }
}
