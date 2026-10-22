package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CompatLandscapeBottomSheetDialogFragment extends BaseBottomSheetDialogFragment {

    public static final class a implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f216396a = null;

        static {
            f216396a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            if ((r100 instanceof BottomSheetDialog) == false) goto L10;
            ViewGroup r101 = (ViewGroup) ((BottomSheetDialog) r100).findViewById(R.id.design_bottom_sheet);
            if (r101 == null) goto L11;
            ViewParent r102 = r101.getParent();
            BottomSheetBehavior.from(r101).setPeekHeight(r101.getHeight());
            if ((r102 instanceof CoordinatorLayout) == false) goto L12;
            ((CoordinatorLayout) r102).getParent().requestLayout();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public CompatLandscapeBottomSheetDialogFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnShowListener(a.f216396a);
        return r101;
    }
}
