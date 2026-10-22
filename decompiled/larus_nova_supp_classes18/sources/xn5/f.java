package xn5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.banner.BannerDataResult;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends BasePresenter<xn5.a, xn5.b, xn5.b.a> implements xn5.b.a {
    public final CompositeDisposable a;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ((xn5.b) this.a.getView()).e8((ArrayList) ((Result) ((BannerDataResult) r2)).data);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ((xn5.b) this.a.getView()).f8(false);
            tt5.a.e("TemplateBannerPresenter", "fetchBannerData()..fail", (Throwable) r4, false);
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    public final void create() {
        super.create();
        Disposable r0 = ((xn5.a) getModel()).C8().observeOn(fo5.d.d()).subscribe(new b(this), new c(this));
        this.a.add(r0);
    }

    public final void destroy() {
        super.destroy();
        this.a.dispose();
    }

    public f(d r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r2, r3);
        this.a = new CompositeDisposable();
    }
}
