package z5c;

import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;

/* JADX INFO: loaded from: classes38.dex */
public final class r0 extends s5c.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r0 f570357c = null;

    static {
        r0 r100 = new r0();
        f570357c = r100;
        r100.a("inbox");
        r100.a("message");
        r100.a("at_me");
        r100.a("unread");
        r100.a("doc");
        r100.a("p2p_chat");
        r100.a("group_chat");
        r100.a("bot");
        r100.a(ChatFromType.HELP_DESK);
        r100.a("topic_group");
        r100.a("done");
        r100.a(ITTVideoEngineEventSource.KEY_MUTE);
        r100.a(WikiSpaceType.TEAM);
        r100.a("label");
        r100.a("thread");
        r100.a(ForwardDependency$ForwardLocation.FLAG);
        r100.a("all");
    }

    public r0() {
        super("feed_tab");
    }
}
