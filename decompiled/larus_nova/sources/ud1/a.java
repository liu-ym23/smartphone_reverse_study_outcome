package ud1;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.admin.api.AdminApi2;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wd1.a f549723a;

    /* JADX INFO: renamed from: ud1.a$a, reason: collision with other inner class name */
    public static final class C7863a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f549724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f549725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f549726c;

        public b(a r100, String r101, boolean r102) {
            this.f549724a = r100;
            this.f549725b = r101;
            this.f549726c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            User r102 = new User();
            r102.setIdStr(this.f549725b);
            wd1.a r103 = this.f549724a.f549723a;
            if (r103 == null) goto L6;
            r103.y1(this.f549726c, r102);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f549727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f549728b;

        public c(a r100, boolean r101) {
            this.f549727a = r100;
            this.f549728b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            wd1.a r102 = this.f549727a.f549723a;
            if (r102 == null) goto L6;
            r102.U1(this.f549728b, (Exception) r101);
            return;
        }
    }

    static {
    }

    public a(wd1.a r100) {
        this.f549723a = r100;
    }

    public final void a(boolean r110, String r111, String r112, String r113, long r114, String r210) {
        Intrinsics.checkNotNullParameter(r111, "userId");
        Intrinsics.checkNotNullParameter(r113, "anchorId");
        Intrinsics.checkNotNullParameter(r210, "enterMethod");
        Room r100 = ((IRoomService) k.n(IRoomService.class)).getCurrentRoom();
        if (r100 == null) goto L12;
        User r101 = r100.mo8271getOwner();
        if (r101 == null) goto L12;
        o0.a r102 = o0.f58946a;
        String r103 = r101.getIdStr();
        r102.getClass();
        if (o0.a.a(r103, r113) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        String r104 = r101.getCastSecUid();
    L13:
        l.d().getClass();
        AdminApi2 r105 = (AdminApi2) com.bytedance.android.live.network.c.b().e(AdminApi2.class);
        if (r110 == false) goto L16;
        int r106 = 3;
    L17:
        RxUtilKt.h(r105.updateAdmin(r106, r111, r112, r113, r104, r114, "room", r210).subscribeOn(Schedulers.io())).subscribe(new b(this, r111, r110), new c(this, r110));
        return;
    L16:
        r106 = 2;
    L12:
        r104 = null;
        goto L13
    }
}
