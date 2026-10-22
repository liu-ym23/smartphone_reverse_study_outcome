package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.util.Base64;
import com.bytedance.ee.bear.contract.NetService;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T, R> implements Function {
    public final /* synthetic */ a a;

    public k(a r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        String r8 = (String) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        a r0 = this.a;
        String r1 = r0.b;
        NetService.f r2 = new NetService.f("/space/api/larkimport/create");
        JsonObject r3 = new JsonObject();
        r3.addProperty("message_token", Base64.encodeToString(r1.getBytes(Charsets.UTF_8), 2));     // Catch: Exception -> L5
        r3.addProperty("chat_token", r8);     // Catch: Exception -> L5
    L7:
        r2.j = r3.toString();
        r2.c = 1;
        return r0.a.Vc(new com.bytedance.ee.bear.drive.biz.importfile.im.entity.a()).a(r2).map(d.a).doOnNext(e.a);
    L5:
        e = move-exception;
        tt5.a.f("ImImportFileModel", e, false);
        goto L7
    }
}
