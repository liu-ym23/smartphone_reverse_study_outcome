package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.text.Spanned;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.coremd.base.parse.r;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends dab.a>, b.a<dab.a>> f420085a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b
    public final void a() {
        ((LinkedHashMap) this.f420085a).clear();
    }

    public final int hashCode() {
        return this.f420085a.hashCode();
    }

    public c() {
        this.f420085a = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b
    public final void c(b.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f420085a.put((Class<? extends dab.a>) r100.getType(), (b.a<dab.a>) r100);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.link.parser.b
    public final Spanned b(r<n> r100, dab.a r101) {
        Intrinsics.checkNotNullParameter(r100, "visitContext");
        Intrinsics.checkNotNullParameter(r101, "info");
        Class<?> r102 = r101.getClass();
        b.a r103 = (b.a) ((LinkedHashMap) this.f420085a).get(r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.a(r100, r101);
    }
}
