package com.bytedance.android.livesdk.livead;

import com.bytedance.android.livehostapi.business.depend.livead.model.CardCommitRemoveResp;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountResp;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006H'J0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/livead/ILiveAdApi;", "", "commitCardSwitch", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCommitRemoveResp;", "url", "", "secUid", "roomId", "getCardCount", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountResp;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAdApi {
    @GET
    Observable<CardCommitRemoveResp> commitCardSwitch(@Url String r1, @Query("sec_uid") String r2, @Query("room_id") String r3);

    @GET
    Observable<CardCountResp> getCardCount(@Url String r1, @Query("sec_uid") String r2, @Query("room_id") String r3);
}
