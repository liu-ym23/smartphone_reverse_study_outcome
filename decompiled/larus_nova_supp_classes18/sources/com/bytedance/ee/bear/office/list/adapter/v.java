package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import java.util.Collection;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v {
    public final String a;
    public final Map<OfficeLongPressLarkAction, String> b;
    public final Map<OfficeLongPressLarkAction, String> c;
    public final Function1<Collection<String>, Unit> d;
    public final Map<OfficeLongPressLarkAction, z> e;
    public volatile boolean f;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        tt5.a.h("OfficeLongPressActionSession", "release action session. sessionId=" + du5.b.k(this.a) + ", actionCount=" + this.c.size());
        this.d.invoke(this.c.values());
    }

    public static String b(z r2) {
        if (Intrinsics.areEqual(r2, z.d.a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r2, z.b.a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r2 instanceof z.c) == false) goto L12;
        return "Loading";
    L12:
        if ((r2 instanceof z.a) == false) goto L16;
        return "Disabled(reason=" + ((z.a) r2).b + ')';
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final z a(OfficeLongPressLarkAction r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Map<OfficeLongPressLarkAction, z> r0 = this.e;
        monitor-enter(r0);
        z r5 = this.e.get(r4);     // Catch: Throwable -> L9
        if (r5 != null) goto L7;
        r5 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);
        return r5;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean d(String r7, OfficeLongPressLarkAction r8, String r9, z r10) {
        Intrinsics.checkNotNullParameter(r7, "actionId");
        Intrinsics.checkNotNullParameter(r8, "action");
        Intrinsics.checkNotNullParameter(r10, "availability");
        String r1 = this.c.get(r8);
        String r2 = this.b.get(r8);
        if (this.f == false) goto L5;
    L23:
        tt5.a.h("OfficeLongPressActionSession", "reject availability update. sessionId=" + du5.b.k(this.a) + ", action=" + r8 + ", result=" + b(r10) + ", released=" + this.f + ", actionIdMatch=" + Intrinsics.areEqual(r1, r7) + ", refreshKeyMatch=" + Intrinsics.areEqual(r2, r9));
        return false;
    L5:
        if (Intrinsics.areEqual(r1, r7) == false) goto L23;
        if (Intrinsics.areEqual(r2, r9) == false) goto L23;
        Map<OfficeLongPressLarkAction, z> r11 = this.e;
        monitor-enter(r11);
    L20:
        th = move-exception;
        throw th;
    L12:
        if (this.f == false) goto L16;
        tt5.a.h("OfficeLongPressActionSession", "reject availability update after lock. sessionId=" + du5.b.k(this.a) + ", action=" + r8 + ", result=" + b(r10) + ", released=true");     // Catch: Throwable -> L20
        monitor-exit(r11);
        return false;
    L16:
        this.e.put(r8, r10);     // Catch: Throwable -> L20
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r11);
        tt5.a.h("OfficeLongPressActionSession", "update availability. sessionId=" + du5.b.k(this.a) + ", action=" + r8 + ", result=" + b(r10));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(String r2, Map<OfficeLongPressLarkAction, ? extends z> r3, Map<OfficeLongPressLarkAction, String> r4, Map<OfficeLongPressLarkAction, String> r5, Function1<? super Collection<String>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "initialAvailability");
        Intrinsics.checkNotNullParameter(r4, "refreshKeys");
        Intrinsics.checkNotNullParameter(r5, "actionIds");
        Intrinsics.checkNotNullParameter(r6, "release");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = MapsKt.toMutableMap(r3);
    }
}
