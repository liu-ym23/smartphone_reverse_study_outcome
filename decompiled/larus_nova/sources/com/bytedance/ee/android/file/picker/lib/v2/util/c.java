package com.bytedance.ee.android.file.picker.lib.v2.util;

import androidx.collection.SimpleArrayMap;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap<Key, Long> f206159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f206160b;

    public c() {
        this.f206159a = new SimpleArrayMap(0, 1, null);
    }

    public final long a(Key r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Long r101 = this.f206159a.get(r100);
        if (r101 != null) goto L5;
        long r102 = this.f206160b;
        this.f206160b = 1 + r102;
        this.f206159a.put(r100, Long.valueOf(r102));
        return r102;
    L5:
        return r101.longValue();
    }
}
