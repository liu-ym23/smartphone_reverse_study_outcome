package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.feed.app.entity.AutoMuteSettingNoticeType;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.FeedCardButton;
import com.ss.android.lark.feed.app.entity.MutexMarkType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements meb.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<FeedCard.Type> f421107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<FeedCard.FeedType> f421108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TypeAdapter<AppFeedCardType> f421109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TypeAdapter<Chat.ChatMode> f421110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TypeAdapter<List<UrgentInfo>> f421111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TypeAdapter<MutexMarkType> f421112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TypeAdapter<UIFeedCard.AtInfo> f421113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TypeAdapter<List<DigestElement>> f421114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TypeAdapter<List<Reaction>> f421115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TypeAdapter<AutoMuteSettingNoticeType> f421116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TypeAdapter<List<FeedCardButton>> f421117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Field f421118l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Field f421119m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Field f421120n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Field f421121o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Field f421122p;

    @Override // meb.e
    public final void a(JsonObject r100, UIFeedCard r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "value");
        a.j(r100, "id", r101.getId());
        a.i(r100, "entityType", r101.getType(), this.f421107a);
        a.i(r100, "feedType", r101.getFeedType(), this.f421108b);
        a.i(r100, "bizType", r101.getBizType(), this.f421109c);
        a.j(r100, "bizId", r101.getBizId());
        a.j(r100, "appId", r101.getAppId());
        a.j(r100, "uid", r101.getUid());
        a.g(r100, "checkUser", Boolean.valueOf(r101.isCheckUser()));
        a.h(r100, UserInfo.UPDATE_TIME, Long.valueOf(r101.getUpdateTime()));
        a.h(r100, "rankTime", Long.valueOf(r101.getRankTime()));
        a.h(r100, "displayTime", Long.valueOf(r101.getDisplayTime()));
        a.h(r100, "rankPriority", Long.valueOf(r101.getRankPriority()));
        a.g(r100, "isSwipedLeftPinned", Boolean.valueOf(r101.isSwipedLeftPinned()));
        a.g(r100, "isSwipeRightPinned", Boolean.valueOf(r101.isSwipeRightPinned()));
        a.j(r100, "parentCardId", r101.getParentCardId());
        a.i(r100, "chatMode", r101.getChatMode(), this.f421110d);
        a.g(r100, "isOfflineOncall", Boolean.valueOf(r101.getOfflineOncall()));
        a.h(r100, "shortcutPosition", Integer.valueOf(r101.getShortcutPosition()));
        a.g(r100, "isDisplayInShortcut", Boolean.valueOf(r101.getIsDisplayInShortcut()));
        a.h(r100, "markType", Integer.valueOf(r101.getMarkType()));
        a.a(r100, "urgentInfos", r101.getUrgentInfos(), this.f421111e);
        a.g(r100, "isStranger", Boolean.valueOf(r101.isStranger()));
        a.g(r100, "isBlocked", Boolean.valueOf(r101.isBlocked()));
        a.h(r100, "canSetStranger", Integer.valueOf(r101.getCanSetStranger()));
        Object r102 = this.f421118l.get(r101);
        List r103 = null;
        if ((r102 instanceof MutexMarkType) == false) goto L5;
        MutexMarkType r104 = (MutexMarkType) r102;
    L6:
        a.i(r100, "mutexMarkType", r104, this.f421112f);
        a.j(r100, "draftMessage", r101.getDraftMessage());
        a.g(r100, "isRemind", Boolean.valueOf(r101.isRemind()));
        a.g(r100, "isShortCutFeed", Boolean.valueOf(r101.isShortCut()));
        a.h(r100, "onTopRankTime", Long.valueOf(r101.getOnTopRankTime()));
        a.g(r100, "isFake", Boolean.valueOf(r101.getIsFake()));
        a.g(r100, "isPriorityProcessing", Boolean.valueOf(r101.getIsPriorityProcessing()));
        a.g(r100, "isFirstTopRank", Boolean.valueOf(r101.getIsFirstTopRank()));
        a.g(r100, "isExpiredFoldHint", Boolean.valueOf(r101.getIsExpiredFoldHint()));
        a.g(r100, "isFlag", Boolean.valueOf(r101.isFlag()));
        a.j(r100, "name", r101.getName());
        a.j(r100, "avatarId", r101.getAvatarId());
        a.j(r100, "avatarKey", r101.getAvatarKey());
        a.h(r100, "unreadCount", Long.valueOf(r101.getUnreadCount()));
        a.i(r100, "atInfo", r101.getAtInfo(), this.f421113g);
        a.a(r100, "digestMessage", r101.getDigestMessage(), this.f421114h);
        Object r105 = this.f421122p.get(r101);
        if ((r105 instanceof List) == false) goto L9;
        List r106 = (List) r105;
    L10:
        a.a(r100, "draftDigestMessage", r106, this.f421114h);
        a.g(r100, "isCrossTenant", Boolean.valueOf(r101.isCrossTenant()));
        Object r107 = this.f421119m.get(r101);
        if ((r107 instanceof List) == false) goto L13;
        r103 = (List) r107;
    L13:
        a.a(r100, "reactions", r103, this.f421115i);
        a.h(r100, "reactionCount", Integer.valueOf(this.f421120n.getInt(r101)));
        a.h(r100, "reactionDisplayCount", Integer.valueOf(this.f421121o.getInt(r101)));
        a.i(r100, "muteNoticeType", r101.getMuteNoticeType(), this.f421116j);
        a.g(r100, "isRedBadge", Boolean.valueOf(r101.isRedBadge()));
        a.g(r100, "isFlowMainBot", Boolean.valueOf(r101.getIsFlowMainBot()));
        a.a(r100, "feedCardButtons", r101.getFeedCardButtons(), this.f421117k);
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // meb.e
    public final void b(JsonObject r100, UIFeedCard r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "value");
        r101.setId(a.l(r100, "id"));
        FeedCard.Type r102 = (FeedCard.Type) a.k(r100, "entityType", this.f421107a);
        if (r102 == null) goto L5;
        r101.setType(r102);
    L5:
        FeedCard.FeedType r103 = (FeedCard.FeedType) a.k(r100, "feedType", this.f421108b);
        if (r103 == null) goto L8;
        r101.setFeedType(r103);
    L8:
        AppFeedCardType r104 = (AppFeedCardType) a.k(r100, "bizType", this.f421109c);
        if (r104 == null) goto L11;
        r101.setBizType(r104);
    L11:
        r101.setBizId(a.l(r100, "bizId"));
        r101.setAppId(a.l(r100, "appId"));
        r101.setUid(a.l(r100, "uid"));
        Boolean r105 = a.c(r100, "checkUser");
        boolean r106 = false;
        if (r105 == null) goto L14;
        boolean r107 = r105.booleanValue();
    L15:
        r101.setCheckUser(r107);
        Long r108 = a.f(r100, UserInfo.UPDATE_TIME);
        long r109 = 0;
        if (r108 == null) goto L18;
        long r110 = r108.longValue();
    L19:
        r101.setUpdateTime(r110);
        Long r111 = a.f(r100, "rankTime");
        if (r111 == null) goto L22;
        long r112 = r111.longValue();
    L23:
        r101.setRankTime(r112);
        Long r113 = a.f(r100, "displayTime");
        if (r113 == null) goto L26;
        long r114 = r113.longValue();
    L27:
        r101.setDisplayTime(r114);
        Long r115 = a.f(r100, "rankPriority");
        if (r115 == null) goto L30;
        long r116 = r115.longValue();
    L31:
        r101.setRankPriority(r116);
        Boolean r117 = a.c(r100, "isSwipedLeftPinned");
        if (r117 == null) goto L34;
        boolean r118 = r117.booleanValue();
    L35:
        r101.setSwipedLeftPinned(r118);
        Boolean r119 = a.c(r100, "isSwipeRightPinned");
        if (r119 == null) goto L38;
        boolean r120 = r119.booleanValue();
    L39:
        r101.setSwipeRightPinned(r120);
        r101.setParentCardId(a.l(r100, "parentCardId"));
        Chat.ChatMode r121 = (Chat.ChatMode) a.k(r100, "chatMode", this.f421110d);
        if (r121 == null) goto L42;
        r101.setChatMode(r121);
    L42:
        Boolean r122 = a.c(r100, "isOfflineOncall");
        if (r122 == null) goto L45;
        boolean r123 = r122.booleanValue();
    L46:
        r101.setOfflineOncall(r123);
        Integer r124 = a.e(r100, "shortcutPosition");
        if (r124 == null) goto L49;
        int r125 = r124.intValue();
    L50:
        r101.setShortcutPosition(r125);
        Boolean r126 = a.c(r100, "isDisplayInShortcut");
        if (r126 == null) goto L53;
        boolean r127 = r126.booleanValue();
    L54:
        r101.setIsDisplayInShortcut(r127);
        Integer r128 = a.e(r100, "markType");
        if (r128 == null) goto L57;
        int r129 = r128.intValue();
    L58:
        r101.setMarkType(r129);
        List r130 = a.b(r100, "urgentInfos", this.f421111e);
        if (r130 != null) goto L61;
        r130 = CollectionsKt.emptyList();
    L61:
        r101.setUrgentInfos(new ArrayList(r130));
        Boolean r131 = a.c(r100, "isStranger");
        if (r131 == null) goto L64;
        boolean r132 = r131.booleanValue();
    L65:
        r101.setStranger(r132);
        Boolean r133 = a.c(r100, "isBlocked");
        if (r133 == null) goto L68;
        boolean r134 = r133.booleanValue();
    L69:
        r101.setBlocked(r134);
        Integer r135 = a.e(r100, "canSetStranger");
        if (r135 == null) goto L72;
        int r136 = r135.intValue();
    L73:
        r101.setCanSetStranger(r136);
        r101.setMutexMarkType((MutexMarkType) a.k(r100, "mutexMarkType", this.f421112f));
        r101.setDraftMessage(a.l(r100, "draftMessage"));
        Boolean r137 = a.c(r100, "isRemind");
        if (r137 == null) goto L76;
        boolean r138 = r137.booleanValue();
    L77:
        r101.setRemind(r138);
        Boolean r139 = a.c(r100, "isShortCutFeed");
        if (r139 == null) goto L80;
        boolean r140 = r139.booleanValue();
    L81:
        r101.setShortCut(r140);
        Long r141 = a.f(r100, "onTopRankTime");
        if (r141 == null) goto L84;
        long r142 = r141.longValue();
    L85:
        r101.setOnTopRankTime(r142);
        Boolean r143 = a.c(r100, "isFake");
        if (r143 == null) goto L88;
        boolean r144 = r143.booleanValue();
    L89:
        r101.setIsFake(r144);
        Boolean r145 = a.c(r100, "isPriorityProcessing");
        if (r145 == null) goto L92;
        boolean r146 = r145.booleanValue();
    L93:
        r101.setIsPriorityProcessing(r146);
        Boolean r147 = a.c(r100, "isFirstTopRank");
        if (r147 == null) goto L96;
        boolean r148 = r147.booleanValue();
    L97:
        r101.setIsFirstTopRank(r148);
        Boolean r149 = a.c(r100, "isExpiredFoldHint");
        if (r149 == null) goto L100;
        boolean r150 = r149.booleanValue();
    L101:
        r101.setIsExpiredFoldHint(r150);
        Boolean r151 = a.c(r100, "isFlag");
        if (r151 == null) goto L104;
        boolean r152 = r151.booleanValue();
    L105:
        r101.setFlag(r152);
        r101.setName(a.l(r100, "name"));
        r101.setAvatarId(a.l(r100, "avatarId"));
        r101.setAvatarKey(a.l(r100, "avatarKey"));
        Long r153 = a.f(r100, "unreadCount");
        if (r153 == null) goto L108;
        r109 = r153.longValue();
    L108:
        r101.setUnreadCount(r109);
        r101.setAtInfo((UIFeedCard.AtInfo) a.k(r100, "atInfo", this.f421113g));
        List r154 = a.b(r100, "digestMessage", this.f421114h);
        ArrayList<DigestElement> r155 = null;
        if (r154 == null) goto L111;
        ArrayList<DigestElement> r156 = new ArrayList(r154);
    L112:
        r101.setDigestMessage(r156);
        List r157 = a.b(r100, "draftDigestMessage", this.f421114h);
        if (r157 == null) goto L115;
        r155 = new ArrayList(r157);
    L115:
        r101.setDraftDigestMessage(r155);
        Boolean r158 = a.c(r100, "isCrossTenant");
        if (r158 == null) goto L118;
        boolean r159 = r158.booleanValue();
    L119:
        r101.setCrossTenant(r159);
        List r160 = a.b(r100, "reactions", this.f421115i);
        if (r160 != null) goto L122;
        r160 = CollectionsKt.emptyList();
    L122:
        r101.setReactions(new ArrayList(r160));
        Integer r161 = a.e(r100, "reactionCount");
        if (r161 == null) goto L125;
        int r162 = r161.intValue();
    L126:
        r101.setReactionCount(r162);
        Integer r163 = a.e(r100, "reactionDisplayCount");
        if (r163 == null) goto L129;
        int r164 = r163.intValue();
    L130:
        r101.setReactionDisplayCount(r164);
        AutoMuteSettingNoticeType r165 = (AutoMuteSettingNoticeType) a.k(r100, "muteNoticeType", this.f421116j);
        if (r165 == null) goto L133;
        r101.setMuteNoticeType(r165);
    L133:
        Boolean r166 = a.c(r100, "isRedBadge");
        if (r166 == null) goto L136;
        boolean r167 = r166.booleanValue();
    L137:
        r101.setRedBadge(r167);
        Boolean r168 = a.c(r100, "isFlowMainBot");
        if (r168 == null) goto L140;
        r106 = r168.booleanValue();
    L140:
        r101.setIsFlowMainBot(r106);
        List r169 = a.b(r100, "feedCardButtons", this.f421117k);
        if (r169 != null) goto L143;
        r169 = CollectionsKt.emptyList();
    L143:
        r101.setFeedCardButtons(new ArrayList(r169));
        return;
    L136:
        r167 = false;
        goto L137
    L129:
        r164 = 0;
        goto L130
    L125:
        r162 = 0;
        goto L126
    L118:
        r159 = false;
        goto L119
    L111:
        r156 = null;
        goto L112
    L104:
        r152 = false;
        goto L105
    L100:
        r150 = false;
        goto L101
    L96:
        r148 = false;
        goto L97
    L92:
        r146 = false;
        goto L93
    L88:
        r144 = false;
        goto L89
    L84:
        r142 = 0;
        goto L85
    L80:
        r140 = false;
        goto L81
    L76:
        r138 = false;
        goto L77
    L72:
        r136 = 0;
        goto L73
    L68:
        r134 = false;
        goto L69
    L64:
        r132 = false;
        goto L65
    L57:
        r129 = 0;
        goto L58
    L53:
        r127 = false;
        goto L54
    L49:
        r125 = 0;
        goto L50
    L45:
        r123 = false;
        goto L46
    L38:
        r120 = false;
        goto L39
    L34:
        r118 = false;
        goto L35
    L30:
        r116 = 0;
        goto L31
    L26:
        r114 = 0;
        goto L27
    L22:
        r112 = 0;
        goto L23
    L18:
        r110 = 0;
        goto L19
    L14:
        r107 = false;
        goto L15
    }

    public f(TypeAdapter r100, TypeAdapter r101, WireEnumTypeAdapter r102, TypeAdapter r103, ListTypeAdapter r104, TypeAdapter r105, UIFeedCardAtInfoTypeAdapter r106, ListTypeAdapter r107, ListTypeAdapter r110, TypeAdapter r111, ListTypeAdapter r112) {
        Intrinsics.checkNotNullParameter(r100, "entityTypeAdapter");
        Intrinsics.checkNotNullParameter(r101, "feedTypeAdapter");
        Intrinsics.checkNotNullParameter(r102, "bizTypeAdapter");
        Intrinsics.checkNotNullParameter(r103, "chatModeAdapter");
        Intrinsics.checkNotNullParameter(r104, "urgentInfoListAdapter");
        Intrinsics.checkNotNullParameter(r105, "mutexMarkTypeAdapter");
        Intrinsics.checkNotNullParameter(r106, "atInfoAdapter");
        Intrinsics.checkNotNullParameter(r107, "digestElementListAdapter");
        Intrinsics.checkNotNullParameter(r110, "reactionListAdapter");
        Intrinsics.checkNotNullParameter(r111, "muteNoticeTypeAdapter");
        Intrinsics.checkNotNullParameter(r112, "feedCardButtonListAdapter");
        this.f421107a = r100;
        this.f421108b = r101;
        this.f421109c = r102;
        this.f421110d = r103;
        this.f421111e = r104;
        this.f421112f = r105;
        this.f421113g = r106;
        this.f421114h = r107;
        this.f421115i = r110;
        this.f421116j = r111;
        this.f421117k = r112;
        Field r108 = UIFeedCard.class.getDeclaredField("mutexMarkType");
        r108.setAccessible(true);
        this.f421118l = r108;
        Field r109 = UIFeedCard.class.getDeclaredField("reactions");
        r109.setAccessible(true);
        this.f421119m = r109;
        Field r113 = UIFeedCard.class.getDeclaredField("reactionCount");
        r113.setAccessible(true);
        this.f421120n = r113;
        Field r114 = UIFeedCard.class.getDeclaredField("reactionDisplayCount");
        r114.setAccessible(true);
        this.f421121o = r114;
        Field r115 = UIFeedCard.class.getDeclaredField("draftDigestMessage");
        r115.setAccessible(true);
        this.f421122p = r115;
    }
}
