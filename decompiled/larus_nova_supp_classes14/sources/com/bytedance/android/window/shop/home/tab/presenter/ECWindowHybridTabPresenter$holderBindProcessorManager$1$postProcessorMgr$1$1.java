package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zq3.v1;
import zq3.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lzq3/w1;", "p1", "", "p2", "", "invoke", "(Lzq3/w1;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1 extends FunctionReferenceImpl implements Function2<w1, String, Unit> {
    public static final ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1 INSTANCE = null;

    static {
        INSTANCE = new ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1();
    }

    public ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1() {
        super(2, w1.class, "onRenderEnd", "onRenderEnd(Ljava/lang/String;)V", 0);
    }

    public final void invoke(w1 r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "p1");
        if (r12 != null) goto L5;
        r11.getClass();
        return;
    L5:
        ArrayList r0 = (ArrayList) r11.a;
        ListIterator r1 = r0.listIterator(r0.size());
    L6:
        JSONObject r2 = null;
        if (r1.hasPrevious() == false) goto L11;
        Object r3 = r1.previous();
        if ((((v1) r3) instanceof v1.d) == false) goto L6;
    L13:
        if ((r3 instanceof v1.d) == true) goto L15;
        r3 = null;
    L15:
        v1.d r4 = (v1.d) r3;
        if (r4 != null) goto L19;
        return;
    L19:
        if ((!Intrinsics.areEqual(r4.c, r12)) == true) goto L77;
        ArrayList r5 = (ArrayList) r11.a;
        ListIterator r6 = r5.listIterator(r5.size());
    L22:
        int r7 = 0;
        if (r6.hasPrevious() == false) goto L32;
        v1 r8 = (v1) r6.previous();
        if ((r8 instanceof v1.c) == true) goto L27;
    L29:
        boolean r9 = false;
    L30:
        if (r9 == false) goto L22;
        int r10 = r6.nextIndex();
    L33:
        if (r10 < 0) goto L78;
        Object r13 = ListProtector.get(r11.a, r10);
        if ((r13 instanceof v1.c) == true) goto L38;
        r13 = null;
    L38:
        v1.c r14 = (v1.c) r13;
        if (r14 != null) goto L42;
        return;
    L42:
        if (r14.c != 0) goto L52;
        List<v1> r15 = r11.a;
    L44:
        if (r7 >= r10) goto L49;
        if ((ListProtector.get(r15, r7) instanceof v1.h) == true) goto L47;
        r7 = r7 + 1;
        goto L44
    L47:
        Integer r16 = Integer.valueOf(r7);
    L50:
        if (r16 == null) goto L75;
        r10 = r16.intValue();
        goto L52
    L75:
        return;
    L49:
        r16 = null;
    L52:
        if (r10 != 0) goto L54;
        List<v1> r17 = r11.a;
    L55:
        v1.g r18 = new v1.g(r12);
        r17.add(r18);
        if (r14.c != 0) goto L58;
        ((ArrayList) r11.c).clear();
        ((ArrayList) r11.c).addAll(r17);
    L62:
        ((ArrayList) r11.a).clear();
        return;
    L58:
        r11.d(r17, Long.valueOf(r18.b));
        Map<String, Object> r19 = r11.b(r17, r4.f);
        Map r20 = w1.a(r17);
        int r21 = ECMonitorService.b;
        JSONObject r22 = com.bytedance.android.ec.hybrid.list.util.k.b(r20);
        JSONObject r110 = com.bytedance.android.ec.hybrid.list.util.k.b(r19);
        Map<String, ? extends Object> r23 = r11.b;
        if (r23 == null) goto L61;
        r2 = com.bytedance.android.ec.hybrid.list.util.k.b(r23);
    L61:
        ECMonitorService.a.a("ec_perf_loadmore_window", r22, r110, r2);
        goto L62
    L54:
        ArrayList r24 = (ArrayList) r11.a;
        r17 = r24.subList(r10, r24.size());
        goto L55
    L78:
        return;
    L27:
        if (((v1.c) r8).d != r4.e) goto L29;
        r9 = true;
        goto L30
    L32:
        r10 = -1;
        goto L33
    L77:
        return;
    L11:
        r3 = null;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((w1) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
