package com.bytedance.timon.ruler.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.timonbase.pipeline.TimonBasicModeCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class RulerBasicLifecycleServiceImpl$init$1$1 extends Lambda implements Function0<Boolean> {
    public static final RulerBasicLifecycleServiceImpl$init$1$1 INSTANCE = null;

    static {
        INSTANCE = new RulerBasicLifecycleServiceImpl$init$1$1();
    }

    public RulerBasicLifecycleServiceImpl$init$1$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Function0<Boolean> r100 = TimonBasicModeCenter.f270816a;
        return TimonBasicModeCenter.f270816a.invoke().booleanValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }
}
