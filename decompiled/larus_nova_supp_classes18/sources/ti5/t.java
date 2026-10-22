package ti5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r3);
        r0.autoDismiss(true);
        r0.title(2131889850);
        r0.message(2131889851);
        r0.addActionButton(2131391778, 2131887759, a.a);
        r0.cancelOnTouchOutside(false);
        UDDialog r4 = r0.build();
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
    }

    public static void c(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r2, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r2);
        r0.autoDismiss(true);
        r0.title(2131889850);
        Intrinsics.checkNotNullParameter(r3, "value");
        r0.message(r3);
        r0.addActionButton(2131391778, 2131887759, b.a);
        r0.cancelOnTouchOutside(false);
        UDDialog r4 = r0.build();
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
    }

    @JvmStatic
    public static final boolean a(JSONObject r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "ownerId");
        if (r5 == null) goto L5;
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L21;
        if (r1 == null) goto L15;
        String r3 = r1.next();
    L17:
        if (r5.optInt(r3) != r6) goto L7;
        if (TextUtils.equals(r3, r7) == false) goto L7;
        return true;
    L15:
        r3 = null;
        goto L17
    L21:
        return false;
    L9:
        if (r1.hasNext() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }
}
