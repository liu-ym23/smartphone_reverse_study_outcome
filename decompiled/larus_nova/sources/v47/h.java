package v47;

import com.bytedance.pia.core.worker.Worker;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class h implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Worker f553096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l47.a f553097b;

    public /* synthetic */ h(Worker r100, l47.a r101) {
        this.f553096a = r100;
        this.f553097b = r101;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        Worker r101 = this.f553096a;
        l47.a r102 = this.f553097b;
        String r103 = (String) r100;
        r101.getClass();
        com.bytedance.pia.core.utils.d.i(r101.f266410h + "Handle message from worker (Message: " + r103 + ")");
        r102.accept(r103);
    }
}
