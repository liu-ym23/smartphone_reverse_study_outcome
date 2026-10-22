package lm0;

import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements u71.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f509823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f509824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g71.b f509825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f509826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f509827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f509828f;

    /* JADX INFO: renamed from: lm0.a$a, reason: collision with other inner class name */
    public static final class C6710a {
    }

    static {
    }

    @Override // u71.b
    public void a() {
        Disposable r100 = this.f509823a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f509824b.clear();
    }

    @Override // u71.b
    public final void reset() {
        Disposable r100 = this.f509823a;
        if (r100 != null) goto L5;
    L10:
        this.f509824b.clear();
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    @Override // u71.b
    public final void c(gm0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "commonCardObserver");
        this.f509825c = r100;
    }

    public final void d(int r100) {
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L6;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r102 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_trigger");
        r102.b(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, Integer.valueOf(r100));
        r102.b("trigger_name", b().getDesc());
        r102.b("trigger_value", this.f509827e);
        Unit r103 = Unit.INSTANCE;
        r101.b(r102.a());
    L6:
        g71.b r104 = this.f509825c;
        if (r104 == null) goto L10;
        r104.a(Integer.valueOf(r100));
        return;
    }

    public a(DataCenter r100, Long r101, int r102) {
        this.f509826d = r100;
        this.f509827e = r101;
        this.f509828f = r102;
        this.f509824b = new CompositeDisposable();
    }
}
