package com.bytedance.android.shopping.deepfeed.event;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ DeepFeedProductEventTracker a;
    public final /* synthetic */ String b;
    public final /* synthetic */ InFeedProductV2 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ List e;
    public final /* synthetic */ Map f;
    public final /* synthetic */ View g;

    public final void a(String r5, Map<Object, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        Map<String, ? extends Object> r0 = this.a.g(this.d, this.c, this.e);
        ArrayList r1 = new ArrayList(r6.size());
        Iterator r7 = ((LinkedHashMap) r6).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r7.next();
        r1.add(TuplesKt.to(r2.getKey().toString(), r2.getValue()));
        goto L4
    L6:
        MapsKt.putAll(r0, r1);
        Map<? extends String, ? extends Object> r8 = this.f;
        if (r8 == null) goto L9;
        r0.putAll(r8);
    L9:
        DeepFeedProductEventTracker r9 = this.a;
        InFeedProductV2 r3 = this.c;
        r9.getClass();
        DeepFeedProductEventTracker.f(r3, r0);
        InFeedProductV2 r10 = this.c;
        if (r10 == null) goto L14;
        String r11 = DeepFeedProductEventTracker.a(this.a, r10);
        if (r11 == null) goto L14;
        r0.put("is_other_channel", r11);
    L14:
        this.a.getClass();
        DeepFeedProductEventTracker.b(r0);
        DeepFeedProductEventTracker r12 = this.a;
        le3.b.a(r0, this.b, this.g);
        r12.doEventAction(r5, r0);
    }

    public e(DeepFeedProductEventTracker r1, String r2, InFeedProductV2 r3, int r4, List r5, Map r6, ConstraintLayout r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
