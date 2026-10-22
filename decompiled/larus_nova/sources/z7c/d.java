package z7c;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoCustomFieldData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f570749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f570750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TodoCustomFieldData f570751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EditText f570752d;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultRootRes() {
        return R.layout.detail_custom_field_number_dialog_root;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController, com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public final void onDismiss() {
        EditText r100 = this.f570752d;
        if (r100 == null) goto L5;
        KeyboardUtils.hideKeyboard(this.f570749a, r100);
    L6:
        super.onDismiss();
        return;
    L5:
        KeyboardUtils.hideKeyboard(this.f570749a);
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = super.createView();
        if (r100 == null) goto L5;
        EditText r101 = (EditText) r100.findViewById(R.id.edittext_number_input);
    L6:
        this.f570752d = r101;
        if (r101 == null) goto L9;
        r101.setText(this.f570750b);
        r101.post(new b(r101));
        r101.setImeOptions(6);
        r101.setOnEditorActionListener(new c(this));
    L9:
        return r100;
    L5:
        r101 = null;
        goto L6
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570749a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof a) == false) goto L7;
        super.apply(r100, r101);
        a r102 = (a) r100;
        this.f570750b = r102.f570739a;
        this.f570751c = r102.f570740b;
        return;
    L7:
        throw new IllegalArgumentException("builder should be CustomFieldNumberDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
