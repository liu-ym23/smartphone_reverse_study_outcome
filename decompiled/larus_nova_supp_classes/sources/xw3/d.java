package xw3;

import com.bytedance.applog.p;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d implements p {
    public final CopyOnWriteArraySet<p> a;

    public d() {
        this.a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.p
    public final void onSessionStart(long r3, String r5) {
        Iterator<p> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onSessionStart(r3, r5);
        goto L4
    }

    @Override // com.bytedance.applog.p
    public final void a(long r3, String r5, JSONObject r6) {
        Iterator<p> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3, r5, r6);
        goto L4
    }

    @Override // com.bytedance.applog.p
    public final void b(long r3, String r5, JSONObject r6) {
        Iterator<p> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b(r3, r5, r6);
        goto L4
    }
}
