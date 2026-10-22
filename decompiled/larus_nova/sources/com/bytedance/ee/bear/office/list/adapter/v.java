package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import java.util.Collection;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f235865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<OfficeLongPressLarkAction, String> f235866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<OfficeLongPressLarkAction, String> f235867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Collection<String>, Unit> f235868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<OfficeLongPressLarkAction, z> f235869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f235870f;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.f235870f == false) goto L5;
        return;
    L5:
        this.f235870f = true;
        tt5.a.h("OfficeLongPressActionSession", "release action session. sessionId=" + du5.b.k(this.f235865a) + ", actionCount=" + this.f235867c.size());
        this.f235868d.invoke(this.f235867c.values());
    }

    public static String b(z r100) {
        if (Intrinsics.areEqual(r100, z.d.f235884a) == false) goto L6;
        return "Visible";
    L6:
        if (Intrinsics.areEqual(r100, z.b.f235882a) == false) goto L9;
        return "Hidden";
    L9:
        if ((r100 instanceof z.c) == false) goto L12;
        return "Loading";
    L12:
        if ((r100 instanceof z.a) == false) goto L16;
        return "Disabled(reason=" + ((z.a) r100).f235881b + ')';
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final z a(OfficeLongPressLarkAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Map<OfficeLongPressLarkAction, z> r101 = this.f235869e;
        monitor-enter(r101);
        z r102 = this.f235869e.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean d(String r100, OfficeLongPressLarkAction r101, String r102, z r110) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r110, "availability");
        String r103 = this.f235867c.get(r101);
        String r104 = this.f235866b.get(r101);
        if (this.f235870f == false) goto L5;
    L23:
        tt5.a.h("OfficeLongPressActionSession", "reject availability update. sessionId=" + du5.b.k(this.f235865a) + ", action=" + r101 + ", result=" + b(r110) + ", released=" + this.f235870f + ", actionIdMatch=" + Intrinsics.areEqual(r103, r100) + ", refreshKeyMatch=" + Intrinsics.areEqual(r104, r102));
        return false;
    L5:
        if (Intrinsics.areEqual(r103, r100) == false) goto L23;
        if (Intrinsics.areEqual(r104, r102) == false) goto L23;
        Map<OfficeLongPressLarkAction, z> r105 = this.f235869e;
        monitor-enter(r105);
    L20:
        th = move-exception;
        throw th;
    L12:
        if (this.f235870f == false) goto L16;
        tt5.a.h("OfficeLongPressActionSession", "reject availability update after lock. sessionId=" + du5.b.k(this.f235865a) + ", action=" + r101 + ", result=" + b(r110) + ", released=true");     // Catch: Throwable -> L20
        monitor-exit(r105);
        return false;
    L16:
        this.f235869e.put(r101, r110);     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r105);
        tt5.a.h("OfficeLongPressActionSession", "update availability. sessionId=" + du5.b.k(this.f235865a) + ", action=" + r101 + ", result=" + b(r110));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(String r100, Map<OfficeLongPressLarkAction, ? extends z> r101, Map<OfficeLongPressLarkAction, String> r102, Map<OfficeLongPressLarkAction, String> r103, Function1<? super Collection<String>, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "initialAvailability");
        Intrinsics.checkNotNullParameter(r102, "refreshKeys");
        Intrinsics.checkNotNullParameter(r103, "actionIds");
        Intrinsics.checkNotNullParameter(r104, "release");
        this.f235865a = r100;
        this.f235866b = r102;
        this.f235867c = r103;
        this.f235868d = r104;
        this.f235869e = MapsKt.toMutableMap(r101);
    }
}
