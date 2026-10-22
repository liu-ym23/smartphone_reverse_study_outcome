package xw3;

import com.bytedance.applog.p;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<p> f565226a;

    public d() {
        this.f565226a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.p
    public final void onSessionStart(long r100, String r101) {
        Iterator<p> r102 = this.f565226a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onSessionStart(r100, r101);
        goto L4
    }

    @Override // com.bytedance.applog.p
    public final void a(long r100, String r101, JSONObject r102) {
        Iterator<p> r103 = this.f565226a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().a(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.applog.p
    public final void b(long r100, String r101, JSONObject r102) {
        Iterator<p> r103 = this.f565226a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().b(r100, r101, r102);
        goto L4
    }
}
