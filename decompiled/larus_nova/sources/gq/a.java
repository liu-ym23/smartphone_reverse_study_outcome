package gq;

import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.c;
import com.bytedance.android.ecom.arch.slice.action.d;
import com.bytedance.android.ecom.arch.slice.action.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends e<Object> {
    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final void onHandle(ActionContext r100, SlcCommonAction r101, Object r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, "action");
    }

    public a() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public final d<Object> checkParam(SlcCommonAction r100, Map<String, ? extends Object> r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        int r103 = d.f49983d;
        return d.a.b(null);
    }
}
