package com.bytedance.android.livesdk.ktvimpl.base.api;

import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H'¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/api/KtvLinkApis;", "", "", "roomId", "anchorId", "", "anchorOpenId", "", "isOChannelRoom", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/liveinteract/plantform/model/w0;", "getLinkListV2", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface KtvLinkApis {
    @PbRequest("linkmic_audience")
    @GET("/webcast/linkmic_audience/list/v2/")
    Single<e<w0>> getLinkListV2(@Query("room_id") long r1, @Query("anchor_id") long r3, @Query("anchor_open_id") String r5, @Query("is_ochannel_room") boolean r6);
}
