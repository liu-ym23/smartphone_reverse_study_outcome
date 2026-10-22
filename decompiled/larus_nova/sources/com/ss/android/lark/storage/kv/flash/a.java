package com.ss.android.lark.storage.kv.flash;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, e> f441036a;

    public a() {
        this.f441036a = new HashMap();
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        e r101 = this.f441036a.get(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        e r101 = this.f441036a.get(r100);
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        e r102 = this.f441036a.get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        e r102 = this.f441036a.get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        e r102 = this.f441036a.get(r100);
        if (r102 == null) goto L9;
        String r103 = r102.getString(r100, r101);
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r103;
    L9:
        return r101;
    }
}
