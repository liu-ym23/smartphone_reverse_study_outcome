package com.larus.share.impl;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.share.service.IShareShortUrlCreateService;
import com.larus.share.service.ShareShortUrlCreateResponse;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/share/impl/ShareShortUrlCreateServiceImpl;", "Lcom/larus/share/service/IShareShortUrlCreateService;", "<init>", "()V", "createShortUrls", "Lcom/larus/network/http/Async;", "Lcom/larus/share/service/ShareShortUrlCreateResponse;", "longUrls", "", "", "fallbackToLongUrl", "", "shareRecord", "Lorg/json/JSONObject;", "(Ljava/util/List;ZLorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareShortUrlCreateServiceImpl implements IShareShortUrlCreateService {

    public static final class a {
    }

    static {
    }

    public ShareShortUrlCreateServiceImpl() {
    }

    @Override // com.larus.share.service.IShareShortUrlCreateService
    public final Object a(List<String> r110, boolean r111, JSONObject r112, Continuation<? super com.larus.network.http.a<ShareShortUrlCreateResponse>> r113) {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r110.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.put((String) r102.next());
        goto L4
    L6:
        Unit r103 = Unit.INSTANCE;
        r100.put("long_urls", r101);
        r100.put("fallback_to_long_url", r111);
        if (r112 == null) goto L10;
        r100.put("share_record", r112);
    L10:
        return HttpExtKt.k(ServiceType.BASIC_SERVICE, ShareShortUrlCreateResponse.class, "/commercial/short_url/create", r100, null, null, true, null, null, null, r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
    }
}
