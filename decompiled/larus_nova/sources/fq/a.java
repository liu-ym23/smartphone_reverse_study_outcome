package fq;

import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.c;
import com.bytedance.android.ecom.arch.slice.action.d;
import com.bytedance.android.ecom.arch.slice.action.e;
import com.bytedance.android.ecom.arch.slice.action.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends e<b> {
    public a() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final d<b> checkParam(SlcCommonAction r100, Map<String, ? extends Object> r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b r103 = new b(r100.getActions());
        int r104 = d.f49983d;
        return d.a.b(r103);
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final void onHandle(ActionContext r100, SlcCommonAction r101, b r102, c r103) {
        b r104 = r102;
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r104 == null) goto L10;
        List<IAction> r105 = r104.f478398a;
        if (r105 == null) goto L12;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L13;
        ActionContext.c(r100, (IAction) r106.next(), r103, 4);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final void onHandle(ActionContext r100, SlcCommonAction r101, b r102, c r103, i r104) {
        b r105 = r102;
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r105 == null) goto L14;
        List<IAction> r106 = r105.f478398a;
        if (r106 == null) goto L18;
        Iterator<T> r107 = r106.iterator();
    L8:
        if (r107.hasNext() == false) goto L19;
        IAction r108 = (IAction) r107.next();
        if (r104 == null) goto L12;
        Map<String, ? extends Object> r109 = r104.f49992b;
    L13:
        r100.b(r108, r103, r109);
        goto L8
    L12:
        r109 = null;
        goto L13
    L19:
        return;
    L18:
        return;
    }
}
