package np1;

import android.view.View;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f520023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<np1.a> f520024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f520025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f520026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner<h80.c<View>> f520027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner f520028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner<h80.c<View>> f520029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f520030j;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f520031a;

        public a(Function1 r100) {
            this.f520031a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f520031a.invoke(z0.b((h80.c) r100));
        }
    }

    @Override // np1.b
    public int getType() {
        return this.f520022b;
    }

    public g(c r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        this.f520030j = r100;
        this.f520022b = 1;
        this.f520023c = "";
        this.f520024d = new ArrayList();
        CompositeDisposable r101 = new CompositeDisposable();
        this.f520026f = r101;
        h80.c<?> r102 = h80.c.f484054b;
        PropertyOwner<h80.c<View>> r103 = new PropertyOwner(r102);
        this.f520027g = r103;
        this.f520028h = r103;
        this.f520029i = new PropertyOwner(r102);
        r100.getCd().add(r101);
    }

    public final void a(Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        RxUtilKt.c(this.f520028h.subscribe(new a(r100)), this.f520026f);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f520023c = r100;
    }
}
