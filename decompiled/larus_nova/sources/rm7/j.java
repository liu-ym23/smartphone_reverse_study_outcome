package rm7;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f538605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f538606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f538607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f538608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<mm7.b> f538609e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f538610a = null;

        static {
            f538610a = new j();
        }
    }

    public j() {
        this.f538609e = new CopyOnWriteArrayList();
    }

    public final void a(boolean r100, JSONObject r101) {
        um7.e.b("handleSettingsStatusCallback() on call; isEnable = " + r100 + ", extra = " + r101);
        Iterator<mm7.b> r102 = this.f538609e.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        mm7.b r103 = r102.next();
        if (r103 == null) goto L4;
        um7.e.b("handleSettingsStatusCallback() isEnable = " + r100 + ", extra = " + r101.toString());
        r103.a(r100);
        goto L4
    }
}
