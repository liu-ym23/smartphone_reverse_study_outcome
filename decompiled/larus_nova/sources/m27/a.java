package m27;

import com.bytedance.mira.event.PluginEventListener;
import java.util.HashMap;
import n27.d;

/* JADX INFO: loaded from: classes.dex */
public final class a implements PluginEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f511671a;

    public a(c r100) {
        this.f511671a = r100;
    }

    @Override // com.bytedance.mira.event.PluginEventListener
    public final void onPluginEvent(int r110, String r111, int r112, long r113, Throwable r210, long r211) {
        if (r110 < 22000) goto L10;
        if (r110 >= 22999) goto L10;
        if ((r210 instanceof Exception) == false) goto L10;
        HashMap r100 = (HashMap) this.f511671a.f511676c;
        r100.put(r111, (Exception) r210);
    L10:
        d.a().getClass();
        d.f516747c.a(r110, r111, r112, r113, -1, r210, r211, -1, null, null);
    }
}
