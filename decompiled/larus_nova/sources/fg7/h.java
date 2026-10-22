package fg7;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import hg7.k;
import hg7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements f, Handler.Callback, com.bytedance.sync.v2.net.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f476893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xf7.g f476894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f476895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f476896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cg7.a f476897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f476898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f476899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f476900h;

    @Override // fg7.f
    public final void c() {
        f r100 = this.f476899g;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f476900h = true;
    }

    @Override // fg7.f
    public final void destroy() {
        zf7.b.a("Compensator: WsFirstCompensator destroy");
        ((m) rgc.b.a(m.class)).o(this);
        this.f476893a.b(new Object[0]).removeCallbacksAndMessages(null);
        f r100 = this.f476899g;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // com.bytedance.sync.v2.net.NetTrace.a
    public final int e() {
        f r100 = this.f476899g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        if ((r100 instanceof com.bytedance.sync.v2.compensate.e) == false) goto L9;
        return 1;
    L9:
        return 2;
    }

    @Override // com.bytedance.sync.v2.net.d.a
    public final void M(boolean r100) {
        zf7.b.a("Compensator: WsFirstCompensator onWsStatusChanged cur=" + r100 + ", before=" + this.f476898f);
        if (r100 != this.f476898f) goto L6;
        this.f476893a.b(new Object[0]).removeMessages(3);
        return;
    L6:
        if (this.f476893a.b(new Object[0]).hasMessages(3) == true) goto L10;
        this.f476893a.b(new Object[0]).sendMessageDelayed(this.f476893a.b(new Object[0]).obtainMessage(3, Boolean.valueOf(r100)), this.f476897e.f() * 1000);
        return;
    }

    @Override // fg7.f
    public final void a(cg7.a r100) {
        this.f476897e = r100;
        f r101 = this.f476899g;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // fg7.f
    public final void b(BsyncProtocol r100) {
        f r101 = this.f476899g;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what != 3) goto L11;
        boolean r101 = ((Boolean) r100.obj).booleanValue();
        if (r101 == this.f476898f) goto L10;
        f r102 = this.f476899g;
        if (r102 == null) goto L9;
        r102.destroy();
    L9:
        f r103 = f(r101, false);
        this.f476899g = r103;
        r103.d(this.f476897e, this.f476900h);
    L10:
        this.f476898f = r101;
    L11:
        return false;
    }

    @Override // fg7.f
    public final void d(cg7.a r100, boolean r101) {
        zf7.b.a("[Compensator] WsFirst start readyToPoll = " + r101);
        this.f476897e = r100;
        this.f476900h = r101;
        this.f476898f = this.f476894b.f563456c.a();
        ((m) rgc.b.a(m.class)).o0(this);
        f r102 = f(this.f476898f, true);
        this.f476899g = r102;
        r102.d(r100, r101);
    }

    public final f f(boolean r100, boolean r110) {
        if (r100 == false) goto L4;
        this.f476899g = new com.bytedance.sync.v2.compensate.e(this.f476895c, this.f476893a, this.f476896d);
    L6:
        return this.f476899g;
    L4:
        this.f476899g = new com.bytedance.sync.v2.compensate.a(this.f476895c, this.f476893a, this.f476896d, r110, false);
        goto L6
    }

    public h(e r100, com.bytedance.sync.v2.protocal.b r101, xf7.g r102) {
        this.f476895c = r100;
        this.f476896d = r101;
        this.f476893a = new g(this);
        this.f476894b = r102;
    }
}
