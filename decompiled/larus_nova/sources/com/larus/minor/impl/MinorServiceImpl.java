package com.larus.minor.impl;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.auth.MinorInfoData;
import com.larus.minor.api.IMinorService;
import com.larus.minor.impl.api.MinorApi;
import com.larus.minor.impl.view.MainMinorFragment;
import com.larus.minor.model.MinorConfigItems;
import com.larus.network.bean.BizResponse;
import com.larus.platform.api.v2;
import com.larus.platform.api.z2;
import com.larus.platform.service.AccountService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J!\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0010H\u0016¨\u0006("}, d2 = {"Lcom/larus/minor/impl/MinorServiceImpl;", "Lcom/larus/minor/api/IMinorService;", "<init>", "()V", "getMinorConfigs", "", "", "createChatMinorRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createNeedInterceptInMinorModeRouterInterceptor", "createMainMinorFragment", "Landroidx/fragment/app/Fragment;", "enterMinorMode", "", "exitMinorMode", "isInMinorMode", "", "registerMinorStatusCallback", "callback", "Lcom/larus/minor/api/IMinorStatusListener;", "isSticky", "(Lcom/larus/minor/api/IMinorStatusListener;Ljava/lang/Boolean;)V", "unregisterMinorStatusCallback", "checkTipsShow", "showDialogAction", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getISdkLinkHandler", "Lcom/larus/platform/api/ISdkLinkHanlder;", "getISdkMessageFilter", "Lcom/larus/platform/api/ISdkMessageFilter;", "requestMinorStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMinorModeChange", "Lcom/larus/minor/api/MinorModePasswordResult;", "enable", "password", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "debugMinorModeGuidePage", "isShowed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinorServiceImpl implements IMinorService {
    public MinorServiceImpl() {
    }

    @Override // com.larus.minor.api.IMinorService
    public final boolean a() {
        v r100 = v.f359217a;
        if (v.f359218b.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L7;
        return true;
    }

    @Override // com.larus.minor.api.IMinorService
    public final void b() {
        v r100 = v.f359217a;
        v.d(true);
    }

    @Override // com.larus.minor.api.IMinorService
    public final List<String> c() {
        v r100 = v.f359217a;
        return CollectionsKt.mutableListOf(new String[]{MinorConfigItems.SHOW_VIDEO, MinorConfigItems.AI_CREATION, MinorConfigItems.ENTER_WEB});
    }

    @Override // com.larus.minor.api.IMinorService
    public final q97.a d() {
        return new w();
    }

    @Override // com.larus.minor.api.IMinorService
    public final Fragment h() {
        return new MainMinorFragment();
    }

    @Override // com.larus.minor.api.IMinorService
    public final void j() {
        v r100 = v.f359217a;
        v.d(false);
    }

    @Override // com.larus.minor.api.IMinorService
    public final q97.a m() {
        return new d();
    }

    @Override // com.larus.minor.api.IMinorService
    public final z2 e() {
        return j.f359215a;
    }

    @Override // com.larus.minor.api.IMinorService
    public final v2 g() {
        return i.f359214a;
    }

    @Override // com.larus.minor.api.IMinorService
    public final void i(com.larus.minor.api.c r100) {
        v r101 = v.f359217a;
        if (r100 == null) goto L10;
        List<com.larus.minor.api.c> r102 = v.f359222f;
        if (r102 == null) goto L9;
        ((CopyOnWriteArrayList) r102).remove(r100);
        return;
    L9:
        return;
    }

    @Override // com.larus.minor.api.IMinorService
    public final Object l(Continuation<? super Boolean> r100) {
        if ((r100 instanceof MinorServiceImpl$requestMinorStatus$1) == false) goto L7;
        MinorServiceImpl$requestMinorStatus$1 r101 = (MinorServiceImpl$requestMinorStatus$1) r100;
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
    L17:
        dm9.a r106 = (dm9.a) r103;
        if ((r106 instanceof dm9.a.b) == false) goto L25;
        dm9.a.b r107 = (dm9.a.b) r106;
        if (r107.f469231a.isSuccess() == false) goto L25;
        MinorInfoData r108 = (MinorInfoData) r107.f469231a.getData();
        if (r108 == null) goto L24;
        boolean r109 = Intrinsics.areEqual(r108.b(), Boxing.boxBoolean(true));
    L27:
        return Boxing.boxBoolean(r109);
    L24:
        r109 = false;
    L25:
        r109 = a();
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        MinorApi.a r110 = MinorApi.f359163a;
        MinorServiceImpl$requestMinorStatus$result$1 r111 = new MinorServiceImpl$requestMinorStatus$result$1(null);
        r101.label = 1;
        r110.getClass();
        r103 = MinorApi.a.a(r111, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new MinorServiceImpl$requestMinorStatus$1(this, r100);
        goto L8
    }

    @Override // com.larus.minor.api.IMinorService
    public final Object n(Continuation r100) {
        if ((r100 instanceof MinorServiceImpl$requestMinorModeChange$1) == false) goto L7;
        MinorServiceImpl$requestMinorModeChange$1 r101 = (MinorServiceImpl$requestMinorModeChange$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        Long r106 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r107 = r101.Z$0;
        ResultKt.throwOnFailure(r103);
    L18:
        dm9.a r108 = (dm9.a) r103;
        boolean r109 = r108 instanceof dm9.a.b;
        if (r109 == false) goto L21;
        dm9.a.b r110 = (dm9.a.b) r108;
    L22:
        if (r110 == null) goto L24;
        BizResponse r111 = r110.f469231a;
    L25:
        if (r111 != null) goto L27;
    L29:
        boolean r112 = false;
    L30:
        if (r112 == false) goto L34;
        v r113 = v.f359217a;
        v.d(r107);
        return new com.larus.minor.api.d(true, null, 14);
    L34:
        if (r111 == null) goto L36;
        String r114 = r111.getMsg();
    L37:
        if (r111 == null) goto L40;
        r106 = Boxing.boxLong(r111.getCode());
    L40:
        return new com.larus.minor.api.d(false, r114, r106, r109);
    L36:
        r114 = null;
        goto L37
    L27:
        if (r111.isSuccess() != true) goto L29;
        r112 = true;
        goto L30
    L24:
        r111 = null;
        goto L25
    L21:
        r110 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r115 = k.a(null);
        MinorApi.a r116 = MinorApi.f359163a;
        MinorServiceImpl$requestMinorModeChange$result$1 r117 = new MinorServiceImpl$requestMinorModeChange$result$1(false, r115, null);
        r101.Z$0 = false;
        r101.label = 1;
        r116.getClass();
        r103 = MinorApi.a.a(r117, r101);
        if (r103 != r104) goto L17;
        return r104;
    L17:
        r107 = false;
    L7:
        r101 = new MinorServiceImpl$requestMinorModeChange$1(this, r100);
        goto L8
    }

    @Override // com.larus.minor.api.IMinorService
    public final Object f(com.larus.minor.impl.component.c r100, Continuation r101) {
        return v.f359217a.a(r100, r101);
    }

    @Override // com.larus.minor.api.IMinorService
    public final void k(com.larus.minor.api.c r100, Boolean r101) {
        v r102 = v.f359217a;
        boolean r103 = Intrinsics.areEqual(r101, Boolean.TRUE);
        if (r100 == null) goto L16;
        List<com.larus.minor.api.c> r104 = v.f359222f;
        if (r104 == null) goto L8;
        ((CopyOnWriteArrayList) r104).add(r100);
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        if (v.f359218b.get() == false) goto L12;
        r100.S1();
        return;
    L12:
        r100.b1();
        return;
    }
}
