package com.bytedance.ee.bear.lynx.impl.xbridge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
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
public final class d extends XCoreBridgeMethod {
    public final String a;

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

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ XBridgeMethod.Callback b;
        public final /* synthetic */ List<b> c;
        public final /* synthetic */ int d;

        public c(d r1, XBridgeMethod.Callback r2, List<b> r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", ((b) ListProtector.get(this.c, this.d)).a)}), null, 4, null);
        }
    }

    static {
    }

    public d() {
        this.a = "ccm.showDialog";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r11, XBridgeMethod.Callback r12, XBridgePlatformType r13) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TYPE);
        Context r14 = (Context) provideContext(Context.class);
        if (r14 != null) goto L6;
        tt5.a.d("ccm-lynx: CCMShowDialogMethod", "handle()...context is null");
        return;
    L6:
        String r1 = s.f(r11, "title", "");
        String r2 = s.f(r11, "content", "");
        int r3 = r11.getInt("contentGravity");
        v r15 = s.a(r11, "actions");
        ArrayList r4 = new ArrayList();
        if (r15 == null) goto L15;
        Iterator r16 = r15.toList().iterator();
    L11:
        if (r16.hasNext() == false) goto L15;
        Object r5 = r16.next();
        if ((r5 instanceof LinkedHashMap) == false) goto L11;
        Map r6 = (Map) r5;
        Object r7 = r6.get("actionID");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.String");
        Object r9 = r6.get("actionText");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.String");
        Object r8 = r6.get("actionType");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Int");
        r4.add(new b((String) r7, (String) r9, ((Integer) r8).intValue()));
    L15:
        tt5.a.h("ccm-lynx: CCMShowDialogMethod", "handle()...title = " + r1 + ", content = " + r2 + ", actions = " + r4);
        if (hu5.a.d(r4) == false) goto L19;
        tt5.a.d("ccm-lynx: CCMShowDialogMethod", "actions is empty");
        return;
    L19:
        Intrinsics.checkNotNullParameter(r14, "context");
        UDDialogBuilder r17 = new UDDialogBuilder(r14);
        r17.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r1, "value");
        r17.title(r1);
        Intrinsics.checkNotNullParameter(r2, "value");
        r17.message(r2);
        if (r3 == 1) goto L24;
        if (r3 == 2) goto L23;
        int r10 = 17;
    L25:
        r17.messageGravity(r10);
        int r18 = 0;
        r17.cancelOnTouchOutside(false);
        List r19 = p.a(r4);
        int r20 = r19.size();
    L26:
        if (r18 >= r20) goto L41;
        if (r18 == 0) goto L31;
        if (r18 == 1) goto L30;
        int r21 = 2131391779;
    L32:
        String r22 = ((b) ListProtector.get(r19, r18)).b;
        int r23 = ((b) ListProtector.get(r19, r18)).c;
        if (r23 == 0) goto L39;
        if (r23 == 1) goto L38;
        if (r23 != 2) goto L38;
        int r24 = 2131101119;
    L40:
        c r25 = new c(this, r12, r19, r18);
        Intrinsics.checkNotNullParameter(r22, "text");
        r17.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r21).text(r22).textColorRes(r24).onClickListener(r25));
        r18 = r18 + 1;
    L38:
        r24 = 2131108730;
        goto L40
    L39:
        r24 = 2131101111;
        goto L40
    L30:
        r21 = 2131391778;
        goto L32
    L31:
        r21 = 2131391777;
        goto L32
    L41:
        Dialog r110 = r17.build();
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r110);
    L46:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(r110);
        return;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
    L45:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L46
    L23:
        r10 = 5;
        goto L25
    L24:
        r10 = 3;
        goto L25
    }
}
