package ip5;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {
    public int a;

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        controller(new b(r2));
        marginInDp(36);
        autoDismiss(true);
        cancelOnTouchOutside(false);
    }
}
