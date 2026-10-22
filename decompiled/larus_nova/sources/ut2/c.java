package ut2;

import com.bytedance.android.live.browser.jsbridge.base.UrgeGiftSendResultModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.urge.UrgeApi;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f551620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f551621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f551622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f551623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f551624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f551625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f551626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f551627h;

    public c(d r100, int r101, CompositeDisposable r102, String r103, String r104, long r105, long r106, String r110) {
        this.f551620a = r100;
        this.f551621b = r101;
        this.f551622c = r102;
        this.f551623d = r103;
        this.f551624e = r104;
        this.f551625f = r105;
        this.f551626g = r106;
        this.f551627h = r110;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Long r111 = (Long) r110;
        if (this.f551620a.f551628a.isDiamondAvailable(this.f551621b) == true) goto L5;
        d r112 = this.f551620a;
        d.j(r112, r112.getCallContext().getContext());
        d r113 = this.f551620a;
        UrgeGiftSendResultModel r100 = new UrgeGiftSendResultModel();
        r100.b(Boolean.TRUE);
        r100.a(UrgeGiftSendResultModel.Code.Success);
        Unit r101 = Unit.INSTANCE;
        r113.finishWithResult(r100);
        this.f551622c.clear();
        return;
    L5:
        RxUtilKt.c(RxUtilKt.h(UrgeApi.CC.sendGift$default((UrgeApi) com.bytedance.android.live.network.c.b().e(UrgeApi.class), this.f551623d, this.f551624e, this.f551625f, this.f551626g, 0, 16, null)).subscribe(new a(this), new b(this)), this.f551622c);
    }
}
