package ms5;

import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.jvm.internal.Intrinsics;
import rxb.e;
import txb.b;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final txb.a a(pxb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        b r101 = r100.getServiceManager();
        if (r101 == null) goto L5;
        txb.a r102 = (txb.a) r101.getService(txb.a.class);
    L6:
        if (r102 != null) goto L9;
        int r103 = e.f539878a;
        Intrinsics.checkNotNullParameter("MixRenderWebViewLog", "tag");
        Intrinsics.checkNotNullParameter("renderInWebViewService is null", "msg");
        j.f("PlatformViewLog-".concat("MixRenderWebViewLog"), "renderInWebViewService is null");
        return null;
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
