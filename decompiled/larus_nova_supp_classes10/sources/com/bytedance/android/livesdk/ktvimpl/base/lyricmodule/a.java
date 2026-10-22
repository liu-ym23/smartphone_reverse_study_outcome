package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements ud2.a {
    public final ArrayList<com.bytedance.component.lyric.model.b> a;
    public int b;
    public int c;
    public int d;
    public final ArrayList<Function1<List<com.bytedance.component.lyric.model.b>, Unit>> e;
    public final ArrayList<com.bytedance.component.lyric.model.b> f;
    public Integer g;
    public Integer h;
    public final com.bytedance.android.livesdk.ktvapi.config.a i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.a$a, reason: collision with other inner class name */
    public static final class C0008a {
    }

    static {
    }

    public final void g() {
        Integer r0 = this.g;
        Integer r1 = this.h;
        if (r0 == null) goto L15;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r0.intValue() >= 0) goto L8;
        return;
    L8:
        if (r0.intValue() < r1.intValue()) goto L10;
        return;
    L10:
        if (r1.intValue() > 0) goto L12;
        return;
    L12:
        if (r1.intValue() >= this.f.size()) goto L20;
        List<com.bytedance.component.lyric.model.b> r2 = this.f.subList(r0.intValue(), r1.intValue());
        ArrayList r3 = new ArrayList();
        r3.addAll(r2);
        this.a.clear();
        this.a.addAll(r3);
        ArrayList<com.bytedance.component.lyric.model.b> r4 = this.a;
        com.bytedance.component.lyric.model.b r5 = new com.bytedance.component.lyric.model.b();
        r5.a = 3;
        Unit r6 = Unit.INSTANCE;
        r4.add(r5);
        return;
    L20:
        return;
    }

    @Override // ud2.a
    public final int b() {
        return this.c;
    }

    @Override // ud2.a
    public final List c() {
        return this.a;
    }

    public a(com.bytedance.android.livesdk.ktvapi.config.a r2) {
        Intrinsics.checkNotNullParameter(r2, "baseConfig");
        this.i = r2;
        this.a = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    public final int f(long r7) {
        int r0 = this.a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L33;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.a, r2)).a != 0) goto L31;
        if (r7 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.a, 0)).b) goto L8;
        if (r7 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.a, r2)).b) goto L20;
        if (r2 <= 0) goto L20;
        int r8 = r2 - 1;
        com.bytedance.component.lyric.model.b r9 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(this.a, r8);
        if (r9 != null) goto L15;
    L18:
        this.c = r2;
        goto L33
    L15:
        if (r9.a != 0) goto L18;
        this.c = r8;
    L20:
        if (r2 != (this.a.size() - 1)) goto L25;
        if (r7 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.a, r2)).b) goto L25;
        this.c = this.a.size() - 1;
    L25:
        if (r2 >= this.a.size()) goto L31;
        if (r7 <= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.a, r2)).b) goto L31;
        if (r7 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.a, r2)).c) goto L31;
        this.c = r2;
        goto L31
    L8:
        this.c = 0;
    L31:
        r2 = r2 + 1;
    L33:
        return this.c;
    }

    @Override // ud2.a
    public final void d(int r1, int r2) {
        this.g = Integer.valueOf(r1);
        this.h = Integer.valueOf(r2);
        g();
    }
}
