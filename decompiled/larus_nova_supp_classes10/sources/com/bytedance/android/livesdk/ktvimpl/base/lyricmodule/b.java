package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.music.download.h;
import com.bytedance.android.live.ktv.common.music.download.i;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ud2.b {
    public final i a;
    public final HashMap<Long, c> b;
    public final C0009b c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.b$b, reason: collision with other inner class name */
    public static final class C0009b implements i.a {
        public final /* synthetic */ b a;

        public C0009b(b r1) {
            this.a = r1;
        }

        public final void b(ub0.c r8) {
            Intrinsics.checkNotNullParameter(r8, "lyricsDownloadInfo");
            long r0 = r8.b;
            c r2 = this.a.b.get(Long.valueOf(r0));
            if (r2 == null) goto L16;
            ArrayList<Function1<ub0.a, Unit>> r3 = r2.a;
            if (r3 == null) goto L16;
            if ((!r3.isEmpty()) != true) goto L16;
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r8, LocationMonitorConst.INFO);
            com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b r4 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a;
            long r5 = r8.b;
            String r6 = r8.d;
            String r7 = r8.a;
            int r9 = r8.c;
            r4.getClass();
            ub0.d r10 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a(r5, r6, r7, r9);
            this.a.getClass();
            ub0.a r11 = b.c(r0, r10);
            c r12 = this.a.b.get(Long.valueOf(r0));
            if (r12 == null) goto L16;
            ArrayList<Function1<ub0.a, Unit>> r13 = r12.a;
            if (r13 == null) goto L16;
            Iterator<Function1<ub0.a, Unit>> r14 = r13.iterator();
        L14:
            if (r14.hasNext() == false) goto L16;
            r14.next().invoke(r11);
        L16:
            this.a.b.remove(Long.valueOf(r0));
        }

        public final void a(long r2, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMsg");
            c r6 = this.a.b.get(Long.valueOf(r2));
            if (r6 == null) goto L16;
            ArrayList<Function1<ub0.a, Unit>> r7 = r6.a;
            if (r7 == null) goto L16;
            if ((!r7.isEmpty()) != true) goto L16;
            c r8 = this.a.b.get(Long.valueOf(r2));
            if (r8 == null) goto L16;
            ArrayList<Function1<ub0.a, Unit>> r9 = r8.a;
            if (r9 == null) goto L16;
            Iterator<Function1<ub0.a, Unit>> r10 = r9.iterator();
        L14:
            if (r10.hasNext() == false) goto L16;
            r10.next().invoke(new ub0.a.a(r2));
        L16:
            this.a.b.remove(Long.valueOf(r2));
        }
    }

    static {
    }

    @Override // ud2.b
    public final void clear() {
        this.b.clear();
    }

    public b() {
        this.a = new i();
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L7;
        e r1 = r0.user();
        if (r1 == null) goto L7;
        r1.n();
    L7:
        this.b = new HashMap();
        this.c = new C0009b(this);
    }

    public static ub0.a c(long r2, ub0.d r4) {
        if (r4.c.isEmpty() == false) goto L6;
        return new ub0.a.a(r2);
    L6:
        return new ub0.a.b(r2, r4.c, r4.getType());
    }

    @Override // ud2.b
    public final ub0.a b(long r2, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "savePath");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a.getClass();
        ub0.d r3 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a(r2, r5, "", r4);
        return c(r3.a, r3);
    }

    @Override // ud2.b
    public final void a(String r9, long r10, int r12, Function1<? super ub0.a, Unit> r13) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r13, "callBack");
        ALogger.i("CommonLyricResourceManager", "downloadAndParse：" + r10 + ", type:" + r12);
        if (this.b.containsKey(Long.valueOf(r10)) == false) goto L10;
        ALogger.i("downAndParse", r10 + " is download or already parse");
        c r11 = this.b.get(Long.valueOf(r10));
        if (r11 == null) goto L19;
        Intrinsics.checkNotNullParameter(r13, "cb");
        if (r11.a.contains(r13) == true) goto L20;
        r11.a.add(r13);
        return;
    L20:
        return;
    L19:
        return;
    L10:
        h r2 = h.a;
        ub0.c r0 = new ub0.c(r9, r10, r12, h.d(r9, r10));
        HashMap<Long, c> r14 = this.b;
        Long r15 = Long.valueOf(r10);
        c r16 = new c();
        Intrinsics.checkNotNullParameter(r13, "cb");
        if (r16.a.contains(r13) == true) goto L13;
        r16.a.add(r13);
    L13:
        Unit r17 = Unit.INSTANCE;
        r14.put(r15, r16);
        if (new PolarisFileWrapper(r0.d).exists() == false) goto L17;
        this.c.b(r0);
        return;
    L17:
        this.a.b(r0, this.c);
    }
}
