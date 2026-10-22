package h08;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.component.universe_design.toast.c f483480a;

    public /* synthetic */ o(com.larksuite.component.universe_design.toast.c r100) {
        this.f483480a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f483480a.cancel();
    }
}
