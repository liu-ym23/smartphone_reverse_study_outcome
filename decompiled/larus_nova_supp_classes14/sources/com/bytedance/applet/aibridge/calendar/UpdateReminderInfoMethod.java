package com.bytedance.applet.aibridge.calendar;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.platform.api.b5;
import com.larus.platform.service.y;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import fv3.b;
import java.util.ArrayList;
import java.util.Iterator;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/calendar/UpdateReminderInfoMethod;", "Lcom/bytedance/applet/aibridge/calendar/AbsUpdateReminderInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/calendar/AbsUpdateReminderInfoMethodIDL$UpdateReminderInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/calendar/AbsUpdateReminderInfoMethodIDL$UpdateReminderInfoResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateReminderInfoMethod extends AbsUpdateReminderInfoMethodIDL {

    public static final class a {
    }

    static {
    }

    public UpdateReminderInfoMethod() {
    }

    public final void handle(d r11, ParamModel r12, h r13) {
        AbsUpdateReminderInfoMethodIDL.a r14 = (AbsUpdateReminderInfoMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        ArrayList r15 = new ArrayList();
        int r0 = r14.getType();
        if (r0 != UpdateCalendarType.ADD.getType()) goto L10;
        Iterator<T> r16 = r14.getReminderInfo().iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        RemindInfo r1 = fv3.a.b((LinkedTreeMap) r16.next());
        b5 r2 = y.a.a(fv3.a.a(r1));
        r15.add(b.a(r2, r1.getId()));
        FLogger.a.d("UpdateReminderInfoMethod", "handle: -" + r1.getId() + "-------" + r2.a);
        goto L6
    L8:
        Intrinsics.checkNotNullParameter(AbsUpdateReminderInfoMethodIDL.b.class, "<this>");
        AbsUpdateReminderInfoMethodIDL.b r17 = c.a(AbsUpdateReminderInfoMethodIDL.b.class);
        r17.setResultInfo(r15);
        r13.b(r17, "");
        return;
    L10:
        if (r0 != UpdateCalendarType.DELETE.getType()) goto L20;
        Iterator<T> r18 = r14.getReminderInfo().iterator();
    L13:
        if (r18.hasNext() == false) goto L18;
        RemindInfo r3 = fv3.a.b((LinkedTreeMap) r18.next());
        y r4 = y.a;
        String r5 = fv3.a.a(r3).a;
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r15.add(b.a(r4.remove(r5), r3.getId()));
        goto L13
    L18:
        Intrinsics.checkNotNullParameter(AbsUpdateReminderInfoMethodIDL.b.class, "<this>");
        AbsUpdateReminderInfoMethodIDL.b r19 = c.a(AbsUpdateReminderInfoMethodIDL.b.class);
        r19.setResultInfo(r15);
        r13.b(r19, "");
        return;
    L20:
        if (r0 != UpdateCalendarType.UPDATE.getType()) goto L26;
        Iterator<T> r110 = r14.getReminderInfo().iterator();
    L23:
        if (r110.hasNext() == false) goto L25;
        RemindInfo r6 = fv3.a.b((LinkedTreeMap) r110.next());
        y r7 = y.a;
        r7.remove(r6.getId());
        b5 r8 = r7.a(fv3.a.a(r6));
        FLogger.a.d("UpdateReminderInfoMethod", "handle: -" + r6.getId() + "-------" + r8.a);
        r15.add(b.a(r8, r6.getId()));
        goto L23
    L25:
        Intrinsics.checkNotNullParameter(AbsUpdateReminderInfoMethodIDL.b.class, "<this>");
        AbsUpdateReminderInfoMethodIDL.b r111 = c.a(AbsUpdateReminderInfoMethodIDL.b.class);
        r111.setResultInfo(r15);
        r13.b(r111, "");
        return;
    L26:
        h.a.a(r13, null, null, null, 15);
    }
}
