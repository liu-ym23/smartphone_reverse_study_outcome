package com.bytedance.android.shopping.feed.repository.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import ud3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/api/FeedbackPanelApi;", "", "", FreqActions.ACTION_VIEW, "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/feed/model/feedbackboard/e;", "getFeedbackBoard", "type", "reasonId", "promotionId", "enterFrom", "", "postGovernanceFeedback", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FeedbackPanelApi {
    public static final a a = null;

    public static final class a {
        public static final FeedbackPanelApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (FeedbackPanelApi) n.a.create(e.a(), FeedbackPanelApi.class);
        }
    }

    static {
        a = a.b;
    }

    @FormUrlEncoded
    @POST("/ecom/video/feedback_board/")
    Observable<com.bytedance.android.shopping.feed.model.feedbackboard.e> getFeedbackBoard(@Field(FreqActions.ACTION_VIEW) String r1);

    @FormUrlEncoded
    @POST("/aweme/v2/governance/feedback/")
    Observable<Unit> postGovernanceFeedback(@Field("type") String r1, @Field("reason_id") String r2, @Field(PdpOpenThirdParam.KEY_PROMOTION_ID) String r3, @Field(SimilarProductParam.ENTER_FROM) String r4);
}
