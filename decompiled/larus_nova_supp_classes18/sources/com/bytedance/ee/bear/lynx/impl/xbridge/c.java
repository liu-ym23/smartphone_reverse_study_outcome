package com.bytedance.ee.bear.lynx.impl.xbridge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.framework.utils.p;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends XCoreBridgeMethod {
    public final String a;
    public boolean b;

    public static final class a {
    }

    public final class b {
        public final String a;
        public final String b;
        public final int c;

        public final String toString() {
            return "actionId = " + this.a + ", actionText = " + this.b + ", actionType = " + this.c;
        }

        public b(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "actionId");
            Intrinsics.checkNotNullParameter(r3, "actionText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.xbridge.c$c, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC0042c implements DialogInterface.OnClickListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ XBridgeMethod.Callback b;
        public final /* synthetic */ List<b> c;
        public final /* synthetic */ int d;

        public DialogInterfaceOnClickListenerC0042c(c r1, XBridgeMethod.Callback r2, List<b> r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", ((b) ListProtector.get(this.c, this.d)).a), TuplesKt.to("isChecked", Boolean.valueOf(this.a.b))}), null, 4, null);
        }
    }

    public static final class d implements fp5.a.b {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        @Override // fp5.a.b
        public final void a(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "checkBox");
            this.a.b = r3;
        }
    }

    static {
    }

    public c() {
        this.a = "ccm.showCheckBoxDialog";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r12, XBridgeMethod.Callback r13, XBridgePlatformType r14) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_TYPE);
        Context r15 = (Context) provideContext(Context.class);
        if (r15 != null) goto L6;
        tt5.a.d("ccm-lynx: CCMShowDialogMethod", "handle()...context is null");
        return;
    L6:
        String r1 = s.f(r12, "title", "");
        String r3 = s.f(r12, "content", "");
        v r4 = s.a(r12, "actions");
        ArrayList r5 = new ArrayList();
        if (r4 == null) goto L15;
        Iterator r6 = r4.toList().iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r7 = r6.next();
        if ((r7 instanceof LinkedHashMap) == false) goto L11;
        Map r8 = (Map) r7;
        Object r9 = r8.get("actionID");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.String");
        Object r10 = r8.get("actionText");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.String");
        Object r11 = r8.get("actionType");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Int");
        r5.add(new b((String) r9, (String) r10, ((Integer) r11).intValue()));
    L15:
        String r16 = s.f(r12, "hintStr", "");
        tt5.a.h("ccm-lynx: CCMShowDialogMethod", "handle()...title = " + r1 + ", content = " + r3 + ", actions = " + r5);
        if (hu5.a.d(r5) == false) goto L19;
        tt5.a.d("ccm-lynx: CCMShowDialogMethod", "actions is empty");
        return;
    L19:
        fp5.a r17 = (fp5.a) ((fp5.a) new fp5.a(r15).title(r1)).message(r3);
        r17.a(r16);
        fp5.a r18 = (fp5.a) r17.cancelable(true);
        d r0 = new d(this);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r0, "value");
        r18.f = r0;
        int r2 = 0;
        fp5.a r19 = (fp5.a) ((fp5.a) r18.messageGravity(17)).cancelOnTouchOutside(false);
        List r20 = p.a(r5);
        int r21 = r20.size();
    L20:
        if (r2 >= r21) goto L37;
        UDBaseDialogBuilder.ActionBuilder r22 = new UDBaseDialogBuilder.ActionBuilder();
        if (r2 == 0) goto L26;
        if (r2 == 1) goto L25;
        int r23 = 2131391779;
    L27:
        r22.actionResId(r23);
        r22.text(((b) ListProtector.get(r20, r2)).b);
        int r24 = ((b) ListProtector.get(r20, r2)).c;
        if (r24 == 0) goto L35;
        if (r24 != 1) goto L31;
    L34:
        int r25 = 2131108730;
    L36:
        r22.textColorRes(r25);
        r22.onClickListener(new DialogInterfaceOnClickListenerC0042c(this, r13, r20, r2));
        r19.addActionButton(r22);
        r2 = r2 + 1;
        goto L20
    L31:
        if (r24 != 2) goto L34;
        r25 = 2131101119;
        goto L36
    L35:
        r25 = 2131101111;
        goto L36
    L25:
        r23 = 2131391778;
        goto L27
    L26:
        r23 = 2131391777;
        goto L27
    L37:
        Dialog r110 = r19.build();
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r110);
    L42:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(r110);
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L41:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L42
    }
}
