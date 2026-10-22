package com.ss.android.lark.passport.flow.core.router;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import syb.b;

/* JADX INFO: loaded from: classes37.dex */
public final class a<CONTEXT> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<b> f437790c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<syb.a<CONTEXT>> f437791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f437792b;

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.core.router.a$a, reason: collision with other inner class name */
    public static final class C5229a {
        @JvmStatic
        public static PassportRouterResult a(Context r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            boolean r103 = false;
            if (r101 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            String r105 = null;
            if (r104 == false) goto L14;
            return new PassportRouterResult(PassportRouterResult.Status.INVALID_NEXT_STEP, r101, null);
        L14:
            if (Intrinsics.areEqual(r101, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE) == true) goto L16;
            b r106 = a.f437790c.get();
            if (r106 == null) goto L23;
            if (r106.a(r100, r101, r102) != true) goto L23;
            r103 = true;
        L23:
            if (r103 == false) goto L25;
            PassportRouterResult.Status r107 = PassportRouterResult.Status.DISPATCHED;
        L26:
            if (r103 == false) goto L29;
            r105 = "step_data_router";
        L29:
            return new PassportRouterResult(r107, r101, r105);
        L25:
            r107 = PassportRouterResult.Status.UNSUPPORTED;
            goto L26
        L16:
            return new PassportRouterResult(PassportRouterResult.Status.TERMINAL, r101, null);
        L5:
            if (r101.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    static {
        f437790c = new AtomicReference();
    }

    public a(List<? extends syb.a<CONTEXT>> r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r101, "terminalSteps");
        Set<String> r102 = r101;
        boolean r103 = true;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        if (((String) r104.next()).length() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L9;
        r103 = false;
        goto L16
    L13:
        r105 = false;
    L16:
        if (r103 == false) goto L20;
        this.f437791a = CollectionsKt.toList(r100);
        this.f437792b = CollectionsKt.toSet(r102);
        return;
    L20:
        throw new IllegalArgumentException("terminal step must not be empty".toString());
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }
}
