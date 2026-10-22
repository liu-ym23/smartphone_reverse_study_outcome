package h05;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements r05.a.InterfaceC0278a {
    public final /* synthetic */ a a;

    @Override // r05.a.InterfaceC0278a
    public final void onClick() {
        e05.a r0 = (e05.a) this.a.c.getHostAbilityOrNull(e05.a.class);
        if (r0 == null) goto L6;
        r0.disassociateExitingDoc();
        return;
    }

    public d(a r1) {
        this.a = r1;
    }
}
