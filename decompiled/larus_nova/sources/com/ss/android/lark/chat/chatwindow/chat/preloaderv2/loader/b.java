package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import q3b.n;
import w3b.d;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements c<w3b.b, ChatMessageResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f413501a;

    public static final class a {
    }

    static {
    }

    @Inject
    public b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "messageService");
        this.f413501a = r100;
    }

    public static void c(MessageFetchScene r100, List r101) {
        Log.i("ChatWindowDataPreLoaderV2", "print first page data begin, scene:" + r100.getDesc() + ", count:" + r101.size());
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Log.i("ChatWindowDataPreLoaderV2", "load message:" + ((MessageInfo) r102.next()).getMessage());
        goto L4
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c
    public final Object a(d r110, Continuation<? super Result<? extends ChatMessageResponse>> r210) {
        w3b.b r100 = (w3b.b) r110;
        String r101 = r100.f558216a;
        int r102 = r100.f558217b;
        if (r102 < 0) goto L5;
        MessageFetchScene r103 = MessageFetchScene.SPECIFIED_POSITION;
    L7:
        if (r102 < 0) goto L9;
        boolean r104 = true;
    L10:
        b(r101, true, r104);
        if (r104 == false) goto L13;
        ChannelDataFetcherStrategy r105 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
    L14:
        PerfLog.start("syncPullChatMessages", "");
        com.ss.android.lark.im.sdk.service.a.C5036a r111 = new com.ss.android.lark.im.sdk.service.a.C5036a();
        r111.a(r101);
        r111.b(r103);
        r111.f426071c = r102;
        r111.f426072d = 15;
        r111.f426073e = 5;
        r111.f426074f = 30;
        r111.f426075g = true;
        r111.c(r105);
        Intrinsics.checkNotNullParameter("", "contextId");
        r111.f426077i = "";
        ChatMessageResponse r106 = this.f413501a.x2(new com.ss.android.lark.im.sdk.service.a(r111));
        PerfLog.end("syncPullChatMessages", "");
        if (r106 == null) goto L41;
        boolean r112 = CollectionUtils.isNotEmpty(r106.missingPositions);
        String r113 = "ChatWindowDataPreLoaderV2";
        ErrorResult r114 = null;
        if (CollectionUtils.isNotEmpty(r106.messageInfoList) == true) goto L24;
        if (r112 == false) goto L24;
        if (r104 == true) goto L24;
        Log.i("ChatWindowDataPreLoaderV2", "local data is empty, reload from net");
        PerfLog.start("syncPullNetMessages", "");
        r105 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
        com.ss.android.lark.im.sdk.service.a.C5036a r107 = new com.ss.android.lark.im.sdk.service.a.C5036a();
        r107.a(r101);
        r107.b(r103);
        r107.f426071c = r102;
        r107.f426072d = 15;
        r107.f426073e = 5;
        r107.f426074f = 30;
        r107.f426075g = true;
        r107.c(r105);
        Intrinsics.checkNotNullParameter("", "contextId");
        r107.f426077i = "";
        ChatMessageResponse r108 = this.f413501a.x2(new com.ss.android.lark.im.sdk.service.a(r107));
        PerfLog.end("syncPullNetMessages", "");
        if (r108 != null) goto L23;
        r106 = r108;
        r114 = new ErrorResult("preload data failed, task is：" + r100.a());
    L25:
        if (r106 != null) goto L27;
    L39:
        if (r106 == null) goto L42;
        n.g(r106.messageInfoList);
        ChatCoreModule.a().getPerfEnterChatMonitor().b(r106.sdkCost, r106.clientDataCost, r106.netCosts);
    L42:
        b(r101, false, r104);
        if (r114 != null) goto L46;
        if (r106 == null) goto L46;
        return Result.m9449constructorimpl(r106);
    L46:
        if (r114 != null) goto L48;
        r114 = new ErrorResult("preload data failed, task is：" + r100.a());
    L48:
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(r114));
    L27:
        if ((!r106.mFoldIntervals.isEmpty()) == false) goto L39;
        Log.i("ChatWindowDataPreLoaderV2", "response has fold messages, try to load pre page");
        Iterator<Pair<Integer, Integer>> r115 = r106.mFoldIntervals.iterator();
        int r116 = Integer.MAX_VALUE;
    L30:
        if (r115.hasNext() == false) goto L32;
        r116 = (int) Math.min(((Number) r115.next().first).intValue(), r116);
        r115 = r115;
        r113 = r113;
        goto L30
    L32:
        String r117 = r113;
        if ((!r106.messageInfoList.isEmpty()) == false) goto L35;
        r116 = (int) Math.min(((MessageInfo) ListProtector.get(r106.messageInfoList, 0)).getMessage().getPosition(), r116);
    L35:
        int r118 = (int) Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, r116);
        Log.i(r117, "load prePage message, start position is minPos");
        PerfLog.start("syncPullNetMessages", "load prePage");
        com.ss.android.lark.im.sdk.service.a.C5036a r119 = new com.ss.android.lark.im.sdk.service.a.C5036a();
        r119.a(r101);
        r119.b(MessageFetchScene.PREVIOUS_PAGE);
        r119.f426071c = r118;
        r119.f426072d = 15;
        r119.f426073e = 0;
        r119.f426074f = 0;
        r119.f426075g = true;
        r119.c(r105);
        Intrinsics.checkNotNullParameter("", "contextId");
        r119.f426077i = "";
        ChatMessageResponse r120 = this.f413501a.x2(new com.ss.android.lark.im.sdk.service.a(r119));
        if (r120 == null) goto L38;
        r106.messageInfoList.addAll(0, r120.messageInfoList);
        Log.i(r117, "load pre page , miss position is " + r120.missingPositions);
        r106.missingPositions.addAll(r120.missingPositions);
    L38:
        PerfLog.end("syncPullNetMessages", "load prePage");
        goto L39
    L23:
        c(r103, r108.messageInfoList);
        r106 = r108;
    L24:
        c(r103, r106.messageInfoList);
        goto L25
    L41:
        r114 = new ErrorResult("preload data failed, task is：" + r100.a());
        goto L42
    L13:
        r105 = ChannelDataFetcherStrategy.RETURN_LOCAL_DATA;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = MessageFetchScene.FIRST_SCREEN;
        goto L7
    }

    public static void b(String r100, boolean r101, boolean r102) {
        if (r102 == false) goto L6;
        if (r101 == false) goto L5;
        ChatCoreModule.a().getPerfEnterChatMonitor().o(r100, com.ss.android.lark.sdk.a.a());
    L9:
        String r103 = "viaNetwork";
        if (r101 == false) goto L17;
        if (r102 == true) goto L15;
        r103 = "viaLocal";
    L15:
        PerfLog.start("chat_loadData_".concat(r103), "");
    L21:
        ChatCoreModule.a().getPerfEnterChatMonitor().n();
        return;
    L17:
        if (r102 == true) goto L20;
        r103 = "viaLocal";
    L20:
        PerfLog.end("chat_loadData_".concat(r103), "");
        goto L21
    L5:
        ChatCoreModule.a().getPerfEnterChatMonitor().s();
        goto L9
    L6:
        if (r101 == false) goto L8;
        ChatCoreModule.a().getPerfEnterChatMonitor().p(r100);
        goto L9
    L8:
        ChatCoreModule.a().getPerfEnterChatMonitor().m();
        goto L9
    }
}
