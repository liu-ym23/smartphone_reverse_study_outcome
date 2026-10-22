package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import com.bytedance.android.live.core.log.ALogger;
import fd2.a0;
import fd2.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class AbsLyricService implements l {
    public a0 b;
    public ub0.a c;
    public final Function1<? super Long, Boolean> d;
    public final com.bytedance.android.livesdk.ktvapi.config.a e;
    public final ud2.b f;
    public final ud2.a g;

    public static final class a {
    }

    static {
    }

    public void reset() {
        this.g.clear();
        this.f.clear();
    }

    public void k(final a0 r7) {
        Intrinsics.checkNotNullParameter(r7, "request");
        if (r7.a != null) goto L5;
        ALogger.e(bb0.b.b(), "prepareShow fail, url is null, invoke class :".concat(AbsLyricService.class.getSimpleName()));
    L5:
        this.b = r7;
        final Function1<ub0.a, Unit> r0 = new AbsLyricService$prepareShow$lyricHandleTask$1(this, r7);
        String r1 = r7.d;
        String r2 = "";
        if (r1 != null) goto L8;
    L19:
        ud2.b r3 = this.f;
        String r4 = r7.a;
        if (r4 == null) goto L23;
        r2 = r4;
    L23:
        String r5 = r2;
        r3.a(r5, r7.b, r7.c, new AbsLyricService$prepareShow$2(r0));
        return;
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 != true) goto L19;
        ud2.b r8 = this.f;
        long r9 = r7.b;
        int r10 = r7.c;
        String r11 = r7.d;
        if (r11 == null) goto L16;
        r2 = r11;
    L16:
        ub0.a r12 = r8.b(r9, r10, r2);
        if (r12 == null) goto L25;
        Unit r13 = (Unit) r0.invoke(r12);
        return;
    L25:
        return;
    L10:
        r6 = false;
        goto L11
    }

    public AbsLyricService(com.bytedance.android.livesdk.ktvapi.config.a r2, ud2.b r3, ud2.a r4) {
        Intrinsics.checkNotNullParameter(r2, "displayConfig");
        Intrinsics.checkNotNullParameter(r3, "resourceManager");
        Intrinsics.checkNotNullParameter(r4, "displayModel");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.d = new AbsLyricService$lyricChecker$1(this);
    }

    public static List t(List r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "list");
        ArrayList r0 = new ArrayList();
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L17;
        com.bytedance.component.lyric.model.b r1 = (com.bytedance.component.lyric.model.b) r10.next();
        long r2 = r1.b;
        if (r2 > r9) goto L8;
    L9:
        long r5 = r1.c;
        if (r5 <= r9) goto L13;
        if (r2 >= r9) goto L13;
    L16:
        r0.add(r1);
    L13:
        if (r2 >= r11) goto L4;
        if (r5 <= r11) goto L4;
    L8:
        if (r1.c < r11) goto L16;
    L17:
        return r0;
    }

    public void r(long r1, boolean r3, Boolean r4) {
        this.g.e(r1);
    }
}
