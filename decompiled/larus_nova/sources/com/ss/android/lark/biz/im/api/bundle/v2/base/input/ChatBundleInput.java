package com.ss.android.lark.biz.im.api.bundle.v2.base.input;

import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.LaunchConfig;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.ai.AIBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.chat.ChatBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.common.CommonBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.flow.FlowChatBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.nexus.NexusBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.profile.ProfileBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.team.TeamBizData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0017J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatBundleInput;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/BaseBundle;", "launchData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;", "launchConfig", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig;", "chatData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/chat/ChatBizData;", "aiData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/ai/AIBizData;", "nexusBizData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/nexus/NexusBizData;", "teamData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/team/TeamBizData;", "profileData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/profile/ProfileBizData;", "commonData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/common/CommonBizData;", "flowChatBizData", "Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/flow/FlowChatBizData;", "<init>", "(Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/LaunchConfig;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/chat/ChatBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/ai/AIBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/nexus/NexusBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/team/TeamBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/profile/ProfileBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/common/CommonBizData;Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/flow/FlowChatBizData;)V", "base", "(Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;Lcom/ss/android/lark/biz/im/api/bundle/v2/base/BaseBundle;)V", "getLaunchData", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;", "toBundle", "Landroid/os/Bundle;", "packBaseBundle", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBundleInput extends BaseBundle {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f409974j = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ILaunchDataInput f409975i;

    public static final class Companion {
        @JvmStatic
        public static ChatBundleInput a(final ChatBundle r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            int r101 = a.f409991a;
            String r102 = r100.f409908a;
            Function1<LaunchInputParam.a, Unit> r103 = new ChatBundleInput$Companion$parse$1(r100);
            Function1<gxa.a, Unit> r104 = new ChatBundleInput$Companion$parse$2(r100);
            Intrinsics.checkNotNullParameter(r103, "param");
            Intrinsics.checkNotNullParameter(r104, "init");
            LaunchInputParam.a r105 = new LaunchInputParam.a(r102);
            r103.invoke(r105);
            ChatLaunchParamData r106 = new ChatLaunchParamData(new LaunchInputParam(r102, r105.f409987a, r105.f409988b, r105.f409989c, r105.f409990d));
            gxa.a r107 = new gxa.a();
            r104.invoke(r107);
            return new ChatBundleInput(r106, r107.a());
        }
    }

    static {
    }

    public ChatBundleInput(ILaunchDataInput r110, BaseBundle r111) {
        Intrinsics.checkNotNullParameter(r110, "launchData");
        Intrinsics.checkNotNullParameter(r111, "base");
        LaunchConfig r100 = r111.f409966a;
        ChatBizData r101 = r111.f409967b;
        AIBizData r102 = r111.f409968c;
        NexusBizData r103 = r111.f409969d;
        TeamBizData r104 = r111.f409970e;
        ProfileBizData r105 = r111.f409971f;
        CommonBizData r106 = r111.f409972g;
        FlowChatBizData r112 = r111.f409973h;
        Intrinsics.checkNotNullParameter(r110, "launchData");
        Intrinsics.checkNotNullParameter(r100, "launchConfig");
        Intrinsics.checkNotNullParameter(r101, "chatData");
        Intrinsics.checkNotNullParameter(r102, "aiData");
        Intrinsics.checkNotNullParameter(r103, "nexusBizData");
        Intrinsics.checkNotNullParameter(r104, "teamData");
        Intrinsics.checkNotNullParameter(r105, "profileData");
        Intrinsics.checkNotNullParameter(r106, "commonData");
        Intrinsics.checkNotNullParameter(r112, "flowChatBizData");
        super(r100, r101, r102, r103, r104, r105, r106, r112);
        this.f409975i = r110;
    }
}
