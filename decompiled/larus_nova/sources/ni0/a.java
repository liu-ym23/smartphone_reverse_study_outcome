package ni0;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.mz;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f519205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f519206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f519207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f519208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f519209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f519210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f519211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f519212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f519213i;

    /* JADX INFO: renamed from: ni0.a$a, reason: collision with other inner class name */
    public static final class C6931a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f519214a;

        public b(a r100) {
            this.f519214a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("GroupLiveGameController", "detectOnlineTask run");     // Catch: Throwable -> L6
            if (hd0.c.f().h() == true) goto L9;
            ALogger.e("GroupLiveGameController", "detectOnlineTask, guest offline -> kick out");     // Catch: Throwable -> L6
            this.f519214a.getClass();     // Catch: Throwable -> L6
            a.a(true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements c0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f519215a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void Bh(ToolbarButton r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void Mr(s r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void R9(View r100, DataCenter r101) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void SY(s r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void Y6() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void onHide(boolean r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ void setAlpha(float r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final /* synthetic */ boolean showRedDot() {
            return false;
        }

        public c(a r100) {
            this.f519215a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100 == null) goto L5;
            this.f519215a.getClass();
            StringBuilder r101 = new StringBuilder();
            r101.append(mz.f120793a.getValue().getGameSelectPageScheme());
            r101.append("&enter_from=live&game_get_scene=3&conv_type=2&conversation_id=");
            String r102 = com.bytedance.android.live.liveinteract.revenue.game.c.f78318a;
            String r103 = qi0.c.f533088b;
            r101.append(qi0.c.h());
            String r104 = r101.toString();
            ALogger.i("ToolbarInteractPlayControlBehavior", "showGameSelectPage, schema: " + r104);
            ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(r100.getContext(), r104);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final void p4(View r100, DataCenter r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "dataCenter");
            HSImageView r102 = (HSImageView) r100.findViewById(R.id.icon);
            if (r102 == null) goto L6;
            a1.m(r102, R.drawable.ic_toolbar_button_for_group_live_game);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f519216a;

        public d(a r100) {
            this.f519216a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            ALogger.i("GroupLiveGameController", "linkPlayerState onChanged: " + ((Integer) r100));
            boolean r101 = hd0.c.f().g();
            a r102 = this.f519216a;
            if (r102.f519205a == r101) goto L12;
            if (r101 == false) goto L12;
            DataCenter r103 = r102.f519213i;
            if (r103 == null) goto L12;
            Room r104 = z.o(r103);
            if (r104 == null) goto L12;
            if (r104.isPrivatePlay() != true) goto L12;
            ALogger.e("GroupLiveGameController", "linkPlayerState onChanged, guest offline -> kick out");
            this.f519216a.getClass();
            a.a(false);
        L12:
            this.f519216a.f519205a = r101;
        }
    }

    static {
    }

    public a(DataCenter r100) {
        this.f519213i = r100;
        this.f519205a = hd0.c.f().g();
        this.f519206b = new d(this);
        mz r101 = mz.f120793a;
        this.f519207c = r101.getValue().getOnlineDetectIntervalInMills();
        this.f519208d = r101.getValue().getOfflineDetectEnable();
        this.f519209e = new b(this);
        this.f519210f = y3.m(r100);
        this.f519211g = new c(this);
    }

    public static void a(boolean r100) {
        n.a.a(qi0.d.f533091a, false, "forceUserLeaveRoom", null, 12);
        xs2.b.a().post(new h1(6));
        if (r100 == false) goto L6;
        f2.c(s1.B(R.string.ttlive_group_live_game_kick_off_tips), 0);
        return;
    }
}
