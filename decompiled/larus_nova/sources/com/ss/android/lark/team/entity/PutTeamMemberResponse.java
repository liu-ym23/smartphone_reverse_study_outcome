package com.ss.android.lark.team.entity;

import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/team/entity/PutTeamMemberResponse;", "Ljava/io/Serializable;", WikiSpaceType.TEAM, "Lcom/ss/android/lark/team/entity/Team;", "orderedWeight", "", "", "", "metas", "Lcom/ss/android/lark/team/entity/TeamMemberMeta;", "chatters", "", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "<init>", "(Lcom/ss/android/lark/team/entity/Team;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)V", "getTeam", "()Lcom/ss/android/lark/team/entity/Team;", "getOrderedWeight", "()Ljava/util/Map;", "getMetas", "getChatters", "()Ljava/util/List;", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PutTeamMemberResponse implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 3597072974204111179L;
    private final List<Chatter> chatters;
    private final Map<String, TeamMemberMeta> metas;
    private final Map<String, Long> orderedWeight;
    private final Team team;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final List<Chatter> getChatters() {
        return this.chatters;
    }

    public final Map<String, TeamMemberMeta> getMetas() {
        return this.metas;
    }

    public final Map<String, Long> getOrderedWeight() {
        return this.orderedWeight;
    }

    public final Team getTeam() {
        return this.team;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PutTeamMemberResponse(Team r100, Map<String, Long> r101, Map<String, TeamMemberMeta> r102, List<? extends Chatter> r103) {
        Intrinsics.checkNotNullParameter(r101, "orderedWeight");
        Intrinsics.checkNotNullParameter(r102, "metas");
        Intrinsics.checkNotNullParameter(r103, "chatters");
        this.team = r100;
        this.orderedWeight = r101;
        this.metas = r102;
        this.chatters = r103;
    }
}
