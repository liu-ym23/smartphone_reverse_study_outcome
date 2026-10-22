package com.ss.android.lark.featuregating;

import com.ss.android.lark.storage.kv.flash.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements e {
    public a() {
    }

    public final String[] a() {
        String[] r100 = FileFgCenter.f420719c;
        return (String[]) FileFgCenter.f420720d.f420721a.keySet().toArray(new String[0]);
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String[] r101 = FileFgCenter.f420719c;
        return FileFgCenter.f420720d.a(r100);
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        throw new UnsupportedOperationException("FileFgCenterSource remove() not support");
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String[] r102 = FileFgCenter.f420719c;
        return FileFgCenter.f420720d.a(r100);
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        throw new UnsupportedOperationException("FileFgCenterSource getLong() not support");
    }

    @Override // com.ss.android.lark.storage.kv.flash.e
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        throw new UnsupportedOperationException("FileFgCenterSource getString() not support");
    }
}
