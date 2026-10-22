package com.ss.android.ugc.aweme.dependence.download.persistence;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.common.collect.f1;
import com.google.common.collect.o;
import com.google.common.collect.r1;
import com.google.common.collect.t1;
import com.ss.android.ugc.aweme.dependence.download.persistence.callback.ISerialTaskCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001ar\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0004 \u0003*8\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0004\u0018\u00010\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Param", "Target", "Lcom/google/common/collect/f1;", "kotlin.jvm.PlatformType", "Lcom/ss/android/ugc/aweme/dependence/download/persistence/callback/ISerialTaskCallback;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/google/common/collect/f1;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PrioritySerialTaskScheduler$mMultiCallbacks$2 extends Lambda implements Function0<f1<Object, ISerialTaskCallback<Object, Object>>> {
    public static final PrioritySerialTaskScheduler$mMultiCallbacks$2 INSTANCE = null;

    static {
        INSTANCE = new PrioritySerialTaskScheduler$mMultiCallbacks$2();
    }

    public PrioritySerialTaskScheduler$mMultiCallbacks$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final f1<Object, ISerialTaskCallback<Object, Object>> invoke() {
        o.b(8, "expectedKeys");
        r1 r100 = new r1();
        o.b(2, "expectedValuesPerKey");
        return new t1(r100).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ f1<Object, ISerialTaskCallback<Object, Object>> invoke() {
        return invoke();
    }
}
