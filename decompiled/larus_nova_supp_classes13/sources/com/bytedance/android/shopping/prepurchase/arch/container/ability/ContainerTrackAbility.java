package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ContainerTrackAbility implements i {
    public final Set<String> a;
    public final List<Function2<String, Map<String, ? extends Object>, Unit>> b;
    public final Lazy c;
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.h d;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a e;

    public final class a implements m {
        public Map<String, ? extends Object> a;
        public Map<String, ? extends Object> b;
        public final /* synthetic */ ContainerTrackAbility c;

        public a(ContainerTrackAbility r1) {
            this.c = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "actionName");
            if (this.c.a.contains(r2) == true) goto L5;
            return this;
        L5:
            return null;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m d(Map<String, ? extends Object> r1) {
            this.a = r1;
            return this;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m c(View r2, String r3, PageFinder r4) {
            Intrinsics.checkNotNullParameter(r3, "btmId");
            Map<String, ? extends Object> r0 = null;
            if (r4 != null) goto L6;
            if (r2 != null) goto L23;
        L22:
            return this;
        L23:
            r4 = PageFinder.via(r2);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            ECExceptionMonitor.e(e);
            Map<String, ? extends Object> r5 = null;
        L11:
            if (r5 != null) goto L13;
        L16:
            boolean r6 = true;
        L18:
            if ((true ^ r6) == false) goto L20;
            r0 = r5;
        L20:
            if (r0 == null) goto L22;
            this.b = r0;
            goto L22
        L13:
            if (r5.isEmpty() == true) goto L16;
            r6 = false;
        L6:
            r5 = BtmSDK.INSTANCE.createReportParams(r3, r4);     // Catch: Exception -> L8
            goto L11
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final boolean a(String r5, boolean r6, String r7, PageFinder r8) {
            Intrinsics.checkNotNullParameter(r5, "actionName");
            if (r7 == null) goto L6;
            String r9 = r5 + r7;
            if (r9 == null) goto L6;
        L7:
            if (r6 == false) goto L9;
        L12:
            LinkedHashMap r10 = new LinkedHashMap();
            Map<String, ? extends Object> r0 = this.a;
            if (r0 == null) goto L15;
            r10.putAll(r0);
        L15:
            Map<String, ? extends Object> r1 = this.b;
            if (r1 == null) goto L19;
            r10.putAll(r1);
        L19:
            if (r10.get("btm") != null) goto L21;
        L23:
            this.c.d.q(r5, r8, r10);
            this.c.a.add(r9);
            Iterator<T> r11 = this.c.b.iterator();
        L25:
            if (r11.hasNext() == false) goto L27;
            ((Function2) r11.next()).invoke(r5, r10);
            goto L25
        L27:
            return true;
        L21:
            if ((!Intrinsics.areEqual(r10.get("btm"), "")) == false) goto L23;
            r10.put("saas_btm_id", r10.get("btm"));
            goto L23
        L9:
            if (this.c.a.contains(r9) == false) goto L12;
            return false;
        L6:
            r9 = r5;
            goto L7
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final PageFinder getPageFinder() {
        return (PageFinder) this.c.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final a m() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final Map<String, Object> u1() {
        return this.d.getEventParams();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void appendEventParams(Pair<String, ? extends Object>... r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.d.appendEventParams((Pair[]) Arrays.copyOf(r3, r3.length));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void y1(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.b).add(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void appendEventParams(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.d.p((LinkedTreeMap) r2);
    }

    public ContainerTrackAbility(com.bytedance.android.shopping.prepurchase.arch.container.intf.h r2, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r3) {
        Intrinsics.checkNotNullParameter(r2, "eventTrackerService");
        Intrinsics.checkNotNullParameter(r3, "containerDelegate");
        this.d = r2;
        this.e = r3;
        this.a = new LinkedHashSet();
        this.b = new ArrayList();
        this.c = LazyKt.lazy(new ContainerTrackAbility$_pageFinder$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void appendEventParamToEntranceInfo(String r2, String r3) {
        Intrinsics.checkNotNullParameter("share_with_head", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.d.o(r3);
    }
}
