package com.larksuite.common_selection;

import android.view.View;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f282928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<s> f282929b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f282930c = null;

    public t() {
    }

    static {
        f282928a = new t();
        ArrayList r100 = new ArrayList();
        f282929b = r100;
        f282930c = new x();
        x r101 = new x();
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        ListProtector.add(r100, 0, r101);
        u r102 = new u();
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        ListProtector.add(r100, 0, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s a(View r100) {
        Object r101 = null;
        if (r100 != 0) goto L6;
        return null;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        Iterator r102 = ((ArrayList) f282929b).iterator();
    L11:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        if (((s) r103).h(r100) == false) goto L11;
        r101 = r103;
    L16:
        return (s) r101;
    L8:
        return ((f) r100).getSelectionStrategy();
    }
}
