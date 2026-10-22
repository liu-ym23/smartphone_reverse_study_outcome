package ex9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements ax9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<ax9.a> f474724a;

    @Override // ax9.a
    public final void a() {
        Iterator<T> r100 = this.f474724a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ax9.a) r100.next()).a();
        goto L4
    }

    @Override // ax9.a
    public final void b() {
        Iterator<T> r100 = this.f474724a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ax9.a) r100.next()).b();
        goto L4
    }

    @Override // ax9.a
    public final void c() {
        Iterator<T> r100 = this.f474724a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ax9.a) r100.next()).c();
        goto L4
    }

    @Override // ax9.a
    public final int getChatInputHeight() {
        ax9.a r100 = (ax9.a) CollectionsKt.lastOrNull(this.f474724a);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getChatInputHeight();
    }

    @Override // ax9.a
    public final void requestChatInputFocus() {
        Iterator<T> r100 = this.f474724a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ax9.a) r100.next()).requestChatInputFocus();
        goto L4
    }

    public a() {
        this.f474724a = new CopyOnWriteArrayList();
    }
}
