package nx3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.bytedance.applog.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<com.bytedance.applog.h> f521041a;

    public a() {
        this.f521041a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.h
    public final void a(boolean r100, JSONObject r101) {
        Iterator<com.bytedance.applog.h> r102 = this.f521041a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r100, r101);
        goto L4
    }

    @Override // com.bytedance.applog.h
    public final void onIdLoaded(String r100, String r101, String r102) {
        Iterator<com.bytedance.applog.h> r103 = this.f521041a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onIdLoaded(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.applog.h
    public final void onRemoteIdGet(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        Iterator<com.bytedance.applog.h> r100 = this.f521041a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onRemoteIdGet(r110, r111, r112, r113, r114, r115, r116);
        goto L4
    }
}
