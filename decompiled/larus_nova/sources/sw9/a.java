package sw9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements pw9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<pw9.a> f543728a;

    @Override // pw9.a
    public final void a() {
        Iterator<T> r100 = this.f543728a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((pw9.a) r100.next()).a();
        goto L4
    }

    @Override // pw9.a
    public final int b() {
        pw9.a r100 = (pw9.a) CollectionsKt.lastOrNull(this.f543728a);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.b();
    }

    @Override // pw9.a
    public final int getChatInputHeight() {
        pw9.a r100 = (pw9.a) CollectionsKt.lastOrNull(this.f543728a);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getChatInputHeight();
    }

    @Override // pw9.a
    public final void requestChatInputFocus() {
        Iterator<T> r100 = this.f543728a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((pw9.a) r100.next()).requestChatInputFocus();
        goto L4
    }

    public a() {
        this.f543728a = new CopyOnWriteArrayList();
    }

    @Override // pw9.a
    public final void c(boolean r100) {
        Iterator<T> r101 = this.f543728a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((pw9.a) r101.next()).c(r100);
        goto L4
    }
}
