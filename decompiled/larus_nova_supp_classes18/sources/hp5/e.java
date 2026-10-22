package hp5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends UDDialogController {
    public boolean a;
    public CharSequence b;
    public int c;
    public boolean d;
    public CharSequence e;
    public UDButton f;
    public UDCheckBox.c g;

    public final int getDefaultContentRes() {
        return 2131558800;
    }

    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        if (r0 != null) goto L6;
        return null;
    L6:
        TextView r1 = (TextView) r0.findViewById(2131391795);
        if (r1 == null) goto L9;
        r1.setText(this.e);
    L9:
        int r2 = 0;
        if (r1 != null) goto L12;
    L16:
        UDCheckBox r3 = r0.findViewById(2131391781);
        if (r3 == null) goto L19;
        r3.setChecked(this.a);
        r3.setOnCheckedChangeListener(new b(this));
    L19:
        TextView r4 = (TextView) r0.findViewById(2131391782);
        if (r4 == null) goto L22;
        r4.setText(this.b);
    L22:
        if (r4 == null) goto L25;
        r4.setOnClickListener(new c(r3));
    L25:
        if (this.c == (-1)) goto L28;
        if (r4 == null) goto L28;
        r4.setTextColor(UDColorUtils.getColor(getContext(), this.c));
    L28:
        LinearLayout r5 = (LinearLayout) r0.findViewById(2131391783);
        if (r5 == null) goto L31;
        r5.setOnClickListener(new d(r3));
    L31:
        if (r5 != null) goto L33;
    L37:
        return r0;
    L33:
        if (this.d == true) goto L36;
        r2 = 8;
    L36:
        r5.setVisibility(r2);
        goto L37
    L12:
        if (TextUtils.isEmpty(this.e) == true) goto L14;
        int r6 = 0;
    L15:
        r1.setVisibility(r6);
        goto L16
    L14:
        r6 = 8;
        goto L15
    }

    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        if (r0 == null) goto L5;
        UDButton r1 = (UDButton) r0.findViewById(2131391777);
    L6:
        this.f = r1;
        boolean r2 = this.a;
        if (this.d == false) goto L14;
        if (r1 == null) goto L11;
        r1.setClickable(r2);
    L11:
        UDButton r3 = this.f;
        if (r3 == null) goto L14;
        r3.setEnabled(r2);
    L14:
        return r0;
    L5:
        r1 = null;
        goto L6
    }

    public e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = "";
        this.c = -1;
        this.d = true;
        this.e = "";
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof a) == false) goto L7;
        super.apply(r2, r3);
        a r4 = (a) r2;
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.d;
        this.d = r4.e;
        this.e = r4.c;
        this.g = r4.f;
        return;
    L7:
        throw new IllegalArgumentException("builder should be BearUDCheckBoxDialogBuilderV2, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
