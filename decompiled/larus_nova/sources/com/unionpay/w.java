package com.unionpay;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class w implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462202a;

    public w(UPPayWapActivity r100) {
        this.f462202a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L10
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L10
    L5:
        if (r103.hasNext() == false) goto L7;
        String r104 = r103.next();     // Catch: Exception -> L10
        UPUtils.d(this.f462202a, JSONObjectProtectorUtils.getString(r102, r104), r104);     // Catch: Exception -> L10
        goto L5
    L7:
        if (r101 == null) goto L17;
        r101.a(UPPayWapActivity.b("0", "success", null));     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        if (r101 == null) goto L18;
        r101.a(UPPayWapActivity.b("1", e.getMessage(), null));
        return;
    }
}
