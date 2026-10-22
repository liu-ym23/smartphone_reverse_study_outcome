package ql1;

import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.SelectDanmuEmojiPresenter;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji;
import com.bytedance.ies.sdk.widgets.DataCenter;
import vr1.c0;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f533708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rl1.a f533709b;

    @Override // vr1.c0
    public final void a() {
        this.f533709b.a();
    }

    @Override // vr1.c0
    public final void b() {
        this.f533709b.b();
    }

    @Override // vr1.c0
    public final void dismissDialog() {
        this.f533709b.dismissDialog();
    }

    @Override // vr1.c0
    public final void c(IBaseEmoji r100) {
        this.f533709b.c(r100);
    }

    public a(c r100, SelectDanmuEmojiPresenter r101) {
        this.f533708a = r100;
        this.f533709b = r101;
    }

    @Override // vr1.c0
    public final void d(String r100, String r101) {
        int r102 = pl1.a.f529750a;
        DataCenter r103 = this.f533708a.f533716e;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        pl1.a.b(r103, r100, r101);
    }
}
