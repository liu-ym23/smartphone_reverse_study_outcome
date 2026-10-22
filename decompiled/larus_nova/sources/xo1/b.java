package xo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BubbleEnv f564667b;

    public b(BubbleEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f564667b = r100;
        this.f564666a = "CommonBubbleInterceptor";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j
    public final boolean a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "bubble");
        if (this.f564667b.a().d() == false) goto L6;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r101 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r101.d(this.f564666a);
        r101.c("气泡展示被拦截，24小时展示频控限制");
        MorePanelBubbleAlog.a(r101.b());
        return true;
    L6:
        g.b r102 = this.f564667b.a().query(r100.getId());
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.e() == false) goto L14;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r103 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r103.d(this.f564666a);
        r103.c("气泡展示被拦截，该气泡已经完成展示了");
        MorePanelBubbleAlog.a(r103.b());
        return true;
    L14:
        if (r102.d() >= 3) goto L16;
    L22:
        return false;
    L16:
        if (r102.b() != 1001) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == true) goto L22;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r105 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r105.d(this.f564666a);
        r105.c("气泡展示被拦截，该气泡已经展示过3次了");
        MorePanelBubbleAlog.a(r105.b());
        return true;
    L18:
        r104 = false;
        goto L19
    }
}
