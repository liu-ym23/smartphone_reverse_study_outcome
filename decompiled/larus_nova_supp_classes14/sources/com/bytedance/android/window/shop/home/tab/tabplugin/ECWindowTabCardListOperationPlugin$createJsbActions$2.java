package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.utils.u0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowTabCardListOperationPlugin$createJsbActions$2 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowTabCardListOperationPlugin$createJsbActions$2(ECWindowTabCardListOperationPlugin r8) {
        super(1, r8, ECWindowTabCardListOperationPlugin.class, "onReceiveWindowCardRemoveEvent", "onReceiveWindowCardRemoveEvent(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ECWindowTabCardListOperationPlugin r0 = (ECWindowTabCardListOperationPlugin) ((CallableReference) this).receiver;
        int r1 = ECWindowTabCardListOperationPlugin.f;
        if (r0.h(r4) == false) goto L20;
        gp3.a.C0128a r2 = gp3.a.c;
        String r5 = r4.toString();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "json");
        gp3.a.b r6 = (gp3.a.b) u0.b(r5, gp3.a.b.class);
        if (r6 != null) goto L8;
        gp3.a r7 = null;
    L16:
        if (r7 == null) goto L21;
        r0.e.invoke(r7);
        return;
    L21:
        return;
    L8:
        String r3 = r6.b();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        Integer r8 = r6.a();
        if (r8 == null) goto L14;
        int r9 = r8.intValue();
    L15:
        r7 = new gp3.a(r3, r9);
        goto L16
    L14:
        r9 = -1;
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
