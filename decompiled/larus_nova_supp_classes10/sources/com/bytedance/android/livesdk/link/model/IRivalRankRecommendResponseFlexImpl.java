package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\by\u0010zR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR/\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u0004\u0018\u00010'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b)\u0010*R\u001b\u0010-\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b-\u0010%R\u001d\u00102\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\r\u001a\u0004\b0\u00101R\u001d\u00107\u001a\u0004\u0018\u0001038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b5\u00106R\u001b\u0010:\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\r\u001a\u0004\b9\u0010%R\u001b\u0010?\u001a\u00020;8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\r\u001a\u0004\b=\u0010>R\u001b\u0010B\u001a\u00020;8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\r\u001a\u0004\bA\u0010>R)\u0010H\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D\u0018\u00010C8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\r\u001a\u0004\bF\u0010GR+\u0010M\u001a\u00020;2\u0006\u0010\u000b\u001a\u00020;8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\r\u001a\u0004\bJ\u0010>\"\u0004\bK\u0010LR+\u0010S\u001a\u00020D2\u0006\u0010\u000b\u001a\u00020D8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010\r\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR;\u0010[\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010T2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010T8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010\r\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR+\u0010]\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\"8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010\r\u001a\u0004\b]\u0010%\"\u0004\b^\u0010_R+\u0010c\u001a\u00020D2\u0006\u0010\u000b\u001a\u00020D8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\r\u001a\u0004\ba\u0010P\"\u0004\bb\u0010RR+\u0010j\u001a\u00020d2\u0006\u0010\u000b\u001a\u00020d8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010\r\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001b\u0010l\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\r\u001a\u0004\bl\u0010%R\u001d\u0010q\u001a\u0004\u0018\u00010m8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\r\u001a\u0004\bo\u0010pR\u001d\u0010v\u001a\u0004\u0018\u00010r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\r\u001a\u0004\bt\u0010uR\u001b\u0010x\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\r\u001a\u0004\bx\u0010%¨\u0006{"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalRankRecommendResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IRivalRankRecommendResponse;", "Lcom/bytedance/android/livesdk/link/model/m8;", "tipBar", "Lcom/bytedance/android/livesdk/link/model/m8;", "getTipBar", "()Lcom/bytedance/android/livesdk/link/model/m8;", "setTipBar", "(Lcom/bytedance/android/livesdk/link/model/m8;)V", "Lcom/bytedance/android/livesdk/link/model/s2;", "<set-?>", "tabRivals$delegate", "Ljava/lang/Object;", "getTabRivals", "()Lcom/bytedance/android/livesdk/link/model/s2;", "setTabRivals", "(Lcom/bytedance/android/livesdk/link/model/s2;)V", "tabRivals", "Lcom/bytedance/android/livesdk/link/model/IRecommendSearchBarFlexImpl;", "searchBar$delegate", "getSearchBar", "()Lcom/bytedance/android/livesdk/link/model/IRecommendSearchBarFlexImpl;", "searchBar", "", "skinType$delegate", "getSkinType", "()I", "skinType", "Lcom/bytedance/android/livesdk/link/model/ITopTipFlexImpl;", "topTip$delegate", "getTopTip", "()Lcom/bytedance/android/livesdk/link/model/ITopTipFlexImpl;", "topTip", "", "acceptPrecisionMatch$delegate", "getAcceptPrecisionMatch", "()Z", "acceptPrecisionMatch", "Lcom/bytedance/android/livesdk/link/model/IPanelBannerFlexImpl;", "panelBanner$delegate", "getPanelBanner", "()Lcom/bytedance/android/livesdk/link/model/IPanelBannerFlexImpl;", "panelBanner", "isNewAnchor$delegate", "isNewAnchor", "Lcom/bytedance/android/livesdk/link/model/IPkCommonBannerFlexImpl;", "commonBanner$delegate", "getCommonBanner", "()Lcom/bytedance/android/livesdk/link/model/IPkCommonBannerFlexImpl;", "commonBanner", "Lcom/bytedance/android/livesdk/link/model/IRecommendAutoMatchInfoFlexImpl;", "autoMatchInfo$delegate", "getAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/IRecommendAutoMatchInfoFlexImpl;", "autoMatchInfo", "displayMultiMatch$delegate", "getDisplayMultiMatch", "displayMultiMatch", "", "tabLocate$delegate", "getTabLocate", "()J", "tabLocate", "durationTime$delegate", "getDurationTime", "durationTime", "", "", "listAbValueMap$delegate", "getListAbValueMap", "()Ljava/util/Map;", "listAbValueMap", "loadType$delegate", "getLoadType", "setLoadType", "(J)V", "loadType", "multiBrawlInfo$delegate", "getMultiBrawlInfo", "()Ljava/lang/String;", "setMultiBrawlInfo", "(Ljava/lang/String;)V", "multiBrawlInfo", "", "Lcom/bytedance/android/livesdk/link/model/y7;", "subTabs$delegate", "getSubTabs", "()Ljava/util/List;", "setSubTabs", "(Ljava/util/List;)V", "subTabs", "isNewPkAnchor$delegate", "isNewPkAnchor", "setNewPkAnchor", "(Z)V", "pkSeasonInfo$delegate", "getPkSeasonInfo", "setPkSeasonInfo", "pkSeasonInfo", "Lcom/bytedance/android/livesdk/link/model/u8;", "rivalsExtra$delegate", "getRivalsExtra", "()Lcom/bytedance/android/livesdk/link/model/u8;", "setRivalsExtra", "(Lcom/bytedance/android/livesdk/link/model/u8;)V", "rivalsExtra", "isUnReadReserveRecord$delegate", "isUnReadReserveRecord", "Lcom/bytedance/android/livesdk/link/model/IRivalRankSeasonInfoFlexImpl;", "rankSeasonInfo$delegate", "getRankSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalRankSeasonInfoFlexImpl;", "rankSeasonInfo", "Lcom/bytedance/android/livesdk/link/model/IRivalPopInfoFlexImpl;", "popInfo$delegate", "getPopInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalPopInfoFlexImpl;", "popInfo", "isOpenAutoFindPeople$delegate", "isOpenAutoFindPeople", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRivalRankRecommendResponseFlexImpl extends FlexModelBase<IRivalRankRecommendResponse> implements IRivalRankRecommendResponse, vh7.h {

    @SerializedName("accept_precision_match")
    protected boolean _$$acceptPrecisionMatch;

    @SerializedName("match_info")
    protected IRecommendAutoMatchInfoFlexImpl _$$autoMatchInfo;

    @SerializedName("common_banner")
    protected IPkCommonBannerFlexImpl _$$commonBanner;

    @SerializedName("display_multi_match")
    protected boolean _$$displayMultiMatch;

    @SerializedName("duration_time")
    protected long _$$durationTime;

    @SerializedName("is_new_anchor")
    protected boolean _$$isNewAnchor;

    @SerializedName("is_new_pk_anchor")
    protected boolean _$$isNewPkAnchor;

    @SerializedName("is_open_auto_start_find_people")
    protected boolean _$$isOpenAutoFindPeople;

    @SerializedName("is_unread_reserve_record")
    protected boolean _$$isUnReadReserveRecord;

    @SerializedName("ab_test_value_map")
    protected Map<String, String> _$$listAbValueMap;

    @SerializedName("load_type")
    protected long _$$loadType;

    @SerializedName("multi_brawl_info")
    protected String _$$multiBrawlInfo;

    @SerializedName("panel_banner")
    protected IPanelBannerFlexImpl _$$panelBanner;

    @SerializedName("pk_season_info")
    protected String _$$pkSeasonInfo;

    @SerializedName("popup_info")
    protected IRivalPopInfoFlexImpl _$$popInfo;

    @SerializedName("rank_season_info")
    protected IRivalRankSeasonInfoFlexImpl _$$rankSeasonInfo;

    @SerializedName("rivals_extra")
    protected u8 _$$rivalsExtra;

    @SerializedName("search_bar")
    protected IRecommendSearchBarFlexImpl _$$searchBar;

    @SerializedName("skin_type")
    protected int _$$skinType;

    @SerializedName("pk_sub_tabs")
    protected List<? extends y7> _$$subTabs;

    @SerializedName("tab_locate")
    protected long _$$tabLocate;

    @SerializedName("rivals")
    protected s2 _$$tabRivals;

    @SerializedName("top_tip")
    protected ITopTipFlexImpl _$$topTip;

    @SerializedName("tip_bar")
    protected m8 tipBar;

    public IRivalRankRecommendResponseFlexImpl() {
        super(IRivalRankRecommendResponse.class);
        this._$$acceptPrecisionMatch = false;
        this._$$isNewAnchor = false;
        this._$$displayMultiMatch = false;
        this._$$multiBrawlInfo = "";
        this._$$isNewPkAnchor = false;
        this._$$pkSeasonInfo = "";
        this._$$rivalsExtra = $defaultValue_rivalsExtra$();
        this._$$isUnReadReserveRecord = false;
        this._$$isOpenAutoFindPeople = false;
    }

    public final u8 $defaultValue_rivalsExtra$() {
        return (u8) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(u8.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public /* bridge */ /* synthetic */ j8 getAutoMatchInfo() {
        return getAutoMatchInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public /* bridge */ /* synthetic */ v7 getCommonBanner() {
        return getCommonBanner();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public /* bridge */ /* synthetic */ n7 getPanelBanner() {
        return getPanelBanner();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public /* bridge */ /* synthetic */ r8 getPopInfo() {
        return getPopInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public /* bridge */ /* synthetic */ s8 getRankSeasonInfo() {
        return getRankSeasonInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public /* bridge */ /* synthetic */ l8 getSearchBar() {
        return getSearchBar();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public /* bridge */ /* synthetic */ ITopTip getTopTip() {
        return getTopTip();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final boolean getAcceptPrecisionMatch() {
        return this._$$acceptPrecisionMatch;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final boolean getDisplayMultiMatch() {
        return this._$$displayMultiMatch;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final long getDurationTime() {
        return this._$$durationTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final Map<String, String> getListAbValueMap() {
        return this._$$listAbValueMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final long getLoadType() {
        return this._$$loadType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final String getMultiBrawlInfo() {
        return this._$$multiBrawlInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final String getPkSeasonInfo() {
        return this._$$pkSeasonInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final u8 getRivalsExtra() {
        return this._$$rivalsExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final int getSkinType() {
        return this._$$skinType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final List<y7> getSubTabs() {
        return this._$$subTabs;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final long getTabLocate() {
        return this._$$tabLocate;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final s2 getTabRivals() {
        return this._$$tabRivals;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public m8 getTipBar() {
        return this.tipBar;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final boolean isNewAnchor() {
        return this._$$isNewAnchor;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final boolean isNewPkAnchor() {
        return this._$$isNewPkAnchor;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final boolean isOpenAutoFindPeople() {
        return this._$$isOpenAutoFindPeople;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final boolean isUnReadReserveRecord() {
        return this._$$isUnReadReserveRecord;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final IRecommendAutoMatchInfoFlexImpl getAutoMatchInfo() {
        return this._$$autoMatchInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final IPkCommonBannerFlexImpl getCommonBanner() {
        return this._$$commonBanner;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final IPanelBannerFlexImpl getPanelBanner() {
        return this._$$panelBanner;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final IRivalPopInfoFlexImpl getPopInfo() {
        return this._$$popInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final IRivalRankSeasonInfoFlexImpl getRankSeasonInfo() {
        return this._$$rankSeasonInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final IRecommendSearchBarFlexImpl getSearchBar() {
        return this._$$searchBar;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final ITopTipFlexImpl getTopTip() {
        return this._$$topTip;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.livesdk.link.model.s2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v25, types: [com.bytedance.android.livesdk.link.model.u8, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.android.livesdk.link.model.m8, java.lang.Object] */
    public IRivalRankRecommendResponseFlexImpl(am3.g r13) {
        super(IRivalRankRecommendResponse.class);
        this._$$listAbValueMap = new HashMap();
        this._$$subTabs = new ArrayList();
        setThreadSafe(false);
        long r1 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L48;
        am3.g.a r7 = decodeExtensionFields(r4, r13);
        switch(r4) {
            case 1: goto L47;
            case 2: goto L7;
            case 3: goto L46;
            case 4: goto L45;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L7;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L40;
            case 16: goto L39;
            case 17: goto L38;
            case 18: goto L37;
            case 19: goto L36;
            case 20: goto L35;
            case 21: goto L7;
            case 22: goto L18;
            case 23: goto L17;
            case 24: goto L16;
            case 25: goto L15;
            case 26: goto L14;
            case 27: goto L13;
            case 28: goto L12;
            case 29: goto L7;
            case 30: goto L11;
            case 31: goto L10;
            case 32: goto L9;
            case 33: goto L8;
            default: goto L7;
        };
    L8:
        this._$$isOpenAutoFindPeople = am3.h.a(r13);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
        goto L3
    L9:
        this._$$popInfo = new IRivalPopInfoFlexImpl(r13);
        goto L3
    L10:
        this._$$rankSeasonInfo = new IRivalRankSeasonInfoFlexImpl(r13);
        goto L3
    L11:
        this._$$isUnReadReserveRecord = am3.h.a(r13);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
        goto L3
    L12:
        this._$$pkSeasonInfo = am3.h.c(r13);
        goto L3
    L13:
        this._$$rivalsExtra = vh7.f.a(r13, u8.class);
        goto L3
    L14:
        this._$$subTabs.add(vh7.f.a(r13, y7.class));
        goto L3
    L15:
        this._$$isNewPkAnchor = am3.h.a(r13);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        goto L3
    L16:
        this._$$multiBrawlInfo = am3.h.c(r13);
        goto L3
    L17:
        this._$$loadType = r13.j();
        r3 = r3 | 64;
        goto L3
    L18:
        long r8 = r13.c();
        String r5 = null;
        String r9 = null;
    L19:
        int r10 = r13.f();
        if (r10 == (-1)) goto L27;
        if (r10 != 1) goto L23;
        r5 = am3.h.c(r13);
        goto L19
    L23:
        if (r10 != 2) goto L24;
        r9 = am3.h.c(r13);
        goto L19
    L24:
        am3.h.e(r13);
        goto L19
    L27:
        r13.d(r8);
        Map<String, String> r6 = this._$$listAbValueMap;
        if (r5 == null) goto L34;
        if (r9 == null) goto L32;
        r6.put(r5, r9);
        goto L3
    L32:
        throw new IllegalStateException("Value must not be null");
    L34:
        throw new IllegalStateException("Key must not be null");
    L35:
        this._$$durationTime = r13.j();
        r3 = r3 | 32;
        goto L3
    L36:
        this._$$tabLocate = r13.j();
        r3 = r3 | 16;
        goto L3
    L37:
        this._$$displayMultiMatch = am3.h.a(r13);
        r3 = r3 | 8;
        goto L3
    L38:
        this._$$autoMatchInfo = new IRecommendAutoMatchInfoFlexImpl(r13);
        goto L3
    L39:
        this._$$commonBanner = new IPkCommonBannerFlexImpl(r13);
        goto L3
    L40:
        this._$$isNewAnchor = am3.h.a(r13);
        r3 = r3 | 4;
        goto L3
    L41:
        this._$$panelBanner = new IPanelBannerFlexImpl(r13);
        goto L3
    L42:
        this._$$acceptPrecisionMatch = am3.h.a(r13);
        r3 = r3 | 2;
        goto L3
    L43:
        this._$$topTip = new ITopTipFlexImpl(r13);
        goto L3
    L44:
        this._$$skinType = r13.i();
        r3 = r3 | 1;
        goto L3
    L45:
        this.tipBar = vh7.f.a(r13, m8.class);
        goto L3
    L46:
        this._$$searchBar = new IRecommendSearchBarFlexImpl(r13);
        goto L3
    L47:
        this._$$tabRivals = vh7.f.a(r13, s2.class);
        goto L3
    L7:
        am3.h.d(r7, r13);
        goto L3
    L48:
        r13.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L52;
        this._$$acceptPrecisionMatch = false;
    L52:
        if ((r3 & 4) != 0) goto L55;
        this._$$isNewAnchor = false;
    L55:
        if ((r3 & 8) != 0) goto L58;
        this._$$displayMultiMatch = false;
    L58:
        if (this._$$multiBrawlInfo != null) goto L61;
        this._$$multiBrawlInfo = "";
    L61:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L64;
        this._$$isNewPkAnchor = false;
    L64:
        if (this._$$pkSeasonInfo != null) goto L67;
        this._$$pkSeasonInfo = "";
    L67:
        if (this._$$rivalsExtra != null) goto L70;
        this._$$rivalsExtra = $defaultValue_rivalsExtra$();
    L70:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L73;
        this._$$isUnReadReserveRecord = false;
    L73:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L139;
        this._$$isOpenAutoFindPeople = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final void setLoadType(long r1) {
        this._$$loadType = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final void setMultiBrawlInfo(String r1) {
        this._$$multiBrawlInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final void setNewPkAnchor(boolean r1) {
        this._$$isNewPkAnchor = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final void setPkSeasonInfo(String r1) {
        this._$$pkSeasonInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final void setRivalsExtra(u8 r1) {
        this._$$rivalsExtra = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final void setSubTabs(List<? extends y7> r1) {
        this._$$subTabs = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse
    public final void setTabRivals(s2 r1) {
        this._$$tabRivals = r1;
    }

    public void setTipBar(m8 r1) {
        this.tipBar = r1;
    }
}
