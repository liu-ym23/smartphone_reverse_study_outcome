package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.shopping.anchorv3.repository.dto.GroupInfoResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T, R> implements Function {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r2) {
        GroupInfoResponse r3 = (GroupInfoResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.getGroupInfo();
    }
}
