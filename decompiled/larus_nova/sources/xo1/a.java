package xo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import lk1.c;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BubbleEnv f564665a;

    public a(BubbleEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f564665a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j
    public final boolean a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "bubble");
        BubbleEnv r101 = this.f564665a;
        boolean r102 = false;
        if (r101 == null) goto L12;
        DataCenter r103 = r101.f115777c;
        if (r103 == null) goto L12;
        c.f509546i2.getClass();
        mk1.a r104 = c.a.a(r103).getComponentStatus("room_auth_toolbar_bubble");
        if (r104 != null) goto L9;
    L10:
        r102 = true;
    L11:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r105 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r105.d("BubbleRoomAuthInterceptor");
        r105.c("气泡房间管控: " + r102);
        MorePanelBubbleAlog.a(r105.b());
        goto L12
    L9:
        if (r104.a() == true) goto L11;
    L12:
        return r102;
    }
}
