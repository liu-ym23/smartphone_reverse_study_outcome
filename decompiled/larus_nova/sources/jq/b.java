package jq;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.c;
import com.bytedance.android.ecom.arch.slice.action.d;
import com.bytedance.android.ecom.arch.slice.action.e;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends e<a> {
    public b() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final d<a> checkParam(SlcCommonAction r100, Map<String, ? extends Object> r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        int r103 = a.f500015a;
        a r104 = a.C6473a.a(r101);
        if (r104 == null) goto L5;
        String r105 = r104.f();
    L6:
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L15;
        int r107 = d.f49983d;
        return d.a.a("event name is nil");
    L15:
        int r108 = d.f49983d;
        return d.a.b(r104);
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final void onHandle(ActionContext r100, SlcCommonAction r101, a r102, c r103) {
        a r104 = r102;
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r104 == null) goto L20;
        View r105 = null;
        if (r103 == null) goto L8;
        Map<String, Object> r106 = r103.f49981b;
    L10:
        if (r106 == null) goto L12;
        int r107 = r106.size();
    L13:
        HashMap r108 = new HashMap(r107 + 2);
        if (r106 == null) goto L16;
        r108.putAll(r106);
    L16:
        if (r103 == null) goto L18;
        r105 = r103.f49980a;
    L18:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "logData");
        r100.f49972g.a(r104, r108, r105);
        return;
    L12:
        r107 = 0;
        goto L13
    L8:
        r106 = null;
        goto L10
    }
}
