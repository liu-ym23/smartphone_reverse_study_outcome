package z88;

import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.avlink.business.api.DoraAvlinkSessionMode;
import com.larus.avlink.business.api.DoraAvlinkSessionState;
import com.larus.avlink.business.timeout.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y88.g;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements y88.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f570960b;

    @Override // y88.f
    public final void B0() {
        this.f570960b.b(y88.e.b.f566922a);
    }

    @Override // y88.f
    public final void D() {
        this.f570960b.b(y88.e.a.f566921a);
    }

    @Override // y88.f
    public final void e3() {
        b r100 = this.f570960b;
        DoraAvlinkSessionState r101 = r100.f570954c.f570962b;
        DoraAvlinkSessionState r102 = DoraAvlinkSessionState.STOPPED;
        if (r101 != r102) goto L5;
        r100.f570958g.log("ignore duplicated session stopped");
        return;
    L5:
        f r103 = f.a(r100.f570954c, r102, null, 13);
        r100.f570954c = r103;
        Iterator<T> r104 = r100.f570952a.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        ((a) r104.next()).e(r103);
        goto L7
    }

    @Override // y88.f
    public final void release() {
        b r100 = this.f570960b;
        if (r100.f570955d == false) goto L9;
        Iterator<T> r101 = r100.f570952a.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((a) r101.next()).onDetach();
        goto L6
    L8:
        r100.f570955d = false;
    L9:
        r100.f570956e = DoraAvlinkSessionMode.NORMAL;
        r100.f570957f = false;
        r100.f570954c = new f("", null, null, 14);
    }

    @Override // y88.f
    public final void s1() {
        this.f570960b.b(y88.e.h.f566929a);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [z88.d] */
    public e() {
        this.f570960b = new b(CollectionsKt.listOf(new h()), new d());
    }

    @Override // y88.f
    public final void I(int r100) {
        b r101 = this.f570960b;
        g r102 = new g(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "config");
        Iterator<T> r103 = r101.f570952a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((a) r103.next()).d(r102);
        goto L4
    }

    @Override // y88.f
    public final void I2(boolean r100) {
        this.f570960b.b(new y88.e.C8315e(r100));
    }

    @Override // y88.f
    public final void R0(boolean r100) {
        this.f570960b.b(new y88.e.c(r100));
    }

    @Override // y88.f
    public final void c2(int r100) {
        b r101 = this.f570960b;
        DoraAvlinkSessionState r102 = (DoraAvlinkSessionState) CollectionsKt.getOrNull(DoraAvlinkSessionState.getEntries(), r100);
        if (r102 != null) goto L5;
        r102 = DoraAvlinkSessionState.UNKNOWN;
    L5:
        r101.b(new y88.e.f(r102));
    }

    @Override // y88.f
    public final void f2(y88.c r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r100 = this.f570960b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.a();
        switch(r110.f566917e) {
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        DoraAvlinkSessionMode r101 = DoraAvlinkSessionMode.NORMAL;
    L8:
        r100.f570956e = r101;
        r100.f570957f = false;
        String r102 = r110.f566913a;
        String r103 = null;
        if ((!StringsKt.isBlank(r102)) == true) goto L13;
        r102 = null;
    L13:
        if (r102 != null) goto L16;
        r102 = "";
    L16:
        if (r100.f570957f == false) goto L18;
        DoraAvlinkSessionMode r104 = DoraAvlinkSessionMode.LIVE_AI;
    L22:
        String r105 = r110.f566913a;
        if ((!StringsKt.isBlank(r105)) == false) goto L25;
        r103 = r105;
    L25:
        if (r103 != null) goto L27;
        String r106 = "";
    L28:
        String r111 = r110.f566914b;
        boolean r112 = r110.f566915c;
        boolean r113 = r110.f566916d;
        int r114 = r110.f566917e;
        boolean r115 = r110.f566918f;
        boolean r116 = r110.f566919g;
        boolean r107 = r110.f566920h;
        Intrinsics.checkNotNullParameter(r106, "sessionId");
        Intrinsics.checkNotNullParameter(r111, FailedBinderCallBack.CALLER_ID);
        f r108 = new f(r102, r104, new y88.c(r106, r111, r112, r113, r114, r115, r116, r107), 2);
        r100.f570954c = r108;
        Iterator<T> r109 = r100.f570952a.iterator();
    L30:
        if (r109.hasNext() == false) goto L32;
        ((a) r109.next()).c(r108);
        goto L30
    L32:
        return;
    L27:
        r106 = r103;
        goto L28
    L18:
        DoraAvlinkSessionMode r117 = r100.f570956e;
        DoraAvlinkSessionMode r118 = DoraAvlinkSessionMode.LIVE_AI;
        if (r117 != r118) goto L21;
        r104 = r118;
        goto L22
    L21:
        r104 = r100.f570956e;
        goto L22
    L5:
        r101 = DoraAvlinkSessionMode.ENVIRONMENT_OBSERVE;
        goto L8
    L6:
        r101 = DoraAvlinkSessionMode.SIMUL_INTERPRET;
        goto L8
    L7:
        r101 = DoraAvlinkSessionMode.LIVE_AI;
        goto L8
    }

    @Override // y88.f
    public final void r(boolean r100) {
        this.f570960b.b(new y88.e.d(r100));
    }

    @Override // y88.f
    public final void u0(boolean r100, int r101) {
        b r102 = this.f570960b;
        DoraAvlinkSessionState r103 = (DoraAvlinkSessionState) CollectionsKt.getOrNull(DoraAvlinkSessionState.getEntries(), r101);
        if (r103 != null) goto L5;
        r103 = DoraAvlinkSessionState.UNKNOWN;
    L5:
        r102.b(new y88.e.g(r100, r103));
    }
}
