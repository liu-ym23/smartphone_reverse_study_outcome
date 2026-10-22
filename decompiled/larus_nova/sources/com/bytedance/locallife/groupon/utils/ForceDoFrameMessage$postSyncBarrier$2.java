package com.bytedance.locallife.groupon.utils;

import android.os.MessageQueue;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Method;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class ForceDoFrameMessage$postSyncBarrier$2 extends Lambda implements Function0<Method> {
    public static final ForceDoFrameMessage$postSyncBarrier$2 INSTANCE = null;

    static {
        INSTANCE = new ForceDoFrameMessage$postSyncBarrier$2();
    }

    public ForceDoFrameMessage$postSyncBarrier$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Method invoke2() {
        Method r100 = MessageQueue.class.getDeclaredMethod("postSyncBarrier", new Class[]{Long.TYPE});     // Catch: Exception -> L4
        r100.setAccessible(true);     // Catch: Exception -> L4
        return r100;
    L4:
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Method invoke() {
        return invoke2();
    }
}
