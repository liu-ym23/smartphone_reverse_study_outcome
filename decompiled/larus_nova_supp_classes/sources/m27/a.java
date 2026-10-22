package m27;

import com.bytedance.mira.event.PluginEventListener;
import java.util.HashMap;
import n27.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements PluginEventListener {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.mira.event.PluginEventListener
    public final void onPluginEvent(int r15, String r16, int r17, long r18, Throwable r20, long r21) {
        if (r15 < 22000) goto L10;
        if (r15 >= 22999) goto L10;
        if ((r20 instanceof Exception) == false) goto L10;
        HashMap r0 = (HashMap) this.a.c;
        r0.put(r16, (Exception) r20);
    L10:
        d.a().getClass();
        d.c.a(r15, r16, r17, r18, -1, r20, r21, -1, null, null);
    }
}
