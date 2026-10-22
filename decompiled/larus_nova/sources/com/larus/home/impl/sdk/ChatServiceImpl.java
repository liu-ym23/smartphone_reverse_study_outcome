package com.larus.home.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.strategy.block.ClientMetaPermissionHelper;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.home.impl.MainActivity;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class ChatServiceImpl implements com.larus.platform.api.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChatServiceImpl f346124a = null;

    static {
        f346124a = new ChatServiceImpl();
    }

    public ChatServiceImpl() {
    }

    public final Fragment f() {
        return (Fragment) HomeService.f344094a.a(null);
    }

    @Override // com.larus.platform.api.f0
    public final Fragment a(Activity r100) {
        return (Fragment) HomeService.f344094a.a(r100);
    }

    public final PendingIntent d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        int r101 = com.larus.home.impl.route.v0.f346106a;
        Intrinsics.checkNotNullParameter(r100, "messageId");
        AppHost.Companion r102 = AppHost.f326268a;
        Activity r103 = r102.a().getCurrentActivity();
        if (r103 == null) goto L5;
        Class<?> r104 = r103.getClass();
    L6:
        Intent r105 = new Intent(r102.getApplication(), r104);
        wc9.e r106 = AuthModelDelegate.f297134b.y().getValue();
        if (r106 == null) goto L9;
        String r107 = r106.f559198a;
    L10:
        r105.setData(UriProtector.parse("sslocal://scroll_to_message?target_message_id=" + r100 + "&target_cvs_id=" + r107));
        r105.setFlags(603979776);
        Application r108 = r102.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L13;
        int r109 = 201326592;
    L15:
        return PendingIntent.getActivity(r108, 107, r105, r109);
    L13:
        r109 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L15
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = MainActivity.class;
        goto L6
    }

    public final Boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return BotStatusCacheDelegate.f296446b.c(r100);
    }

    public final Boolean h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return BotStatusCacheDelegate.f296446b.b(r100);
    }

    @Override // com.larus.platform.api.f0
    public final void setScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(ObricActionBarTrackType.SPEAK, "scene");
        IAIChatControlTraceService.f365889a.Ma(r100, ObricActionBarTrackType.SPEAK);
    }

    @Override // com.larus.platform.api.f0
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r101, "cvsId");
        Intrinsics.checkNotNullParameter(ObricActionBarTrackType.SPEAK, "scene");
        if (Intrinsics.areEqual(ObricActionBarTrackType.SPEAK, ObricActionBarTrackType.SPEAK) == true) goto L5;
        IAIChatService.f365899a.m8(r100, r101);
        return;
    L5:
        if (com.larus.platform.exp.s.f365398b == false) goto L9;
        ClientMetaPermissionHelper.c();
        return;
    }

    public final Object g(String r100, Continuation<? super String> r110) {
        if ((r110 instanceof ChatServiceImpl$getChatType$1) == false) goto L7;
        ChatServiceImpl$getChatType$1 r101 = (ChatServiceImpl$getChatType$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ChatServiceImpl$getChatType$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L20:
        wc9.e r112 = (wc9.e) r111;
        if (r112 == null) goto L23;
        String r106 = ic8.n.f(r112);
    L24:
        if (r106 != null) goto L27;
        return "";
    L27:
        return r106;
    L23:
        r106 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (r100 != null) goto L17;
        return "";
    L17:
        IConversationRepoService r107 = RepoDispatcherDelegate.f307737b.f();
        r103.label = 1;
        r111 = IConversationRepoService.a.c(r107, r100, false, null, r103, 6);
        if (r111 != r104) goto L20;
        return r104;
    L7:
        r101 = new ChatServiceImpl$getChatType$1(this, r110);
        goto L8
    }

    @Override // com.larus.platform.api.f0
    public final void b(String r100, String r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r111, "vid");
        IAIChatService.f365899a.m7(r100, r101, r110, r111);
    }
}
