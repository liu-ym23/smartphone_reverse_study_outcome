package p82;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.b7;
import com.bytedance.android.livesdk.c7;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.h6;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.MarkUserApi;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends p82.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveSwitchButton f528130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f528131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f528132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f528133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f528134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f528135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f528136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f528137l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f528138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f528139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.livesdk.sharedpref.e<Boolean> f528140o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f528141p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f528142q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CompositeDisposable f528143r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RoomContext f528144s;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f528145a;

        public b(p r100) {
            this.f528145a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            TextView r102 = this.f528145a.f528132g;
            if (r102 == null) goto L6;
            UtilityKotlinExtentionsKt.t(r102);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f528146a;

        public c(p r100) {
            this.f528146a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.c r101 = (com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.c) ((Response) r100).data;
            if (r101 == null) goto L5;
            Boolean r102 = r101.a();
        L6:
            boolean r103 = false;
            if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L11;
            LiveSwitchButton r104 = this.f528146a.f528130e;
            if (r104 == null) goto L11;
            r104.f(false, false);
        L11:
            p r105 = this.f528146a;
            LiveSwitchButton r106 = r105.f528130e;
            if (r106 != null) goto L14;
        L16:
            r105.f528133h = r103;
            p r107 = this.f528146a;
            if (r107.f528133h == false) goto L19;
            String r108 = "on";
        L20:
            r107.f528137l = r108;
            return;
        L19:
            r108 = "off";
            goto L20
        L14:
            if (r106.isChecked() != true) goto L16;
            r103 = true;
            goto L16
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f528147a = null;

        static {
            f528147a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.e("PSOperatePanel", "get user mark status error");
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f528148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBaseUser f528149b;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f528150a;

            public a(e r100) {
                this.f528150a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r110) {
                BaseResponse r111 = (BaseResponse) r110;
                LiveSwitchButton r112 = this.f528150a.f528148a.f528130e;
                boolean r100 = false;
                if (r112 == null) goto L5;
                r112.f(false, false);
            L5:
                LiveSwitchButton r113 = this.f528150a.f528148a.f528130e;
                if (r113 == null) goto L8;
                r113.setEnabled(false);
            L8:
                p.f(this.f528150a.f528148a);
                p r114 = this.f528150a.f528148a;
                LiveSwitchButton r101 = r114.f528130e;
                if (r101 != null) goto L11;
            L13:
                boolean r102 = false;
            L14:
                r114.f528133h = r102;
                if (this.f528150a.f528148a.f528133h == false) goto L17;
                f2.c(s1.B(R.string.ttlive_mark_user_toast_content), 0);
            L18:
                p r115 = this.f528150a.f528148a;
                r115.f528136k = true;
                Map r116 = MapsKt.mapOf(TuplesKt.to("event_user_type", r115.d()));
                int r103 = com.bytedance.android.livesdk.interactivity.utils.r.f141414a;
                long r104 = this.f528150a.f528148a.f528073d.getId();
                RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
                if (r105 == null) goto L25;
                com.bytedance.live.datacontext.i<Boolean> r106 = r105.isAnchor();
                if (r106 == null) goto L25;
                if (r106.getValue().booleanValue() != true) goto L25;
                r100 = true;
            L25:
                com.bytedance.android.livesdk.interactivity.utils.r.a(r104, r100, r116);
                return;
            L17:
                f2.c(s1.B(R.string.ttlive_unmark_user_toast_content), 0);
                goto L18
            L11:
                if (r101.isChecked() != true) goto L13;
                r102 = true;
                goto L14
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f528151a;

            public b(e r100) {
                this.f528151a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                LiveSwitchButton r102 = this.f528151a.f528148a.f528130e;
                if (r102 == null) goto L5;
                r102.setEnabled(false);
            L5:
                p.f(this.f528151a.f528148a);
                String r103 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r101);
                if (r103 == null) goto L9;
                f2.c(r103, 0);
            L9:
                if (4021040 != com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r101)) goto L30;
                User r104 = this.f528151a.f528148a.f528144s.getRoom().getValue().mo8271getOwner();
                String r105 = "";
                if (r104 == null) goto L14;
                String r106 = r104.getIdString();
                if (r106 == null) goto L14;
            L16:
                if ((r101 instanceof CustomApiServerException) == true) goto L28;
            L25:
                r105 = null;
            L26:
                com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_tag_priority_display_user_upper_limit_toast", MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", r106), TuplesKt.to("upper_limit_user_number", r105)}), new Object[]{Room.class});
                return;
            L28:
                com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d r107 = (com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d) GsonHelper.get().fromJson(((CustomApiServerException) r101).getExtra(), com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d.class);     // Catch: Exception -> L23
                if (r107 == null) goto L26;
                String r108 = String.valueOf(r107.a());     // Catch: Exception -> L23
                if (r108 == null) goto L26;
                r105 = r108;
            L23:
                e = move-exception;
                ALogger.e("PSOperatePanel", "MarkUserItem limit parse error,e:" + e.getMessage());
            L14:
                r106 = "";
                goto L16
            }
        }

        public e(p r100, IBaseUser r101) {
            this.f528148a = r100;
            this.f528149b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f528148a.f528133h == false) goto L5;
            long r101 = 2;
        L6:
            long r102 = r101;
            MarkUserApi.f133742a.getClass();
            MarkUserApi r103 = (MarkUserApi) com.bytedance.android.live.network.c.b().e(MarkUserApi.class);
            if (r103 == null) goto L22;
            IBaseUser r104 = this.f528149b;
            if (r104 == null) goto L11;
            String r105 = r104.getIdString();
        L12:
            long r106 = d5.c(r105);
            IBaseUser r107 = this.f528149b;
            if (r107 == null) goto L16;
            String r108 = r107.getIdString();
            if (r108 == null) goto L16;
        L17:
            Observable<BaseResponse<Object, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.d>> r109 = r103.markUser(r106, r108, r102);
            if (r109 == null) goto L22;
            Disposable r110 = r109.subscribe(new a(this), new b(this));
            if (r110 == null) goto L22;
            RxUtilKt.c(r110, this.f528148a.f528143r);
        L16:
            r108 = "";
            goto L17
        L11:
            r105 = null;
        L22:
            TextView r111 = this.f528148a.f528132g;
            if (r111 == null) goto L26;
            UtilityKotlinExtentionsKt.t(r111);
            return;
        L26:
            return;
        L5:
            r101 = 1;
            goto L6
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f528152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e f528153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.entity.l f528154c;

        public f(p r100, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r101, com.bytedance.android.livesdk.interactivity.api.entity.l r102) {
            this.f528152a = r100;
            this.f528153b = r101;
            this.f528154c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TextView r101 = this.f528152a.f528132g;
            if (r101 == null) goto L5;
            UtilityKotlinExtentionsKt.t(r101);
        L5:
            this.f528152a.f528135j = RangesKt.coerceAtLeast(400, (int) s1.G(this.f528153b.ot()));
            String r102 = this.f528152a.f528134i + this.f528152a.f528135j;
            ILiveService r103 = TTLiveService.getLiveService();
            if (r103 == null) goto L9;
            r103.handleSchema(this.f528154c.getContext(), UriProtector.parse(r102));
            return;
        }
    }

    static {
    }

    @Override // p82.a
    public final int e() {
        return R.layout.ttlive_ps_panel_item_mark_user;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onDestroyView() {
        CompositeDisposable r100 = this.f528143r;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f528143r = null;
        if (this.f528133h == false) goto L8;
        String r101 = "on";
    L9:
        this.f528138m = r101;
        if (this.f528136k == false) goto L27;
        com.bytedance.android.livesdk.interactivity.api.entity.l r102 = this.f528071b;
        if (r102 == null) goto L14;
        com.bytedance.android.live.base.model.message.t r103 = r102.f133174b;
    L16:
        if ((r103 instanceof u3) == true) goto L18;
        r103 = null;
    L18:
        u3 r104 = (u3) r103;
        if (r104 == null) goto L21;
        IBaseUser r105 = r104.getUserInMessage();
    L22:
        Pair[] r106 = new Pair[4];
        r106[0] = TuplesKt.to("status_before", this.f528137l);
        r106[1] = TuplesKt.to("status_after", this.f528138m);
        r106[2] = TuplesKt.to("page_from", "comment_operate_panel");
        if (r105 == null) goto L25;
        String r107 = r105.getIdString();
    L26:
        r106[3] = TuplesKt.to("user_id", r107);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_tag_priority_display_user_click", MapsKt.mapOf(r106), new Object[]{Room.class});
        goto L27
    L25:
        r107 = null;
        goto L26
    L21:
        r105 = null;
        goto L22
    L14:
        r103 = null;
    L27:
        this.f528070a = null;
        return;
    L8:
        r101 = "off";
        goto L9
    }

    public p(RoomContext r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        super(PanelItemSymbol.MARK_USER);
        this.f528144s = r100;
        this.f528134i = c7.f104416a.getValue();
        this.f528137l = "off";
        this.f528138m = "off";
        this.f528139n = b7.f104236a.getValue();
        this.f528140o = new com.bytedance.android.livesdk.sharedpref.e("mark_user_bubble_" + r100.getUser().getValue().getIdString(), Boolean.FALSE);
        this.f528141p = h6.f132628a.getValue();
        this.f528142q = 5000;
    }

    public static final void f(p r100) {
        RxUtilKt.c(RxUtilKt.h(Observable.timer(r100.f528141p.longValue(), TimeUnit.MILLISECONDS)).subscribe(new q(r100)), r100.f528143r);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        RoomAuthStatus r101 = this.f528144s.getRoom().getValue().getRoomAuthStatus();
        if (r101 != null) goto L5;
    L9:
        boolean r102 = false;
    L10:
        com.bytedance.android.live.base.model.message.t r103 = r100.f133174b;
        com.bytedance.android.live.base.model.message.t r104 = null;
        if ((r103 instanceof u3) == true) goto L13;
        r103 = null;
    L13:
        u3 r105 = (u3) r103;
        if (r105 == null) goto L16;
        IBaseUser r106 = r105.getUserInMessage();
    L18:
        if ((r106 instanceof User) == true) goto L20;
        r106 = null;
    L20:
        User r107 = (User) r106;
        IUserService r108 = (IUserService) jc1.k.f(IUserService.class);
        if (r108 == null) goto L26;
        com.bytedance.android.livesdk.user.f r109 = r108.user();
        if (r109 == null) goto L26;
        String r110 = r109.n();
        if (r110 == null) goto L26;
    L27:
        if (r107 != null) goto L29;
    L33:
        boolean r111 = false;
    L34:
        com.bytedance.android.live.base.model.message.t r112 = r100.f133174b;
        if ((r112 instanceof k0) == true) goto L37;
        r112 = null;
    L37:
        k0 r113 = (k0) r112;
        if (r113 != null) goto L40;
    L50:
        boolean r114 = true;
    L51:
        if (r102 == false) goto L56;
        if (r111 == false) goto L57;
        if (r114 == false) goto L58;
        return true;
    L58:
        return false;
    L57:
        return false;
    L56:
        return false;
    L40:
        if (r113.isFromOtherIntercomRoom() != true) goto L50;
        com.bytedance.android.live.base.model.message.t r115 = r100.f133174b;
        if ((r115 instanceof k0) == false) goto L45;
        r104 = r115;
    L45:
        k0 r116 = (k0) r104;
        if (r116 == null) goto L50;
        if (r116.intercomHideUserCard() != true) goto L50;
        r114 = false;
        goto L51
    L29:
        if (r107.isMysteryMan() == true) goto L33;
        if ((!Intrinsics.areEqual(r107.getIdString(), r110)) == false) goto L33;
        r111 = true;
    L26:
        r110 = "0";
        goto L27
    L16:
        r106 = null;
        goto L18
    L5:
        if (r101.isEnableMarkUser() != true) goto L9;
        if (this.f528144s.isAnchor().getValue().booleanValue() == false) goto L9;
        r102 = true;
        goto L10
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r100) {
        TextView r101 = this.f528132g;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r101);
        return;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void c(com.bytedance.android.livesdk.interactivity.api.entity.l r100, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "bridge");
        super.c(r100, r101);
        View r102 = getView(r100.getContext());
        String r103 = null;
        if (r102 == null) goto L5;
        ImageView r104 = (ImageView) r102.findViewById(R.id.mark_user_tips);
    L6:
        this.f528131f = r104;
        View r105 = getView(r100.getContext());
        if (r105 == null) goto L9;
        LiveSwitchButton r106 = (LiveSwitchButton) r105.findViewById(R.id.btn_mark_user);
    L10:
        this.f528130e = r106;
        View r107 = getView(r100.getContext());
        if (r107 == null) goto L13;
        TextView r108 = (TextView) r107.findViewById(R.id.tip_content);
    L14:
        this.f528132g = r108;
        com.bytedance.android.live.base.model.message.t r109 = r100.f133174b;
        if ((r109 instanceof u3) == true) goto L17;
        r109 = null;
    L17:
        u3 r110 = (u3) r109;
        if (r110 == null) goto L20;
        IBaseUser r111 = r110.getUserInMessage();
    L21:
        this.f528143r = new CompositeDisposable();
        Boolean r112 = this.f528140o.getValue();
        Boolean r113 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r112, r113)) == false) goto L30;
        TextView r114 = this.f528132g;
        if (r114 == null) goto L26;
        r114.setText(this.f528139n);
    L26:
        TextView r115 = this.f528132g;
        if (r115 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r115);
    L29:
        RxUtilKt.c(RxUtilKt.h(Observable.timer(this.f528142q, TimeUnit.MILLISECONDS)).subscribe(new b(this)), this.f528143r);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r116 = this.f528140o;
        r116.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r116, r113);
        com.bytedance.android.livesdk.log.u.l().d("livesdk_anchor_tag_priority_display_user_bubble_show", new Object[]{Room.class});
    L33:
        MarkUserApi.f133742a.getClass();
        MarkUserApi r117 = (MarkUserApi) com.bytedance.android.live.network.c.b().e(MarkUserApi.class);
        if (r117 == null) goto L49;
        if (r111 == null) goto L37;
        r103 = r111.getIdString();
    L37:
        long r118 = d5.c(r103);
        if (r111 == null) goto L41;
        String r119 = r111.getIdString();
        if (r119 == null) goto L41;
    L42:
        Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.c>> r120 = r117.getUserMarked(r118, r119, "mark");
        if (r120 == null) goto L49;
        Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.c>> r121 = r120.observeOn(AndroidSchedulers.mainThread());
        if (r121 == null) goto L49;
        Disposable r122 = r121.subscribe(new c(this), d.f528147a);
        if (r122 == null) goto L49;
        RxUtilKt.c(r122, this.f528143r);
    L41:
        r119 = "";
    L49:
        LiveSwitchButton r123 = this.f528130e;
        if (r123 == null) goto L52;
        r123.setOnClickListener(new e(this, r111));
    L52:
        ImageView r124 = this.f528131f;
        if (r124 == null) goto L56;
        r124.setOnClickListener(new f(this, r101, r100));
        return;
    L56:
        return;
    L30:
        TextView r125 = this.f528132g;
        if (r125 == null) goto L33;
        UtilityKotlinExtentionsKt.t(r125);
        goto L33
    L20:
        r111 = null;
        goto L21
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
