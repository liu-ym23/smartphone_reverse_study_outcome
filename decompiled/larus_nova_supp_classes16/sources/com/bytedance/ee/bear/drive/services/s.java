package com.bytedance.ee.bear.drive.services;

import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s<T, R> implements Function {
    public final /* synthetic */ v.b a;
    public final /* synthetic */ UserSession b;

    public s(v.b r1, UserSession r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r3) {
        Boolean r4 = (Boolean) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        tt5.a.h("DriveSaveCacheManager", "addUploadDriveFileCache cacheType=lru, exist=" + r4.booleanValue());
        return this.a.a(this.b);
    }
}
