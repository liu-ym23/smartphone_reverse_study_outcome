package zr2;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.revenue.toolbar.RevRedDot;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessInject;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements c0.b, ILivePreviewBusinessInject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f573397a;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void Bh(ToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        RevRedDot r100 = this.f573397a.h7();
        if (r100 == null) goto L15;
        int r101 = l.f573396a[r100.ordinal()];
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 != 3) goto L12;
        return up2.a.f551007g;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return up2.a.f551014n;
    L19:
        return up2.a.f551013m;
    L15:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return this.f573397a.showRedDot();
    }

    public m(b r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f573397a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        this.f573397a.d(new h(r100.f116193c, r100.f116194d, r100.f116202l.f116104b));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r210) {
        Intrinsics.checkNotNullParameter(r210, "command");
        b r100 = this.f573397a;
        Intrinsics.checkNotNullParameter(r210, "$this$toRevType");
        if ((r210 instanceof pp1.c) == false) goto L6;
        pp1.c r101 = (pp1.c) r210;
        n r102 = new e(r101.f530168b, r101.f530169c, r101.f530170d, r101.f530171e, r101.f530172f, r101.f530173g, r101.f530174h, r101.f530175i, r101.f530176j, r101.f530177k, null, r101.f530178l, r101.f530179m, r101.f530180n, 1024);
    L30:
        if (r102 != null) goto L32;
        return;
    L32:
        r100.a(r102);
        return;
    L6:
        if ((r210 instanceof pp1.d) == false) goto L9;
        r102 = new f(((pp1.d) r210).f530185a);
        goto L30
    L9:
        if ((r210 instanceof pp1.j) == false) goto L18;
        pp1.j r103 = (pp1.j) r210;
        boolean r104 = false;
        if (r103.f530190a == false) goto L13;
        char r105 = 0;
    L14:
        if (r105 != 0) goto L16;
        r104 = true;
    L16:
        r102 = new i(r104, r103.f530191b);
        goto L30
    L13:
        r105 = '\b';
        goto L14
    L18:
        if ((r210 instanceof pp1.k) == false) goto L21;
        r102 = j.f573390a;
        goto L30
    L21:
        if ((r210 instanceof pp1.l) == false) goto L24;
        r102 = q.f573401a;
        goto L30
    L24:
        if ((r210 instanceof pp1.m) == false) goto L27;
        r102 = new r(((pp1.m) r210).f530192a);
        goto L30
    L27:
        if ((r210 instanceof pp1.e) == false) goto L29;
        r102 = g.f573384a;
        goto L30
    L29:
        r102 = null;
        goto L30
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessInject
    public final ILiveEnterRoomCallback onBindBridge(ILivePreviewBusinessBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        return this.f573397a.k(r100);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f573397a.onClick(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f573397a.R9(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f573397a.p4(r100, r101);
    }
}
