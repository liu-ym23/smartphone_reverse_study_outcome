package com.bytedance.ies.argus.repository;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public abstract class BaseConfigProvider<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f246097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function1<T, Unit>> f246098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f246099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f246100d;

    public abstract T a(JSONObject r100, c r101);

    public BaseConfigProvider(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f246097a = r100;
        this.f246098b = new CopyOnWriteArrayList();
    }

    public final void b(JSONObject r110, c r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "info");
        Long r100 = r111.f246110c;
        c r101 = this.f246099c;
        if (r101 == null) goto L5;
        Long r102 = r101.f246110c;
    L6:
        if (r100 != null) goto L8;
    L10:
        Pair r103 = new Pair(Boolean.TRUE, "");
    L11:
        this.f246099c = r111;
        boolean r104 = ((Boolean) r103.component1()).booleanValue();
        String r105 = (String) r103.component2();
        if (r104 == false) goto L21;
        T r112 = a(r110, r111);
        this.f246100d = r112;
        if (r112 != null) goto L16;
        return;
    L16:
        if ((!this.f246098b.isEmpty()) == false) goto L25;
        b1 r113 = kotlinx.coroutines.flow.e.b(j1.a(r112));
        Iterator<Function1<T, Unit>> r114 = this.f246098b.iterator();
    L19:
        if (r114.hasNext() == false) goto L26;
        BuildersKt.launch$default(this.f246097a, null, null, new BaseConfigProvider$onConfigUpdate$1$1(r113, r114.next(), null), 3, null);
        goto L19
    L26:
        return;
    L25:
        return;
    L21:
        int r115 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("ArgusConfigManager", "no need update " + getClass().getSimpleName() + ", " + r105);
        return;
    L8:
        if (Intrinsics.areEqual(r100, r102) == false) goto L10;
        r103 = new Pair(Boolean.FALSE, "timeStamp is same: " + r100);
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
