package com.larus.bmhome.banner;

import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/banner/BannerApi;", "", "getNoticeBanner", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/banner/BannerResponse;", "pageType", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "banner_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BannerApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f295881a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f295882a = null;

        static {
            f295882a = new a();
        }

        public a() {
        }

        public static Object a(int r110, DowngradeSource r111, Continuation r112) {
            FlowDowngradeServiceDelegate r100 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r101 = new JSONObject();
            r101.put("page_type", r110);
            Unit r113 = Unit.INSTANCE;
            if (r111 == null) goto L5;
            Map r114 = MapsKt.mapOf(TuplesKt.to("source", r111.getValue()));
        L7:
            return IFlowDowngradeService.a.b(r100, ServiceType.BASIC_SERVICE, BannerResponse.class, "/alice/notice/banner", r101, null, true, null, r114, r112, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        L5:
            r114 = null;
            goto L7
        }
    }

    static {
        f295881a = a.f295882a;
    }

    @POST("/alice/notice/banner")
    Object getNoticeBanner(@Query("page_type") int r100, Continuation<? super BizResponse<BannerResponse>> r101);
}
