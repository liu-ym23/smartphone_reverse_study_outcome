package o57;

import android.os.Handler;
import android.os.Message;
import com.bytedance.platform.godzilla.anr.sp.LinkedListProxyForWorks;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Handler.Callback {
    public b() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what == 1) goto L19;
    L18:
        return true;
    L19:
    L16:
        e = move-exception;
        e.toString();
        goto L18
    L5:
        if (c.f522102a == null) goto L18;
        LinkedListProxyForWorks r101 = c.f522103b;     // Catch: ConcurrentModificationException -> L16
        if (r101 == null) goto L18;
        LinkedList r102 = (LinkedList) r101.clone();     // Catch: ConcurrentModificationException -> L16
        c.f522103b.clear();     // Catch: ConcurrentModificationException -> L16
        c.f522102a.removeMessages(1);     // Catch: ConcurrentModificationException -> L16
        if (r102.size() <= 0) goto L18;
        Iterator r103 = r102.iterator();     // Catch: ConcurrentModificationException -> L16
    L13:
        if (r103.hasNext() == false) goto L18;
        ((Runnable) r103.next()).run();     // Catch: ConcurrentModificationException -> L16
        goto L13
    }
}
