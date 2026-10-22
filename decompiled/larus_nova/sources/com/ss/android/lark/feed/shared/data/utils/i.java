package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.basic.v1.ChatTeamInfo;
import com.bytedance.lark.pb.basic.v1.Team;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((FeedTeamInfo) r100).orderWeight, ((FeedTeamInfo) r101).orderWeight);
        }
    }

    static {
    }

    @JvmStatic
    public static final List<FeedTeamInfo> a(ChatData r110) {
        List<ChatTeamInfo> r100 = r110.joined_team_infos;
        if (r100 != null) goto L5;
        return null;
    L5:
        Map<Long, Team> r111 = r110.joined_teams;
        if (r111 != null) goto L8;
        return null;
    L8:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L10:
        if (r102.hasNext() == false) goto L26;
        ChatTeamInfo r103 = (ChatTeamInfo) r102.next();
        Long r104 = r103.team_id;
        if (r104 != null) goto L14;
    L22:
        FeedTeamInfo r105 = null;
    L23:
        if (r105 == null) goto L10;
        r101.add(r105);
        goto L10
    L14:
        if (r103.team_chat_type == null) goto L22;
        Team r106 = r111.get(r104);
        if (r106 == null) goto L22;
        String r107 = r106.name;
        if (r107 == null) goto L22;
        long r108 = r103.team_id.longValue();
        TeamChatType.a r109 = TeamChatType.Companion;
        int r112 = r103.team_chat_type.getValue();
        r109.getClass();
        r105 = new FeedTeamInfo(r108, r107, TeamChatType.a.a(r112), r103.order_weight);
        goto L23
    L26:
        return CollectionsKt.sortedWith(r101, new a());
    }
}
