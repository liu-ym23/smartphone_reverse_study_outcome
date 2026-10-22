package oka;

import android.text.TextUtils;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends ZeusPluginStateListener {
    public a() {
    }

    @Override // com.volcengine.zeus.ZeusPluginStateListener
    public final void onPluginStateChange(String r100, int r101, Object... r102) {
        if (TextUtils.equals(r100, "com.obric.memorydata.plugin") == true) goto L6;
        return;
    L6:
        if (r101 == 9) goto L8;
        return;
    L8:
        List<Runnable> r103 = b.f523742a;
        ArrayList r104 = (ArrayList) r103;
        if (r104.isEmpty() == true) goto L19;
        ArrayList r105 = new ArrayList(r103);
        r104.clear();
        Iterator r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L19;
        ((Runnable) r106.next()).run();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    L19:
        Zeus.unregisterPluginStateListener(this);
    }
}
