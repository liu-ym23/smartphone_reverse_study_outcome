package h05;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements r05.a.InterfaceC7408a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f483440a;

    @Override // r05.a.InterfaceC7408a
    public final void onClick() {
        e05.a r100 = (e05.a) this.f483440a.f483436c.getHostAbilityOrNull(e05.a.class);
        if (r100 == null) goto L6;
        r100.disassociateExitingDoc();
        return;
    }

    public d(a r100) {
        this.f483440a = r100;
    }
}
