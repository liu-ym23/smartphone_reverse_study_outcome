package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.shopping.prepurchase.arch.exposure.ExposureEngine;
import com.bytedance.android.shopping.prepurchase.arch.exposure.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ b c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.services.a$a, reason: collision with other inner class name */
    public static final class C0172a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ a a;

        public C0172a(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r11) {
            List r12 = (List) r11;
            if (r12 == null) goto L53;
            final b r0 = this.a.c;
            int r1 = b.m;
            r0.getClass();
            ArrayList r2 = new ArrayList();
            Iterator<T> r13 = r12.iterator();
        L7:
            if (r13.hasNext() == false) goto L18;
            com.bytedance.android.ecom.arch.slice.adapter.b r3 = (com.bytedance.android.ecom.arch.slice.adapter.b) r13.next();
            List r4 = null;
            if ((r3 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L11;
            r3 = null;
        L11:
            com.bytedance.android.ecom.arch.slice.g r5 = (com.bytedance.android.ecom.arch.slice.g) r3;
            if (r5 == null) goto L16;
            com.bytedance.android.ecom.arch.slice.b r6 = r5.getExposure();
            if (r6 == null) goto L16;
            r4 = r6.a();
        L16:
            if (r4 == null) goto L7;
            r2.add(r4);
            goto L7
        L18:
            List r14 = CollectionsKt.flatten(r2);
            ArrayList r7 = new ArrayList();
            Iterator<T> r15 = r14.iterator();
        L20:
            if (r15.hasNext() == false) goto L24;
            T r8 = r15.next();
            if (((com.bytedance.android.ecom.arch.slice.c) r8).a() == false) goto L20;
            r7.add(r8);
            goto L20
        L24:
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r9 = r7.iterator();
        L26:
            if (r9.hasNext() == false) goto L35;
            final com.bytedance.android.ecom.arch.slice.c r10 = (com.bytedance.android.ecom.arch.slice.c) r9.next();
            String r17 = r10.b();
            Intrinsics.checkNotNull(r17);
            float r18 = r10.e();
            com.bytedance.android.shopping.prepurchase.arch.exposure.g r19 = new ExposureService$updateExposureTask$$inlined$map$lambda$1(r10, r0);
            List r20 = r10.d();
            if (r20 == null) goto L33;
            List r21 = r20;
            ?? r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator<T> r23 = r21.iterator();
        L31:
            if (r23.hasNext() == false) goto L34;
            r22.add(new l((String) r23.next()));
        L34:
            r16.add(new com.bytedance.android.shopping.prepurchase.arch.exposure.d(r17, r18, r22, r19));
            goto L26
        L33:
            r22 = CollectionsKt.emptyList();
            goto L34
        L35:
            ExposureEngine r24 = r0.j;
            if (r24 == null) goto L52;
            r24.c(r16);
            return;
        L52:
            return;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.c.O1().d().getData().b(), this.c, new C0172a(this));
    }

    public a(b r1) {
        this.c = r1;
        super("updateExposureTask");
    }
}
