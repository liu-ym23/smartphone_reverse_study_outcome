package q45;

import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.y7;
import com.ss.android.lark.utils.LarkContext;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final Deque<a> a;
    public b b;

    public static class a {
        public Object a;
        public DocBridgeWebViewV2 b;

        public a() {
        }
    }

    public final synchronized DocBridgeWebViewV2 a() {
        monitor-enter(this);
        a r0 = new a();     // Catch: Throwable -> L9
        r0.b = new DocBridgeWebViewV2(LarkContext.getApplication(), "WebViewPool");     // Catch: Throwable -> L9
        ((LinkedList) this.a).addLast(r0);     // Catch: Throwable -> L9
        b r1 = this.b;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        y7 r2 = (y7) r1;     // Catch: Throwable -> L9
        r2.o(r0.b);     // Catch: Throwable -> L9
    L6:
        DocBridgeWebViewV2 r3 = r0.b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public final int e() {
        Iterator<a> r0 = this.a.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().a == null) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    public final int f() {
        return ((LinkedList) this.a).size();
    }

    public c() {
        this.a = new LinkedList();
    }

    public final synchronized void b(DocBridgeWebViewV2 r3) {
        monitor-enter(this);
        if (r3 != null) goto L24;
        monitor-exit(this);
        return;
    L24:
        b r0 = this.b;     // Catch: Throwable -> L21
        if (r0 == null) goto L10;
        ((y7) r0).p(r3);     // Catch: Throwable -> L21
    L10:
        if (this.a.isEmpty() == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        Iterator<a> r1 = this.a.iterator();     // Catch: Throwable -> L21
    L15:
        if (r1.hasNext() == false) goto L19;
        if (r1.next().b != r3) goto L15;
        r1.remove();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized DocBridgeWebViewV2 c(Object r1, boolean r2) {
        monitor-enter(this);
        a r3 = d(r1, r2);     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        DocBridgeWebViewV2 r4 = r3.b;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r4;
    L7:
        r4 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final a d(Object r5, boolean r6) {
        a r1 = null;
        if (this.a.isEmpty() == true) goto L16;
        if (r5 == null) goto L16;
        Iterator<a> r0 = this.a.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        a r2 = r0.next();
        if (r5.equals(r2.a) == false) goto L8;
        r1 = r2;
    L12:
        if (r1 == null) goto L16;
        r1.a = r5;
        if (r6 == false) goto L16;
        ((LinkedList) this.a).remove(r1);
        ((LinkedList) this.a).addFirst(r1);
    L16:
        return r1;
    }

    public final synchronized DocBridgeWebViewV2 g(Object r7, boolean r8) {
        monitor-enter(this);
        a r1 = null;
        if (this.a.isEmpty() == false) goto L8;
        tt5.a.d("WebViewPool", "call provideWebView without initializing pool!");     // Catch: Throwable -> L28
        monitor-exit(this);
        return null;
    L8:
        Iterator r0 = ((LinkedList) this.a).descendingIterator();     // Catch: Throwable -> L28
        a r2 = null;
    L10:
        if (r0.hasNext() == false) goto L20;
        a r3 = (a) r0.next();     // Catch: Throwable -> L28
        if (r3.a != null) goto L10;
        if (r3.b.M() == r8) goto L15;
        if (r2 == null) goto L19;
        if (r3.b.getUsedCount() <= r2.b.getUsedCount()) goto L10;
    L19:
        r2 = r3;
        goto L10
    L15:
        r1 = r3;
    L20:
        if (r1 == null) goto L23;
        r2 = r1;
    L23:
        if (r2 != null) goto L25;
        r2 = (a) ((LinkedList) this.a).getLast();     // Catch: Throwable -> L28
    L25:
        ((LinkedList) this.a).remove(r2);     // Catch: Throwable -> L28
        ((LinkedList) this.a).addFirst(r2);     // Catch: Throwable -> L28
        r2.a = r7;     // Catch: Throwable -> L28
        DocBridgeWebViewV2 r9 = r2.b;     // Catch: Throwable -> L28
        monitor-exit(this);
        return r9;
    L28:
        th = move-exception;
        throw th;
    }
}
