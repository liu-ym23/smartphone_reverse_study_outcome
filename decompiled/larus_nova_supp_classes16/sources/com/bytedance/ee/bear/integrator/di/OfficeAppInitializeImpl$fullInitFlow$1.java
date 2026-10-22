package com.bytedance.ee.bear.integrator.di;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeAppInitializeImpl$fullInitFlow$1 implements FlowableOnSubscribe<Object> {
    public Job a;

    public static final class a implements ttc.c {
        public final /* synthetic */ OfficeAppInitializeImpl$fullInitFlow$1 a;

        public a(OfficeAppInitializeImpl$fullInitFlow$1 r1) {
            this.a = r1;
        }

        public final void cancel() {
            Job r0 = this.a.a;     // Catch: Exception -> L6
            if (r0 == null) goto L11;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            tt5.a.e("OfficeAppInitializeImpl", "fullInitFlow, cancel sdkInitJob error: ", e, false);
        }
    }

    public OfficeAppInitializeImpl$fullInitFlow$1() {
    }

    public final void subscribe(FlowableEmitter<Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "emitter");
        this.a = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), null, new OfficeAppInitializeImpl$fullInitFlow$1$subscribe$1(r8, null), 2, null);
        r8.setCancellable(new a(this));
    }
}
