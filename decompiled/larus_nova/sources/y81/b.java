package y81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b implements u81.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f566662i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f566663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f566664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f566665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f566666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public tlc.d f566667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f566668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f566669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f566670h;

    public static final class a {
        @JvmStatic
        public static View a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_layout_incentive_info_common_exp, r100, false);
        }
    }

    static {
    }

    @Override // u81.d
    public final void d() {
        this.f566665c = true;
    }

    public final void h() {
        if (this.f566669g.getVisibility() != 0) goto L6;
        xs2.b.a().post(new zg1.s0(0, 1));
        return;
    }

    public final void j() {
        RxBusAbility.INSTANCE.getRxBus(this.f566668f).post(new zg1.n());
    }

    @Override // u81.d
    public void onDestroy() {
        this.f566664b.clear();
    }

    @Override // u81.d
    public final View a() {
        return this.f566669g;
    }

    @Override // u81.d
    public Integer b() {
        return this.f566663a;
    }

    @Override // u81.d
    public final String getIconUrl() {
        return this.f566666d;
    }

    public final void i(int r100) {
        if (this.f566669g.getVisibility() != 0) goto L6;
        xs2.b.a().post(new zg1.s0(r100, 0));
        return;
    }

    public b(DataCenter r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r102, "parentView");
        this.f566668f = r100;
        this.f566669g = r101;
        this.f566670h = r102;
        this.f566663a = 0;
        this.f566664b = new CompositeDisposable();
        this.f566665c = true;
        this.f566666d = "";
    }
}
