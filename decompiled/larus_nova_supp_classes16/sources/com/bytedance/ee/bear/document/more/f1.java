package com.bytedance.ee.bear.document.more;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f1 implements com.bytedance.ee.bear.more.protocol3.panel.x {
    public final DocumentPluginHost a;
    public final com.bytedance.ee.bear.more.protocol3.h b;
    public final com.bytedance.ee.bear.more.protocol3.panel.t c;
    public final Map<String, com.bytedance.ee.bear.more.protocol3.panel.q> d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        tt5.a.h("MorePanelContext", "closePanel");
        this.b.c();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("MorePanelContext", "closePanel error", th, false);
        throw th;
    }

    public final void d6() {
        tt5.a.h("MorePanelContext", "refreshPanel");
        this.b.g();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("MorePanelContext", "refreshPanel error", th, false);
        throw th;
    }

    public final com.bytedance.ee.bear.more.protocol3.panel.z f6() {
        oj5.c r1 = this.b.d;
        Set r2 = null;
        if (r1 == null) goto L32;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        com.bytedance.ee.bear.more.protocol3.panel.b0 r4 = new com.bytedance.ee.bear.more.protocol3.panel.b0(r1.getToken(), r1.getType(), r1.b());
        com.bytedance.ee.bear.more.protocol3.panel.c0 r5 = new com.bytedance.ee.bear.more.protocol3.panel.c0(r1.isOwner(), r1.n(), r1.y(), r1.q(), r1.p(), r1.canOperateEntity(), r1.Q());
        String[] r7 = r1.B();
        if (r7 == null) goto L7;
        Set r8 = ArraysKt.toSet(r7);
    L8:
        if (r8 != null) goto L10;
        r8 = SetsKt.emptySet();
    L10:
        Set r17 = r8;
        Map r9 = r1.M();
        if (r9 != null) goto L13;
        r9 = MapsKt.emptyMap();
    L13:
        Map r18 = r9;
        String[] r10 = r1.u();
        if (r10 == null) goto L16;
        Set r11 = ArraysKt.toSet(r10);
    L17:
        if (r11 != null) goto L19;
        r11 = SetsKt.emptySet();
    L19:
        Set r19 = r11;
        String[] r12 = r1.O();
        if (r12 == null) goto L22;
        Set r13 = ArraysKt.toSet(r12);
    L23:
        if (r13 != null) goto L25;
        r13 = SetsKt.emptySet();
    L25:
        Set r20 = r13;
        String[] r14 = r1.l();
        if (r14 == null) goto L28;
        r2 = ArraysKt.toSet(r14);
    L28:
        if (r2 != null) goto L31;
        r2 = SetsKt.emptySet();
    L31:
        return new com.bytedance.ee.bear.more.protocol3.panel.g(r4, r5, new com.bytedance.ee.bear.more.protocol3.panel.a0(r17, r18, r19, r20, r2, r1.K()));
    L22:
        r13 = null;
        goto L23
    L16:
        r11 = null;
        goto L17
    L7:
        r8 = null;
        goto L8
    L32:
        return null;
    }

    public final Fragment getHostFragment() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(this.b.f().getHostFragment());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        Fragment r2 = (Fragment) r1;
        if (r2 != null) goto L16;
        r2 = this.a.getHostFragment();
        if (r2 != null) goto L16;
        throw new IllegalStateException("MorePanelContext.hostFragment is null, plugin not attached".toString());
    L16:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public Activity getActivity() {
        return com.bytedance.ee.bear.more.protocol3.panel.x.a.getActivity(this);
    }

    public final com.bytedance.ee.bear.more.protocol3.panel.q e6(String r3) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        com.bytedance.ee.bear.more.protocol3.panel.q r0 = this.c.a(com.bytedance.ee.bear.more.protocol3.panel.s.a(r3));
        tt5.a.h("MorePanelContext", r3 + " -> " + r0);
        return r0;
    }

    public f1(DocumentPluginHost r2, com.bytedance.ee.bear.more.protocol3.h r3, com.bytedance.ee.bear.more.protocol3.panel.e r4, Map r5) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "providerHost");
        Intrinsics.checkNotNullParameter(r4, "registry");
        Intrinsics.checkNotNullParameter(r5, "hostDelegates");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
