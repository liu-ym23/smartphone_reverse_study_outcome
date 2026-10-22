package n62;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends n62.a implements s22.e.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShareParams f518125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f518126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f518127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f518128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s22.e f518129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f518130k;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f518131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s22.a f518132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f518133c;

        public b(e r100, s22.a r101, String r102) {
            this.f518131a = r100;
            this.f518132b = r101;
            this.f518133c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f518131a.e(this.f518132b, this.f518133c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f518134a = null;

        static {
            f518134a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f518135a = null;

        static {
            f518135a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    /* JADX INFO: renamed from: n62.e$e, reason: collision with other inner class name */
    public static final class RunnableC6900e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f518136a;

        public RunnableC6900e(String r100) {
            this.f518136a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f2.c(this.f518136a, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f518137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s22.a f518138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f518139c;

        public f(e r100, s22.a r101, long r102) {
            this.f518137a = r100;
            this.f518138b = r101;
            this.f518139c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            int r102 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f132999a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.h(this.f518138b, r101.logId, this.f518139c);
            j r103 = (j) r101.data;
            if (r103 == null) goto L5;
            int r104 = r103.b();
        L6:
            j r105 = (j) r101.data;
            if (r105 == null) goto L9;
            long r106 = r105.a();
        L10:
            j r107 = (j) r101.data;
            if (r107 == null) goto L14;
            String r108 = r107.c();
            if (r108 == null) goto L14;
        L15:
            e r109 = this.f518137a;
            r109.f518125f = r109.a(r104, r106, r108);
            Disposable r110 = this.f518137a.f518108b;
            if (r110 == null) goto L19;
            r110.dispose();
            return;
        L19:
            return;
        L14:
            r108 = "";
            goto L15
        L9:
            r106 = -1;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f518140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s22.a f518141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f518142c;

        public g(e r100, s22.a r101, long r102) {
            this.f518140a = r100;
            this.f518141b = r101;
            this.f518142c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f132999a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.g(this.f518141b, r101, this.f518142c);
            if ((r101 instanceof ApiServerException) == false) goto L5;
            f2.c(((ApiServerException) r101).getPrompt(), 0);
        L5:
            Disposable r103 = this.f518140a.f518108b;
            if (r103 == null) goto L9;
            r103.dispose();
            return;
        }
    }

    static {
    }

    @Override // s22.e.c
    public final void Df() {
    }

    @Override // s22.e.c
    public final void Ij(long r100, long r101, Long r102, Long r103, Throwable r104) {
    }

    @Override // s22.e.c
    public final void Nc() {
    }

    @Override // s22.e.c
    public final void Va(long r100) {
    }

    @Override // s22.e.c
    public final void Y9(long r100) {
    }

    @Override // s22.e.c
    public final void a3(long r100, Throwable r101) {
    }

    @Override // s22.e.c
    public final void p6(long r100) {
    }

    @Override // s22.e.c
    public final void t9(long r100) {
    }

    @Override // s22.e.c
    public final void Oo() {
        Disposable r100 = this.f518107a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        n62.a.f518105d = false;
    }

    @Override // s22.e.c
    public final void Dm(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void W5(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    public final void c(CompositeDisposable r100) {
        if (f72.b.a().user().isLogin() == true) goto L9;
        Bundle r101 = new Bundle();
        com.bytedance.android.livesdk.user.f r102 = f72.b.a().user();
        Context r103 = this.f518127h;
        l.a r104 = new l.a();
        r104.f158689e = "";
        r104.f158692h = r101;
        Disposable r105 = r102.login(r103, new l(r104)).subscribe(c.f518134a, d.f518135a);
        if (r105 == null) goto L13;
        RxUtilKt.c(r105, r100);
        return;
    L13:
        return;
    L9:
        if (this.f518130k == null) goto L14;
        n62.a.f518105d = true;
        this.f518129j.addListener(this);
        this.f518107a = Disposables.fromAction(new n62.g(this));
        this.f518129j.createChannel(this.f518130k.f518153d);
        int r106 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f132999a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.m(this.f518130k.f518153d);
        return;
    }

    @Override // s22.e.c
    public final void d8(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void gf(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void hb(List<? extends s22.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "channels");
        Intrinsics.checkNotNullParameter(r100, "channels");
    }

    @Override // s22.e.c
    public final void kf(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void vg(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void D9(s22.a r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Disposable r102 = this.f518107a;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        i r103 = this.f518130k;
        if (r103 != null) goto L8;
    L18:
        n62.a.f518105d = false;
        return;
    L8:
        if (r103.f518150a != true) goto L18;
        if (r103.f518152c == false) goto L13;
        if (r101 == null) goto L13;
        String r104 = r101.c();
    L14:
        long r105 = this.f518130k.f518151b;
        if (r105 <= 0) goto L17;
        MainThreadPostUtils.c(new b(this, r100, r104), r105);
        goto L18
    L17:
        e(r100, r104);
    L13:
        r104 = null;
        goto L14
    }

    @Override // s22.e.c
    public final void Gh(s22.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void Hh(long r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    @Override // s22.e.c
    public final void Rn(long r100, k r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    public final void d(s22.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        e(r100, r101);
    }

    public final void e(s22.a r110, String r210) {
        if ((this.f518127h instanceof FragmentActivity) == true) goto L6;
        this.f518128i.put("cmd_room_channel_show_invite_dialog", new f62.b(false, r210, r110));
        return;
    L6:
        long r100 = System.currentTimeMillis();
        n62.a.f518106e = true;
        ShareParams r111 = a(0, -1, "");
        Context r112 = this.f518127h;
        IVSPlayerService r101 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r102 = r101.provideVSPlayerViewControlService(this.f518128i);
        if (r102 == null) goto L11;
        r102.setVisibilityStatus(false);
    L11:
        int r103 = e62.a.f471117a;
        int r113 = (int) UtilityKotlinExtentionsKt.j(e62.a.b(this.f518109c));
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("openNewShareDialog, height is " + r113);
        DialogFragment r104 = ((IHostBusiness) jc1.k.n(IHostBusiness.class)).loadLiveSharePanel(r112, r111, Boolean.FALSE, Boolean.valueOf(this.f518129j.getConfig().f540289j), r113, new n62.f(this, r100, r112, r110));
        if (r104 == null) goto L14;
        this.f518129j.recordChatChannelDialog(this.f518126g, r104);
    L14:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_invite_panel_show", null);
        if (TextUtils.isEmpty(r210) == true) goto L17;
        MainThreadPostUtils.c(new RunnableC6900e(r210), 200);
    L17:
        this.f518108b = this.f518129j.getInviteId(r110.getChannelId()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new f(this, r110, r100), new g(this, r110, r100));
    }

    public e(RoomContext r100, Context r101, DataCenter r102, s22.e r103, i r104) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "chatManager");
        super(r100);
        this.f518127h = r101;
        this.f518128i = r102;
        this.f518129j = r103;
        this.f518130k = r104;
        this.f518126g = "SharePanel";
    }
}
