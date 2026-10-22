package v62;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.vip.e;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.comment.input.LiveCommonInputDialog;
import com.bytedance.android.livesdk.interactivity.comment.input.framework.PanelType;
import com.ss.ttm.player.MediaPlayer;
import i40.h;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements u62.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelType f553384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f553385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f553386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u62.b f553387d;

    /* JADX INFO: renamed from: v62.a$a, reason: collision with other inner class name */
    public interface InterfaceC7966a {
        void a();

        void c(BaseEmoji r100, String r101);

        void dismissDialog();
    }

    @Override // u62.c
    public final void b() {
    }

    @Override // u62.c
    public final void c() {
    }

    @Override // u62.c
    public final void a() {
        u62.b r100 = this.f553387d;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME);
        if (r100.d() == 0) goto L8;
        r101 = r100.d();
    L8:
        View r102 = this.f553386c;
        if (r102 == null) goto L11;
        a1.k(r102, r101);
    L11:
        String r103 = "on panel switch to emoji, height: " + r101;
        Intrinsics.checkNotNullParameter(r103, "msg");
        Intrinsics.checkNotNullParameter(r103, "msg");
        h.a(r103);
        e r104 = yt0.c.l();
        if (r104 == null) goto L15;
        r104.bn("emoji");
        return;
    }

    public a() {
        this.f553384a = PanelType.EMOJI;
    }

    public final View d(LiveCommonInputDialog.j r110) {
        Intrinsics.checkNotNullParameter(r110, "panelBridge");
        this.f553387d = r110;
        if (this.f553385b == true) goto L22;
        if (k.f(IMiddleWareHostContext.class) != null) goto L8;
        Intrinsics.checkNotNullParameter("init emoji panel error IHostContext null", "msg");
        Intrinsics.checkNotNullParameter("init emoji panel error IHostContext null", "msg");
        h.a("init emoji panel error IHostContext null");
        goto L22
    L8:
        Context r100 = ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).context();
        if (r100 != null) goto L11;
        Intrinsics.checkNotNullParameter("init emoji panel error context null", "msg");
        Intrinsics.checkNotNullParameter("init emoji panel error context null", "msg");
        h.a("init emoji panel error context null");
        goto L22
    L11:
        int r101 = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME);
        IExpressionService r102 = (IExpressionService) k.n(IExpressionService.class);
        boolean r103 = r110.f();
        int r104 = s1.y();
        i r105 = new i();
        r105.f133215a = true;
        Unit r106 = Unit.INSTANCE;
        View r107 = r102.createNewEmojiSelectPanel(r100, r103, r104, r105, new b(r110));
        this.f553386c = r107;
        boolean r108 = r107 instanceof jf2.a;
        Object r109 = r107;
        if (r108 == true) goto L14;
        r109 = null;
    L14:
        jf2.a r111 = (jf2.a) r109;
        if (r111 == null) goto L17;
        r110.g(new c(r111));
    L17:
        ViewGroup.LayoutParams r112 = new ViewGroup.LayoutParams(-1, r101);
        View r113 = this.f553386c;
        if (r113 == null) goto L20;
        r113.setLayoutParams(r112);
    L20:
        this.f553385b = true;
        String r114 = "emoji panel init, opt: true, height: " + r101;
        Intrinsics.checkNotNullParameter(r114, "msg");
        Intrinsics.checkNotNullParameter(r114, "msg");
        h.a(r114);
    L22:
        return this.f553386c;
    }
}
