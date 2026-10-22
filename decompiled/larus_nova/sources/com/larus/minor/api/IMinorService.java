package com.larus.minor.api;

import androidx.fragment.app.Fragment;
import com.larus.platform.api.v2;
import com.larus.platform.api.z2;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 &2\u00020\u0001:\u0001&J\b\u0010\u0002\u001a\u00020\u0003H&J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0005H&J\u001c\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H¦@¢\u0006\u0002\u0010\u0018J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u000e\u0010\u001d\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\rH¦@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0003H&¨\u0006'"}, d2 = {"Lcom/larus/minor/api/IMinorService;", "", "isInMinorMode", "", "registerMinorStatusCallback", "", "callback", "Lcom/larus/minor/api/IMinorStatusListener;", "isSticky", "(Lcom/larus/minor/api/IMinorStatusListener;Ljava/lang/Boolean;)V", "unregisterMinorStatusCallback", "getMinorConfigs", "", "", "createChatMinorRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createNeedInterceptInMinorModeRouterInterceptor", "createMainMinorFragment", "Landroidx/fragment/app/Fragment;", "enterMinorMode", "exitMinorMode", "checkTipsShow", "showDialogAction", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getISdkLinkHandler", "Lcom/larus/platform/api/ISdkLinkHanlder;", "getISdkMessageFilter", "Lcom/larus/platform/api/ISdkMessageFilter;", "requestMinorStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMinorModeChange", "Lcom/larus/minor/api/MinorModePasswordResult;", "enable", "password", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "debugMinorModeGuidePage", "isShowed", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMinorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f359156a = null;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u001c\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010$\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u000eH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006-"}, d2 = {"Lcom/larus/minor/api/IMinorService$Companion;", "Lcom/larus/minor/api/IMinorService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/minor/api/IMinorService;", "impl$delegate", "Lkotlin/Lazy;", "registerMinorStatusCallback", "", "callback", "Lcom/larus/minor/api/IMinorStatusListener;", "isSticky", "", "(Lcom/larus/minor/api/IMinorStatusListener;Ljava/lang/Boolean;)V", "unregisterMinorStatusCallback", "isInMinorMode", "getMinorConfigs", "", "", "createChatMinorRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createNeedInterceptInMinorModeRouterInterceptor", "createMainMinorFragment", "Landroidx/fragment/app/Fragment;", "enterMinorMode", "exitMinorMode", "checkTipsShow", "showDialogAction", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getISdkLinkHandler", "Lcom/larus/platform/api/ISdkLinkHanlder;", "getISdkMessageFilter", "Lcom/larus/platform/api/ISdkMessageFilter;", "requestMinorStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMinorModeChange", "Lcom/larus/minor/api/MinorModePasswordResult;", "enable", "password", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "debugMinorModeGuidePage", "isShowed", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IMinorService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f359157b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IMinorService> f359158c = null;

        private Companion() {
        }

        static {
            f359157b = new Companion();
            f359158c = LazyKt.lazy(new com.larus.minor.api.a());
        }

        public static IMinorService o() {
            return f359158c.getValue();
        }

        @Override // com.larus.minor.api.IMinorService
        public final boolean a() {
            IMinorService r100 = o();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.a() != true) goto L7;
            return true;
        }

        @Override // com.larus.minor.api.IMinorService
        public final void b() {
            IMinorService r100 = o();
            if (r100 == null) goto L6;
            r100.b();
            return;
        }

        @Override // com.larus.minor.api.IMinorService
        public final List<String> c() {
            IMinorService r100 = o();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.c();
        }

        @Override // com.larus.minor.api.IMinorService
        public final q97.a d() {
            IMinorService r100 = o();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.d();
        }

        @Override // com.larus.minor.api.IMinorService
        public final z2 e() {
            IMinorService r100 = o();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.e();
        }

        @Override // com.larus.minor.api.IMinorService
        public final v2 g() {
            IMinorService r100 = o();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.g();
        }

        @Override // com.larus.minor.api.IMinorService
        public final Fragment h() {
            IMinorService r100 = o();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.h();
        }

        @Override // com.larus.minor.api.IMinorService
        public final void j() {
            IMinorService r100 = o();
            if (r100 == null) goto L6;
            r100.j();
            return;
        }

        @Override // com.larus.minor.api.IMinorService
        public final q97.a m() {
            IMinorService r100 = o();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.m();
        }

        @Override // com.larus.minor.api.IMinorService
        public final void i(c r100) {
            IMinorService r101 = o();
            if (r101 == null) goto L6;
            r101.i(r100);
            return;
        }

        @Override // com.larus.minor.api.IMinorService
        public final Object l(Continuation<? super Boolean> r100) {
            if ((r100 instanceof IMinorService$Companion$requestMinorStatus$1) == false) goto L7;
            IMinorService$Companion$requestMinorStatus$1 r101 = (IMinorService$Companion$requestMinorStatus$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r103);
        L19:
            boolean r106 = ((Boolean) r103).booleanValue();
        L22:
            return Boxing.boxBoolean(r106);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            IMinorService r107 = o();
            if (r107 == null) goto L20;
            r101.label = 1;
            r103 = r107.l(r101);
            if (r103 != r104) goto L19;
            return r104;
        L20:
            r106 = false;
        L7:
            r101 = new IMinorService$Companion$requestMinorStatus$1(this, r100);
            goto L8
        }

        @Override // com.larus.minor.api.IMinorService
        public final Object n(Continuation r100) {
            if ((r100 instanceof IMinorService$Companion$requestMinorModeChange$1) == false) goto L7;
            IMinorService$Companion$requestMinorModeChange$1 r101 = (IMinorService$Companion$requestMinorModeChange$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r103);
        L19:
            d r106 = (d) r103;
            if (r106 == null) goto L22;
            return r106;
        L22:
            return new d(false, "Minor service is unavailable.", 4);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            IMinorService r107 = o();
            if (r107 == null) goto L22;
            r101.label = 1;
            r103 = r107.n(r101);
            if (r103 != r104) goto L19;
            return r104;
        L7:
            r101 = new IMinorService$Companion$requestMinorModeChange$1(this, r100);
            goto L8
        }

        @Override // com.larus.minor.api.IMinorService
        public final Object f(com.larus.minor.impl.component.c r100, Continuation r101) {
            if ((r101 instanceof IMinorService$Companion$checkTipsShow$1) == false) goto L7;
            IMinorService$Companion$checkTipsShow$1 r102 = (IMinorService$Companion$checkTipsShow$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            ResultKt.throwOnFailure(r104);
        L19:
            boolean r107 = ((Boolean) r104).booleanValue();
        L22:
            return Boxing.boxBoolean(r107);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            IMinorService r108 = o();
            if (r108 == null) goto L20;
            r102.label = 1;
            r104 = r108.f(r100, r102);
            if (r104 != r105) goto L19;
            return r105;
        L20:
            r107 = false;
        L7:
            r102 = new IMinorService$Companion$checkTipsShow$1(this, r101);
            goto L8
        }

        @Override // com.larus.minor.api.IMinorService
        public final void k(c r100, Boolean r101) {
            IMinorService r102 = o();
            if (r102 == null) goto L6;
            r102.k(r100, r101);
            return;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IMinorService r100, c r101) {
            r100.k(r101, Boolean.FALSE);
        }
    }

    static {
        f359156a = Companion.f359157b;
    }

    boolean a();

    void b();

    List<String> c();

    q97.a d();

    z2 e();

    Object f(com.larus.minor.impl.component.c r100, Continuation r101);

    v2 g();

    Fragment h();

    void i(c r100);

    void j();

    void k(c r100, Boolean r101);

    Object l(Continuation<? super Boolean> r100);

    q97.a m();

    Object n(Continuation r100);
}
