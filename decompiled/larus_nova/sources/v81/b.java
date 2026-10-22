package v81;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.config.setting.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import u81.f;
import zg1.s0;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends v81.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f553650e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f553651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f553652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f553653d;

    public static final class a {
    }

    /* JADX INFO: renamed from: v81.b$b, reason: collision with other inner class name */
    public static final class C7972b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f553654a;

        public C7972b(b r100) {
            this.f553654a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            Iterator r102 = ((ArrayList) this.f553654a.f553649a).iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            f.a r103 = (f.a) r102.next();
            if (r103 == null) goto L4;
            r103.a();
            goto L4
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f553655a;

        public c(b r100) {
            this.f553655a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            s0 r101 = (s0) r100;
            int r102 = r101.f571934a;
            if (r102 == 0) goto L11;
            if (r102 != 1) goto L21;
            Disposable r103 = this.f553655a.f553653d;
            if (r103 == null) goto L18;
            r103.dispose();
            return;
        L18:
            return;
        L21:
            return;
        L11:
            if (r101.f571935b != 0) goto L16;
            b r104 = this.f553655a;
            Disposable r105 = r104.f553653d;
            if (r105 == null) goto L15;
            r105.dispose();
        L15:
            r104.f553653d = Observable.just("").observeOn(AndroidSchedulers.mainThread()).subscribe(new v81.c(r104));
            return;
        L16:
            this.f553655a.e();
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f553656a;

        public d(b r100) {
            this.f553656a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            b r100 = this.f553656a;
            Disposable r101 = r100.f553652c;
            if (r101 == null) goto L5;
            r101.dispose();
        L5:
            Disposable r102 = r100.f553653d;
            if (r102 == null) goto L8;
            r102.dispose();
        L8:
            Disposable r103 = r100.f553651b;
            if (r103 == null) goto L12;
            r103.dispose();
            return;
        }
    }

    static {
        int r100 = j.f121211a;
        f553650e = LiveInfraSettingKeys.LIVE_FLOW_STIMULATE_CONFIG.getValue().loopTimeInterval;
    }

    public final void e() {
        Disposable r100 = this.f553653d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f553653d = Observable.just("").delay(f553650e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C7972b(this));
    }

    public final Disposable f() {
        Disposable r100 = this.f553652c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f553653d;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        Disposable r102 = this.f553651b;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        e();
        this.f553652c = xs2.b.a().b(s0.class).subscribe(new c(this));
        Disposable r103 = Disposables.fromAction(new d(this));
        this.f553651b = r103;
        return r103;
    }

    public b() {
    }
}
