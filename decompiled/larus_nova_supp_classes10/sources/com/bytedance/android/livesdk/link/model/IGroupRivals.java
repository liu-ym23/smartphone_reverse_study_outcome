package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002\f\rR0\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdk/link/model/m2;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSortRivals", "()Ljava/util/List;", "setSortRivals", "(Ljava/util/List;)V", "sortRivals", "Companion", "a", "GroupType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGroupRivals extends vh7.c<IGroupRivals> {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGroupRivals$GroupType;", "", "GroupUndefined", "GroupFeedFollowed", "GroupFeedRecommend", "GroupRivalsSearchHourlyRank", "GroupRivalsActivity", "GroupRivalsSearchPopularityRank", "GroupRivalsFeedAutoMatchSelfIn", "GroupRivalsMultipleFeedRecommend", "GroupRivalsNewRecommend", "GroupRivalsNewFollowed", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum GroupType extends Enum<GroupType> {
        public static final GroupType GroupFeedFollowed = null;
        public static final GroupType GroupFeedRecommend = null;
        public static final GroupType GroupRivalsActivity = null;
        public static final GroupType GroupRivalsFeedAutoMatchSelfIn = null;
        public static final GroupType GroupRivalsMultipleFeedRecommend = null;
        public static final GroupType GroupRivalsNewFollowed = null;
        public static final GroupType GroupRivalsNewRecommend = null;
        public static final GroupType GroupRivalsSearchHourlyRank = null;
        public static final GroupType GroupRivalsSearchPopularityRank = null;
        public static final GroupType GroupUndefined = null;
        public static final /* synthetic */ GroupType[] a = null;

        static {
            GroupType r1 = new GroupType("GroupUndefined", 0);
            GroupUndefined = r1;
            GroupType r2 = new GroupType("GroupFeedFollowed", 1);
            GroupFeedFollowed = r2;
            GroupType r3 = new GroupType("GroupFeedRecommend", 2);
            GroupFeedRecommend = r3;
            GroupType r4 = new GroupType("GroupRivalsSearchHourlyRank", 3);
            GroupRivalsSearchHourlyRank = r4;
            GroupType r5 = new GroupType("GroupRivalsActivity", 4);
            GroupRivalsActivity = r5;
            GroupType r6 = new GroupType("GroupRivalsSearchPopularityRank", 5);
            GroupRivalsSearchPopularityRank = r6;
            GroupType r7 = new GroupType("GroupRivalsFeedAutoMatchSelfIn", 6);
            GroupRivalsFeedAutoMatchSelfIn = r7;
            GroupType r8 = new GroupType("GroupRivalsMultipleFeedRecommend", 7);
            GroupRivalsMultipleFeedRecommend = r8;
            GroupType r9 = new GroupType("GroupRivalsNewRecommend", 8);
            GroupRivalsNewRecommend = r9;
            GroupType r10 = new GroupType("GroupRivalsNewFollowed", 9);
            GroupRivalsNewFollowed = r10;
            a = new GroupType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        }

        public static GroupType valueOf(String r1) {
            return (GroupType) r27.a.a(GroupType.class, r1);
        }

        public static GroupType[] values() {
            return (GroupType[]) a.clone();
        }

        public GroupType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getDetailType();

    /* synthetic */ com.bytedance.android.live.base.model.message.a5 getGroupInfo();

    /* synthetic */ String getGroupName();

    /* synthetic */ int getGroupType();

    /* synthetic */ boolean getHasSelectButton();

    /* synthetic */ String getImprId();

    /* synthetic */ List<m2> getRivals();

    /* synthetic */ int getSelectType();

    List<m2> getSortRivals();

    /* synthetic */ int getStatus();

    /* synthetic */ void setRivals(List<? extends m2> r1);

    void setSortRivals(List<? extends m2> r1);
}
