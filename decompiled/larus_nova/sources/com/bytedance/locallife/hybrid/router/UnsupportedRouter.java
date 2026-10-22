package com.bytedance.locallife.hybrid.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.locallife.biz.utils.ToastUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class UnsupportedRouter extends fo6.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f259081c;

    public UnsupportedRouter(Function0<Unit> r100) {
        super(r100);
        this.f259081c = LazyKt.lazy(UnsupportedRouter$interceptRule$2.INSTANCE);
    }

    @Override // fo6.d
    public final boolean a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        InterceptRule r100 = (InterceptRule) this.f259081c.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "uri");
        String r111 = r110.toString();
        Intrinsics.checkNotNullParameter(r111, "schema");
        com.bytedance.locallife.biz.common.utils.c.a("InterceptRule", "match Schema: " + r111);
        Iterator r101 = ((List) r100.f259080a.getValue()).iterator();
    L3:
        boolean r102 = false;
        if (r101.hasNext() == false) goto L51;
        cu6.b r103 = (cu6.b) r101.next();
        String r104 = r103.c();
        com.bytedance.locallife.biz.common.utils.c.a("InterceptRule", "match prefix: " + r104);
        List<String> r105 = r103.b();
        if (r105 != null) goto L9;
        r105 = CollectionsKt.emptyList();
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L18;
    L34:
        com.bytedance.locallife.biz.common.utils.c.b("InterceptRule", "match reuslt: false");
    L35:
        if (r102 == false) goto L3;
        return true;
    L18:
        if (StringsKt.startsWith$default(r111, r104, false, 2, null) == false) goto L34;
        Iterator<T> r107 = r105.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        String r108 = (String) r107.next();
        com.bytedance.locallife.biz.common.utils.c.a("InterceptRule", "match reguler: " + r108);
        if (StringsKt.contains$default(r111, r108, false, 2, null) == true) goto L21;
        com.bytedance.locallife.biz.common.utils.c.a("InterceptRule", "match reuslt: false");
        goto L35
    L25:
        List<String> r109 = r103.a();
        if (r109 == null) goto L33;
        Iterator<T> r112 = r109.iterator();
    L29:
        if (r112.hasNext() == false) goto L33;
        if (StringsKt.contains$default(r111, (String) r112.next(), false, 2, null) == false) goto L29;
        com.bytedance.locallife.biz.common.utils.c.a("InterceptRule", "match ignore");
    L33:
        com.bytedance.locallife.biz.common.utils.c.b("InterceptRule", "match reuslt: true");
        r102 = true;
        goto L35
    L11:
        if (r104.length() == 0) goto L14;
        r106 = false;
        goto L16
    L51:
        return false;
    }

    @Override // fo6.a, fo6.d
    public final void b(Context r100, Uri r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "intent");
        super.b(r100, r101, r102);
        ToastUtils.b(r100);
    }
}
