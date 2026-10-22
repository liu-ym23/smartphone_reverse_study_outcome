package com.larus.podcast.api;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class PodcastGenerateApiKt {
    public static final Object a(String r110, boolean r111, PodcastClickSource r112, String r113, Continuation<? super com.larus.network.http.a<a>> r114) {
        if ((r114 instanceof PodcastGenerateApiKt$generatePodcast$1) == false) goto L7;
        PodcastGenerateApiKt$generatePodcast$1 r100 = (PodcastGenerateApiKt$generatePodcast$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PodcastGenerateApiKt$generatePodcast$1 r115 = r100;
        Object r102 = r115.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r115.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L21:
        return (com.larus.network.http.a) r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r105 = new JSONObject();
        r105.put("resource_id", r110);
        r105.put("need_fullscreen_player", r111);
        r105.put("click_source", r112.getValue());
        if (r113 == null) goto L17;
        r105.put("conversation_id", r113);
    L17:
        Unit r106 = Unit.INSTANCE;
        r115.label = 1;
        r102 = HttpExtKt.k(ServiceType.AUDIO, a.class, "/chat/podcast/generate", r105, null, null, false, null, null, null, r115, 1008);
        if (r102 != r103) goto L21;
        return r103;
    L7:
        r100 = new PodcastGenerateApiKt$generatePodcast$1(r114);
        goto L8
    }
}
