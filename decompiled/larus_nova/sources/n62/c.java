package n62;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j;
import com.bytedance.android.livesdk.user.l;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends n62.a implements s22.e.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f518112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s22.e f518113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.live.base.model.user.f> f518114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e f518115i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f518116a = null;

        static {
            f518116a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f518117a = null;

        static {
            f518117a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    /* JADX INFO: renamed from: n62.c$c, reason: collision with other inner class name */
    public static final class C6899c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f518118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s22.a f518119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f518120c;

        public C6899c(c r100, s22.a r101, long r102) {
            this.f518118a = r100;
            this.f518119b = r101;
            this.f518120c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            int r102 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f132999a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.h(this.f518119b, r101.logId, this.f518120c);
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
            c r109 = this.f518118a;
            s22.a r110 = this.f518119b;
            Disposable r111 = r109.f518108b;
            if (r111 == null) goto L18;
            r111.dispose();
        L18:
            ShareParams r112 = r109.a(r104, r106, r108);
            IHostBusiness r113 = (IHostBusiness) k.f(IHostBusiness.class);
            if (r113 == null) goto L22;
            r113.shareInviteMsg(r109.f518112f, r112, r109.f518114h, new n62.b(r109, r110));
            return;
        L22:
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

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f518121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s22.a f518122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f518123c;

        public d(c r100, s22.a r101, long r102) {
            this.f518121a = r100;
            this.f518122b = r101;
            this.f518123c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f132999a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.g(this.f518122b, r101, this.f518123c);
            if ((r101 instanceof ApiServerException) == false) goto L5;
            f2.c(((ApiServerException) r101).getPrompt(), 0);
        L5:
            Disposable r103 = this.f518121a.f518108b;
            if (r103 == null) goto L8;
            r103.dispose();
        L8:
            n62.a.f518106e = false;
            f2.b(R.string.ttlive_chat_channel_member_invite_failed, 0);
        }
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
        if (f72.b.a().user().isLogin() == true) goto L8;
        Bundle r101 = new Bundle();
        com.bytedance.android.livesdk.user.f r102 = f72.b.a().user();
        Context r103 = this.f518112f;
        l.a r104 = new l.a();
        r104.f158689e = "";
        r104.f158692h = r101;
        Disposable r105 = r102.login(r103, new l(r104)).subscribe(a.f518116a, b.f518117a);
        if (r105 == null) goto L10;
        RxUtilKt.c(r105, r100);
        return;
    L10:
        return;
    L8:
        n62.a.f518105d = true;
        this.f518113g.addListener(this);
        this.f518107a = Disposables.fromAction(new n62.d(this));
        this.f518113g.createChannel(this.f518115i);
        int r106 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f132999a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.m(this.f518115i);
    }

    public final void d(s22.a r100) {
        long r101 = System.currentTimeMillis();
        n62.a.f518106e = true;
        this.f518108b = this.f518113g.getInviteId(r100.getChannelId()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new C6899c(this, r100, r101), new d(this, r100, r101));
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
        d(r100);
        n62.a.f518105d = false;
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
    public final void Rn(long r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(RoomContext r100, Context r101, s22.e r102, List<? extends com.bytedance.android.live.base.model.user.f> r103, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r104) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatManager");
        Intrinsics.checkNotNullParameter(r103, "inviteUsers");
        super(r100);
        this.f518112f = r101;
        this.f518113g = r102;
        this.f518114h = r103;
        this.f518115i = r104;
    }
}
