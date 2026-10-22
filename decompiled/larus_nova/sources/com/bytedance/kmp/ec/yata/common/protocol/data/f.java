package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    @Deprecated(message = "内部API")
    public static final String b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<v96.k> r101 = r100.f251550a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        List<v96.k> r103 = r100.f251550a;
        if (r103 == null) goto L36;
        Iterator<T> r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L26;
        Object r105 = r104.next();
        v96.k r106 = (v96.k) r105;
        if (Intrinsics.areEqual(r106.f553804a, Constants.Keys.KEY_X_TT_LOGID) == false) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L16;
    L27:
        v96.k r108 = (v96.k) r105;
        if (r108 != null) goto L30;
        return null;
    L30:
        return r108.f553805b;
    L20:
        if (Intrinsics.areEqual(r106.f553804a, NetResponse.HEADER_KEY_LOG_ID) == true) goto L23;
        r107 = false;
        goto L24
    L26:
        r105 = null;
        goto L27
    L36:
        return null;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    @Deprecated(message = "内部API")
    public static final boolean c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.a();
        if (r101 != null) goto L6;
    L7:
        return true;
    L6:
        if (r101.intValue() != 0) goto L7;
        return false;
    }

    @Deprecated(message = "内部API")
    public static final boolean d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.a();
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r101.intValue() != 0) goto L8;
        return true;
    }

    public static final e a(final String r100, List r101) {
        Intrinsics.checkNotNullParameter(e.f251551b, "<this>");
        final e r102 = new e(null);
        r102.d(null);
        r102.f251550a = r101;
        r102.i();
        String r103 = YaTaLog.f251436a;
        YaTaLog.d("net-error", new DownLinkDataResponseKt$error$1$1(r100, r102));
        return r102;
    }
}
