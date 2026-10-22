package com.larus.bmhome.music.protocol;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.stream.JsonReader;
import com.larus.bmhome.chat.resp.MessageList;
import com.larus.bmhome.music.widget.n2;
import com.larus.im.bean.IMMsg;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.LyricsUtterances;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class MusicPullingApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MusicPullingApi f313037a = null;

    static {
        f313037a = new MusicPullingApi();
    }

    public MusicPullingApi() {
    }

    public static Pair a(MusicCreationContent r100) {
        if (TextUtils.isEmpty(r100.getLyricsSeekContent()) == false) goto L5;
        return null;
    L5:
        JsonReader r101 = new JsonReader(new StringReader(r100.getLyricsSeekContent()));
        boolean r102 = true;
        r101.setLenient(true);
        LyricsSeekContent r103 = (LyricsSeekContent) GsonProtectorUtils.fromJson(HttpExtKt.f360123f, r101, LyricsSeekContent.class);
        if (TextUtils.isEmpty(r100.getVid()) == true) goto L18;
        if (r103 == null) goto L13;
        List<LyricsUtterances> r104 = r103.getUtterances();
        if (r104 == null) goto L13;
        if (r104.isEmpty() == true) goto L13;
    L14:
        if (r102 == false) goto L18;
        return TuplesKt.to(r100, r103);
    L13:
        r102 = false;
    L18:
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008d -> B:25:0x0094). Please report as a decompilation issue!!! */
    public final Object b(Message r110, String r210, int r211, Continuation<? super Pair<? extends MusicCreationContent, LyricsSeekContent>> r212) {
        if ((r212 instanceof MusicPullingApi$pullMusicStateTillCanPlay$1) == false) goto L7;
        MusicPullingApi$pullMusicStateTillCanPlay$1 r100 = (MusicPullingApi$pullMusicStateTillCanPlay$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        String r106 = "MusicPlayerDetailFragment";
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r107 = r100.I$0;
        String r108 = (String) r100.L$1;
        Message r109 = (Message) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r111 = r103;
        int r112 = r107;
        MusicPullingApi$pullMusicStateTillCanPlay$1 r113 = r100;
        String r114 = r108;
    L25:
        dm9.a r115 = (dm9.a) r102;
        if ((r115 instanceof dm9.a.b) == false) goto L88;
        dm9.a.b r116 = (dm9.a.b) r115;
        MessageList r117 = (MessageList) r116.f469231a.getData();
        if (r117 == null) goto L90;
        List<IMMsg> r118 = r117.getMessageList();
        if (r118 == null) goto L90;
        List r119 = CollectionsKt.filterNotNull(r118);
        if (r119 == null) goto L90;
        IMMsg r120 = (IMMsg) CollectionsKt.firstOrNull(r119);
        if (r120 == null) goto L90;
        FLogger r121 = FLogger.f375446a;
        r121.i(r106, "[fetchMessageListForMusic] isSuccess=" + r116.f469231a.isSuccess() + ", content=" + r120.a());
        Integer r122 = r120.b();
        String r123 = "";
        if (r122 != null) goto L39;
    L51:
        if (r122 != null) goto L54;
    L71:
        if (r122 != null) goto L74;
    L86:
        r121.e(r106, "[MusicPullingApi] e: fault content type un noticed");
        goto L90
    L74:
        if (r122.intValue() != 9999) goto L86;
        MusicCreationContentList r124 = n2.a(r120.a());
        if (r124 == null) goto L90;
        Map<String, MusicCreationContent> r125 = r124.getContentMap();
        if (r125 == null) goto L90;
        MusicCreationContent r126 = r125.get(r114);
        if (r126 == null) goto L90;
        Pair r127 = a(r126);
        if (r127 == null) goto L90;
        r121.e(r106, "[MusicPullingApi] fetched match with vid " + r126.getVid() + ' ');
        return r127;
    L54:
        if (r122.intValue() != 72) goto L71;
        String r128 = r120.i();
        if (r128 != null) goto L58;
        r128 = "";
    L58:
        String r129 = r120.a();
        if (r129 == null) goto L62;
        r123 = r129;
    L62:
        Map<String, MusicCreationContent> r130 = a.b(r128, r123).getContentMap();
        if (r130 == null) goto L90;
        MusicCreationContent r131 = r130.get(r114);
        if (r131 == null) goto L90;
        Pair r132 = a(r131);
        if (r132 == null) goto L90;
        r121.e(r106, "[MusicPullingApi] fetched match with vid " + r131.getVid() + ' ');
        return r132;
    L39:
        if (r122.intValue() != 70) goto L51;
        MusicCreationContent.b r133 = MusicCreationContent.Companion;
        String r134 = r120.a();
        if (r134 == null) goto L44;
        r123 = r134;
    L44:
        Function1 r135 = new i();
        r133.getClass();
        MusicCreationContent r136 = MusicCreationContent.b.a(r123, r135);
        if (r136 == null) goto L90;
        Pair r137 = a(r136);
        if (r137 == null) goto L90;
        r121.e(r106, "[MusicPullingApi] fetched match with vid " + r136.getVid() + ' ');
        return r137;
    L90:
        String r138 = r106;
        Message r139 = r109;
        r105 = 1;
    L19:
        int r140 = r112 - 1;
        if (r112 <= 0) goto L91;
        MusicMessageFetchApi.a r141 = MusicMessageFetchApi.f313035a;
        MusicPullingApi$pullMusicStateTillCanPlay$result$1 r142 = new MusicPullingApi$pullMusicStateTillCanPlay$result$1(r139, null);
        r113.L$0 = r139;
        r113.L$1 = r114;
        r113.I$0 = r140;
        r113.label = r105;
        r141.getClass();
        FlowHttpConnection r143 = FlowHttpConnection.f359975a;
        Object r144 = r111;
        Object r145 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, MusicMessageFetchApi.class, r142, false, null, null, null, r113, 248);
        if (r145 != r144) goto L24;
        return r144;
    L24:
        r109 = r139;
        r102 = r145;
        r111 = r144;
        r106 = r138;
        r112 = r140;
        goto L25
    L91:
        return null;
    L88:
        if ((r115 instanceof dm9.a.C5690a) == false) goto L90;
        FLogger.f375446a.e(r106, "[MusicPullingApi] e:" + ((dm9.a.C5690a) r115).f469230c);
        goto L90
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r110 != null) goto L18;
        FLogger.f375446a.i("MusicPlayerDetailFragment", "[MusicPullingApi] lyrics binding message is null");
        return null;
    L18:
        r139 = r110;
        r113 = r100;
        r111 = r103;
        r138 = "MusicPlayerDetailFragment";
        r114 = r210;
        r112 = r211;
    L7:
        r100 = new MusicPullingApi$pullMusicStateTillCanPlay$1(this, r212);
        goto L8
    }
}
