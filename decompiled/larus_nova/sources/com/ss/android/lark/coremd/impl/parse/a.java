package com.ss.android.lark.coremd.impl.parse;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements com.ss.android.lark.coremd.base.parse.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Object, Object> f419862c;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        a r100 = new a();
        r100.f419862c.putAll(this.f419862c);
        return r100;
    }

    public a() {
        this.f419862c = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f419862c;
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r100) {
        Intrinsics.checkNotNullParameter(r100, "that");
        a r101 = new a();
        r101.f419862c.putAll(this.f419862c);
        r101.f419862c.putAll(r100.getValues());
        return r101;
    }
}
