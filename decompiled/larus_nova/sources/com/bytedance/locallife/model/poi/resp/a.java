package com.bytedance.locallife.model.poi.resp;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR$\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00106\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\f\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R*\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0005\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u0010\tR$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010L\u001a\u0004\u0018\u00010K8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001c\u0010Q\u001a\u0004\u0018\u00010P8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010\u0016\u001a\u0004\bV\u0010\u0018¨\u0006W"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/a;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "", "Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "awemeList", "Ljava/util/List;", "getAwemeList", "()Ljava/util/List;", "setAwemeList", "(Ljava/util/List;)V", "", "hasMore", "I", "b", "()I", "setHasMore", "(I)V", "nextCursor", "d", "setNextCursor", "", "innerFeedDynamictText", "Ljava/lang/String;", "getInnerFeedDynamictText", "()Ljava/lang/String;", "setInnerFeedDynamictText", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "subTitle", "getSubTitle", "setSubTitle", "removeAwemeId", "e", "setRemoveAwemeId", "selfPubAwemeId", "getSelfPubAwemeId", "setSelfPubAwemeId", "Lcom/bytedance/locallife/model/poi/resp/PoiFeedAwemeResStruct;", "awemeRes", "Lcom/bytedance/locallife/model/poi/resp/PoiFeedAwemeResStruct;", "getAwemeRes", "()Lcom/bytedance/locallife/model/poi/resp/PoiFeedAwemeResStruct;", "Lcom/bytedance/locallife/model/poi/resp/PoiFeedFixLayerLynx;", "poiFeedFixLayer", "Lcom/bytedance/locallife/model/poi/resp/PoiFeedFixLayerLynx;", "getPoiFeedFixLayer", "()Lcom/bytedance/locallife/model/poi/resp/PoiFeedFixLayerLynx;", "Lcom/bytedance/locallife/model/poi/resp/PoiDouDiscountResStruct;", "douDiscountRes", "Lcom/bytedance/locallife/model/poi/resp/PoiDouDiscountResStruct;", "getDouDiscountRes", "()Lcom/bytedance/locallife/model/poi/resp/PoiDouDiscountResStruct;", "uiType", "getUiType", "setUiType", "Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedHead;", "poiUgcFeedHead", "Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedHead;", "getPoiUgcFeedHead", "()Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedHead;", "setPoiUgcFeedHead", "(Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedHead;)V", "Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedItem;", "items", "c", "setItems", "Lcom/bytedance/locallife/model/poi/resp/QAInfo;", "qaInfo", "Lcom/bytedance/locallife/model/poi/resp/QAInfo;", "getQaInfo", "()Lcom/bytedance/locallife/model/poi/resp/QAInfo;", "setQaInfo", "(Lcom/bytedance/locallife/model/poi/resp/QAInfo;)V", "Lcom/bytedance/locallife/model/poi/resp/TagRateSurveyInfo;", "surveyInfo", "Lcom/bytedance/locallife/model/poi/resp/TagRateSurveyInfo;", "getSurveyInfo", "()Lcom/bytedance/locallife/model/poi/resp/TagRateSurveyInfo;", "Lcom/google/gson/JsonObject;", "abParams", "Lcom/google/gson/JsonObject;", "getAbParams", "()Lcom/google/gson/JsonObject;", "toastContent", "getToastContent", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class a extends BaseResponse {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private final JsonObject abParams;

    @SerializedName("aweme_list")
    private List<SimpleAwemeInfo> awemeList;

    @SerializedName("aweme_res")
    private final PoiFeedAwemeResStruct awemeRes;

    @SerializedName("dou_discount_res")
    private final PoiDouDiscountResStruct douDiscountRes;

    @SerializedName("has_more")
    private int hasMore;

    @SerializedName("dynamic_text")
    private String innerFeedDynamictText;

    @SerializedName("items")
    private List<PoiUgcFeedItem> items;

    @SerializedName("next_cursor")
    private int nextCursor;

    @SerializedName("poi_feed_fix_layer")
    private final PoiFeedFixLayerLynx poiFeedFixLayer;

    @SerializedName("header")
    private PoiUgcFeedHead poiUgcFeedHead;

    @SerializedName("qa_info")
    private QAInfo qaInfo;

    @SerializedName("remove_aweme_id")
    private String removeAwemeId;

    @SerializedName("self_pub_aweme_id")
    private String selfPubAwemeId;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    @SerializedName("survey_info")
    private final TagRateSurveyInfo surveyInfo;

    @SerializedName("title")
    private String title;

    @SerializedName("toast_content")
    private final String toastContent;

    @SerializedName("ui_type")
    private int uiType;

    public a() {
        this.awemeList = new ArrayList();
        this.hasMore = 0;
        this.nextCursor = 0;
        this.innerFeedDynamictText = null;
        this.title = null;
        this.subTitle = null;
        this.removeAwemeId = null;
        this.selfPubAwemeId = null;
        this.awemeRes = null;
        this.poiFeedFixLayer = null;
        this.douDiscountRes = null;
        this.uiType = 0;
        this.poiUgcFeedHead = null;
        this.items = null;
        this.qaInfo = null;
        this.surveyInfo = null;
        this.abParams = null;
        this.toastContent = null;
    }

    public final List<SimpleAwemeInfo> a() {
        List<SimpleAwemeInfo> r100 = this.awemeList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public final int b() {
        return this.hasMore;
    }

    public final List<PoiUgcFeedItem> c() {
        return this.items;
    }

    public final int d() {
        return this.nextCursor;
    }

    public final String e() {
        return this.removeAwemeId;
    }
}
