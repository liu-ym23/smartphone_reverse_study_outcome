package com.larus.bmhome.chat.outerinput;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes25.dex */
public final class OuterChatInputController implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f308393d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f308394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f308395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OuterChatInput f308396c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.outerinput.c
    public final boolean a() {
        boolean r100 = false;
        if ((this.f308394a.getActivity() instanceof b) == false) goto L6;
        return false;
    L6:
        if (this.f308395b.length() != 0) goto L8;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        FLogger.f375446a.d("OuterChatInputController", "tab page no config");
        return false;
    L13:
        List<String> r102 = z2.f365865a.t0();
        List r103 = CollectionsKt.listOf(new String[]{"aweme_feed_dialog", "aweeme_feed_fragment", "aweme_feed_conversation"});
        FLogger r104 = FLogger.f375446a;
        r104.d("OuterChatInputController", "visibleTabList:" + r102 + ", forceVisibleTabList:" + r103);
        if (r102.contains(this.f308395b) == false) goto L16;
    L17:
        r100 = true;
    L18:
        if (r100 == true) goto L20;
        r104.d("OuterChatInputController", "no in outer chat input test");
    L20:
        return r100;
    L16:
        if (r103.contains(this.f308395b) == false) goto L18;
    L8:
        r101 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.outerinput.c
    public final void c(String r100) {
        LifecycleOwner r101 = this.f308394a.getViewLifecycleOwnerLiveData().getValue();
        if (r101 == null) goto L5;
        LifecycleCoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r101);
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (a() == false) goto L12;
        FLogger.f375446a.i("OuterChatInputController", "onRealtimeCallEntranceShow, previousPage:" + r100 + ", tabKey:" + this.f308395b);
        BuildersKt.launch$default(r102, null, null, new OuterChatInputController$onRealtimeCallEntranceShow$1(this, null), 3, null);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public OuterChatInputController(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tabPage");
        Intrinsics.checkNotNullParameter(r101, "tabKey");
        this.f308394a = r100;
        this.f308395b = r101;
    }

    public static final Object d(OuterChatInputController r100, Function2 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof OuterChatInputController$getMainBotConversationInfo$1) == false) goto L7;
        OuterChatInputController$getMainBotConversationInfo$1 r103 = (OuterChatInputController$getMainBotConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 == 1) goto L17;
        if (r107 == 2) goto L16;
        if (r107 != 3) goto L15;
        ResultKt.throwOnFailure(r105);
    L37:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r101 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L32:
        wc9.e r108 = (wc9.e) r105;
    L33:
        r103.L$0 = null;
        r103.label = 3;
        if (r101.invoke(r108, r103) != r106) goto L37;
        return r106;
    L17:
        r101 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L23:
        r108 = (wc9.e) r105;
        goto L33
    L18:
        ResultKt.throwOnFailure(r105);
        if (com.larus.platform.exp.o.a() == false) goto L24;
        LocalSubConvHelper r109 = LocalSubConvHelper.f314106a;
        String r110 = AccountService.f365697a.getSecUserId();
        r103.L$0 = r101;
        r103.label = 1;
        r105 = r109.c(r110, null, r103);
        if (r105 != r106) goto L23;
        return r106;
    L24:
        ILaunchCacheService r111 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r111 == null) goto L29;
        r108 = r111.b();
        if (r108 == null) goto L29;
        FLogger.f375446a.i("OuterChatInputController", "use lastCachedConversationInfo");
    L29:
        Flow r112 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        OuterChatInputController$getMainBotConversationInfo$cvs$2 r113 = new OuterChatInputController$getMainBotConversationInfo$cvs$2(null);
        r103.L$0 = r101;
        r103.label = 2;
        r105 = kotlinx.coroutines.flow.e.t(r112, r113, r103);
        if (r105 != r106) goto L32;
        return r106;
    L7:
        r103 = new OuterChatInputController$getMainBotConversationInfo$1(r100, r102);
        goto L8
    }

    @Override // com.larus.bmhome.chat.outerinput.c
    public final void b(String r110, FrameLayout r111, boolean r112, Function1<? super Integer, Unit> r113) {
        if (r111 != null) goto L7;
        if (r113 == null) goto L23;
        r113.invoke(0);
        return;
    L23:
        return;
    L7:
        Context r100 = this.f308394a.getContext();
        if (r100 != null) goto L10;
        return;
    L10:
        OuterChatInput r101 = new OuterChatInput(r100);
        r111.addView(r101, new FrameLayout.LayoutParams(-1, -1));
        LifecycleOwner r102 = this.f308394a.getViewLifecycleOwnerLiveData().getValue();
        if (r102 == null) goto L13;
        LifecycleCoroutineScope r103 = LifecycleOwnerKt.getLifecycleScope(r102);
    L14:
        LifecycleCoroutineScope r104 = r103;
        if (r104 != null) goto L17;
    L19:
        e1.o(r111);
        if (r113 == null) goto L25;
        r113.invoke(0);
        return;
    L25:
        return;
    L17:
        if (a() == false) goto L19;
        this.f308396c = r101;
        BuildersKt.launch$default(r104, null, null, new OuterChatInputController$setup$1(this, r111, r113, r101, r112, r110, null), 3, null);
        return;
    L13:
        r103 = null;
        goto L14
    }
}
