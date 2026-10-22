package com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/IAntiScreenshotsConfig;", "<init>", "()V", "antiScreenshotsDelegate", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/delegate/DialogFragmentAntiScreenshotsDelegate;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onDestroy", "onDoCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseAntiScreenshotsDialogFragment extends BaseForsetiCompatDialogFragment implements a {
    public final d g;

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a
    public boolean Cl() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public View X90(LayoutInflater r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return null;
    }

    public BaseAntiScreenshotsDialogFragment() {
        this.g = new d(this);
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        d r0 = this.g;
        MutableLiveData<Integer> r1 = r0.c;
        if (r1 == null) goto L6;
        r1.removeObserver(r0.d);
        return;
    }

    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        d r0 = this.g;
        MutableLiveData<Integer> r1 = r0.c;
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        r0.b(r3);
        return;
    L7:
        r3 = -1;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.g.a();
    }
}
