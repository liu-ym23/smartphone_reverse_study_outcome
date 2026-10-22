package com.ss.android.lark.biz.im.api.bundle.v2.base;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.ChatIntentExtraBundle;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.biz.im.api.bundle.ChatAIBundle;
import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.LaunchConfig;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.ai.AIBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.chat.ChatBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.common.CommonBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.flow.FlowChatBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.nexus.NexusBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.profile.ProfileBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.team.TeamBizData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.LarkAgentContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001.BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020\u0000J\b\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020(H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006/"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/BaseBundle;", "Landroid/os/Parcelable;", "launchConfig", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig;", "chatData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/chat/ChatBizData;", "aiData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/ai/AIBizData;", "nexusBizData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/nexus/NexusBizData;", "teamData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/team/TeamBizData;", "profileData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/profile/ProfileBizData;", "commonData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/common/CommonBizData;", "flowChatData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/flow/FlowChatBizData;", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/chat/ChatBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/ai/AIBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/nexus/NexusBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/team/TeamBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/profile/ProfileBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/common/CommonBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/flow/FlowChatBizData;)V", "getLaunchConfig", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig;", "getChatData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/chat/ChatBizData;", "getAiData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/ai/AIBizData;", "getNexusBizData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/nexus/NexusBizData;", "getTeamData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/team/TeamBizData;", "getProfileData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/profile/ProfileBizData;", "getCommonData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/common/CommonBizData;", "getFlowChatData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/flow/FlowChatBizData;", "toBundle", "Landroid/os/Bundle;", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseBundle implements Parcelable {
    public static final Parcelable.Creator<BaseBundle> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LaunchConfig f409966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatBizData f409967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AIBizData f409968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NexusBizData f409969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TeamBizData f409970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProfileBizData f409971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CommonBizData f409972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FlowChatBizData f409973h;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<BaseBundle> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseBundle createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new BaseBundle(LaunchConfig.CREATOR.createFromParcel(r110), (ChatBizData) r110.readParcelable(BaseBundle.class.getClassLoader()), AIBizData.CREATOR.createFromParcel(r110), NexusBizData.CREATOR.createFromParcel(r110), TeamBizData.CREATOR.createFromParcel(r110), ProfileBizData.CREATOR.createFromParcel(r110), CommonBizData.CREATOR.createFromParcel(r110), FlowChatBizData.CREATOR.createFromParcel(r110));
        }

        @Override // android.os.Parcelable.Creator
        public final BaseBundle[] newArray(int r100) {
            return new BaseBundle[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        this.f409966a.writeToParcel(r100, r101);
        r100.writeParcelable(this.f409967b, r101);
        this.f409968c.writeToParcel(r100, r101);
        this.f409969d.writeToParcel(r100, r101);
        this.f409970e.writeToParcel(r100, r101);
        this.f409971f.writeToParcel(r100, r101);
        this.f409972g.writeToParcel(r100, r101);
        this.f409973h.writeToParcel(r100, r101);
    }

    public BaseBundle() {
        this(new LaunchConfig(0), new ChatBizData(0), new AIBizData(0), new NexusBizData(null), new TeamBizData(null, 7), new ProfileBizData(0), new CommonBizData(0), new FlowChatBizData(0));
    }

    public final BaseBundle E() {
        LaunchConfig r100 = this.f409966a;
        int r101 = r100.f410017a;
        int r102 = r100.f410018b;
        LaunchConfig.LaunchStyle r103 = r100.f410019c;
        String r104 = r100.f410020d;
        SourceType r105 = r100.f410021e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "launchStyle");
        LaunchConfig r106 = new LaunchConfig(r101, r102, r103, r104, r105);
        ChatBizData r107 = this.f409967b;
        ChatBizData.a r108 = ChatBizData.CREATOR;
        int r110 = r107.f410031a;
        boolean r111 = r107.f410032b;
        boolean r112 = r107.f410033c;
        ProfileSource r113 = r107.f410034d;
        String r109 = r107.f410035e;
        String r114 = r107.f410036f;
        boolean r115 = r107.f410037g;
        boolean r116 = r107.f410038h;
        boolean r117 = r107.f410039i;
        boolean r118 = r107.f410040j;
        boolean r119 = r107.f410041k;
        Bundle r120 = r107.f410042l;
        String r121 = r107.f410043m;
        String r122 = r107.f410044n;
        ChatWindowPrepareData r123 = r107.f410045o;
        ChatIntentExtraBundle r124 = r107.f410046p;
        long r125 = r107.f410047q;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r120, "applyContactsBundle");
        ChatBizData r310 = new ChatBizData(r110, r111, r112, r113, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125);
        AIBizData r126 = this.f409968c;
        int r127 = r126.f410029a;
        ChatAIBundle r128 = r126.f410030b;
        r126.getClass();
        AIBizData r129 = new AIBizData(r127, r128);
        NexusBizData r130 = this.f409969d;
        LarkAgentContext r131 = r130.f410051a;
        r130.getClass();
        NexusBizData r132 = new NexusBizData(r131);
        TeamBizData r133 = this.f409970e;
        ChatTeamBundle r134 = r133.f410056a;
        boolean r135 = r133.f410057b;
        boolean r136 = r133.f410058c;
        r133.getClass();
        TeamBizData r137 = new TeamBizData(r134, r135, r136);
        ProfileBizData r138 = this.f409971f;
        boolean r139 = r138.f410052a;
        boolean r140 = r138.f410053b;
        boolean r141 = r138.f410054c;
        String r142 = r138.f410055d;
        r138.getClass();
        ProfileBizData r143 = new ProfileBizData(r139, r140, r141, r142);
        CommonBizData r144 = this.f409972g;
        Bundle r145 = r144.f410048a;
        r144.getClass();
        Intrinsics.checkNotNullParameter(r145, "extraBundle");
        CommonBizData r146 = new CommonBizData(r145);
        FlowChatBizData r147 = this.f409973h;
        Chat.ChatMode r148 = r147.f410049a;
        boolean r149 = r147.f410050b;
        r147.getClass();
        return new BaseBundle(r106, r310, r129, r132, r137, r143, r146, new FlowChatBizData(r148, r149));
    }

    public BaseBundle(LaunchConfig r100, ChatBizData r101, AIBizData r102, NexusBizData r103, TeamBizData r104, ProfileBizData r105, CommonBizData r106, FlowChatBizData r107) {
        Intrinsics.checkNotNullParameter(r100, "launchConfig");
        Intrinsics.checkNotNullParameter(r101, "chatData");
        Intrinsics.checkNotNullParameter(r102, "aiData");
        Intrinsics.checkNotNullParameter(r103, "nexusBizData");
        Intrinsics.checkNotNullParameter(r104, "teamData");
        Intrinsics.checkNotNullParameter(r105, "profileData");
        Intrinsics.checkNotNullParameter(r106, "commonData");
        Intrinsics.checkNotNullParameter(r107, "flowChatData");
        this.f409966a = r100;
        this.f409967b = r101;
        this.f409968c = r102;
        this.f409969d = r103;
        this.f409970e = r104;
        this.f409971f = r105;
        this.f409972g = r106;
        this.f409973h = r107;
    }
}
