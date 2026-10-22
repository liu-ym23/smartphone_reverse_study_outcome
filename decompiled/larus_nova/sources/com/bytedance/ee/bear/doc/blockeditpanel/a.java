package com.bytedance.ee.bear.doc.blockeditpanel;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BearUrl f217611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f217612b;

    public final void a(String r100) {
        if (this.f217612b != null) goto L5;
        return;
    L5:
        tt5.a.h("BlockEditPanelAnalytic", "report:".concat(r100));
        HashMap r101 = new HashMap();
        BearUrl r102 = this.f217611a;
        String r103 = "ERR";
        if (r102 != null) goto L9;
    L10:
        String r104 = "ERR";
    L12:
        r101.put("file_id", r104);
        BearUrl r105 = this.f217611a;
        if (r105 != null) goto L16;
    L19:
        r101.put("file_type", r103);
        r101.put(EventConstant.Key.MODULE, r103);
        r101.put("action_source", r100);
        tt5.a.b("BlockEditPanelAnalytic", "report param:" + r101);
        this.f217612b.v("ccm_block_close", r101);
        return;
    L16:
        if (TextUtils.isEmpty(r105.f222560a) == true) goto L19;
        r103 = this.f217611a.f222560a;
        goto L19
    L9:
        if (TextUtils.isEmpty(r102.f222561b) == true) goto L10;
        r104 = du5.b.g(this.f217611a.f222561b);
        goto L12
    }

    public a(BearUrl r100, d r101) {
        this.f217611a = r100;
        this.f217612b = r101;
    }
}
