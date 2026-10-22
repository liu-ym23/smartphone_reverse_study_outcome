package e91;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends a<AnchorTabLabel> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f471445c;

    @Override // e91.a
    public final void c() {
        super.c();
        ViewGroup r100 = this.f471424b.getContainer();
        if (r100 == null) goto L15;
        ImageView r101 = this.f471445c;
        if (r101 == null) goto L16;
        ViewParent r102 = null;
        r101.setImageBitmap(null);
        ViewParent r103 = r101.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L10;
        r102 = r103;
    L10:
        ViewGroup r104 = (ViewGroup) r102;
        if (r104 == null) goto L13;
        r104.removeView(r101);
    L13:
        r100.addView(r101);
        return;
    L16:
        return;
    }

    public h(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        super(r100);
        ViewGroup r101 = r100.f100144d.f100106k;
        if (r101 == null) goto L5;
        ImageView r102 = new ImageView(r101.getContext());
    L6:
        this.f471445c = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "tabLabel");
        k r101 = r100.getLabel();
        if (this.f471423a == true) goto L20;
        if (r101 == null) goto L23;
        ViewGroup r102 = this.f471424b.getContainer();
        if (r102 == null) goto L21;
        this.f471423a = true;
        ImageView r103 = this.f471445c;
        if (r103 == null) goto L22;
        int r104 = r101.getWidth();
        if (r104 > 0) goto L14;
        r104 = 64;
    L14:
        int r105 = (int) UtilityKotlinExtentionsKt.h(r104);
        int r106 = r101.getHeight();
        if (r106 > 0) goto L18;
        r106 = 12;
    L18:
        r103.setLayoutParams(new FrameLayout.LayoutParams(r105, (int) UtilityKotlinExtentionsKt.h(r106)));
        r102.setVisibility(0);
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r101, new g(this, r101));
        return;
    L22:
        return;
    L21:
        return;
    L23:
        return;
    }
}
