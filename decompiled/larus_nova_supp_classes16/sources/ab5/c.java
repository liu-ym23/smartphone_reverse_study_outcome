package ab5;

import android.content.DialogInterface;
import bb5.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        g r5 = this.a.i;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("photoCompressClose");
        r5 = null;
    L5:
        r5.close();
        Iterator r6 = ((ConcurrentHashMap) this.a.c).entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry r7 = (Map.Entry) r6.next();
        long r0 = ((Number) r7.getKey()).longValue();
        ((Number) r7.getValue()).longValue();
        int r8 = com.ss.android.lark.videosend.compress.d.d;
        com.ss.android.lark.videosend.compress.d.b.a.b(r0);
        goto L7
    L9:
        tt5.a.h(this.a.h, "cancel compress");
    }
}
