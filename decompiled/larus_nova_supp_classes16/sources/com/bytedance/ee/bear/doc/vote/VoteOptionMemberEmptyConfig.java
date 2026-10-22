package com.bytedance.ee.bear.doc.vote;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.empty.Config;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class VoteOptionMemberEmptyConfig {
    public final Context a;
    public final String b;
    public final Function0<Config> c;

    public final Context getContext() {
        return this.a;
    }

    public VoteOptionMemberEmptyConfig(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lang");
        this.a = r2;
        this.b = r3;
        this.c = new VoteOptionMemberEmptyConfig$value$1(this);
    }
}
