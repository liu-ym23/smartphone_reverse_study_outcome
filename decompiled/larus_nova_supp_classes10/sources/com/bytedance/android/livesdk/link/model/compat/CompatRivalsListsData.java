package com.bytedance.android.livesdk.link.model.compat;

import am3.g;
import com.bytedance.android.livesdk.link.model.IAnchorTopTips;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.a0;
import com.bytedance.android.livesdk.link.model.q8;
import com.bytedance.android.livesdk.link.model.r2;
import com.bytedance.android.livesdk.link.model.w8;
import com.bytedance.android.livesdk.link.model.y8;
import com.bytedance.android.livesdk.link.model.z8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bP\u0010QR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020 8\u0016X\u0097D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\u00020/8\u0016X\u0097D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R(\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000204\u0018\u00010\u00148\u0016X\u0097\u0004¢\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001aR(\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000204\u0018\u00010\u00148\u0016X\u0097\u0004¢\u0006\f\n\u0004\b7\u0010\u0018\u001a\u0004\b8\u0010\u001aR\u001c\u0010:\u001a\u0004\u0018\u0001098\u0016X\u0097\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010?\u001a\u0004\u0018\u00010>8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u00158\u0016X\u0097D¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020G8\u0016X\u0097D¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u00158\u0016X\u0097D¢\u0006\f\n\u0004\bL\u0010D\u001a\u0004\bM\u0010FR\u001a\u0010N\u001a\u00020 8\u0016X\u0097D¢\u0006\f\n\u0004\bN\u0010\"\u001a\u0004\bO\u0010$¨\u0006R"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/compat/CompatRivalsListsData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w8;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "followedList", "Ljava/util/List;", "getFollowedList", "()Ljava/util/List;", "setFollowedList", "(Ljava/util/List;)V", "sortedFollowedList", "getSortedFollowedList", "setSortedFollowedList", "recentList", "getRecentList", "setRecentList", "recommendList", "getRecommendList", "setRecommendList", "", "", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "rivalExtraInfos", "Ljava/util/Map;", "getRivalExtraInfos", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdk/link/model/a0;", "autoMatchBanner", "Lcom/bytedance/android/livesdk/link/model/a0;", "getAutoMatchBanner", "()Lcom/bytedance/android/livesdk/link/model/a0;", "", "tips", "Ljava/lang/String;", "getTips", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/link/model/y8;", "searchBar", "Lcom/bytedance/android/livesdk/link/model/y8;", "getSearchBar", "()Lcom/bytedance/android/livesdk/link/model/y8;", "Lcom/bytedance/android/livesdk/link/model/z8;", "tipBar", "Lcom/bytedance/android/livesdk/link/model/z8;", "getTipBar", "()Lcom/bytedance/android/livesdk/link/model/z8;", "", "skinType", "I", "getSkinType", "()I", "Lcom/bytedance/android/livesdk/link/model/r2;", "room2Tags", "getRoom2Tags", "tagsMap", "getTagsMap", "Lcom/bytedance/android/livesdk/link/model/q8;", "activityData", "Lcom/bytedance/android/livesdk/link/model/q8;", "getActivityData", "()Lcom/bytedance/android/livesdk/link/model/q8;", "Lcom/bytedance/android/livesdk/link/model/IAnchorTopTips;", "anchorTopTips", "Lcom/bytedance/android/livesdk/link/model/IAnchorTopTips;", "getAnchorTopTips", "()Lcom/bytedance/android/livesdk/link/model/IAnchorTopTips;", "tabLocate", "J", "getTabLocate", "()J", "", "pkAvailable", "Z", "getPkAvailable", "()Z", "durationTime", "getDurationTime", "followedListGroupName", "getFollowedListGroupName", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CompatRivalsListsData extends FlexModelBase<w8> implements w8, h {

    @SerializedName("activity_data")
    protected q8 activityData;

    @SerializedName("top_tips")
    protected IAnchorTopTips anchorTopTips;

    @SerializedName("auto_match_banner")
    protected a0 autoMatchBanner;

    @SerializedName("duration_time")
    protected long durationTime;

    @SerializedName("followed_list")
    protected List<? extends IRoom> followedList;

    @SerializedName("followedlist_group_name")
    protected String followedListGroupName;

    @SerializedName("pk_available")
    protected boolean pkAvailable;

    @SerializedName("recent_list")
    protected List<? extends IRoom> recentList;

    @SerializedName("recommend_list")
    protected List<? extends IRoom> recommendList;

    @SerializedName("rival_extra_infos")
    protected Map<Long, IRivalExtraInfo> rivalExtraInfos;

    @SerializedName("room2tags")
    protected Map<Long, r2> room2Tags;

    @SerializedName("search_bar")
    protected y8 searchBar;

    @SerializedName("skin_type")
    protected int skinType;
    private List<? extends IRoom> sortedFollowedList;

    @SerializedName("tab_locate")
    protected long tabLocate;

    @SerializedName("tags")
    protected Map<Long, r2> tagsMap;

    @SerializedName("tip_bar")
    protected z8 tipBar;

    @SerializedName("tips")
    protected String tips;

    public CompatRivalsListsData() {
        super(w8.class);
        this.tips = "";
        this.followedListGroupName = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public q8 getActivityData() {
        return this.activityData;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public IAnchorTopTips getAnchorTopTips() {
        return this.anchorTopTips;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public a0 getAutoMatchBanner() {
        return this.autoMatchBanner;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public long getDurationTime() {
        return this.durationTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public List<IRoom> getFollowedList() {
        return this.followedList;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public String getFollowedListGroupName() {
        return this.followedListGroupName;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public boolean getPkAvailable() {
        return this.pkAvailable;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public List<IRoom> getRecentList() {
        return this.recentList;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public List<IRoom> getRecommendList() {
        return this.recommendList;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public Map<Long, IRivalExtraInfo> getRivalExtraInfos() {
        return this.rivalExtraInfos;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public Map<Long, r2> getRoom2Tags() {
        return this.room2Tags;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public y8 getSearchBar() {
        return this.searchBar;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public int getSkinType() {
        return this.skinType;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public List<IRoom> getSortedFollowedList() {
        return this.sortedFollowedList;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public long getTabLocate() {
        return this.tabLocate;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public Map<Long, r2> getTagsMap() {
        return this.tagsMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public z8 getTipBar() {
        return this.tipBar;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public String getTips() {
        return this.tips;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.livesdk.link.model.a0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.bytedance.android.livesdk.link.model.y8, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.bytedance.android.livesdk.link.model.z8, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v24, types: [com.bytedance.android.livesdk.link.model.q8, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v26, types: [com.bytedance.android.livesdk.link.model.IAnchorTopTips, java.lang.Object] */
    public CompatRivalsListsData(g r15) {
        super(w8.class);
        this.followedList = new ArrayList();
        this.recentList = new ArrayList();
        this.recommendList = new ArrayList();
        this.rivalExtraInfos = new HashMap();
        this.room2Tags = new HashMap();
        this.tagsMap = new HashMap();
        setThreadSafe(false);
        long r0 = r15.c();
    L3:
        int r2 = r15.f();
        if (r2 == (-1)) goto L71;
        g.a r5 = decodeExtensionFields(r2, r15);
        Long r9 = null;
        switch(r2) {
            case 1: goto L69;
            case 2: goto L68;
            case 3: goto L67;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L48;
            case 8: goto L47;
            case 9: goto L46;
            case 10: goto L30;
            case 11: goto L29;
            case 12: goto L7;
            case 13: goto L7;
            case 14: goto L28;
            case 15: goto L27;
            case 16: goto L26;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L8;
            default: goto L7;
        };
    L8:
        this.followedListGroupName = am3.h.c(r15);
        goto L3
    L9:
        this.durationTime = r15.j();
        goto L3
    L10:
        long r10 = r15.c();
        Object r3 = null;
    L11:
        int r6 = r15.f();
        if (r6 == (-1)) goto L18;
        if (r6 != 1) goto L14;
        r9 = Long.valueOf(r15.j());
        goto L11
    L14:
        if (r6 != 2) goto L15;
        r3 = f.a(r15, r2.class);
        goto L11
    L15:
        am3.h.e(r15);
        goto L11
    L18:
        r15.d(r10);
        Map r4 = this.tagsMap;
        if (r9 == null) goto L25;
        if (r3 == null) goto L23;
    L62:
        r4.put(r9, r3);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this.pkAvailable = am3.h.a(r15);
        goto L3
    L27:
        this.tabLocate = r15.j();
        goto L3
    L28:
        this.anchorTopTips = f.a(r15, IAnchorTopTips.class);
        goto L3
    L29:
        this.activityData = f.a(r15, q8.class);
        goto L3
    L30:
        long r11 = r15.c();
        r3 = null;
    L31:
        int r7 = r15.f();
        if (r7 == (-1)) goto L38;
        if (r7 != 1) goto L34;
        r9 = Long.valueOf(r15.j());
        goto L31
    L34:
        if (r7 != 2) goto L35;
        r3 = f.a(r15, r2.class);
        goto L31
    L35:
        am3.h.e(r15);
        goto L31
    L38:
        r15.d(r11);
        r4 = this.room2Tags;
        if (r9 == null) goto L45;
        if (r3 != null) goto L62;
        throw new IllegalStateException("Value must not be null");
    L45:
        throw new IllegalStateException("Key must not be null");
    L46:
        this.skinType = r15.i();
        goto L3
    L47:
        this.tipBar = f.a(r15, z8.class);
        goto L3
    L48:
        this.searchBar = f.a(r15, y8.class);
        goto L3
    L49:
        this.tips = am3.h.c(r15);
        goto L3
    L50:
        this.autoMatchBanner = f.a(r15, a0.class);
        goto L3
    L51:
        long r12 = r15.c();
        r3 = null;
    L52:
        int r8 = r15.f();
        if (r8 == (-1)) goto L59;
        if (r8 != 1) goto L55;
        r9 = Long.valueOf(r15.j());
        goto L52
    L55:
        if (r8 != 2) goto L56;
        r3 = f.a(r15, IRivalExtraInfo.class);
        goto L52
    L56:
        am3.h.e(r15);
        goto L52
    L59:
        r15.d(r12);
        r4 = this.rivalExtraInfos;
        if (r9 == null) goto L66;
        if (r3 != null) goto L62;
        throw new IllegalStateException("Value must not be null");
    L66:
        throw new IllegalStateException("Key must not be null");
    L67:
        List<? extends IRoom> r13 = this.recommendList;
    L70:
        r13.add(f.a(r15, IRoom.class));
        goto L3
    L68:
        r13 = this.recentList;
        goto L70
    L69:
        r13 = this.followedList;
        goto L70
    L7:
        am3.h.d(r5, r15);
        goto L3
    L71:
        r15.d(r0);
        setThreadSafe(true);
        if (this.tips != null) goto L75;
        this.tips = "";
    L75:
        if (this.followedListGroupName != null) goto L145;
        this.followedListGroupName = "";
        return;
    }

    public void setFollowedList(List<? extends IRoom> r1) {
        this.followedList = r1;
    }

    public void setRecentList(List<? extends IRoom> r1) {
        this.recentList = r1;
    }

    public void setRecommendList(List<? extends IRoom> r1) {
        this.recommendList = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.w8
    public void setSortedFollowedList(List<? extends IRoom> r1) {
        this.sortedFollowedList = r1;
    }
}
