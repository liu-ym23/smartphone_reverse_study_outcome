package j85;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.drive.core.fragment.DriveMainFragment;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.module.nativepreview.model.FileBlockResModel;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ DriveMainFragment b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ FileBlockResModel.NativeViewHolder d;
    public final /* synthetic */ k85.a e;
    public final /* synthetic */ e f;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        e r0 = this.f;
        if (r0.a == true) goto L16;
        r0.a = true;
        FragmentManager r1 = n85.b.a.a.d(this.b, this.c, this.a);
        if (r1 == null) goto L7;
        boolean r2 = true;
    L8:
        tt5.a.h("FileBlockPreviewWrapper", "createView onGlobalLayout, fragmentManager available: " + r2);
        this.d.setFragmentManager(r1);
        if (r2 == false) goto L15;
        FragmentTransaction r3 = r1.beginTransaction();
        int r4 = this.a.getId();
        DriveMainFragment r5 = this.b;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r4) == true) goto L14;
        r3 = r3.add(r4, r5);
    L14:
        r3.commitAllowingStateLoss();
        DriveComponentRenderVM r6 = (DriveComponentRenderVM) new ViewModelProvider(this.b, new ViewModelProvider.NewInstanceFactory()).get(DriveComponentRenderVM.class);
        this.d.setComponentRenderVM(r6);
        r6.getLiveNativeComponentDelegate().postValue(this.e);
        goto L16
    L15:
        tt5.a.k("FileBlockPreviewWrapper", "not isAttachedToWindow getFragmentManager null");
        goto L16
    L7:
        r2 = false;
    L16:
        return true;
    }

    public c(e r1, ViewGroup r2, DriveMainFragment r3, FragmentActivity r4, FileBlockResModel.NativeViewHolder r5, k85.a r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
