package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import android.app.Activity;
import android.view.View;
import com.larus.bmhome.bigimg.k;
import com.larus.bmhome.bigimg.l;
import com.larus.common.apphost.AppHost;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f308956a;

    @Override // com.larus.bmhome.chat.standarduikit.browsercontrol.vm.b
    public final void a() {
        this.f308956a.invoke();
    }

    public c(dj8.c r100) {
        Intrinsics.checkNotNullParameter(r100, "onRebind");
        this.f308956a = r100;
    }

    @Override // com.larus.bmhome.chat.standarduikit.browsercontrol.vm.b
    public final void b(String r210, View r211) {
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r211, "view");
        l r100 = new l(null, r210, "", r210, null, null, null, null, null, null, 2033);
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.content.Context");
        k.c(r101, CollectionsKt.listOf(new Pair(0, r211)), CollectionsKt.listOf(r100), 0, new uo8.k(MapsKt.emptyMap(), null), true, null, null, false, null, null, null, null, 16320);
    }
}
