package ip5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.progress.UDProgress;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends UDDialogController {
    public int a;
    public UDProgress b;
    public TextView c;

    public final int getDefaultContentRes() {
        return 2131558802;
    }

    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        if (r0 != null) goto L6;
        return null;
    L6:
        this.c = (TextView) r0.findViewById(2131391794);
        this.b = r0.findViewById(2131383297);
        b(this.a);
        return r0;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void b(int r5) {
        if (r5 > 0) goto L6;
        r5 = 0;
    L8:
        this.a = r5;
        UDProgress r1 = this.b;
        if (r1 == null) goto L11;
        r1.setProgress(r5);
    L11:
        TextView r2 = this.c;
        if (r2 == null) goto L15;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        r2.setText(String.format("%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(r5)}, 1)));
        return;
    L15:
        return;
    L6:
        if (r5 <= 100) goto L8;
        r5 = 100;
        goto L8
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof a) == false) goto L7;
        super.apply(r2, r3);
        this.a = ((a) r2).a;
        return;
    L7:
        throw new IllegalArgumentException("builder should be BearUDProgressDialogBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
