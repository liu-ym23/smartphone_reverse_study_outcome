package dv4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.widget.EditText;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;

    /* JADX INFO: renamed from: dv4.a$a, reason: collision with other inner class name */
    public static final class C0213a {
    }

    public static final class b implements DialogInterface.OnShowListener {
        public final /* synthetic */ UDDialog a;

        public b(UDDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r2) {
            UDEditText r3 = this.a.findViewById(2131391787);
            if (r3 == null) goto L6;
            r3.m(true);
            return;
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ a b;
        public final /* synthetic */ XBridgeMethod.Callback c;

        public c(Ref.BooleanRef r1, a r2, XBridgeMethod.Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r5) {
            a.e(this.a, this.b, this.c, "cancel", "");
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ a b;
        public final /* synthetic */ XBridgeMethod.Callback c;

        public d(Ref.BooleanRef r1, a r2, XBridgeMethod.Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            tt5.a.h("ShowTextInputDialogMethod", "onConfirmClick");
            String r0 = null;
            if ((r5 instanceof Dialog) == false) goto L5;
            Dialog r7 = (Dialog) r5;
        L6:
            if (r7 == null) goto L8;
            EditText r8 = (EditText) r7.findViewById(2131391787);
        L9:
            Ref.BooleanRef r1 = this.a;
            a r2 = this.b;
            XBridgeMethod.Callback r3 = this.c;
            if (r8 == null) goto L14;
            Editable r9 = r8.getText();
            if (r9 == null) goto L14;
            r0 = r9.toString();
        L14:
            if (r0 != null) goto L16;
            r0 = "";
        L16:
            a.e(r1, r2, r3, TipCallBackData.CONFIRM, r0);
            if (r5 == null) goto L20;
            r5.dismiss();
            return;
        L20:
            return;
        L8:
            r8 = null;
            goto L9
        L5:
            r7 = null;
            goto L6
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ a b;
        public final /* synthetic */ XBridgeMethod.Callback c;

        public e(Ref.BooleanRef r1, a r2, XBridgeMethod.Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            tt5.a.h("ShowTextInputDialogMethod", "onCancelClick");
            a.e(this.a, this.b, this.c, "cancel", "");
            if (r5 == null) goto L6;
            r5.dismiss();
            return;
        }
    }

    static {
    }

    public a() {
        this.a = "bitable.super.agent.showTextInputDialog";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r8, XBridgeMethod.Callback r9, XBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        Context r11 = (Context) provideContext(Context.class);
        if (r11 != null) goto L6;
        tt5.a.d("ShowTextInputDialogMethod", "context is null");
        XCoreBridgeMethod.onFailure$default(this, r9, 0, "context null", null, 8, null);
        return;
    L6:
        String r0 = s.f(r8, "title", "");
        String r2 = s.f(r8, "text", "");
        String r3 = s.f(r8, "placeholder", "");
        String r4 = s.f(r8, "cancelText", "");
        String r12 = s.f(r8, "confirmText", "");
        Ref.BooleanRef r1 = new Ref.BooleanRef();
        com.larksuite.component.universe_design.dialog.c r13 = new com.larksuite.component.universe_design.dialog.c(r11).title(r0);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r2, "value");
        r13.k = r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        r13.j = r3;
        r13.l = true;
        r13.m = true;
        UDDialog r14 = r13.cancelOnTouchOutside(false).addActionButton(2131391777, r12, new d(r1, this, r9)).addActionButton(2131391778, r4, new e(r1, this, r9)).build();
        r14.setOnShowListener(new b(r14));
        r14.setOnDismissListener(new c(r1, this, r9));
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r14);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
    }

    public static final void e(Ref.BooleanRef r7, a r8, XBridgeMethod.Callback r9, String r10, String r11) {
        if (r7.element == true) goto L7;
        r7.element = true;
        XCoreBridgeMethod.onSuccess$default(r8, r9, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", r10), TuplesKt.to("inputText", r11)}), null, 4, null);
        return;
    }
}
