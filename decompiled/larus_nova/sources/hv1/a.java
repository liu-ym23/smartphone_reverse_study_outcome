package hv1;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdk.config.av;
import com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator;
import com.bytedance.android.livesdkapi.explore.LiveExploreLynxCallback;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.lynx.tasm.LynxView;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements ILiveExploreLynxFragmentCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridFragment f487276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f487277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveExploreLynxCallback f487278c;

    /* JADX INFO: renamed from: hv1.a$a, reason: collision with other inner class name */
    public static final class C6201a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator
    public final void callPauseLiveBridge() {
        HybridFragment r100 = this.f487276a;
        if (r100 == null) goto L6;
        r100.sendJsEvent("webcast.discover.pause", new Object());
        return;
    }

    @Override // com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator
    public final void callPlayLiveBridge() {
        HybridFragment r100 = this.f487276a;
        if (r100 == null) goto L6;
        r100.sendJsEvent("webcast.discover.play", new Object());
        return;
    }

    @Override // com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator
    public final boolean isTop() {
        HybridFragment r100 = this.f487276a;
        if (r100 == null) goto L16;
        View r101 = r100.getHybridView();
        if ((r101 instanceof LynxView) == false) goto L10;
        View r102 = ((LynxView) r101).findViewByName("page-list");
        if ((r102 instanceof RecyclerView) == false) goto L10;
        return !r102.canScrollVertically(-1);
    L10:
        if (r101 != null) goto L12;
    L14:
        return false;
    L12:
        if (r101.getScrollY() != 0) goto L14;
        return true;
    L16:
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator
    public final void release() {
        HybridFragment r100 = this.f487276a;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f487276a = null;
    }

    @Override // com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator
    public final Fragment createLiveWebFragment() {
        return this.f487276a;
    }

    @Override // com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator
    public final Fragment createLiveLynxFragment(Context r100) {
        if (this.f487276a != null) goto L31;
        av r101 = av.f119821a;
        String r102 = r101.getValue().b();
        boolean r103 = false;
        if (r102.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        Uri r105 = null;
    L25:
        if (r105 == null) goto L31;
        if (r100 == null) goto L31;
        HybridFragment r106 = ((IBrowserService) k.n(IBrowserService.class)).getHybridFragment(r100, r105, new b(this));
        if (r106 == null) goto L31;
        this.f487276a = r106;
        goto L31
    L10:
        Uri.Builder r107 = UriProtector.parse(r102).buildUpon();
        String r108 = "dark";
        if (this.f487277b == false) goto L13;
        String r109 = "dark";
    L14:
        r107.appendQueryParameter(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r109);
        Uri.Builder r110 = x6.a.d(r107.toString()).buildUpon();
        String r111 = r101.getValue().a();
        if (r111.length() != 0) goto L17;
        r103 = true;
    L17:
        if (r103 == false) goto L19;
        String r112 = "";
    L24:
        r105 = r110.appendQueryParameter("fallback_url", r112).appendQueryParameter("hide_nav_bar", String.valueOf(1)).build();
        goto L25
    L19:
        Uri.Builder r113 = UriProtector.parse(r111).buildUpon();
        if (this.f487277b == true) goto L23;
        r108 = "dawn";
    L23:
        r113.appendQueryParameter(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r108);
        r112 = r113.toString();
        goto L24
    L13:
        r109 = "dawn";
        goto L14
    L7:
        r104 = false;
    L31:
        return this.f487276a;
    }

    public a(boolean r100, LiveExploreLynxCallback r101) {
        Intrinsics.checkNotNullParameter(r101, "mLiveExploreLyncCallback");
        this.f487277b = r100;
        this.f487278c = r101;
    }
}
