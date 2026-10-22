package com.larus.suggest.impl.wcb.loading;

import com.larus.im.bean.message.Message;
import com.larus.suggest.impl.wcb.render.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f369932a;

    public a(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f369932a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        ConcurrentHashMap<Long, b> r104 = c.f369948a;
        if (c.a(this.f369932a.b()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r110, "input");
        ConcurrentHashMap<Long, b> r103 = c.f369948a;
        b r104 = c.a(this.f369932a.b());
        if (r104 != null) goto L6;
        return r110;
    L6:
        if (r104.f369947o.isCompleted() == true) goto L42;
        List<xc8.b> r105 = r110;
        boolean r106 = false;
        if ((r105 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L40;
        Message r108 = ((xc8.b) r107.next()).getMessage();
        Intrinsics.checkNotNullParameter(r108, "message");
        n.b r109 = r104.f369945m;
        if (r109 == null) goto L37;
        Map<String, String> r111 = r108.getExt();
        if (r111 != null) goto L22;
        r111 = MapsKt.emptyMap();
    L22:
        if (Intrinsics.areEqual(r108.getConversationId(), r104.f369935c) == false) goto L37;
        if (Intrinsics.areEqual(r108.getLocalMessageId(), r109.f370063a) == false) goto L37;
        Map<String, String> r112 = r109.f370064b;
        if (r112.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L30:
        if (r113.hasNext() == false) goto L34;
        Map.Entry<String, String> r114 = r113.next();
        String r115 = r114.getKey();
        String r116 = r114.getValue();
        if (Intrinsics.areEqual(r111.get(r115), r116) == true) goto L30;
        boolean r117 = false;
    L35:
        if (r117 == false) goto L37;
        boolean r118 = true;
    L38:
        if (r118 == false) goto L14;
        r106 = true;
    L34:
        r117 = true;
    L37:
        r118 = false;
    L40:
        if (r106 == false) goto L42;
        r104.f369947o.complete(Unit.INSTANCE);
        goto L42
    L10:
        if (r105.isEmpty() == false) goto L12;
    L42:
        return r110;
    }
}
