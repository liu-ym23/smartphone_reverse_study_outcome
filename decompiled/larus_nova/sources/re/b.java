package re;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements td.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseLiveRoomFunctionHandler f537394a;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f537395a = null;

        static {
            f537395a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((IBaseUser) r100, "it");
            return new ge.a();
        }
    }

    /* JADX INFO: renamed from: re.b$b, reason: collision with other inner class name */
    public static final class C7468b implements ConfigObserver<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ud.a f537396a;

        @Override // com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
        public final Object getConfig() {
            return (String) this.f537396a.getConfig();
        }

        public C7468b(ud.a r100) {
            this.f537396a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
        public final void onChanged(Object r100) {
            ud.a r101 = this.f537396a;
            r101.onChanged((String) r100);
        }
    }

    @Override // td.b
    public final void a() {
    }

    @Override // td.b
    public final void d() {
    }

    @Override // td.b
    public final void e() {
        this.f537394a.startVBoost(0);
    }

    @Override // td.b
    public final void f() {
    }

    @Override // td.b
    public final void isLinkmic() {
    }

    @Override // td.b
    public final void onPurchasingIntentionAction() {
    }

    public b(IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "realHandler");
        this.f537394a = r100;
    }

    @Override // td.b
    public final void b(int r100) {
        this.f537394a.fullDialogHoverStateChange(r100, false);
    }

    @Override // td.b
    public final void c(boolean r100) {
        this.f537394a.onPermissionChange(0, r100);
    }

    @Override // td.b
    public final re.a getLogger(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "loggerClass");
        if (Intrinsics.areEqual(r100, be.b.class) == false) goto L7;
        return new re.a(this);
    L7:
        throw new Exception("unknown logger class");
    }

    @Override // td.b
    public final void h(ud.a<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "bitmapObserverEC");
        this.f537394a.takeLiveRoomScreenshot(new C7468b(r100));
    }

    @Override // td.b
    public final Observable<ge.a> g(Context r100, ge.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        IBaseLiveRoomFunctionHandler r102 = this.f537394a;
        l.a r103 = new l.a();
        r103.f158688d = r101.f480996d;
        r103.f158691g = r101.f480998f;
        r103.f158689e = r101.f480997e;
        r103.f158687c = r101.f480995c;
        r103.f158686b = r101.f480994b;
        r103.f158685a = r101.f480993a;
        return r102.loginIn(r100, new l(r103)).map(a.f537395a);
    }

    @Override // td.b
    public final boolean insertLegalMessage(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "legalMessageText");
        return this.f537394a.insertLegalMessage(r100, r101);
    }

    @Override // td.b
    public final void jetDanmaku(String r100, long r101, String r110, String r111) {
        IBaseLiveRoomFunctionHandler r102 = this.f537394a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (r110 != null) goto L7;
        String r103 = "";
    L8:
        if (r111 != null) goto L10;
        String r104 = "";
    L11:
        r102.jetDanmaku(r100, r101, r103, r104);
        return;
    L10:
        r104 = r111;
        goto L11
    L7:
        r103 = r110;
        goto L8
    }

    @Override // td.b
    public final void onCouponMessage(int r100, long r110, String r111, int r112, long r113) {
        this.f537394a.onCouponMessage(r100, r110, r111, r112, r113);
    }
}
