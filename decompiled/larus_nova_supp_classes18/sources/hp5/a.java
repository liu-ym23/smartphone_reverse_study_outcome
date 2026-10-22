package hp5;

import android.content.Context;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {
    public boolean a;
    public CharSequence b;
    public final CharSequence c;
    public int d;
    public boolean e;
    public UDCheckBox.c f;

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = "";
        this.c = "";
        this.d = -1;
        this.e = true;
        controller(new e(r2));
        marginInDp(36);
    }
}
