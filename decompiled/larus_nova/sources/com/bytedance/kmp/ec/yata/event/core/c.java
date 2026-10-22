package com.bytedance.kmp.ec.yata.event.core;

import com.bytedance.kmp.ec.yata.chain.trigger.f;
import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import com.bytedance.kmp.ec.yata.event.common.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f251695a;

    public c(i r100) {
        this.f251695a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.chain.trigger.f
    public final f.a a(com.bytedance.kmp.ec.yata.chain.trigger.b r100) {
        Intrinsics.checkNotNullParameter(r100, "chainContext");
        i r101 = this.f251695a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new f.a(r101.e(new EventTriggerInfo(r100)).f251671a);
    }
}
