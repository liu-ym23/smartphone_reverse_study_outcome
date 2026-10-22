package yp;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final g a(EventContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSlice");
        YataConcurrentHashMap<Object, Object> r101 = r100.d();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("slice-data");
    L7:
        if ((r103 instanceof g) == false) goto L11;
        r102 = r103;
    L11:
        return (g) r102;
    L5:
        r103 = null;
        goto L7
    }

    public static final SlcContext b(EventContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSliceContext");
        YataConcurrentHashMap<Object, Object> r101 = r100.d();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("slice-context");
    L7:
        if ((r103 instanceof SlcContext) == false) goto L11;
        r102 = r103;
    L11:
        return (SlcContext) r102;
    L5:
        r103 = null;
        goto L7
    }

    public static final View c(EventContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getView");
        YataConcurrentHashMap<Object, Object> r101 = r100.d();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("view");
    L7:
        if ((r103 instanceof View) == false) goto L11;
        r102 = r103;
    L11:
        return (View) r102;
    L5:
        r103 = null;
        goto L7
    }
}
