package com.larus.bmhome.music.protocol;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateApi;", "", "listMusicGenTemplate", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateData;", "request", "Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateRequest;", "(Lcom/larus/bmhome/music/protocol/ListMusicGenTemplateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ListMusicGenTemplateApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f313033a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f313034a = null;

        static {
            f313034a = new a();
        }

        public a() {
        }
    }

    static {
        f313033a = a.f313034a;
    }

    @POST("/alice/bot/list_music_gen_template")
    Object listMusicGenTemplate(@Body d r100, Continuation<? super BizResponse<c>> r101);
}
