package com.ss.android.lark.flow.passport.ui.widget.utils;

import androidx.core.app.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowUtilKt {

    public static final class a implements FlowCollector, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f423911a;

        public a(Function2 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f423911a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* synthetic */ Object emit(Object r100, Continuation r101) {
            return this.f423911a.invoke(r100, r101);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f423911a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    public static final void a(ComponentActivity r100, i1 r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, BytedCertConstant.CertKey.FLOW);
        Intrinsics.checkNotNullParameter(r102, ShareChannel.COLLECT);
        LifecycleOwnerKt.getLifecycleScope(r100).launchWhenResumed(new FlowUtilKt$collectLatestLifecycleFlow$2(r101, r102, null));
    }

    public static final void b(ComponentActivity r100, d1 r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, BytedCertConstant.CertKey.FLOW);
        Intrinsics.checkNotNullParameter(r102, ShareChannel.COLLECT);
        LifecycleOwnerKt.getLifecycleScope(r100).launchWhenResumed(new FlowUtilKt$collectLifecycleFlow$2(r101, r102, null));
    }

    public static final <T> void c(Fragment r100, Flow<? extends T> r101, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, BytedCertConstant.CertKey.FLOW);
        Intrinsics.checkNotNullParameter(r102, ShareChannel.COLLECT);
        LifecycleOwnerKt.getLifecycleScope(r100).launchWhenResumed(new FlowUtilKt$collectLifecycleFlow$1(r101, r102, null));
    }
}
