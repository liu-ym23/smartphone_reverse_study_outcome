package d35;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends UDDialogController {
    public String a;

    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        boolean r1 = !TextUtils.isEmpty(this.a);
        TextView r2 = (TextView) r0.findViewById(2131391784);
        if (r1 == false) goto L5;
        r2.setText(this.a);
    L6:
        return r0;
    L5:
        r2.setVisibility(8);
        goto L6
    }

    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.newerror.optimization") == true) goto L5;
    L6:
        View r1 = r0.findViewById(2131391780);
        r0.findViewById(2131391808).setVisibility(r1.getVisibility());
    L7:
        return r0;
    L5:
        if (getMActionButtonsOrientation() != UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL) goto L7;
        goto L6
    }

    public b(Context r1) {
        super(r1);
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        if ((r2 instanceof a) == false) goto L7;
        super.apply(r2, r3);
        this.a = ((a) r2).a;
        return;
    L7:
        throw new IllegalArgumentException("builder should be OopsDialogBuilder, but actually ".concat(r2.getClass().getSimpleName()));
    }
}
