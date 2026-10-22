package gxa;

import com.ss.android.lark.biz.im.api.bundle.v2.annotation.ChatBundleScope;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.LaunchConfig;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.ai.AIBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.chat.ChatBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.common.CommonBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.flow.FlowChatBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.nexus.NexusBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.profile.ProfileBizData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.team.TeamBizData;

/* JADX INFO: loaded from: classes34.dex */
@ChatBundleScope
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LaunchConfig f483267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ChatBizData f483268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AIBizData f483269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TeamBizData f483270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ProfileBizData f483271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonBizData f483272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NexusBizData f483273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FlowChatBizData f483274h;

    public final BaseBundle a() {
        return new BaseBundle(this.f483267a, this.f483268b, this.f483269c, this.f483273g, this.f483270d, this.f483271e, this.f483272f, this.f483274h);
    }

    public a() {
        this.f483267a = new LaunchConfig(0);
        this.f483268b = new ChatBizData(0);
        this.f483269c = new AIBizData(0);
        this.f483270d = new TeamBizData(null, 7);
        this.f483271e = new ProfileBizData(0);
        this.f483272f = new CommonBizData(0);
        this.f483273g = new NexusBizData(null);
        this.f483274h = new FlowChatBizData(0);
    }
}
