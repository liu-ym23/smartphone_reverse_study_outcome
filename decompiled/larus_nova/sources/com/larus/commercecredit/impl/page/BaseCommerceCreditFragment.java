package com.larus.commercecredit.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H$¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0014\u0018\u00010\u0013H$J\b\u0010\u0015\u001a\u00020\u0016H$J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0004J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0004J\b\u0010#\u001a\u00020!H\u0014J\b\u0010$\u001a\u00020\u0016H\u0014J\b\u0010%\u001a\u00020\u0016H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006&"}, d2 = {"Lcom/larus/commercecredit/impl/page/BaseCommerceCreditFragment;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "getAssociatedActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "initViews", "", "initEvents", "finishActivity", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupLandscape", "getTheme", "", "updateBottomSheetHeight", "getAvailableBottomSheetHeight", "postUpdateBottomSheetHeight", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseCommerceCreditFragment<T extends ViewBinding> extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f325725e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f325726d;

    public abstract T S90(LayoutInflater r100, ViewGroup r101);

    public abstract Class<? extends Activity> T90();

    public void W90() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BottomSheetTransparentDialog;
    }

    public abstract void initViews();

    public int U90() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L14;
        View r101 = r100.findViewById(R.id.design_bottom_sheet);
        if (r101 == null) goto L14;
        T r102 = this.f325726d;
        if (r102 == null) goto L14;
        View r103 = r102.getRoot();
        if (r103 == null) goto L14;
        r103.measure(View.MeasureSpec.makeMeasureSpec(r101.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r103.getMeasuredHeight();
    L14:
        return 0;
    }

    public void V90() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L6;
        r100.setOnDismissListener(new c(this));
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f325726d = null;
    }

    public final void y() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L12;
        Class<? extends Activity> r101 = T90();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isInstance(r100) == true) goto L9;
        return;
    L9:
        if (r100.isFinishing() == true) goto L15;
        r100.finish();
        return;
    L15:
        return;
    }

    public BaseCommerceCreditFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        final View r103 = null;
        if ((r102 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r104 = (BottomSheetDialog) r102;
    L6:
        if (r104 == null) goto L8;
        r103 = r104.findViewById(R.id.design_bottom_sheet);
    L8:
        Dialog r105 = getDialog();
        if (r105 == null) goto L11;
        r105.setOnShowListener(new a(r103));
    L11:
        initViews();
        V90();
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        T r103 = (T) S90(r100, r101);
        this.f325726d = r103;
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.getRoot();
    }
}
