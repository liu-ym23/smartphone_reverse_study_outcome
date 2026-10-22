package wx1;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import bw.p;
import com.bytedance.android.gamecp.host_api.model.user.FollowPair;
import com.bytedance.android.gamecp.host_api.model.user.IUser;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.lynx.tasm.LynxError;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements hw.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IUser f561761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.gamecp.base.cache.c f561762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PublishSubject<IUser> f561763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishProcessor<hw.c> f561764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<IUser> f561765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f561766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f561767g;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f561768a;

        public a(g r100) {
            this.f561768a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((UserEvent) r100).isLogin() == false) goto L5;
            g r101 = this.f561768a;
            r101.f(r101.f561767g.b());
            this.f561768a.g().subscribe(new f(this));
            return;
        L5:
            this.f561768a.f(new wx1.e());
            g r102 = this.f561768a;
            PublishProcessor<hw.c> r103 = r102.f561764d;
            IUser.Status r104 = IUser.Status.Login;
            r103.onNext(new hw.c(r102.b()));
        }
    }

    public static final class b implements hw.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f561769a;

        public b(g r100) {
            this.f561769a = r100;
        }

        @Override // hw.a
        public final void a(User r100) {
            Intrinsics.checkNotNullParameter(r100, "user");
            g r101 = this.f561769a;
            if (r101.f561763c == null) goto L6;
            r101.f561761a = r100;
            r101.g().subscribe(new j(this, r100));
            return;
        }

        @Override // hw.a
        public final void onCancel(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            PublishSubject<IUser> r101 = this.f561769a.f561763c;
            if (r101 == null) goto L5;
            r101.onError(r100);
        L5:
            this.f561769a.f561763c = null;
            hw.d r102 = new hw.d();
            xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
            if (r103 == null) goto L9;
            r103.u(r102);
            return;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f561770a = null;

        static {
            f561770a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            BaseResponse r101 = (BaseResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            vh7.c r102 = jm2.a.d((vh7.c) r101.data);
            if (r102 == null) goto L7;
            com.bytedance.android.live.base.model.user.User r103 = (com.bytedance.android.live.base.model.user.User) r102;
            User r104 = new User();
            r104.setNickName(r103.getNickName());
            r104.setAvatarThumb(wx1.a.b(r103.getAvatarThumb()));
            r104.setAvatarMedium(wx1.a.b(r103.getAvatarMedium()));
            r104.setAvatarLarge(wx1.a.b(r103.getAvatarLarge()));
            r104.setIdStr(r103.getIdStr());
            r104.setId(r103.getUserId());
            return r104;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.User");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f561771a;

        public d(g r100) {
            this.f561771a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IUser r101 = (IUser) r100;
            Intrinsics.checkNotNullParameter(r101, "user");
            this.f561771a.f561765e.onNext(r101);
            this.f561771a.f561761a = r101;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f561772a = null;

        static {
            f561772a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @Override // hw.b
    public final IUser b() {
        String r100 = this.f561761a.getId();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        f(this.f561767g.b());
    L12:
        return this.f561761a;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final Single<IUser> g() {
        String r100 = this.f561767g.getCurUserId();
        Single<BaseResponse<IBaseUser, UserExtra>> r101 = ((IUserService) k.n(IUserService.class)).user().r(r100);
        if (r101 == null) goto L15;
        Single<BaseResponse<IBaseUser, UserExtra>> r102 = r101.subscribeOn(Schedulers.io());
        if (r102 == null) goto L15;
        Single<R> r103 = r102.map(c.f561770a);
        if (r103 == 0) goto L15;
        Single r104 = r103.observeOn(AndroidSchedulers.mainThread());
        if (r104 == null) goto L15;
        Single r105 = r104.doOnSuccess(new d(this));
        if (r105 == null) goto L15;
        Single<IUser> r106 = r105.doOnError(e.f561772a);
        if (r106 == null) goto L15;
        return r106;
    L15:
        return Single.never();
    }

    @Override // hw.b
    public final String getCurrentUserId() {
        String r100 = this.f561761a.getId();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        f(this.f561767g.b());
    L12:
        return this.f561761a.getId();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // hw.b
    public final boolean isLogin() {
        return ((od1.a) k.n(od1.a.class)).shouldTreatAsLoggedIn();
    }

    public g(p r100) {
        Intrinsics.checkNotNullParameter(r100, "userService");
        this.f561767g = r100;
        this.f561761a = new wx1.e();
        this.f561762b = new com.bytedance.android.gamecp.base.cache.c();
        this.f561764d = new PublishProcessor();
        this.f561765e = PublishSubject.create();
        this.f561766f = new b(this);
        f(r100.b());
        Flowable<UserEvent> r101 = ((IUserService) k.n(IUserService.class)).user().x();
        if (r101 == null) goto L6;
        r101.subscribe(new a(this));
    L6:
        if (r100.getCurUserId().length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        g().subscribe(new com.bytedance.android.livesdk.gamecp.utils.e());
        return;
    L12:
        return;
    L8:
        r102 = false;
        goto L9
    }

    public static FragmentActivity e(Context r100) {
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if ((r100 instanceof Application) == true) goto L13;
        if ((r100 instanceof FragmentActivity) == false) goto L11;
        return (FragmentActivity) r100;
    L11:
        if ((r100 instanceof ContextWrapper) == false) goto L13;
        return e(((ContextWrapper) r100).getBaseContext());
    }

    @Override // hw.b
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        IUser r101 = (IUser) this.f561762b.a(r100);
        if (r101 == null) goto L6;
        String r102 = r101.getSecUid();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.android.livesdk.user.a$a, com.bytedance.android.livesdk.user.b$a] */
    @Override // hw.b
    public final Observable<FollowPair> d(com.bytedance.android.gamecp.host_api.model.user.b r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        String r100 = r110.f57402a;
        long r111 = r110.f57404b;
        HashMap r101 = new HashMap();
        String r102 = "";
        String r103 = null;
        Pair r104 = new Pair("", null);
        IRoomService r105 = (IRoomService) k.f(IRoomService.class);
        if (r105 == null) goto L5;
        Room r106 = r105.getCurrentRoom();
    L6:
        if (r106 == null) goto L18;
        String r107 = r106.getOwnerUserIdString();
        if (r107 == null) goto L12;
        r102 = r107;
    L12:
        if (r106.mo8271getOwner() == null) goto L16;
        com.bytedance.android.live.base.model.user.User r108 = r106.mo8271getOwner();
        if (r108 == null) goto L16;
        r103 = r108.getSecUid();
    L16:
        r104 = new Pair(r102, r103);
    L18:
        if (((CharSequence) r104.getFirst()).length() <= 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L24;
        r101.put("anchor_id", r104.getFirst());
    L24:
        if (r104.getSecond() == null) goto L26;
        r101.put("sec_anchor_id", r104.getSecond());
    L26:
        PublishSubject r112 = PublishSubject.create();
        long r113 = SystemClock.uptimeMillis();
        Observable<com.bytedance.android.livesdkapi.depend.model.follow.FollowPair> r114 = ((IUserService) k.n(IUserService.class)).user().h(((com.bytedance.android.livesdk.user.b.a) new com.bytedance.android.livesdk.user.b.C2427b().h(r111).c(r100)).d());
        if (r114 == null) goto L29;
        r114.subscribe(new h(this, r112, r100, r111, r113), new i(this, r112, r100, r111, r113));
    L29:
        return r112;
    L20:
        r109 = false;
        goto L21
    L5:
        r106 = null;
        goto L6
    }

    public final void f(IUser r100) {
        if (r100 == null) goto L4;
        this.f561761a = r100;
        PublishProcessor<hw.c> r101 = this.f561764d;
        IUser.Status r102 = IUser.Status.Login;
        r101.onNext(new hw.c(r100));
        this.f561762b.b(r100.getId(), r100);
        this.f561765e.onNext(r100);
        return;
    L4:
        this.f561761a = new wx1.e();
    }

    @Override // hw.b
    public final Observable<IUser> c(Context r100, com.bytedance.android.gamecp.host_api.model.user.c r101) {
        FragmentActivity r102 = e(r100);
        if (r102 == null) goto L11;
        p r103 = this.f561767g;
        b r104 = this.f561766f;
        Intrinsics.checkNotNull(r101);
        r103.v1(r102, r104, r101.f57406a, r101.f57407b, r101.f57408c);
        PublishSubject<IUser> r105 = PublishSubject.create();
        this.f561763c = r105;
        if (r105 == null) goto L9;
        Observable<IUser> r106 = r105.observeOn(AndroidSchedulers.mainThread());
        if (r106 == null) goto L9;
        return r106;
    L9:
        return Observable.empty();
    L11:
        throw new IllegalArgumentException("Argument \"context\" cannot be transformed to FragmentActivity in UserCenter.login() method. ");
    }
}
