package com.larus.bmhome.double_post;

import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes26.dex */
public final class AwemeDoublePostInnerPushManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AwemeDoublePostInnerPushManager f311395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f311396b = null;

    public AwemeDoublePostInnerPushManager() {
    }

    static {
        f311395a = new AwemeDoublePostInnerPushManager();
        f311396b = LazyKt.lazy(new a());
    }

    public final Object b(Continuation<? super Unit> r100) {
        if ((!((Keva) f311396b.getValue()).getBoolean("aweme_inner_push_showed_".concat(AccountService.f365697a.getUserId()), false)) == false) goto L14;
        Object r101 = a(new AwemeDoublePostInnerPushManager$showInnerPush$2(null), r100);
        if (r101 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        r101 = Unit.INSTANCE;
    L9:
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r101;
    L12:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    }

    public final Object a(Function2<? super wc9.e, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1) == false) goto L7;
        AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1 r102 = (AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (Function2) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L24:
        wc9.e r107 = (wc9.e) r104;
    L25:
        r102.L$0 = null;
        r102.label = 2;
        if (r100.invoke(r107, r102) != r105) goto L29;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        ILaunchCacheService r108 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r108 == null) goto L21;
        r107 = r108.b();
        if (r107 == null) goto L21;
        FLogger.f375446a.i("AwemeDoublePostInnerPushManager", "use lastCachedConversationInfo");
    L21:
        Flow r109 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2 r110 = new AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2(null);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = kotlinx.coroutines.flow.e.t(r109, r110, r102);
        if (r104 != r105) goto L24;
        return r105;
    L7:
        r102 = new AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1(this, r101);
        goto L8
    }
}
