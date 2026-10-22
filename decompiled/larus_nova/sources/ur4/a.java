package ur4;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.card.viewmodel.c;
import com.bytedance.ee.bear.bitable.core.infoarch.BitableContentContainer;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.f;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.h;
import com.bytedance.ee.bear.bitable.loading.BitableLoadingWrapper;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.m;
import com.larus.nova.R;
import du4.b;
import io.supercharge.shimmerlayout.ShimmerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements com.bytedance.ee.bear.bitable.loading.a, h, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f551374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShimmerLayout f551376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f551377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f551378e;

    /* JADX INFO: renamed from: ur4.a$a, reason: collision with other inner class name */
    public static final class C7923a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final /* synthetic */ void Nr() {
        du4.a.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final boolean A30() {
        boolean r100 = this.f551375b;
        if (r100 == false) goto L5;
        this.f551378e = true;
    L5:
        return r100;
    }

    @Override // du4.c
    public final void ZX() {
        View r100 = this.f551377d;
        if (r100 == null) goto L6;
        this.f551374a.removeView(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.viewmodel.c
    public final void a() {
        du4.a.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final ELoadingType getLoadingType() {
        return ELoadingType.VIEW_CONTAINER;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final View getLoadingView() {
        return this.f551376c;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void TQ(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        ShimmerLayout r101 = b.a(this, r100, null);
        m.a(this.f551374a, r101);
        r101.setBackgroundColor(r100.getResources().getColor(R.color.bg_body));
        this.f551376c = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void aS(BitableLoadingWrapper.LoadingState r100) {
        ShimmerLayout r101 = this.f551376c;
        if (r101 == null) goto L5;
        this.f551374a.removeView(r101);
    L5:
        View r102 = this.f551374a.findViewById(R.id.loading_container);
        if (r102 == null) goto L9;
        r102.setVisibility(8);
        return;
    }

    @Override // du4.c
    public final void xr(View r100) {
        if (r100 == null) goto L5;
        this.f551377d = r100;
        m.a(this.f551374a, r100);
        return;
    }

    public a(BitableContentContainer r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewContentContainer");
        this.f551374a = r100;
        this.f551375b = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.core.infoarch.arch.h
    public final void b(SceneModel r100, f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "state");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == true) goto L5;
        return;
    L5:
        if (this.f551375b == true) goto L7;
        return;
    L7:
        if (this.f551378e == false) goto L27;
        SceneModel r102 = r101.f210263f;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        boolean r104 = true ^ r100.isInvalid();
        boolean r105 = r100.isFormV1();
        if (r105 == true) goto L18;
    L20:
        if (r103 == false) goto L28;
        if (r104 == false) goto L29;
        if (r105 == true) goto L30;
        this.f551378e = false;
        du4.a.a(this);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L18:
        if (Intrinsics.areEqual(r101.f210259b, Boolean.TRUE) == false) goto L20;
        tt5.a.d("BitableViewContentContainer", "BearMobile is old form but native is new form");
        r105 = false;
        goto L20
    L11:
        if (r102.isInvalid() == true) goto L14;
        r103 = false;
        goto L15
    }
}
