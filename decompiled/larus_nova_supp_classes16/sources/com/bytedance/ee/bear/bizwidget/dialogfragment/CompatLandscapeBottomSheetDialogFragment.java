package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CompatLandscapeBottomSheetDialogFragment extends BaseBottomSheetDialogFragment {

    public static final class a implements DialogInterface.OnShowListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r3) {
            if ((r3 instanceof BottomSheetDialog) == false) goto L10;
            ViewGroup r4 = (ViewGroup) ((BottomSheetDialog) r3).findViewById(2131368870);
            if (r4 == null) goto L11;
            CoordinatorLayout r0 = r4.getParent();
            BottomSheetBehavior.from(r4).setPeekHeight(r4.getHeight());
            if ((r0 instanceof CoordinatorLayout) == false) goto L12;
            r0.getParent().requestLayout();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public CompatLandscapeBottomSheetDialogFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnShowListener(a.a);
        return r3;
    }
}
