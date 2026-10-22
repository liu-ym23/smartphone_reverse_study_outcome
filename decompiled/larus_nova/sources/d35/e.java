package d35;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.document.j5;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f466712a;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        boolean r101 = !TextUtils.isEmpty(this.f466712a);
        TextView r102 = (TextView) r100.findViewById(R.id.ud_dialog_content_code_tv);
        if (r101 == false) goto L5;
        r102.setText(this.f466712a);
    L6:
        return r100;
    L5:
        r102.setVisibility(8);
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r100 = super.onCreateFooter();
        if (j5.a() == true) goto L5;
    L6:
        View r101 = r100.findViewById(R.id.ud_dialog_btn_secondary3);
        r100.findViewById(R.id.ud_dialog_secondary_btn_divider3).setVisibility(r101.getVisibility());
    L7:
        return r100;
    L5:
        if (getMActionButtonsOrientation() != UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL) goto L7;
        goto L6
    }

    public e(Context r100) {
        super(r100);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        if ((r100 instanceof d) == false) goto L7;
        super.apply(r100, r101);
        this.f466712a = ((d) r100).f466711a;
        return;
    L7:
        throw new IllegalArgumentException("builder should be OopsDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()));
    }
}
