package yh9;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.home.api.main.HomeService;
import com.larus.larkfeed.impl.utils.b;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements qza.a {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qza.a
    public final boolean Q() {
        WeakReference<Fragment> r100 = b.f355548a;
        WeakReference<Fragment> r101 = b.f355548a;
        if (r101 == null) goto L42;
        Fragment r102 = r101.get();
        if (r102 == null) goto L46;
        FLogger.f375446a.i("LarkMixedFeedForegroundChecker", "isFragmentDisplay: state=" + r102.getLifecycle().getCurrentState() + ' ' + r102.isAdded() + ", " + r102.isDetached() + ", " + r102.isRemoving() + ", " + r102.isHidden());
        if (r102.isAdded() == true) goto L10;
        return false;
    L10:
        if (r102.isDetached() == false) goto L12;
        return false;
    L12:
        if (r102.isRemoving() == false) goto L15;
        return false;
    L15:
        if (r102.isHidden() == false) goto L18;
        return false;
    L18:
        if (r102.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L49;
        View r103 = r102.getView();
        if (r103 != null) goto L24;
        return false;
    L24:
        if (r103.isShown() == false) goto L51;
        Fragment r104 = r102.getParentFragment();
    L27:
        if (r104 == 0) goto L32;
        if ((r104 instanceof ay9.a) == true) goto L30;
        r104 = r104.getParentFragment();
        goto L27
    L30:
        ay9.a r105 = (ay9.a) r104;
    L34:
        if (r105 != null) goto L37;
    L38:
        return true;
    L37:
        if (r105.Fu() == 0) goto L38;
        return false;
    L32:
        r105 = null;
        goto L34
    L51:
        return false;
    L49:
        return false;
    L46:
        return false;
    L42:
        return false;
    }

    @Override // qza.a
    public final boolean m() {
        return HomeService.f344094a.m();
    }

    @Override // qza.a
    public final boolean n() {
        return HomeService.f344094a.n();
    }
}
