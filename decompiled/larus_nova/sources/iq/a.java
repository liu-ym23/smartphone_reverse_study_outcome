package iq;

import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.c;
import com.bytedance.android.ecom.arch.slice.action.d;
import com.bytedance.android.ecom.arch.slice.action.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends e<b> {
    public a() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final d<b> checkParam(SlcCommonAction r100, Map<String, ? extends Object> r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Object r103 = null;
        if (r101 == null) goto L5;
        Object r104 = r101.get("msg");
    L7:
        if ((r104 instanceof String) == true) goto L9;
        r104 = null;
    L9:
        String r105 = (String) r104;
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L19;
        int r107 = d.f49983d;
        return d.a.a("msg is empty");
    L19:
        int r108 = d.f49983d;
        int r109 = b.f495328a;
        if (r101 == null) goto L28;
        Object r110 = r101.get("msg");
        if ((r110 instanceof String) == false) goto L26;
        r103 = r110;
    L26:
        r103 = new b((String) r103, mq.b.a(r101.get("is_long")));
    L28:
        return d.a.b(r103);
    L12:
        if (r105.length() == 0) goto L15;
        r106 = false;
        goto L16
    L5:
        r104 = null;
        goto L7
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final void onHandle(ActionContext r100, SlcCommonAction r101, b r102, c r103) {
        b r104 = r102;
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r104 == null) goto L6;
        r100.f49972g.e(r100.getActivity(), r104);
        return;
    }
}
