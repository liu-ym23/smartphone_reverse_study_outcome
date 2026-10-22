package com.bytedance.locallife.live.lynx.jsb;

import com.bytedance.keva.Keva;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j extends a {
    @Override // com.bytedance.locallife.live.lynx.jsb.a
    public final String a() {
        return "saveGenericKV";
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.jsb.a
    public final void d(HashMap<String, Object> r100, Function1<? super Map<String, ? extends Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = w.f(r100, "lynxSaveKey");
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        boolean r104 = false;
        if (r102.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        a.c("key isNullOrEmpty", r101);
    L11:
        String r106 = w.f(r100, "lynxSaveValue");
        if (r106 == null) goto L16;
        r103 = r106;
    L16:
        if (r103.length() != 0) goto L18;
        r104 = true;
    L18:
        if (r104 == false) goto L20;
        a.c("value isNullOrEmpty", r101);
    L20:
        Keva.getRepo("live_local_life").storeString(r102, r103);
        a.e(r101);
        return;
    L8:
        r105 = false;
        goto L9
    }
}
