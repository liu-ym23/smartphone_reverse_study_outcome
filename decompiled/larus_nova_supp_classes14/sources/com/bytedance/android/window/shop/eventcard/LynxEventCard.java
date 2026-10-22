package com.bytedance.android.window.shop.eventcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.window.shop.eventcard.handler.f;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import ep3.c;
import ep3.d;
import hp3.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/LynxEventCard;", "Landroid/view/View;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lhp3/b;", "event", "", "call", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxEventCard extends View implements LifecycleEventObserver {
    public final WindowPageCardBridge a;
    public final ECLynxCard b;
    public final ViewGroup c;
    public final ECWindowViewModel d;

    public static final class a {
    }

    static {
    }

    public final boolean call(b r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        WindowPageCardBridge r0 = this.a;
        ECLynxCard r1 = this.b;
        r7.getClass();
        AtomicLong r2 = cp3.a.d;
        String r3 = r7.a;
        Map<String, Object> r8 = r7.a();
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r8, "eventParams");
        return r0.call(r1, new cp3.a(String.valueOf(cp3.a.d.getAndIncrement()), r3, r8));
    }

    public final void a(String r10, LifecycleOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        WindowPageCardBridge r0 = this.a;
        c[] r2 = new c[2];
        r2[0] = this.d.getParamProvider();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r6 = this.d.getBaseParams().entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Map.Entry r7 = (Map.Entry) r6.next();
        String r8 = (String) r7.getKey();
        String r9 = (String) r7.getValue();
        if (r9 == null) goto L4;
        r5.put(r8, r9);
        goto L4
    L9:
        Object r12 = this.d.getShopParam().getPassThroughParam("pass_through_api");
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        r5.put("pass_through_api", r12);
        r5.put("seven_split", Boolean.valueOf(this.d.isCroppedStyle()));
        r2[1] = new d(r5);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "providers");
        r0.c.put(4, new f(r2));
        ECLynxLoadParam.a r1 = new ECLynxLoadParam.a(getContext(), r10, this.c);
        r1.j(3000);
        WindowPageCardBridge r13 = this.a;
        r13.getClass();
        List r14 = CollectionsKt.listOf(new WindowPageCardBridge.a[]{new WindowPageCardBridge.a(r13, new WindowPageCardBridge$makeJsBridgeMap$1(r13), "ecom.window.page_event.event", false), new WindowPageCardBridge.a(r13, new WindowPageCardBridge$makeJsBridgeMap$2(r13), "ecom.window.page_event.async_event", true)});
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        Object r4 = r15.next();
        r3.put(((WindowPageCardBridge.a) r4).d, r4);
        goto L14
    L16:
        Intrinsics.checkNotNullParameter(r3, "ecBridgeMap");
        r1.r = r3;
        int r16 = zq3.d.a;
        r1.e(zq3.d.b(this.d, null, null));
        this.b.j(new ECLynxLoadParam(r1));
        this.b.n();
        r11.getLifecycle().addObserver(this);
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        Map<Lifecycle.Event, b> r0 = kp3.a.a;
        Intrinsics.checkNotNullParameter(r3, "lifecycleEvent");
        b r4 = (b) ((LinkedHashMap) kp3.a.a).get(r3);
        if (r4 == null) goto L6;
        call(r4);
    L6:
        if (r2.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L14;
        Iterator<com.bytedance.android.window.shop.eventcard.handler.a> r5 = this.a.c.values().iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        r5.next().release();
        goto L9
    L11:
        this.b.release();
        return;
    }

    public LynxEventCard(Context r2, ViewGroup r3, ECWindowViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        Intrinsics.checkNotNullParameter(r4, "shopViewModel");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.a = new WindowPageCardBridge(r4);
        this.b = new ECLynxCard();
    }
}
