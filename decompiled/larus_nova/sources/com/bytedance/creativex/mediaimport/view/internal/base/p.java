package com.bytedance.creativex.mediaimport.view.internal.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class p<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f203858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f203859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ti4.m<DATA> f203860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f203861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f203862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f203863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BehaviorSubject<ti4.i0> f203864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f203865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f203866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f203867j;

    public final ViewGroup b() {
        ViewGroup r100 = this.f203865h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    public void c() {
        ViewGroup r100 = f(this.f203858a);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f203865h = r100;
        ViewGroup r101 = b();
        Intrinsics.checkNotNullParameter(r101, "content");
        View r102 = r101.findViewById(R.id.sure_view);
        TextView r103 = null;
        if (r102 == null) goto L5;
        r102.setOnClickListener(new o(this));
    L6:
        this.f203867j = r102;
        if (r102 == null) goto L9;
        ViewCompat.setAccessibilityDelegate(r102, new BaseMaterialSelectorView$initConfirmView$2$1());
    L9:
        TextView r104 = e(b());
        if (r104 == null) goto L12;
        r104.setText(this.f203862e);
        r103 = r104;
    L12:
        this.f203866i = r103;
        Intrinsics.checkNotNullParameter(b(), "content");
        LifecycleOwner r105 = this.f203859b;
        ti4.m<DATA> r106 = this.f203860c;
        if (r106 == null) goto L16;
        r106.getSelectedMaterials().observe(r105, new m(this));
        r106.getConfirmEnable().observe(r105, new n(this));
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void d() {
        ti4.m<DATA> r100 = this.f203860c;
        if (r100 == null) goto L6;
        r100.requestConfirm("click_next_button");
        return;
    }

    public TextView e(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return (TextView) r100.findViewById(R.id.sure_view);
    }

    public ViewGroup f(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_tools_media_import_selector_view, r100, true);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) r101;
    }

    public String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "confirmText");
        if (r101 > 1) goto L5;
        return r100;
    L5:
        return r100 + '(' + r101 + ')';
    }

    public /* synthetic */ p(ViewGroup r100, LifecycleOwner r101, ti4.m r110, boolean r111, String r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public p(ViewGroup r100, LifecycleOwner r101, ti4.m<DATA> r102, boolean r103, String r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r104, "confirmText");
        this.f203858a = r100;
        this.f203859b = r101;
        this.f203860c = r102;
        this.f203861d = r103;
        this.f203862e = r104;
        this.f203863f = r105;
        this.f203864g = BehaviorSubject.create();
    }
}
