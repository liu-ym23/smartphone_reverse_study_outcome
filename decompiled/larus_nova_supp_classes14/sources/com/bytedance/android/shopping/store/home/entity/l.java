package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.marquee.ECStoreTopMultiMarqueeItemVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public static final /* synthetic */ int g = 0;
    public List<com.bytedance.android.ec.store.repository.vo.i> a;
    public String b;
    public Map<String, String> c;
    public ij3.b d;
    public ECStoreTopMultiMarqueeItemVO e;
    public Blcok f;

    public static final class a {
        public static l a(ECStoreHomeActivityResponse r9) {
            Intrinsics.checkNotNullParameter(r9, "response");
            l r0 = new l();
            ECStoreDynamicModule r1 = r9.getDynamicModule();
            ECStoreTopMultiMarqueeItemVO r2 = null;
            if (r1 == null) goto L10;
            List<com.bytedance.android.ec.store.repository.dto.d> r3 = r1.getComponents();
            if (r3 == null) goto L10;
            List<com.bytedance.android.ec.store.repository.dto.d> r4 = r3;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r6 = r4.iterator();
        L8:
            if (r6.hasNext() == false) goto L11;
            com.bytedance.android.ec.store.repository.dto.d r7 = (com.bytedance.android.ec.store.repository.dto.d) r6.next();
            int r8 = com.bytedance.android.ec.store.repository.vo.i.a;
            r5.add(com.bytedance.android.ec.store.repository.vo.i.a.a(r7));
        L11:
            r0.a = r5;
            r0.b = r9.getExtraSchema();
            r0.c = r9.getFloatSchema();
            int r10 = ij3.b.b;
            List<ij3.a> r11 = r9.getMarqueeBubble();
            if (r11 != null) goto L14;
            ij3.b r12 = null;
        L19:
            r0.d = r12;
            int r13 = ECStoreTopMultiMarqueeItemVO.b;
            List<ij3.c> r14 = r9.getMultiMarqueeBubble();
            if (r14 == null) goto L27;
            ArrayList r15 = new ArrayList();
            Iterator<T> r16 = r14.iterator();
        L24:
            if (r16.hasNext() == false) goto L26;
            ij3.c r17 = (ij3.c) r16.next();
            r15.add(new ECStoreTopMultiMarqueeItemVO.b(r17.c(), r17.d(), r17.a(), r17.b()));
            goto L24
        L26:
            r2 = new ECStoreTopMultiMarqueeItemVO(r15);
        L27:
            r0.e = r2;
            r0.f = r9.getBlock();
            return r0;
        L14:
            ArrayList r18 = new ArrayList();
            Iterator<T> r19 = r11.iterator();
        L16:
            if (r19.hasNext() == false) goto L18;
            ij3.a r20 = (ij3.a) r19.next();
            r18.add(new ij3.b.C0136b(r20.c(), r20.d(), r20.a(), r20.b()));
            goto L16
        L18:
            r12 = new ij3.b(r18);
        L10:
            r5 = null;
            goto L11
        }
    }

    static {
    }

    public l() {
    }
}
