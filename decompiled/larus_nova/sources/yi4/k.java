package yi4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.creativex.mediaimport.view.internal.base.p;
import com.larus.nova.R;
import ki4.r;
import ki4.z;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import ti4.m;
import ti4.t;

/* JADX INFO: loaded from: classes15.dex */
public final class k extends p<r> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t<z> f567927k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f567928l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f567929m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f567930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f567931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<? super z, String> f567932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<? super z, Boolean> f567933d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f567934e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f567935f;

        public a() {
            this(null);
        }

        public a(Object r100) {
            Function1<? super z, Boolean> r101 = new j();
            Intrinsics.checkNotNullParameter("", "hintText");
            Intrinsics.checkNotNullParameter(r101, "showInCategory");
            this.f567930a = "";
            this.f567931b = true;
            this.f567932c = null;
            this.f567933d = r101;
            this.f567934e = 0;
            this.f567935f = false;
        }
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f567936a;

        public b(i r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f567936a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f567936a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f567936a.invoke(r100);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [yi4.i] */
    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final void c() {
        super.c();
        ViewGroup r100 = b();
        Intrinsics.checkNotNullParameter(r100, "content");
        TextView r101 = (TextView) r100.findViewById(R.id.tv_selector_hint);
        if (r101 == null) goto L5;
        r101.setText(this.f567928l.f567930a);
    L6:
        this.f567929m = r101;
        int r102 = this.f567928l.f567934e;
        if (r102 == 0) goto L11;
        View r103 = this.f203867j;
        if (r103 == null) goto L11;
        r103.setBackgroundResource(r102);
    L11:
        t<z> r104 = this.f567927k;
        if (r104 == null) goto L16;
        MutableLiveData r105 = r104.a();
        if (r105 == null) goto L16;
        r105.observe(this.f203859b, new h(this));
    L16:
        m<DATA> r106 = this.f203860c;
        if (r106 == 0) goto L22;
        LiveData r107 = r106.getSelectedMaterials();
        if (r107 == null) goto L23;
        r107.observe(this.f203859b, new b(new i(this)));
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public k(ViewGroup r100, LifecycleOwner r101, m<r> r110, t<z> r111, boolean r112, String r113, Function0<Unit> r114, Function1<? super a, Unit> r115) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r113, "confirmText");
        super(r100, r101, r110, r112, r113, r114);
        this.f567927k = r111;
        a r102 = new a(null);
        this.f567928l = r102;
        if (r115 == null) goto L6;
        r115.invoke(r102);
        return;
    }
}
