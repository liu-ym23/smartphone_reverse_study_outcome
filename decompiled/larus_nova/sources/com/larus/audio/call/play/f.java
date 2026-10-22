package com.larus.audio.call.play;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements u68.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f289322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<u68.a.b> f289323b;

    @Override // u68.a.b
    public final void a() {
        Iterator r100 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        u68.a.b r101 = (u68.a.b) r100.next();
        Intrinsics.checkNotNullParameter(r101, "$this$dispatch");
        r101.a();
        Unit r102 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void c() {
        Iterator r100 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        u68.a.b r101 = (u68.a.b) r100.next();
        Intrinsics.checkNotNullParameter(r101, "$this$dispatch");
        r101.c();
        Unit r102 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void onPaused() {
        Iterator r100 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        u68.a.b r101 = (u68.a.b) r100.next();
        Intrinsics.checkNotNullParameter(r101, "$this$dispatch");
        r101.onPaused();
        Unit r102 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void onPlayComplete() {
        String r100 = this.f289322a;
        this.f289322a = null;
        Iterator r101 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        u68.a.b r102 = (u68.a.b) r101.next();
        Intrinsics.checkNotNullParameter(r102, "$this$dispatch");
        if ((r102 instanceof e) == false) goto L8;
        ((e) r102).h(r100);
    L9:
        Unit r103 = Unit.INSTANCE;
        goto L4
    L8:
        r102.onPlayComplete();
        goto L9
    }

    @Override // u68.a.b
    public final void onResume() {
        Iterator r100 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        u68.a.b r101 = (u68.a.b) r100.next();
        Intrinsics.checkNotNullParameter(r101, "$this$dispatch");
        r101.onResume();
        Unit r102 = Unit.INSTANCE;
        goto L4
    }

    public f() {
        this.f289323b = new CopyOnWriteArraySet();
    }

    @Override // u68.a.b
    public final void b(Map<String, String> r100) {
        if (r100 == null) goto L8;
        String r101 = r100.get("query_round");
        if (r101 == null) goto L8;
        if ((!StringsKt.isBlank(r101)) == false) goto L8;
    L9:
        this.f289322a = r101;
        Iterator r102 = CollectionsKt.toList(this.f289323b).iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        u68.a.b r103 = (u68.a.b) r102.next();
        Intrinsics.checkNotNullParameter(r103, "$this$dispatch");
        r103.b(r100);
        Unit r104 = Unit.INSTANCE;
        goto L11
    L13:
        return;
    L8:
        r101 = null;
        goto L9
    }

    @Override // u68.a.b
    public final void d(h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = r100.f289333c;
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
        r101 = null;
    L6:
        this.f289322a = r101;
        Iterator r102 = CollectionsKt.toList(this.f289323b).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        u68.a.b r103 = (u68.a.b) r102.next();
        Intrinsics.checkNotNullParameter(r103, "$this$dispatch");
        r103.d(r100);
        Unit r104 = Unit.INSTANCE;
        goto L8
    }

    @Override // u68.a.b
    public final void e(boolean r100) {
        Iterator r101 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        u68.a.b r102 = (u68.a.b) r101.next();
        Intrinsics.checkNotNullParameter(r102, "$this$dispatch");
        r102.e(r100);
        Unit r103 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void f(TtsPlayEndType r100) {
        Intrinsics.checkNotNullParameter(r100, "endType");
        Iterator r101 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        u68.a.b r102 = (u68.a.b) r101.next();
        Intrinsics.checkNotNullParameter(r102, "$this$dispatch");
        r102.f(r100);
        Unit r103 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void g(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
        Iterator r101 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        u68.a.b r102 = (u68.a.b) r101.next();
        Intrinsics.checkNotNullParameter(r102, "$this$dispatch");
        r102.g(r100);
        Unit r103 = Unit.INSTANCE;
        goto L4
    }

    public final void h(u68.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((CopyOnWriteArraySet) this.f289323b).contains(r100) == false) goto L5;
        return;
    L5:
        ((CopyOnWriteArraySet) this.f289323b).add(r100);
    }

    @Override // u68.a.b
    public final void i(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
        Iterator r101 = CollectionsKt.toList(this.f289323b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        u68.a.b r102 = (u68.a.b) r101.next();
        Intrinsics.checkNotNullParameter(r102, "$this$dispatch");
        r102.i(r100);
        Unit r103 = Unit.INSTANCE;
        goto L4
    }
}
