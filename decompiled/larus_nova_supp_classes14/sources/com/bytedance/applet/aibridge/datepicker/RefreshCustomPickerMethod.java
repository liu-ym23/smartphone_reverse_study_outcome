package com.bytedance.applet.aibridge.datepicker;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import e3.d;
import f3.h;
import hv3.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/RefreshCustomPickerMethod;", "Lcom/bytedance/applet/aibridge/datepicker/AbsRefreshCustomPickerMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/datepicker/AbsRefreshCustomPickerMethodIDL$RefreshCustomPickerParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/datepicker/AbsRefreshCustomPickerMethodIDL$RefreshCustomPickerResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RefreshCustomPickerMethod extends AbsRefreshCustomPickerMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public RefreshCustomPickerMethod() {
    }

    public final void handle(d r13, ParamModel r14, h r15) {
        AbsRefreshCustomPickerMethodIDL.a r16 = (AbsRefreshCustomPickerMethodIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        a.c r17 = a.b();
        Long r1 = null;
        if (r17 != null) goto L5;
        h.a.a(r15, "No active customPicker", null, null, 14);
        return;
    L5:
        List<List<String>> r2 = r16.getOptionList();
        if (r2.isEmpty() == true) goto L56;
        List<List<String>> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        if (((List) r4.next()).isEmpty() == false) goto L14;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L56;
        int[] r0 = i.a(r2, r16.getSelectedOptionList());
        Number r18 = r16.getVersion();
        if (r18 == null) goto L24;
        r1 = Long.valueOf(r18.longValue());
    L24:
        Intrinsics.checkNotNullParameter(r2, "columns");
        Intrinsics.checkNotNullParameter(r0, "selectedIndices");
        if (r1 == null) goto L29;
        long r7 = r17.e;
        if (r1.longValue() == r7) goto L29;
    L55:
        Intrinsics.checkNotNullParameter(AbsRefreshCustomPickerMethodIDL.b.class, "<this>");
        r15.b(c.a(AbsRefreshCustomPickerMethodIDL.b.class), "");
        return;
    L29:
        long r8 = r17.k + 1;
        r17.k = r8;
        r17.d = r0;
        if (r2.size() == r17.c.size()) goto L32;
        r17.j = new a.b(r8, r2, r0);
        r17.f();
        goto L55
    L32:
        List<? extends List<String>> r19 = CollectionsKt.toMutableList(r17.c);
        Iterator<T> r6 = r3.iterator();
        int r9 = 0;
    L34:
        if (r6.hasNext() == false) goto L54;
        Object r10 = r6.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        List<String> r12 = (List) r10;
        Integer r20 = ArraysKt.getOrNull(r0, r9);
        if (r20 == null) goto L41;
        int r21 = r20.intValue();
    L43:
        if (Intrinsics.areEqual(ArraysKt.getOrNull(r17.f, r9), Boolean.TRUE) == false) goto L45;
        Integer r22 = Integer.valueOf(r9);
        r17.i.put(r22, new a.C0046a(r8, r12, r21));
    L53:
        r9 = r11;
        goto L34
    L45:
        r17.a(r9, r12, r21);
        if (r9 >= 0) goto L48;
    L50:
        boolean r23 = false;
    L51:
        if (r23 == false) goto L53;
        ListProtector.set(r19, r9, r12);
        goto L53
    L48:
        if (r9 >= r19.size()) goto L50;
        r23 = true;
        goto L51
    L41:
        r21 = r12.size() / 2;
        goto L43
    L54:
        r17.c = r19;
    L18:
        r5 = false;
        goto L19
    L10:
        if (r3.isEmpty() == false) goto L12;
    L56:
        h.a.a(r15, "optionList is Empty", null, null, 14);
    }
}
