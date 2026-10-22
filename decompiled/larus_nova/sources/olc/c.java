package olc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f524200a;

    public c(b r100) {
        this.f524200a = r100;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        b r101 = this.f524200a;
        ReentrantLock r102 = r101.f524196b;
        r102.lock();
        Iterator<Bitmap> r103 = r101.f524195a.descendingIterator();     // Catch: Throwable -> L11
        if (r103.hasNext() == true) goto L7;
        r103 = null;
    L7:
        if (r103 == null) goto L9;
        r103.next().recycle();     // Catch: Throwable -> L11
        r103.remove();     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        r102.unlock();
        this.f524200a.b();
        return true;
    L11:
        th = move-exception;
        r102.unlock();
        throw th;
    }
}
