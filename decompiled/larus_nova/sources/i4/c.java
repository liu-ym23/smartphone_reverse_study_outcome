package i4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import com.bytedance.ai.bridge.service.ActionSheetBuilder;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.service.PageTitleBar;
import com.bytedance.ai.bridge.service.ShowActionSheetListener;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements IHostStyleUIDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Toast f488129a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean hideLoading(e3.a r100) {
        return null;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final void setPageNaviStyle(e3.a r100, Activity r101, PageTitleBar r102) {
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showLoading(e3.a r100) {
        return null;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean hideToast(e3.a r100) {
        Toast r101 = f488129a;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        f488129a = null;
        return Boolean.TRUE;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showDialog(final DialogBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogBuilder");
        if (r100.getEditable() == false) goto L5;
        final EditText r101 = new EditText(r100.getContext());
        r101.setInputType(131073);
        r101.setMaxLines(4);
        r101.setHint(r100.getPlaceholderText());
        r101.setSingleLine(false);
        Resources r102 = r101.getResources();
        int r103 = (int) (20 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
        Resources r104 = r101.getResources();
        int r105 = (int) (8 * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density);
        r101.setPadding(r103, r105, r103, r105);
    L6:
        AlertDialog.Builder r106 = new AlertDialog.Builder(r100.getContext()).setTitle(r100.getTitle()).setMessage(r100.getMessage());
        if (r101 == null) goto L9;
        r106.setView(r101);
    L9:
        r106.setPositiveButton(r100.getPositiveBtnText(), null);
        if (r100.getNegativeBtnText() == null) goto L12;
        r106.setNegativeButton(r100.getNegativeBtnText(), r100.getNegativeClickListener());
    L12:
        final AlertDialog r107 = r106.create();
        r107.setCanceledOnTouchOutside(r100.getCancelOnTouchOutside());
        r107.setCancelable(r100.getCancelOnTouchOutside());
        r107.setOnCancelListener(r100.getCancelOnTouchOutsideListener());
        r107.setOnShowListener(new i4.a(r107, r100, r101));
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r107);
    L17:
        if (r101 == null) goto L22;
        r101.requestFocus();
        Window r108 = r107.getWindow();
        if (r108 == null) goto L22;
        r108.setSoftInputMode(5);
    L22:
        return Boolean.TRUE;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L16:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        goto L17
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "toastBuilder");
        Toast r101 = f488129a;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        Toast r102 = Toast.makeText(r100.getContext().getApplicationContext(), r100.getMessage(), 0);
        r102.show();
        f488129a = r102;
        return Boolean.TRUE;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r100, ShowActionSheetListener r101) {
        Intrinsics.checkNotNullParameter(r100, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r101, "showActionSheetListener");
        return null;
    }
}
