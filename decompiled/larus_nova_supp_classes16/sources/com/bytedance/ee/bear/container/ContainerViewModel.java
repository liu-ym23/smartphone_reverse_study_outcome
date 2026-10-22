package com.bytedance.ee.bear.container;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/container/ContainerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "messageTag", "loadJob", "Lkotlinx/coroutines/Job;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ee/bear/container/State;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "containerDependency", "Lcom/bytedance/ee/bear/dependency/ContainerDependency;", "load", "", "fragment", "Landroidx/fragment/app/Fragment;", "userComponentDelegate", "Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", "userSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setState", "provideIContainer", "Lcom/bytedance/ee/bear/node/IContainer;", "containerFragment", "framework-container_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContainerViewModel extends ViewModel {
    private final String TAG;
    private final z0<w> _state;
    private yx4.a containerDependency;
    private volatile Job loadJob;
    private final String messageTag;
    private final i1<w> state;

    public static final class a implements bk5.a {
        public volatile f a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ ContainerViewModel c;
        public final /* synthetic */ vo5.a d;
        public final /* synthetic */ UserSession e;

        public Activity getActivity() {
            return this.b.getActivity();
        }

        public final String getTAG() {
            return ContainerViewModel.access$getMessageTag$p(this.c);
        }

        public final Bundle h9() {
            Bundle r0 = this.b.getArguments();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new Bundle();
        }

        public final void hideLoading() {
            w r0 = w.a((w) this.c.getState().getValue(), null, new e(false), null, null, null, 13);
            ContainerViewModel.access$setState(this.c, r0);
        }

        public final void showLoading() {
            w r0 = w.a((w) this.c.getState().getValue(), null, new e(true), null, null, null, 13);
            ContainerViewModel.access$setState(this.c, r0);
        }

        public final void terminate() {
            Job r0 = ContainerViewModel.access$getLoadJob$p(this.c);
            if (r0 == null) goto L6;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
            return;
        }

        public final void w() {
            Log.i(ContainerViewModel.access$getTAG$p(this.c), "finishSelf...");
            f r0 = this.a;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            if (r1 == true) goto L12;
            FragmentActivity r2 = this.b.getActivity();
            if (r2 == null) goto L13;
            r2.finish();
            return;
        L13:
            return;
        L12:
            return;
        L5:
            if (r0.w() != true) goto L7;
            r1 = true;
            goto L7
        }

        public final void x() {
            w r0 = w.a((w) this.c.getState().getValue(), new g(false), null, null, null, null, 14);
            ContainerViewModel.access$setState(this.c, r0);
        }

        public final UserSession e9() {
            return this.e;
        }

        public final Fragment getFragment() {
            return this.b;
        }

        public final vo5.a j9() {
            return this.d;
        }

        public final void f9(Fragment r10) {
            Intrinsics.checkNotNullParameter(r10, "fragment");
            ContainerViewModel r0 = this.c;
            ContainerViewModel.access$setState(r0, w.a((w) r0.getState().getValue(), null, null, null, null, new com.bytedance.ee.bear.container.a(r10), 15));
        }

        public final void i9(yx4.d r10) {
            ContainerViewModel r0 = this.c;
            ContainerViewModel.access$setState(r0, w.a((w) r0.getState().getValue(), null, null, new d(r10), null, null, 27));
        }

        public final void o0(Bundle r9) {
            Intrinsics.checkNotNullParameter(r9, "argument");
            String r0 = r9.getString("url");
            String r1 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            BearUrl r2 = (BearUrl) r9.getParcelable("bear_url");
            String r3 = ContainerViewModel.access$getTAG$p(this.c);
            StringBuilder r4 = new StringBuilder("reload... url = ");
            r4.append(du5.b.h(r0));
            r4.append(", bearUrl.url =  stark: ");
            String r5 = null;
            if (r2 == null) goto L8;
            String r6 = r2.e;
        L9:
            r4.append(du5.b.h(r6));
            Log.i(r3, r4.toString(), new RuntimeException());
            f r7 = this.a;
            boolean r8 = false;
            if (r7 != null) goto L12;
        L25:
            if (r8 == false) goto L28;
            Log.i(ContainerViewModel.access$getTAG$p(this.c), "reload intercepted");
            return;
        L28:
            this.b.setArguments(r9);
            this.c.load(this.b, this.d, this.e);
            return;
        L12:
            if (r0.length() != 0) goto L14;
            boolean r10 = true;
        L15:
            if (r10 == false) goto L23;
            if (r2 == null) goto L18;
            r5 = r2.e;
        L18:
            if (r5 == null) goto L21;
            r1 = r5;
        L21:
            r0 = r1;
        L23:
            if (r7.a(r0, r9) != true) goto L25;
            r8 = true;
            goto L25
        L14:
            r10 = false;
            goto L15
        L8:
            r6 = null;
            goto L9
        }

        public a(Fragment r1, ContainerViewModel r2, vo5.a r3, UserSession r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            f r5 = null;
            if ((r1 instanceof ContainerFragment) == false) goto L5;
            ContainerFragment r6 = (ContainerFragment) r1;
        L6:
            if (r6 == null) goto L8;
            r5 = r6.s;
        L8:
            this.a = r5;
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void g9(String r14, int r16, Integer r17, String r18, Function0<Unit> r19) {
            Intrinsics.checkNotNullParameter(r14, "msg");
            w r1 = w.a((w) this.c.getState().getValue(), null, null, null, new c(r14, r16, r17, r18, r19), null, 7);
            ContainerViewModel.access$setState(this.c, r1);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.container.ContainerViewModel$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.container.ContainerViewModel$load$1", f = "ContainerViewModel.kt", i = {0, 0, 0, 0}, l = {109}, m = "invokeSuspend", n = {"container", "bearUrl", "nodeType", "startTime"}, s = {"L$0", "L$1", "L$3", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Fragment $fragment;
        final /* synthetic */ vo5.a $userComponentDelegate;
        final /* synthetic */ UserSession $userSession;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ContainerViewModel this$0;

        public AnonymousClass1(ContainerViewModel r1, Fragment r2, vo5.a r3, UserSession r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$fragment = r2;
            this.$userComponentDelegate = r3;
            this.$userSession = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$fragment, this.$userComponentDelegate, this.$userSession, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0119 -> B:57:0x011c). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r18) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            long r6 = this.J$0;
            bk5.d r3 = (bk5.d) this.L$3;
            Iterator r8 = (Iterator) this.L$2;
            BearUrl r9 = (BearUrl) this.L$1;
            bk5.a r10 = (bk5.a) this.L$0;
            ResultKt.throwOnFailure(r18);     // Catch: Exception -> L8
            long r11 = r6;
            AnonymousClass1 r7 = this;
            bk5.d r12 = r3;
            Object r4 = r18;
        L57:
            bk5.e r5 = (bk5.e) r4;     // Catch: Exception -> L48
            String r13 = ContainerViewModel.access$getTAG$p(r7.this$0);     // Catch: Exception -> L48
            StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L48
            r14.append(ContainerViewModel.access$getMessageTag$p(r7.this$0));     // Catch: Exception -> L48
            r14.append(" nodeType: ");     // Catch: Exception -> L48
            r14.append(r12);     // Catch: Exception -> L48
            r14.append(", loaderTypeBefore: ");     // Catch: Exception -> L48
            r14.append(r5);     // Catch: Exception -> L48
            r14.append(", cost: ");     // Catch: Exception -> L48
            r14.append(System.currentTimeMillis() - r11);     // Catch: Exception -> L48
            r14.append(", isCancel: ");     // Catch: Exception -> L48
            Job r16 = ContainerViewModel.access$getLoadJob$p(r7.this$0);     // Catch: Exception -> L48
            if (r16 == null) goto L46;
            Boolean r17 = Boxing.boxBoolean(r16.isCancelled());     // Catch: Exception -> L48
        L47:
            r14.append(r17);     // Catch: Exception -> L48
            Log.i(r13, r14.toString());     // Catch: Exception -> L48
        L29:
            if (r8.hasNext() == false) goto L55;
            r12 = (bk5.d) r8.next();     // Catch: Exception -> L48
            r11 = System.currentTimeMillis();     // Catch: Exception -> L48
            yx4.a r19 = yx4.b.a;     // Catch: Exception -> L48
            Intrinsics.checkNotNullParameter(r12, "type");     // Catch: Exception -> L48
            bk5.c r110 = yx4.b.b.get(r12);     // Catch: Exception -> L48
            if (r110 == null) goto L33;
            bk5.b r111 = r110.a();     // Catch: Exception -> L48
        L34:
            if (r111 != null) goto L36;
        L38:
            boolean r112 = false;
        L39:
            if (r112 == true) goto L40;
            Log.i(ContainerViewModel.access$getTAG$p(r7.this$0), ContainerViewModel.access$getMessageTag$p(r7.this$0) + " nodeType: " + r12 + ", skip run");     // Catch: Exception -> L48
            goto L29
        L40:
            r7.L$0 = r10;     // Catch: Exception -> L48
            r7.L$1 = r9;     // Catch: Exception -> L48
            r7.L$2 = r8;     // Catch: Exception -> L48
            r7.L$3 = r12;     // Catch: Exception -> L48
            r7.J$0 = r11;     // Catch: Exception -> L48
            r7.label = 1;     // Catch: Exception -> L48
            r4 = r111.a(r9, r5, r10, r7);     // Catch: Exception -> L48
            if (r4 != r0) goto L57;
            return r0;
        L36:
            if (r111.b(r9, r5, r10) != true) goto L38;
            r112 = true;
            goto L39
        L33:
            r111 = null;
        L55:
            return Unit.INSTANCE;
        L46:
            r17 = null;
        L48:
            e = e;
        L53:
            Log.e(ContainerViewModel.access$getTAG$p(r7.this$0), ContainerViewModel.access$getMessageTag$p(r7.this$0) + " load error", e);
            goto L55
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r18);
            ContainerViewModel.access$setState(this.this$0, new w(new g(true), 30));
            if (this.$fragment.getArguments() != null) goto L15;
            this.$fragment.setArguments(new Bundle());
        L15:
            bk5.a r20 = this.this$0.provideIContainer(this.$fragment, this.$userComponentDelegate, this.$userSession);
            Bundle r21 = this.$fragment.getArguments();
            if (r21 == null) goto L19;
            String r22 = r21.getString("url");
            if (r22 == null) goto L19;
        L20:
            Bundle r23 = this.$fragment.getArguments();
            if (r23 == null) goto L24;
            BearUrl r24 = (BearUrl) r23.getParcelable("bear_url");
            if (r24 == null) goto L24;
        L25:
            List r26 = CollectionsKt.plus(ContainerViewModel.access$getContainerDependency$p(this.this$0).a(), bk5.d.a.b);
            Log.i(ContainerViewModel.access$getTAG$p(this.this$0), ContainerViewModel.access$getMessageTag$p(this.this$0) + " load start, init node is: " + r26);
            r10 = r20;
            r9 = r24;
            r5 = bk5.e.a.b;
            r8 = r26.iterator();     // Catch: Exception -> L8
            r7 = this;
        L24:
            r24 = s45.p.a().Z(r22);
        L19:
            r22 = "";
        L8:
            e = e;
            r7 = this;
            goto L53
        }
    }

    public ContainerViewModel() {
        this.TAG = "ContainerViewModel" + hashCode();
        this.messageTag = "==openDocs==container== " + hashCode() + ' ';
        StateFlowImpl r0 = j1.a(new w(null, 31));
        this._state = r0;
        this.state = r0;
        this.containerDependency = yx4.b.a;
    }

    public final i1<w> getState() {
        return this.state;
    }

    public static final /* synthetic */ yx4.a access$getContainerDependency$p(ContainerViewModel r0) {
        return r0.containerDependency;
    }

    public static final /* synthetic */ Job access$getLoadJob$p(ContainerViewModel r0) {
        return r0.loadJob;
    }

    public static final /* synthetic */ String access$getMessageTag$p(ContainerViewModel r0) {
        return r0.messageTag;
    }

    public static final /* synthetic */ String access$getTAG$p(ContainerViewModel r0) {
        return r0.TAG;
    }

    private final void setState(w r2) {
        this._state.setValue(r2);
    }

    public static final /* synthetic */ void access$setState(ContainerViewModel r0, w r1) {
        r0.setState(r1);
    }

    public final void load(Fragment r13, vo5.a r14, UserSession r16) {
        Intrinsics.checkNotNullParameter(r13, "fragment");
        Intrinsics.checkNotNullParameter(r14, "userComponentDelegate");
        Intrinsics.checkNotNullParameter(r16, "userSession");
        Job r0 = this.loadJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.loadJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13), Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, r13, r14, r16, null), 2, null);
    }

    public final bk5.a provideIContainer(Fragment r2, vo5.a r3, UserSession r4) {
        Intrinsics.checkNotNullParameter(r2, "containerFragment");
        Intrinsics.checkNotNullParameter(r3, "userComponentDelegate");
        Intrinsics.checkNotNullParameter(r4, "userSession");
        return new a(r2, this, r3, r4);
    }
}
