package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements com.ss.android.lark.threaddetail.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f414296a;

    @Override // com.ss.android.lark.threaddetail.b.a
    public final void b() {
    }

    @Override // com.ss.android.lark.threaddetail.b.a
    public final m2b.a a() {
        return this.f414296a.getContext();
    }

    @Override // com.ss.android.lark.threaddetail.b.a
    public final int getContainerWidth() {
        m2b.a r100 = a();
        if (r100 == null) goto L9;
        lya.a r101 = r100.l();
        if (r101 == null) goto L9;
        Integer r102 = r101.a();
        if (r102 == null) goto L9;
        return r102.intValue();
    L9:
        return 0;
    }

    public a(b r100) {
        this.f414296a = r100;
    }
}
