package zs1;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f573471a;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f573472a;

        public a(i r100) {
            this.f573472a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
            this.f573472a.f573471a.e();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f573473a = null;

        static {
            f573473a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("UgBalanceCouponController", "coupon login fail: " + ((Throwable) r100));
        }
    }

    @Override // zs1.e.a
    public final void onClose() {
        this.f573471a.l();
        g.k(this.f573471a, "close");
    }

    public i(g r100) {
        this.f573471a = r100;
    }

    @Override // zs1.e.a
    public final void a(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = this.f573471a.f573469i;
        if (r101 != null) goto L5;
    L10:
        Uri r102 = UriProtector.parse("sslocal://webcast_webview?web_bg_color=%23FFFFFF&status_bar_color=black&status_font_dark=1").buildUpon().appendQueryParameter("url", this.f573471a.f573469i).build();
        ILiveActionHandler r103 = (ILiveActionHandler) k.f(ILiveActionHandler.class);
        if (r103 == null) goto L13;
        r103.handle(this.f573471a.f121822c.getContext(), r102);
    L13:
        g.k(this.f573471a, "rule_url");
        return;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 != true) goto L10;
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // zs1.e.a
    public final void b(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        IUserService r101 = (IUserService) k.f(IUserService.class);
        if (r101 == null) goto L5;
        com.bytedance.android.livesdk.user.f r102 = r101.user();
    L6:
        if (r102 != null) goto L8;
    L10:
        l.a r103 = new l.a();
        r103.f158688d = "balance_to_coupon_popup";
        r103.f158687c = -1;
        l r104 = new l(r103);
        if (r102 == null) goto L15;
        Observable<IBaseUser> r105 = r102.login(this.f573471a.f121822c.getContext(), r104);
        if (r105 == null) goto L15;
        r105.subscribe(new a(this), b.f573473a);
    L15:
        g.k(this.f573471a, "exchange");
        return;
    L8:
        if (r102.isLogin() != true) goto L10;
        this.f573471a.e();
        goto L15
    L5:
        r102 = null;
        goto L6
    }
}
