package g97;

import android.database.ContentObserver;
import android.net.Uri;
import com.bytedance.reparo.core.o;
import com.bytedance.reparo.e;
import com.bytedance.reparo.secondary.Logger;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends ContentObserver {
    public a() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
    L7:
        th = move-exception;
        Logger.b("PatchChangeObserver", "PatchChangeObserver -> onChanged failed:", th);
        return;
    L3:
        if (e.b().f267431e == true) goto L12;
        o r102 = o.c();     // Catch: Throwable -> L7
        r102.a();     // Catch: Throwable -> L7
        r102.f267414d.f(true);     // Catch: Throwable -> L7
        return;
    }
}
