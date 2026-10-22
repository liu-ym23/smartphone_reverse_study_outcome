package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvRoomGuestWidget$realOnCreate$seiCallback$1 extends FunctionReferenceImpl implements Function1<SeiAppData, Unit> {
    public KtvRoomGuestWidget$realOnCreate$seiCallback$1(KtvRoomGuestWidget r8) {
        super(1, r8, KtvRoomGuestWidget.class, "talkStateUpdatedBySei", "talkStateUpdatedBySei(Lcom/bytedance/android/livesdkapi/model/SeiAppData;)V", 0);
    }

    public final void invoke(SeiAppData r10) {
        KtvRoomGuestWidget r0 = (KtvRoomGuestWidget) ((CallableReference) this).receiver;
        int r1 = KtvRoomGuestWidget.G2;
        r0.getClass();
        if (r10 == null) goto L5;
        List r2 = r10.getGrids();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (r10.getGrids().isEmpty() == true) goto L30;
        List r11 = r10.getGrids();
        int r3 = r11.size();
        String[] r4 = new String[r3];
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r6 >= r3) goto L13;
        r4[r6] = "";
        r6 = r6 + 1;
        goto L11
    L13:
        boolean[] r7 = new boolean[r3];
        int[] r8 = new int[r3];
        int r9 = 0;
    L14:
        if (r9 >= r3) goto L20;
        SeiRegion r12 = (SeiRegion) ListProtector.get(r11, r9);
        r4[r9] = r12.getInteractId().toString();
        if (r12.getTalk() == 0) goto L18;
        boolean r13 = true;
    L19:
        r7[r9] = r13;
        r8[r9] = r12.getTalk();
        r9 = r9 + 1;
        goto L14
    L18:
        r13 = false;
    L20:
        if (r5 >= r3) goto L22;
        Map<String, Integer> r14 = r0.M1;
        HashMap r15 = (HashMap) r14;
        r15.put(r4[r5], Integer.valueOf(r8[r5]));
        r5 = r5 + 1;
        goto L20
    L22:
        r0.jr(r4, r8, r7);
        return;
    L30:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((SeiAppData) r1);
        return Unit.INSTANCE;
    }
}
