package qk1;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.g;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.profile.repository.NewProfileApi;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.service.h;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "资料卡已迁移，profile目录中代码废弃")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f533454a;

    /* JADX INFO: renamed from: qk1.a$a, reason: collision with other inner class name */
    public static final class C7346a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f533455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f533456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Room f533457c;

        public C7346a(boolean r100, Function1 r101, Room r102) {
            this.f533455a = r100;
            this.f533456b = r101;
            this.f533457c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Response r111 = (Response) r110;
            if (r111 == null) goto L26;
            r0 r100 = (r0) r111.data;
            if (r100 == null) goto L27;
            boolean r101 = false;
            if (r100.setStatus == false) goto L11;
            e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.f158141e3;
            Boolean r103 = Boolean.valueOf(this.f533455a);
            r102.getClass();
            f.d(r102, r103);
            this.f533456b.invoke(0L);
        L21:
            int r104 = LiveRoomManageAppLogger.f111181b;
            Room r105 = this.f533457c;
            r0 r112 = (r0) r111.data;
            boolean r106 = r112.setStatus;
            if (r112.userGiftOffReason != 5) goto L24;
            r101 = true;
        L24:
            LiveRoomManageAppLogger.u(r105, r106, r101, this.f533455a);
            return;
        L11:
            this.f533456b.invoke(Long.valueOf(r100.userGiftOffReason));
            r0 r107 = (r0) r111.data;
            long r108 = r107.userGiftOffReason;
            if (r108 != 5) goto L15;
            f2.b(R.string.ttlive_user_setting_receive_gift_disable_without_verify, 0);
            goto L21
        L15:
            if (r108 != 7) goto L17;
            f2.b(R.string.ttlive_user_setting_receive_gift_disable_without_face_detect, 0);
            goto L21
        L17:
            String r109 = r107.failMessage;
            if (r109 != null) goto L20;
            r109 = s1.B(R.string.ttlive_user_setting_receive_gift_disable);
        L20:
            f2.c(r109, 0);
            goto L21
        L27:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f533458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f533459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f533460c;

        public b(Function1 r100, Room r101, boolean r102) {
            this.f533458a = r100;
            this.f533459b = r101;
            this.f533460c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if ((r101 instanceof ApiServerException) == false) goto L5;
            f2.c(((ApiServerException) r101).getPrompt(), 0);
        L5:
            this.f533458a.invoke(0L);
            int r102 = LiveRoomManageAppLogger.f111181b;
            LiveRoomManageAppLogger.u(this.f533459b, false, false, this.f533460c);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f533461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f533462b;

        public c(Function1 r100, Function1 r101) {
            this.f533461a = r100;
            this.f533462b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            if (r101 == null) goto L17;
            T r102 = r101.data;
            if (((g) r102) == null) goto L18;
            Function1 r103 = this.f533461a;
            if (r103 == null) goto L12;
            Unit r104 = (Unit) r103.invoke(r102);
        L12:
            if (((g) r101.data).userGiftSwitch != 1) goto L14;
            e<Boolean> r105 = com.bytedance.android.livesdk.sharedpref.b.f158141e3;
            Boolean r106 = Boolean.TRUE;
            r105.getClass();
            f.d(r105, r106);
            this.f533462b.invoke(0L);
            return;
        L14:
            e<Boolean> r107 = com.bytedance.android.livesdk.sharedpref.b.f158141e3;
            Boolean r108 = Boolean.FALSE;
            r107.getClass();
            f.d(r107, r108);
            this.f533462b.invoke(Long.valueOf(((g) r101.data).userGiftOffReason));
            return;
        L18:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f533463a = null;

        static {
            f533463a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public a() {
        this.f533454a = new CompositeDisposable();
    }

    public final void a(boolean r210, Function1<? super Long, Unit> r211) {
        Intrinsics.checkNotNullParameter(r211, "updateUICallback");
        String r100 = null;
        long r101 = 0;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L7;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L7;
        Room r104 = r103.getValue();
    L8:
        IUserService r105 = (IUserService) k.f(IUserService.class);
        if (r105 == null) goto L11;
        com.bytedance.android.livesdk.user.f r106 = r105.user();
    L12:
        if (r106 == null) goto L14;
        r100 = r106.n();
    L14:
        String r107 = r100;
        if (r104 == null) goto L17;
        r101 = r104.getRoomId();
    L17:
        long r110 = r101;
        if (r104 == null) goto L23;
        User r108 = r104.mo8271getOwner();
        if (r108 == null) goto L23;
        String r109 = r108.getIdStr();
        if (r109 == null) goto L23;
    L24:
        String r111 = r109;
        if (r210 == false) goto L27;
        long r112 = 1;
    L28:
        l.d().getClass();
        this.f533454a.add(RxUtilKt.i(((NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class)).postSetting(r107, 0, 0, r110, r111, 1, r112).subscribeOn(Schedulers.io())).subscribe(new C7346a(r210, r211, r104), new b(r211, r104, r210)));
        return;
    L27:
        r112 = 2;
    L23:
        r109 = "0";
        goto L24
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final void b(Function1<? super g, Unit> r100, Function1<? super Long, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "updateUICallback");
        String r102 = null;
        long r103 = 0;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L7;
        m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L7;
        Room r106 = r105.getValue();
    L8:
        IUserService r107 = (IUserService) k.f(IUserService.class);
        if (r107 == null) goto L11;
        com.bytedance.android.livesdk.user.f r108 = r107.user();
    L12:
        h r109 = TTLiveSDKContext.getHostService();
        if (r109 == null) goto L20;
        com.bytedance.android.livesdk.user.f r110 = ((com.bytedance.android.livesdk.service.f) r109).h();
        if (r110 == null) goto L20;
        if (r108 == null) goto L18;
        r102 = r108.n();
    L18:
        String r111 = ((f0) r110).a(r102);
        if (r111 == null) goto L20;
    L21:
        if (r106 == null) goto L23;
        r103 = r106.getRoomId();
    L23:
        if (r106 == null) goto L28;
        User r112 = r106.mo8271getOwner();
        if (r112 == null) goto L28;
        String r113 = r112.getIdStr();
        if (r113 == null) goto L28;
    L29:
        l.d().getClass();
        this.f533454a.add(RxUtilKt.i(((NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class)).getSetting(r111, r103, r113).subscribeOn(Schedulers.io())).subscribe(new c(r100, r101), d.f533463a));
        return;
    L28:
        r113 = "0";
    L20:
        r111 = "";
        goto L21
    L11:
        r108 = null;
    L7:
        r106 = null;
        goto L8
    }

    public final void c(long r110, Function1 r111) {
        Intrinsics.checkNotNullParameter("", "key");
        Intrinsics.checkNotNullParameter(r111, "updateUICallback");
        com.bytedance.android.livesdk.user.f r100 = null;
        long r101 = 0;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L7;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L7;
        Room r104 = r103.getValue();
    L8:
        IUserService r105 = (IUserService) k.f(IUserService.class);
        if (r105 == null) goto L12;
        r100 = r105.user();
    L12:
        if (r100 == null) goto L17;
        String r106 = r100.n();
        if (r106 == null) goto L17;
        String r107 = r106;
    L18:
        if (r104 == null) goto L20;
        r101 = r104.getRoomId();
    L20:
        long r108 = r101;
        if (r104 == null) goto L28;
        User r109 = r104.mo8271getOwner();
        if (r109 == null) goto L28;
        String r112 = r109.getIdStr();
        if (r112 == null) goto L28;
        String r113 = r112;
    L29:
        l.d().getClass();
        this.f533454a.add(RxUtilKt.i(((NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class)).updateAnchorUserRelationSwitch(r107, r108, r113, 1, r110).subscribeOn(Schedulers.io())).subscribe(new qk1.b(r111), qk1.c.f533465a));
        return;
    L28:
        r113 = "0";
    L17:
        r107 = "0";
    L7:
        r104 = null;
        goto L8
    }
}
